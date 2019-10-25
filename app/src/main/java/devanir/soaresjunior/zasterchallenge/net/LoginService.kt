package devanir.soaresjunior.zasterchallenge.net

import devanir.soaresjunior.zasterchallenge.data.LoginResponse
import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Path

interface LoginService {
    @GET("DevanirSoaresJr/JSON/{login}")
    fun getLoggedIn(@Path("login") login: String): Single<LoginResponse>

}