// License: GPL. For details, see LICENSE file.
package s57

import java.util.*

/**
 * @author Malcolm Herring
 * @author mgrouch
 */
object S57val {
    private val Bcnshp: Map<Any, S57enum> = mapOf(
        BcnSHP.BCN_UNKN to S57enum(0, "")             ,
        BcnSHP.BCN_STAK to S57enum(1, "stake")        ,
        BcnSHP.BCN_WTHY to S57enum(2, "withy")        ,
        BcnSHP.BCN_TOWR to S57enum(3, "tower")        ,
        BcnSHP.BCN_LATT to S57enum(4, "lattice")      ,
        BcnSHP.BCN_PILE to S57enum(5, "pile")         ,
        BcnSHP.BCN_CARN to S57enum(6, "cairn")        ,
        BcnSHP.BCN_BUOY to S57enum(7, "buoyant")      ,
        BcnSHP.BCN_POLE to S57enum(1, "pole")         ,
        BcnSHP.BCN_PRCH to S57enum(1, "perch")        ,
        BcnSHP.BCN_POST to S57enum(1, "post")         ,
    )

    private val Buishp: Map<Any, S57enum> = mapOf(
        BuiSHP.BUI_UNKN to S57enum(0, "")              ,
        BuiSHP.BUI_HIRS to S57enum(5, "high-rise")     ,
        BuiSHP.BUI_PYRD to S57enum(6, "pyramid")       ,
        BuiSHP.BUI_CYLR to S57enum(7, "cylindrical")   ,
        BuiSHP.BUI_SPHR to S57enum(8, "spherical")     ,
        BuiSHP.BUI_CUBE to S57enum(9, "cubic")         ,
    )

    private val Boyshp: Map<Any, S57enum> = mapOf(
        BoySHP.BOY_UNKN to S57enum(0, "")               ,
        BoySHP.BOY_CONE to S57enum(1, "conical")        ,
        BoySHP.BOY_CAN to S57enum(2, "can")             ,
        BoySHP.BOY_SPHR to S57enum(3, "spherical")      ,
        BoySHP.BOY_PILR to S57enum(4, "pillar")         ,
        BoySHP.BOY_SPAR to S57enum(5, "spar")           ,
        BoySHP.BOY_BARL to S57enum(6, "barrel")         ,
        BoySHP.BOY_SUPR to S57enum(7, "super-buoy")     ,
        BoySHP.BOY_ICE to S57enum(8, "ice_buoy")        ,
    )

    private val Catair: Map<Any, S57enum> = mapOf(
        CatAIR.AIR_UNKN to S57enum(0, "")                     ,
        CatAIR.AIR_MILA to S57enum(1, "military")             ,
        CatAIR.AIR_CIVA to S57enum(2, "civil")                ,
        CatAIR.AIR_MILH to S57enum(3, "military_heliport")    ,
        CatAIR.AIR_CIVH to S57enum(4, "civil_heliport")       ,
        CatAIR.AIR_GLDR to S57enum(5, "glider")               ,
        CatAIR.AIR_SMLP to S57enum(6, "small_planes")         ,
        CatAIR.AIR_EMRG to S57enum(8, "emergency")            ,
    )

    private val Catach: Map<Any, S57enum> = mapOf(
        CatACH.ACH_UNKN to S57enum(0, "")                          ,
        CatACH.ACH_UNRD to S57enum(1, "unrestricted")              ,
        CatACH.ACH_DEEP to S57enum(2, "deep_water")                ,
        CatACH.ACH_TANK to S57enum(3, "tanker")                    ,
        CatACH.ACH_EXPL to S57enum(4, "explosives")                ,
        CatACH.ACH_QUAR to S57enum(5, "quarantine")                ,
        CatACH.ACH_SEAP to S57enum(6, "seaplane")                  ,
        CatACH.ACH_SMCF to S57enum(7, "small_craft")               ,
        CatACH.ACH_SMCM to S57enum(8, "small_craft_mooring")       ,
        CatACH.ACH_H24P to S57enum(9, "24_hour")                   ,
        CatACH.ACH_LTPD to S57enum(10, "limited_period")           ,
        CatACH.ACH_NPSH to S57enum(11, "non_pushing")              ,
        CatACH.ACH_DRYC to S57enum(12, "dry_cargo")                ,
        CatACH.ACH_RAFT to S57enum(13, "raft")                     ,
        CatACH.ACH_WAIT to S57enum(14, "waiting")                  ,
        CatACH.ACH_REPT to S57enum(15, "reported")                 ,
    )

    private val Catbrg: Map<Any, S57enum> = mapOf(
        CatBRG.BRG_UNKN to S57enum(0, "")                        ,
        CatBRG.BRG_FIXD to S57enum(1, "fixed")                   ,
        CatBRG.BRG_OPEN to S57enum(2, "opening")                 ,
        CatBRG.BRG_SWNG to S57enum(3, "swing")                   ,
        CatBRG.BRG_LIFT to S57enum(4, "lifting")                 ,
        CatBRG.BRG_BASC to S57enum(5, "bascule")                 ,
        CatBRG.BRG_PONT to S57enum(6, "pontoon")                 ,
        CatBRG.BRG_DRAW to S57enum(7, "drawbridge")              ,
        CatBRG.BRG_TRNS to S57enum(8, "transporter")             ,
        CatBRG.BRG_FOOT to S57enum(9, "footbridge")              ,
        CatBRG.BRG_VIAD to S57enum(10, "viaduct")                ,
        CatBRG.BRG_AQUA to S57enum(11, "aqueduct")               ,
        CatBRG.BRG_SUSP to S57enum(12, "suspension")             ,
    )

    private val Catbua: Map<Any, S57enum> = mapOf(
        CatBUA.BUA_UNKN to S57enum(0, "")                        ,
        CatBUA.BUA_URBN to S57enum(1, "urban")                   ,
        CatBUA.BUA_STTL to S57enum(2, "settlement")              ,
        CatBUA.BUA_VLLG to S57enum(3, "village")                 ,
        CatBUA.BUA_TOWN to S57enum(4, "town")                    ,
        CatBUA.BUA_CITY to S57enum(5, "city")                    ,
        CatBUA.BUA_HOLV to S57enum(6, "holiday_village")         ,
    )

    private val Catcbl: Map<Any, S57enum> = mapOf(
        CatCBL.CBL_UNKN to S57enum(0, "")                      ,
        CatCBL.CBL_POWR to S57enum(1, "power")                 ,
        CatCBL.CBL_TRNS to S57enum(3, "transmission")          ,
        CatCBL.CBL_TELE to S57enum(4, "telephone")             ,
        CatCBL.CBL_TGPH to S57enum(5, "telegraph")             ,
        CatCBL.CBL_MOOR to S57enum(6, "mooring")               ,
        CatCBL.CBL_OPTC to S57enum(7, "optical")               ,
        CatCBL.CBL_FERY to S57enum(8, "ferry")                 ,
    )

    private val Catcan: Map<Any, S57enum> = mapOf(
        CatCAN.CAN_UNKN to S57enum(0, "")                     ,
        CatCAN.CAN_TRNS to S57enum(1, "transportation")       ,
        CatCAN.CAN_DRNG to S57enum(2, "drainage")             ,
        CatCAN.CAN_IRGN to S57enum(3, "irrigation")           ,
    )

    private val Catcam: Map<Any, S57enum> = mapOf(
        CatCAM.CAM_UNKN to S57enum(0, "")                 ,
        CatCAM.CAM_NORTH to S57enum(1, "north")           ,
        CatCAM.CAM_EAST to S57enum(2, "east")             ,
        CatCAM.CAM_SOUTH to S57enum(3, "south")           ,
        CatCAM.CAM_WEST to S57enum(4, "west")             ,
    )

    private val Catchp: Map<Any, S57enum> = mapOf(
        CatCHP.CHP_UNKN to S57enum(0, "")             ,
        CatCHP.CHP_CSTM to S57enum(1, "customs")      ,
        CatCHP.CHP_BRDR to S57enum(2, "border")       ,
    )

    private val Catcoa: Map<Any, S57enum> = mapOf(
        CatCOA.COA_UNKN to S57enum(0, "")              ,
        CatCOA.COA_STEP to S57enum(1, "steep")         ,
        CatCOA.COA_FLAT to S57enum(2, "flat")          ,
        CatCOA.COA_SAND to S57enum(3, "sandy")         ,
        CatCOA.COA_STON to S57enum(4, "stony")         ,
        CatCOA.COA_SHNG to S57enum(5, "shingly")       ,
        CatCOA.COA_GLCR to S57enum(6, "glacier")       ,
        CatCOA.COA_MNGV to S57enum(7, "mangrove")      ,
        CatCOA.COA_MRSH to S57enum(8, "marshy")        ,
        CatCOA.COA_CRRF to S57enum(9, "coral_reef")    ,
        CatCOA.COA_ICE to S57enum(10, "ice")           ,
        CatCOA.COA_SHEL to S57enum(11, "shelly")       ,
    )

    private val Catctr: Map<Any, S57enum> = mapOf(
        CatCTR.CTR_UNKN to S57enum(0, "")                           ,
        CatCTR.CTR_TRGN to S57enum(1, "triangulation")              ,
        CatCTR.CTR_OBSV to S57enum(2, "observation")                ,
        CatCTR.CTR_FIXD to S57enum(3, "fixed")                      ,
        CatCTR.CTR_BMRK to S57enum(4, "benchmark")                  ,
        CatCTR.CTR_BDRY to S57enum(5, "boundary")                   ,
        CatCTR.CTR_HORM to S57enum(6, "horizontal_main")            ,
        CatCTR.CTR_HORS to S57enum(7, "horizontal_secondary")       ,
    )

    private val Catcon: Map<Any, S57enum> = mapOf(
        CatCON.CON_UNKN to S57enum(0, "")            ,
        CatCON.CAT_AERL to S57enum(1, "aerial")      ,
        CatCON.CAT_BELT to S57enum(2, "belt")        ,
    )

    private val Catcrn: Map<Any, S57enum> = mapOf(
        CatCRN.CRN_UNKN to S57enum(0, "")                ,
        CatCRN.CRN_NONS to S57enum(1, "non-specific")    ,
        CatCRN.CRN_CONT to S57enum(2, "container")       ,
        CatCRN.CRN_SHRL to S57enum(3, "sheerlegs")       ,
        CatCRN.CRN_TRAV to S57enum(4, "travelling")      ,
        CatCRN.CRN_AFRM to S57enum(5, "a-frame")         ,
        CatCRN.CRN_GLTH to S57enum(6, "goliath")         ,
    )

    private val Catdam: Map<Any, S57enum> = mapOf(
        CatDAM.DAM_UNKN to S57enum(0, "")                 ,
        CatDAM.DAM_WEIR to S57enum(1, "weir")             ,
        CatDAM.DAM_DAM to S57enum(2, "dam")               ,
        CatDAM.DAM_FLDB to S57enum(3, "flood_barrage")    ,
    )

    private val Catdis: Map<Any, S57enum> = mapOf(
        CatDIS.DIS_UNKN to S57enum(0, ""),
        CatDIS.DIS_NONI to S57enum(1, "not_installed"),
        CatDIS.DIS_POLE to S57enum(2, "pole"),
        CatDIS.DIS_BORD to S57enum(3, "board"),
        CatDIS.DIS_UKSH to S57enum(4, "unknown_shape"),
    )

    private val Catdoc: Map<Any, S57enum> = mapOf(
        CatDOC.DOC_UNKN to S57enum(0, ""),
        CatDOC.DOC_TIDL to S57enum(1, "tidal"),
        CatDOC.DOC_NTDL to S57enum(2, "non-tidal"),
    )

    private val Catdpg: Map<Any, S57enum> = mapOf(
        CatDPG.DPG_UNKN to S57enum(0, ""),
        CatDPG.DPG_GENL to S57enum(1, "general"),
        CatDPG.DPG_CHEM to S57enum(2, "chemical"),
        CatDPG.DPG_NCLR to S57enum(3, "nuclear"),
        CatDPG.DPG_EXPL to S57enum(4, "explosives"),
        CatDPG.DPG_SPIL to S57enum(5, "spoil"),
        CatDPG.DPG_VSSL to S57enum(6, "vessel"),
    )

    private val Catfnc: Map<Any, S57enum> = mapOf(
        CatFNC.FNC_UNKN to S57enum(0, ""),
        CatFNC.FNC_FENC to S57enum(1, "fence"),
        CatFNC.FNC_MUIR to S57enum(2, "muir"),
        CatFNC.FNC_HEDG to S57enum(3, "hedge"),
        CatFNC.FNC_WALL to S57enum(4, "wall"),
    )

    private val Catfry: Map<Any, S57enum> = mapOf(
        CatFRY.FRY_UNKN to S57enum(0, ""),
        CatFRY.FRY_FREE to S57enum(1, "free"),
        CatFRY.FRY_CABL to S57enum(2, "cable"),
        CatFRY.FRY_ICE to S57enum(3, "ice"),
        CatFRY.FRY_SWWR to S57enum(4, "swinging_wire"),
    )

    private val Catfif: Map<Any, S57enum> = mapOf(
        CatFIF.FIF_UNKN to S57enum(0, ""),
        CatFIF.FIF_STAK to S57enum(1, "stake"),
        CatFIF.FIF_TRAP to S57enum(2, "trap"),
        CatFIF.FIF_WEIR to S57enum(3, "weir"),
        CatFIF.FIF_TUNY to S57enum(4, "tunny"),
    )

    private val Catfog: Map<Any, S57enum> = mapOf(
        CatFOG.FOG_UNKN to S57enum(0, ""),
        CatFOG.FOG_EXPL to S57enum(1, "explosive"),
        CatFOG.FOG_DIA to S57enum(2, "diaphone"),
        CatFOG.FOG_SIRN to S57enum(3, "siren"),
        CatFOG.FOG_NAUT to S57enum(4, "nautophone"),
        CatFOG.FOG_REED to S57enum(5, "reed"),
        CatFOG.FOG_TYPH to S57enum(6, "tyfon"),
        CatFOG.FOG_BELL to S57enum(7, "bell"),
        CatFOG.FOG_WHIS to S57enum(8, "whistle"),
        CatFOG.FOG_GONG to S57enum(9, "gong"),
        CatFOG.FOG_HORN to S57enum(10, "horn"),
    )

    private val Catfor: Map<Any, S57enum> = mapOf(
        CatFOR.FOR_UNKN to S57enum(0, ""),
        CatFOR.FOR_CSTL to S57enum(1, "castle"),
        CatFOR.FOR_FORT to S57enum(2, "fort"),
        CatFOR.FOR_BTTY to S57enum(3, "battery"),
        CatFOR.FOR_BKHS to S57enum(4, "blockhouse"),
        CatFOR.FOR_MTWR to S57enum(5, "martello_tower"),
        CatFOR.FOR_RDBT to S57enum(6, "redoubt"),
    )

    private val Catgat: Map<Any, S57enum> = mapOf(
        CatGAT.GAT_UNKN to S57enum(0, ""),
        CatGAT.GAT_GNRL to S57enum(1, "general"),
        CatGAT.GAT_FLBG to S57enum(2, "flood_barrage"),
        CatGAT.GAT_CSSN to S57enum(3, "caisson"),
        CatGAT.GAT_LOCK to S57enum(4, "lock"),
        CatGAT.GAT_DYKE to S57enum(5, "dyke"),
        CatGAT.GAT_SLUC to S57enum(6, "sluice"),
    )

    private val Cathaf: Map<Any, S57enum> = mapOf(
        CatHAF.HAF_UNKN to S57enum(0, ""),
        CatHAF.HAF_RORO to S57enum(1, "roro"),
        CatHAF.HAF_FERY to S57enum(3, "ferry"),
        CatHAF.HAF_FISH to S57enum(4, "fishing"),
        CatHAF.HAF_MRNA to S57enum(5, "marina"),
        CatHAF.HAF_NAVL to S57enum(6, "naval"),
        CatHAF.HAF_TNKR to S57enum(7, "tanker"),
        CatHAF.HAF_PSGR to S57enum(8, "passenger"),
        CatHAF.HAF_YARD to S57enum(9, "shipyard"),
        CatHAF.HAF_CNTR to S57enum(10, "container"),
        CatHAF.HAF_BULK to S57enum(11, "bulk"),
        CatHAF.HAF_SYNC to S57enum(12, "syncrolift"),
        CatHAF.HAF_STCR to S57enum(13, "straddle_carrier"),
        CatHAF.HAF_LUVB to S57enum(14, "lay_up"),
        CatHAF.HAF_TMBR to S57enum(15, "timber"),
        CatHAF.HAF_REPR to S57enum(16, "service_repair"),
        CatHAF.HAF_QUAR to S57enum(17, "quarantine"),
        CatHAF.HAF_SPLN to S57enum(18, "seaplane"),
        CatHAF.HAF_CARG to S57enum(19, "cargo"),
        CatHAF.HAF_OFFS to S57enum(20, "offshore_support"),
        CatHAF.HAF_OFFS to S57enum(21, "port_support_base"),
        CatHAF.HAF_MANF to S57enum(22, "marina_no_facilities"),
    )

    private val Cathlk : Map<Any, S57enum> = mapOf(
        CatHLK.HLK_UNKN to S57enum(0, ""),
        CatHLK.HLK_REST to S57enum(1, "floating_restaurant"),
        CatHLK.HLK_HIST to S57enum(2, "historic"),
        CatHLK.HLK_MUSM to S57enum(3, "museum"),
        CatHLK.HLK_ACCM to S57enum(4, "accommodation"),
        CatHLK.HLK_BWTR to S57enum(5, "floating_breakwater"),
        CatHLK.HLK_CSNO to S57enum(6, "casino_boat"),
    )

    private val Catice : Map<Any, S57enum> = mapOf(
        CatICE.ICE_UNKN to S57enum(0, ""),
        CatICE.ICE_FAST to S57enum(1, "fast"),
        CatICE.ICE_SEA to S57enum(2, "sea"),
        CatICE.ICE_GRLR to S57enum(3, "growler"),
        CatICE.ICE_PANK to S57enum(4, "pancake"),
        CatICE.ICE_GLAS to S57enum(5, "glacier"),
        CatICE.ICE_PEAK to S57enum(6, "peak"),
        CatICE.ICE_PACK to S57enum(7, "pack"),
        CatICE.ICE_POLR to S57enum(8, "polar"),
    )

    private val Catinb : Map<Any, S57enum> = mapOf(
        CatINB.INB_UNKN to S57enum(0, ""),
        CatINB.INB_CALM to S57enum(1, "calm"),
        CatINB.INB_SBM to S57enum(2, "sbm"),
    )

    private val Catlnd : Map<Any, S57enum> = mapOf(
        CatLND.LND_UNKN to S57enum(0, ""),
        CatLND.LND_FEN to S57enum(1, "fen"),
        CatLND.LND_MRSH to S57enum(2, "marsh"),
        CatLND.LND_BOG to S57enum(3, "bog"),
        CatLND.LND_HTHL to S57enum(4, "heathland"),
        CatLND.LND_MNTN to S57enum(5, "mountain"),
        CatLND.LND_LOWL to S57enum(6, "lowlands"),
        CatLND.LND_CNYN to S57enum(7, "canyon"),
        CatLND.LND_PDDY to S57enum(8, "paddy"),
        CatLND.LND_AGRI to S57enum(9, "agricultural"),
        CatLND.LND_SVNA to S57enum(10, "savanna"),
        CatLND.LND_PARK to S57enum(11, "parkland"),
        CatLND.LND_SWMP to S57enum(12, "swamp"),
        CatLND.LND_LSLD to S57enum(13, "landslide"),
        CatLND.LND_LAVA to S57enum(14, "lava"),
        CatLND.LND_SLTP to S57enum(15, "salt_pan"),
        CatLND.LND_MORN to S57enum(16, "moraine"),
        CatLND.LND_CRTR to S57enum(17, "crater"),
        CatLND.LND_CAVE to S57enum(18, "cave"),
        CatLND.LND_PINCL to S57enum(19, "rock_pinnacle"),
        CatLND.LND_CAY to S57enum(20, "cay"),
    )

    private val Catlmk : Map<Any, S57enum> = mapOf(
        CatLMK.LMK_UNKN to S57enum(0, ""),
        CatLMK.LMK_CARN to S57enum(1, "cairn"),
        CatLMK.LMK_CMTY to S57enum(2, "cemetery"),
        CatLMK.LMK_CHMY to S57enum(3, "chimney"),
        CatLMK.LMK_DISH to S57enum(4, "dish_aerial"),
        CatLMK.LMK_FLAG to S57enum(5, "flagstaff"),
        CatLMK.LMK_FLAR to S57enum(6, "flare_stack"),
        CatLMK.LMK_MAST to S57enum(7, "mast"),
        CatLMK.LMK_WNDS to S57enum(8, "windsock"),
        CatLMK.LMK_MNMT to S57enum(9, "monument"),
        CatLMK.LMK_CLMN to S57enum(10, "column"),
        CatLMK.LMK_MEML to S57enum(11, "memorial"),
        CatLMK.LMK_OBLK to S57enum(12, "obelisk"),
        CatLMK.LMK_STAT to S57enum(13, "statue"),
        CatLMK.LMK_CROS to S57enum(14, "cross"),
        CatLMK.LMK_DOME to S57enum(15, "dome"),
        CatLMK.LMK_RADR to S57enum(16, "radar_scanner"),
        CatLMK.LMK_TOWR to S57enum(17, "tower"),
        CatLMK.LMK_WNDM to S57enum(18, "windmill"),
        CatLMK.LMK_WNDG to S57enum(19, "windmotor"),
        CatLMK.LMK_SPIR to S57enum(20, "spire"),
        CatLMK.LMK_BLDR to S57enum(21, "boulder"),
        CatLMK.LMK_TRIM to S57enum(22, "triangulation_mark"),
        CatLMK.LMK_BNDM to S57enum(23, "boundary_mark"),
        CatLMK.LMK_OBSW to S57enum(24, "observation_wheel"),
        CatLMK.LMK_TORL to S57enum(25, "toril"),
    )

    private val Catlam : Map<Any, S57enum> = mapOf(
        CatLAM.LAM_UNKN to S57enum(0, ""),
        CatLAM.LAM_PORT to S57enum(1, "port"),
        CatLAM.LAM_STBD to S57enum(2, "starboard"),
        CatLAM.LAM_PCST to S57enum(3, "preferred_channel_starboard"),
        CatLAM.LAM_PCPT to S57enum(4, "preferred_channel_port"),
        CatLAM.LAM_WWRT to S57enum(5, "waterway_right"),
        CatLAM.LAM_WWLT to S57enum(6, "waterway_left"),
        CatLAM.LAM_CHRT to S57enum(7, "channel_right"),
        CatLAM.LAM_CHLT to S57enum(8, "channel_left"),
        CatLAM.LAM_WWSN to S57enum(9, "waterway_separation"),
        CatLAM.LAM_CHSN to S57enum(10, "channel_separation"),
        CatLAM.LAM_CHRB to S57enum(11, "channel_right_bank"),
        CatLAM.LAM_CHLB to S57enum(12, "channel_left_bank"),
        CatLAM.LAM_CRRT to S57enum(13, "crossover_right"),
        CatLAM.LAM_CRLT to S57enum(14, "crossover_left"),
        CatLAM.LAM_DRLT to S57enum(15, "danger_right"),
        CatLAM.LAM_DRRT to S57enum(16, "danger_left"),
        CatLAM.LAM_TOLT to S57enum(17, "turnoff_right"),
        CatLAM.LAM_TPRT to S57enum(18, "turnoff_left"),
        CatLAM.LAM_JBRT to S57enum(19, "junction_right"),
        CatLAM.LAM_JNLT to S57enum(20, "junction_left"),
        CatLAM.LAM_HBRT to S57enum(21, "harbour_right"),
        CatLAM.LAM_HBLT to S57enum(22, "harbour_left"),
        CatLAM.LAM_BRGP to S57enum(23, "bridge_pier"),
    )

