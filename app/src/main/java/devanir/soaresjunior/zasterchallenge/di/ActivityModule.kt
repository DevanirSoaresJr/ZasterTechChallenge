package devanir.soaresjunior.zasterchallenge.di

import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProviders
import dagger.Module
import dagger.Provides
import devanir.soaresjunior.zasterchallenge.net.LoginService
import devanir.soaresjunior.zasterchallenge.repo.Repository
import devanir.soaresjunior.zasterchallenge.repo.RepositoryImpl
import devanir.soaresjunior.zasterchallenge.ui.MainViewModel
import devanir.soaresjunior.zasterchallenge.ui.ViewModelFactory
import javax.inject.Singleton

@Module(includes = [NetworkModule::class])
class ActivityModule(private val activity: AppCompatActivity) {
    @Provides
    @Singleton
    fun provideMainViewModel(factory: ViewModelFactory) = ViewModelProviders.of(activity, factory)
        .get(MainViewModel::class.java)

    @Provides
    @Singleton
    fun provideRepository(loginService: LoginService): Repository = RepositoryImpl(loginService)
}