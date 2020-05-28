package id.ac.unhas.todolist.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [ToDoList::class], exportSchema = false, version = 4)
abstract class TodoDatabase : RoomDatabase() {

    abstract fun toDoListDao(): ToDoListDao

    companion object {

        private const val DB_NAME = "ToDoList_DB"
        private var instance: TodoDatabase? = null

        fun getInstance(context: Context): TodoDatabase? {
            if (instance == null) {
                synchronized(TodoDatabase::class) {
                    instance = Room
                        .databaseBuilder(
                            context,
                            TodoDatabase::class.java,
                            DB_NAME
                        )
                        .fallbackToDestructiveMigration()
                        .build()
                }
            }
            return instance
        }

    }

}