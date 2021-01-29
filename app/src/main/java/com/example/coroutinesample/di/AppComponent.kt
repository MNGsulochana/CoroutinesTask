package com.example.coroutinesample.di

import android.app.Application
import android.content.Context
import com.example.coroutinesample.BaseApplication
import com.example.coroutinesample.di.module.ActivityBuilderModule
import com.example.coroutinesample.di.module.AppModule
import com.example.coroutinesample.di.module.DbModule
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjectionModule
import dagger.android.AndroidInjector
import javax.inject.Singleton

@Singleton
@Component(modules = [AndroidInjectionModule::class,
    ActivityBuilderModule::class,AppModule::class,DbModule::class])
interface AppComponent:AndroidInjector<BaseApplication> {

  /*  @Component.Builder
    interface Builder {
        @BindsInstance
        fun application(application: Application): Builder
        fun build(): AppComponent

    }
*/



    /* @Component.Factory
     interface Factory {
         fun create(@BindsInstance applicationContext: Context): AppComponent
     }*/
}