// License: GPL. For details, see LICENSE file.
package s57

import java.util.*

/**
 * @author Malcolm Herring
 */
object S57obj {
    private val ObjS57: EnumMap<Obj?, Int?>? = EnumMap(
        Obj::class.java
    )

    init {
        ObjS57!![Obj.UNKOBJ] = 0
        ObjS57[Obj.AIRARE] = 2
        ObjS57[Obj.ACHBRT] = 3
        ObjS57[Obj.ACHARE] = 4
        ObjS57[Obj.BCNCAR] = 5
        ObjS57[Obj.BCNISD] = 6
        ObjS57[Obj.BCNLAT] = 7
        ObjS57[Obj.BCNSAW] = 8
        ObjS57[Obj.BCNSPP] = 9
        ObjS57[Obj.BERTHS] = 10
        ObjS57[Obj.BRIDGE] = 11
        ObjS57[Obj.BUISGL] = 12
        ObjS57[Obj.BUAARE] = 13
        ObjS57[Obj.BOYCAR] = 14
        ObjS57[Obj.BOYINB] = 15
        ObjS57[Obj.BOYISD] = 16
        ObjS57[Obj.BOYLAT] = 17
        ObjS57[Obj.BOYSAW] = 18
        ObjS57[Obj.BOYSPP] = 19
        ObjS57[Obj.CBLARE] = 20
        ObjS57[Obj.CBLOHD] = 21
        ObjS57[Obj.CBLSUB] = 22
        ObjS57[Obj.CANALS] = 23
        ObjS57[Obj.CTSARE] = 25
        ObjS57[Obj.CAUSWY] = 26
        ObjS57[Obj.CTNARE] = 27
        ObjS57[Obj.CHKPNT] = 28
        ObjS57[Obj.CGUSTA] = 29
        ObjS57[Obj.COALNE] = 30
        ObjS57[Obj.CONZNE] = 31
        ObjS57[Obj.COSARE] = 32
        ObjS57[Obj.CTRPNT] = 33
        ObjS57[Obj.CONVYR] = 34
        ObjS57[Obj.CRANES] = 35
        ObjS57[Obj.CURENT] = 36
        ObjS57[Obj.CUSZNE] = 37
        ObjS57[Obj.DAMCON] = 38
        ObjS57[Obj.DAYMAR] = 39
        ObjS57[Obj.DWRTCL] = 40
        ObjS57[Obj.DWRTPT] = 41
        ObjS57[Obj.DEPARE] = 42
        ObjS57[Obj.DEPCNT] = 43
        ObjS57[Obj.DISMAR] = 44
        ObjS57[Obj.DOCARE] = 45
        ObjS57[Obj.DRGARE] = 46
        ObjS57[Obj.DRYDOC] = 47
        ObjS57[Obj.DMPGRD] = 48
        ObjS57[Obj.DYKCON] = 49
        ObjS57[Obj.EXEZNE] = 50
        ObjS57[Obj.FAIRWY] = 51
        ObjS57[Obj.FNCLNE] = 52
        ObjS57[Obj.FERYRT] = 53
        ObjS57[Obj.FSHZNE] = 54
        ObjS57[Obj.FSHFAC] = 55
        ObjS57[Obj.FSHGRD] = 56
        ObjS57[Obj.FLODOC] = 57
        ObjS57[Obj.FOGSIG] = 58
        ObjS57[Obj.FORSTC] = 59
        ObjS57[Obj.FRPARE] = 60
        ObjS57[Obj.GATCON] = 61
        ObjS57[Obj.GRIDRN] = 62
        ObjS57[Obj.HRBARE] = 63
        ObjS57[Obj.HRBFAC] = 64
        ObjS57[Obj.HULKES] = 65
        ObjS57[Obj.ICEARE] = 66
        ObjS57[Obj.ICNARE] = 67
        ObjS57[Obj.ISTZNE] = 68
        ObjS57[Obj.LAKARE] = 69
        ObjS57[Obj.LNDARE] = 71
        ObjS57[Obj.LNDELV] = 72
        ObjS57[Obj.LNDRGN] = 73
        ObjS57[Obj.LNDMRK] = 74
        ObjS57[Obj.LIGHTS] = 75
        ObjS57[Obj.LITFLT] = 76
        ObjS57[Obj.LITVES] = 77
        ObjS57[Obj.LOCMAG] = 78
        ObjS57[Obj.LOKBSN] = 79
        ObjS57[Obj.LOGPON] = 80
        ObjS57[Obj.MAGVAR] = 81
        ObjS57[Obj.MARCUL] = 82
        ObjS57[Obj.MIPARE] = 83
        ObjS57[Obj.MORFAC] = 84
        ObjS57[Obj.NAVLNE] = 85
        ObjS57[Obj.OBSTRN] = 86
        ObjS57[Obj.OFSPLF] = 87
        ObjS57[Obj.OSPARE] = 88
        ObjS57[Obj.OILBAR] = 89
        ObjS57[Obj.PILPNT] = 90
        ObjS57[Obj.PILBOP] = 91
        ObjS57[Obj.PIPARE] = 92
        ObjS57[Obj.PIPOHD] = 93
        ObjS57[Obj.PIPSOL] = 94
        ObjS57[Obj.PONTON] = 95
        ObjS57[Obj.PRCARE] = 96
        ObjS57[Obj.PRDARE] = 97
        ObjS57[Obj.PYLONS] = 98
        ObjS57[Obj.RADLNE] = 99
        ObjS57[Obj.RADRNG] = 100
        ObjS57[Obj.RADRFL] = 101
        ObjS57[Obj.RADSTA] = 102
        ObjS57[Obj.RTPBCN] = 103
        ObjS57[Obj.RDOCAL] = 104
        ObjS57[Obj.RDOSTA] = 105
        ObjS57[Obj.RAILWY] = 106
        ObjS57[Obj.RAPIDS] = 107
        ObjS57[Obj.RCRTCL] = 108
        ObjS57[Obj.RECTRC] = 109
        ObjS57[Obj.RCTLPT] = 110
        ObjS57[Obj.RSCSTA] = 111
        ObjS57[Obj.RESARE] = 112
        ObjS57[Obj.RETRFL] = 113
        ObjS57[Obj.RIVERS] = 114
        ObjS57[Obj.ROADWY] = 116
        ObjS57[Obj.RUNWAY] = 117
        ObjS57[Obj.SNDWAV] = 118
        ObjS57[Obj.SEAARE] = 119
        ObjS57[Obj.SPLARE] = 120
        ObjS57[Obj.SBDARE] = 121
        ObjS57[Obj.SLCONS] = 122
        ObjS57[Obj.SISTAT] = 123
        ObjS57[Obj.SISTAW] = 124
        ObjS57[Obj.SILTNK] = 125
        ObjS57[Obj.SLOTOP] = 126
        ObjS57[Obj.SLOGRD] = 127
        ObjS57[Obj.SMCFAC] = 128
        ObjS57[Obj.SOUNDG] = 129
        ObjS57[Obj.SPRING] = 130
        ObjS57[Obj.STSLNE] = 132
        ObjS57[Obj.SUBTLN] = 133
        ObjS57[Obj.SWPARE] = 134
        ObjS57[Obj.TESARE] = 135
        ObjS57[Obj.TS_PRH] = 136
        ObjS57[Obj.TS_PNH] = 137
        ObjS57[Obj.TS_PAD] = 138
        ObjS57[Obj.TS_TIS] = 139
        ObjS57[Obj.T_HMON] = 140
        ObjS57[Obj.T_NHMN] = 141
        ObjS57[Obj.T_TIMS] = 142
        ObjS57[Obj.TIDEWY] = 143
        ObjS57[Obj.TOPMAR] = 144
        ObjS57[Obj.TSELNE] = 145
        ObjS57[Obj.TSSBND] = 146
        ObjS57[Obj.TSSCRS] = 147
        ObjS57[Obj.TSSLPT] = 148
        ObjS57[Obj.TSSRON] = 149
        ObjS57[Obj.TSEZNE] = 150
        ObjS57[Obj.TUNNEL] = 151
        ObjS57[Obj.TWRTPT] = 152
        ObjS57[Obj.UWTROC] = 153
        ObjS57[Obj.UNSARE] = 154
        ObjS57[Obj.VEGATN] = 155
        ObjS57[Obj.WATTUR] = 156
        ObjS57[Obj.WATFAL] = 157
        ObjS57[Obj.WEDKLP] = 158
        ObjS57[Obj.WRECKS] = 159
        ObjS57[Obj.TS_FEB] = 160
        ObjS57[Obj.MPAARE] = 199
        ObjS57[Obj.M_COVR] = 302
        ObjS57[Obj.M_NSYS] = 306
        ObjS57[Obj.LITMAJ] = 74
        ObjS57[Obj.LITMIN] = 90
    }

