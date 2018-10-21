package app.hanxk.demo.coroutinememorydemo.data

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import io.reactivex.Observable

@Dao
abstract class AddressDao {
  @Insert(onConflict = OnConflictStrategy.IGNORE)
  abstract fun insert(address: Address): Long

  @Query("SELECT COUNT(id) FROM address")
  abstract fun getTotalCount(): Int

}