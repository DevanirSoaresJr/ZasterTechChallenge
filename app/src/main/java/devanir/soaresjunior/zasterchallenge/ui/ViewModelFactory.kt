package devanir.soaresjunior.zasterchallenge.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import devanir.soaresjunior.zasterchallenge.repo.Repository
import java.lang.IllegalArgumentException
import javax.inject.Inject

class ViewModelFactory @Inject constructor(private val repository: Repository) :
    ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return if (modelClass.isAssignableFrom(MainViewModel::class.java))
            MainViewModel(repository) as T
        else throw IllegalArgumentException("ViewModel Not Found!") as Throwable
    }
}