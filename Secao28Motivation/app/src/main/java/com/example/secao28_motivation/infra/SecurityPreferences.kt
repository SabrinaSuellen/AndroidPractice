package com.example.secao28_motivation.infra

import android.content.Context

class SecurityPreferences(context: Context) {
    val mSharedPreferences = context.getSharedPreferences("motivation", Context.MODE_PRIVATE)

    //fun storeString(key: S)

}