package devanir.soaresjunior.zasterchallenge.repo

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import devanir.soaresjunior.zasterchallenge.data.LoginResponse
import devanir.soaresjunior.zasterchallenge.net.LoginService
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers

class RepositoryImpl(private val loginService: LoginService) : Repository {


    private val compositeDisposable = CompositeDisposable()
    private val loginLiveData = MutableLiveData<LoginResponse>()

    override fun getLoggedIn(login:String): LiveData<LoginResponse> {
        compositeDisposable.add(loginService.getLoggedIn(login)
            .observeOn(AndroidSchedulers.mainThread())
            .subscribeOn(Schedulers.io()).subscribe(
                {
                    loginLiveData.value = it
                },
                {
                    error("Error Fetching Data")

                }
            ))

        return loginLiveData
    }


    override fun dispose() {
        compositeDisposable.clear()
    }


}
