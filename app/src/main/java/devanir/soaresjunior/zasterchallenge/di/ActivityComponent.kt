package devanir.soaresjunior.zasterchallenge.di

import dagger.Component
import devanir.soaresjunior.zasterchallenge.ui.LogInFrag
import devanir.soaresjunior.zasterchallenge.ui.RegistrationFrag
import javax.inject.Singleton

@Singleton
@Component(modules = [ActivityModule::class])
interface ActivityComponent {
    fun inject(logInFrag: LogInFrag)
    fun inject(registrationFrag: RegistrationFrag)
}