package com.example.hmw3

import android.app.Application
import android.content.Context
import android.os.Bundle
import android.util.AttributeSet
import android.view.View
import android.widget.Toast
import com.google.android.material.bottomnavigation.BottomNavigationView
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import androidx.recyclerview.widget.RecyclerView
import com.example.hmw3.databinding.ActivityMainBinding
import com.example.hmw3.ui.App
import com.example.hmw3.ui.ImageAdapter
import com.example.hmw3.ui.model.PixabayModel
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {
    var page = 1
    var imageAdapter=ImageAdapter(arrayListOf())
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

onScroll()
    }

    override fun onCreateView(name: String, context: Context, attrs: AttributeSet): View? {
        return super.onCreateView(name, context, attrs)
    }

        fun onScroll() {
            binding.btnChanched.setOnClickListener {
                doRequest(page)
            }
            binding.recycle.addOnScrollListener(object: RecyclerView.OnScrollListener(){
                override fun onScrollStateChanged(recyclerView: RecyclerView, newState: Int) {
                    super.onScrollStateChanged(recyclerView, newState)
                    if(!recyclerView.canScrollVertically(1)){
                        doRequest(++page)
                        Toast.makeText(applicationContext, "Scrollte vniz", Toast.LENGTH_SHORT).show()
                    }

                }
            })
            binding.btnTwo.setOnClickListener{
                doRequest(++page)
                Toast.makeText(applicationContext, "Budet novii kart", Toast.LENGTH_SHORT).show()
            }

        }


        private fun doRequest(page: Int) {
App.api.getImagesByWord(keyWord=binding.editActivity.text.toString(), page=page).enqueue(object :Callback<PixabayModel> {
    override fun onResponse(call: Call<PixabayModel>, response: Response<PixabayModel>) {

        response.body()?.hits.let {
            imageAdapter = ImageAdapter(it!!)
            binding.recycle.adapter = imageAdapter
        }
    }

    override fun onFailure(call: Call<PixabayModel>, t: Throwable) {

    }
})
        }

    }



