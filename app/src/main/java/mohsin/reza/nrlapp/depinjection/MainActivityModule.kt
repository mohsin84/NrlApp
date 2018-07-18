package mohsin.reza.nrlapp.depinjection
import dagger.Module
import dagger.android.ContributesAndroidInjector
import mohsin.reza.nrlapp.MainActivity

/*
 * Main Activity module with Fragment Builder submodule for Dagger to generate code from
 */

@Suppress("unused")
@Module
abstract class MainActivityModule {
    @ContributesAndroidInjector(modules = [FragmentBuildersModule::class])
    abstract fun contributeMainActivity(): MainActivity
}
