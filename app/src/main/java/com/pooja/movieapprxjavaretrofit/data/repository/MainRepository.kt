package com.pooja.movieapprxjavaretrofit.data.repository

import com.pooja.movieapprxjavaretrofit.data.network.RetrofitService

class MainRepository constructor(private val retrofitService: RetrofitService) {

    fun getAllMovies() = retrofitService.getAllMovies()
}