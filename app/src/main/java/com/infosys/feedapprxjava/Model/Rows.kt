package com.infosys.feedapprxjava.Model

import com.google.gson.annotations.SerializedName

data class Rows (

    @SerializedName("title") var title : String,
    @SerializedName("description") var description : String,
    @SerializedName("imageHref") var imageHref : String

)