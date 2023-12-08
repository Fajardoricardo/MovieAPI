package com.pokemon.adso2499719

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.pokemon.adso2499719.models.resuls
import kotlin.concurrent.thread

class MainActivity : AppCompatActivity() {
    var movies : resuls? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var rv = findViewById<RecyclerView>(R.id.rvMovie)

        rv.layoutManager = LinearLayoutManager(
            this,
            LinearLayoutManager.VERTICAL,
            false)

        var adapterMovie = AdapterMovie(emptyList(), this)
        rv.adapter = adapterMovie
        val service = MovieServiceFactory.makeMovieService()

        thread {
            movies = service.listPopularMovie("4bed62a818bc7868ccddaefebed4b7a2", "US").execute().body()
            runOnUiThread{
                if (movies != null){
                    adapterMovie.items = movies!!.results
                    adapterMovie.notifyDataSetChanged()
                }
            }
        }
    }
}