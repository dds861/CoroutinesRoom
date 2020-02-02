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


class MainActivity : AppCompatActivity() {

//    private val parentKodein by closestKodein()
//
//    override val kodein: Kodein by Kodein.lazy {
//        extend(parentKodein)
//        import(injectionActivityModule())
//    }
//
//    private val userViewModelFactory:UserViewModelFactory by instance()
//
//    private lateinit var userViewModel: UserViewModel


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
//        initViewModel()
//        showUsersList()
//        init()
    }

}
