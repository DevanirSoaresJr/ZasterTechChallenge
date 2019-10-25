package devanir.soaresjunior.zasterchallenge.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import devanir.soaresjunior.zasterchallenge.data.LoginResponse
import devanir.soaresjunior.zasterchallenge.repo.Repository


class MainViewModel(private val repository: Repository) : ViewModel() {

    override fun onCleared() {
        super.onCleared()
        repository.dispose()
    }

    fun showlogin(login:String): LiveData<LoginResponse> = repository.getLoggedIn(login)

}
