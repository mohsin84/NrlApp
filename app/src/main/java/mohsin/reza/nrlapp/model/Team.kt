package mohsin.reza.nrlapp.model

import com.google.gson.annotations.SerializedName

data class Team(
        @SerializedName("id")
        var id: Int? = null,
        @SerializedName("name")
        var name: String? = null,
        @SerializedName("code")
        var code: String? = null,
        @SerializedName("short_name")
        var shortName: String? = null,
        @SerializedName("top_players")
        var topPlayers: List<TopPlayer>? = null
)
