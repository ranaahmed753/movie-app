package edu.notes.movieapp.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.WindowManager
import androidx.activity.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import dagger.hilt.android.AndroidEntryPoint
import edu.notes.movieapp.R
import edu.notes.movieapp.databinding.adapter.MoviePagingAdapter
import edu.notes.movieapp.viewmodel.MovieViewModel
import kotlinx.coroutines.flow.collectLatest
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private lateinit var recyclerview : RecyclerView
    private lateinit var moviePagingAdapter: MoviePagingAdapter

    private val movieViewModel : MovieViewModel by viewModels()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
            WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_main)

        recyclerview = findViewById(R.id.recyclerview)
        moviePagingAdapter = MoviePagingAdapter(this@MainActivity)
        recyclerview.setHasFixedSize(true)
        recyclerview.layoutManager = LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false)
        recyclerview.adapter = moviePagingAdapter

        lifecycleScope.launchWhenStarted {
            movieViewModel.listData.collectLatest { result ->
                moviePagingAdapter.submitData(result)
            }
        }



    }
}