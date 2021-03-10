package com.example.storageactivity

import android.content.Context
import android.view.LayoutInflater
import android.view.OrientationEventListener
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.Button
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.item_view.view.*
import java.util.concurrent.Executors

class MyCustomAdapter() : RecyclerView.Adapter<MyCustomAdapter.MyCustomViewHolder>() {

    var myArrayList: List<Employee>? = null
    var myListener: OnItemClickListener? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyCustomViewHolder {
        return MyCustomViewHolder(
            (LayoutInflater.from(parent.context).inflate(R.layout.item_view, parent, false))
        )
    }

    override fun onBindViewHolder(holder: MyCustomViewHolder, position: Int) {
        val currentItem = myArrayList?.get(position)
        holder.tv_name.text = currentItem?.name!!
        holder.tv_address.text = myArrayList?.get(position)?.address
        holder.tv_phone.text = myArrayList?.get(position)?.phone
                //holder.tv_address.text = currentItem.address!!
        //holder.tv_phone.text = currentItem.phone!!

        holder.btnDelete.setOnClickListener {
            myListener?.onItemClickDelete(currentItem.id)
        }

        holder.btnEdit.setOnClickListener {
            myListener?.onItemClickEdit(currentItem.id, position)
        }
    }

    override fun getItemCount(): Int {
        if (myArrayList == null) {
            return 0;
        } else {
            return myArrayList?.size!!
        }

    }

    class MyCustomViewHolder(item_view: View) :
        RecyclerView.ViewHolder(item_view)//, View.OnClickListener
    {
        val tv_name = item_view.findViewById<TextView>(R.id.tv_name)
        val tv_address = item_view.findViewById<TextView>(R.id.tv_address)
        val tv_phone = item_view.findViewById<TextView>(R.id.tv_phone)

        val btnEdit = item_view.findViewById<Button>(R.id.btnEdit)
        val btnDelete = item_view.findViewById<Button>(R.id.btnDelete)

    }

    fun setTasks(employeeList: List<Employee>) {
        myArrayList = employeeList
        notifyDataSetChanged()
    }

    fun deleteTasks(position: Int, employeeList: List<Employee>) {
        myArrayList = employeeList
        notifyDataSetChanged()
    }

    fun updateTasks(position : Int, employeeList: List<Employee>){
        myArrayList = employeeList
        notifyItemChanged(position)
        notifyDataSetChanged()
    }

    fun setListener(listener: OnItemClickListener) {
        myListener = listener
    }

    interface OnItemClickListener {
        fun onItemClickDelete(id: Int)
        fun onItemClickEdit(position : Int, id: Int)
    }
}