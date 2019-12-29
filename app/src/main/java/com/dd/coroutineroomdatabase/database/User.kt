package  com.dd.coroutineroomdatabase.database

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.dd.coroutineroomdatabase.constants.ConstantsApp

@Entity(tableName = ConstantsApp.TABLE_NAME)
data class User(

    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = ConstantsApp.USER_ID)
    val userId: Int,

    @ColumnInfo(name = ConstantsApp.USER_NAME)
    var userName: String,

    @ColumnInfo(name = ConstantsApp.USER_HOBBY)
    var userHobby: String

)