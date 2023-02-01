package uz.smartmuslim.adminpanel.data.remote.mapper

import com.google.firebase.firestore.DocumentSnapshot
import uz.smartmuslim.adminpanel.data.model.Admin

object Mapper {

    fun DocumentSnapshot.toAdmin() = Admin(
        username = this["username"].toString(),
        password = this["password"].toString()
    )

}