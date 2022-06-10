// License: GPL. For details, see LICENSE file.
package s57


/**
 * @author Malcolm Herring
 * @author mgrouch
 */
object S57obj {

    private val ObjS57 = mapOf(
        Obj.UNKOBJ to 0,
        Obj.AIRARE to 2,
        Obj.ACHBRT to 3,
        Obj.ACHARE to 4,
        Obj.BCNCAR to 5,
        Obj.BCNISD to 6,
        Obj.BCNLAT to 7,
        Obj.BCNSAW to 8,
        Obj.BCNSPP to 9,
        Obj.BERTHS to 10,
        Obj.BRIDGE to 11,
        Obj.BUISGL to 12,
        Obj.BUAARE to 13,
        Obj.BOYCAR to 14,
        Obj.BOYINB to 15,
        Obj.BOYISD to 16,
        Obj.BOYLAT to 17,
        Obj.BOYSAW to 18,
        Obj.BOYSPP to 19,
        Obj.CBLARE to 20,
        Obj.CBLOHD to 21,
        Obj.CBLSUB to 22,
        Obj.CANALS to 23,
        Obj.CTSARE to 25,
        Obj.CAUSWY to 26,
        Obj.CTNARE to 27,
        Obj.CHKPNT to 28,
        Obj.CGUSTA to 29,
        Obj.COALNE to 30,
        Obj.CONZNE to 31,
        Obj.COSARE to 32,
        Obj.CTRPNT to 33,
        Obj.CONVYR to 34,
        Obj.CRANES to 35,
        Obj.CURENT to 36,
        Obj.CUSZNE to 37,
        Obj.DAMCON to 38,
        Obj.DAYMAR to 39,
        Obj.DWRTCL to 40,
        Obj.DWRTPT to 41,
        Obj.DEPARE to 42,
        Obj.DEPCNT to 43,
        Obj.DISMAR to 44,
        Obj.DOCARE to 45,
        Obj.DRGARE to 46,
        Obj.DRYDOC to 47,
        Obj.DMPGRD to 48,
        Obj.DYKCON to 49,
        Obj.EXEZNE to 50,
        Obj.FAIRWY to 51,
        Obj.FNCLNE to 52,
        Obj.FERYRT to 53,
        Obj.FSHZNE to 54,
        Obj.FSHFAC to 55,
        Obj.FSHGRD to 56,
        Obj.FLODOC to 57,
        Obj.FOGSIG to 58,
        Obj.FORSTC to 59,
        Obj.FRPARE to 60,
        Obj.GATCON to 61,
        Obj.GRIDRN to 62,
        Obj.HRBARE to 63,
        Obj.HRBFAC to 64,
        Obj.HULKES to 65,
        Obj.ICEARE to 66,
        Obj.ICNARE to 67,
        Obj.ISTZNE to 68,
        Obj.LAKARE to 69,
        Obj.LNDARE to 71,
        Obj.LNDELV to 72,
        Obj.LNDRGN to 73,
        Obj.LNDMRK to 74,
        Obj.LIGHTS to 75,
        Obj.LITFLT to 76,
        Obj.LITVES to 77,
        Obj.LOCMAG to 78,
        Obj.LOKBSN to 79,
        Obj.LOGPON to 80,
        Obj.MAGVAR to 81,
        Obj.MARCUL to 82,
        Obj.MIPARE to 83,
        Obj.MORFAC to 84,
        Obj.NAVLNE to 85,
        Obj.OBSTRN to 86,
        Obj.OFSPLF to 87,
        Obj.OSPARE to 88,
        Obj.OILBAR to 89,
        Obj.PILPNT to 90,
        Obj.PILBOP to 91,
        Obj.PIPARE to 92,
        Obj.PIPOHD to 93,
        Obj.PIPSOL to 94,
        Obj.PONTON to 95,
        Obj.PRCARE to 96,
        Obj.PRDARE to 97,
        Obj.PYLONS to 98,
        Obj.RADLNE to 99,
        Obj.RADRNG to 100,
        Obj.RADRFL to 101,
        Obj.RADSTA to 102,
        Obj.RTPBCN to 103,
        Obj.RDOCAL to 104,
        Obj.RDOSTA to 105,
        Obj.RAILWY to 106,
        Obj.RAPIDS to 107,
        Obj.RCRTCL to 108,
        Obj.RECTRC to 109,
        Obj.RCTLPT to 110,
        Obj.RSCSTA to 111,
        Obj.RESARE to 112,
        Obj.RETRFL to 113,
        Obj.RIVERS to 114,
        Obj.ROADWY to 116,
        Obj.RUNWAY to 117,
        Obj.SNDWAV to 118,
        Obj.SEAARE to 119,
        Obj.SPLARE to 120,
        Obj.SBDARE to 121,
        Obj.SLCONS to 122,
        Obj.SISTAT to 123,
        Obj.SISTAW to 124,
        Obj.SILTNK to 125,
        Obj.SLOTOP to 126,
        Obj.SLOGRD to 127,
        Obj.SMCFAC to 128,
        Obj.SOUNDG to 129,
        Obj.SPRING to 130,
        Obj.STSLNE to 132,
        Obj.SUBTLN to 133,
        Obj.SWPARE to 134,
        Obj.TESARE to 135,
        Obj.TS_PRH to 136,
        Obj.TS_PNH to 137,
        Obj.TS_PAD to 138,
        Obj.TS_TIS to 139,
        Obj.T_HMON to 140,
        Obj.T_NHMN to 141,
        Obj.T_TIMS to 142,
        Obj.TIDEWY to 143,
        Obj.TOPMAR to 144,
        Obj.TSELNE to 145,
        Obj.TSSBND to 146,
        Obj.TSSCRS to 147,
        Obj.TSSLPT to 148,
        Obj.TSSRON to 149,
        Obj.TSEZNE to 150,
        Obj.TUNNEL to 151,
        Obj.TWRTPT to 152,
        Obj.UWTROC to 153,
        Obj.UNSARE to 154,
        Obj.VEGATN to 155,
        Obj.WATTUR to 156,
        Obj.WATFAL to 157,
        Obj.WEDKLP to 158,
        Obj.WRECKS to 159,
        Obj.TS_FEB to 160,
        Obj.MPAARE to 199,
        Obj.M_COVR to 302,
        Obj.M_NSYS to 306,
        Obj.LITMAJ to 74,
        Obj.LITMIN to 90,
    )

