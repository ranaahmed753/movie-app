package edu.notes.movieapp.databinding.adapter

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.DiffUtil
import edu.notes.movieapp.view.DetailsActivity
import edu.notes.movieapp.R
import edu.notes.movieapp.databinding.viewholder.MovieViewHolder
import edu.notes.movieapp.datamodel.Results
import edu.notes.movieapp.utilities.AnimationController
import edu.notes.movieapp.view.MainActivity

class MoviePagingAdapter(var context : Context) : PagingDataAdapter<Results,MovieViewHolder>(Diff_Util),MovieViewHolder.onItemClick {

    companion object{
        val Diff_Util = object : DiffUtil.ItemCallback<Results>(){
            override fun areItemsTheSame(oldItem: Results, newItem: Results): Boolean {
                return oldItem.id == newItem.id
            }

            override fun areContentsTheSame(oldItem: Results, newItem: Results): Boolean {
                return oldItem.id == newItem.id
            }

        }
    }

    override fun onBindViewHolder(holder: MovieViewHolder, position: Int) {
        val currentItem = getItem(position)

        AnimationController.fadeInAnimation(holder.constraintLayout!!,context)

        holder.bindView(currentItem!!,context,holder)

        holder.onClick(holder.constraintLayout!!,context,::onNavigateToMovieDetailsPage,position,holder)

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.child_item,parent,false)
        return MovieViewHolder(view)
    }

    override fun onNavigateToMovieDetailsPage(position: Int, holder: MovieViewHolder) {
        val currentItem = getItem(position)
        val intent = Intent(context, DetailsActivity::class.java)
        intent.putExtra("id",currentItem!!.id)
        intent.putExtra("title",currentItem!!.title)
        intent.putExtra("image",currentItem.poster_path)
        intent.putExtra("overview",currentItem.overview)
        intent.putExtra("popularity",currentItem.popularity)
        intent.putExtra("release_date",currentItem.release_date)
        intent.putExtra("vote_count",currentItem.vote_count)
        intent.putExtra("vote_average",currentItem.vote_average)
        context.startActivity(intent)
        (context as MainActivity).finish()
    }
}