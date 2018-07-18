package mohsin.reza.nrlapp.depinjection

import android.app.Application
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjectionModule
import mohsin.reza.nrlapp.NrlApp
import mohsin.reza.propertyapp.di.AppModule
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