    private val ObjIENC: EnumMap<Obj?, Int?>? = EnumMap(
        Obj::class.java
    )

    init {
        ObjIENC!![Obj.UNKOBJ] = 0
        ObjIENC[Obj.ACHBRT] = 17000
        ObjIENC[Obj.ACHARE] = 17001
        ObjIENC[Obj.DEPARE] = 17003
        ObjIENC[Obj.DISMAR] = 17004
        ObjIENC[Obj.RESARE] = 17005
        ObjIENC[Obj.SISTAT] = 17007
        ObjIENC[Obj.SISTAW] = 17008
        ObjIENC[Obj.TOPMAR] = 17009
        ObjIENC[Obj.BERTHS] = 17010
        ObjIENC[Obj.BRIDGE] = 17011
        ObjIENC[Obj.CBLOHD] = 17012
        ObjIENC[Obj.FERYRT] = 17013
        ObjIENC[Obj.HRBARE] = 17014
        ObjIENC[Obj.HRBFAC] = 17015
        ObjIENC[Obj.LOKBSN] = 17016
        ObjIENC[Obj.RDOCAL] = 17017
        ObjIENC[Obj.CURENT] = 17019
        ObjIENC[Obj.HULKES] = 17020
        ObjIENC[Obj.PONTON] = 17021
        ObjIENC[Obj.PIPOHD] = 17024
        ObjIENC[Obj.FLODOC] = 17025
        ObjIENC[Obj.CHKPNT] = 17027
        ObjIENC[Obj.BCNLAT] = 17028
        ObjIENC[Obj.BOYLAT] = 17029
        ObjIENC[Obj.CRANES] = 17030
        ObjIENC[Obj.GATCON] = 17031
        ObjIENC[Obj.SLCONS] = 17032
        ObjIENC[Obj.UWTROC] = 17033
        ObjIENC[Obj.CONVYR] = 17034
        ObjIENC[Obj.NOTMRK] = 17050
        ObjIENC[Obj.WTWAXS] = 17051
        ObjIENC[Obj.WTWPRF] = 17052
        ObjIENC[Obj.BUNSTA] = 17054
        ObjIENC[Obj.COMARE] = 17055
        ObjIENC[Obj.HRBBSN] = 17056
        ObjIENC[Obj.LKBSPT] = 17058
        ObjIENC[Obj.PRTARE] = 17059
        ObjIENC[Obj.REFDMP] = 17062
        ObjIENC[Obj.TERMNL] = 17064
        ObjIENC[Obj.TRNBSN] = 17065
        ObjIENC[Obj.WTWARE] = 17066
        ObjIENC[Obj.WTWGAG] = 17067
        ObjIENC[Obj.TISDGE] = 17068
        ObjIENC[Obj.VEHTRF] = 17069
        ObjIENC[Obj.EXCNST] = 17070
        ObjIENC[Obj.LG_SDM] = 18001
        ObjIENC[Obj.LG_VSP] = 18002
    }

