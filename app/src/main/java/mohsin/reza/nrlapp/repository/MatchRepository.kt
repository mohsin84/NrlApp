package mohsin.reza.nrlapp.repository

import android.arch.lifecycle.LiveData
import android.arch.lifecycle.MediatorLiveData
import mohsin.reza.nrlapp.model.Match
import mohsin.reza.nrlapp.model.Player
import mohsin.reza.nrlapp.model.Resource
import mohsin.reza.nrlapp.network.*
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class MatchRepository @Inject constructor(private val nrlServices: NrlServices) {

    private var matchList = MediatorLiveData<Resource<List<Match>>>()
    private var playerList = MediatorLiveData<Resource<Player>>()

    fun getMatchData(refresh: Boolean?): LiveData<Resource<List<Match>>> {
        val matches: LiveData<ApiResponse<List<Match>>> = nrlServices.getMatches()

        matchList.addSource(matches) { response ->
            when (response) {
                is ApiSuccessResponse -> {
                    matchList.value = Resource.success(response.body)
                }
                is ApiErrorResponse -> {
                    matchList.value = Resource.error(response.errorMessage, null)
                }
                is ApiEmptyResponse -> {
                    matchList.value = null
                }
            }
        }
        return matchList
    }

    fun getPlayerData(playerId: Int?, teamId: Int?): LiveData<Resource<Player>> {
        val players: LiveData<ApiResponse<Player>> = nrlServices.getPlayerDetails(teamId
                ?: 0, playerId ?: 0)

        playerList.addSource(players) { response ->
            when (response) {
                is ApiSuccessResponse -> {
                    playerList.value = Resource.success(response.body)
                }
                is ApiErrorResponse -> {
                    playerList.value = Resource.error(response.errorMessage, null)
                }
                is ApiEmptyResponse -> {
                    playerList.value = null
                }
            }
        }
        return playerList
    }

}