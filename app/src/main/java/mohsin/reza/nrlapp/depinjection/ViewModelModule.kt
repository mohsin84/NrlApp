package mohsin.reza.nrlapp.depinjection

import android.arch.lifecycle.ViewModelProvider
import dagger.Binds
import dagger.Module
import mohsin.reza.nrlapp.Util.NrlViewModelFactory

/**
 * ViewModel Module to use ViewModelKey to generate di code for ViewModels and factory
 */

@Suppress("unused")
@Module
internal abstract class ViewModelModule {
//    @Binds
//    @IntoMap
//    @ViewModelKey(PropertyViewModel::class)
//    abstract fun bindPropertyViewModel(propertyViewModel: PropertyViewModel): ViewModel

    @Binds
    abstract fun bindViewModelFactory(propertyViewModelFactory: NrlViewModelFactory): ViewModelProvider.Factory
}
