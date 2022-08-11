package com.joseph.core_network_impl.di

import com.joseph.core_network_api.MakeService
import dagger.Component
import javax.inject.Singleton

@Component(modules = [NetworkModule::class])
@Singleton
interface CoreNetworkComponent {

    @Component.Builder
    interface Builder {

        fun applicationContextModule(networkModule: NetworkModule): Builder

        fun build(): CoreNetworkComponent

    }

    fun makeService(): MakeService

}