package uz.smartmuslim.adminpanel.data.model


import java.util.*

data class AppealData(
    val id: UUID,
    val useId: UUID,
    val content: String,
    val recipient: Recipient,
    val createDate: Long,
    val isComplete: Boolean,
    val lastModifiedDate: Long
)