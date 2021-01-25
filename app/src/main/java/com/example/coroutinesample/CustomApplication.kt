package com.example.coroutinesample

import android.app.Application
import com.example.coroutinesample.di.component.AppComponent
import com.example.coroutinesample.di.component.DaggerAppComponent

open class CustomApplication:Application() {

    internal lateinit var component: AppComponent

    // Instance of the AppComponent that will be used by all the Activities in the project
    val appComponent: AppComponent by lazy {
        initializeComponent()
    }

    open fun initializeComponent(): AppComponent {
        // Creates an instance of AppComponent using its Factory constructor
        // We pass the applicationContext that will be used as Context in the graph
        return DaggerAppComponent.factory().create(applicationContext)
    }
}