package com.example.tasks.service.listener

class ValidationListener(str: String = "") {

    private var status: Boolean = true
    private var mMessage: String = ""

    init {
        if(str != ""){
            status = false
            mMessage = str
        }
    }

    fun success() = status
    fun failure() = mMessage
}