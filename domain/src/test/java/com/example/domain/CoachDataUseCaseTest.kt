package com.example.domain

import com.example.domain.entity.response.coachdataresponse.CoachData
import com.example.domain.repo.coachdatarepo.CoachDataRepo
import com.example.domain.usecase.coachdatausecase.CoachDataUseCase
import com.google.common.truth.Truth
import io.mockk.MockKAnnotations
import io.mockk.coEvery
import io.mockk.impl.annotations.MockK
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.runTest
import org.junit.Test

import org.junit.Assert.*
import org.junit.Before
import org.junit.Rule

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
@OptIn(ExperimentalCoroutinesApi::class)
class CoachDataUseCaseTest {

        @get: Rule
        var mainCoroutineRule =
            MainCoroutineRule()
        @MockK
        private lateinit var coachDataRepo: CoachDataRepo
        private lateinit var coachDataUseCase : CoachDataUseCase

        @Before
        fun setUp() {
            MockKAnnotations.init(this)
            coachDataUseCase = CoachDataUseCase(coachDataRepo)
        }

        @Test
        fun test_GetCoach_Completed()= runTest  {
            val coachData = CoachData(
                "Josh Kramer",
            "https://www.shutterstock.com/shutterstock/photos/1822207589/display_1500/stock-photo-indoor-personal-cardio-training-in-gym-1822207589.jpg",
            "The Challenge",
            "You will assess the physical and health conditions of clients, create appropriate exercise plans,")
            coEvery { coachDataRepo.getCoachData()} returns coachData
            val result=coachDataUseCase.getCoachDataUseCase()
            Truth.assertThat((result.coaches_name)).isEqualTo("Josh Kramer")
        }
    }


