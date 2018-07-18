package mohsin.reza.nrlapp.depinjection

import dagger.Module
import dagger.android.ContributesAndroidInjector
import mohsin.reza.nrlapp.ui.MatchFragment
import mohsin.reza.nrlapp.ui.PlayerFragment

/**
 * Dagger Module for Fragment
 */

@Module
abstract class FragmentBuildersModule {

    @ContributesAndroidInjector
    abstract fun contributeMatchFragment(): MatchFragment

    @ContributesAndroidInjector
    abstract fun contributePlayerFragment(): PlayerFragment
}
