package devanir.soaresjunior.zasterchallenge.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import devanir.soaresjunior.zasterchallenge.R
import kotlinx.android.synthetic.main.login_frag.*
import kotlinx.android.synthetic.main.user_registration.*


class RegistrationFrag: Fragment(){
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.user_registration, container, false)

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

    }

}