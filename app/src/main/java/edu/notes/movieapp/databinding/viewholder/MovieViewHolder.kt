package edu.notes.movieapp.databinding.viewholder

import android.content.Context
import android.view.View
import android.widget.ImageView
import android.widget.RatingBar
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import edu.notes.movieapp.R
import edu.notes.movieapp.datamodel.Results
import edu.notes.movieapp.utilities.AnimationController
import edu.notes.movieapp.utilities.Constants

class MovieViewHolder(itemView : View) : RecyclerView.ViewHolder(itemView) {
    var movieName : TextView? = null
    var movieImage : ImageView? = null
    var constraintLayout : ConstraintLayout? = null
    var ratingBar : RatingBar? = null

    init {
        movieName = itemView.findViewById(R.id.movieName)
        movieImage = itemView.findViewById(R.id.movieImage)
        constraintLayout = itemView.findViewById(R.id.constraintLayout)
        ratingBar = itemView.findViewById(R.id.ratingBar)


    }

    fun bindView(result: Results, context : Context, holder : MovieViewHolder){
        movieName?.text = result.title
        ratingBar?.rating = result.vote_average.toFloat()/2
        Glide.with(context).load(Constants.imageBase + result.poster_path).into(holder.movieImage!!)
    }

    fun onClick(widget : ConstraintLayout, context: Context, onDoSomething : (position : Int, holder : MovieViewHolder) -> Unit, position: Int, holder: MovieViewHolder){
        widget.setOnClickListener {
            AnimationController.fadeInAnimation(widget,context)
            onDoSomething(position,holder)

        }
    }

    interface onItemClick{
        fun onNavigateToMovieDetailsPage(position: Int, holder: MovieViewHolder)
    }


}