    private val Catlit : Map<Any, S57enum> = mapOf(
        CatLIT.LIT_UNKN to S57enum(0, ""),
        CatLIT.LIT_DIR to S57enum(1, "directional"),
        CatLIT.LIT_LEAD to S57enum(4, "leading"),
        CatLIT.LIT_AERO to S57enum(5, "aero"),
        CatLIT.LIT_AIR to S57enum(6, "air_obstruction"),
        CatLIT.LIT_FOG to S57enum(7, "fog_detector"),
        CatLIT.LIT_FLDL to S57enum(8, "floodlight"),
        CatLIT.LIT_STRP to S57enum(9, "strip_light"),
        CatLIT.LIT_SUBS to S57enum(10, "subsidiary"),
        CatLIT.LIT_SPOT to S57enum(11, "spotlight"),
        CatLIT.LIT_FRNT to S57enum(12, "front"),
        CatLIT.LIT_REAR to S57enum(13, "rear"),
        CatLIT.LIT_LOWR to S57enum(14, "lower"),
        CatLIT.LIT_UPPR to S57enum(15, "upper"),
        CatLIT.LIT_MOIR to S57enum(16, "moire"),
        CatLIT.LIT_EMRG to S57enum(17, "emergency"),
        CatLIT.LIT_BRNG to S57enum(18, "bearing"),
        CatLIT.LIT_HORI to S57enum(19, "horizontal"),
        CatLIT.LIT_VERT to S57enum(20, "vertical"),
    )

    private val Catmfa : Map<Any, S57enum> = mapOf(
        CatMFA.MFA_UNKN to S57enum(0, ""),
        CatMFA.MFA_CRST to S57enum(1, "crustaceans"),
        CatMFA.MFA_OYMS to S57enum(2, "oysters_mussels"),
        CatMFA.MFA_FISH to S57enum(3, "fish"),
        CatMFA.MFA_SEAW to S57enum(4, "seaweed"),
        CatMFA.MFA_PRLC to S57enum(5, "pearl_culture"),
    )

    private val Catmpa : Map<Any, S57enum> = mapOf(
        CatMPA.MPA_UNKN to S57enum(0, ""),
        CatMPA.MPA_PRCT to S57enum(1, "practice"),
        CatMPA.MPA_TRPD to S57enum(2, "torpedo"),
        CatMPA.MPA_SUBM to S57enum(3, "submarine"),
        CatMPA.MPA_FIRG to S57enum(4, "firing"),
        CatMPA.MPA_MINL to S57enum(5, "mine-laying"),
        CatMPA.MPA_SMLA to S57enum(6, "small_arms"),
    )

    private val Catmor : Map<Any, S57enum> = mapOf(
        CatMOR.MOR_UNKN to S57enum(0, ""),
        CatMOR.MOR_DLPN to S57enum(1, "dolphin"),
        CatMOR.MOR_DDPN to S57enum(2, "deviation_dolphin"),
        CatMOR.MOR_BLRD to S57enum(3, "bollard"),
        CatMOR.MOR_WALL to S57enum(4, "wall"),
        CatMOR.MOR_PILE to S57enum(5, "pile"),
        CatMOR.MOR_CHAN to S57enum(6, "chain"),
        CatMOR.MOR_BUOY to S57enum(7, "buoy"),
        CatMOR.MOR_SHRP to S57enum(8, "shore_ropes"),
        CatMOR.MOR_AUTO to S57enum(9, "automatic"),
        CatMOR.MOR_POST to S57enum(10, "post"),
        CatMOR.MOR_WIRE to S57enum(11, "wire"),
        CatMOR.MOR_CABL to S57enum(12, "cable"),
    )

    private val Catnav : Map<Any, S57enum> = mapOf(
        CatNAV.NAV_UNKN to S57enum(0, ""),
        CatNAV.NAV_CLRG to S57enum(1, "clearing"),
        CatNAV.NAV_TRST to S57enum(2, "transit"),
        CatNAV.NAV_LDNG to S57enum(3, "leading"),
    )

    private val Catobs : Map<Any, S57enum> = mapOf(
        CatOBS.OBS_UNKN to S57enum(0, ""),
        CatOBS.OBS_STMP to S57enum(1, "stump"),
        CatOBS.OBS_WELH to S57enum(2, "wellhead"),
        CatOBS.OBS_DIFF to S57enum(3, "diffuser"),
        CatOBS.OBS_CRIB to S57enum(4, "crib"),
        CatOBS.OBS_FHVN to S57enum(5, "fish_haven"),
        CatOBS.OBS_FLAR to S57enum(6, "foul_area"),
        CatOBS.OBS_FLGD to S57enum(7, "foul_ground"),
        CatOBS.OBS_ICEB to S57enum(8, "ice_boom"),
        CatOBS.OBS_GTKL to S57enum(9, "ground_tackle"),
        CatOBS.OBS_BOOM to S57enum(10, "boom"),
        CatOBS.OBS_UWTB to S57enum(11, "underwater_turbine"),
        CatOBS.OBS_TPLT to S57enum(12, "template"),
        CatOBS.OBS_WEND to S57enum(13, "wave_energy_device"),
        CatOBS.OBS_UWAS to S57enum(14, "subsurface_data"),
        CatOBS.OBS_REEF to S57enum(15, "artificial_reef"),
        CatOBS.OBS_MNFD to S57enum(16, "manifold"),
        CatOBS.OBS_PNGO to S57enum(17, "submerged_pingo"),
        CatOBS.OBS_RPLT to S57enum(18, "platform_remains"),
        CatOBS.OBS_SCII to S57enum(19, "scientific_instrument"),
    )

    private val Catofp : Map<Any, S57enum> = mapOf(
        CatOFP.OFP_UNKN to S57enum(0, ""),
        CatOFP.OFP_OIL to S57enum(1, "oil"),
        CatOFP.OFP_PROD to S57enum(2, "production"),
        CatOFP.OFP_OBS to S57enum(3, "observation"),
        CatOFP.OFP_ALP to S57enum(4, "alp"),
        CatOFP.OFP_SALM to S57enum(5, "salm"),
        CatOFP.OFP_MOOR to S57enum(6, "mooring"),
        CatOFP.OFP_AISL to S57enum(7, "artificial_island"),
        CatOFP.OFP_FPSO to S57enum(8, "fpso"),
        CatOFP.OFP_ACCN to S57enum(9, "accommodation"),
        CatOFP.OFP_NCCB to S57enum(10, "nccb"),
        CatOFP.OFP_FOTK to S57enum(11, "floating_oil_tank"),
    )

    private val Catolb : Map<Any, S57enum> = mapOf(
        CatOLB.OLB_UNKN to S57enum(0, ""),
        CatOLB.OLB_RETN to S57enum(1, "retention"),
        CatOLB.OLB_FLTG to S57enum(2, "floating"),
    )

    private val Catple : Map<Any, S57enum> = mapOf(
        CatPLE.PLE_UNKN to S57enum(0, ""),
        CatPLE.PLE_STAK to S57enum(1, "stake"),
        CatPLE.PLE_POST to S57enum(3, "post"),
        CatPLE.PLE_TRIP to S57enum(4, "tripodal"),
        CatPLE.PLE_PLNG to S57enum(5, "piling"),
        CatPLE.PLE_PARE to S57enum(6, "pile_area"),
        CatPLE.PLE_PIPE to S57enum(7, "pipe"),
    )

    private val Catpil : Map<Any, S57enum> = mapOf(
        CatPIL.PIL_UNKN to S57enum(0, ""),
        CatPIL.PIL_CVSL to S57enum(1, "cruising_vessel"),
        CatPIL.PIL_HELI to S57enum(2, "helicopter"),
        CatPIL.PIL_SHOR to S57enum(3, "from_shore"),
    )

    private val Catpip : Map<Any, S57enum> = mapOf(
        CatPIP.PIP_UNKN to S57enum(0, ""),
        CatPIP.PIP_OFAL to S57enum(2, "outfall"),
        CatPIP.PIP_ITAK to S57enum(3, "intake"),
        CatPIP.PIP_SEWR to S57enum(4, "sewer"),
        CatPIP.PIP_BBLR to S57enum(5, "bubbler"),
        CatPIP.PIP_SPPL to S57enum(6, "supply"),
    )

    private val Catpra : Map<Any, S57enum> = mapOf(
        CatPRA.PRA_UNKN to S57enum(0, ""),
        CatPRA.PRA_QRRY to S57enum(1, "quarry"),
        CatPRA.PRA_MINE to S57enum(2, "mine"),
        CatPRA.PRA_STPL to S57enum(3, "stockpile"),
        CatPRA.PRA_PSTN to S57enum(4, "power_station"),
        CatPRA.PRA_RFNY to S57enum(5, "refinery"),
        CatPRA.PRA_TYRD to S57enum(6, "timber_yard"),
        CatPRA.PRA_FACT to S57enum(7, "factory"),
        CatPRA.PRA_TFRM to S57enum(8, "tank_farm"),
        CatPRA.PRA_WFRM to S57enum(9, "wind_farm"),
        CatPRA.PRA_SLAG to S57enum(10, "slag_heap"),
        CatPRA.PRA_CURF to S57enum(11, "current_farm"),
        CatPRA.PRA_OILF to S57enum(12, "oil"),
        CatPRA.PRA_GASF to S57enum(13, "gas"),
        CatPRA.PRA_WAVE to S57enum(14, "wave_energy"),
    )

    private val Catpyl : Map<Any, S57enum> = mapOf(
        CatPYL.PYL_UNKN to S57enum(0, ""),
        CatPYL.PYL_POWR to S57enum(1, "power"),
        CatPYL.PYL_TELE to S57enum(2, "telecom"),
        CatPYL.PYL_AERL to S57enum(3, "aerial"),
        CatPYL.PYL_BRDG to S57enum(4, "bridge"),
        CatPYL.PYL_PIER to S57enum(5, "bridge_pier"),
    )

    private val Catras : Map<Any, S57enum> = mapOf(
        CatRAS.RAS_UNKN to S57enum(0, ""),
        CatRAS.RAS_SURV to S57enum(1, "surveillance"),
        CatRAS.RAS_COST to S57enum(2, "coast"),
    )

    private val Catrtb : Map<Any, S57enum> = mapOf(
        CatRTB.RTB_UNKN to S57enum(0, ""),
        CatRTB.RTB_RAMK to S57enum(1, "ramark"),
        CatRTB.RTB_RACN to S57enum(2, "racon"),
        CatRTB.RTB_LDG to S57enum(3, "leading"),
    )

    private val Catros : Map<Any, S57enum> = mapOf(
        CatROS.ROS_UNKN to S57enum(0, ""),
        CatROS.ROS_OMNI to S57enum(1, "omnidirectional"),
        CatROS.ROS_DIRL to S57enum(2, "directional"),
        CatROS.ROS_ROTP to S57enum(3, "rotating_pattern"),
        CatROS.ROS_CNSL to S57enum(4, "consol"),
        CatROS.ROS_RDF to S57enum(5, "rdf"),
        CatROS.ROS_QTA to S57enum(6, "qtg"),
        CatROS.ROS_AERO to S57enum(7, "aeronautical"),
        CatROS.ROS_DECA to S57enum(8, "decca"),
        CatROS.ROS_LORN to S57enum(9, "loran"),
        CatROS.ROS_DGPS to S57enum(10, "dgps"),
        CatROS.ROS_TORN to S57enum(11, "toran"),
        CatROS.ROS_OMGA to S57enum(12, "omega"),
        CatROS.ROS_SYLD to S57enum(13, "syledis"),
        CatROS.ROS_CHKA to S57enum(14, "chiaka"),
        CatROS.ROS_PCOM to S57enum(15, "public_communication"),
        CatROS.ROS_COMB to S57enum(16, "commercial_broadcast"),
        CatROS.ROS_FACS to S57enum(17, "facsimile"),
        CatROS.ROS_TIME to S57enum(18, "time_signal"),
        CatROS.ROS_PAIS to S57enum(19, "ais"),
        CatROS.ROS_SAIS to S57enum(20, "s-ais"),
        CatROS.ROS_VAIS to S57enum(21, "v-ais"),
        CatROS.ROS_VANC to S57enum(22, "v-ais_north_cardinal"),
        CatROS.ROS_VASC to S57enum(23, "v-ais_south_cardinal"),
        CatROS.ROS_VAEC to S57enum(24, "v-ais_east_cardinal"),
        CatROS.ROS_VAWC to S57enum(25, "v-ais_west_cardinal"),
        CatROS.ROS_VAPL to S57enum(26, "v-ais_port_lateral"),
        CatROS.ROS_VASL to S57enum(27, "v-ais_starboard_lateral"),
        CatROS.ROS_VAID to S57enum(28, "v-ais_isolated_danger"),
        CatROS.ROS_VASW to S57enum(29, "v-ais_safe_water"),
        CatROS.ROS_VASP to S57enum(30, "v-ais_special_purpose"),
        CatROS.ROS_VAWK to S57enum(31, "v-ais_wreck"),
    )

    private val Catrsc : Map<Any, S57enum> = mapOf(
        CatRSC.RSC_UNKN to S57enum(0, ""),
        CatRSC.RSC_LIFB to S57enum(1, "lifeboat"),
        CatRSC.RSC_ROKT to S57enum(2, "rocket"),
        CatRSC.RSC_LBRK to S57enum(3, "lifeboat_rocket"),
        CatRSC.RSC_RFSW to S57enum(4, "refuge_shipwrecked"),
        CatRSC.RSC_RFIT to S57enum(5, "refuge_intertidal"),
        CatRSC.RSC_LBOM to S57enum(6, "lifeboat_on_mooring"),
        CatRSC.RSC_RDIO to S57enum(7, "radio"),
        CatRSC.RSC_FSTA to S57enum(8, "first_aid"),
        CatRSC.RSC_SPLN to S57enum(9, "seaplane"),
        CatRSC.RSC_ACFT to S57enum(10, "aircraft"),
        CatRSC.RSC_STUG to S57enum(12, "tug"),
    )

    private val Catrea : Map<Any, S57enum> = mapOf(
        CatREA.REA_UNKN to S57enum(0, ""),
        CatREA.REA_SFTY to S57enum(1, "safety"),
        CatREA.REA_NANC to S57enum(2, "no_anchoring"),
        CatREA.REA_NFSH to S57enum(3, "no_fishing"),
        CatREA.REA_NATR to S57enum(4, "nature_reserve"),
        CatREA.REA_BRDS to S57enum(5, "bird_sanctuary"),
        CatREA.REA_GRSV to S57enum(6, "game_reserve"),
        CatREA.REA_SEAL to S57enum(7, "seal_sanctuary"),
        CatREA.REA_DEGR to S57enum(8, "degaussing_range"),
        CatREA.REA_MILY to S57enum(9, "military"),
        CatREA.REA_HIST to S57enum(10, "historic_wreck"),
        CatREA.REA_INST to S57enum(11, "inshore_traffic"),
        CatREA.REA_NASF to S57enum(12, "navigational_aid_safety"),
        CatREA.REA_STRD to S57enum(13, "stranding_danger"),
        CatREA.REA_MINE to S57enum(14, "minefield"),
        CatREA.REA_NDIV to S57enum(15, "no_diving"),
        CatREA.REA_TBAV to S57enum(16, "to_be_avoided"),
        CatREA.REA_PROH to S57enum(17, "prohibited"),
        CatREA.REA_SWIM to S57enum(18, "swimming"),
        CatREA.REA_WAIT to S57enum(19, "waiting"),
        CatREA.REA_RSCH to S57enum(20, "research"),
        CatREA.REA_DREG to S57enum(21, "dredging"),
        CatREA.REA_FSNC to S57enum(22, "fish_sanctuary"),
        CatREA.REA_ERES to S57enum(23, "ecological_reserve"),
        CatREA.REA_NWAK to S57enum(24, "no_wake"),
        CatREA.REA_SWNG to S57enum(25, "swinging"),
        CatREA.REA_WSKI to S57enum(26, "water_skiing"),
        CatREA.REA_ESSA to S57enum(27, "environmentally_sensitive"),
        CatREA.REA_PSSA to S57enum(28, "particularly_sensitive"),
        CatREA.REA_DISA to S57enum(29, "disengagement"),
        CatREA.REA_PSAR to S57enum(30, "port_security"),
        CatREA.REA_CRLS to S57enum(31, "coral_sactuary"),
    )

    private val Catrod : Map<Any, S57enum> = mapOf(
        CatROD.ROD_UNKN to S57enum(0, ""),
        CatROD.ROD_MWAY to S57enum(1, "motorway"),
        CatROD.ROD_MAJR to S57enum(2, "major_road"),
        CatROD.ROD_MINR to S57enum(3, "minor_road"),
        CatROD.ROD_TRAK to S57enum(4, "track"),
        CatROD.ROD_MAJS to S57enum(5, "major_street"),
        CatROD.ROD_MINS to S57enum(6, "minor_street"),
        CatROD.ROD_CRSG to S57enum(7, "crossing"),
        CatROD.ROD_PATH to S57enum(8, "path"),
    )

    private val Catrun : Map<Any, S57enum> = mapOf(
        CatRUN.RUN_UNKN to S57enum(0, ""),
        CatRUN.RUN_AERP to S57enum(1, "aeroplane"),
        CatRUN.RUN_HELI to S57enum(2, "helicopter"),
    )

    private val Catsea : Map<Any, S57enum> = mapOf(
        CatSEA.SEA_UNKN to S57enum(0, ""),
        CatSEA.SEA_GENL to S57enum(1, "general"),
        CatSEA.SEA_GAT to S57enum(2, "gat"),
        CatSEA.SEA_BANK to S57enum(3, "bank"),
        CatSEA.SEA_DEEP to S57enum(4, "deep"),
        CatSEA.SEA_BAY to S57enum(5, "bay"),
        CatSEA.SEA_TRCH to S57enum(6, "trench"),
        CatSEA.SEA_BASN to S57enum(7, "basin"),
        CatSEA.SEA_MDFT to S57enum(8, "flat"),
        CatSEA.SEA_REEF to S57enum(9, "reef"),
        CatSEA.SEA_LEDG to S57enum(10, "ledge"),
        CatSEA.SEA_CNYN to S57enum(11, "canyon"),
        CatSEA.SEA_NRRW to S57enum(12, "narrows"),
        CatSEA.SEA_SHOL to S57enum(13, "shoal"),
        CatSEA.SEA_KNOL to S57enum(14, "knoll"),
        CatSEA.SEA_RIDG to S57enum(15, "ridge"),
        CatSEA.SEA_SMNT to S57enum(16, "seamount"),
        CatSEA.SEA_PNCL to S57enum(17, "pinnacle"),
        CatSEA.SEA_APLN to S57enum(18, "abyssal_plain"),
        CatSEA.SEA_PLTU to S57enum(19, "plateau"),
        CatSEA.SEA_SPUR to S57enum(20, "spur"),
        CatSEA.SEA_SHLF to S57enum(21, "shelf"),
        CatSEA.SEA_TRGH to S57enum(22, "trough"),
        CatSEA.SEA_SDDL to S57enum(23, "saddle"),
        CatSEA.SEA_AHLL to S57enum(24, "abyssal_hills"),
        CatSEA.SEA_APRN to S57enum(25, "apron"),
        CatSEA.SEA_AAPN to S57enum(26, "archipelagic_apron"),
        CatSEA.SEA_BLND to S57enum(27, "borderland"),
        CatSEA.SEA_CMGN to S57enum(28, "continental_margin"),
        CatSEA.SEA_CRIS to S57enum(29, "continental_rise"),
        CatSEA.SEA_ESCT to S57enum(30, "escarpment"),
        CatSEA.SEA_FAN to S57enum(31, "fan"),
        CatSEA.SEA_FZON to S57enum(32, "fracture_zone"),
        CatSEA.SEA_GAP to S57enum(33, "gap"),
        CatSEA.SEA_GUYT to S57enum(34, "guyot"),
        CatSEA.SEA_HILL to S57enum(35, "hill"),
        CatSEA.SEA_HOLE to S57enum(36, "hole"),
        CatSEA.SEA_LEVE to S57enum(37, "levee"),
        CatSEA.SEA_MVLY to S57enum(38, "median_valley"),
        CatSEA.SEA_MOAT to S57enum(39, "moat"),
        CatSEA.SEA_MTNS to S57enum(40, "mountains"),
        CatSEA.SEA_PEAK to S57enum(41, "peak"),
        CatSEA.SEA_PVNC to S57enum(42, "province"),
        CatSEA.SEA_RISE to S57enum(43, "rise"),
        CatSEA.SEA_SCNL to S57enum(44, "sea_channel"),
        CatSEA.SEA_SCHN to S57enum(45, "seamount_chain"),
        CatSEA.SEA_SEDG to S57enum(46, "shelf-edge"),
        CatSEA.SEA_SILL to S57enum(47, "sill"),
        CatSEA.SEA_SLOP to S57enum(48, "slope"),
        CatSEA.SEA_TRRC to S57enum(49, "terrace"),
        CatSEA.SEA_VLLY to S57enum(50, "valley"),
        CatSEA.SEA_CANL to S57enum(51, "canal"),
        CatSEA.SEA_LAKE to S57enum(52, "lake"),
        CatSEA.SEA_RIVR to S57enum(53, "river"),
        CatSEA.SEA_RECH to S57enum(54, "reach"),
    )

    private val Catslc : Map<Any, S57enum> = mapOf(
        CatSLC.SLC_UNKN to S57enum(0, ""),
        CatSLC.SLC_BWTR to S57enum(1, "breakwater"),
        CatSLC.SLC_GRYN to S57enum(2, "groyne"),
        CatSLC.SLC_MOLE to S57enum(3, "mole"),
        CatSLC.SLC_PIER to S57enum(4, "pier"),
        CatSLC.SLC_PPER to S57enum(5, "promenade_pier"),
        CatSLC.SLC_WHRF to S57enum(6, "wharf"),
        CatSLC.SLC_TWAL to S57enum(7, "training_wall"),
        CatSLC.SLC_RPRP to S57enum(8, "rip_rap"),
        CatSLC.SLC_RVMT to S57enum(9, "revetment"),
        CatSLC.SLC_SWAL to S57enum(10, "sea_wall"),
        CatSLC.SLC_LSTP to S57enum(11, "landing_steps"),
        CatSLC.SLC_RAMP to S57enum(12, "ramp"),
        CatSLC.SLC_SWAY to S57enum(13, "slipway"),
        CatSLC.SLC_FNDR to S57enum(14, "fender"),
        CatSLC.SLC_SFWF to S57enum(15, "solid_face_wharf"),
        CatSLC.SLC_OFWF to S57enum(16, "open_face_wharf"),
        CatSLC.SLC_LRMP to S57enum(17, "log_ramp"),
        CatSLC.SLC_LWAL to S57enum(18, "lock_wall"),
        CatSLC.SLC_ICEB to S57enum(18, "ice_breaker"),
    )

    private val Catsit : Map<Any, S57enum> = mapOf(
        CatSIT.SIT_UNKN to S57enum(0, ""),
        CatSIT.SIT_PRTC to S57enum(1, "port_control"),
        CatSIT.SIT_PRTE to S57enum(2, "port_entry_departure"),
        CatSIT.SIT_IPT to S57enum(3, "ipt"),
        CatSIT.SIT_BRTH to S57enum(4, "berthing"),
        CatSIT.SIT_DOCK to S57enum(5, "dock"),
        CatSIT.SIT_LOCK to S57enum(6, "lock"),
        CatSIT.SIT_FLDB to S57enum(7, "flood_barrage"),
        CatSIT.SIT_BRDG to S57enum(8, "bridge_passage"),
        CatSIT.SIT_DRDG to S57enum(9, "dredging"),
        CatSIT.SIT_TCLT to S57enum(10, "traffic_control"),
        CatSIT.SIT_PLTG to S57enum(11, "pilotage"),
        CatSIT.SIT_SPCL to S57enum(12, "special"),
        CatSIT.SIT_ONCT to S57enum(13, "oncoming_traffic"),
    )

