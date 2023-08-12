package com.example.data.repoImp.coachdatarepoImp

import android.content.Context
import com.example.domain.entity.response.coachdataresponse.CoachData
import com.example.domain.repo.coachdatarepo.CoachDataRepo
import com.example.data.remote.GetJsonDataFromAsset.Companion.getJsonDataFromAsset
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import dagger.hilt.android.qualifiers.ApplicationContext
import javax.inject.Inject


class CoachDataRepoImp @Inject constructor(@ApplicationContext var context: Context?) : CoachDataRepo {

    override fun getCoachData(): CoachData {
        return convertJsonToGson()
    }

   private fun convertJsonToGson() : CoachData
    {
        val jsonFileString = getJsonDataFromAsset(context, "CoachData.json")
        val gson = Gson()
        val coachDataType = object : TypeToken<CoachData>() {}.type
        return gson.fromJson(jsonFileString, coachDataType)
    }
}