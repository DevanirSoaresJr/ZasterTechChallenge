package devanir.soaresjunior.zasterchallenge.ui

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import devanir.soaresjunior.zasterchallenge.R
import kotlinx.android.synthetic.main.login_frag.*
import javax.inject.Inject

class LogInFrag: Fragment() {
    @Inject
    lateinit var viewModel: MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        (activity as MainActivity).activityComponent.inject(this)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.login_frag, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

        val sharedPreferences = requireActivity()
            .getSharedPreferences("loginData", Context.MODE_PRIVATE)

        val usernameDB = sharedPreferences.getString("username", null)
        val passwordDB = sharedPreferences.getString("password", null)

        val username = etUsername.text.toString()
        val password = etPassword.text.toString()

        btn_login.setOnClickListener {

           if (username == usernameDB && password == passwordDB){
               viewModel.showlogin("200").observe(viewLifecycleOwner, Observer {
                   Toast.makeText(requireContext(), it.token, Toast.LENGTH_LONG).show()
               })
           } else{
               viewModel.showlogin("401").observe(viewLifecycleOwner, Observer {
                   Toast.makeText(requireContext(), it.error, Toast.LENGTH_LONG).show()
               })
           }

       }
        btn_500Error.setOnClickListener {
            viewModel.showlogin("500").observe(viewLifecycleOwner, Observer {
                Toast.makeText(requireContext(), it.error, Toast.LENGTH_LONG).show()
        })

        }

        btn_register_login_page.setOnClickListener {
            fragmentManager?.beginTransaction()
                ?.replace(R.id.frag_container, RegistrationFrag())
                ?.addToBackStack(RegistrationFrag().tag)
                ?.commit()
        }
    }
}