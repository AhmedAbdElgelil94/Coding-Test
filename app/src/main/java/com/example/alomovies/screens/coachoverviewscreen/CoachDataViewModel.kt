package com.example.alomovies.screens.coachoverviewscreen

import android.content.Context
import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.domain.entity.response.coachdataresponse.CoachData
import com.example.domain.usecase.coachdatausecase.CoachDataUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class  CoachDataViewModel @Inject constructor(private val coachDataUseCase: CoachDataUseCase) :ViewModel(){

    private val _coachData : MutableStateFlow<CoachData?> = MutableStateFlow(null)
    val coachData : StateFlow<CoachData?> = _coachData

    fun getCoachData()
    {
        viewModelScope.launch {
            try {
              _coachData.value = coachDataUseCase.getCoachDataUseCase()
            }
            catch (e:Exception)
            {
                Log.e("Exception Error:",e.message.toString())
            }
        }
    }
}