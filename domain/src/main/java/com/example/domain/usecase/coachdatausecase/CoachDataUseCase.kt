package com.example.domain.usecase.coachdatausecase

import android.content.Context
import com.example.domain.entity.response.coachdataresponse.CoachData
import com.example.domain.repo.coachdatarepo.CoachDataRepo

class CoachDataUseCase (private val coachDataRepo: CoachDataRepo){

      suspend fun getCoachDataUseCase() : CoachData = coachDataRepo.getCoachData()

}