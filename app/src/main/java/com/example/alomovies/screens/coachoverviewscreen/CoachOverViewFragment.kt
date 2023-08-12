package com.example.alomovies.screens.coachoverviewscreen

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModel
import androidx.lifecycle.lifecycleScope
import com.bumptech.glide.Glide
import com.example.alomovies.R
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.android.synthetic.main.fragment_overview_coach.*
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch

@AndroidEntryPoint
class CoachOverViewFragment : Fragment() {

    val viewModel:CoachDataViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_overview_coach, container, false)
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel.getCoachData()
        lifecycleScope.launch{
            viewModel.coachData.collect{
                tv_name.text = it?.coaches_name
                tv_series.text = it?.series_name
                tv_description.text = it?.Description
                context?.let { it1 ->
                    Glide
                        .with(it1)
                        .load(it?.cover_photo)
                        .into(img)
                };
            }
        }
    }

}