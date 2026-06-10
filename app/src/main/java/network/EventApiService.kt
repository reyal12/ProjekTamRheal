package network

import model.Event
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET

private const val BASE_URL = "https://gist.githubusercontent.com/reyal12/0501d07a1a3135c65f2ee2e5d7bc7dbd/raw/"

interface EventApiService {
    @GET("events.json")
    suspend fun getEvents(): List<Event>
}

object EventApi {
    val retrofitService: EventApiService by lazy {
        Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl(BASE_URL)
            .build()
            .create(EventApiService::class.java)
    }
}