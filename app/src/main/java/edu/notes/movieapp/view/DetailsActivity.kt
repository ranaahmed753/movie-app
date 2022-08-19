package edu.notes.movieapp.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.WindowManager
import android.widget.ImageView
import android.widget.RatingBar
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.coordinatorlayout.widget.CoordinatorLayout
import com.bumptech.glide.Glide
import edu.notes.movieapp.R
import edu.notes.movieapp.utilities.AnimationController
import edu.notes.movieapp.utilities.Constants
import edu.notes.movieapp.utilities.Navigation

class DetailsActivity : AppCompatActivity() {

    private lateinit var coordinatorLayout : CoordinatorLayout
    private lateinit var movieImage : ImageView
    private lateinit var movieName : TextView
    private lateinit var movieOverView : TextView

    private lateinit var ratingBar : RatingBar
    private lateinit var ratingCount : TextView

    private lateinit var movieId : TextView
    private lateinit var movieReleaseDate : TextView
    private lateinit var popularityCount : TextView
    private lateinit var voteCount : TextView

    private lateinit var backButton : ConstraintLayout

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        getWindow().setFlags(
            WindowManager.LayoutParams.FLAG_FULLSCREEN,
            WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_details)


        movieImage = findViewById(R.id.movieImage)
        movieName = findViewById(R.id.movieName)
        movieOverView = findViewById(R.id.movieOverView)
        ratingBar = findViewById(R.id.ratingBar)
        ratingCount = findViewById(R.id.ratingCount)
        movieId = findViewById(R.id.movieId)
        movieReleaseDate = findViewById(R.id.releaseDate)
        backButton = findViewById(R.id.backButton)
        popularityCount = findViewById(R.id.popularityCount)
        voteCount = findViewById(R.id.voteCount)
        coordinatorLayout = findViewById(R.id.coordinatorLayout)


        val Id = intent.getStringExtra("id")
        val title = intent.getStringExtra("title")
        val image = intent.getStringExtra("image")
        val overview = intent.getStringExtra("overview")
        val popularity = intent.getStringExtra("popularity")
        val release_date = intent.getStringExtra("release_date")
        val vote_count = intent.getStringExtra("vote_count")
        val vote_average = intent.getStringExtra("vote_average")

        movieName.text = title
        Glide.with(this).load(Constants.imageBase+image).into(movieImage)
        movieOverView.text = overview

        ratingCount.text = vote_average+"/10"
        ratingBar.rating = vote_average!!.toFloat()/2

        movieId.text = Id
        movieReleaseDate.text = release_date

        popularityCount.text = popularity
        voteCount.text = vote_count

        backButton.setOnClickListener {
        AnimationController.fadeInAnimation(backButton,this@DetailsActivity)
            Navigation.navigate(this@DetailsActivity,MainActivity())
        }
    }

    override fun onStart() {
        super.onStart()
        AnimationController.fadeInAnimation(coordinatorLayout,this@DetailsActivity)
    }



}