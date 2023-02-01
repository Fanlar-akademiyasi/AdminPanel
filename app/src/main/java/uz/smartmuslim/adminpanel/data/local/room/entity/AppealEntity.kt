package uz.smartmuslim.adminpanel.data.local.room.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import uz.smartmuslim.adminpanel.data.model.AppealData
import uz.smartmuslim.adminpanel.data.model.Recipient
import java.util.UUID

@Entity(tableName = "appeal")
data class AppealEntity(
    @PrimaryKey
    val id: UUID,
    @ColumnInfo(name = "user_id")
    val useId: UUID,
    val content: String,
    val recipient: Recipient,
    @ColumnInfo(name = "create_date")
    val createDate: Long,
    @ColumnInfo(name = "is_complete")
    val isComplete: Boolean,
    @ColumnInfo(name = "last_modified_date")
    val lastModifiedDate: Long
) {
    fun toData() =
        AppealData(
            id,
            useId,
            content,
            recipient,
            createDate,
            isComplete,
            lastModifiedDate
        )
}