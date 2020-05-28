package id.ac.unhas.todolist.database


import android.app.Application
import androidx.lifecycle.LiveData

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

class ToDoListRepository(application: Application) {

    private val toDoListDao: ToDoListDao?
    private var toDoList: LiveData<List<ToDoList>>? = null

    init {
        val db = TodoDatabase.getInstance(application.applicationContext)
        toDoListDao = db?.toDoListDao()
        toDoList = toDoListDao?.getList()
    }

    fun getList(): LiveData<List<ToDoList>>? {
        return toDoList
    }

    fun insert(toDoList: ToDoList) = runBlocking {
        this.launch(Dispatchers.IO) {
            toDoListDao?.insertList(toDoList)
        }
    }

    fun delete(toDoList: ToDoList) {
        runBlocking {
            this.launch(Dispatchers.IO) {
                toDoListDao?.deleteList(toDoList)
            }
        }
    }

    fun update(toDoList: ToDoList) = runBlocking {
        this.launch(Dispatchers.IO) {
            toDoListDao?.updateList(toDoList)
        }
    }

    fun deadlineDesc() : LiveData<List<ToDoList>>?{
        return toDoListDao?.deadlineDesc()
    }

    fun deadlineAsc() : LiveData<List<ToDoList>>?{
        return toDoListDao?.deadlineAsc()
    }

    fun dateDesc() : LiveData<List<ToDoList>>?{
        return toDoListDao?.dateDesc()
    }

    fun dateAsc() : LiveData<List<ToDoList>>?{
        return toDoListDao?.dateAsc()
    }

}