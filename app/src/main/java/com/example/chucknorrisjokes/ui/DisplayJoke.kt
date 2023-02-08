package com.example.chucknorrisjokes.ui

import android.app.AlertDialog
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import com.example.chucknorrisjokes.R
import com.example.chucknorrisjokes.databinding.ActivityMainBinding
import com.example.chucknorrisjokes.databinding.FragmentDisplayJokeBinding
import com.example.chucknorrisjokes.di.ChuckNorrisApp
import com.example.chucknorrisjokes.model.ChuckNorrisResponse
import com.example.chucknorrisjokes.model.domain.DomainJokes
import com.example.chucknorrisjokes.utils.ChuckNorrisViewModelFactory
import com.example.chucknorrisjokes.utils.UIState
import com.example.chucknorrisjokes.viewmodel.ChuckNorrisViewModel
import javax.inject.Inject

class DisplayJoke : Fragment() {

    @Inject
    lateinit var chuckNorrisViewModelFactory: ChuckNorrisViewModelFactory

    private val chuckNorrisViewModel: ChuckNorrisViewModel by lazy {
        ViewModelProvider(requireActivity(), chuckNorrisViewModelFactory)[ChuckNorrisViewModel::class.java]
    }


    private val binding by lazy {
        FragmentDisplayJokeBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        ChuckNorrisApp.chuckNorrisComponent.inject(this)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        chuckNorrisViewModel.randomJoke.observe(viewLifecycleOwner) { state ->
            when (state) {
                is UIState.LOADING -> {}
                is UIState.ERROR -> {}
                is UIState.SUCCESS -> {
                    binding.chuckJoke.text = state.response.jokesValues
                }
//                is UIState.ERROR -> {
//                    AlertDialog.Builder(requireActivity())
//                        .setTitle("Error occurred")
//                        .setMessage(it.e.localizedMessage)
//                        .setPositiveButton("Retry") { dialog, _ ->
//                            chuckNorrisViewModel.getData()
//                            dialog.dismiss()
//                        }
//                        .setNegativeButton("Dismiss") { dialog, _ ->
//                            dialog.dismiss()
//                        }
//                }
            }
        }
        return binding.root
    }
}
