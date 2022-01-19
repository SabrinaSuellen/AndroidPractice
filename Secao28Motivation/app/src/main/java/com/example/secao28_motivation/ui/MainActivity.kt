package com.example.secao28_motivation.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.example.secao28_motivation.R
import com.example.secao28_motivation.infra.Constants
import com.example.secao28_motivation.infra.SecurityPreferences
import com.example.secao28_motivation.repo.Mock
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), View.OnClickListener {

    private lateinit var mSecurityPreferences: SecurityPreferences
    private var mPhrase : Int = Constants.PHRASE.ALL

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        if (supportActionBar != null)
            supportActionBar!!.hide()

        mSecurityPreferences = SecurityPreferences(this)
        text_view_name.text = "Olá, " + mSecurityPreferences.getString(Constants.KEY.PERSON_NAME)


        //inicio frases
        image_view_all.setColorFilter(resources.getColor(R.color.colorAccent))
        handleNewPhrase()

        button_phrase.setOnClickListener(this)
        image_view_all.setOnClickListener(this)
        image_view_face.setOnClickListener(this)
        image_view_sun.setOnClickListener(this)

    }


    override fun onClick(view: View) {
        var id = view.id
        val listfilter = listOf(R.id.image_view_all, R.id.image_view_face, R.id.image_view_sun)

        if (id == R.id.button_phrase) {
            handleNewPhrase()
        } else if (id in listfilter) {
            handleFilter(id)
        }

    }

    private fun handleNewPhrase() {
        text_view_motiva.text = Mock().getPhrase(mPhrase)
    }

    private fun handleFilter(id: Int) {
        image_view_all.setColorFilter(resources.getColor(R.color.white))
        image_view_face.setColorFilter(resources.getColor(R.color.white))
        image_view_sun.setColorFilter(resources.getColor(R.color.white))

            when (id) {
                R.id.image_view_all -> {
                    image_view_all.setColorFilter(resources.getColor(R.color.colorAccent))
                    mPhrase = Constants.PHRASE.ALL
                }
                R.id.image_view_face -> {
                    image_view_face.setColorFilter(resources.getColor(R.color.colorAccent))
                    mPhrase = Constants.PHRASE.HAPPY
                }
                R.id.image_view_sun -> {
                    image_view_sun.setColorFilter(resources.getColor(R.color.colorAccent))
                    mPhrase = Constants.PHRASE.MORNING
                }
            }
    }
}

