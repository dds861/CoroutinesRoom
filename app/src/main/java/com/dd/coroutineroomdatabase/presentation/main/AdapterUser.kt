package com.dd.coroutineroomdatabase.presentation.main

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.dd.core.domain.User
import com.dd.coroutineroomdatabase.R
import com.dd.coroutineroomdatabase.framework.db.entity.UserEntity
import kotlinx.android.synthetic.main.content_item.view.*

class AdapterUser(private val list: List<User>) : RecyclerView.Adapter<AdapterUser.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.content_item, null)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.itemView.tv_hobby.text = list[position].userHobby
        holder.itemView.tv_name.text = list[position].userName
    }

    override fun getItemCount(): Int {
        return list.size
    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView)
}