    private val Catsiw : Map<Any, S57enum> = mapOf(
        CatSIW.SIW_UNKN to S57enum(0, ""),
        CatSIW.SIW_DNGR to S57enum(1, "danger"),
        CatSIW.SIW_OBST to S57enum(2, "maritime_obstruction"),
        CatSIW.SIW_CABL to S57enum(3, "cable"),
        CatSIW.SIW_MILY to S57enum(4, "military"),
        CatSIW.SIW_DSTR to S57enum(5, "distress"),
        CatSIW.SIW_WTHR to S57enum(6, "weather"),
        CatSIW.SIW_STRM to S57enum(7, "storm"),
        CatSIW.SIW_ICE to S57enum(8, "ice"),
        CatSIW.SIW_TIME to S57enum(9, "time"),
        CatSIW.SIW_TIDE to S57enum(10, "tide"),
        CatSIW.SIW_TSTR to S57enum(11, "tidal_stream"),
        CatSIW.SIW_TIDG to S57enum(12, "tide_gauge"),
        CatSIW.SIW_TIDS to S57enum(13, "tide_scale"),
        CatSIW.SIW_DIVE to S57enum(14, "diving"),
        CatSIW.SIW_WTLG to S57enum(15, "water_level_gauge"),
        CatSIW.SIW_VRCL to S57enum(16, "vertical_clearance"),
        CatSIW.SIW_HIWM to S57enum(17, "high_water"),
        CatSIW.SIW_DPTH to S57enum(18, "depth"),
        CatSIW.SIW_CURR to S57enum(19, "current"),
    )

    private val Catsil : Map<Any, S57enum> = mapOf(
        CatSIL.SIL_UNKN to S57enum(0, ""),
        CatSIL.SIL_SILO to S57enum(1, "silo"),
        CatSIL.SIL_TANK to S57enum(2, "tank"),
        CatSIL.SIL_GRNE to S57enum(3, "grain_elevator"),
        CatSIL.SIL_WTRT to S57enum(4, "water_tower"),
    )

    private val Catslo : Map<Any, S57enum> = mapOf(
        CatSLO.SLO_UNKN to S57enum(0, ""),
        CatSLO.SLO_CUTG to S57enum(1, "cutting"),
        CatSLO.SLO_EMBK to S57enum(2, "embankment"),
        CatSLO.SLO_DUNE to S57enum(3, "dune"),
        CatSLO.SLO_HILL to S57enum(4, "hill"),
        CatSLO.SLO_PINO to S57enum(5, "pingo"),
        CatSLO.SLO_CLIF to S57enum(6, "cliff"),
        CatSLO.SLO_SCRE to S57enum(7, "scree"),
    )

    private val Catscf : Map<Any, S57enum> = mapOf(
        CatSCF.SCF_UNKN to S57enum(0, ""),
        CatSCF.SCF_VBTH to S57enum(1, "visitor_berth"),
        CatSCF.SCF_CLUB to S57enum(2, "nautical_club"),
        CatSCF.SCF_BHST to S57enum(3, "boat_hoist"),
        CatSCF.SCF_SMKR to S57enum(4, "sailmaker"),
        CatSCF.SCF_BTYD to S57enum(5, "boatyard"),
        CatSCF.SCF_INN to S57enum(6, "public_inn"),
        CatSCF.SCF_RSRT to S57enum(7, "restaurant"),
        CatSCF.SCF_CHDR to S57enum(8, "chandler"),
        CatSCF.SCF_PROV to S57enum(9, "provisions"),
        CatSCF.SCF_DCTR to S57enum(10, "doctor"),
        CatSCF.SCF_PHRM to S57enum(11, "pharmacy"),
        CatSCF.SCF_WTRT to S57enum(12, "water_tap"),
        CatSCF.SCF_FUEL to S57enum(13, "fuel_station"),
        CatSCF.SCF_ELEC to S57enum(14, "electricity"),
        CatSCF.SCF_BGAS to S57enum(15, "bottle_gas"),
        CatSCF.SCF_SHWR to S57enum(16, "showers"),
        CatSCF.SCF_LAUN to S57enum(17, "laundrette"),
        CatSCF.SCF_WC to S57enum(18, "toilets"),
        CatSCF.SCF_POST to S57enum(19, "post_box"),
        CatSCF.SCF_TELE to S57enum(20, "telephone"),
        CatSCF.SCF_REFB to S57enum(21, "refuse_bin"),
        CatSCF.SCF_CARP to S57enum(22, "car_park"),
        CatSCF.SCF_BTPK to S57enum(23, "boat_trailers_park"),
        CatSCF.SCF_CRVN to S57enum(24, "caravan_site"),
        CatSCF.SCF_CAMP to S57enum(25, "camping_site"),
        CatSCF.SCF_PMPO to S57enum(26, "pump-out"),
        CatSCF.SCF_EMRT to S57enum(27, "emergency_telephone"),
        CatSCF.SCF_SLPW to S57enum(28, "slipway"),
        CatSCF.SCF_VMOR to S57enum(29, "visitors_mooring"),
        CatSCF.SCF_SCRB to S57enum(30, "scrubbing_berth"),
        CatSCF.SCF_PCNC to S57enum(31, "picnic_area"),
        CatSCF.SCF_MECH to S57enum(32, "mechanics_workshop"),
        CatSCF.SCF_SECS to S57enum(33, "security_service"),
    )

    private val Catspm : Map<Any, S57enum> = mapOf(
        CatSPM.SPM_UNKN to S57enum(0, ""),
        CatSPM.SPM_FDGA to S57enum(1, "firing_danger_area"),
        CatSPM.SPM_TRGT to S57enum(2, "target"),
        CatSPM.SPM_MSHP to S57enum(3, "marker_ship"),
        CatSPM.SPM_DGRG to S57enum(4, "degaussing_range"),
        CatSPM.SPM_BARG to S57enum(5, "barge"),
        CatSPM.SPM_CABL to S57enum(6, "cable"),
        CatSPM.SPM_SPLG to S57enum(7, "spoil_ground"),
        CatSPM.SPM_OFAL to S57enum(8, "outfall"),
        CatSPM.SPM_ODAS to S57enum(9, "odas"),
        CatSPM.SPM_RCDG to S57enum(10, "recording"),
        CatSPM.SPM_SPLA to S57enum(11, "seaplane_anchorage"),
        CatSPM.SPM_RCZN to S57enum(12, "recreation_zone"),
        CatSPM.SPM_PRVT to S57enum(13, "private"),
        CatSPM.SPM_MOOR to S57enum(14, "mooring"),
        CatSPM.SPM_LNBY to S57enum(15, "lanby"),
        CatSPM.SPM_LDNG to S57enum(16, "leading"),
        CatSPM.SPM_MDST to S57enum(17, "measured_distance"),
        CatSPM.SPM_NOTC to S57enum(18, "notice"),
        CatSPM.SPM_TSS to S57enum(19, "tss"),
        CatSPM.SPM_NANC to S57enum(20, "no_anchoring"),
        CatSPM.SPM_NBRT to S57enum(21, "no_berthing"),
        CatSPM.SPM_NOTK to S57enum(22, "no_overtaking"),
        CatSPM.SPM_NTWT to S57enum(23, "no_two-way_traffic"),
        CatSPM.SPM_RWAK to S57enum(24, "reduced_wake"),
        CatSPM.SPM_SPDL to S57enum(25, "speed_limit"),
        CatSPM.SPM_STOP to S57enum(26, "stop"),
        CatSPM.SPM_WRNG to S57enum(27, "warning"),
        CatSPM.SPM_SSSN to S57enum(28, "sound_ship_siren"),
        CatSPM.SPM_RVCL to S57enum(29, "restricted_vertical_clearance"),
        CatSPM.SPM_MVDT to S57enum(30, "maximum_vessel_draught"),
        CatSPM.SPM_RHCL to S57enum(31, "restricted_horizontal_clearance"),
        CatSPM.SPM_SCNT to S57enum(32, "strong_current"),
        CatSPM.SPM_BRTH to S57enum(33, "berthing"),
        CatSPM.SPM_OHPC to S57enum(34, "overhead_power_cable"),
        CatSPM.SPM_CHEG to S57enum(35, "channel_edge_gradient"),
        CatSPM.SPM_TELE to S57enum(36, "telephone"),
        CatSPM.SPM_FCRS to S57enum(37, "ferry_crossing"),
        CatSPM.SPM_MTRL to S57enum(38, "marine_traffic_lights"),
        CatSPM.SPM_PLIN to S57enum(39, "pipeline"),
        CatSPM.SPM_ANCH to S57enum(40, "anchorage"),
        CatSPM.SPM_CLRG to S57enum(41, "clearing"),
        CatSPM.SPM_CTRL to S57enum(42, "control"),
        CatSPM.SPM_DIVG to S57enum(43, "diving"),
        CatSPM.SPM_RBCN to S57enum(44, "refuge_beacon"),
        CatSPM.SPM_FGND to S57enum(45, "foul_ground"),
        CatSPM.SPM_YCHT to S57enum(46, "yachting"),
        CatSPM.SPM_HPRT to S57enum(47, "heliport"),
        CatSPM.SPM_GPS to S57enum(48, "gps"),
        CatSPM.SPM_SLDG to S57enum(49, "seaplane_landing"),
        CatSPM.SPM_NENT to S57enum(50, "no_entry"),
        CatSPM.SPM_WRKP to S57enum(51, "work_in_progress"),
        CatSPM.SPM_UKPP to S57enum(52, "unknown_purpose"),
        CatSPM.SPM_WELH to S57enum(53, "wellhead"),
        CatSPM.SPM_CHSP to S57enum(54, "channel_separation"),
        CatSPM.SPM_MFRM to S57enum(55, "marine_farm"),
        CatSPM.SPM_AREF to S57enum(56, "artificial_reef"),
    )

    private val Cattrk : Map<Any, S57enum> = mapOf(
        CatTRK.TRK_UNKN to S57enum(0, ""),
        CatTRK.TRK_FIXM to S57enum(1, "fixed_marks"),
        CatTRK.TRK_NFXM to S57enum(2, "no_fixed_marks"),
    )

    private val Cattss : Map<Any, S57enum> = mapOf(
        CatTSS.TSS_UNKN to S57enum(0, ""),
        CatTSS.TSS_IMOA to S57enum(1, "imo_adopted"),
        CatTSS.TSS_NIMO to S57enum(2, "not_imo_adopted"),
    )

    private val Catveg : Map<Any, S57enum> = mapOf(
        CatVEG.VEG_UNKN to S57enum(0, ""),
        CatVEG.VEG_GRAS to S57enum(1, "grass"),
        CatVEG.VEG_PDDY to S57enum(2, "paddy"),
        CatVEG.VEG_BUSH to S57enum(3, "bush"),
        CatVEG.VEG_DCDW to S57enum(4, "deciduous_wood"),
        CatVEG.VEG_CONW to S57enum(5, "coniferous_wood"),
        CatVEG.VEG_WOOD to S57enum(6, "wood"),
        CatVEG.VEG_MGRV to S57enum(7, "mangroves"),
        CatVEG.VEG_PARK to S57enum(8, "park"),
        CatVEG.VEG_PKLD to S57enum(9, "parkland"),
        CatVEG.VEG_MCRP to S57enum(10, "mixed_crops"),
        CatVEG.VEG_REED to S57enum(11, "reed"),
        CatVEG.VEG_MOSS to S57enum(12, "moss"),
        CatVEG.VEG_TREE to S57enum(13, "tree"),
        CatVEG.VEG_EVGT to S57enum(14, "evergreen_tree"),
        CatVEG.VEG_CONT to S57enum(15, "coniferous_tree"),
        CatVEG.VEG_PLMT to S57enum(16, "palm_tree"),
        CatVEG.VEG_NPMT to S57enum(17, "nipa_palm_tree"),
        CatVEG.VEG_CSAT to S57enum(18, "casuarina_tree"),
        CatVEG.VEG_EUCT to S57enum(19, "eucalypt_tree"),
        CatVEG.VEG_DCDT to S57enum(20, "deciduous_tree"),
        CatVEG.VEG_MRVT to S57enum(21, "mangrove_tree"),
        CatVEG.VEG_FLOT to S57enum(22, "filao_tree"),
    )

    private val Catwat : Map<Any, S57enum> = mapOf(
        CatWAT.WAT_UNKN to S57enum(0, ""),
        CatWAT.WAT_BKRS to S57enum(1, "breakers"),
        CatWAT.WAT_EDDY to S57enum(2, "eddies"),
        CatWAT.WAT_OVFL to S57enum(3, "overfalls"),
        CatWAT.WAT_TDRP to S57enum(4, "tide_rips"),
        CatWAT.WAT_BMBR to S57enum(5, "bombora"),
    )

    private val Catwed : Map<Any, S57enum> = mapOf(
        CatWED.WED_UNKN to S57enum(0, ""),
        CatWED.WED_KELP to S57enum(1, "kelp"),
        CatWED.WED_SWED to S57enum(2, "sea_weed"),
        CatWED.WED_SGRS to S57enum(3, "sea_grass"),
        CatWED.WED_SGSO to S57enum(4, "sargasso"),
    )

    private val Catwrk : Map<Any, S57enum> = mapOf(
        CatWRK.WRK_UNKN to S57enum(0, ""),
        CatWRK.WRK_NDGR to S57enum(1, "non-dangerous"),
        CatWRK.WRK_DNGR to S57enum(2, "dangerous"),
        CatWRK.WRK_DREM to S57enum(3, "distributed_remains"),
        CatWRK.WRK_MSTS to S57enum(4, "mast_showing"),
        CatWRK.WRK_HULS to S57enum(5, "hull_showing"),
    )

    private val Catzoc : Map<Any, S57enum> = mapOf(
        CatZOC.ZOC_UNKN to S57enum(0, ""),
        CatZOC.ZOC_A1 to S57enum(1, "a1"),
        CatZOC.ZOC_A2 to S57enum(2, "a2"),
        CatZOC.ZOC_B to S57enum(3, "b"),
        CatZOC.ZOC_C to S57enum(4, "c"),
        CatZOC.ZOC_D to S57enum(5, "d"),
        CatZOC.ZOC_U to S57enum(6, "u"),
    )

    private val Colour : Map<Any, S57enum> = mapOf(
        ColCOL.COL_UNK to S57enum(0, ""),
        ColCOL.COL_WHT to S57enum(1, "white"),
        ColCOL.COL_BLK to S57enum(2, "black"),
        ColCOL.COL_RED to S57enum(3, "red"),
        ColCOL.COL_GRN to S57enum(4, "green"),
        ColCOL.COL_BLU to S57enum(5, "blue"),
        ColCOL.COL_YEL to S57enum(6, "yellow"),
        ColCOL.COL_GRY to S57enum(7, "grey"),
        ColCOL.COL_BRN to S57enum(8, "brown"),
        ColCOL.COL_AMB to S57enum(9, "amber"),
        ColCOL.COL_VIO to S57enum(10, "violet"),
        ColCOL.COL_ORG to S57enum(11, "orange"),
        ColCOL.COL_MAG to S57enum(12, "magenta"),
        ColCOL.COL_PNK to S57enum(13, "pink"),
    )

    private val Colpat : Map<Any, S57enum> = mapOf(
        ColPAT.PAT_UNKN to S57enum(0, ""),
        ColPAT.PAT_HORI to S57enum(1, "horizontal"),
        ColPAT.PAT_VERT to S57enum(2, "vertical"),
        ColPAT.PAT_DIAG to S57enum(3, "diagonal"),
        ColPAT.PAT_SQUR to S57enum(4, "squared"),
        ColPAT.PAT_STRP to S57enum(5, "stripes"),
        ColPAT.PAT_BRDR to S57enum(6, "border"),
        ColPAT.PAT_CROS to S57enum(7, "cross"),
        ColPAT.PAT_SALT to S57enum(8, "saltire"),
    )

    private val Condtn : Map<Any, S57enum> = mapOf(
        CndCND.CND_UNKN to S57enum(0, ""),
        CndCND.CND_UCNS to S57enum(1, "under_construction"),
        CndCND.CND_RUIN to S57enum(2, "ruined"),
        CndCND.CND_URCL to S57enum(3, "under_reclamation"),
        CndCND.CND_WLES to S57enum(4, "wingless"),
        CndCND.CND_PCNS to S57enum(5, "planned_construction"),
    )

    private val Conrad : Map<Any, S57enum> = mapOf(
        ConRAD.RAD_UNKN to S57enum(0, ""),
        ConRAD.RAD_CNSP to S57enum(1, "conspicuous"),
        ConRAD.RAD_NCSP to S57enum(2, "not_conspicuous"),
        ConRAD.RAD_REFL to S57enum(3, "reflector"),
    )

    private val Convis : Map<Any, S57enum> = mapOf(
        ConVIS.VIS_UNKN to S57enum(0, ""),
        ConVIS.VIS_CNSP to S57enum(1, "conspicuous"),
        ConVIS.VIS_NCSP to S57enum(2, "not_conspicuous"),
    )

    private val Dunits : Map<Any, S57enum> = mapOf(
        UniDPU.DPU_UNKN to S57enum(0, ""),
        UniDPU.DPU_METR to S57enum(1, "metres"),
        UniDPU.DPU_FTFT to S57enum(2, "fathoms_feet"),
        UniDPU.DPU_FTHM to S57enum(3, "fathoms"),
        UniDPU.DPU_FTFR to S57enum(4, "fathoms_fractions"),
    )

    private val Exclit : Map<Any, S57enum> = mapOf(
        ExcLIT.EXH_UNKN to S57enum(0, ""),
        ExcLIT.EXH_24H to S57enum(1, "24h"),
        ExcLIT.EXH_DAY to S57enum(2, "day"),
        ExcLIT.EXH_FOG to S57enum(3, "fog"),
        ExcLIT.EXH_NGHT to S57enum(4, "night"),
        ExcLIT.EXH_WRNG to S57enum(5, "warning"),
        ExcLIT.EXH_STRM to S57enum(6, "storm"),
    )

    private val Expsou : Map<Any, S57enum> = mapOf(
        ExpSOU.EXP_UNKN to S57enum(0, ""),
        ExpSOU.EXP_WTHN to S57enum(1, "within"),
        ExpSOU.EXP_SHLR to S57enum(2, "shoaler"),
        ExpSOU.EXP_DEPR to S57enum(3, "deeper"),
    )

    private val Functn : Map<Any, S57enum> = mapOf(
        FncFNC.FNC_UNKN to S57enum(0, ""),
        FncFNC.FNC_HBRM to S57enum(2, "harbour_master"),
        FncFNC.FNC_CSTM to S57enum(3, "customs"),
        FncFNC.FNC_HLTH to S57enum(4, "health"),
        FncFNC.FNC_HOSP to S57enum(5, "hospital"),
        FncFNC.FNC_POST to S57enum(6, "post_office"),
        FncFNC.FNC_HOTL to S57enum(7, "hotel"),
        FncFNC.FNC_RAIL to S57enum(8, "railway_station"),
        FncFNC.FNC_POLC to S57enum(9, "police_station"),
        FncFNC.FNC_WPOL to S57enum(10, "water-police_station"),
        FncFNC.FNC_PILO to S57enum(11, "pilot_office"),
        FncFNC.FNC_PILL to S57enum(12, "pilot_lookout"),
        FncFNC.FNC_BANK to S57enum(13, "bank"),
        FncFNC.FNC_DIST to S57enum(14, "district_control"),
        FncFNC.FNC_TRNS to S57enum(15, "transit_shed"),
        FncFNC.FNC_FCTY to S57enum(16, "factory"),
        FncFNC.FNC_POWR to S57enum(17, "power_station"),
        FncFNC.FNC_ADMIN to S57enum(18, "administrative"),
        FncFNC.FNC_EDUC to S57enum(19, "educational"),
        FncFNC.FNC_CHCH to S57enum(20, "church"),
        FncFNC.FNC_CHPL to S57enum(21, "chapel"),
        FncFNC.FNC_TMPL to S57enum(22, "temple"),
        FncFNC.FNC_PGDA to S57enum(23, "pagoda"),
        FncFNC.FNC_SHSH to S57enum(24, "shinto_shrine"),
        FncFNC.FNC_BTMP to S57enum(25, "buddhist_temple"),
        FncFNC.FNC_MOSQ to S57enum(26, "mosque"),
        FncFNC.FNC_MRBT to S57enum(27, "marabout"),
        FncFNC.FNC_LOOK to S57enum(28, "lookout"),
        FncFNC.FNC_COMM to S57enum(29, "communication"),
        FncFNC.FNC_TV to S57enum(30, "television"),
        FncFNC.FNC_RADO to S57enum(31, "radio"),
        FncFNC.FNC_RADR to S57enum(32, "radar"),
        FncFNC.FNC_LGHT to S57enum(33, "light_support"),
        FncFNC.FNC_MCWV to S57enum(34, "microwave"),
        FncFNC.FNC_COOL to S57enum(35, "cooling"),
        FncFNC.FNC_OBS to S57enum(36, "observation"),
        FncFNC.FNC_TMBL to S57enum(37, "time_ball"),
        FncFNC.FNC_CLOK to S57enum(38, "clock"),
        FncFNC.FNC_CTRL to S57enum(39, "control"),
        FncFNC.FNC_ASHM to S57enum(40, "airship_mooring"),
        FncFNC.FNC_STAD to S57enum(41, "stadium"),
        FncFNC.FNC_BUSS to S57enum(42, "bus_station"),
        FncFNC.FNC_PTRM to S57enum(43, "passenger_terminal"),
        FncFNC.FNC_SRCT to S57enum(44, "sea_rescue_control"),
        FncFNC.FNC_OBSV to S57enum(45, "observatory"),
        FncFNC.FNC_OREC to S57enum(46, "ore_crusher"),
        FncFNC.FNC_BTHS to S57enum(47, "boathouse"),
        FncFNC.FNC_PMPS to S57enum(48, "pumping_station"),
    )

    private val Hunits : Map<Any, S57enum> = mapOf(
        UniHLU.HLU_UNKN to S57enum(0, ""),
        UniHLU.HLU_METR to S57enum(1, "metres"),
        UniHLU.HLU_FEET to S57enum(2, "feet"),
        UniHLU.HLU_KMTR to S57enum(3, "kilometres"),
        UniHLU.HLU_HMTR to S57enum(4, "hectometres"),
        UniHLU.HLU_SMIL to S57enum(5, "statute_miles"),
        UniHLU.HLU_NMIL to S57enum(6, "nautical_miles"),
    )

    private val Jrsdtn : Map<Any, S57enum> = mapOf(
        JrsJRS.JRS_UNKN to S57enum(0, ""),
        JrsJRS.JRS_INT to S57enum(1, "international"),
        JrsJRS.JRS_NAT to S57enum(2, "national"),
        JrsJRS.JRS_NSD to S57enum(3, "national_sub-division"),
    )

    private val Litchr : Map<Any, S57enum> = mapOf(
        LitCHR.CHR_UNKN to S57enum(0, ""),
        LitCHR.CHR_F to S57enum(1, "F"),
        LitCHR.CHR_FL to S57enum(2, "Fl"),
        LitCHR.CHR_LFL to S57enum(3, "LFl"),
        LitCHR.CHR_Q to S57enum(4, "Q"),
        LitCHR.CHR_VQ to S57enum(5, "VQ"),
        LitCHR.CHR_UQ to S57enum(6, "UQ"),
        LitCHR.CHR_ISO to S57enum(7, "Iso"),
        LitCHR.CHR_OC to S57enum(8, "Oc"),
        LitCHR.CHR_IQ to S57enum(9, "IQ"),
        LitCHR.CHR_IVQ to S57enum(10, "IVQ"),
        LitCHR.CHR_IUQ to S57enum(11, "IUQ"),
        LitCHR.CHR_MO to S57enum(12, "Mo"),
        LitCHR.CHR_FFL to S57enum(13, "FFl"),
        LitCHR.CHR_FLLFL to S57enum(14, "FlLFl"),
        LitCHR.CHR_OCFL to S57enum(15, "OcFl"),
        LitCHR.CHR_FLFL to S57enum(16, "FLFl"),
        LitCHR.CHR_ALOC to S57enum(17, "Al.Oc"),
        LitCHR.CHR_ALLFL to S57enum(18, "Al.LFl"),
        LitCHR.CHR_ALFL to S57enum(19, "Al.Fl"),
        LitCHR.CHR_ALGR to S57enum(20, "Al.Gr"),
        LitCHR.CHR_QLFL to S57enum(25, "Q+LFl"),
        LitCHR.CHR_VQLFL to S57enum(26, "VQ+LFl"),
        LitCHR.CHR_UQLFL to S57enum(27, "UQ+LFl"),
        LitCHR.CHR_AL to S57enum(28, "Al"),
        LitCHR.CHR_ALFFL to S57enum(29, "Al.FFl"),
    )

