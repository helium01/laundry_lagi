package com.opencv.laundrylagi.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.opencv.laundrylagi.model.model_paket
import com.opencv.laundrylagi.R

class AdapterList(val data: List<model_paket>): RecyclerView.Adapter<AdapterList.ViewHolder>(){

    // code untuk membuat ViewHolder dan menampilkan data ke dalam ViewHolder

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
        val tvnama_paket=itemView.findViewById<TextView>(R.id.nama_list)
        val tvjenis_paket=itemView.findViewById<TextView>(R.id.jenis_list)
        val tvharga_paket=itemView.findViewById<TextView>(R.id.harga_list)
        val imgpaket=itemView.findViewById<ImageView>(R.id.foto_list)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view: View=LayoutInflater.from(parent.context).inflate(R.layout.item_list, parent, false)
        return ViewHolder(view)
    }


    override fun getItemCount(): Int {
        return data.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.tvnama_paket.text=data[position].nama_paket
        holder.tvjenis_paket.text=data[position].jenis_paket
        holder.tvharga_paket.text=data[position].harga_paket.toString()
        holder.imgpaket.setImageResource(data[position].image_paket)


    }
}

//class UserActivity : AppCompatActivity() {
//    private lateinit var userRecyclerView: RecyclerView
//    private lateinit var userAdapter: UserAdapter
//
//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//        setContentView(R.layout.activity_user)
//
//        userRecyclerView = findViewById(R.id.userRecyclerView)
//        userAdapter = UserAdapter(emptyList())
//        userRecyclerView.adapter = userAdapter
//        userRecyclerView.layoutManager = LinearLayoutManager(this)
//
//        // request API menggunakan Retrofit dan Coroutine
//        CoroutineScope(Dispatchers.IO).launch {
//            try {
//                val users = RetrofitClient.userService.getUsers()
//                withContext(Dispatchers.Main) {
//                    userAdapter = UserAdapter(users)
//                    userRecyclerView.adapter = userAdapter
//                }
//            } catch (e: Exception) {
//                Log.e("UserActivity", "Error: ${e.message}")
//            }
//        }
//    }
//}