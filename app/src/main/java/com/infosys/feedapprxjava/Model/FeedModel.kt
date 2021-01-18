package com.infosys.feedapprxjava.Model

import com.google.gson.annotations.SerializedName

data class FeedModel (

    @SerializedName("title") var title : String,
    @SerializedName("rows") var rows : ArrayList<Rows>

)