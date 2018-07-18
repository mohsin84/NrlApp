package mohsin.reza.nrlapp.depinjection

import android.arch.lifecycle.ViewModel
import android.arch.lifecycle.ViewModelProvider
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap
import mohsin.reza.nrlapp.Util.NrlViewModelFactory
import mohsin.reza.nrlapp.ui.MatchViewModel
import mohsin.reza.nrlapp.ui.PlayerViewModel

/**
 * ViewModel Module to use ViewModelKey to generate di code for ViewModels and factory
 */

@Suppress("unused")
@Module
internal abstract class ViewModelModule {
    @Binds
    @IntoMap
    @ViewModelKey(MatchViewModel::class)
    abstract fun bindMatchViewModel(propertyViewModel: MatchViewModel): ViewModel

    @Binds
    @IntoMap
    @ViewModelKey(PlayerViewModel::class)
    abstract fun bindPlayerViewModel(playerViewModel: PlayerViewModel): ViewModel

    @Binds
    abstract fun bindViewModelFactory(propertyViewModelFactory: NrlViewModelFactory): ViewModelProvider.Factory
}
