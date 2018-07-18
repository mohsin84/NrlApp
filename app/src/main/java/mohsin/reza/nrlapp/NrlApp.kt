package mohsin.reza.nrlapp

import android.app.Activity
import android.app.Application
import dagger.android.DispatchingAndroidInjector
import dagger.android.HasActivityInjector
import mohsin.reza.propertyapp.di.AppInjector
import javax.inject.Inject

class NrlApp : Application(), HasActivityInjector {
    @Inject
    lateinit var dispatchingAndroidInjector: DispatchingAndroidInjector<Activity>

    override fun onCreate() {
        super.onCreate()
        if (BuildConfig.DEBUG) {
        }
        AppInjector.init(this)
    }

    override fun activityInjector() = dispatchingAndroidInjector

}
