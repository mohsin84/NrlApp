package mohsin.reza.nrlapp.model

import com.google.gson.annotations.SerializedName

data class LastMatchStat(
        @SerializedName("errors")
        var errors: Int? = null,
        @SerializedName("goals")
        var goals: Int? = null,
        @SerializedName("intercepted")
        var intercepted: Int? = null,
        @SerializedName("intercepts")
        var intercepts: Int? = null,
        @SerializedName("kicks")
        var kicks: Int? = null,
        @SerializedName("points")
        var points: Int? = null,
        @SerializedName("possessions")
        var possessions: Int? = null,
        @SerializedName("runs")
        var runs: Int? = null,
        @SerializedName("tackles")
        var tackles: Int? = null,
        @SerializedName("tries")
        var tries: Int? = null,
        @SerializedName("mins_played")
        var minsPlayed: Int? = null,
        @SerializedName("attacking_kicks")
        var attackingKicks: Int? = null,
        @SerializedName("bombs_caught")
        var bombsCaught: Int? = null,
        @SerializedName("bombs_dropped")
        var bombsDropped: Int? = null,
        @SerializedName("charged_down")
        var chargedDown: Int? = null,
        @SerializedName("charges_down")
        var chargesDown: Int? = null,
        @SerializedName("drop_outs")
        var dropOuts: Int? = null,
        @SerializedName("dummy_half_runs")
        var dummyHalfRuns: Int? = null,
        @SerializedName("effective_offloads")
        var effectiveOffloads: Int? = null,
        @SerializedName("fantasy_points")
        var fantasyPoints: Int? = null,
        @SerializedName("field_goal_attempts")
        var fieldGoalAttempts: Any? = null,
        @SerializedName("field_goal_misses")
        var fieldGoalMisses: Int? = null,
        @SerializedName("field_goals")
        var fieldGoals: Int? = null,
        @SerializedName("forced_drop_outs")
        var forcedDropOuts: Int? = null,
        @SerializedName("general_play_pass")
        var generalPlayPass: Int? = null,
        @SerializedName("goal_misses")
        var goalMisses: Int? = null,
        @SerializedName("ineffective_tackles")
        var ineffectiveTackles: Int? = null,
        @SerializedName("in_goal_escapes")
        var inGoalEscapes: Int? = null,
        @SerializedName("interchanges_off")
        var interchangesOff: Int? = null,
        @SerializedName("interchanges_on")
        var interchangesOn: Int? = null,
        @SerializedName("kick_errors")
        var kickErrors: Int? = null,
        @SerializedName("kick_metres")
        var kickMetres: Int? = null,
        @SerializedName("kick_return_metres")
        var kickReturnMetres: Int? = null,
        @SerializedName("kick_returns")
        var kickReturns: Int? = null,
        @SerializedName("kicks_4020")
        var kicks4020: Int? = null,
        @SerializedName("kicks_dead")
        var kicksDead: Int? = null,
        @SerializedName("last_touch_try_assists")
        var lastTouchTryAssists: Int? = null,
        @SerializedName("line_break_assists")
        var lineBreakAssists: Int? = null,
        @SerializedName("line_break_causes")
        var lineBreakCauses: Int? = null,
        @SerializedName("line_breaks")
        var lineBreaks: Int? = null,
        @SerializedName("line_engagements")
        var lineEngagements: Int? = null,
        @SerializedName("long_kicks")
        var longKicks: Int? = null,
        @SerializedName("missed_tackles")
        var missedTackles: Int? = null,
        @SerializedName("off_loads")
        var offLoads: Int? = null,
        @SerializedName("one_pass_runs")
        var onePassRuns: Int? = null,
        @SerializedName("penalties_conceded")
        var penaltiesConceded: Int? = null,
        @SerializedName("play_the_balls")
        var playTheBalls: Int? = null,
        @SerializedName("run_metres")
        var runMetres: Int? = null,
        @SerializedName("runs_7less_meters")
        var runs7lessMeters: Any? = null,
        @SerializedName("runs_8plus_meters")
        var runs8plusMeters: Int? = null,
        @SerializedName("send_offs")
        var sendOffs: Int? = null,
        @SerializedName("sin_bins")
        var sinBins: Int? = null,
        @SerializedName("steals_one_on_one")
        var stealsOneOnOne: Int? = null,
        @SerializedName("stolen_one_on_one")
        var stolenOneOnOne: Int? = null,
        @SerializedName("tackle_busts")
        var tackleBusts: Int? = null,
        @SerializedName("tackled_opp20")
        var tackledOpp20: Int? = null,
        @SerializedName("tackle_opp_half")
        var tackleOppHalf: Int? = null,
        @SerializedName("tackles_one_on_one")
        var tacklesOneOnOne: Int? = null,
        @SerializedName("try_assists")
        var tryAssists: Int? = null,
        @SerializedName("try_causes")
        var tryCauses: Int? = null,
        @SerializedName("try_contribution_percentage")
        var tryContributionPercentage: Any? = null,
        @SerializedName("try_contributions")
        var tryContributions: Int? = null,
        @SerializedName("try_involvements")
        var tryInvolvements: Int? = null,
        @SerializedName("twenty_metre_restarts")
        var twentyMetreRestarts: Int? = null,
        @SerializedName("weighted_kicks")
        var weightedKicks: Int? = null
)
