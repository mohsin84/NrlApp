package mohsin.reza.nrlapp.model

import com.google.gson.annotations.SerializedName

data class TopPlayer(
        @SerializedName("id")
        var id: Int? = null,
        @SerializedName("position")
        var position: String? = null,
        @SerializedName("full_name")
        var fullName: String? = null,
        @SerializedName("short_name")
        var shortName: String? = null,
        @SerializedName("stat_value")
        var statValue: Int? = null,
        @SerializedName("jumper_number")
        var jumperNumber: Int? = null
)
