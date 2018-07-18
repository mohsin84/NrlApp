package mohsin.reza.nrlapp.model

import com.google.gson.annotations.SerializedName

data class CareerStat(
        @SerializedName("games")
        var games: Int? = null,
        @SerializedName("points")
        var points: Int? = null,
        @SerializedName("tries")
        var tries: Int? = null,
        @SerializedName("win_percentage")
        var winPercentage: Double? = null
)
