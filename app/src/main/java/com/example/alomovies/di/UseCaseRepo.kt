package com.example.alomovies.di

import com.example.domain.repo.coachdatarepo.CoachDataRepo
import com.example.domain.usecase.coachdatausecase.CoachDataUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
object UseCaseRepo {

    @Provides
    fun provideCoachDataUseCase(coachDataRepo: CoachDataRepo):CoachDataUseCase
    {
        return CoachDataUseCase(coachDataRepo)
    }


}