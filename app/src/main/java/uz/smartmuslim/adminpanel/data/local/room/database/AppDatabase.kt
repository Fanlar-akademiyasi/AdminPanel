package uz.smartmuslim.adminpanel.data.local.room.database

import androidx.room.Database
import androidx.room.RoomDatabase
import uz.smartmuslim.adminpanel.data.local.room.dao.AppealDao
import uz.smartmuslim.adminpanel.data.local.room.dao.UserDao
import uz.smartmuslim.adminpanel.data.local.room.entity.AppealEntity
import uz.smartmuslim.adminpanel.data.local.room.entity.UserEntity

@Database(entities = [UserEntity::class, AppealEntity::class], version = 1)
abstract class AppDatabase : RoomDatabase() {

    abstract fun userDao(): UserDao

    abstract fun appealDao(): AppealDao
}