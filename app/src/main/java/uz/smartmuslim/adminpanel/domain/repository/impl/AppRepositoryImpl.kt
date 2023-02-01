package uz.smartmuslim.adminpanel.domain.repository.impl

import com.google.firebase.firestore.FirebaseFirestore
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.channels.awaitClose
import kotlinx.coroutines.flow.*
import uz.smartmuslim.adminpanel.data.local.room.dao.AppealDao
import uz.smartmuslim.adminpanel.data.local.room.dao.UserDao
import uz.smartmuslim.adminpanel.data.local.shp.impl.MySharedPreference
import uz.smartmuslim.adminpanel.data.model.AppealData
import uz.smartmuslim.adminpanel.data.model.AuthData
import uz.smartmuslim.adminpanel.data.model.UserData
import uz.smartmuslim.adminpanel.data.remote.api.Api
import uz.smartmuslim.adminpanel.data.remote.mapper.Mapper.toAdmin
import uz.smartmuslim.adminpanel.data.remote.response.AppealResponse
import uz.smartmuslim.adminpanel.data.remote.response.UserResponse
import uz.smartmuslim.adminpanel.data.utils.MessageData
import uz.smartmuslim.adminpanel.data.utils.ResultData
import uz.smartmuslim.adminpanel.data.utils.hasConnection
import uz.smartmuslim.adminpanel.domain.repository.AppRepository
import java.io.IOException
import javax.inject.Inject

class AppRepositoryImpl @Inject constructor(
    private val appealDao: AppealDao,
    private val userDao: UserDao,
    private val api: Api,
    private val fireStore: FirebaseFirestore,
    private val shp: MySharedPreference
) : AppRepository {
    override fun getIsFirst(): Flow<Boolean> = flow {
        emit(shp.isFirst)
    }.flowOn(Dispatchers.IO)
    override suspend fun setIsFirst(state: Boolean) {
        shp.isFirst = state
    }

    override fun getAllUsers(): Flow<List<UserData>> = flow {
        userDao.getAllUsers().map { it ->
            val list = it.map {
                it.toData()
            }.toList()
            emit(list)
        }
    }

    override fun getAllAppeals(): Flow<List<AppealData>> = flow {
        appealDao.getAllAppeals().map { it ->
            val list = it.map {
                it.toData()
            }.toList()
            emit(list)
        }
    }

    override fun login(authData: AuthData): Flow<ResultData<Boolean>> =
        callbackFlow<ResultData<Boolean>> {

            fireStore.collection("admin").get()
                .addOnSuccessListener { it ->
                    val admins = it.documents
                        .map {
                            it.toAdmin()
                        }.toList()
                    val admin = admins[0]
                    if (authData.userName == admin.username
                        && authData.password == admin.password
                    ) {
                        trySend(ResultData.success(true))
                    }
                }.addOnFailureListener {
                    trySend(ResultData.error(it.fillInStackTrace()))
                }
            awaitClose {
            }
        }
            .catch { emit(ResultData.error(it)) }
            .flowOn(Dispatchers.IO)

    override fun getAllIsNotCompleteAppeals(): Flow<List<AppealData>> = flow {
        appealDao.getAllAppeals().map { it ->
            val list = it.map {
                it.toData()
            }.filter { !it.isComplete }.toList()
            emit(list)
        }
    }

    override fun getAllIsCompleteAppeals(): Flow<List<AppealData>> = flow {
        appealDao.getAllAppeals().map { it ->
            val list = it.map {
                it.toData()
            }.filter { it.isComplete }.toList()
            emit(list)
        }
    }

    override fun refreshUserData(): Flow<ResultData<Boolean>> = channelFlow {

        val response = api.getAllUsers()

        try {
            val data = response.body()

            when (response.code()) {
                in 200..299 -> {
                    val list = data?.map {
                        it.toEntity()
                    }?.toList()
                    if (list != null) {
                        userDao.insert(list)
                    }
                    send(ResultData.Success(true))
                }
                in 400..499 -> {
                    send(ResultData.Message(MessageData.messageText("Notog'ri so'rov")))
                }
                in 500..599 -> {
                    send(
                        ResultData.Message(
                            MessageData.messageText(
                                response.errorBody().toString()
                            )
                        )
                    )
                }
            }
        } catch (e: Exception) {
            send(ResultData.Error(e))
        }
    }

    override fun refreshAppealData(): Flow<ResultData<Boolean>> = channelFlow {

        val response = api.getAllAppeal()

        try {
            val data = response.body()

            when (response.code()) {
                in 200..299 -> {
                    val list = data?.map {
                        it.toEntity()
                    }?.toList()
                    if (list != null) {
                        appealDao.insert(list)
                    }
                    send(ResultData.Success(true))
                }
                in 400..499 -> {
                    send(ResultData.Message(MessageData.messageText("Notog'ri so'rov")))
                }
                in 500..599 -> {
                    send(
                        ResultData.Message(
                            MessageData.messageText(
                                response.errorBody().toString()
                            )
                        )
                    )
                }
            }
        } catch (e: Exception) {
            send(ResultData.Error(e))
        }
    }

}