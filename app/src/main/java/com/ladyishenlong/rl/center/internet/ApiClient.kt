package com.ladyishenlong.rl.center.internet

object ApiClient {

    var apiService: ApiService? = null

    fun getApi(): ApiService? {

        if (apiService == null) {
            apiService = Internet.retrofit
                    .create(ApiService::class.java)
        }

        return apiService
    }

}