    private val ObjStr: EnumMap<Obj?, String?>? = EnumMap(
        Obj::class.java
    )

    init {
        ObjStr!![Obj.UNKOBJ] = ""
        ObjStr[Obj.AIRARE] = "airfield"
        ObjStr[Obj.ACHBRT] = "anchor_berth"
        ObjStr[Obj.ACHARE] = "anchorage"
        ObjStr[Obj.BCNCAR] = "beacon_cardinal"
        ObjStr[Obj.BCNISD] = "beacon_isolated_danger"
        ObjStr[Obj.BCNLAT] = "beacon_lateral"
        ObjStr[Obj.BCNSAW] = "beacon_safe_water"
        ObjStr[Obj.BCNSPP] = "beacon_special_purpose"
        ObjStr[Obj.BERTHS] = "berth"
        ObjStr[Obj.BRIDGE] = "bridge"
        ObjStr[Obj.BUISGL] = "building"
        ObjStr[Obj.BUAARE] = "built-up_area"
        ObjStr[Obj.BOYCAR] = "buoy_cardinal"
        ObjStr[Obj.BOYINB] = "buoy_installation"
        ObjStr[Obj.BOYISD] = "buoy_isolated_danger"
        ObjStr[Obj.BOYLAT] = "buoy_lateral"
        ObjStr[Obj.BOYSAW] = "buoy_safe_water"
        ObjStr[Obj.BOYSPP] = "buoy_special_purpose"
        ObjStr[Obj.CBLARE] = "cable_area"
        ObjStr[Obj.CBLOHD] = "cable_overhead"
        ObjStr[Obj.CBLSUB] = "cable_submarine"
        ObjStr[Obj.CANALS] = "canal"
        ObjStr[Obj.CTSARE] = "cargo_area"
        ObjStr[Obj.CAUSWY] = "causeway"
        ObjStr[Obj.CTNARE] = "caution_area"
        ObjStr[Obj.CHKPNT] = "checkpoint"
        ObjStr[Obj.CGUSTA] = "coastguard_station"
        ObjStr[Obj.COALNE] = "coastline"
        ObjStr[Obj.CONZNE] = "contiguous_zone"
        ObjStr[Obj.COSARE] = "continental_shelf"
        ObjStr[Obj.CTRPNT] = "control_point"
        ObjStr[Obj.CONVYR] = "conveyor"
        ObjStr[Obj.CRANES] = "crane"
        ObjStr[Obj.CURENT] = "current"
        ObjStr[Obj.CUSZNE] = "custom_zone"
        ObjStr[Obj.DAMCON] = "dam"
        ObjStr[Obj.DAYMAR] = "daymark"
        ObjStr[Obj.DWRTCL] = "deep_water_route_centreline"
        ObjStr[Obj.DWRTPT] = "deep_water_route"
        ObjStr[Obj.DEPARE] = "depth_area"
        ObjStr[Obj.DEPCNT] = "depth_contour"
        ObjStr[Obj.DISMAR] = "distance_mark"
        ObjStr[Obj.DOCARE] = "dock"
        ObjStr[Obj.DRGARE] = "dredged_area"
        ObjStr[Obj.DRYDOC] = "dry_dock"
        ObjStr[Obj.DMPGRD] = "dumping_ground"
        ObjStr[Obj.DYKCON] = "dyke"
        ObjStr[Obj.EXEZNE] = "exclusive_economic_zone"
        ObjStr[Obj.FAIRWY] = "fairway"
        ObjStr[Obj.FNCLNE] = "wall"
        ObjStr[Obj.FERYRT] = "ferry_route"
        ObjStr[Obj.FSHZNE] = "fishery_zone"
        ObjStr[Obj.FSHFAC] = "fishing_facility"
        ObjStr[Obj.FSHGRD] = "fishing_ground"
        ObjStr[Obj.FLODOC] = "floating_dock"
        ObjStr[Obj.FOGSIG] = "fog_signal"
        ObjStr[Obj.FORSTC] = "fortified_structure"
        ObjStr[Obj.FRPARE] = "free_port_area"
        ObjStr[Obj.GATCON] = "gate"
        ObjStr[Obj.GRIDRN] = "gridiron"
        ObjStr[Obj.HRBARE] = "harbour_area"
        ObjStr[Obj.HRBFAC] = "harbour"
        ObjStr[Obj.HULKES] = "hulk"
        ObjStr[Obj.ICEARE] = "ice_area"
        ObjStr[Obj.ICNARE] = "incineration_zone"
        ObjStr[Obj.ISTZNE] = "inshore_traffic_zone"
        ObjStr[Obj.LAKARE] = "lake"
        ObjStr[Obj.LNDARE] = "land_area"
        ObjStr[Obj.LNDELV] = "land_elevation"
        ObjStr[Obj.LNDRGN] = "land_region"
        ObjStr[Obj.LNDMRK] = "landmark"
        ObjStr[Obj.LIGHTS] = "light"
        ObjStr[Obj.LITFLT] = "light_float"
        ObjStr[Obj.LITVES] = "light_vessel"
        ObjStr[Obj.LOCMAG] = "local_magnetic_anomaly"
        ObjStr[Obj.LOKBSN] = "lock_basin"
        ObjStr[Obj.LOGPON] = "log_pond"
        ObjStr[Obj.MAGVAR] = "magnetic_variation"
        ObjStr[Obj.MARCUL] = "marine_farm"
        ObjStr[Obj.MIPARE] = "military_area"
        ObjStr[Obj.MORFAC] = "mooring"
        ObjStr[Obj.NAVLNE] = "navigation_line"
        ObjStr[Obj.OBSTRN] = "obstruction"
        ObjStr[Obj.OFSPLF] = "platform"
        ObjStr[Obj.OSPARE] = "production_area"
        ObjStr[Obj.OILBAR] = "oil_barrier"
        ObjStr[Obj.PILPNT] = "pile"
        ObjStr[Obj.PILBOP] = "pilot_boarding"
        ObjStr[Obj.PIPARE] = "pipeline_area"
        ObjStr[Obj.PIPOHD] = "pipeline_overhead"
        ObjStr[Obj.PIPSOL] = "pipeline_submarine"
        ObjStr[Obj.PONTON] = "pontoon"
        ObjStr[Obj.PRCARE] = "precautionary_area"
        ObjStr[Obj.PRDARE] = "land_production_area"
        ObjStr[Obj.PYLONS] = "pylon"
        ObjStr[Obj.RADLNE] = "radar_line"
        ObjStr[Obj.RADRNG] = "radar_range"
        ObjStr[Obj.RADRFL] = "radar_reflector"
        ObjStr[Obj.RADSTA] = "radar_station"
        ObjStr[Obj.RTPBCN] = "radar_transponder"
        ObjStr[Obj.RDOCAL] = "calling-in_point"
        ObjStr[Obj.RDOSTA] = "radio_station"
        ObjStr[Obj.RAILWY] = "railway"
        ObjStr[Obj.RAPIDS] = "rapids"
        ObjStr[Obj.RCRTCL] = "recommended_route_centreline"
        ObjStr[Obj.RECTRC] = "recommended_track"
        ObjStr[Obj.RCTLPT] = "recommended_traffic_lane"
        ObjStr[Obj.RSCSTA] = "rescue_station"
        ObjStr[Obj.RESARE] = "restricted_area"
        ObjStr[Obj.RETRFL] = "retro_reflector"
        ObjStr[Obj.RIVERS] = "river"
        ObjStr[Obj.ROADWY] = "road"
        ObjStr[Obj.RUNWAY] = "runway"
        ObjStr[Obj.SNDWAV] = "sand_waves"
        ObjStr[Obj.SEAARE] = "sea_area"
        ObjStr[Obj.SPLARE] = "seaplane_landing_area"
        ObjStr[Obj.SBDARE] = "seabed_area"
        ObjStr[Obj.SLCONS] = "shoreline_construction"
        ObjStr[Obj.SISTAT] = "signal_station_traffic"
        ObjStr[Obj.SISTAW] = "signal_station_warning"
        ObjStr[Obj.SILTNK] = "tank"
        ObjStr[Obj.SLOTOP] = "slope_topline"
        ObjStr[Obj.SLOGRD] = "sloping_ground"
        ObjStr[Obj.SMCFAC] = "small_craft_facility"
        ObjStr[Obj.SOUNDG] = "sounding"
        ObjStr[Obj.SPRING] = "spring"
        ObjStr[Obj.STSLNE] = "territorial_baseline"
        ObjStr[Obj.SUBTLN] = "submarine_transit_lane"
        ObjStr[Obj.SWPARE] = "swept_area"
        ObjStr[Obj.TESARE] = "territorial_area"
        ObjStr[Obj.TIDEWY] = "tideway"
        ObjStr[Obj.TOPMAR] = "topmark"
        ObjStr[Obj.TSELNE] = "separation_line"
        ObjStr[Obj.TSSBND] = "separation_boundary"
        ObjStr[Obj.TSSCRS] = "separation_crossing"
        ObjStr[Obj.TSSLPT] = "separation_lane"
        ObjStr[Obj.TSSRON] = "separation_roundabout"
        ObjStr[Obj.TSEZNE] = "separation_zone"
        ObjStr[Obj.TUNNEL] = "tunnel"
        ObjStr[Obj.TWRTPT] = "two-way_route"
        ObjStr[Obj.UWTROC] = "rock"
        ObjStr[Obj.UNSARE] = "unsurveyed_area"
        ObjStr[Obj.VEGATN] = "vegetation"
        ObjStr[Obj.WATTUR] = "water_turbulence"
        ObjStr[Obj.WATFAL] = "waterfall"
        ObjStr[Obj.WEDKLP] = "weed"
        ObjStr[Obj.WRECKS] = "wreck"
        ObjStr[Obj.TS_FEB] = "tidal_stream"
        ObjStr[Obj.NOTMRK] = "notice"
        ObjStr[Obj.WTWAXS] = "waterway_axis"
        ObjStr[Obj.WTWPRF] = "waterway_profile"
        ObjStr[Obj.BUNSTA] = "bunker_station"
        ObjStr[Obj.COMARE] = "communication_area"
        ObjStr[Obj.HRBBSN] = "harbour_basin"
        ObjStr[Obj.LOKARE] = "lock_area"
        ObjStr[Obj.LKBSPT] = "lock_basin_part"
        ObjStr[Obj.PRTARE] = "port_area"
        ObjStr[Obj.REFDMP] = "refuse_dump"
        ObjStr[Obj.TERMNL] = "terminal"
        ObjStr[Obj.TRNBSN] = "turning_basin"
        ObjStr[Obj.WTWARE] = "waterway_area"
        ObjStr[Obj.WTWGAG] = "waterway_gauge"
        ObjStr[Obj.TISDGE] = "time_schedule"
        ObjStr[Obj.VEHTRF] = "vehicle_transfer"
        ObjStr[Obj.EXCNST] = "exceptional_structure"
        ObjStr[Obj.MPAARE] = "protected_area"
        ObjStr[Obj.LITMAJ] = "light_major"
        ObjStr[Obj.LITMIN] = "light_minor"
        ObjStr[Obj.M_COVR] = "coverage"
        ObjStr[Obj.M_NSYS] = "system"
    }

