package app.hanxk.demo.coroutinememorydemo.data

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [Address::class], version = 1, exportSchema = false)
abstract class MyDataBase : RoomDatabase() {

  abstract fun addressDao(): AddressDao


  companion object {
    private var INSTANCE: MyDataBase? = null

    fun initialize(context: Context) {
      if (INSTANCE == null) {
        synchronized(MyDataBase::class) {

          INSTANCE = Room.databaseBuilder(context.applicationContext,
              MyDataBase::class.java, "MyDataBase.db")
              .build()
        }
      }
    }

    fun getInstance(): MyDataBase {
      return INSTANCE!!
    }
  }

}