package com.example.coroutinesample.di.component

import android.content.Context
import com.example.coroutinesample.di.component.scope.module.NetworkModule
import com.example.coroutinesample.di.module.StorageModule
import com.example.coroutinesample.ui.MainActivity
import dagger.BindsInstance
import dagger.Component
import javax.inject.Singleton


@Singleton
@Component(modules = [StorageModule::class,NetworkModule::class])
interface AppComponent {
    @Component.Factory
    interface Factory {
        fun create(@BindsInstance applicationContext: Context): AppComponent
    }

    fun inject(activity:MainActivity)
}