    private val ObjIENC = mapOf(
        Obj.UNKOBJ to 0,
        Obj.ACHBRT to 17000,
        Obj.ACHARE to 17001,
        Obj.DEPARE to 17003,
        Obj.DISMAR to 17004,
        Obj.RESARE to 17005,
        Obj.SISTAT to 17007,
        Obj.SISTAW to 17008,
        Obj.TOPMAR to 17009,
        Obj.BERTHS to 17010,
        Obj.BRIDGE to 17011,
        Obj.CBLOHD to 17012,
        Obj.FERYRT to 17013,
        Obj.HRBARE to 17014,
        Obj.HRBFAC to 17015,
        Obj.LOKBSN to 17016,
        Obj.RDOCAL to 17017,
        Obj.CURENT to 17019,
        Obj.HULKES to 17020,
        Obj.PONTON to 17021,
        Obj.PIPOHD to 17024,
        Obj.FLODOC to 17025,
        Obj.CHKPNT to 17027,
        Obj.BCNLAT to 17028,
        Obj.BOYLAT to 17029,
        Obj.CRANES to 17030,
        Obj.GATCON to 17031,
        Obj.SLCONS to 17032,
        Obj.UWTROC to 17033,
        Obj.CONVYR to 17034,
        Obj.NOTMRK to 17050,
        Obj.WTWAXS to 17051,
        Obj.WTWPRF to 17052,
        Obj.BUNSTA to 17054,
        Obj.COMARE to 17055,
        Obj.HRBBSN to 17056,
        Obj.LKBSPT to 17058,
        Obj.PRTARE to 17059,
        Obj.REFDMP to 17062,
        Obj.TERMNL to 17064,
        Obj.TRNBSN to 17065,
        Obj.WTWARE to 17066,
        Obj.WTWGAG to 17067,
        Obj.TISDGE to 17068,
        Obj.VEHTRF to 17069,
        Obj.EXCNST to 17070,
        Obj.LG_SDM to 18001,
        Obj.LG_VSP to 18002,
    )

