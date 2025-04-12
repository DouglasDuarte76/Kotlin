package com.example.acaiStore

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.acaiStore.network.AcaiApiService
import com.example.acaiStore.network.RetrofitClient
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Inicializando Retrofit
        val apiService = RetrofitClient.instance.create(AcaiApiService::class.java)

        // Fazendo a chamada à API
        apiService.getProducts().enqueue(object : Callback<List<AcaiProduct>> {
            override fun onResponse(
                call: Call<List<AcaiProduct>>,
                response: Response<List<AcaiProduct>>
            ) {
                if (response.isSuccessful) {
                    val products = response.body() ?: emptyList()
                    // Atualizar a UI com os produtos recebidos
                } else {
                    Toast.makeText(this@MainActivity, "Erro ao buscar produtos", Toast.LENGTH_SHORT).show()
                }
            }

            override fun onFailure(call: Call<List<AcaiProduct>>, t: Throwable) {
                Toast.makeText(this@MainActivity, "Falha na comunicação com a API", Toast.LENGTH_SHORT).show()
            }
        })
    }
}
