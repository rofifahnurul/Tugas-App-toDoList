package id.ac.unhas.todolist.database

import androidx.lifecycle.LiveData
import androidx.room.*

@Dao
interface ToDoListDao {
    @Query("Select * from toDoList")
    fun getList(): LiveData<List<ToDoList>>

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insertList(toDoList: ToDoList)

    @Delete
    suspend fun deleteList(toDoList: ToDoList)

    @Update
    suspend fun updateList(toDoList: ToDoList)
}