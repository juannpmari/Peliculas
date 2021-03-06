package data.local

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import data.model.FavEntity
import data.model.MovieEntity

@Database(entities = [MovieEntity::class],version=1)
abstract class AppDatabase: RoomDatabase() {

    abstract fun movieDao():MovieDao
    //abstract fun favDao():FavDao

    companion object{
        private var INSTANCE: AppDatabase? = null

        fun getDatabase(context: Context): AppDatabase{
            INSTANCE=INSTANCE ?: Room.databaseBuilder(
                context.applicationContext,
                AppDatabase::class.java,
                "movie_table"
            ).build()
            return INSTANCE!! //El !! es para manejar la nulabilidad
        }
        fun destroyInstance(){
            INSTANCE=null
        }
    }
}