    private val Litvis : Map<Any, S57enum> = mapOf(
        LitVIS.LIT_UNKN to S57enum(0, ""),
        LitVIS.LIT_HIGH to S57enum(1, "high"),
        LitVIS.LIT_LOW to S57enum(2, "low"),
        LitVIS.LIT_FANT to S57enum(3, "faint"),
        LitVIS.LIT_INTS to S57enum(4, "intensified"),
        LitVIS.LIT_UINT to S57enum(5, "unintensified"),
        LitVIS.LIT_RSTR to S57enum(6, "restricted"),
        LitVIS.LIT_OBSC to S57enum(7, "obscured"),
        LitVIS.LIT_POBS to S57enum(8, "part_obscured"),
    )

    private val Marsys : Map<Any, S57enum> = mapOf(
        MarSYS.SYS_UNKN to S57enum(0, ""),
        MarSYS.SYS_IALA to S57enum(1, "iala-a"),
        MarSYS.SYS_IALB to S57enum(2, "iala-b"),
        MarSYS.SYS_NONE to S57enum(9, "none"),
        MarSYS.SYS_OTHR to S57enum(10, "other"),
        MarSYS.SYS_CEVN to S57enum(11, "cevni"),
        MarSYS.SYS_RIWR to S57enum(12, "riwr"),
        MarSYS.SYS_BWR2 to S57enum(13, "bniwr2"),
        MarSYS.SYS_BNWR to S57enum(14, "bniwr"),
        MarSYS.SYS_PPWB to S57enum(15, "ppwbc"),
    )

    private val Natcon : Map<Any, S57enum> = mapOf(
        NatCON.CON_UNKN to S57enum(0, ""),
        NatCON.CON_MSNY to S57enum(1, "masonry"),
        NatCON.CON_CONC to S57enum(2, "concreted"),
        NatCON.CON_BDRS to S57enum(3, "loose_boulders"),
        NatCON.CON_HSRF to S57enum(4, "hard-surfaced"),
        NatCON.CON_USRF to S57enum(5, "unsurfaced"),
        NatCON.CON_WOOD to S57enum(6, "wooden"),
        NatCON.CON_METL to S57enum(7, "metal"),
        NatCON.CON_GRP to S57enum(8, "grp"),
        NatCON.CON_PNTD to S57enum(9, "painted"),
        NatCON.CON_FMWK to S57enum(10, "framework"),
        NatCON.CON_LATT to S57enum(11, "latticed"),
        NatCON.CON_GLAS to S57enum(12, "glass"),
    )

    private val Natsur : Map<Any, S57enum> = mapOf(
        NatSUR.SUR_UNKN to S57enum(0, ""),
        NatSUR.SUR_MUD to S57enum(1, "mud"),
        NatSUR.SUR_CLAY to S57enum(2, "clay"),
        NatSUR.SUR_SILT to S57enum(3, "silt"),
        NatSUR.SUR_SAND to S57enum(4, "sand"),
        NatSUR.SUR_STON to S57enum(5, "stones"),
        NatSUR.SUR_GRVL to S57enum(6, "gravel"),
        NatSUR.SUR_PBBL to S57enum(7, "pebbles"),
        NatSUR.SUR_CBBL to S57enum(8, "cobbles"),
        NatSUR.SUR_ROCK to S57enum(9, "rocky"),
        NatSUR.SUR_LAVA to S57enum(11, "lava"),
        NatSUR.SUR_CORL to S57enum(14, "coral"),
        NatSUR.SUR_SHEL to S57enum(17, "shells"),
        NatSUR.SUR_BLDR to S57enum(18, "boulders"),
    )

    private val Natqua : Map<Any, S57enum> = mapOf(
        NatQUA.QUA_UNKN to S57enum(0, ""),
        NatQUA.QUA_FINE to S57enum(1, "fine"),
        NatQUA.QUA_MEDM to S57enum(2, "medium"),
        NatQUA.QUA_CORS to S57enum(3, "coarse"),
        NatQUA.QUA_BRKN to S57enum(4, "broken"),
        NatQUA.QUA_STKY to S57enum(5, "sticky"),
        NatQUA.QUA_SOFT to S57enum(6, "soft"),
        NatQUA.QUA_STIF to S57enum(7, "stiff"),
        NatQUA.QUA_VCNC to S57enum(8, "volcanic"),
        NatQUA.QUA_CALC to S57enum(9, "calcareous"),
        NatQUA.QUA_HARD to S57enum(10, "hard"),
    )

    private val Prodct : Map<Any, S57enum> = mapOf(
        PrdPRD.PRD_UNKN to S57enum(0, ""),
        PrdPRD.PRD_OIL to S57enum(1, "oil"),
        PrdPRD.PRD_GAS to S57enum(2, "gas"),
        PrdPRD.PRD_WATR to S57enum(3, "water"),
        PrdPRD.PRD_STON to S57enum(4, "stone"),
        PrdPRD.PRD_COAL to S57enum(5, "coal"),
        PrdPRD.PRD_ORE to S57enum(6, "ore"),
        PrdPRD.PRD_CHEM to S57enum(7, "chemicals"),
        PrdPRD.PRD_DWTR to S57enum(8, "drinking_water"),
        PrdPRD.PRD_MILK to S57enum(9, "milk"),
        PrdPRD.PRD_BXIT to S57enum(10, "bauxite"),
        PrdPRD.PRD_COKE to S57enum(11, "coke"),
        PrdPRD.PRD_IIGS to S57enum(12, "iron_ingots"),
        PrdPRD.PRD_SALT to S57enum(13, "salt"),
        PrdPRD.PRD_SAND to S57enum(14, "sand"),
        PrdPRD.PRD_TMBR to S57enum(15, "timber"),
        PrdPRD.PRD_SDST to S57enum(16, "sawdust"),
        PrdPRD.PRD_SCRP to S57enum(17, "scrap"),
        PrdPRD.PRD_LNA to S57enum(18, "lng"),
        PrdPRD.PRD_LPA to S57enum(19, "lpg"),
        PrdPRD.PRD_WINE to S57enum(20, "wine"),
        PrdPRD.PRD_CMNT to S57enum(21, "cement"),
        PrdPRD.PRD_GRAN to S57enum(22, "grain"),
    )

    private val Quasou : Map<Any, S57enum> = mapOf(
        QuaSOU.SOU_UNKN to S57enum(0, ""),
        QuaSOU.SOU_KNWN to S57enum(1, "known"),
        QuaSOU.SOU_UKNN to S57enum(2, "unknown"),
        QuaSOU.SOU_DFUL to S57enum(3, "doubtful"),
        QuaSOU.SOU_UNRL to S57enum(4, "unreliable"),
        QuaSOU.SOU_NBFD to S57enum(5, "no_bottom_found"),
        QuaSOU.SOU_LKWN to S57enum(6, "least_known"),
        QuaSOU.SOU_LUKN to S57enum(7, "least_unknown"),
        QuaSOU.SOU_NSRV to S57enum(8, "not_surveyed"),
        QuaSOU.SOU_NCNF to S57enum(9, "not_confirmed"),
        QuaSOU.SOU_MANT to S57enum(10, "maintained"),
        QuaSOU.SOU_NMNT to S57enum(11, "not_maintained"),
    )

    private val Restrn : Map<Any, S57enum> = mapOf(
        RstRST.RST_UNKN to S57enum(0, ""),
        RstRST.RST_NANC to S57enum(1, "no_anchoring"),
        RstRST.RST_RANC to S57enum(2, "restricted_anchoring"),
        RstRST.RST_NFSH to S57enum(3, "no_fishing"),
        RstRST.RST_RFSH to S57enum(4, "restricted_fishing"),
        RstRST.RST_NTRL to S57enum(5, "no_trawling"),
        RstRST.RST_RTRL to S57enum(6, "restricted_trawling"),
        RstRST.RST_NENT to S57enum(7, "no_entry"),
        RstRST.RST_RENT to S57enum(8, "restricted_entry"),
        RstRST.RST_NDRG to S57enum(9, "no_dredging"),
        RstRST.RST_RDRG to S57enum(10, "restricted_dredging"),
        RstRST.RST_NDVG to S57enum(11, "no_diving"),
        RstRST.RST_RDVG to S57enum(12, "restricted_diving"),
        RstRST.RST_NWAK to S57enum(13, "no_wake"),
        RstRST.RST_TBAV to S57enum(14, "to_be_avoided"),
        RstRST.RST_NCST to S57enum(15, "no_construction"),
        RstRST.RST_NDSC to S57enum(16, "no_discharging"),
        RstRST.RST_RDSC to S57enum(17, "restricted_discharging"),
        RstRST.RST_NEXD to S57enum(18, "no_exploration_development"),
        RstRST.RST_REXD to S57enum(19, "restricted_exploration_development"),
        RstRST.RST_NDRL to S57enum(20, "no_drilling"),
        RstRST.RST_RDRL to S57enum(21, "restricted_drilling"),
        RstRST.RST_NHAR to S57enum(22, "no_historical_artifacts_removal"),
        RstRST.RST_NLTG to S57enum(23, "no_lightering"),
        RstRST.RST_NDRA to S57enum(24, "no_dragging"),
        RstRST.RST_NSTP to S57enum(25, "no_stopping"),
        RstRST.RST_NLND to S57enum(26, "no_landing"),
        RstRST.RST_RSPD to S57enum(27, "restricted_speed"),
        RstRST.RST_NOVT to S57enum(28, "no_overtaking"),
        RstRST.RST_NCOV to S57enum(29, "no_convoy_overtaking"),
        RstRST.RST_NPOV to S57enum(30, "no_passing_overtaking"),
        RstRST.RST_NBRT to S57enum(31, "no_berthing"),
        RstRST.RST_RBRT to S57enum(32, "restricted_berthing"),
        RstRST.RST_NMFT to S57enum(33, "no_making_fast"),
        RstRST.RST_RMFT to S57enum(34, "restricted_making_fast"),
        RstRST.RST_NTRN to S57enum(35, "no_turning"),
        RstRST.RST_RFWD to S57enum(36, "restricted_fairway_depth"),
        RstRST.RST_RFWW to S57enum(37, "restricted_fairway_width"),
        RstRST.RST_NSWM to S57enum(38, "no_swimming"),
    )

    private val Siggen : Map<Any, S57enum> = mapOf(
        SigGEN.GEN_UNKN to S57enum(0, ""),
        SigGEN.GEN_AUTO to S57enum(1, "automatic"),
        SigGEN.GEN_WAVE to S57enum(2, "wave"),
        SigGEN.GEN_HAND to S57enum(3, "hand"),
        SigGEN.GEN_WIND to S57enum(4, "wind"),
    )

    private val Status : Map<Any, S57enum> = mapOf(
        StsSTS.STS_UNKN to S57enum(0, ""),
        StsSTS.STS_PERM to S57enum(1, "permanent"),
        StsSTS.STS_OCAS to S57enum(2, "occasional"),
        StsSTS.STS_RCMD to S57enum(3, "recommended"),
        StsSTS.STS_NIUS to S57enum(4, "not_in_use"),
        StsSTS.STS_IMTT to S57enum(5, "intermittent"),
        StsSTS.STS_RESV to S57enum(6, "reserved"),
        StsSTS.STS_TEMP to S57enum(7, "temporary"),
        StsSTS.STS_PRIV to S57enum(8, "private"),
        StsSTS.STS_MAND to S57enum(9, "mandatory"),
        StsSTS.STS_EXTD to S57enum(11, "extinguished"),
        StsSTS.STS_ILLD to S57enum(12, "illuminated"),
        StsSTS.STS_HIST to S57enum(13, "historic"),
        StsSTS.STS_PBLC to S57enum(14, "public"),
        StsSTS.STS_SYNC to S57enum(15, "synchronised"),
        StsSTS.STS_WCHD to S57enum(16, "watched"),
        StsSTS.STS_UWCD to S57enum(17, "unwatched"),
        StsSTS.STS_EDBT to S57enum(18, "existence_doubtful"),
        StsSTS.STS_OREQ to S57enum(19, "on_request"),
        StsSTS.STS_DPAW to S57enum(20, "drop_away"),
        StsSTS.STS_RSNG to S57enum(21, "rising"),
        StsSTS.STS_INCR to S57enum(22, "increasing"),
        StsSTS.STS_DECR to S57enum(23, "decreasing"),
        StsSTS.TS_STNG to S57enum(24, "strong"),
        StsSTS.STS_GOOD to S57enum(25, "good"),
        StsSTS.STS_MODY to S57enum(26, "moderately"),
        StsSTS.STS_POOR to S57enum(27, "poor"),
    )

    private val Surtyp : Map<Any, S57enum> = mapOf(
        SurTYP.TYP_UNKN to S57enum(0, ""),
        SurTYP.TYP_SKCH to S57enum(1, "sketch"),
        SurTYP.TYP_CTLD to S57enum(2, "controlled"),
        SurTYP.TYP_PSSG to S57enum(4, "examination"),
        SurTYP.TYP_PSSG to S57enum(5, "passage"),
        SurTYP.TYP_REMT to S57enum(6, "remote"),
    )

    private val Tecsou : Map<Any, S57enum> = mapOf(
        TecSOU.SOU_UNKN to S57enum(0, ""),
        TecSOU.SOU_ESND to S57enum(1, "echo-sounder"),
        TecSOU.SOU_FSSN to S57enum(2, "side-scan_sonar"),
        TecSOU.SOU_MLBM to S57enum(3, "multi-beam"),
        TecSOU.SOU_DIVR to S57enum(4, "diver"),
        TecSOU.SOU_LDLN to S57enum(5, "lead-line"),
        TecSOU.SOU_WDRG to S57enum(6, "wire-drag"),
        TecSOU.SOU_LASR to S57enum(7, "laser"),
        TecSOU.SOU_VACC to S57enum(8, "vertical_acoustic"),
        TecSOU.SOU_EMAG to S57enum(9, "electromagnetic"),
        TecSOU.SOU_PHGY to S57enum(10, "photogrammetry"),
        TecSOU.SOU_SATL to S57enum(11, "satellite"),
        TecSOU.SOU_LEVL to S57enum(12, "levelling"),
        TecSOU.SOU_SSSN to S57enum(13, "side-scan_sonar_swept"),
        TecSOU.SOU_COMP to S57enum(14, "computer"),
    )

    private val Topshp : Map<Any, S57enum> = mapOf(
        TopSHP.TOP_UNKN to S57enum(0, ""),
        TopSHP.TOP_CONE to S57enum(1, "cone, point up"),
        TopSHP.TOP_ICONE to S57enum(2, "cone, point down"),
        TopSHP.TOP_SPHR to S57enum(3, "sphere"),
        TopSHP.TOP_ISD to S57enum(4, "2 spheres"),
        TopSHP.TOP_CAN to S57enum(5, "cylinder"),
        TopSHP.TOP_BORD to S57enum(6, "board"),
        TopSHP.TOP_SALT to S57enum(7, "x-shape"),
        TopSHP.TOP_CROS to S57enum(8, "cross"),
        TopSHP.TOP_CUBE to S57enum(9, "cube, point up"),
        TopSHP.TOP_WEST to S57enum(10, "2 cones point together"),
        TopSHP.TOP_EAST to S57enum(11, "2 cones base together"),
        TopSHP.TOP_RHOM to S57enum(12, "rhombus"),
        TopSHP.TOP_NORTH to S57enum(13, "2 cones up"),
        TopSHP.TOP_SOUTH to S57enum(14, "2 cones down"),
        TopSHP.TOP_BESM to S57enum(15, "besom, point up"),
        TopSHP.TOP_IBESM to S57enum(16, "besom, point down"),
        TopSHP.TOP_FLAG to S57enum(17, "flag"),
        TopSHP.TOP_SPRH to S57enum(18, "sphere over rhombus"),
        TopSHP.TOP_SQUR to S57enum(19, "square"),
        TopSHP.TOP_HRECT to S57enum(20, "rectangle, horizontal"),
        TopSHP.TOP_VRECT to S57enum(21, "rectangle, vertical"),
        TopSHP.TOP_TRAP to S57enum(22, "trapezium, up"),
        TopSHP.TOP_ITRAP to S57enum(23, "trapezium, down"),
        TopSHP.TOP_TRI to S57enum(24, "triangle, point up"),
        TopSHP.TOP_ITRI to S57enum(25, "triangle, point down"),
        TopSHP.TOP_CIRC to S57enum(26, "circle"),
        TopSHP.TOP_CRSS to S57enum(27, "2 upright crosses"),
        TopSHP.TOP_T to S57enum(28, "t-shape"),
        TopSHP.TOP_TRCL to S57enum(29, "triangle, point up over circle"),
        TopSHP.TOP_CRCL to S57enum(30, "upright cross over circle"),
        TopSHP.TOP_RHCL to S57enum(31, "rhombus over circle"),
        TopSHP.TOP_CLTR to S57enum(32, "circle over triangle, point up"),
        TopSHP.TOP_OTHR to S57enum(33, "other"),
        TopSHP.TOP_CYSP to S57enum(34, "cylinder over sphere"),
        TopSHP.TOP_COSP to S57enum(35, "cone, point up over sphere"),
    )

    private val Trafic : Map<Any, S57enum> = mapOf(
        TrfTRF.TRF_UNKN to S57enum(0, ""),
        TrfTRF.TRF_INBD to S57enum(1, "inbound"),
        TrfTRF.TRF_OBND to S57enum(2, "outbbound"),
        TrfTRF.TRF_ONEW to S57enum(3, "one-way"),
        TrfTRF.TRF_TWOW to S57enum(4, "two-way"),
    )

    private val Watlev : Map<Any, S57enum> = mapOf(
        WatLEV.LEV_UNKN to S57enum(0, ""),
        WatLEV.LEV_PSUB to S57enum(1, "part-submerged"),
        WatLEV.LEV_DRY to S57enum(2, "dry"),
        WatLEV.LEV_SUBM to S57enum(3, "submerged"),
        WatLEV.LEV_CVRS to S57enum(4, "covers"),
        WatLEV.LEV_AWSH to S57enum(5, "awash"),
        WatLEV.LEV_FLDS to S57enum(6, "floods"),
        WatLEV.LEV_FLTG to S57enum(7, "floating"),
        WatLEV.LEV_AMWL to S57enum(8, "above_mwl"),
        WatLEV.LEV_BMWL to S57enum(9, "below_mwl"),
    )

    private val Cat_ts : Map<Any, S57enum> = mapOf(
        Cat_TS.TS_UNKN to S57enum(0, ""),
        Cat_TS.TS_FLOD to S57enum(1, "flood"),
        Cat_TS.TS_EBB to S57enum(2, "ebb"),
        Cat_TS.TS_OTHR to S57enum(3, "other"),
    )

    private val Punits : Map<Any, S57enum> = mapOf(
        UniPAU.PAU_UNKN to S57enum(0, ""),
        UniPAU.PAU_MTRS to S57enum(1, "metres"),
        UniPAU.PAU_DGRS to S57enum(2, "degrees"),
        UniPAU.PAU_MMTR to S57enum(3, "millimetres"),
        UniPAU.PAU_FEET to S57enum(4, "feet"),
        UniPAU.PAU_CBLS to S57enum(5, "cables"),
    )

    private val Quapos : Map<Any, S57enum> = mapOf(
        QuaPOS.POS_UNKN to S57enum(0, ""),
        QuaPOS.POS_SRVD to S57enum(1, "surveyed"),
        QuaPOS.POS_USRV to S57enum(2, "unsurveyed"),
        QuaPOS.POS_PSRV to S57enum(3, "part-surveyed"),
        QuaPOS.POS_APRX to S57enum(4, "approximate"),
        QuaPOS.POS_DBTF to S57enum(5, "doubtful"),
        QuaPOS.POS_URLB to S57enum(6, "unreliable"),
        QuaPOS.POS_RSRV to S57enum(7, "reported_unsurveyd"),
        QuaPOS.POS_UCNF to S57enum(8, "unconfirmed"),
        QuaPOS.POS_ESTM to S57enum(9, "estimated"),
        QuaPOS.POS_PRCS to S57enum(10, "precise"),
        QuaPOS.POS_CALC to S57enum(11, "calculated"),
    )

    private val Verdat : Map<Any, S57enum> = mapOf(
        VerDAT.DAT_UNKN to S57enum(0, ""),
        VerDAT.DAT_MLWS to S57enum(1, "mlws"),
        VerDAT.DAT_MLLWS to S57enum(2, "mllws"),
        VerDAT.DAT_MSL to S57enum(3, "msl"),
        VerDAT.DAT_LLW to S57enum(4, "llw"),
        VerDAT.DAT_MLW to S57enum(5, "mlw"),
        VerDAT.DAT_LLWS to S57enum(6, "llws"),
        VerDAT.DAT_AMLWS to S57enum(7, "amlws"),
        VerDAT.DAT_ISLW to S57enum(8, "islw"),
        VerDAT.DAT_LWS to S57enum(9, "lws"),
        VerDAT.DAT_ALAT to S57enum(10, "alat"),
        VerDAT.DAT_NLLW to S57enum(11, "nllw"),
        VerDAT.DAT_MLLW to S57enum(12, "mllw"),
        VerDAT.DAT_LW to S57enum(13, "lw"),
        VerDAT.DAT_AMLW to S57enum(14, "amlw"),
        VerDAT.DAT_AMLLW to S57enum(15, "amllw"),
        VerDAT.DAT_MHW to S57enum(16, "mhw"),
        VerDAT.DAT_MHWS to S57enum(17, "mhws"),
        VerDAT.DAT_HW to S57enum(18, "hw"),
        VerDAT.DAT_AMSL to S57enum(19, "amsl"),
        VerDAT.DAT_HWS to S57enum(20, "hws"),
        VerDAT.DAT_MHHW to S57enum(21, "mhhw"),
        VerDAT.DAT_ESLW to S57enum(22, "eslw"),
        VerDAT.DAT_LAT to S57enum(23, "lat"),
        VerDAT.DAT_LOCAL to S57enum(24, "local"),
        VerDAT.DAT_IGLD to S57enum(25, "igld1985"),
        VerDAT.DAT_MWL to S57enum(26, "mwl"),
        VerDAT.DAT_LLWLT to S57enum(27, "llwlt"),
        VerDAT.DAT_HHWLT to S57enum(28, "hhwlt"),
        VerDAT.DAT_NHHW to S57enum(29, "nhhw"),
        VerDAT.DAT_HAT to S57enum(30, "hat"),
        VerDAT.DAT_LLWRL to S57enum(31, "llwrl"),
        VerDAT.DAT_LHWRL to S57enum(32, "lhwrl"),
        VerDAT.DAT_LMWRL to S57enum(33, "lmwrl"),
        VerDAT.DAT_EHW to S57enum(34, "ehw_dglw"),
        VerDAT.DAT_HSHW to S57enum(35, "hshw_dhsw"),
        VerDAT.DAT_RLWL to S57enum(36, "rlwl_donau"),
        VerDAT.DAT_HSHWD to S57enum(37, "hshw_donau"),
        VerDAT.DAT_DRLWRL to S57enum(38, "drlwrl_olr"),
        VerDAT.DAT_RPWL to S57enum(39, "rpwl"),
        VerDAT.DAT_RNBL to S57enum(40, "rnbl"),
        VerDAT.DAT_OHIO to S57enum(41, "ohio_rd"),
    )

