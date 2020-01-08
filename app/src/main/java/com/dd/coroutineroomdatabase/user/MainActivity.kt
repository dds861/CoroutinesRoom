package com.dd.coroutineroomdatabase.user

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.dd.coroutineroomdatabase.R
import com.dd.coroutineroomdatabase.database.User
import com.dd.coroutineroomdatabase.inject.injectionActivityModule
import kotlinx.android.synthetic.main.activity_main.*
import org.kodein.di.Kodein
import org.kodein.di.KodeinAware
import org.kodein.di.android.closestKodein
import org.kodein.di.generic.instance


class MainActivity : AppCompatActivity(), KodeinAware {

    private val parentKodein by closestKodein()

    override val kodein: Kodein by Kodein.lazy {
        extend(parentKodein)
        import(injectionActivityModule())
    }

    private val userViewModelFactory:UserViewModelFactory by instance()

    private lateinit var userViewModel: UserViewModel


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initViewModel()
        showUsersList()
        init()
    }

    private fun initViewModel() {
//        val userDatabase = UserDatabase.getInstance(application)
//        val dao = userDatabase.userDAO
//        val repository = UserRepository(dao)
//        val viewModelFactory = UserViewModelFactory(repository)

        userViewModel = ViewModelProvider(this, userViewModelFactory).get(UserViewModel::class.java)
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
