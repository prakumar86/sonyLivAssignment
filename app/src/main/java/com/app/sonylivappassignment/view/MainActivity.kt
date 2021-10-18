package com.app.sonylivappassignment.view

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.app.sonylivappassignment.R
import com.app.sonylivappassignment.service.model.Language
import com.app.sonylivappassignment.utility.ButtonClickListener
import com.app.sonylivappassignment.utility.LocaleHelper
import com.app.sonylivappassignment.view.adapter.LanguageAdapter
import com.app.sonylivappassignment.viewmodel.MainViewModel
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), ButtonClickListener {
    private var languageMap: HashMap<String, List<Language>>? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setUpViewModel()
    }

    private fun setUpViewModel() {
        val viewModel = ViewModelProvider(this).get(MainViewModel::class.java)
        viewModel.getLanguageData()
        viewModel.languages.observe(this, {
            configView(it)
        })
    }

    private fun configView(it: HashMap<String, List<Language>>?) {
        languageMap = it
        val languageAdapter = LanguageAdapter(this, it)
        rv_language.layoutManager = LinearLayoutManager(this)
        rv_language.adapter = languageAdapter
        languageAdapter.setClickCallBack(this)
    }

    override fun onButtonClick(key: String?) {
        if (languageMap != null) {
            val list = languageMap?.get(key!!)
            if (list != null) {
                for (obj in list) {
                    if (obj.key.equals(resources.getString(R.string.txt_hello_world))) {
                        setViewForHelloWorld(obj, key)
                    }
                }
            }
        }
    }

    private fun setViewForHelloWorld(obj: Language, key: String?) {
        tv_hello_world.setText(obj.value)
        LocaleHelper.setLocale(this, key)
    }
}