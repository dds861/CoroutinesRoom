package com.dd.coroutineroomdatabase.presentation.main


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.dd.core.domain.User

import com.dd.coroutineroomdatabase.R
import com.dd.coroutineroomdatabase.framework.db.entity.UserEntity
import com.dd.coroutineroomdatabase.presentation.UserViewModelFactory
import kotlinx.android.synthetic.main.fragment_main.*
import org.kodein.di.Kodein
import org.kodein.di.KodeinAware
import org.kodein.di.android.support.closestKodein
import org.kodein.di.generic.instance

/**
 * A simple [Fragment] subclass.
 */
class MainFragment : Fragment(), KodeinAware {
    override val kodein: Kodein by closestKodein()

    private lateinit var userViewModel: UserViewModel

    private val userViewModelFactory: UserViewModelFactory by instance()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_main, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
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
            val user = User(
                0,
                tv_name.text.toString(),
                tv_hobby.text.toString()
            )
            userViewModel.insert(user)
        }

        btn_clear.setOnClickListener {
            userViewModel.clearAll()
        }
    }

    private fun showUsersList() {
        userViewModel.users.observe(viewLifecycleOwner, Observer {
            setDataToRecyclerView(it)
        })


    }

    private fun setDataToRecyclerView(userList: List<User>) {
        recyclerViewMain.apply {
            layoutManager = LinearLayoutManager(requireContext())
            adapter =
                AdapterUser(
                    userList
                )
        }
    }
}
