package devanir.soaresjunior.zasterchallenge.ui

import android.content.Context
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import devanir.soaresjunior.zasterchallenge.R
import devanir.soaresjunior.zasterchallenge.di.ActivityComponent
import devanir.soaresjunior.zasterchallenge.di.ActivityModule
import devanir.soaresjunior.zasterchallenge.di.DaggerActivityComponent
import java.util.function.LongFunction

class MainActivity : AppCompatActivity() {
    lateinit var activityComponent: ActivityComponent

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        supportFragmentManager.beginTransaction().add(R.id.frag_container,LogInFrag()).commit()
        activityComponent = DaggerActivityComponent.builder()
            .activityModule(ActivityModule(this))
            .build()

        val sharedPreferences = getSharedPreferences("loginData", Context.MODE_PRIVATE)
        val editor = sharedPreferences.edit()

        editor.putString("username", "devanir")
        editor.putString("password", "123devanir123")
        editor.apply()

    }
}
