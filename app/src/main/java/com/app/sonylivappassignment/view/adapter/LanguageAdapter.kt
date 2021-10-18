package com.app.sonylivappassignment.view.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.recyclerview.widget.RecyclerView
import com.app.sonylivappassignment.R
import com.app.sonylivappassignment.service.model.Language
import com.app.sonylivappassignment.utility.ButtonClickListener
import com.app.sonylivappassignment.utility.LocaleHelper
import java.util.*
import kotlin.collections.HashMap

class LanguageAdapter(context: Context, var list: HashMap<String, List<Language>>?) :
    RecyclerView.Adapter<LanguageAdapter.LanguageViewHolder>() {


    private lateinit var callBack: ButtonClickListener

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): LanguageViewHolder {
        return LanguageViewHolder(
            LayoutInflater.from(parent.context).inflate(
                R.layout.item_language,
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: LanguageViewHolder, position: Int) {
        val item = list?.keys?.elementAt(position)
        holder.btnLang.setText(LocaleHelper.getUsLocaleName(item))
        holder.btnLang.setOnClickListener({
            if (callBack != null) {
                callBack.onButtonClick(list?.keys?.elementAt(position))
            }
        })
    }

    override fun getItemCount(): Int {
        return list?.keys?.size!!
    }

    class LanguageViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val btnLang: Button = itemView.findViewById(R.id.btn_lang)
    }


    fun setClickCallBack(listener: ButtonClickListener) {
        this.callBack = listener
    }
}