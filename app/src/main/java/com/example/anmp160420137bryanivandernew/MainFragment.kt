package com.example.anmp160420137bryanivandernew

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.navigation.Navigation
import com.example.anmp160420137bryanivandernew.databinding.FragmentMainBinding
import com.google.android.material.textfield.TextInputEditText
import kotlin.random.Random


class MainFragment : Fragment() {
    private lateinit var binding: FragmentMainBinding
    private var score = 0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {

        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentMainBinding.inflate(
            inflater,
            container, false
        )
        return binding.root

    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        binding.btnStart.setOnClickListener{if (binding.btnStart.text == "Start") {
            randomizeNumbers()
            binding.btnStart.text = "Submit Answer"
        } else {
            val number1 = binding.textNumber1.text.toString().toInt()
            val number2 = binding.textNumber2.text.toString().toInt()
            val correctAnswer = number1 + number2

            val userAnswer = binding.txtAnswer.text.toString().toIntOrNull()
            if (userAnswer != null && userAnswer == correctAnswer) {
                score++
                randomizeNumbers()
                binding.txtAnswer.text?.clear()
            } else {
                val action = MainFragmentDirections.mainToResultFragment(score)
                Navigation.findNavController(it).navigate(action)
            }
        }
        }
    }
    private fun randomizeNumbers() {
        val number1 = Random.nextInt(20) + 1  // Generates numbers between 1 and 10
        val number2 = Random.nextInt(20) + 1  // Generates numbers between 1 and 10

        binding.textNumber1.text = number1.toString()
        binding.textNumber2.text = number2.toString()
    }

    companion object {

    }
}