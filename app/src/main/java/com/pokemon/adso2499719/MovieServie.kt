package com.pokemon.adso2499719

import android.graphics.Region
import com.pokemon.adso2499719.models.resuls
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Query
import java.nio.channels.spi.AbstractSelectionKey

interface MovieServie {
    @GET("discover/movie?sort_by=popular.desc")
    fun listPopularMovie(
        @Query("api_key") apiKey: String,
        @Query("region") region: String,
    ) : Call<resuls>
}

object  MovieServiceFactory{
    fun makeMovieService(): MovieServie {
        return Retrofit.Builder()
            .baseUrl("https://api.themoviedb.org/3/")
            .addConverterFactory(GsonConverterFactory.create())
            .build().create(MovieServie::class.java)
    }
}