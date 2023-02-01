package uz.smartmuslim.adminpanel.data.remote.response

import androidx.room.ColumnInfo
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName
import uz.smartmuslim.adminpanel.data.local.room.entity.AppealEntity
import uz.smartmuslim.adminpanel.data.model.Recipient
import java.util.*

data class AppealResponse(
    val id: UUID,
    @SerializedName("user_id")
    val useId: UUID,
    val content: String,
    val recipient: Recipient,
    @SerializedName("create_date")
    val createDate: Long,
    @SerializedName("is_complete")
    val isComplete: Boolean,
    @SerializedName("last_modified_date")
    val lastModifiedDate: Long
) {
    fun toEntity() =
        AppealEntity(id, useId, content, recipient, createDate, isComplete, lastModifiedDate)
}