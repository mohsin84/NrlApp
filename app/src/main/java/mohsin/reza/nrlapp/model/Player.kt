package mohsin.reza.nrlapp.model

import com.google.gson.annotations.SerializedName

data class Player(
        @SerializedName("id")
        var id: Int? = null,
        @SerializedName("surname")
        var surname: String? = null,
        @SerializedName("position")
        var position: String? = null,
        @SerializedName("full_name")
        var fullName: String? = null,
        @SerializedName("short_name")
        var shortName: String? = null,
        @SerializedName("date_of_birth")
        var dateOfBirth: String? = null,
        @SerializedName("height_cm")
        var heightCm: Int? = null,
        @SerializedName("other_names")
        var otherNames: String? = null,
        @SerializedName("weight_kg")
        var weightKg: Int? = null,
        @SerializedName("last_match_id")
        var lastMatchId: String? = null,
        @SerializedName("career_stats")
        var careerStat: CareerStat? = null,
        @SerializedName("last_match_stats")
        var lastMatchStat: List<LastMatchStat>? = null
)
