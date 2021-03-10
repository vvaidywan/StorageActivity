package com.example.storageactivity

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.activity_room.*
import kotlinx.android.synthetic.main.item_view.*
import java.text.FieldPosition
import java.util.concurrent.Executors

class RoomActivity : AppCompatActivity(), MyCustomAdapter.OnItemClickListener {

    private var recyclerView : RecyclerView? =null
    private var adapter: MyCustomAdapter? = null
    //var employeeList: List<Employee>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_room)

        recyclerView = findViewById<RecyclerView>(R.id.recyclerView)
        adapter = MyCustomAdapter()
        adapter?.setListener(this)

        val layoutManager = LinearLayoutManager(applicationContext)
        recyclerView?.layoutManager = layoutManager
        recyclerView?.adapter = adapter
        val database: AppRoomDatabase = DatabaseBuilder.getInstance(context = this)

        rv_btnAdd.setOnClickListener(View.OnClickListener {
            Executors.newSingleThreadExecutor().execute {
                database.employeeDao().insertEmp(
                    Employee(
                        name = rv_et1.text.toString(),
                        address = rv_et2.text.toString(), phone = rv_et3.text.toString()
                    )
                )
                 var employeeList: List<Employee> = database.employeeDao().getAllEmp()
                runOnUiThread { adapter?.setTasks(employeeList) }
            }
        })
    }

    override fun onItemClickDelete(id: Int) {
        //Toast.makeText(this, "onItemClick" + position, Toast.LENGTH_SHORT).show()
        val database: AppRoomDatabase = DatabaseBuilder.getInstance(context = this)
        Executors.newSingleThreadExecutor().execute{
            database.employeeDao().deleteEmp(Employee(id = id))
            var employeeList: List<Employee> = database.employeeDao().getAllEmp()
            runOnUiThread { adapter?.deleteTasks(id, employeeList) }
        }
    }

   override fun onItemClickEdit(id: Int, position: Int) {
       val database: AppRoomDatabase = DatabaseBuilder.getInstance(context = this)
       Executors.newSingleThreadExecutor().execute {

           database.employeeDao().updateEmp(Employee(id = 52, name = "x", address = "", phone = "Varsha"))
           var employeeList: List<Employee> = database.employeeDao().getAllEmp()
           runOnUiThread { adapter?.updateTasks(position, employeeList) }
       }
   }
}

