package mohsin.reza.nrlapp.ui

import android.arch.lifecycle.LiveData
import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.Transformations
import android.arch.lifecycle.ViewModel
import android.support.annotation.VisibleForTesting
import mohsin.reza.nrlapp.Util.AbsentLiveData
import mohsin.reza.nrlapp.model.Match
import mohsin.reza.nrlapp.model.Resource
import mohsin.reza.nrlapp.repository.MatchRepository
import javax.inject.Inject

class MatchViewModel @Inject
constructor(matchRepository: MatchRepository) : ViewModel() {

    private val refresh = MutableLiveData<Boolean>()

    @get:VisibleForTesting
    val matchLiveData: LiveData<Resource<List<Match>>>     //this return live data to observer in Fragment


    init {
        matchLiveData = Transformations.switchMap(refresh) { //Observing change of refresh param to get value from
            input ->
            if (input == null) {
                AbsentLiveData.create()       //if in any case refresh is null will show empty data
            } else
                matchRepository.getMatchData(refresh.value) //Getting data from Repository
        }

    }

    @VisibleForTesting
    fun setRefresh(refresh: Boolean) {
        this.refresh.value = refresh             //Setting refresh liveData so that repo call inside PropertyViewModel
        // constructor can make call by listening to the change
    }
}