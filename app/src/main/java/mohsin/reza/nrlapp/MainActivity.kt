package mohsin.reza.nrlapp

import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v7.app.AppCompatActivity
import dagger.android.DispatchingAndroidInjector
import dagger.android.support.HasSupportFragmentInjector
import mohsin.reza.nrlapp.ui.MatchFragment
import javax.inject.Inject

class MainActivity : AppCompatActivity(), HasSupportFragmentInjector {

    @Inject
    lateinit var dispatchingAndroidInjector: DispatchingAndroidInjector<Fragment>
    private var fragmentManager: FragmentManager = supportFragmentManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        if (savedInstanceState == null) {
            val matchFragment = MatchFragment()
            fragmentManager.beginTransaction()                      //Adding the fragment to the Activity container
                    .replace(R.id.container, matchFragment)
                    .commitAllowingStateLoss()
        }
    }

    override fun supportFragmentInjector() = dispatchingAndroidInjector

}
