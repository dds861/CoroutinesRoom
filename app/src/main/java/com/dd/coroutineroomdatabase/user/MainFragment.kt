package com.dd.coroutineroomdatabase.user


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import com.dd.coroutineroomdatabase.R
import org.kodein.di.Kodein
import org.kodein.di.KodeinAware
import org.kodein.di.android.support.closestKodein

/**
 * A simple [Fragment] subclass.
 */
class MainFragment : Fragment(), KodeinAware {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_main, container, false)
    }

    override val kodein: Kodein by closestKodein()


//    private fun initViewModel() {
////        val userDatabase = UserDatabase.getInstance(application)
////        val dao = userDatabase.userDAO
////        val repository = UserRepository(dao)
////        val viewModelFactory = UserViewModelFactory(repository)
//
//        userViewModel = ViewModelProvider(this, userViewModelFactory).get(UserViewModel::class.java)
//    }
//
//    private fun init() {
//        btn_add.setOnClickListener {
//            val user = User(0, tv_name.text.toString(), tv_hobby.text.toString())
//            userViewModel.insert(user)
//        }
//
//        btn_clear.setOnClickListener {
//            userViewModel.clearAll()
//        }
//    }
//
//    private fun showUsersList() {
//        userViewModel.users.observe(this, Observer {
//            setDataToRecyclerView(it)
//        })
//    }
//
//    private fun setDataToRecyclerView(userList: List<User>) {
//        recyclerViewMain.apply {
//            layoutManager = LinearLayoutManager(this@MainActivity)
//            adapter = AdapterUser(userList)
//        }
//    }
}
