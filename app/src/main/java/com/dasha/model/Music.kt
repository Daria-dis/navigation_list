package com.dasha.model

import java.io.Serializable


class Music (private val name: String,
             private val subjectiveScore: Double ) : Serializable{

    private var description : String = "I assess $name as $subjectiveScore/10"

    public fun getDescription():String {
        return description
    }

    public fun getName():String {
        return name
    }
}