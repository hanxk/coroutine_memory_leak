package app.hanxk.demo.coroutinememorydemo.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.Navigation
import app.hanxk.demo.coroutinememorydemo.R
import kotlinx.android.synthetic.main.frag_home.*

class HomeFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.frag_home, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        btnGo2Detail.setOnClickListener {
            //      Navigation.findNavController(it).navigate(R.id.action_homeFragment_to_detailFragment)
            activity?.finish()
        }
    }
}