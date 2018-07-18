package mohsin.reza.nrlapp.model

import com.google.gson.annotations.SerializedName

data class Match(
        @SerializedName("match_id")
        var matchId: String? = null,
        @SerializedName("team_A")
        var teamA: Team? = null,
        @SerializedName("team_B")
        var teamB: Team? = null,
        @SerializedName("stat_type")
        var statType: String? = null
)