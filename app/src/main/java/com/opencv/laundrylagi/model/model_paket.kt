package com.opencv.laundrylagi.model

import retrofit2.http.GET
import java.io.Serializable

class model_paket : Serializable {
    var id: Int=0
    lateinit var nama_paket: String
    var harga_paket: Int=0
    lateinit var jenis_paket: String
    var image_paket: Int=0
}
interface PaketService {
    @GET("users")
    suspend fun getUsers(): List<model_paket>
}