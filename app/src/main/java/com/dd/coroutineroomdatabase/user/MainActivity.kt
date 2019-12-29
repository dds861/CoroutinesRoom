package com.dd.coroutineroomdatabase.user

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.dd.coroutineroomdatabase.R
import com.dd.coroutineroomdatabase.database.User
import com.dd.coroutineroomdatabase.database.UserDatabase
import com.dd.coroutineroomdatabase.database.UserRepository
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {
    private lateinit var userViewModel: UserViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initViewModel()
        showUsersList()
        init()
    }

    private fun initViewModel() {
        val dao = UserDatabase.getInstance(application).userDAO
        val repository = UserRepository(dao)
        val viewModelFactory =
            UserViewModelFactory(repository)
        userViewModel = ViewModelProvider(this, viewModelFactory).get(UserViewModel::class.java)
    }

    private fun init() {
        btn_add.setOnClickListener {
            val user = User(0, tv_name.text.toString(), tv_hobby.text.toString())
            userViewModel.insert(user)
        }

        btn_clear.setOnClickListener {
            userViewModel.clearAll()
        }
    }

    private fun showUsersList() {
        userViewModel.users.observe(this, Observer {
            setDataToRecyclerView(it)
        })
    }

    private fun setDataToRecyclerView(userList: List<User>) {
        recyclerViewMain.apply {
            layoutManager = LinearLayoutManager(this@MainActivity)
            adapter = AdapterUser(userList)
        }
    }
}