    private val ObjStr = mapOf(
        Obj.UNKOBJ to "",
        Obj.AIRARE to "airfield",
        Obj.ACHBRT to "anchor_berth",
        Obj.ACHARE to "anchorage",
        Obj.BCNCAR to "beacon_cardinal",
        Obj.BCNISD to "beacon_isolated_danger",
        Obj.BCNLAT to "beacon_lateral",
        Obj.BCNSAW to "beacon_safe_water",
        Obj.BCNSPP to "beacon_special_purpose",
        Obj.BERTHS to "berth",
        Obj.BRIDGE to "bridge",
        Obj.BUISGL to "building",
        Obj.BUAARE to "built-up_area",
        Obj.BOYCAR to "buoy_cardinal",
        Obj.BOYINB to "buoy_installation",
        Obj.BOYISD to "buoy_isolated_danger",
        Obj.BOYLAT to "buoy_lateral",
        Obj.BOYSAW to "buoy_safe_water",
        Obj.BOYSPP to "buoy_special_purpose",
        Obj.CBLARE to "cable_area",
        Obj.CBLOHD to "cable_overhead",
        Obj.CBLSUB to "cable_submarine",
        Obj.CANALS to "canal",
        Obj.CTSARE to "cargo_area",
        Obj.CAUSWY to "causeway",
        Obj.CTNARE to "caution_area",
        Obj.CHKPNT to "checkpoint",
        Obj.CGUSTA to "coastguard_station",
        Obj.COALNE to "coastline",
        Obj.CONZNE to "contiguous_zone",
        Obj.COSARE to "continental_shelf",
        Obj.CTRPNT to "control_point",
        Obj.CONVYR to "conveyor",
        Obj.CRANES to "crane",
        Obj.CURENT to "current",
        Obj.CUSZNE to "custom_zone",
        Obj.DAMCON to "dam",
        Obj.DAYMAR to "daymark",
        Obj.DWRTCL to "deep_water_route_centreline",
        Obj.DWRTPT to "deep_water_route",
        Obj.DEPARE to "depth_area",
        Obj.DEPCNT to "depth_contour",
        Obj.DISMAR to "distance_mark",
        Obj.DOCARE to "dock",
        Obj.DRGARE to "dredged_area",
        Obj.DRYDOC to "dry_dock",
        Obj.DMPGRD to "dumping_ground",
        Obj.DYKCON to "dyke",
        Obj.EXEZNE to "exclusive_economic_zone",
        Obj.FAIRWY to "fairway",
        Obj.FNCLNE to "wall",
        Obj.FERYRT to "ferry_route",
        Obj.FSHZNE to "fishery_zone",
        Obj.FSHFAC to "fishing_facility",
        Obj.FSHGRD to "fishing_ground",
        Obj.FLODOC to "floating_dock",
        Obj.FOGSIG to "fog_signal",
        Obj.FORSTC to "fortified_structure",
        Obj.FRPARE to "free_port_area",
        Obj.GATCON to "gate",
        Obj.GRIDRN to "gridiron",
        Obj.HRBARE to "harbour_area",
        Obj.HRBFAC to "harbour",
        Obj.HULKES to "hulk",
        Obj.ICEARE to "ice_area",
        Obj.ICNARE to "incineration_zone",
        Obj.ISTZNE to "inshore_traffic_zone",
        Obj.LAKARE to "lake",
        Obj.LNDARE to "land_area",
        Obj.LNDELV to "land_elevation",
        Obj.LNDRGN to "land_region",
        Obj.LNDMRK to "landmark",
        Obj.LIGHTS to "light",
        Obj.LITFLT to "light_float",
        Obj.LITVES to "light_vessel",
        Obj.LOCMAG to "local_magnetic_anomaly",
        Obj.LOKBSN to "lock_basin",
        Obj.LOGPON to "log_pond",
        Obj.MAGVAR to "magnetic_variation",
        Obj.MARCUL to "marine_farm",
        Obj.MIPARE to "military_area",
        Obj.MORFAC to "mooring",
        Obj.NAVLNE to "navigation_line",
        Obj.OBSTRN to "obstruction",
        Obj.OFSPLF to "platform",
        Obj.OSPARE to "production_area",
        Obj.OILBAR to "oil_barrier",
        Obj.PILPNT to "pile",
        Obj.PILBOP to "pilot_boarding",
        Obj.PIPARE to "pipeline_area",
        Obj.PIPOHD to "pipeline_overhead",
        Obj.PIPSOL to "pipeline_submarine",
        Obj.PONTON to "pontoon",
        Obj.PRCARE to "precautionary_area",
        Obj.PRDARE to "land_production_area",
        Obj.PYLONS to "pylon",
        Obj.RADLNE to "radar_line",
        Obj.RADRNG to "radar_range",
        Obj.RADRFL to "radar_reflector",
        Obj.RADSTA to "radar_station",
        Obj.RTPBCN to "radar_transponder",
        Obj.RDOCAL to "calling-in_point",
        Obj.RDOSTA to "radio_station",
        Obj.RAILWY to "railway",
        Obj.RAPIDS to "rapids",
        Obj.RCRTCL to "recommended_route_centreline",
        Obj.RECTRC to "recommended_track",
        Obj.RCTLPT to "recommended_traffic_lane",
        Obj.RSCSTA to "rescue_station",
        Obj.RESARE to "restricted_area",
        Obj.RETRFL to "retro_reflector",
        Obj.RIVERS to "river",
        Obj.ROADWY to "road",
        Obj.RUNWAY to "runway",
        Obj.SNDWAV to "sand_waves",
        Obj.SEAARE to "sea_area",
        Obj.SPLARE to "seaplane_landing_area",
        Obj.SBDARE to "seabed_area",
        Obj.SLCONS to "shoreline_construction",
        Obj.SISTAT to "signal_station_traffic",
        Obj.SISTAW to "signal_station_warning",
        Obj.SILTNK to "tank",
        Obj.SLOTOP to "slope_topline",
        Obj.SLOGRD to "sloping_ground",
        Obj.SMCFAC to "small_craft_facility",
        Obj.SOUNDG to "sounding",
        Obj.SPRING to "spring",
        Obj.STSLNE to "territorial_baseline",
        Obj.SUBTLN to "submarine_transit_lane",
        Obj.SWPARE to "swept_area",
        Obj.TESARE to "territorial_area",
        Obj.TIDEWY to "tideway",
        Obj.TOPMAR to "topmark",
        Obj.TSELNE to "separation_line",
        Obj.TSSBND to "separation_boundary",
        Obj.TSSCRS to "separation_crossing",
        Obj.TSSLPT to "separation_lane",
        Obj.TSSRON to "separation_roundabout",
        Obj.TSEZNE to "separation_zone",
        Obj.TUNNEL to "tunnel",
        Obj.TWRTPT to "two-way_route",
        Obj.UWTROC to "rock",
        Obj.UNSARE to "unsurveyed_area",
        Obj.VEGATN to "vegetation",
        Obj.WATTUR to "water_turbulence",
        Obj.WATFAL to "waterfall",
        Obj.WEDKLP to "weed",
        Obj.WRECKS to "wreck",
        Obj.TS_FEB to "tidal_stream",
        Obj.NOTMRK to "notice",
        Obj.WTWAXS to "waterway_axis",
        Obj.WTWPRF to "waterway_profile",
        Obj.BUNSTA to "bunker_station",
        Obj.COMARE to "communication_area",
        Obj.HRBBSN to "harbour_basin",
        Obj.LOKARE to "lock_area",
        Obj.LKBSPT to "lock_basin_part",
        Obj.PRTARE to "port_area",
        Obj.REFDMP to "refuse_dump",
        Obj.TERMNL to "terminal",
        Obj.TRNBSN to "turning_basin",
        Obj.WTWARE to "waterway_area",
        Obj.WTWGAG to "waterway_gauge",
        Obj.TISDGE to "time_schedule",
        Obj.VEHTRF to "vehicle_transfer",
        Obj.EXCNST to "exceptional_structure",
        Obj.MPAARE to "protected_area",
        Obj.LITMAJ to "light_major",
        Obj.LITMIN to "light_minor",
        Obj.M_COVR to "coverage",
        Obj.M_NSYS to "system",
    )