    private val Addmrk : Map<Any, S57enum> = mapOf(
        AddMRK.MRK_UNKN to S57enum(0, ""),
        AddMRK.MRK_TOPB to S57enum(1, "top_board"),
        AddMRK.MRK_BOTB to S57enum(2, "bottom_board"),
        AddMRK.MRK_RTRI to S57enum(3, "right_triangle"),
        AddMRK.MRK_LTRI to S57enum(4, "left_triangle"),
        AddMRK.MRK_BTRI to S57enum(5, "bottom_triangle"),
    )

    private val Bnkwtw : Map<Any, S57enum> = mapOf(
        BnkWTW.BWW_UNKN to S57enum(0, ""),
        BnkWTW.BWW_LEFT to S57enum(1, "left"),
        BnkWTW.BWW_RGHT to S57enum(2, "right"),
    )

    private val Catnmk : Map<Any, S57enum> = mapOf(
        CatNMK.NMK_UNKN to S57enum(0, ""),
        CatNMK.NMK_NENT to S57enum(1, "no_entry"),
        CatNMK.NMK_CLSA to S57enum(2, "closed_area"),
        CatNMK.NMK_NOVK to S57enum(3, "no_overtaking"),
        CatNMK.NMK_NCOV to S57enum(4, "no_convoy_overtaking"),
        CatNMK.NMK_NPAS to S57enum(5, "no_passing"),
        CatNMK.NMK_NBRT to S57enum(6, "no_berthing"),
        CatNMK.NMK_NBLL to S57enum(7, "no_berthing_lateral_limit"),
        CatNMK.NMK_NANK to S57enum(8, "no_anchoring"),
        CatNMK.NMK_NMOR to S57enum(9, "no_mooring"),
        CatNMK.NMK_NTRN to S57enum(10, "no_turning"),
        CatNMK.NMK_NWSH to S57enum(11, "no_wash"),
        CatNMK.NMK_NPSL to S57enum(12, "no_passage_left"),
        CatNMK.NMK_NPSR to S57enum(13, "no_passage_right"),
        CatNMK.NMK_NMTC to S57enum(14, "no_motor_craft"),
        CatNMK.NMK_NSPC to S57enum(15, "no_sport_craft"),
        CatNMK.NMK_NWSK to S57enum(16, "no_waterskiing"),
        CatNMK.NMK_NSLC to S57enum(17, "no_sailing_craft"),
        CatNMK.NMK_NUPC to S57enum(18, "no_unpowered_craft"),
        CatNMK.NMK_NSLB to S57enum(19, "no_sailboards"),
        CatNMK.NMK_NWBK to S57enum(20, "no_waterbikes"),
        CatNMK.NMK_NHSC to S57enum(21, "no_high_speeds"),
        CatNMK.NMK_NLBG to S57enum(22, "no_launching_beaching"),
        CatNMK.NMK_MVTL to S57enum(23, "move_to_left"),
        CatNMK.NMK_MVTR to S57enum(24, "move_to_right"),
        CatNMK.NMK_MVTP to S57enum(25, "move_to_port"),
        CatNMK.NMK_MVTS to S57enum(26, "move_to_starboard"),
        CatNMK.NMK_KPTP to S57enum(27, "keep_to_port"),
        CatNMK.NMK_KPTS to S57enum(28, "keep_to_starboard"),
        CatNMK.NMK_CSTP to S57enum(29, "cross_to_port"),
        CatNMK.NMK_CSTS to S57enum(30, "cross_to_starboard"),
        CatNMK.NMK_STOP to S57enum(31, "stop"),
        CatNMK.NMK_SPDL to S57enum(32, "speed_limit"),
        CatNMK.NMK_SHRN to S57enum(33, "sound_horn"),
        CatNMK.NMK_KPLO to S57enum(34, "keep_lookout"),
        CatNMK.NMK_GWJN to S57enum(35, "give_way_junction"),
        CatNMK.NMK_GWCS to S57enum(36, "give_way_crossing"),
        CatNMK.NMK_MKRC to S57enum(37, "make_radio_contact"),
        CatNMK.NMK_LMDP to S57enum(38, "limited_depth"),
        CatNMK.NMK_LMHR to S57enum(39, "limited_headroom"),
        CatNMK.NMK_LMWD to S57enum(40, "limited_width"),
        CatNMK.NMK_NAVR to S57enum(41, "navigation_restrictions"),
        CatNMK.NMK_CHDL to S57enum(42, "channel_distance_left"),
        CatNMK.NMK_CHDR to S57enum(43, "channel_distance_right"),
        CatNMK.NMK_CHTW to S57enum(44, "channel_two_way"),
        CatNMK.NMK_CHOW to S57enum(45, "channel_one_way"),
        CatNMK.NMK_OPTR to S57enum(46, "opening_to_right"),
        CatNMK.NMK_OPTL to S57enum(47, "opening_to_left"),
        CatNMK.NMK_PRTL to S57enum(48, "proceed_to_left"),
        CatNMK.NMK_PRTR to S57enum(49, "proceed_to_right"),
        CatNMK.NMK_ENTP to S57enum(50, "entry_permitted"),
        CatNMK.NMK_OVHC to S57enum(51, "overhead_cable"),
        CatNMK.NMK_WEIR to S57enum(52, "weir"),
        CatNMK.NMK_FERN to S57enum(53, "ferry_non_independent"),
        CatNMK.NMK_FERI to S57enum(54, "ferry_independent"),
        CatNMK.NMK_BRTP to S57enum(55, "berthing_permitted"),
        CatNMK.NMK_BTLL to S57enum(56, "berthing_lateral_limit"),
        CatNMK.NMK_BTLS to S57enum(57, "berthing_lateral_limits"),
        CatNMK.NMK_BTRL to S57enum(58, "berth_rafting_limit"),
        CatNMK.NMK_BTUP to S57enum(59, "berthing_unmarked_pushing"),
        CatNMK.NMK_BTP1 to S57enum(60, "berthing_marked_pushing_1"),
        CatNMK.NMK_BTP2 to S57enum(61, "berthing_marked_pushing_2"),
        CatNMK.NMK_BTP3 to S57enum(62, "berthing_marked_pushing_3"),
        CatNMK.NMK_BTUN to S57enum(63, "berthing_unmarked_non-pushing"),
        CatNMK.NMK_BTN1 to S57enum(64, "berthing_marked_non-pushing_1"),
        CatNMK.NMK_BTN2 to S57enum(65, "berthing_marked_non-pushing_2"),
        CatNMK.NMK_BTN3 to S57enum(66, "berthing_marked_non-pushing_3"),
        CatNMK.NMK_BTUM to S57enum(67, "berthing_unmarked"),
        CatNMK.NMK_BTU1 to S57enum(68, "berthing_marked_1"),
        CatNMK.NMK_BTU2 to S57enum(69, "berthing_marked_2"),
        CatNMK.NMK_BTU3 to S57enum(70, "berthing_marked_3"),
        CatNMK.NMK_ANKP to S57enum(71, "anchoring_permitted"),
        CatNMK.NMK_MORP to S57enum(72, "mooring_permitted"),
        CatNMK.NMK_VLBT to S57enum(73, "vehicle_loading_berth"),
        CatNMK.NMK_TRNA to S57enum(74, "turning_area"),
        CatNMK.NMK_SWWC to S57enum(75, "secondary_waterway_crossing"),
        CatNMK.NMK_SWWR to S57enum(76, "secondary_waterway_right"),
        CatNMK.NMK_SWWL to S57enum(77, "secondary_waterway_left"),
        CatNMK.NMK_WRSA to S57enum(78, "main_waterway_right_secondary_ahead"),
        CatNMK.NMK_WLSA to S57enum(79, "main_waterway_left_secondary_ahead"),
        CatNMK.NMK_WRSL to S57enum(80, "main_waterway_right_secondary_left"),
        CatNMK.NMK_WLSR to S57enum(81, "main_waterway_left_secondary_right"),
        CatNMK.NMK_WRAL to S57enum(82, "main_waterway_right_secondary_ahead_left"),
        CatNMK.NMK_WLAR to S57enum(83, "main_waterway_left_secondary_ahead_right"),
        CatNMK.NMK_MWWC to S57enum(84, "main_waterway_crossing"),
        CatNMK.NMK_MWWJ to S57enum(85, "main_waterway_junction"),
        CatNMK.NMK_MWAR to S57enum(86, "main_waterway_ahead_right"),
        CatNMK.NMK_MWAL to S57enum(87, "main_waterway_ahead_left"),
        CatNMK.NMK_WARL to S57enum(88, "main_waterway_ahead_right_secondary_left"),
        CatNMK.NMK_WALR to S57enum(89, "main_waterway_ahead_left_secondary_right"),
        CatNMK.NMK_PEND to S57enum(90, "prohibition_ends"),
        CatNMK.NMK_DWTR to S57enum(91, "drinking_water"),
        CatNMK.NMK_TELE to S57enum(92, "telephone"),
        CatNMK.NMK_MTCP to S57enum(93, "motor_craft_permitted"),
        CatNMK.NMK_SPCP to S57enum(94, "sport_craft_permitted"),
        CatNMK.NMK_WSKP to S57enum(95, "waterskiing_permitted"),
        CatNMK.NMK_SLCP to S57enum(96, "sailing_craft_permitted"),
        CatNMK.NMK_UPCP to S57enum(97, "unpowered_craft_permitted"),
        CatNMK.NMK_SLBP to S57enum(98, "sailboards_permitted"),
        CatNMK.NMK_RADI to S57enum(99, "radio_information"),
        CatNMK.NMK_WTBP to S57enum(100, "waterbikes_permitted"),
        CatNMK.NMK_HSCP to S57enum(101, "high_speeds_permitted"),
        CatNMK.NMK_LBGP to S57enum(102, "launching_beaching_permitted"),
        CatNMK.NMK_KTPM to S57enum(103, "keep_to_port_margin"),
        CatNMK.NMK_KTSM to S57enum(104, "keep_to_starboard_margin"),
        CatNMK.NMK_KTMR to S57enum(105, "keep_to_mid-river"),
        CatNMK.NMK_CRTP to S57enum(106, "cross_river_to_port"),
        CatNMK.NMK_CRTS to S57enum(107, "cross_river_to_starboard"),
        CatNMK.NMK_TRBM to S57enum(108, "traffic_between_margins"),
        CatNMK.NMK_RSPD to S57enum(109, "reduce_speed"),
        CatNMK.NMK_WRKP to S57enum(110, "wreck_pontoon"),
        CatNMK.NMK_PSBS to S57enum(111, "pass_both_sides"),
        CatNMK.NMK_NCPS to S57enum(112, "no_convoy_passing"),
        CatNMK.NMK_NSMC to S57enum(113, "no_small_craft"),
        CatNMK.NMK_ATTN to S57enum(114, "attention"),
        CatNMK.NMK_FWCR to S57enum(115, "fairway_crossing"),
        CatNMK.NMK_SHIP to S57enum(112, "shipping_inspection_point"),
    )

    private val Clsdng : Map<Any, S57enum> = mapOf(
        ClsDNG.DNG_UNKN to S57enum(0, ""),
        ClsDNG.DNG_1BLU to S57enum(1, "one_blue"),
        ClsDNG.DNG_2BLU to S57enum(2, "two_blue"),
        ClsDNG.DNG_3BLU to S57enum(3, "three_blue"),
        ClsDNG.DNG_0BLU to S57enum(4, "no_blue"),
        ClsDNG.DNG_1RED to S57enum(5, "one_red"),
    )

    private val Dirimp : Map<Any, S57enum> = mapOf(
        DirIMP.IMP_UNKN to S57enum(0, ""),
        DirIMP.IMP_UPST to S57enum(1, "upstream"),
        DirIMP.IMP_DNST to S57enum(2, "downstream"),
        DirIMP.IMP_LTBK to S57enum(3, "left_bank"),
        DirIMP.IMP_RTBK to S57enum(4, "right_bank"),
        DirIMP.IMP_THBR to S57enum(5, "to_harbour"),
    )

    private val Fnctnm : Map<Any, S57enum> = mapOf(
        FncFNM.FNM_UNKN to S57enum(0, ""),
        FncFNM.FNM_PRHB to S57enum(1, "prohibition"),
        FncFNM.FNM_RGLN to S57enum(2, "regulation"),
        FncFNM.FNM_RSTN to S57enum(3, "restriction"),
        FncFNM.FNM_RCMD to S57enum(4, "recommendation"),
        FncFNM.FNM_INFO to S57enum(5, "information"),
    )

    private val Bunves : Map<Any, S57enum> = mapOf(
        BunVES.VES_UNKN to S57enum(0, ""),
        BunVES.VES_BVAV to S57enum(1, "bunker_vessel_available"),
        BunVES.VES_NBVA to S57enum(2, "no_bunker_vessel_available"),
    )

    private val Catbrt : Map<Any, S57enum> = mapOf(
        CatBRT.BRT_UNKN to S57enum(0, ""),
        CatBRT.BRT_LODG to S57enum(1, "loading"),
        CatBRT.BRT_ULDG to S57enum(2, "unloading"),
        CatBRT.BRT_OVNT to S57enum(3, "overnight_accommodation"),
        CatBRT.BRT_PSHN to S57enum(4, "pushing-navigation"),
        CatBRT.BRT_NPSH to S57enum(5, "non-pushing-navigation"),
        CatBRT.BRT_FLTG to S57enum(6, "fleeting"),
        CatBRT.BRT_FCLS to S57enum(7, "first_class"),
        CatBRT.BRT_SCLS to S57enum(8, "second_class"),
    )

    private val Catbun : Map<Any, S57enum> = mapOf(
        CatBUN.BUN_UNKN to S57enum(0, ""),
        CatBUN.BUN_DESL to S57enum(1, "diesel"),
        CatBUN.BUN_WATR to S57enum(2, "water"),
        CatBUN.BUN_BLST to S57enum(3, "ballast"),
    )

    private val Catccl : Map<Any, S57enum> = mapOf(
        CatCCL.CCL_UNKN to S57enum(0, ""),
        CatCCL.CCL_SMLV to S57enum(1, "small_vessels"),
        CatCCL.CCL_PNCH to S57enum(2, "peniche"),
        CatCCL.CCL_CMPB to S57enum(3, "campine_barge"),
        CatCCL.CCL_DMEB to S57enum(4, "dortmund-ems_barge"),
        CatCCL.CCL_RHNB to S57enum(5, "rhine-herne_barge"),
        CatCCL.CCL_1BPT to S57enum(6, "1-barge_push-tow"),
        CatCCL.CCL_2PTL to S57enum(7, "2-barge_push-tow_long"),
        CatCCL.CCL_2PTW to S57enum(8, "2-barge_push-tow_wide"),
        CatCCL.CCL_4BPT to S57enum(9, "4-barge_push-tow"),
        CatCCL.CCL_6BPT to S57enum(10, "6-barge_push-tow"),
        CatCCL.CCL_NCCL to S57enum(11, "no_cemt_class"),
    )

    private val Catcom : Map<Any, S57enum> = mapOf(
        CatCOM.COM_UNKN to S57enum(0, ""),
        CatCOM.COM_VTSC to S57enum(1, "vts_centre"),
        CatCOM.COM_VTSS to S57enum(2, "vts_sector"),
        CatCOM.COM_IVSP to S57enum(3, "ivs_point"),
        CatCOM.COM_MID to S57enum(4, "mib"),
        CatCOM.COM_LOCK to S57enum(5, "lock"),
        CatCOM.COM_BRDG to S57enum(6, "bridge"),
        CatCOM.COM_CSTM to S57enum(7, "customs"),
        CatCOM.COM_HRBR to S57enum(8, "harbour"),
    )

    private val Cathbr : Map<Any, S57enum> = mapOf(
        CatHBR.HBR_UNKN to S57enum(0, ""),
        CatHBR.HBR_CSTM to S57enum(1, "customs"),
        CatHBR.HBR_REFG to S57enum(2, "refuge"),
        CatHBR.HBR_MRNA to S57enum(3, "marina"),
        CatHBR.HBR_FISH to S57enum(4, "fishing"),
        CatHBR.HBR_PRIV to S57enum(5, "private"),
    )

    private val Catrfd : Map<Any, S57enum> = mapOf(
        CatRFD.RFD_UNKN to S57enum(0, ""),
        CatRFD.RFD_CRSD to S57enum(1, "cargo_residue"),
        CatRFD.RFD_WOIL to S57enum(2, "waste_oil"),
        CatRFD.RFD_GBWT to S57enum(3, "grey_black_water"),
        CatRFD.RFD_DREF to S57enum(4, "domestic_refuse"),
    )

    private val Cattml : Map<Any, S57enum> = mapOf(
        CatTML.TML_UNKN to S57enum(0, ""),
        CatTML.TML_PSGR to S57enum(1, "passenger"),
        CatTML.TML_FERY to S57enum(2, "ferry"),
        CatTML.TML_TSPT to S57enum(3, "transhipment"),
        CatTML.TML_RORO to S57enum(4, "roro"),
    )

    private val Trshgd : Map<Any, S57enum> = mapOf(
        TrsTGD.TGD_UNKN to S57enum(0, ""),
        TrsTGD.TGD_CONT to S57enum(1, "containers"),
        TrsTGD.TGD_BULK to S57enum(2, "bulk"),
        TrsTGD.TGD_OIL to S57enum(3, "oil"),
        TrsTGD.TGD_FUEL to S57enum(4, "fuel"),
        TrsTGD.TGD_CHEM to S57enum(5, "chemicals"),
        TrsTGD.TGD_LIQD to S57enum(6, "liquid"),
        TrsTGD.TGD_EXPL to S57enum(7, "explosive"),
        TrsTGD.TGD_FISH to S57enum(8, "fish"),
        TrsTGD.TGD_CARS to S57enum(9, "cars"),
        TrsTGD.TGD_GNRL to S57enum(10, "general"),
    )

    private val Catgag : Map<Any, S57enum> = mapOf(
        CatGAG.GAG_UNKN to S57enum(0, ""),
        CatGAG.GAG_STAF to S57enum(1, "staff"),
        CatGAG.GAG_RCRD to S57enum(2, "recording"),
        CatGAG.GAG_RCRA to S57enum(3, "recording_remote_access"),
        CatGAG.GAG_RCEI to S57enum(4, "recording_external_indicator"),
        CatGAG.GAG_RRAI to S57enum(5, "recording_remote_access_indicator"),
    )

    private val Reflev : Map<Any, S57enum> = mapOf(
        RefLEV.LEV_UNKN to S57enum(0, ""),
        RefLEV.LEV_BALT to S57enum(1, "baltic"),
        RefLEV.LEV_ADRC to S57enum(2, "adriatic"),
        RefLEV.LEV_AMSD to S57enum(3, "amsterdam"),
        RefLEV.LEV_MSL to S57enum(4, "msl"),
        RefLEV.LEV_OTHR to S57enum(5, "other"),
        RefLEV.LEV_NG29 to S57enum(6, "ngvd29"),
        RefLEV.LEV_NA88 to S57enum(7, "navd88"),
        RefLEV.LEV_1912 to S57enum(8, "msl1912"),
        RefLEV.LEV_1929 to S57enum(9, "msl1929"),
    )

    private val Catvtr : Map<Any, S57enum> = mapOf(
        CatVTR.VTR_UNKN to S57enum(0, ""),
        CatVTR.VTR_OFFL to S57enum(1, "official"),
        CatVTR.VTR_PRIV to S57enum(2, "private"),
        CatVTR.VTR_CARC to S57enum(3, "car_cranes"),
        CatVTR.VTR_CARP to S57enum(4, "car_planks"),
        CatVTR.VTR_PREQ to S57enum(5, "permission_required"),
        CatVTR.VTR_LGAT to S57enum(6, "locked_gate"),
    )

    private val Cattab : Map<Any, S57enum> = mapOf(
        CatTAB.TAB_UNKN to S57enum(0, ""),
        CatTAB.TAB_OPPD to S57enum(1, "operational_period"),
        CatTAB.TAB_NOPP to S57enum(2, "non-operational_period"),
    )

    private val Useshp : Map<Any, S57enum> = mapOf(
        UseSHP.SHP_UNKN to S57enum(0, ""),
        UseSHP.SHP_LINT to S57enum(1, "liner_trade"),
        UseSHP.SHP_OCSH to S57enum(2, "occasional_professional_shipping"),
        UseSHP.SHP_LESR to S57enum(3, "leisure"),
    )

    private val Catexs : Map<Any, S57enum> = mapOf(
        CatEXS.EXS_UNKN to S57enum(0, ""),
        CatEXS.EXS_LLOK to S57enum(1, "lift-lock"),
        CatEXS.EXS_AQDT to S57enum(2, "aqueduct"),
        CatEXS.EXS_SPLK to S57enum(3, "sloping_plane_lock"),
        CatEXS.EXS_WSLK to S57enum(4, "water_slope_lock"),
        CatEXS.EXS_OTHR to S57enum(5, "other"),
    )

    private val Catwwm : Map<Any, S57enum> = mapOf(
        CatWWM.WWM_UNKN to S57enum(0, ""),
        CatWWM.WWM_WWRT to S57enum(1, "waterway_right"),
        CatWWM.WWM_WWLT to S57enum(2, "waterway_left"),
        CatWWM.WWM_WWSP to S57enum(3, "waterway_separation"),
        CatWWM.WWM_CHRT to S57enum(4, "channel_right"),
        CatWWM.WWM_CHLT to S57enum(5, "channel_left"),
        CatWWM.WWM_CHSP to S57enum(6, "channel_separation"),
        CatWWM.WWM_CHRB to S57enum(7, "channel_right_bank"),
        CatWWM.WWM_CHLB to S57enum(8, "channel_left_bank"),
        CatWWM.WWM_CORT to S57enum(9, "crossover_right"),
        CatWWM.WWM_COLT to S57enum(10, "crossover_left"),
        CatWWM.WWM_DGRT to S57enum(11, "danger_right"),
        CatWWM.WWM_DGLT to S57enum(12, "danger_left"),
        CatWWM.WWM_TORT to S57enum(13, "turnoff_right"),
        CatWWM.WWM_TOLT to S57enum(14, "turnoff_left"),
        CatWWM.WWM_JNRT to S57enum(15, "junction_right"),
        CatWWM.WWM_JNLT to S57enum(16, "junction_left"),
        CatWWM.WWM_HBRT to S57enum(17, "harbour_right"),
        CatWWM.WWM_HBLT to S57enum(18, "harbour_left"),
        CatWWM.WWM_BRPR to S57enum(19, "bridge_pier"),
    )

    private val Lg_spr : Map<Any, S57enum> = mapOf(
        Lg_SPR.SPR_UNKN to S57enum(0, ""),
        Lg_SPR.SPR_OTHR to S57enum(1, "other"),
        Lg_SPR.SPR_SPOG to S57enum(2, "speed_over_ground"),
        Lg_SPR.SPR_SPTW to S57enum(3, "speed_through_water"),
    )

    private val Lg_wdu : Map<Any, S57enum> = mapOf(
        Lg_WDU.WDU_UNKN to S57enum(0, ""),
        Lg_WDU.WDU_OTHR to S57enum(1, "other"),
        Lg_WDU.WDU_CUMT to S57enum(2, "cubic_metres"),
        Lg_WDU.WDU_TONS to S57enum(3, "tonnes"),
    )

    private val Lg_rel : Map<Any, S57enum> = mapOf(
        Lg_REL.REL_UNKN to S57enum(0, ""),
        Lg_REL.REL_OTHR to S57enum(1, "other"),
        Lg_REL.REL_USWW to S57enum(2, "usage_of_waterway"),
        Lg_REL.REL_CREQ to S57enum(3, "carriage_of_equipment"),
        Lg_REL.REL_TKOP to S57enum(4, "task_operation"),
    )

    private val Lg_fnc : Map<Any, S57enum> = mapOf(
        Lg_FNC.FNC_UNKN to S57enum(0, ""),
        Lg_FNC.FNC_OTHR to S57enum(1, "other"),
        Lg_FNC.FNC_PRHB to S57enum(2, "prohibited"),
        Lg_FNC.FNC_PRHE to S57enum(3, "prohibited_with_exceptions"),
        Lg_FNC.FNC_PERM to S57enum(4, "permitted"),
        Lg_FNC.FNC_PERE to S57enum(5, "permitted_with_exceptions"),
        Lg_FNC.FNC_RCMD to S57enum(6, "recommended"),
        Lg_FNC.FNC_NRCD to S57enum(7, "not_recommended"),
    )

