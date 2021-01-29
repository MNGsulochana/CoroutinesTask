package com.example.coroutinesample.di.module

import com.example.coroutinesample.adapter.PostAdapter
import com.example.coroutinesample.datamodel.PostModelItem
import com.example.coroutinesample.di.scope.ActivityScope
import com.example.coroutinesample.ui.MainActivity
import dagger.Module
import dagger.Provides
import dagger.android.ContributesAndroidInjector
import kotlin.reflect.KClass


@Module
abstract class ActivityBuilderModule {

    @ContributesAndroidInjector
   // @ContributesAndroidInjector(modules = [ApiModule::class])//as a subcomponent
    abstract fun mainActivity(): MainActivity

}