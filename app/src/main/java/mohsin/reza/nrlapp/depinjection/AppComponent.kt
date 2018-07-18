package mohsin.reza.propertyapp.di

import android.app.Application
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjectionModule
import mohsin.reza.nrlapp.NrlApp
import javax.inject.Singleton

/***
 * Dagger2 Component for dependency injection
 */

@Singleton
@Component(modules = [AndroidInjectionModule::class,
    AppModule::class,
    MainActivityModule::class]
)
interface AppComponent {
    @Component.Builder
    interface Builder {
        @BindsInstance
        fun application(application: Application): Builder

        fun build(): AppComponent
    }

    fun inject(propertyApp: NrlApp)
}
