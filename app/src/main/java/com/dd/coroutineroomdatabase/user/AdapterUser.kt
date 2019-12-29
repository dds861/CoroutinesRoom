package com.dd.coroutineroomdatabase.user

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.dd.coroutineroomdatabase.R
import com.dd.coroutineroomdatabase.database.User

class AdapterUser(private val list: List<User>) : RecyclerView.Adapter<AdapterUser.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.content_item, null)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.hobby.text = list[position].userHobby
        holder.name.text = list[position].userName
    }

    override fun getItemCount(): Int {
        return list.size
    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var hobby: TextView = itemView.findViewById<View>(R.id.tv_hobby) as TextView
        var name: TextView = itemView.findViewById<View>(R.id.tv_name) as TextView
    }
}