    private val StrObj: HashMap<String?, Obj?>? = HashMap()

    init {
        for ((key, value) in ObjStr!!) {
            if (!s57.entry.value.isEmpty()) StrObj!![s57.entry.value] = s57.entry.key
        }
    }

    fun decodeType(objl: Long): Obj? { // Convert S57 feature code to SCM object enumeration
        for (obj in ObjS57!!.keys) {
            if (ObjS57[obj]!!.toLong() == objl) return obj
        }
        for (obj in ObjIENC!!.keys) {
            if (ObjIENC[obj]!!.toLong() == objl) return obj
        }
        return Obj.UNKOBJ
    }

    fun encodeType(type: Obj?): Long { // Convert SCM object enumeration to S57 feature code
        if (ObjS57!!.containsKey(type)) return ObjS57[type] else if (ObjIENC!!.containsKey(type)) return ObjIENC[type]
        return 0
    }

    fun stringType(type: Obj?): String? { // Convert SCM object enumeration to OSM object string
        val str = ObjStr!![type]
        return str ?: ""
    }

    fun enumType(type: String?): Obj? { // Convert OSM object string to SCM object enumeration
        return if (type != null && !type.isEmpty() && StrObj!!.containsKey(type)) StrObj[type] else Obj.UNKOBJ
    }

