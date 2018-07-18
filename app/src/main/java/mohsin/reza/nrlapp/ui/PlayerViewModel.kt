package mohsin.reza.nrlapp.ui

import android.arch.lifecycle.LiveData
import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.Transformations
import android.arch.lifecycle.ViewModel
import android.support.annotation.VisibleForTesting
import mohsin.reza.nrlapp.Util.AbsentLiveData
import mohsin.reza.nrlapp.model.Player
import mohsin.reza.nrlapp.model.Resource
import mohsin.reza.nrlapp.repository.MatchRepository
import javax.inject.Inject

class PlayerViewModel @Inject
constructor(matchRepository: MatchRepository) : ViewModel() {

    private val playerId = MutableLiveData<Int>()
    private val teamid = MutableLiveData<Int>()

    @get:VisibleForTesting
    val playerLiveData: LiveData<Resource<Player>>     //this return live data to observer in Fragment

    init {
        playerLiveData = Transformations.switchMap(playerId) { //Observing change of refresh param to get value from
            input ->
            if (input == null) {
                AbsentLiveData.create()       //if in any case refresh is null will show empty data
            } else
                matchRepository.getPlayerData(playerId.value, teamid.value) //Getting data from Repository
        }

    }

    @VisibleForTesting
    fun setRefresh(playerid: Int?, teamid: Int?) {
        this.playerId.value = playerid
        this.teamid.value = teamid
        //Setting refresh liveData so that repo call inside PropertyViewModel
        // constructor can make call by listening to the change
    }
}