    private val Lc_csi : Map<Any, S57enum> = mapOf(
        Lc_CSX.CSX_UNKN to S57enum(0, ""),
        Lc_CSX.CSX_ALL to S57enum(1, "all"),
        Lc_CSX.CSX_OTHR to S57enum(2, "other"),
        Lc_CSX.CSX_NMOT to S57enum(3, "non-motorized"),
        Lc_CSX.CSX_CRFT to S57enum(5, "craft"),
        Lc_CSX.CSX_VSSL to S57enum(6, "vessel"),
        Lc_CSX.CSX_ILWW to S57enum(7, "inland_waterway"),
        Lc_CSX.CSX_SEAG to S57enum(8, "sea-going"),
        Lc_CSX.CSX_MOTR to S57enum(9, "motor"),
        Lc_CSX.CSX_MTNK to S57enum(10, "motor_tanker"),
        Lc_CSX.CSX_MCGO to S57enum(11, "motor_cargo"),
        Lc_CSX.CSX_CBRG to S57enum(12, "canal_barge"),
        Lc_CSX.CSX_TUG to S57enum(13, "tug"),
        Lc_CSX.CSX_PSHR to S57enum(14, "pusher"),
        Lc_CSX.CSX_BARG to S57enum(15, "barge"),
        Lc_CSX.CSX_TNKB to S57enum(16, "tank_barge"),
        Lc_CSX.CSX_DMBB to S57enum(17, "dumb_barge"),
        Lc_CSX.CSX_LGTR to S57enum(18, "lighter"),
        Lc_CSX.CSX_TNKL to S57enum(19, "tank_lighter"),
        Lc_CSX.CSX_CGOL to S57enum(20, "cargo_lighter"),
        Lc_CSX.CSX_SBLR to S57enum(21, "ship_borne_lighter"),
        Lc_CSX.CSX_PSGR to S57enum(22, "passenger"),
        Lc_CSX.CSX_PSGS to S57enum(23, "passenger_sailing"),
        Lc_CSX.CSX_DAYT to S57enum(24, "day_trip"),
        Lc_CSX.CSX_CABN to S57enum(25, "cabin"),
        Lc_CSX.CSX_HSPD to S57enum(26, "high-speed"),
        Lc_CSX.CSX_FLEQ to S57enum(27, "floating_equipment"),
        Lc_CSX.CSX_WSIT to S57enum(28, "worksite"),
        Lc_CSX.CSX_RCNL to S57enum(29, "recreational"),
        Lc_CSX.CSX_DNGY to S57enum(30, "dinghy"),
        Lc_CSX.CSX_FEST to S57enum(31, "floating_establishment"),
        Lc_CSX.CSX_FOBJ to S57enum(32, "floating_object"),
    )

    private val Lc_cse : Map<Any, S57enum> = mapOf(
        Lc_CSX.CSX_UNKN to S57enum(0, ""),
        Lc_CSX.CSX_ALL to S57enum(1, "all"),
        Lc_CSX.CSX_OTHR to S57enum(2, "other"),
        Lc_CSX.CSX_NMOT to S57enum(3, "non-motorized"),
        Lc_CSX.CSX_CRFT to S57enum(5, "craft"),
        Lc_CSX.CSX_VSSL to S57enum(6, "vessel"),
        Lc_CSX.CSX_ILWW to S57enum(7, "inland_waterway"),
        Lc_CSX.CSX_SEAG to S57enum(8, "sea-going"),
        Lc_CSX.CSX_MOTR to S57enum(9, "motor"),
        Lc_CSX.CSX_MTNK to S57enum(10, "motor_tanker"),
        Lc_CSX.CSX_MCGO to S57enum(11, "motor_cargo"),
        Lc_CSX.CSX_CBRG to S57enum(12, "canal_barge"),
        Lc_CSX.CSX_TUG to S57enum(13, "tug"),
        Lc_CSX.CSX_PSHR to S57enum(14, "pusher"),
        Lc_CSX.CSX_BARG to S57enum(15, "barge"),
        Lc_CSX.CSX_TNKB to S57enum(16, "tank_barge"),
        Lc_CSX.CSX_DMBB to S57enum(17, "dumb_barge"),
        Lc_CSX.CSX_LGTR to S57enum(18, "lighter"),
        Lc_CSX.CSX_TNKL to S57enum(19, "tank_lighter"),
        Lc_CSX.CSX_CGOL to S57enum(20, "cargo_lighter"),
        Lc_CSX.CSX_SBLR to S57enum(21, "ship_borne_lighter"),
        Lc_CSX.CSX_PSGR to S57enum(22, "passenger"),
        Lc_CSX.CSX_PSGS to S57enum(23, "passenger_sailing"),
        Lc_CSX.CSX_DAYT to S57enum(24, "day_trip"),
        Lc_CSX.CSX_CABN to S57enum(25, "cabin"),
        Lc_CSX.CSX_HSPD to S57enum(26, "high-speed"),
        Lc_CSX.CSX_FLEQ to S57enum(27, "floating_equipment"),
        Lc_CSX.CSX_WSIT to S57enum(28, "worksite"),
        Lc_CSX.CSX_RCNL to S57enum(29, "recreational"),
        Lc_CSX.CSX_DNGY to S57enum(30, "dinghy"),
        Lc_CSX.CSX_FEST to S57enum(31, "floating_establishment"),
        Lc_CSX.CSX_FOBJ to S57enum(32, "floating_object"),
    )

    private val Lc_asi : Map<Any, S57enum> = mapOf(
        Lc_ASX.ASX_UNKN to S57enum(0, ""),
        Lc_ASX.ASX_ALL to S57enum(1, "all"),
        Lc_ASX.ASX_OTHR to S57enum(2, "other"),
        Lc_ASX.ASX_SNGL to S57enum(3, "single"),
        Lc_ASX.ASX_CONV to S57enum(5, "convoy"),
        Lc_ASX.ASX_FMTN to S57enum(6, "formation"),
        Lc_ASX.ASX_RCNV to S57enum(7, "rigid_convoy"),
        Lc_ASX.ASX_PCNV to S57enum(8, "pushed_convoy"),
        Lc_ASX.ASX_BSTD to S57enum(9, "breasted"),
        Lc_ASX.ASX_TCNV to S57enum(10, "towed_convoy"),
    )

    private val Lc_ase : Map<Any, S57enum> = mapOf(
        Lc_ASX.ASX_UNKN to S57enum(0, ""),
        Lc_ASX.ASX_ALL to S57enum(1, "all"),
        Lc_ASX.ASX_OTHR to S57enum(2, "other"),
        Lc_ASX.ASX_SNGL to S57enum(3, "single"),
        Lc_ASX.ASX_CONV to S57enum(5, "convoy"),
        Lc_ASX.ASX_FMTN to S57enum(6, "formation"),
        Lc_ASX.ASX_RCNV to S57enum(7, "rigid_convoy"),
        Lc_ASX.ASX_PCNV to S57enum(8, "pushed_convoy"),
        Lc_ASX.ASX_BSTD to S57enum(9, "breasted"),
        Lc_ASX.ASX_TCNV to S57enum(10, "towed_convoy"),
    )

    private val Lc_cci : Map<Any, S57enum> = mapOf(
        Lc_CCX.CCX_UNKN to S57enum(0, ""),
        Lc_CCX.CCX_ALL to S57enum(1, "all"),
        Lc_CCX.CCX_OTHR to S57enum(2, "other"),
        Lc_CCX.CCX_BULK to S57enum(4, "bulk"),
        Lc_CCX.CCX_DRY to S57enum(5, "dry"),
        Lc_CCX.CCX_LIQD to S57enum(6, "liquid"),
        Lc_CCX.CCX_LQDN to S57enum(7, "liquid_n"),
        Lc_CCX.CCX_LQDC to S57enum(8, "liquid_c"),
        Lc_CCX.CCX_GAS to S57enum(9, "gas"),
    )

    private val Lc_cce : Map<Any, S57enum> = mapOf(
        Lc_CCX.CCX_UNKN to S57enum(0, ""),
        Lc_CCX.CCX_ALL to S57enum(1, "all"),
        Lc_CCX.CCX_OTHR to S57enum(2, "other"),
        Lc_CCX.CCX_BULK to S57enum(4, "bulk"),
        Lc_CCX.CCX_DRY to S57enum(5, "dry"),
        Lc_CCX.CCX_LIQD to S57enum(6, "liquid"),
        Lc_CCX.CCX_LQDN to S57enum(7, "liquid_n"),
        Lc_CCX.CCX_LQDC to S57enum(8, "liquid_c"),
        Lc_CCX.CCX_GAS to S57enum(9, "gas"),
    )

    private val Shptyp : Map<Any, S57enum> = mapOf(
        ShpTYP.TYP_UNKN to S57enum(0, ""),
        ShpTYP.TYP_CRGO to S57enum(1, "cargo"),
        ShpTYP.TYP_CONT to S57enum(2, "container"),
        ShpTYP.TYP_TNKR to S57enum(3, "tanker"),
        ShpTYP.TYP_SAIL to S57enum(4, "sailing"),
        ShpTYP.TYP_FISH to S57enum(5, "fishing"),
        ShpTYP.TYP_SPPS to S57enum(6, "special_purpose."),
        ShpTYP.TYP_MOWR to S57enum(7, "man_of_war"),
        ShpTYP.TYP_SUBM to S57enum(8, "submarine"),
        ShpTYP.TYP_HSPD to S57enum(9, "high-speed"),
        ShpTYP.TYP_BCAR to S57enum(10, "bulk_carrier"),
        ShpTYP.TYP_SPLN to S57enum(11, "seaplane"),
        ShpTYP.TYP_TUGB to S57enum(12, "tugboat"),
        ShpTYP.TYP_PSGR to S57enum(13, "passenger"),
        ShpTYP.TYP_FERY to S57enum(14, "ferry"),
        ShpTYP.TYP_BOAT to S57enum(15, "boat"),
    )

    private val Catcvr : Map<Any, S57enum> = mapOf(
        CatCVR.CVR_UNKN to S57enum(0, ""),
        CatCVR.CVR_COVR to S57enum(1, "coverage"),
        CatCVR.CVR_NCVR to S57enum(2, "no_coverage"),
    )

    private val keys = mapOf(
        S57att.Att.UNKATT to S57key(Conv.A, null),
        S57att.Att.AGENCY to S57key(Conv.A, null),
        S57att.Att.BCNSHP to S57key(Conv.E, Bcnshp),
        S57att.Att.BUISHP to S57key(Conv.E, Buishp),
        S57att.Att.BOYSHP to S57key(Conv.E, Boyshp),
        S57att.Att.BURDEP to S57key(Conv.F, null),
        S57att.Att.CALSGN to S57key(Conv.S, null),
        S57att.Att.CATAIR to S57key(Conv.L, Catair),
        S57att.Att.CATACH to S57key(Conv.L, Catach),
        S57att.Att.CATBRG to S57key(Conv.L, Catbrg),
        S57att.Att.CATBUA to S57key(Conv.E, Catbua),
        S57att.Att.CATCBL to S57key(Conv.E, Catcbl),
        S57att.Att.CATCAN to S57key(Conv.E, Catcan),
        S57att.Att.CATCAM to S57key(Conv.E, Catcam),
        S57att.Att.CATCHP to S57key(Conv.E, Catchp),
        S57att.Att.CATCOA to S57key(Conv.E, Catcoa),
        S57att.Att.CATCTR to S57key(Conv.E, Catctr),
        S57att.Att.CATCON to S57key(Conv.E, Catcon),
        S57att.Att.CATCRN to S57key(Conv.E, Catcrn),
        S57att.Att.CATDAM to S57key(Conv.E, Catdam),
        S57att.Att.CATDIS to S57key(Conv.E, Catdis),
        S57att.Att.CATDOC to S57key(Conv.E, Catdoc),
        S57att.Att.CATDPG to S57key(Conv.L, Catdpg),
        S57att.Att.CATFNC to S57key(Conv.E, Catfnc),
        S57att.Att.CATFRY to S57key(Conv.E, Catfry),
        S57att.Att.CATFIF to S57key(Conv.E, Catfif),
        S57att.Att.CATFOG to S57key(Conv.E, Catfog),
        S57att.Att.CATFOR to S57key(Conv.E, Catfor),
        S57att.Att.CATGAT to S57key(Conv.E, Catgat),
        S57att.Att.CATHAF to S57key(Conv.L, Cathaf),
        S57att.Att.CATHLK to S57key(Conv.L, Cathlk),
        S57att.Att.CATICE to S57key(Conv.E, Catice),
        S57att.Att.CATINB to S57key(Conv.E, Catinb),
        S57att.Att.CATLND to S57key(Conv.L, Catlnd),
        S57att.Att.CATLMK to S57key(Conv.L, Catlmk),
        S57att.Att.CATLAM to S57key(Conv.E, Catlam),
        S57att.Att.CATLIT to S57key(Conv.L, Catlit),
        S57att.Att.CATMFA to S57key(Conv.E, Catmfa),
        S57att.Att.CATMPA to S57key(Conv.L, Catmpa),
        S57att.Att.CATMOR to S57key(Conv.E, Catmor),
        S57att.Att.CATNAV to S57key(Conv.E, Catnav),
        S57att.Att.CATOBS to S57key(Conv.E, Catobs),
        S57att.Att.CATOFP to S57key(Conv.L, Catofp),
        S57att.Att.CATOLB to S57key(Conv.E, Catolb),
        S57att.Att.CATPLE to S57key(Conv.E, Catple),
        S57att.Att.CATPIL to S57key(Conv.E, Catpil),
        S57att.Att.CATPIP to S57key(Conv.L, Catpip),
        S57att.Att.CATPRA to S57key(Conv.E, Catpra),
        S57att.Att.CATPYL to S57key(Conv.E, Catpyl),
        S57att.Att.CATRAS to S57key(Conv.E, Catras),
        S57att.Att.CATRTB to S57key(Conv.E, Catrtb),
        S57att.Att.CATROS to S57key(Conv.L, Catros),
        S57att.Att.CATTRK to S57key(Conv.E, Cattrk),
        S57att.Att.CATRSC to S57key(Conv.L, Catrsc),
        S57att.Att.CATREA to S57key(Conv.L, Catrea),
        S57att.Att.CATROD to S57key(Conv.E, Catrod),
        S57att.Att.CATRUN to S57key(Conv.E, Catrun),
        S57att.Att.CATSEA to S57key(Conv.E, Catsea),
        S57att.Att.CATSIL to S57key(Conv.E, Catsil),
        S57att.Att.CATSLO to S57key(Conv.E, Catslo),
        S57att.Att.CATSCF to S57key(Conv.L, Catscf),
        S57att.Att.CATSLC to S57key(Conv.E, Catslc),
        S57att.Att.CATSIT to S57key(Conv.L, Catsit),
        S57att.Att.CATSIW to S57key(Conv.L, Catsiw),
        S57att.Att.CATSPM to S57key(Conv.L, Catspm),
        S57att.Att.CATTSS to S57key(Conv.E, Cattss),
        S57att.Att.CATVEG to S57key(Conv.L, Catveg),
        S57att.Att.CATWAT to S57key(Conv.E, Catwat),
        S57att.Att.CATWED to S57key(Conv.E, Catwed),
        S57att.Att.CATWRK to S57key(Conv.E, Catwrk),
        S57att.Att.COLOUR to S57key(Conv.L, Colour),
        S57att.Att.COLPAT to S57key(Conv.L, Colpat),
        S57att.Att.COMCHA to S57key(Conv.A, null),
        S57att.Att.CPDATE to S57key(Conv.A, null),
        S57att.Att.CSCALE to S57key(Conv.I, null),
        S57att.Att.CONDTN to S57key(Conv.E, Condtn),
        S57att.Att.CONRAD to S57key(Conv.E, Conrad),
        S57att.Att.CONVIS to S57key(Conv.E, Convis),
        S57att.Att.CURVEL to S57key(Conv.F, null),
        S57att.Att.DATEND to S57key(Conv.A, null),
        S57att.Att.DATSTA to S57key(Conv.A, null),
        S57att.Att.DRVAL1 to S57key(Conv.F, null),
        S57att.Att.DRVAL2 to S57key(Conv.F, null),
        S57att.Att.ELEVAT to S57key(Conv.F, null),
        S57att.Att.ESTRNG to S57key(Conv.F, null),
        S57att.Att.EXCLIT to S57key(Conv.E, Exclit),
        S57att.Att.EXPSOU to S57key(Conv.E, Expsou),
        S57att.Att.FUNCTN to S57key(Conv.L, Functn),
        S57att.Att.HEIGHT to S57key(Conv.F, null),
        S57att.Att.HUNITS to S57key(Conv.E, Hunits),
        S57att.Att.HORACC to S57key(Conv.F, null),
        S57att.Att.HORCLR to S57key(Conv.F, null),
        S57att.Att.HORLEN to S57key(Conv.F, null),
        S57att.Att.HORWID to S57key(Conv.F, null),
        S57att.Att.ICEFAC to S57key(Conv.F, null),
        S57att.Att.INFORM to S57key(Conv.S, null),
        S57att.Att.JRSDTN to S57key(Conv.E, Jrsdtn),
        S57att.Att.LIFCAP to S57key(Conv.F, null),
        S57att.Att.LITCHR to S57key(Conv.E, Litchr),
        S57att.Att.LITVIS to S57key(Conv.L, Litvis),
        S57att.Att.MARSYS to S57key(Conv.E, Marsys),
        S57att.Att.MLTYLT to S57key(Conv.I, null),
        S57att.Att.NATION to S57key(Conv.A, null),
        S57att.Att.NATCON to S57key(Conv.L, Natcon),
        S57att.Att.NATSUR to S57key(Conv.L, Natsur),
        S57att.Att.NATQUA to S57key(Conv.L, Natqua),
        S57att.Att.NMDATE to S57key(Conv.A, null),
        S57att.Att.OBJNAM to S57key(Conv.S, null),
        S57att.Att.ORIENT to S57key(Conv.F, null),
        S57att.Att.PEREND to S57key(Conv.A, null),
        S57att.Att.PERSTA to S57key(Conv.A, null),
        S57att.Att.PICREP to S57key(Conv.S, null),
        S57att.Att.PILDST to S57key(Conv.S, null),
        S57att.Att.PRCTRY to S57key(Conv.A, null),
        S57att.Att.PRODCT to S57key(Conv.L, Prodct),
        S57att.Att.PUBREF to S57key(Conv.S, null),
        S57att.Att.QUASOU to S57key(Conv.L, Quasou),
        S57att.Att.RADWAL to S57key(Conv.A, null),
        S57att.Att.RADIUS to S57key(Conv.F, null),
        S57att.Att.RYRMGV to S57key(Conv.A, null),
        S57att.Att.RESTRN to S57key(Conv.L, Restrn),
        S57att.Att.SCAMIN to S57key(Conv.I, null),
        S57att.Att.SCVAL1 to S57key(Conv.I, null),
        S57att.Att.SCVAL2 to S57key(Conv.I, null),
        S57att.Att.SECTR1 to S57key(Conv.F, null),
        S57att.Att.SECTR2 to S57key(Conv.F, null),
        S57att.Att.SHIPAM to S57key(Conv.A, null),
        S57att.Att.SIGFRQ to S57key(Conv.I, null),
        S57att.Att.SIGGEN to S57key(Conv.E, Siggen),
        S57att.Att.SIGGRP to S57key(Conv.A, null),
        S57att.Att.SIGPER to S57key(Conv.F, null),
        S57att.Att.SIGSEQ to S57key(Conv.A, null),
        S57att.Att.SOUACC to S57key(Conv.F, null),
        S57att.Att.SDISMX to S57key(Conv.I, null),
        S57att.Att.SDISMN to S57key(Conv.I, null),
        S57att.Att.SORDAT to S57key(Conv.A, null),
        S57att.Att.SORIND to S57key(Conv.A, null),
        S57att.Att.STATUS to S57key(Conv.L, Status),
        S57att.Att.SURATH to S57key(Conv.S, null),
        S57att.Att.SUREND to S57key(Conv.A, null),
        S57att.Att.SURSTA to S57key(Conv.A, null),
        S57att.Att.SURTYP to S57key(Conv.L, Surtyp),
        S57att.Att.TECSOU to S57key(Conv.L, Tecsou),
        S57att.Att.TXTDSC to S57key(Conv.S, null),
        S57att.Att.TS_TSP to S57key(Conv.A, null),
        S57att.Att.TS_TSV to S57key(Conv.A, null),
        S57att.Att.T_ACWL to S57key(Conv.E, null),
        S57att.Att.T_HWLW to S57key(Conv.A, null),
        S57att.Att.T_MTOD to S57key(Conv.E, null),
        S57att.Att.T_THDF to S57key(Conv.A, null),
        S57att.Att.T_TINT to S57key(Conv.I, null),
        S57att.Att.T_TSVL to S57key(Conv.A, null),
        S57att.Att.T_VAHC to S57key(Conv.A, null),
        S57att.Att.TIMEND to S57key(Conv.A, null),
        S57att.Att.TIMSTA to S57key(Conv.A, null),
        S57att.Att.TOPSHP to S57key(Conv.E, Topshp),
        S57att.Att.TRAFIC to S57key(Conv.E, Trafic),
        S57att.Att.VALACM to S57key(Conv.F, null),
        S57att.Att.VALDCO to S57key(Conv.F, null),
        S57att.Att.VALLMA to S57key(Conv.F, null),
        S57att.Att.VALMAG to S57key(Conv.F, null),
        S57att.Att.VALMXR to S57key(Conv.F, null),
        S57att.Att.VALNMR to S57key(Conv.F, null),
        S57att.Att.VALSOU to S57key(Conv.F, null),
        S57att.Att.VERACC to S57key(Conv.F, null),
        S57att.Att.VERCLR to S57key(Conv.F, null),
        S57att.Att.VERCCL to S57key(Conv.F, null),
        S57att.Att.VERCOP to S57key(Conv.F, null),
        S57att.Att.VERCSA to S57key(Conv.F, null),
        S57att.Att.VERDAT to S57key(Conv.E, Verdat),
        S57att.Att.VERLEN to S57key(Conv.F, null),
        S57att.Att.WATLEV to S57key(Conv.E, Watlev),
        S57att.Att.CAT_TS to S57key(Conv.E, Cat_ts),
        S57att.Att.NINFOM to S57key(Conv.S, null),
        S57att.Att.NOBJNM to S57key(Conv.S, null),
        S57att.Att.NPLDST to S57key(Conv.S, null),
        S57att.Att.NTXTDS to S57key(Conv.S, null),
        S57att.Att.HORDAT to S57key(Conv.E, null),
        S57att.Att.POSACC to S57key(Conv.F, null),
        S57att.Att.QUAPOS to S57key(Conv.E, Quapos),
        S57att.Att.CLSDNG to S57key(Conv.E, Clsdng),
        S57att.Att.DIRIMP to S57key(Conv.L, Dirimp),
        S57att.Att.DISBK1 to S57key(Conv.F, null),
        S57att.Att.DISBK2 to S57key(Conv.F, null),
        S57att.Att.DISIPU to S57key(Conv.F, null),
        S57att.Att.DISIPD to S57key(Conv.F, null),
        S57att.Att.ELEVA1 to S57key(Conv.F, null),
        S57att.Att.ELEVA2 to S57key(Conv.F, null),
        S57att.Att.FNCTNM to S57key(Conv.E, Fnctnm),
        S57att.Att.WTWDIS to S57key(Conv.F, null),
        S57att.Att.BUNVES to S57key(Conv.E, Bunves),
        S57att.Att.COMCTN to S57key(Conv.S, null),
        S57att.Att.HORCLL to S57key(Conv.F, null),
        S57att.Att.HORCLW to S57key(Conv.F, null),
        S57att.Att.TRSHGD to S57key(Conv.L, Trshgd),
        S57att.Att.UNLOCD to S57key(Conv.S, null),
        S57att.Att.HIGWAT to S57key(Conv.F, null),
        S57att.Att.HIGNAM to S57key(Conv.S, null),
        S57att.Att.LOWWAT to S57key(Conv.F, null),
        S57att.Att.LOWNAM to S57key(Conv.S, null),
        S57att.Att.MEAWAT to S57key(Conv.F, null),
        S57att.Att.MEANAM to S57key(Conv.S, null),
        S57att.Att.OTHWAT to S57key(Conv.F, null),
        S57att.Att.OTHNAM to S57key(Conv.S, null),
        S57att.Att.REFLEV to S57key(Conv.E, Reflev),
        S57att.Att.SDRLEV to S57key(Conv.S, null),
        S57att.Att.VCRLEV to S57key(Conv.S, null),
        S57att.Att.SCHREF to S57key(Conv.S, null),
        S57att.Att.USESHP to S57key(Conv.E, Useshp),
        S57att.Att.CURVHW to S57key(Conv.F, null),
        S57att.Att.CURVLW to S57key(Conv.F, null),
        S57att.Att.CURVMW to S57key(Conv.F, null),
        S57att.Att.CURVOW to S57key(Conv.F, null),
        S57att.Att.APTREF to S57key(Conv.S, null),
        S57att.Att.SHPTYP to S57key(Conv.E, Shptyp),
        S57att.Att.UPDMSG to S57key(Conv.S, null),
        S57att.Att.ADDMRK to S57key(Conv.L, Addmrk),
        S57att.Att.BNKWTW to S57key(Conv.E, Bnkwtw),
        S57att.Att.CATNMK to S57key(Conv.E, Catnmk),
        S57att.Att.CATBRT to S57key(Conv.L, Catbrt),
        S57att.Att.CATBUN to S57key(Conv.L, Catbun),
        S57att.Att.CATCCL to S57key(Conv.L, Catccl),
        S57att.Att.CATCOM to S57key(Conv.L, Catcom),
        S57att.Att.CATHBR to S57key(Conv.L, Cathbr),
        S57att.Att.CATRFD to S57key(Conv.L, Catrfd),
        S57att.Att.CATTML to S57key(Conv.L, Cattml),
        S57att.Att.CATGAG to S57key(Conv.L, Catgag),
        S57att.Att.CATVTR to S57key(Conv.L, Catvtr),
        S57att.Att.CATTAB to S57key(Conv.E, Cattab),
        S57att.Att.CATEXS to S57key(Conv.E, Catexs),
        S57att.Att.LG_SPD to S57key(Conv.F, null),
        S57att.Att.LG_SPR to S57key(Conv.L, Lg_spr),
        S57att.Att.LG_BME to S57key(Conv.F, null),
        S57att.Att.LG_LGS to S57key(Conv.F, null),
        S57att.Att.LG_DRT to S57key(Conv.F, null),
        S57att.Att.LG_WDP to S57key(Conv.F, null),
        S57att.Att.LG_WDU to S57key(Conv.E, Lg_wdu),
        S57att.Att.LG_REL to S57key(Conv.L, Lg_rel),
        S57att.Att.LG_FNC to S57key(Conv.L, Lg_fnc),
        S57att.Att.LG_DES to S57key(Conv.S, null),
        S57att.Att.LG_PBR to S57key(Conv.S, null),
        S57att.Att.LC_CSI to S57key(Conv.L, Lc_csi),
        S57att.Att.LC_CSE to S57key(Conv.L, Lc_cse),
        S57att.Att.LC_ASI to S57key(Conv.L, Lc_asi),
        S57att.Att.LC_ASE to S57key(Conv.L, Lc_ase),
        S57att.Att.LC_CCI to S57key(Conv.L, Lc_cci),
        S57att.Att.LC_CCE to S57key(Conv.L, Lc_cce),
        S57att.Att.LC_BM1 to S57key(Conv.F, null),
        S57att.Att.LC_BM2 to S57key(Conv.F, null),
        S57att.Att.LC_LG1 to S57key(Conv.F, null),
        S57att.Att.LC_LG2 to S57key(Conv.F, null),
        S57att.Att.LC_DR1 to S57key(Conv.F, null),
        S57att.Att.LC_DR2 to S57key(Conv.F, null),
        S57att.Att.LC_SP1 to S57key(Conv.F, null),
        S57att.Att.LC_SP2 to S57key(Conv.F, null),
        S57att.Att.LC_WD1 to S57key(Conv.F, null),
        S57att.Att.LC_WD2 to S57key(Conv.F, null),
        S57att.Att.CATCVR to S57key(Conv.E, Catcvr),
    )