    // CHECKSTYLE.OFF: LineLength
    enum class Obj {
        UNKOBJ, M_COVR, M_NSYS, AIRARE, ACHBRT, ACHARE, BCNCAR, BCNISD, BCNLAT, BCNSAW, BCNSPP, BERTHS, BRIDGE, BUISGL, BUAARE, BOYCAR, BOYINB, BOYISD, BOYLAT, BOYSAW, BOYSPP, CBLARE, CBLOHD, CBLSUB, CANALS, CTSARE, CAUSWY, CTNARE, CHKPNT, CGUSTA, COALNE, CONZNE, COSARE, CTRPNT, CONVYR, CRANES, CURENT, CUSZNE, DAMCON, DAYMAR, DWRTCL, DWRTPT, DEPARE, DEPCNT, DISMAR, DOCARE, DRGARE, DRYDOC, DMPGRD, DYKCON, EXEZNE, FAIRWY, FNCLNE, FERYRT, FSHZNE, FSHFAC, FSHGRD, FLODOC, FOGSIG, FORSTC, FRPARE, GATCON, GRIDRN, HRBARE, HRBFAC, HULKES, ICEARE, ICNARE, ISTZNE, LAKARE, LNDARE, LNDELV, LNDRGN, LNDMRK, LIGHTS, LITFLT, LITVES, LOCMAG, LOKBSN, LOGPON, MAGVAR, MARCUL, MIPARE, MORFAC, MPAARE, NAVLNE, OBSTRN, OFSPLF, OSPARE, OILBAR, PILPNT, PILBOP, PIPARE, PIPOHD, PIPSOL, PONTON, PRCARE, PRDARE, PYLONS, RADLNE, RADRNG, RADRFL, RADSTA, RTPBCN, RDOCAL, RDOSTA, RAILWY, RAPIDS, RCRTCL, RECTRC, RCTLPT, RSCSTA, RESARE, RETRFL, RIVERS, ROADWY, RUNWAY, SNDWAV, SEAARE, SPLARE, SBDARE, SLCONS, SISTAT, SISTAW, SILTNK, SLOTOP, SLOGRD, SMCFAC, SOUNDG, SPRING, STSLNE, SUBTLN, SWPARE, TESARE, TS_PRH, TS_PNH, TS_PAD, TS_TIS, T_HMON, T_NHMN, T_TIMS, TIDEWY, TOPMAR, TSELNE, TSSBND, TSSCRS, TSSLPT, TSSRON, TSEZNE, TUNNEL, TWRTPT, UWTROC, UNSARE, VEGATN, WATTUR, WATFAL, WEDKLP, WRECKS, TS_FEB, NOTMRK, WTWAXS, WTWPRF, BUNSTA, COMARE, HRBBSN, LOKARE, LKBSPT, PRTARE, REFDMP, TERMNL, TRNBSN, WTWARE, WTWGAG, TISDGE, VEHTRF, EXCNST, LG_SDM, LG_VSP, LITMIN, LITMAJ
    }
}