    private val StrObj: Map<String?, Obj?> = ObjStr.entries.associate{(k,v)-> v to k}

    fun decodeType(objl: Long): Obj { // Convert S57 feature code to SCM object enumeration
        for (obj in ObjS57.keys) {
            if (ObjS57[obj]!!.toLong() == objl) return obj
        }
        for (obj in ObjIENC.keys) {
            if (ObjIENC[obj]!!.toLong() == objl) return obj
        }
        return Obj.UNKOBJ
    }

    fun encodeType(type: Obj?): Int? { // Convert SCM object enumeration to S57 feature code
        return when {
            ObjS57.containsKey(type) -> ObjS57[type]
            ObjIENC.containsKey(type) -> ObjIENC[type]
            else -> 0
        }
    }

    fun stringType(type: Obj?): String { // Convert SCM object enumeration to OSM object string
        val str = ObjStr[type]
        return str ?: ""
    }

    fun enumType(type: String?): Obj? { // Convert OSM object string to SCM object enumeration
        return if (type != null && !type.isEmpty() && StrObj.containsKey(type)) StrObj[type] else Obj.UNKOBJ
    }

    enum class Obj {
        UNKOBJ, M_COVR, M_NSYS, AIRARE, ACHBRT, ACHARE, BCNCAR, BCNISD, BCNLAT, BCNSAW, BCNSPP, BERTHS, BRIDGE,
        BUISGL, BUAARE, BOYCAR, BOYINB, BOYISD, BOYLAT, BOYSAW, BOYSPP, CBLARE, CBLOHD, CBLSUB, CANALS, CTSARE,
        CAUSWY, CTNARE, CHKPNT, CGUSTA, COALNE, CONZNE, COSARE, CTRPNT, CONVYR, CRANES, CURENT, CUSZNE, DAMCON,
        DAYMAR, DWRTCL, DWRTPT, DEPARE, DEPCNT, DISMAR, DOCARE, DRGARE, DRYDOC, DMPGRD, DYKCON, EXEZNE, FAIRWY,
        FNCLNE, FERYRT, FSHZNE, FSHFAC, FSHGRD, FLODOC, FOGSIG, FORSTC, FRPARE, GATCON, GRIDRN, HRBARE, HRBFAC,
        HULKES, ICEARE, ICNARE, ISTZNE, LAKARE, LNDARE, LNDELV, LNDRGN, LNDMRK, LIGHTS, LITFLT, LITVES, LOCMAG,
        LOKBSN, LOGPON, MAGVAR, MARCUL, MIPARE, MORFAC, MPAARE, NAVLNE, OBSTRN, OFSPLF, OSPARE, OILBAR, PILPNT,
        PILBOP, PIPARE, PIPOHD, PIPSOL, PONTON, PRCARE, PRDARE, PYLONS, RADLNE, RADRNG, RADRFL, RADSTA, RTPBCN,
        RDOCAL, RDOSTA, RAILWY, RAPIDS, RCRTCL, RECTRC, RCTLPT, RSCSTA, RESARE, RETRFL, RIVERS, ROADWY, RUNWAY,
        SNDWAV, SEAARE, SPLARE, SBDARE, SLCONS, SISTAT, SISTAW, SILTNK, SLOTOP, SLOGRD, SMCFAC, SOUNDG, SPRING,
        STSLNE, SUBTLN, SWPARE, TESARE, TS_PRH, TS_PNH, TS_PAD, TS_TIS, T_HMON, T_NHMN, T_TIMS, TIDEWY, TOPMAR,
        TSELNE, TSSBND, TSSCRS, TSSLPT, TSSRON, TSEZNE, TUNNEL, TWRTPT, UWTROC, UNSARE, VEGATN, WATTUR, WATFAL,
        WEDKLP, WRECKS, TS_FEB, NOTMRK, WTWAXS, WTWPRF, BUNSTA, COMARE, HRBBSN, LOKARE, LKBSPT, PRTARE, REFDMP,
        TERMNL, TRNBSN, WTWARE, WTWGAG, TISDGE, VEHTRF, EXCNST, LG_SDM, LG_VSP, LITMIN, LITMAJ
    }
}