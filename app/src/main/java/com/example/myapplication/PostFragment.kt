package com.example.myapplication

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication.models.Post
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class PostFragment : Fragment() {

    val user : Int = 1

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        retainInstance = true
    }

    override fun onCreateView(inflater: LayoutInflater,
                              container: ViewGroup?,
                              savedInstanceState: Bundle?): View? =
        inflater.inflate(R.layout.fragment_posts, container, false)

    // populate the views now that the layout has been inflated
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        // RecyclerView node initialized here
        executeCall()

    }

    companion object {
        fun newInstance(): PostFragment = PostFragment()
    }

   private fun executeCall() {
        val apiInterface = ApiService.create().getPostByUser(user)

        apiInterface.enqueue( object : Callback<List<Post>> {
            override fun onResponse(call: Call<List<Post>>, response: Response<List<Post>>) {
                val usersResponse = response.body()
                if (usersResponse.isNullOrEmpty()) {
                    return
                }
                val users = view!!.findViewById<RecyclerView>(R.id.list_post_view)
                users.apply {
                    // set a LinearLayoutManager to handle Android
                    // RecyclerView behavior
                    layoutManager = LinearLayoutManager(activity)
                    // set the custom adapter to the RecyclerView
                    adapter = PostsAdapter(usersResponse)
                }

            }
            override fun onFailure(call: Call<List<Post>>, t: Throwable) {
                val test = 1

            }
        })
    }
}