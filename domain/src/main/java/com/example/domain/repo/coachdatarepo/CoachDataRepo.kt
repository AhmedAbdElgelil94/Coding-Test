package com.example.domain.repo.coachdatarepo

import android.content.Context
import com.example.domain.entity.response.coachdataresponse.CoachData

interface CoachDataRepo {
    fun getCoachData(): CoachData
}