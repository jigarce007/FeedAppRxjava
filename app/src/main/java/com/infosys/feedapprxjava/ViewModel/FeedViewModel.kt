package com.infosys.feedapprxjava.ViewModel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import com.infosys.feedapprxjava.Model.FeedModel

import com.infosys.feedapprxjava.Network.RetroInstance
import com.infosys.feedapprxjava.Network.RetroService
import io.reactivex.Observer
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers


class FeedViewModel(val app:Application): AndroidViewModel(app) {
 var feedList : MutableLiveData<FeedModel>

    init {
        feedList = MutableLiveData()
        makeAPIcall()
    }

    fun getFeedListObserver():MutableLiveData<FeedModel>{
        return feedList
    }

   private fun makeAPIcall(){
        var retroInstance = RetroInstance.getRetroInstace(app.applicationContext).create(RetroService::class.java)
        retroInstance.getFeeds()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(getFeedListObserverRx())


    }

    fun getFeedListObserverRx():Observer<FeedModel>{
        return object : Observer<FeedModel>{
            override fun onComplete() {

                //will hide progress bar
            }

            override fun onSubscribe(d: Disposable?) {

            }

            override fun onNext(value: FeedModel?) {

                feedList.postValue(value)
            }

            override fun onError(e: Throwable?) {

                feedList.postValue(null)
            }

        }
    }
}
