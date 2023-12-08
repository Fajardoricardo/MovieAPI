package com.pokemon.adso2499719

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.RemoteViews.RemoteCollectionItems
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.pokemon.adso2499719.models.Movie


class AdapterMovie(var items:List<Movie>, val context: Context)
    : RecyclerView.Adapter<AdapterMovie.ViewHolder>() {

    class ViewHolder (view: View): RecyclerView.ViewHolder(view){
    var lblTile = view.findViewById<TextView>(R.id.lbTitle)
        var imgMovie = view.findViewById<ImageView>(R.id.imgMovie)
        var dbDescripcion = view.findViewById<TextView>(R.id.dbDescripcion)

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AdapterMovie.ViewHolder {
        return  ViewHolder(LayoutInflater.from(context).inflate(R.layout.item_rv_fragment, parent, false))
    }

    override fun onBindViewHolder(holder: AdapterMovie.ViewHolder, position: Int) {
        holder.lblTile.text = items.get(position).title
        holder.dbDescripcion.text = items.get(position).overview

        val imgUrl = "https://image.tmbd.org/t/p/w500${items.get(position).poster_path}"
        Glide.with(holder.itemView)
            .load(imgUrl)
            .into(holder.imgMovie)
    }

    override fun getItemCount(): Int {
        return items.size
    }

}



