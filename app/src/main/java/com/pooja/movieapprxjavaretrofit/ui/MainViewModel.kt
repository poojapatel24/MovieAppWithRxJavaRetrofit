package com.pooja.movieapprxjavaretrofit.ui

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.pooja.movieapprxjavaretrofit.Movie
import com.pooja.movieapprxjavaretrofit.data.network.model.MovieList
import com.pooja.movieapprxjavaretrofit.data.repository.MainRepository
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.core.Observer
import io.reactivex.rxjava3.disposables.Disposable
import io.reactivex.rxjava3.schedulers.Schedulers


class MainViewModel(private val repository: MainRepository) : ViewModel() {

    val movieList = MutableLiveData<List<Movie>>()
    val errorMessage = MutableLiveData<String>()
    lateinit var disposable: Disposable

    fun getAllMovies() {

        // observer subscribing to observable
        val response = repository.getAllMovies()
        response.subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(getMoviesListObserver())
    }

    private fun getMoviesListObserver(): Observer<MovieList> {
        return object : Observer<MovieList> {
            override fun onComplete() {
                //hide progress indicator .
            }

            override fun onError(e: Throwable) {
                movieList.postValue(null)

            }

            override fun onNext(t: MovieList) {
                movieList.postValue(t.mList)
            }

            override fun onSubscribe(d: Disposable) {
                disposable = d
                //start showing progress indicator.
            }
        }
    }
}