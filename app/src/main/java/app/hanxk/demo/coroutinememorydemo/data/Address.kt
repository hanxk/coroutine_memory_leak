package app.hanxk.demo.coroutinememorydemo.data

import androidx.room.Entity
import androidx.room.Index
import androidx.room.PrimaryKey

@Entity(tableName = "address")
data class Address( @PrimaryKey(autoGenerate = true) var id: Int = 0, var text: String = "")