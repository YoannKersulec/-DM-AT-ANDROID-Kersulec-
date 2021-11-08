package com.example.myapplication

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.FrameLayout
import android.widget.TextView
import androidx.fragment.app.FragmentActivity
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication.models.User
import java.lang.Exception

class UsersAdapter(private val dataSet: List<User>, private val activity: FragmentActivity) :
    RecyclerView.Adapter<UsersAdapter.ViewHolder>() {

    /**
     * Provide a reference to the type of views that you are using
     * (custom ViewHolder).
     */
    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val name: TextView
        val username : TextView
        val id : TextView
        val layout : FrameLayout

        init {
            // Define click listener for the ViewHolder's View.
            name = view.findViewById(R.id.userViewName)
            username = view.findViewById(R.id.userViewUsername)
            id = view.findViewById(R.id.userViewId)
            layout = view.findViewById(R.id.user_view_layout)
        }
    }

    // Create new views (invoked by the layout manager)
    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): ViewHolder {
        // Create a new view, which defines the UI of the list item
        val view = LayoutInflater.from(viewGroup.context)
            .inflate(R.layout.base_field, viewGroup, false)

        return ViewHolder(view)
    }

    // Replace the contents of a view (invoked by the layout manager)
    override fun onBindViewHolder(viewHolder: ViewHolder, position: Int) {

        // Get element from your dataset at this position and replace the
        // contents of the view with that element
        viewHolder.name.text = dataSet[position].name
        viewHolder.username.text = dataSet[position].userName
        viewHolder.id.text = dataSet[position].id.toString()
        viewHolder.layout.setOnClickListener {
            try {
                val test = activity as MainActivity
                test.switch(dataSet[position].id.toString())
            } catch (e: Exception) {
                val oui = e.message
            }
        }



    }

    // Return the size of your dataset (invoked by the layout manager)
    override fun getItemCount() = dataSet.size



}
