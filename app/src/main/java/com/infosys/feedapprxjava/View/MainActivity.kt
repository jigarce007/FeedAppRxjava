package com.infosys.feedapprxjava.View

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders

import androidx.recyclerview.widget.LinearLayoutManager

import com.infosys.feedapprxjava.Model.Rows
import com.infosys.feedapprxjava.R
import com.infosys.feedapprxjava.ViewModel.FeedViewModel

import kotlinx.android.synthetic.main.activity_main.*
import java.io.IOException
import java.nio.charset.Charset

class MainActivity : AppCompatActivity() {
    lateinit var feedViewModel: FeedViewModel


    lateinit var  feedAdapter : FeedListAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initRecyclerView()
        loadFeeds()



    }
    fun initRecyclerView(){
        feedAdapter = FeedListAdapter()
       rv_feed.adapter = feedAdapter
    }

    fun loadFeeds(){

        feedViewModel = ViewModelProviders.of(this).get(FeedViewModel::class.java)
        feedViewModel.getFeedListObserver().observe(this, Observer {
            if (it!=null) {

                    feedAdapter.feedList = it.rows
                feedAdapter.notifyDataSetChanged()
            }else{
                Toast.makeText(this,"Error in list",Toast.LENGTH_LONG).show()
            }
        })

    }
}