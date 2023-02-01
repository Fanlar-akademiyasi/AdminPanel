package uz.smartmuslim.adminpanel.domain.repository

import kotlinx.coroutines.flow.Flow
import uz.smartmuslim.adminpanel.data.model.AppealData
import uz.smartmuslim.adminpanel.data.model.AuthData
import uz.smartmuslim.adminpanel.data.model.UserData
import uz.smartmuslim.adminpanel.data.remote.response.AppealResponse
import uz.smartmuslim.adminpanel.data.remote.response.UserResponse
import uz.smartmuslim.adminpanel.data.utils.ResultData

interface AppRepository {

    fun getIsFirst(): Flow<Boolean>

    suspend fun setIsFirst(state: Boolean)

    fun getAllUsers(): Flow<List<UserData>>

    fun getAllAppeals(): Flow<List<AppealData>>

    fun login(authData: AuthData): Flow<ResultData<Boolean>>

    fun getAllIsNotCompleteAppeals(): Flow<List<AppealData>>

    fun getAllIsCompleteAppeals(): Flow<List<AppealData>>

    fun refreshUserData(): Flow<ResultData<Boolean>>

    fun refreshAppealData(): Flow<ResultData<Boolean>>

}