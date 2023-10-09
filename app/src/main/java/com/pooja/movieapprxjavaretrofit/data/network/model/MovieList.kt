package com.pooja.movieapprxjavaretrofit.data.network.model

import com.pooja.movieapprxjavaretrofit.Movie
import com.google.gson.annotations.SerializedName

data class MovieList(@SerializedName("Search") val mList: List<Movie>)
