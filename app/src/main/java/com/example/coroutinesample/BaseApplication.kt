package com.example.coroutinesample

import com.example.coroutinesample.di.DaggerAppComponent
import com.example.coroutinesample.di.module.AppModule
import com.example.coroutinesample.di.module.DbModule
import dagger.android.AndroidInjector
import dagger.android.support.DaggerApplication

class BaseApplication: DaggerApplication() {
    override fun applicationInjector(): AndroidInjector<out DaggerApplication> {
        return DaggerAppComponent.builder().appModule(AppModule(this)).dbModule(DbModule()).build()

    }
}