    fun s57Enum(`val`: String?, att: S57att.Att?): Enum<*>? { // Convert S57 attribute value string to SCM enumeration
        val s57key: S57key? = keys[att]
        val map = s57key!!.map
        var unkn: Enum<*>? = null
        val i = try {
            `val`!!.toInt()
        } catch (e: Exception) {
            return unkn
        }
        if (map != null) {
            for (item in map.keys) {
                if (unkn == null) unkn = item as Enum<*>
                if (map[item]!!.atvl == i) return item as Enum<*>
            }
        }
        return unkn
    }

    fun decodeValue(
        `val`: String?,
        att: S57att.Att?
    ): AttVal<*>? { // Convert S57 attribute value string to SCM attribute value
        when (val conv = keys[att]!!.conv) {
            Conv.A, Conv.S -> return AttVal<String?>(conv, `val`)
            Conv.E -> {
                val list = ArrayList<Enum<*>?>()
                list.add(s57Enum(`val`, att))
                return AttVal<ArrayList<*>?>(Conv.E, list)
            }
            Conv.L -> {
                val list = ArrayList<Enum<*>?>()
                for (item in `val`!!.split(",".toRegex()).dropLastWhile { it.isEmpty() }.toTypedArray()) {
                    list.add(s57Enum(item, att))
                }
                return AttVal<ArrayList<*>?>(Conv.L, list)
            }
            Conv.I -> {
                return try {
                    AttVal<Long?>(Conv.I, `val`!!.toLong())
                } catch (e: Exception) {
                    return null
                }
                return try {
                    AttVal<Double?>(Conv.F, `val`!!.toDouble())
                } catch (e: Exception) {
                    return null
                }
            }
            Conv.F -> return try {
                AttVal<Double?>(Conv.F, `val`!!.toDouble())
            } catch (e: Exception) {
                return null
            }
        }
        return null
    }

    fun encodeValue(
        attval: AttVal<*>?,
        att: S57att.Att?
    ): String? { // Convert SCM attribute value to S57 attribute value string
        if (attval != null) {
            var str = stringValue(attval, att)
            if (attval.conv == Conv.E || attval.conv == Conv.L) {
                val vals: Array<String?> = str!!.split(";".toRegex()).dropLastWhile { it.isEmpty() }.toTypedArray()
                str = ""
                for (`val` in vals) {
                    if (str.isNotEmpty()) str += ","
                    val map = keys[att]!!.map
                    for (item in map!!.keys) {
                        if (map[item]!!.`val` == `val`) str += map[item]!!.atvl.toString()
                    }
                }
            }
            return str
        }
        return ""
    }

    fun stringValue(
        attval: AttVal<*>?,
        att: S57att.Att?
    ): String? { // Convert SCM attribute value to OSM attribute value string
        if (attval != null) {
            when (attval.conv) {
                Conv.A, Conv.S -> return attval.`val` as String?
                Conv.E -> {
                    val map = keys[att]!!.map
                    return map!![(attval.`val` as ArrayList<*>?)!![0]]!!.`val`
                }
                Conv.L -> {
                    var str: String? = ""
                    val map = keys[att]!!.map
                    for (item in (attval.`val` as ArrayList<*>?)!!) {
                        if (str!!.isNotEmpty()) str += ";"
                        if (item != null) str += (map?.get(item) as S57enum).`val`
                    }
                    return str
                }
                Conv.I -> return (attval.`val` as Long?).toString()
                Conv.F -> return (attval.`val` as Double?).toString()
            }
        }
        return ""
    }

    fun osmEnum(`val`: String?, att: S57att.Att?): Enum<*>? { // Convert OSM attribute value string to SCM enumeration
        val map = keys[att]!!.map
        var unkn: Enum<*>? = null
        if (map != null) {
            for (item in map.keys) {
                if (unkn == null) unkn = item as Enum<*>
                if (map[item]!!.`val` == `val`) return item as Enum<*>
            }
        }
        return unkn
    }

    fun convertValue(
        `val`: String?,
        att: S57att.Att?
    ): AttVal<*>? { // Convert OSM attribute value string to SCM attribute value
        when (keys[att]!!.conv) {
            Conv.A, Conv.S -> return AttVal<String?>(Conv.S, `val`)
            Conv.E -> {
                val list = ArrayList<Enum<*>?>()
                list.add(osmEnum(`val`, att))
                return AttVal<ArrayList<*>?>(Conv.E, list)
            }
            Conv.L -> {
                val list = ArrayList<Enum<*>?>()
                for (item in `val`!!.split(";".toRegex()).dropLastWhile { it.isEmpty() }.toTypedArray()) {
                    list.add(osmEnum(item, att))
                }
                return AttVal<ArrayList<*>?>(Conv.L, list)
            }
            Conv.I -> {
                return try {
                    AttVal<Long?>(Conv.I, `val`!!.toLong())
                } catch (e: Exception) {
                    return null
                }
                return try {
                    AttVal<Double?>(Conv.F, `val`!!.toDouble())
                } catch (e: Exception) {
                    return null
                }
            }
            Conv.F -> return try {
                AttVal<Double?>(Conv.F, `val`!!.toDouble())
            } catch (e: Exception) {
                return null
            }
        }
        return AttVal<Any?>(keys[att]!!.conv, null)
    }

    @JvmStatic
    fun unknAtt(att: S57att.Att?): Enum<*> {
        val s57key: S57key? = keys[att]
        return s57key!!.map!!.keys.toTypedArray()[0] as Enum<*>
    }

    // CHECKSTYLE.OFF: LineLength
    internal class S57enum(var atvl: Int?, var `val`: String?)

    enum class Conv {
        S, A, L, E, F, I
    }

    internal data class S57key(val conv: Conv?, val map: Map<Any, S57enum>?)

    class AttVal<V> internal constructor(var conv: Conv?, var `val`: V?)

    enum class BcnSHP {
        BCN_UNKN, BCN_STAK, BCN_WTHY, BCN_TOWR, BCN_LATT, BCN_PILE, BCN_CARN, BCN_BUOY, BCN_POLE, BCN_PRCH, BCN_POST
    }

    enum class BuiSHP {
        BUI_UNKN, BUI_HIRS, BUI_PYRD, BUI_CYLR, BUI_SPHR, BUI_CUBE
    }

    enum class BoySHP {
        BOY_UNKN, BOY_CONE, BOY_CAN, BOY_SPHR, BOY_PILR, BOY_SPAR, BOY_BARL, BOY_SUPR, BOY_ICE
    }

    enum class CatAIR {
        AIR_UNKN, AIR_MILA, AIR_CIVA, AIR_MILH, AIR_CIVH, AIR_GLDR, AIR_SMLP, AIR_EMRG
    }

    enum class CatACH {
        ACH_UNKN, ACH_UNRD, ACH_DEEP, ACH_TANK, ACH_EXPL, ACH_QUAR, ACH_SEAP, ACH_SMCF, ACH_SMCM, ACH_H24P, ACH_LTPD,
        ACH_NPSH, ACH_DRYC, ACH_RAFT, ACH_WAIT, ACH_REPT
    }

    enum class CatBRG {
        BRG_UNKN, BRG_FIXD, BRG_OPEN, BRG_SWNG, BRG_LIFT, BRG_BASC, BRG_PONT, BRG_DRAW, BRG_TRNS, BRG_FOOT, BRG_VIAD,
        BRG_AQUA, BRG_SUSP
    }

    enum class CatBUA {
        BUA_UNKN, BUA_URBN, BUA_STTL, BUA_VLLG, BUA_TOWN, BUA_CITY, BUA_HOLV
    }

    enum class CatCBL {
        CBL_UNKN, CBL_POWR, CBL_TRNS, CBL_TELE, CBL_TGPH, CBL_MOOR, CBL_OPTC, CBL_FERY
    }

    enum class CatCAN {
        CAN_UNKN, CAN_TRNS, CAN_DRNG, CAN_IRGN
    }

    enum class CatCAM {
        CAM_UNKN, CAM_NORTH, CAM_EAST, CAM_SOUTH, CAM_WEST
    }

    enum class CatCHP {
        CHP_UNKN, CHP_CSTM, CHP_BRDR
    }

    enum class CatCOA {
        COA_UNKN, COA_STEP, COA_FLAT, COA_SAND, COA_STON, COA_SHNG, COA_GLCR, COA_MNGV, COA_MRSH, COA_CRRF,
        COA_ICE, COA_SHEL
    }

    enum class CatCTR {
        CTR_UNKN, CTR_TRGN, CTR_OBSV, CTR_FIXD, CTR_BMRK, CTR_BDRY, CTR_HORM, CTR_HORS
    }

    enum class CatCON {
        CON_UNKN, CAT_AERL, CAT_BELT
    }

    enum class CatCRN {
        CRN_UNKN, CRN_NONS, CRN_CONT, CRN_SHRL, CRN_TRAV, CRN_AFRM, CRN_GLTH
    }

    enum class CatDAM {
        DAM_UNKN, DAM_WEIR, DAM_DAM, DAM_FLDB
    }

    enum class CatDIS {
        DIS_UNKN, DIS_NONI, DIS_POLE, DIS_BORD, DIS_UKSH
    }

    enum class CatDOC {
        DOC_UNKN, DOC_TIDL, DOC_NTDL
    }

    enum class CatDPG {
        DPG_UNKN, DPG_GENL, DPG_CHEM, DPG_NCLR, DPG_EXPL, DPG_SPIL, DPG_VSSL
    }

    enum class CatFNC {
        FNC_UNKN, FNC_FENC, FNC_MUIR, FNC_HEDG, FNC_WALL
    }

    enum class CatFRY {
        FRY_UNKN, FRY_FREE, FRY_CABL, FRY_ICE, FRY_SWWR
    }

    enum class CatFIF {
        FIF_UNKN, FIF_STAK, FIF_TRAP, FIF_WEIR, FIF_TUNY
    }

    enum class CatFOG {
        FOG_UNKN, FOG_EXPL, FOG_DIA, FOG_SIRN, FOG_NAUT, FOG_REED, FOG_TYPH, FOG_BELL, FOG_WHIS, FOG_GONG, FOG_HORN
    }

    enum class CatFOR {
        FOR_UNKN, FOR_CSTL, FOR_FORT, FOR_BTTY, FOR_BKHS, FOR_MTWR, FOR_RDBT
    }

    enum class CatGAT {
        GAT_UNKN, GAT_GNRL, GAT_FLBG, GAT_CSSN, GAT_LOCK, GAT_DYKE, GAT_SLUC
    }

    enum class CatHAF {
        HAF_UNKN, HAF_RORO, HAF_TMBR, HAF_FERY, HAF_FISH, HAF_MRNA, HAF_NAVL, HAF_TNKR, HAF_PSGR, HAF_YARD, HAF_CNTR,
        HAF_BULK, HAF_SYNC, HAF_STCR, HAF_LUVB, HAF_REPR, HAF_QUAR, HAF_SPLN, HAF_CARG, HAF_OFFS, HAF_SSUP, HAF_MANF
    }

    enum class CatHLK {
        HLK_UNKN, HLK_REST, HLK_HIST, HLK_MUSM, HLK_ACCM, HLK_BWTR, HLK_CSNO
    }

    enum class CatICE {
        ICE_UNKN, ICE_FAST, ICE_SEA, ICE_GRLR, ICE_PANK, ICE_GLAS, ICE_PEAK, ICE_PACK, ICE_POLR
    }

    enum class CatINB {
        INB_UNKN, INB_CALM, INB_SBM
    }

    enum class CatLND {
        LND_UNKN, LND_FEN, LND_MRSH, LND_BOG, LND_HTHL, LND_MNTN, LND_LOWL, LND_CNYN, LND_PDDY, LND_AGRI, LND_SVNA,
        LND_PARK, LND_SWMP, LND_LSLD, LND_LAVA, LND_SLTP, LND_MORN, LND_CRTR, LND_CAVE, LND_PINCL, LND_CAY
    }

    enum class CatLMK {
        LMK_UNKN, LMK_CARN, LMK_CMTY, LMK_CHMY, LMK_DISH, LMK_FLAG, LMK_FLAR, LMK_MAST, LMK_WNDS, LMK_MNMT, LMK_CLMN,
        LMK_MEML, LMK_OBLK, LMK_STAT, LMK_CROS, LMK_DOME, LMK_RADR, LMK_TOWR, LMK_WNDM, LMK_WNDG, LMK_SPIR, LMK_BLDR,
        LMK_TRIM, LMK_BNDM, LMK_OBSW, LMK_TORL
    }

    enum class CatLAM {
        LAM_UNKN, LAM_PORT, LAM_STBD, LAM_PCST, LAM_PCPT, LAM_WWLT, LAM_WWRT, LAM_CHLT, LAM_CHRT, LAM_WWSN, LAM_CHSN,
        LAM_CHRB, LAM_CHLB, LAM_CRRT, LAM_CRLT, LAM_DRLT, LAM_DRRT, LAM_TOLT, LAM_TPRT, LAM_JBRT, LAM_JNLT, LAM_HBRT,
        LAM_HBLT, LAM_BRGP
    }

    enum class CatLIT {
        LIT_UNKN, LIT_DIR, LIT_LEAD, LIT_AERO, LIT_AIR, LIT_FOG, LIT_FLDL, LIT_STRP, LIT_SUBS, LIT_SPOT, LIT_FRNT,
        LIT_REAR, LIT_LOWR, LIT_UPPR, LIT_MOIR, LIT_EMRG, LIT_BRNG, LIT_HORI, LIT_VERT
    }

    enum class CatMFA {
        MFA_UNKN, MFA_CRST, MFA_OYMS, MFA_FISH, MFA_SEAW, MFA_PRLC
    }

    enum class CatMPA {
        MPA_UNKN, MPA_PRCT, MPA_TRPD, MPA_SUBM, MPA_FIRG, MPA_MINL, MPA_SMLA
    }

    enum class CatMOR {
        MOR_UNKN, MOR_DLPN, MOR_DDPN, MOR_BLRD, MOR_WALL, MOR_PILE, MOR_CHAN, MOR_BUOY, MOR_SHRP, MOR_AUTO, MOR_POST,
        MOR_WIRE, MOR_CABL
    }

    enum class CatNAV {
        NAV_UNKN, NAV_CLRG, NAV_TRST, NAV_LDNG
    }

    enum class CatOBS {
        OBS_UNKN, OBS_STMP, OBS_WELH, OBS_DIFF, OBS_CRIB, OBS_FHVN, OBS_FLAR, OBS_FLGD, OBS_ICEB, OBS_GTKL, OBS_BOOM,
        OBS_UWTB, OBS_TPLT, OBS_WEND, OBS_UWAS, OBS_REEF, OBS_MNFD, OBS_PNGO, OBS_RPLT, OBS_SCII
    }

    enum class CatOFP {
        OFP_UNKN, OFP_OIL, OFP_PROD, OFP_OBS, OFP_ALP, OFP_SALM, OFP_MOOR, OFP_AISL, OFP_FPSO, OFP_ACCN, OFP_NCCB,
        OFP_FOTK
    }

    enum class CatOLB {
        OLB_UNKN, OLB_RETN, OLB_FLTG
    }

    enum class CatPLE {
        PLE_UNKN, PLE_STAK, PLE_POST, PLE_TRIP, PLE_PLNG, PLE_PARE, PLE_PIPE
    }

    enum class CatPIL {
        PIL_UNKN, PIL_CVSL, PIL_HELI, PIL_SHOR
    }

    enum class CatPIP {
        PIP_UNKN, PIP_OFAL, PIP_ITAK, PIP_SEWR, PIP_BBLR, PIP_SPPL
    }

    enum class CatPRA {
        PRA_UNKN, PRA_QRRY, PRA_MINE, PRA_STPL, PRA_PSTN, PRA_RFNY, PRA_TYRD, PRA_FACT, PRA_TFRM, PRA_WFRM,
        PRA_SLAG, PRA_CURF, PRA_OILF, PRA_GASF, PRA_WAVE
    }

    enum class CatPYL {
        PYL_UNKN, PYL_POWR, PYL_TELE, PYL_AERL, PYL_BRDG, PYL_PIER
    }

    enum class CatRAS {
        RAS_UNKN, RAS_SURV, RAS_COST
    }

    enum class CatRTB {
        RTB_UNKN, RTB_RAMK, RTB_RACN, RTB_LDG
    }

    enum class CatROS {
        ROS_UNKN, ROS_OMNI, ROS_DIRL, ROS_ROTP, ROS_CNSL, ROS_RDF, ROS_QTA, ROS_AERO, ROS_DECA, ROS_LORN, ROS_DGPS,
        ROS_TORN, ROS_OMGA, ROS_SYLD, ROS_CHKA, ROS_PCOM, ROS_COMB, ROS_FACS, ROS_TIME, ROS_PAIS, ROS_SAIS, ROS_VAIS,
        ROS_VANC, ROS_VASC, ROS_VAEC, ROS_VAWC, ROS_VAPL, ROS_VASL, ROS_VAID, ROS_VASW, ROS_VASP, ROS_VAWK
    }

    enum class CatRSC {
        RSC_UNKN, RSC_LIFB, RSC_ROKT, RSC_LBRK, RSC_RFSW, RSC_RFIT, RSC_LBOM, RSC_RDIO, RSC_FSTA, RSC_SPLN,
        RSC_ACFT, RSC_STUG
    }

    enum class CatREA {
        REA_UNKN, REA_SFTY, REA_NANC, REA_NFSH, REA_NATR, REA_BRDS, REA_GRSV, REA_SEAL, REA_DEGR, REA_MILY,
        REA_HIST, REA_INST, REA_NASF, REA_STRD, REA_MINE, REA_NDIV, REA_TBAV, REA_PROH, REA_SWIM, REA_WAIT,
        REA_RSCH, REA_DREG, REA_FSNC, REA_ERES, REA_NWAK, REA_SWNG, REA_WSKI, REA_ESSA, REA_PSSA, REA_DISA,
        REA_PSAR, REA_CRLS
    }

    enum class CatROD {
        ROD_UNKN, ROD_MWAY, ROD_MAJR, ROD_MINR, ROD_TRAK, ROD_MAJS, ROD_MINS, ROD_CRSG, ROD_PATH
    }

    enum class CatRUN {
        RUN_UNKN, RUN_AERP, RUN_HELI
    }

    enum class CatSEA {
        SEA_UNKN, SEA_GENL, SEA_GAT, SEA_BANK, SEA_DEEP, SEA_BAY, SEA_TRCH, SEA_BASN, SEA_MDFT, SEA_REEF, SEA_LEDG,
        SEA_CNYN, SEA_NRRW, SEA_SHOL, SEA_KNOL, SEA_RIDG, SEA_SMNT, SEA_PNCL, SEA_APLN, SEA_PLTU, SEA_SPUR, SEA_SHLF,
        SEA_TRGH, SEA_SDDL, SEA_AHLL, SEA_APRN, SEA_AAPN, SEA_BLND, SEA_CMGN, SEA_CRIS, SEA_ESCT, SEA_FAN, SEA_FZON,
        SEA_GAP, SEA_GUYT, SEA_HILL, SEA_HOLE, SEA_LEVE, SEA_MVLY, SEA_MOAT, SEA_MTNS, SEA_PEAK, SEA_PVNC, SEA_RISE,
        SEA_SCNL, SEA_SCHN, SEA_SEDG, SEA_SILL, SEA_SLOP, SEA_TRRC, SEA_VLLY, SEA_CANL, SEA_LAKE, SEA_RIVR, SEA_RECH
    }

