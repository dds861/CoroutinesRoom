package  com.dd.coroutineroomdatabase.framework.db.dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.dd.coroutineroomdatabase.constants.ConstantsApp
import com.dd.coroutineroomdatabase.framework.db.entity.UserEntity

@Dao
interface UserDAO {

    @Insert
    suspend fun insert(user: UserEntity)

    @Query("DELETE FROM ${ConstantsApp.TABLE_NAME}")
    suspend fun deleteAll()

    @Query("SELECT * FROM ${ConstantsApp.TABLE_NAME}")
    fun getAllUsers(): LiveData<List<UserEntity>>
}