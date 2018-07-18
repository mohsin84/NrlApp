package mohsin.reza.nrlapp.network

import android.arch.lifecycle.LiveData
import mohsin.reza.nrlapp.model.Match
import mohsin.reza.nrlapp.model.Player
import retrofit2.http.GET
import retrofit2.http.Path

interface NrlServices {

    @GET("matches/NRL20172101/topplayerstats.json;type=fantasy_points;type=tackles;type=runs;type=run_metres?limit=5&userkey=A00239D3-45F6-4A0A-810C-54A347F144C2")
    fun getMatches(): LiveData<ApiResponse<List<Match>>>

    @GET("series/1/seasons/115/teams/{team_id}/players/{player_id}/detailedstats.json?userkey=9024ec15-d791-4bfd-aa3b-5bcf5d36da4f")
    fun getPlayerDetails(@Path("team_id") team_id: Int,
                         @Path("player_id") player_id: Int
    ): LiveData<ApiResponse<Player>>
}