    enum class CatSLC {
        SLC_UNKN, SLC_BWTR, SLC_GRYN, SLC_MOLE, SLC_PIER, SLC_PPER, SLC_WHRF, SLC_TWAL, SLC_RPRP, SLC_RVMT, SLC_SWAL,
        SLC_LSTP, SLC_RAMP, SLC_SWAY, SLC_FNDR, SLC_SFWF, SLC_OFWF, SLC_LRMP, SLC_LWAL, SLC_ICEB
    }

    enum class CatSIT {
        SIT_UNKN, SIT_PRTC, SIT_PRTE, SIT_IPT, SIT_BRTH, SIT_DOCK, SIT_LOCK, SIT_FLDB, SIT_BRDG, SIT_DRDG, SIT_TCLT,
        SIT_SPCL, SIT_PLTG, SIT_ONCT
    }

    enum class CatSIW {
        SIW_UNKN, SIW_DNGR, SIW_OBST, SIW_CABL, SIW_MILY, SIW_DSTR, SIW_WTHR, SIW_STRM, SIW_ICE, SIW_TIME, SIW_TIDE,
        SIW_TSTR, SIW_TIDG, SIW_TIDS, SIW_DIVE, SIW_WTLG, SIW_VRCL, SIW_HIWM, SIW_DPTH, SIW_CURR
    }

    enum class CatSIL {
        SIL_UNKN, SIL_SILO, SIL_TANK, SIL_GRNE, SIL_WTRT
    }

    enum class CatSLO {
        SLO_UNKN, SLO_CUTG, SLO_EMBK, SLO_DUNE, SLO_HILL, SLO_PINO, SLO_CLIF, SLO_SCRE
    }

    enum class CatSCF {
        SCF_UNKN, SCF_VBTH, SCF_CLUB, SCF_BHST, SCF_SMKR, SCF_BTYD, SCF_INN, SCF_RSRT, SCF_CHDR, SCF_PROV, SCF_DCTR,
        SCF_PHRM, SCF_WTRT, SCF_FUEL, SCF_ELEC, SCF_BGAS, SCF_SHWR, SCF_LAUN, SCF_WC, SCF_POST, SCF_TELE, SCF_REFB,
        SCF_CARP, SCF_BTPK, SCF_CRVN, SCF_CAMP, SCF_PMPO, SCF_EMRT, SCF_SLPW, SCF_VMOR, SCF_SCRB, SCF_PCNC, SCF_MECH,
        SCF_SECS
    }

    enum class CatSPM {
        SPM_UNKN, SPM_FDGA, SPM_TRGT, SPM_MSHP, SPM_DGRG, SPM_BARG, SPM_CABL, SPM_SPLG, SPM_OFAL, SPM_ODAS, SPM_RCDG,
        SPM_SPLA, SPM_RCZN, SPM_PRVT, SPM_MOOR, SPM_LNBY, SPM_LDNG, SPM_MDST, SPM_NOTC, SPM_TSS, SPM_NANC, SPM_NBRT,
        SPM_NOTK, SPM_NTWT, SPM_RWAK, SPM_SPDL, SPM_STOP, SPM_WRNG, SPM_SSSN, SPM_RVCL, SPM_MVDT, SPM_RHCL, SPM_SCNT,
        SPM_BRTH, SPM_OHPC, SPM_CHEG, SPM_TELE, SPM_FCRS, SPM_MTRL, SPM_PLIN, SPM_ANCH, SPM_CLRG, SPM_CTRL, SPM_DIVG,
        SPM_RBCN, SPM_FGND, SPM_YCHT, SPM_HPRT, SPM_GPS, SPM_SLDG, SPM_NENT, SPM_WRKP, SPM_UKPP, SPM_WELH, SPM_CHSP,
        SPM_MFRM, SPM_AREF
    }

    enum class CatTRK {
        TRK_UNKN, TRK_FIXM, TRK_NFXM
    }

    enum class CatTSS {
        TSS_UNKN, TSS_IMOA, TSS_NIMO
    }

    enum class CatVEG {
        VEG_UNKN, VEG_GRAS, VEG_PDDY, VEG_BUSH, VEG_DCDW, VEG_CONW, VEG_WOOD, VEG_MGRV, VEG_PARK, VEG_PKLD, VEG_MCRP,
        VEG_REED, VEG_MOSS, VEG_TREE, VEG_EVGT, VEG_CONT, VEG_PLMT, VEG_NPMT, VEG_CSAT, VEG_EUCT, VEG_DCDT, VEG_MRVT,
        VEG_FLOT
    }

    enum class CatWAT {
        WAT_UNKN, WAT_BKRS, WAT_EDDY, WAT_OVFL, WAT_TDRP, WAT_BMBR
    }

    enum class CatWED {
        WED_UNKN, WED_KELP, WED_SWED, WED_SGRS, WED_SGSO
    }

    enum class CatWRK {
        WRK_UNKN, WRK_NDGR, WRK_DNGR, WRK_DREM, WRK_MSTS, WRK_HULS
    }

    enum class CatZOC {
        ZOC_UNKN, ZOC_A1, ZOC_A2, ZOC_B, ZOC_C, ZOC_D, ZOC_U
    }

    enum class ColCOL {
        COL_UNK, COL_WHT, COL_BLK, COL_RED, COL_GRN, COL_BLU, COL_YEL, COL_GRY, COL_BRN, COL_AMB, COL_VIO, COL_ORG,
        COL_MAG, COL_PNK
    }

    enum class ColPAT {
        PAT_UNKN, PAT_HORI, PAT_VERT, PAT_DIAG, PAT_SQUR, PAT_STRP, PAT_BRDR, PAT_CROS, PAT_SALT
    }

    enum class CndCND {
        CND_UNKN, CND_UCNS, CND_RUIN, CND_URCL, CND_WLES, CND_PCNS
    }

    enum class ConRAD {
        RAD_UNKN, RAD_CNSP, RAD_NCSP, RAD_REFL
    }

    enum class ConVIS {
        VIS_UNKN, VIS_CNSP, VIS_NCSP
    }

    enum class UniDPU {
        DPU_UNKN, DPU_METR, DPU_FTFT, DPU_FTHM, DPU_FTFR
    }

    enum class ExcLIT {
        EXH_UNKN, EXH_24H, EXH_DAY, EXH_FOG, EXH_NGHT, EXH_WRNG, EXH_STRM
    }

    enum class ExpSOU {
        EXP_UNKN, EXP_WTHN, EXP_SHLR, EXP_DEPR
    }

    enum class FncFNC {
        FNC_UNKN, FNC_HBRM, FNC_CSTM, FNC_HLTH, FNC_HOSP, FNC_POST, FNC_HOTL, FNC_RAIL, FNC_POLC, FNC_WPOL, FNC_PILO,
        FNC_PILL, FNC_BANK, FNC_DIST, FNC_TRNS, FNC_FCTY, FNC_POWR, FNC_ADMIN, FNC_EDUC, FNC_CHCH, FNC_CHPL, FNC_TMPL,
        FNC_PGDA, FNC_SHSH, FNC_BTMP, FNC_MOSQ, FNC_MRBT, FNC_LOOK, FNC_COMM, FNC_TV, FNC_RADO, FNC_RADR, FNC_LGHT,
        FNC_MCWV, FNC_COOL, FNC_OBS, FNC_TMBL, FNC_CLOK, FNC_CTRL, FNC_ASHM, FNC_STAD, FNC_BUSS, FNC_PTRM, FNC_SRCT,
        FNC_OBSV, FNC_OREC, FNC_BTHS, FNC_PMPS
    }

    enum class UniHLU {
        HLU_UNKN, HLU_METR, HLU_FEET, HLU_KMTR, HLU_HMTR, HLU_SMIL, HLU_NMIL
    }

    enum class JrsJRS {
        JRS_UNKN, JRS_INT, JRS_NAT, JRS_NSD
    }

    enum class LitCHR {
        CHR_UNKN, CHR_F, CHR_FL, CHR_LFL, CHR_Q, CHR_VQ, CHR_UQ, CHR_ISO, CHR_OC, CHR_IQ, CHR_IVQ, CHR_IUQ, CHR_MO,
        CHR_FFL, CHR_FLLFL, CHR_OCFL, CHR_FLFL, CHR_ALOC, CHR_ALLFL, CHR_ALFL, CHR_ALGR, CHR_QLFL, CHR_VQLFL,
        CHR_UQLFL, CHR_AL, CHR_ALFFL
    }

    enum class LitVIS {
        LIT_UNKN, LIT_HIGH, LIT_LOW, LIT_FANT, LIT_INTS, LIT_UINT, LIT_RSTR, LIT_OBSC, LIT_POBS
    }

    enum class MarSYS {
        SYS_UNKN, SYS_IALA, SYS_IALB, SYS_NONE, SYS_OTHR, SYS_CEVN, SYS_RIWR, SYS_BWR2, SYS_BNWR, SYS_PPWB
    }

    enum class NatCON {
        CON_UNKN, CON_MSNY, CON_CONC, CON_BDRS, CON_HSRF, CON_USRF, CON_WOOD, CON_METL, CON_GRP, CON_PNTD,
        CON_FMWK, CON_LATT, CON_GLAS
    }

    enum class NatSUR {
        SUR_UNKN, SUR_MUD, SUR_CLAY, SUR_SILT, SUR_SAND, SUR_STON, SUR_GRVL, SUR_PBBL, SUR_CBBL, SUR_ROCK, SUR_LAVA,
        SUR_CORL, SUR_SHEL, SUR_BLDR
    }

    enum class NatQUA {
        QUA_UNKN, QUA_FINE, QUA_MEDM, QUA_CORS, QUA_BRKN, QUA_STKY, QUA_SOFT, QUA_STIF, QUA_VCNC, QUA_CALC, QUA_HARD
    }

    enum class PrdPRD {
        PRD_UNKN, PRD_OIL, PRD_GAS, PRD_WATR, PRD_STON, PRD_COAL, PRD_ORE, PRD_CHEM, PRD_DWTR, PRD_MILK, PRD_BXIT,
        PRD_COKE, PRD_IIGS, PRD_SALT, PRD_SAND, PRD_TMBR, PRD_SDST, PRD_SCRP, PRD_LNA, PRD_LPA, PRD_WINE, PRD_CMNT,
        PRD_GRAN
    }

    enum class QuaSOU {
        SOU_UNKN, SOU_KNWN, SOU_UKNN, SOU_DFUL, SOU_UNRL, SOU_NBFD, SOU_LKWN, SOU_LUKN, SOU_NSRV, SOU_NCNF,
        SOU_MANT, SOU_NMNT
    }

    enum class RstRST {
        RST_UNKN, RST_NANC, RST_RANC, RST_NFSH, RST_RFSH, RST_NTRL, RST_RTRL, RST_NENT, RST_RENT, RST_NDRG,
        RST_RDRG, RST_NDVG, RST_RDVG, RST_NWAK, RST_TBAV, RST_NCST, RST_NDSC, RST_RDSC, RST_NEXD, RST_REXD,
        RST_NDRL, RST_RDRL, RST_NHAR, RST_NLTG, RST_NDRA, RST_NSTP, RST_NLND, RST_RSPD, RST_NOVT, RST_NCOV,
        RST_NPOV, RST_NBRT, RST_RBRT, RST_NMFT, RST_RMFT, RST_NTRN, RST_RFWD, RST_RFWW, RST_NSWM
    }

    enum class SigGEN {
        GEN_UNKN, GEN_AUTO, GEN_WAVE, GEN_HAND, GEN_WIND
    }

    enum class StsSTS {
        STS_UNKN, STS_PERM, STS_OCAS, STS_RCMD, STS_NIUS, STS_IMTT, STS_RESV, STS_TEMP, STS_PRIV, STS_MAND,
        STS_EXTD, STS_ILLD, STS_HIST, STS_PBLC, STS_SYNC, STS_WCHD, STS_UWCD, STS_EDBT, STS_OREQ, STS_DPAW,
        STS_RSNG, STS_INCR, STS_DECR, TS_STNG, STS_GOOD, STS_MODY, STS_POOR
    }

    enum class SurTYP {
        TYP_UNKN, TYP_SKCH, TYP_CTLD, TYP_PSSG, TYP_REMT
    }

    enum class TecSOU {
        SOU_UNKN, SOU_ESND, SOU_FSSN, SOU_MLBM, SOU_DIVR, SOU_LDLN, SOU_WDRG, SOU_LASR, SOU_VACC, SOU_EMAG,
        SOU_PHGY, SOU_SATL, SOU_LEVL, SOU_SSSN, SOU_COMP
    }

    enum class TopSHP {
        TOP_UNKN, TOP_CONE, TOP_ICONE, TOP_SPHR, TOP_ISD, TOP_CAN, TOP_BORD, TOP_SALT, TOP_CROS, TOP_CUBE,
        TOP_WEST, TOP_EAST, TOP_RHOM, TOP_NORTH, TOP_SOUTH, TOP_BESM, TOP_IBESM, TOP_FLAG, TOP_SPRH, TOP_SQUR,
        TOP_HRECT, TOP_VRECT, TOP_TRAP, TOP_ITRAP, TOP_TRI, TOP_ITRI, TOP_CIRC, TOP_CRSS, TOP_T, TOP_TRCL,
        TOP_CRCL, TOP_RHCL, TOP_CLTR, TOP_OTHR, TOP_CYSP, TOP_COSP
    }

    enum class TrfTRF {
        TRF_UNKN, TRF_INBD, TRF_OBND, TRF_ONEW, TRF_TWOW
    }

    enum class WatLEV {
        LEV_UNKN, LEV_PSUB, LEV_DRY, LEV_SUBM, LEV_CVRS, LEV_AWSH, LEV_FLDS, LEV_FLTG, LEV_AMWL, LEV_BMWL
    }

    enum class Cat_TS {
        TS_UNKN, TS_FLOD, TS_EBB, TS_OTHR
    }

    enum class UniPAU {
        PAU_UNKN, PAU_MTRS, PAU_DGRS, PAU_MMTR, PAU_FEET, PAU_CBLS
    }

    enum class QuaPOS {
        POS_UNKN, POS_SRVD, POS_USRV, POS_PSRV, POS_APRX, POS_DBTF, POS_URLB, POS_RSRV, POS_UCNF, POS_ESTM,
        POS_PRCS, POS_CALC
    }

    enum class VerDAT {
        DAT_UNKN, DAT_MLWS, DAT_MLLWS, DAT_MSL, DAT_LLW, DAT_MLW, DAT_LLWS, DAT_AMLWS, DAT_ISLW, DAT_LWS,
        DAT_ALAT, DAT_NLLW, DAT_MLLW, DAT_LW, DAT_AMLW, DAT_AMLLW, DAT_MHW, DAT_MHWS, DAT_HW, DAT_AMSL,
        DAT_HWS, DAT_MHHW, DAT_ESLW, DAT_LAT, DAT_LOCAL, DAT_IGLD, DAT_MWL, DAT_LLWLT, DAT_HHWLT, DAT_NHHW,
        DAT_HAT, DAT_LLWRL, DAT_LHWRL, DAT_LMWRL, DAT_EHW, DAT_HSHW, DAT_RLWL, DAT_HSHWD, DAT_DRLWRL, DAT_RPWL,
        DAT_RNBL, DAT_OHIO
    }

    enum class AddMRK {
        MRK_UNKN, MRK_TOPB, MRK_BOTB, MRK_RTRI, MRK_LTRI, MRK_BTRI
    }

    enum class BnkWTW {
        BWW_UNKN, BWW_LEFT, BWW_RGHT
    }

    enum class CatNMK {
        NMK_UNKN, NMK_NENT, NMK_CLSA, NMK_NOVK, NMK_NCOV, NMK_NPAS, NMK_NBRT, NMK_NBLL, NMK_NANK, NMK_NMOR,
        NMK_NTRN, NMK_NWSH, NMK_NPSL, NMK_NPSR, NMK_NMTC, NMK_NSPC, NMK_NWSK, NMK_NSLC, NMK_NUPC, NMK_NSLB,
        NMK_NWBK, NMK_NHSC, NMK_NLBG, NMK_MVTL, NMK_MVTR, NMK_MVTP, NMK_MVTS, NMK_KPTP, NMK_KPTS, NMK_CSTP,
        NMK_CSTS, NMK_STOP, NMK_SPDL, NMK_SHRN, NMK_KPLO, NMK_GWJN, NMK_GWCS, NMK_MKRC, NMK_LMDP, NMK_LMHR,
        NMK_LMWD, NMK_NAVR, NMK_CHDL, NMK_CHDR, NMK_CHTW, NMK_CHOW, NMK_OPTR, NMK_OPTL, NMK_PRTL, NMK_PRTR,
        NMK_ENTP, NMK_OVHC, NMK_WEIR, NMK_FERN, NMK_FERI, NMK_BRTP, NMK_BTLL, NMK_BTLS, NMK_BTRL, NMK_BTUP,
        NMK_BTP1, NMK_BTP2, NMK_BTP3, NMK_BTUN, NMK_BTN1, NMK_BTN2, NMK_BTN3, NMK_BTUM, NMK_BTU1, NMK_BTU2,
        NMK_BTU3, NMK_ANKP, NMK_MORP, NMK_VLBT, NMK_TRNA, NMK_SWWC, NMK_SWWR, NMK_SWWL, NMK_WRSA, NMK_WLSA,
        NMK_WRSL, NMK_WLSR, NMK_WRAL, NMK_WLAR, NMK_MWWC, NMK_MWWJ, NMK_MWAR, NMK_MWAL, NMK_WARL, NMK_WALR,
        NMK_PEND, NMK_DWTR, NMK_TELE, NMK_MTCP, NMK_SPCP, NMK_WSKP, NMK_SLCP, NMK_UPCP, NMK_SLBP, NMK_RADI,
        NMK_WTBP, NMK_HSCP, NMK_LBGP, NMK_KTPM, NMK_KTSM, NMK_KTMR, NMK_CRTP, NMK_CRTS, NMK_TRBM, NMK_RSPD,
        NMK_WRKP, NMK_PSBS, NMK_NCPS, NMK_NSMC, NMK_ATTN, NMK_FWCR, NMK_SHIP
    }

    enum class ClsDNG {
        DNG_UNKN, DNG_1BLU, DNG_2BLU, DNG_3BLU, DNG_0BLU, DNG_1RED
    }

    enum class DirIMP {
        IMP_UNKN, IMP_UPST, IMP_DNST, IMP_LTBK, IMP_RTBK, IMP_THBR
    }

    enum class FncFNM {
        FNM_UNKN, FNM_PRHB, FNM_RGLN, FNM_RSTN, FNM_RCMD, FNM_INFO
    }

    enum class BunVES {
        VES_UNKN, VES_BVAV, VES_NBVA
    }

    enum class CatBRT {
        BRT_UNKN, BRT_LODG, BRT_ULDG, BRT_OVNT, BRT_PSHN, BRT_NPSH, BRT_FLTG, BRT_FCLS, BRT_SCLS
    }

    enum class CatBUN {
        BUN_UNKN, BUN_DESL, BUN_WATR, BUN_BLST
    }

    enum class CatCCL {
        CCL_UNKN, CCL_SMLV, CCL_PNCH, CCL_CMPB, CCL_DMEB, CCL_RHNB, CCL_1BPT, CCL_2PTL, CCL_2PTW,
        CCL_4BPT, CCL_6BPT, CCL_NCCL
    }

    enum class CatCOM {
        COM_UNKN, COM_VTSC, COM_VTSS, COM_IVSP, COM_MID, COM_LOCK, COM_BRDG, COM_CSTM, COM_HRBR
    }

    enum class CatHBR {
        HBR_UNKN, HBR_CSTM, HBR_REFG, HBR_MRNA, HBR_FISH, HBR_PRIV, HBR_
    }

    enum class CatRFD {
        RFD_UNKN, RFD_CRSD, RFD_WOIL, RFD_GBWT, RFD_DREF
    }

    enum class CatTML {
        TML_UNKN, TML_PSGR, TML_FERY, TML_TSPT, TML_RORO
    }

    enum class TrsTGD {
        TGD_UNKN, TGD_CONT, TGD_BULK, TGD_OIL, TGD_FUEL, TGD_CHEM, TGD_LIQD, TGD_EXPL, TGD_FISH, TGD_CARS, TGD_GNRL
    }

    enum class CatGAG {
        GAG_UNKN, GAG_STAF, GAG_RCRD, GAG_RCRA, GAG_RCEI, GAG_RRAI
    }

    enum class RefLEV {
        LEV_UNKN, LEV_BALT, LEV_ADRC, LEV_AMSD, LEV_MSL, LEV_OTHR, LEV_NG29, LEV_NA88, LEV_1912, LEV_1929
    }

    enum class CatVTR {
        VTR_UNKN, VTR_OFFL, VTR_PRIV, VTR_CARC, VTR_CARP, VTR_PREQ, VTR_LGAT
    }

    enum class CatTAB {
        TAB_UNKN, TAB_OPPD, TAB_NOPP
    }

    enum class UseSHP {
        SHP_UNKN, SHP_LINT, SHP_OCSH, SHP_LESR
    }

    enum class CatEXS {
        EXS_UNKN, EXS_LLOK, EXS_AQDT, EXS_SPLK, EXS_WSLK, EXS_OTHR
    }

    enum class CatWWM {
        WWM_UNKN, WWM_WWRT, WWM_WWLT, WWM_WWSP, WWM_CHRT, WWM_CHLT, WWM_CHSP, WWM_CHRB, WWM_CHLB, WWM_CORT,
        WWM_COLT, WWM_DGRT, WWM_DGLT, WWM_TORT, WWM_TOLT, WWM_JNRT, WWM_JNLT, WWM_HBRT, WWM_HBLT, WWM_BRPR
    }

    enum class Lg_SPR {
        SPR_UNKN, SPR_OTHR, SPR_SPOG, SPR_SPTW
    }

    enum class Lg_WDU {
        WDU_UNKN, WDU_OTHR, WDU_CUMT, WDU_TONS
    }

    enum class Lg_REL {
        REL_UNKN, REL_OTHR, REL_USWW, REL_CREQ, REL_TKOP
    }

    enum class Lg_FNC {
        FNC_UNKN, FNC_OTHR, FNC_PRHB, FNC_PRHE, FNC_PERM, FNC_PERE, FNC_RCMD, FNC_NRCD
    }

    enum class Lc_CSX {
        CSX_UNKN, CSX_ALL, CSX_OTHR, CSX_NMOT, CSX_CRFT, CSX_VSSL, CSX_ILWW, CSX_SEAG, CSX_MOTR, CSX_MTNK,
        CSX_MCGO, CSX_CBRG, CSX_TUG, CSX_PSHR, CSX_BARG, CSX_TNKB, CSX_DMBB, CSX_LGTR, CSX_TNKL, CSX_CGOL,
        CSX_SBLR, CSX_PSGR, CSX_PSGS, CSX_DAYT, CSX_CABN, CSX_HSPD, CSX_FLEQ, CSX_WSIT, CSX_RCNL, CSX_DNGY,
        CSX_FEST, CSX_FOBJ
    }

    enum class Lc_ASX {
        ASX_UNKN, ASX_ALL, ASX_OTHR, ASX_SNGL, ASX_CONV, ASX_FMTN, ASX_RCNV, ASX_PCNV, ASX_BSTD, ASX_TCNV
    }

    enum class Lc_CCX {
        CCX_UNKN, CCX_ALL, CCX_OTHR, CCX_BULK, CCX_DRY, CCX_LIQD, CCX_LQDN, CCX_LQDC, CCX_GAS
    }

    enum class ShpTYP {
        TYP_UNKN, TYP_CRGO, TYP_CONT, TYP_TNKR, TYP_SAIL, TYP_FISH, TYP_SPPS, TYP_MOWR, TYP_SUBM, TYP_HSPD,
        TYP_BCAR, TYP_SPLN, TYP_TUGB, TYP_PSGR, TYP_FERY, TYP_BOAT
    }

    enum class CatCVR {
        CVR_UNKN, CVR_COVR, CVR_NCVR
    }
}