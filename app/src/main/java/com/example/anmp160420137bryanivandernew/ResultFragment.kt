package com.example.anmp160420137bryanivandernew

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation
import androidx.navigation.fragment.navArgs
import com.example.anmp160420137bryanivandernew.databinding.FragmentMainBinding
import com.example.anmp160420137bryanivandernew.databinding.FragmentResultBinding


class ResultFragment : Fragment() {
    private lateinit var binding: FragmentResultBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {

        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {binding = FragmentResultBinding.inflate(
        inflater,
        container, false
    )
        return binding.root
        // Inflate the layout for this fragment

    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        if(arguments != null) {
            val scorey =
                ResultFragmentArgs.fromBundle(requireArguments()).score
            binding.txtScore.text = "Your Score Is: $scorey"

        }




        binding.btnBack.setOnClickListener {
            val action = ResultFragmentDirections.resultToMainFragment()
            Navigation.findNavController(it).navigate(action)
        }
    }

    companion object {

    }
}