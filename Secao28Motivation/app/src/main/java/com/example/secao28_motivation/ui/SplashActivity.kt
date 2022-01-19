package com.example.secao28_motivation.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import com.example.secao28_motivation.R
import com.example.secao28_motivation.infra.Constants
import com.example.secao28_motivation.infra.SecurityPreferences
import kotlinx.android.synthetic.main.activity_splash.*

class SplashActivity : AppCompatActivity(), View.OnClickListener {

    private lateinit var mSecurityPreferences: SecurityPreferences

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

        mSecurityPreferences = SecurityPreferences(this)

        if(supportActionBar != null)
            supportActionBar!!.hide()

        button_save.setOnClickListener(this)

        verifyName()
    }

    private fun verifyName() {
        val name = mSecurityPreferences.getString(Constants.KEY.PERSON_NAME)
        if (name != ""){
            startActivity(Intent(this, MainActivity::class.java))
        }
    }

    override fun onClick(view: View) {
        //vai verificar se o id é o do
        // item que se tem interesse
        val id = view.id
        if(id == R.id.button_save)
            handlesave()
    }

    private fun handlesave(){
        val name = input_nome.text.toString()

        if(name != ""){
            mSecurityPreferences.storeString(Constants.KEY.PERSON_NAME, name)
            startActivity(Intent(this, MainActivity::class.java))
        }else {
            Toast.makeText(this, "Informe um nome", Toast.LENGTH_LONG).show()
        }
    }
}