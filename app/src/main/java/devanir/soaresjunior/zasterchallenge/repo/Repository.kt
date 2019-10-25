package devanir.soaresjunior.zasterchallenge.repo

import androidx.lifecycle.LiveData
import devanir.soaresjunior.zasterchallenge.data.LoginResponse


interface Repository {

    fun getLoggedIn(login:String): LiveData<LoginResponse>

    fun dispose()
}
