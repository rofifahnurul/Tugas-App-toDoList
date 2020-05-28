package id.ac.unhas.todolist.database

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "toDoList")
data class ToDoList(
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id")
    val id: Int? = null,
    @ColumnInfo(name = "toDoList")
    var toDoList: String,
    @ColumnInfo(name = "note")
    var note: String,
    @ColumnInfo(name = "date")
    var date: String

)