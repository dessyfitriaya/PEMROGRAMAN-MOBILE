package com.example.biffcinema

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class FilmAdapter(private val filmList: ArrayList<Film>, val listener: MyClickListener): RecyclerView.Adapter<FilmAdapter.FilmViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FilmViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.film_item,parent,false)
        return FilmViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: FilmViewHolder, position: Int) {
        val currentItem = filmList[position]
        holder.pictureFilm.setImageResource(currentItem.picture)
        holder.titleFilm.text = currentItem.title
        holder.directorFilm.text = currentItem.director
    }

    override fun getItemCount(): Int {
        return filmList.size
    }

    inner class FilmViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
        val pictureFilm: ImageView = itemView.findViewById(R.id.iv_img)
        val titleFilm: TextView = itemView.findViewById(R.id.tv_title)
        val directorFilm: TextView = itemView.findViewById(R.id.tv_director)

        init {
            itemView.setOnClickListener {
                val position = adapterPosition
                listener.onClick(position)
            }
        }
    }

    interface MyClickListener {
        fun onClick(position: Int)
    }
}