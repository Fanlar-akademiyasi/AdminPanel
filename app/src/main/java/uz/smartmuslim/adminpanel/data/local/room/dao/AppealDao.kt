package uz.smartmuslim.adminpanel.data.local.room.dao

import androidx.room.Dao
import androidx.room.Query
import kotlinx.coroutines.flow.Flow
import uz.smartmuslim.adminpanel.data.local.room.entity.AppealEntity
import uz.smartmuslim.adminpanel.data.local.room.entity.UserEntity


@Dao
interface AppealDao : BaseDao<AppealEntity> {

    @Query("Select * From appeal")
    fun getAllAppeals(): Flow<List<AppealEntity>>
}