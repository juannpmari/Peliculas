package repository

import data.model.MovieList
import data.remote.MovieDataSource

//Acá se hace la implementación de los métodos definidos en la interfaz

class MovieRepositoryImpl(private val dataSource: MovieDataSource) : MovieRepository {
    override suspend fun getUpcomingMovies(): MovieList = dataSource.getUpcomingMovies()
    //Al implementar un método de una interfaz, sí o sí hay que hacer override
    override suspend fun getTopRatedMovies(): MovieList = dataSource.getTopRatedMovies()

    override suspend fun getPopularMovies(): MovieList = dataSource.getPopularMovies()

}