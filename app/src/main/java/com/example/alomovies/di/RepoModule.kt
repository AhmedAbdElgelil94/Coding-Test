package com.example.alomovies.di

import com.example.data.repoImp.coachdatarepoImp.CoachDataRepoImp
import com.example.domain.repo.coachdatarepo.CoachDataRepo
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
abstract class RepoModule {

    @Binds
    abstract fun bindCoachDataRepo(coachDataRepoImp: CoachDataRepoImp) : CoachDataRepo

}