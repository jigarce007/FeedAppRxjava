package com.infosys.feedapprxjava.Network

import com.infosys.feedapprxjava.Model.FeedModel
import com.infosys.feedapprxjava.ViewModel.FeedViewModel
import io.reactivex.Observable
import io.reactivex.Single
import okhttp3.Response
import retrofit2.http.GET

interface RetroService {

    @GET("s/2iodh4vg0eortkl/facts.json")
    fun getFeeds(): Observable<FeedModel>



}