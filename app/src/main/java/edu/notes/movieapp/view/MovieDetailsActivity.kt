package edu.notes.movieapp.view

import android.media.TimedText
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.WindowManager
import android.widget.ImageView
import android.widget.RatingBar
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import com.bumptech.glide.Glide
import edu.notes.movieapp.R
import edu.notes.movieapp.utilities.AnimationController
import edu.notes.movieapp.utilities.Constants
import edu.notes.movieapp.utilities.Navigation
import java.lang.Thread.sleep

class MovieDetailsActivity : AppCompatActivity() {
    private lateinit var backButton : ConstraintLayout
    private lateinit var movieImage : ImageView
    private lateinit var movieName : TextView
    private lateinit var movieOverView : TextView
    private lateinit var moviePopularity : TextView
    private lateinit var movieReleaseDate : TextView
    private lateinit var movieVoteCount : TextView
    private lateinit var movieVoteAverage : TextView
    private lateinit var movieId : TextView
    private lateinit var constraintLayout: ConstraintLayout


    private lateinit var movieRatingbar : RatingBar

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        getWindow().setFlags(
            WindowManager.LayoutParams.FLAG_FULLSCREEN,
            WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_movie_details)

        backButton = findViewById(R.id.backButton)
        movieImage = findViewById(R.id.movieImage)
        movieName = findViewById(R.id.movieName)
        movieOverView = findViewById(R.id.movieOverView)
        moviePopularity = findViewById(R.id.popularityCount)
        movieReleaseDate = findViewById(R.id.releaseDate)
        movieVoteCount = findViewById(R.id.voteCount)
        movieVoteAverage = findViewById(R.id.ratingPoint)
        movieRatingbar = findViewById(R.id.ratingBar)
        movieId = findViewById(R.id.movieId)
        constraintLayout = findViewById(R.id.constraintLayout)

        backButton.setOnClickListener {
            AnimationController.fadeInAnimation(backButton,this@MovieDetailsActivity)
            Navigation.navigate(this,MainActivity())
        }

        val Id = intent.getStringExtra("id")
        val title = intent.getStringExtra("title")
        val image = intent.getStringExtra("image")
        val overview = intent.getStringExtra("overview")
        val popularity = intent.getStringExtra("popularity")
        val release_date = intent.getStringExtra("release_date")
        val vote_count = intent.getStringExtra("vote_count")
        val vote_average = intent.getStringExtra("vote_average")

        movieId.text = Id
        movieName.text = title
        Glide.with(this).load(Constants.imageBase+image).into(movieImage)
        movieOverView.text = overview
        moviePopularity.text = popularity
        movieReleaseDate.text = release_date
        movieVoteCount.text = vote_count
        movieVoteAverage.text = vote_average
        movieRatingbar.rating = vote_average!!.toFloat()/2
    }

    override fun onStart() {
        super.onStart()
        AnimationController.fadeInAnimation(constraintLayout,this@MovieDetailsActivity)
    }
}