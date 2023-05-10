package com.opencv.laundrylagi.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager.widget.ViewPager
import com.opencv.laundrylagi.adapter.AdapterSlider
import com.opencv.laundrylagi.adapter.AdapterList
import com.opencv.laundrylagi.model.model_paket
import com.opencv.laundrylagi.R

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [HomeFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class HomeFragment : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null

    lateinit var vpSlider:ViewPager
    lateinit var rvList:RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view: View=inflater.inflate(R.layout.fragment_user_home, container, false)
        vpSlider=view.findViewById(R.id.vp_slider)
        rvList=view.findViewById(R.id._rvkategori)
        val arrSlider=ArrayList<Int>()
        arrSlider.add(R.drawable.bg1)
        arrSlider.add(R.drawable.bg2)
        arrSlider.add(R.drawable.bg3)

        val adapterSlider= AdapterSlider(arrSlider,activity)
        vpSlider.adapter=adapterSlider

        val LayoutManager= LinearLayoutManager(activity)
        LayoutManager.orientation=LinearLayoutManager.HORIZONTAL

        rvList.adapter= AdapterList(arrPaket)
        rvList.layoutManager=LayoutManager

        return view
    }
    val arrPaket:ArrayList<model_paket>get() {
        val arr=ArrayList<model_paket>()
        val p1= model_paket()
        p1.id=1
        p1.image_paket=R.drawable.bg3
        p1.harga_paket=100000
        p1.nama_paket="cuci kering"
        p1.jenis_paket="paket apalah"

        val p2= model_paket()
        p2.id=1
        p2.harga_paket=100000
        p1.image_paket=R.drawable.bg2
        p2.nama_paket="cuci kering"
        p2.jenis_paket="paket apalah"

        arr.add(p1)
        arr.add(p2)

        return arr
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment HomeFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            HomeFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}