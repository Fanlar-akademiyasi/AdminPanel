package uz.smartmuslim.adminpanel.data.remote.response

import androidx.room.ColumnInfo
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName
import uz.smartmuslim.adminpanel.data.local.room.entity.UserEntity
import java.time.LocalDate
import java.util.*

data class UserResponse(
    val id: UUID,
    @SerializedName("full_name")
    val fullName: String,
    @SerializedName("phone_number")
    val phoneNumber: String,
    @SerializedName("passport_sn")
    val passportSN: String,
    val address: String,
    @SerializedName("birth_date")
    val birthDate: String,
    @SerializedName("create_date")
    val createDate: Long,
    @SerializedName("last_modified_date")
    val lastModifiedDate: Long
) {
    fun toEntity() = UserEntity(
        id,
        fullName,
        phoneNumber,
        passportSN,
        address,
        birthDate,
        createDate,
        lastModifiedDate
    )
}