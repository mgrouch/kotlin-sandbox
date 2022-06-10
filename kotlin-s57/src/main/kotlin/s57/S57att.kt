// License: GPL. For details, see LICENSE file.
package s57

import s57.S57obj.Obj

/**
 * @author Malcolm Herring
 * @author mgrouch
 */
object S57att {

    private val AttS57 = mapOf(
        Att.UNKATT to 0,
        Att.AGENCY to 1,
        Att.BCNSHP to 2,
        Att.BUISHP to 3,
        Att.BOYSHP to 4,
        Att.BURDEP to 5,
        Att.CALSGN to 6,
        Att.CATAIR to 7,
        Att.CATACH to 8,
        Att.CATBRG to 9,
        Att.CATBUA to 10,
        Att.CATCBL to 11,
        Att.CATCAN to 12,
        Att.CATCAM to 13,
        Att.CATCHP to 14,
        Att.CATCOA to 15,
        Att.CATCTR to 16,
        Att.CATCON to 17,
        Att.CATCVR to 18,
        Att.CATCRN to 19,
        Att.CATDAM to 20,
        Att.CATDIS to 21,
        Att.CATDOC to 22,
        Att.CATDPG to 23,
        Att.CATFNC to 24,
        Att.CATFRY to 25,
        Att.CATFIF to 26,
        Att.CATFOG to 27,
        Att.CATFOR to 28,
        Att.CATGAT to 29,
        Att.CATHAF to 30,
        Att.CATHLK to 31,
        Att.CATICE to 32,
        Att.CATINB to 33,
        Att.CATLND to 34,
        Att.CATLMK to 35,
        Att.CATLAM to 36,
        Att.CATLIT to 37,
        Att.CATMFA to 38,
        Att.CATMPA to 39,
        Att.CATMOR to 40,
        Att.CATNAV to 41,
        Att.CATOBS to 42,
        Att.CATOFP to 43,
        Att.CATOLB to 44,
        Att.CATPLE to 45,
        Att.CATPIL to 46,
        Att.CATPIP to 47,
        Att.CATPRA to 48,
        Att.CATPYL to 49,
        Att.CATRAS to 51,
        Att.CATRTB to 52,
        Att.CATROS to 53,
        Att.CATTRK to 54,
        Att.CATRSC to 55,
        Att.CATREA to 56,
        Att.CATROD to 57,
        Att.CATRUN to 58,
        Att.CATSEA to 59,
        Att.CATSLC to 60,
        Att.CATSIT to 61,
        Att.CATSIW to 62,
        Att.CATSIL to 63,
        Att.CATSLO to 64,
        Att.CATSCF to 65,
        Att.CATSPM to 66,
        Att.CATTSS to 67,
        Att.CATVEG to 68,
        Att.CATWAT to 69,
        Att.CATWED to 70,
        Att.CATWRK to 71,
        Att.COLOUR to 75,
        Att.COLPAT to 76,
        Att.COMCHA to 77,
        Att.CONDTN to 81,
        Att.CONRAD to 82,
        Att.CONVIS to 83,
        Att.CURVEL to 84,
        Att.DATEND to 85,
        Att.DATSTA to 86,
        Att.DRVAL1 to 87,
        Att.DRVAL2 to 88,
        Att.ELEVAT to 90,
        Att.ESTRNG to 91,
        Att.EXCLIT to 92,
        Att.EXPSOU to 93,
        Att.FUNCTN to 94,
        Att.HEIGHT to 95,
        Att.HUNITS to 96,
        Att.HORACC to 97,
        Att.HORCLR to 98,
        Att.HORLEN to 99,
        Att.HORWID to 100,
        Att.ICEFAC to 101,
        Att.INFORM to 102,
        Att.JRSDTN to 103,
        Att.LIFCAP to 106,
        Att.LITCHR to 107,
        Att.LITVIS to 108,
        Att.MARSYS to 109,
        Att.MLTYLT to 110,
        Att.NATION to 111,
        Att.NATCON to 112,
        Att.NATSUR to 113,
        Att.NATQUA to 114,
        Att.NMDATE to 115,
        Att.OBJNAM to 116,
        Att.ORIENT to 117,
        Att.PEREND to 118,
        Att.PERSTA to 119,
        Att.PICREP to 120,
        Att.PILDST to 121,
        Att.PRCTRY to 122,
        Att.PRODCT to 123,
        Att.PUBREF to 124,
        Att.QUASOU to 125,
        Att.RADWAL to 126,
        Att.RADIUS to 127,
        Att.RYRMGV to 130,
        Att.RESTRN to 131,
        Att.SCAMIN to 133,
        Att.SCVAL1 to 134,
        Att.SCVAL2 to 135,
        Att.SECTR1 to 136,
        Att.SECTR2 to 137,
        Att.SHIPAM to 138,
        Att.SIGFRQ to 139,
        Att.SIGGEN to 140,
        Att.SIGGRP to 141,
        Att.SIGPER to 142,
        Att.SIGSEQ to 143,
        Att.SOUACC to 144,
        Att.SDISMX to 145,
        Att.SDISMN to 146,
        Att.SORDAT to 147,
        Att.SORIND to 148,
        Att.STATUS to 149,
        Att.SURATH to 150,
        Att.SUREND to 151,
        Att.SURSTA to 152,
        Att.SURTYP to 153,
        Att.TECSOU to 156,
        Att.TXTDSC to 158,
        Att.TIMEND to 168,
        Att.TIMSTA to 169,
        Att.TOPSHP to 171,
        Att.TRAFIC to 172,
        Att.VALACM to 173,
        Att.VALDCO to 174,
        Att.VALLMA to 175,
        Att.VALMAG to 176,
        Att.VALMXR to 177,
        Att.VALNMR to 178,
        Att.VALSOU to 179,
        Att.VERACC to 180,
        Att.VERCLR to 181,
        Att.VERCCL to 182,
        Att.VERCOP to 183,
        Att.VERCSA to 184,
        Att.VERDAT to 185,
        Att.VERLEN to 186,
        Att.WATLEV to 187,
        Att.CAT_TS to 188,
        Att.NINFOM to 300,
        Att.NOBJNM to 301,
        Att.NPLDST to 302,
        Att.NTXTDS to 304,
        Att.HORDAT to 400,
        Att.POSACC to 401,
        Att.QUAPOS to 402,
    )

    private val AttIENC = mapOf(
        Att.CATACH to 17000,
        Att.CATDIS to 17001,
        Att.CATSIT to 17002,
        Att.CATSIW to 17003,
        Att.RESTRN to 17004,
        Att.VERDAT to 17005,
        Att.CATBRG to 17006,
        Att.CATFRY to 17007,
        Att.CATHAF to 17008,
        Att.MARSYS to 17009,
        Att.CATCHP to 17010,
        Att.CATLAM to 17011,
        Att.CATSLC to 17012,
        Att.ADDMRK to 17050,
        Att.CATNMK to 17052,
        Att.CLSDNG to 17055,
        Att.DIRIMP to 17056,
        Att.DISBK1 to 17057,
        Att.DISBK2 to 17058,
        Att.DISIPU to 17059,
        Att.DISIPD to 17060,
        Att.ELEVA1 to 17061,
        Att.ELEVA2 to 17062,
        Att.FNCTNM to 17063,
        Att.WTWDIS to 17064,
        Att.BUNVES to 17065,
        Att.CATBRT to 17066,
        Att.CATBUN to 17067,
        Att.CATCCL to 17069,
        Att.CATHBR to 17070,
        Att.CATRFD to 17071,
        Att.CATTML to 17072,
        Att.COMCTN to 17073,
        Att.HORCLL to 17074,
        Att.HORCLW to 17075,
        Att.TRSHGD to 17076,
        Att.UNLOCD to 17077,
        Att.CATGAG to 17078,
        Att.HIGWAT to 17080,
        Att.HIGNAM to 17081,
        Att.LOWWAT to 17082,
        Att.LOWNAM to 17083,
        Att.MEAWAT to 17084,
        Att.MEANAM to 17085,
        Att.OTHWAT to 17086,
        Att.OTHNAM to 17087,
        Att.REFLEV to 17088,
        Att.SDRLEV to 17089,
        Att.VCRLEV to 17090,
        Att.CATVTR to 17091,
        Att.CATTAB to 17092,
        Att.SCHREF to 17093,
        Att.USESHP to 17094,
        Att.CURVHW to 17095,
        Att.CURVLW to 17096,
        Att.CURVMW to 17097,
        Att.CURVOW to 17098,
        Att.APTREF to 17099,
        Att.CATEXS to 17100,
        Att.CATCBL to 17101,
        Att.CATHLK to 17102,
        Att.HUNITS to 17103,
        Att.WATLEV to 17104,
        Att.LG_SPD to 18001,
        Att.LG_SPR to 18002,
        Att.LG_BME to 18003,
        Att.LG_LGS to 18004,
        Att.LG_DRT to 18005,
        Att.LG_WDP to 18006,
        Att.LG_WDU to 18007,
        Att.LG_REL to 18008,
        Att.LG_FNC to 18009,
        Att.LG_DES to 18010,
        Att.LG_PBR to 18011,
        Att.LC_CSI to 18012,
        Att.LC_CSE to 18013,
        Att.LC_ASI to 18014,
        Att.LC_ASE to 18015,
        Att.LC_CCI to 18016,
        Att.LC_CCE to 18017,
        Att.LC_BM1 to 18018,
        Att.LC_BM2 to 18019,
        Att.LC_LG1 to 18020,
        Att.LC_LG2 to 18021,
        Att.LC_DR1 to 18022,
        Att.LC_DR2 to 18023,
        Att.LC_SP1 to 18024,
        Att.LC_SP2 to 18025,
        Att.LC_WD1 to 18026,
        Att.LC_WD2 to 18027,
        Att.SHPTYP to 33066,
        Att.UPDMSG to 40000,
        Att.BNKWTW to 17999,
    )

    private val AttStr = mapOf(
        Att.UNKATT to "",
        Att.AGENCY to "agency",
        Att.BCNSHP to "shape",
        Att.BUISHP to "shape",
        Att.BOYSHP to "shape",
        Att.BURDEP to "depth_buried",
        Att.CALSGN to "callsign",
        Att.CATAIR to "category",
        Att.CATACH to "category",
        Att.CATBRG to "category",
        Att.CATBUA to "category",
        Att.CATCBL to "category",
        Att.CATCAN to "category",
        Att.CATCAM to "category",
        Att.CATCHP to "category",
        Att.CATCOA to "category",
        Att.CATCTR to "category",
        Att.CATCON to "category",
        Att.CATCRN to "category",
        Att.CATDAM to "category",
        Att.CATDIS to "category",
        Att.CATDOC to "category",
        Att.CATDPG to "category",
        Att.CATFNC to "category",
        Att.CATFRY to "category",
        Att.CATFIF to "category",
        Att.CATFOG to "category",
        Att.CATFOR to "category",
        Att.CATGAT to "category",
        Att.CATHAF to "category",
        Att.CATHLK to "category",
        Att.CATICE to "category",
        Att.CATINB to "category",
        Att.CATLND to "category",
        Att.CATLMK to "category",
        Att.CATLAM to "category",
        Att.CATLIT to "category",
        Att.CATMFA to "category",
        Att.CATMPA to "category",
        Att.CATMOR to "category",
        Att.CATNAV to "category",
        Att.CATOBS to "category",
        Att.CATOFP to "category",
        Att.CATOLB to "category",
        Att.CATPLE to "category",
        Att.CATPIL to "category",
        Att.CATPIP to "category",
        Att.CATPRA to "category",
        Att.CATPYL to "category",
        Att.CATRAS to "category",
        Att.CATRTB to "category",
        Att.CATROS to "category",
        Att.CATTRK to "category",
        Att.CATRSC to "category",
        Att.CATREA to "category",
        Att.CATROD to "category",
        Att.CATRUN to "category",
        Att.CATSEA to "category",
        Att.CATSLC to "category",
        Att.CATSIT to "category",
        Att.CATSIW to "category",
        Att.CATSIL to "category",
        Att.CATSLO to "category",
        Att.CATSCF to "category",
        Att.CATSPM to "category",
        Att.CATTSS to "category",
        Att.CATVEG to "category",
        Att.CATWAT to "category",
        Att.CATWED to "category",
        Att.CATWRK to "category",
        Att.COLOUR to "colour",
        Att.COLPAT to "colour_pattern",
        Att.COMCHA to "channel",
        Att.CONDTN to "condition",
        Att.CONRAD to "reflectivity",
        Att.CONVIS to "conspicuity",
        Att.CURVEL to "velocity",
        Att.DATEND to "end_date",
        Att.DATSTA to "start_date",
        Att.DRVAL1 to "minimum_depth",
        Att.DRVAL2 to "maximum_depth",
        Att.ELEVAT to "elevation",
        Att.ESTRNG to "estimated_range",
        Att.EXCLIT to "exhibition",
        Att.EXPSOU to "exposition",
        Att.FUNCTN to "function",
        Att.HEIGHT to "height",
        Att.HUNITS to "units",
        Att.HORACC to "accuracy",
        Att.HORCLR to "clearance_width",
        Att.HORLEN to "length",
        Att.HORWID to "width",
        Att.ICEFAC to "factor",
        Att.INFORM to "information",
        Att.JRSDTN to "jurisdiction",
        Att.LIFCAP to "maximum_load",
        Att.LITCHR to "character",
        Att.LITVIS to "visibility",
        Att.MARSYS to "system",
        Att.MLTYLT to "multiple",
        Att.NATION to "nationality",
        Att.NATCON to "construction",
        Att.NATSUR to "surface",
        Att.NATQUA to "surface_qualification",
        Att.NMDATE to "nm_date",
        Att.OBJNAM to "name",
        Att.ORIENT to "orientation",
        Att.PEREND to "period_end",
        Att.PERSTA to "period_start",
        Att.PICREP to "picture",
        Att.PILDST to "pilot_district",
        Att.PRCTRY to "producing_country",
        Att.PRODCT to "product",
        Att.PUBREF to "reference",
        Att.QUASOU to "quality",
        Att.RADWAL to "wavelength",
        Att.RADIUS to "radius",
        Att.RYRMGV to "year",
        Att.RESTRN to "restriction",
        Att.SECTR1 to "sector_start",
        Att.SECTR2 to "sector_end",
        Att.SHIPAM to "shift",
        Att.SIGFRQ to "frequency",
        Att.SIGGEN to "generation",
        Att.SIGGRP to "group",
        Att.SIGPER to "period",
        Att.SIGSEQ to "sequence",
        Att.SOUACC to "sounding_accuracy",
        Att.SDISMX to "maximum_sounding",
        Att.SDISMN to "minimum_sounding",
        Att.SORDAT to "source_date",
        Att.SORIND to "source",
        Att.STATUS to "status",
        Att.SURATH to "authority",
        Att.SUREND to "survey_end",
        Att.SURSTA to "survey_start",
        Att.SURTYP to "survey",
        Att.TECSOU to "technique",
        Att.TXTDSC to "document",
        Att.TIMEND to "end_time",
        Att.TIMSTA to "start_time",
        Att.TOPSHP to "shape",
        Att.TRAFIC to "traffic_flow",
        Att.VALACM to "variation_change",
        Att.VALDCO to "depth",
        Att.VALLMA to "anomaly",
        Att.VALMAG to "variation",
        Att.VALMXR to "maximum_range",
        Att.VALNMR to "range",
        Att.VALSOU to "depth",
        Att.VERACC to "vertical_accuracy",
        Att.VERCLR to "clearance_height",
        Att.VERCCL to "clearance_height_closed",
        Att.VERCOP to "clearance_height_open",
        Att.VERCSA to "clearance_height_safe",
        Att.VERDAT to "vertical_datum",
        Att.VERLEN to "vertical_length",
        Att.WATLEV to "water_level",
        Att.CAT_TS to "category",
        Att.NINFOM to "national_information",
        Att.NOBJNM to "national_name",
        Att.NPLDST to "national_pilot_district",
        Att.NTXTDS to "national_description",
        Att.HORDAT to "horizontal_datum",
        Att.POSACC to "positional_accuracy",
        Att.QUAPOS to "position_quality",
        Att.ADDMRK to "addition",
        Att.BNKWTW to "bank",
        Att.CATNMK to "category",
        Att.CLSDNG to "danger_class",
        Att.DIRIMP to "impact",
        Att.DISBK1 to "distance_start",
        Att.DISBK2 to "distance_end",
        Att.DISIPU to "distance_up",
        Att.DISIPD to "distance_down",
        Att.ELEVA1 to "minimum_elevation",
        Att.ELEVA2 to "maximum_elevation",
        Att.FNCTNM to "function",
        Att.WTWDIS to "distance",
        Att.BUNVES to "availability",
        Att.CATBRT to "category",
        Att.CATBUN to "category",
        Att.CATCCL to "category",
        Att.CATHBR to "category",
        Att.CATRFD to "category",
        Att.CATTML to "category",
        Att.COMCTN to "communication",
        Att.HORCLL to "horizontal_clearance_length",
        Att.HORCLW to "horizontal_clearance_width",
        Att.TRSHGD to "goods",
        Att.UNLOCD to "",
        Att.CATGAG to "category",
        Att.HIGWAT to "high_value",
        Att.HIGNAM to "high_name",
        Att.LOWWAT to "low_value",
        Att.LOWNAM to "low_name",
        Att.MEAWAT to "mean_value",
        Att.MEANAM to "mean_name",
        Att.OTHWAT to "local_value",
        Att.OTHNAM to "local_name",
        Att.REFLEV to "gravity_reference",
        Att.SDRLEV to "sounding_name",
        Att.VCRLEV to "vertical_name",
        Att.CATVTR to "category",
        Att.CATTAB to "operation",
        Att.SCHREF to "schedule",
        Att.USESHP to "use",
        Att.CURVHW to "high_velocity",
        Att.CURVLW to "low_velocity",
        Att.CURVMW to "mean_velocity",
        Att.CURVOW to "other_velocity",
        Att.APTREF to "passing_time",
        Att.CATCOM to "category",
        Att.CATCVR to "category",
        Att.CATEXS to "category",
        Att.SHPTYP to "ship",
        Att.UPDMSG to "message",
    )

    private val Accuracy = mapOf(Obj.UNKOBJ to Att.HORACC)
    private val Addition = mapOf(Obj.UNKOBJ to Att.ADDMRK)
    private val Agency = mapOf(Obj.UNKOBJ to Att.AGENCY)
    private val Anomaly = mapOf(Obj.UNKOBJ to Att.VALLMA)
    private val Authority = mapOf(Obj.UNKOBJ to Att.SURATH)
    private val Availability = mapOf(Obj.UNKOBJ to Att.BUNVES)
    private val Bank = mapOf(Obj.UNKOBJ to Att.BNKWTW)
    private val Callsign = mapOf(Obj.UNKOBJ to Att.CALSGN)

    private val Category = mapOf(
        Obj.ACHARE to Att.CATACH,
        Obj.ACHBRT to Att.CATACH,
        Obj.AIRARE to Att.CATAIR,
        Obj.BCNCAR to Att.CATCAM,
        Obj.BCNLAT to Att.CATLAM,
        Obj.BCNSPP to Att.CATSPM,
        Obj.BOYLAT to Att.CATLAM,
        Obj.BOYINB to Att.CATINB,
        Obj.BOYSPP to Att.CATSPM,
        Obj.DAYMAR to Att.CATSPM,
        Obj.BRIDGE to Att.CATBRG,
        Obj.BUAARE to Att.CATBUA,
        Obj.BUNSTA to Att.CATBUN,
        Obj.CANALS to Att.CATCAN,
        Obj.CBLARE to Att.CATCBL,
        Obj.CBLOHD to Att.CATCBL,
        Obj.CBLSUB to Att.CATCBL,
        Obj.CHKPNT to Att.CATCHP,
        Obj.COMARE to Att.CATCOM,
        Obj.COALNE to Att.CATCOA,
        Obj.CONVYR to Att.CATCON,
        Obj.CRANES to Att.CATCRN,
        Obj.CTRPNT to Att.CATCTR,
        Obj.DAMCON to Att.CATDAM,
        Obj.DISMAR to Att.CATDIS,
        Obj.DMPGRD to Att.CATDPG,
        Obj.DOCARE to Att.CATDOC,
        Obj.EXCNST to Att.CATEXS,
        Obj.FERYRT to Att.CATFRY,
        Obj.FNCLNE to Att.CATFNC,
        Obj.FOGSIG to Att.CATFOG,
        Obj.FORSTC to Att.CATFOR,
        Obj.FSHFAC to Att.CATFIF,
        Obj.GATCON to Att.CATGAT,
        Obj.HRBFAC to Att.CATHAF,
        Obj.HRBARE to Att.CATHBR,
        Obj.HRBBSN to Att.CATHBR,
        Obj.HULKES to Att.CATHLK,
        Obj.ICEARE to Att.CATICE,
        Obj.LNDRGN to Att.CATLND,
        Obj.LNDMRK to Att.CATLMK,
        Obj.LIGHTS to Att.CATLIT,
        Obj.M_COVR to Att.CATCVR,
        Obj.MARCUL to Att.CATMFA,
        Obj.MIPARE to Att.CATMPA,
        Obj.MORFAC to Att.CATMOR,
        Obj.NAVLNE to Att.CATNAV,
        Obj.NOTMRK to Att.CATNMK,
        Obj.OBSTRN to Att.CATOBS,
        Obj.OFSPLF to Att.CATOFP,
        Obj.OILBAR to Att.CATOLB,
        Obj.OSPARE to Att.CATPRA,
        Obj.PILPNT to Att.CATPLE,
        Obj.PILBOP to Att.CATPIL,
        Obj.PIPARE to Att.CATPIP,
        Obj.PIPOHD to Att.CATPIP,
        Obj.PIPSOL to Att.CATPIP,
        Obj.PRDARE to Att.CATPRA,
        Obj.PYLONS to Att.CATPYL,
        Obj.RADSTA to Att.CATRAS,
        Obj.RCRTCL to Att.CATTRK,
        Obj.RCTLPT to Att.CATTRK,
        Obj.RDOSTA to Att.CATROS,
        Obj.RDOCAL to Att.CATCOM,
        Obj.RECTRC to Att.CATTRK,
        Obj.REFDMP to Att.CATRFD,
        Obj.RESARE to Att.CATREA,
        Obj.RSCSTA to Att.CATRSC,
        Obj.RTPBCN to Att.CATRTB,
        Obj.ROADWY to Att.CATROD,
        Obj.RUNWAY to Att.CATRUN,
        Obj.SEAARE to Att.CATSEA,
        Obj.SILTNK to Att.CATSIL,
        Obj.SISTAT to Att.CATSIT,
        Obj.SISTAW to Att.CATSIW,
        Obj.SLCONS to Att.CATSLC,
        Obj.SLOTOP to Att.CATSLO,
        Obj.SLOGRD to Att.CATSLO,
        Obj.SMCFAC to Att.CATSCF,
        Obj.TERMNL to Att.CATTML,
        Obj.TS_FEB to Att.CAT_TS,
        Obj.TSELNE to Att.CATTSS,
        Obj.TSEZNE to Att.CATTSS,
        Obj.TSSBND to Att.CATTSS,
        Obj.TSSCRS to Att.CATTSS,
        Obj.TSSLPT to Att.CATTSS,
        Obj.TSSRON to Att.CATTSS,
        Obj.TWRTPT to Att.CATTRK,
        Obj.VEGATN to Att.CATVEG,
        Obj.VEHTRF to Att.CATVTR,
        Obj.WATTUR to Att.CATWAT,
        Obj.WEDKLP to Att.CATWED,
        Obj.WRECKS to Att.CATWRK,
        Obj.WTWAXS to Att.CATCCL,
        Obj.WTWARE to Att.CATCCL,
        Obj.WTWGAG to Att.CATGAG,
        Obj.BERTHS to Att.CATBRT,
    )

    private val Channel = mapOf(Obj.UNKOBJ to Att.COMCHA)
    private val Character = mapOf(Obj.UNKOBJ to Att.LITCHR)
    private val Clearance_height = mapOf(Obj.UNKOBJ to Att.VERCLR)
    private val Clearance_height_closed = mapOf(Obj.UNKOBJ to Att.VERCCL)
    private val Clearance_height_open = mapOf(Obj.UNKOBJ to Att.VERCOP)
    private val Clearance_height_safe = mapOf(Obj.UNKOBJ to Att.VERCSA)
    private val Clearance_width = mapOf(Obj.UNKOBJ to Att.HORCLR)
    private val Colour = mapOf(Obj.UNKOBJ to Att.COLOUR)
    private val Colour_pattern = mapOf(Obj.UNKOBJ to Att.COLPAT)
    private val Communication = mapOf(Obj.UNKOBJ to Att.COMCTN)
    private val Condition = mapOf(Obj.UNKOBJ to Att.CONDTN)
    private val Conspicuity = mapOf(Obj.UNKOBJ to Att.CONVIS)
    private val Construction = mapOf(Obj.UNKOBJ to Att.NATCON)
    private val Danger_class = mapOf(Obj.UNKOBJ to Att.CLSDNG)

    private val Depth = mapOf(
        Obj.UNKOBJ to Att.VALDCO,
        Obj.SOUNDG to Att.VALSOU,
    )

    private val Depth_buried = mapOf(Obj.UNKOBJ to Att.BURDEP)
    private val Description = mapOf(Obj.UNKOBJ to Att.TXTDSC)
    private val Distance = mapOf(Obj.UNKOBJ to Att.WTWDIS)
    private val Distance_down = mapOf(Obj.UNKOBJ to Att.DISIPD)
    private val Distance_end = mapOf(Obj.UNKOBJ to Att.DISBK2)
    private val Distance_start = mapOf(Obj.UNKOBJ to Att.DISBK1)
    private val Distance_up = mapOf(Obj.UNKOBJ to Att.DISIPU)
    private val Elevation = mapOf(Obj.UNKOBJ to Att.ELEVAT)
    private val End_date = mapOf(Obj.UNKOBJ to Att.DATEND)
    private val End_time = mapOf(Obj.UNKOBJ to Att.TIMEND)
    private val Estimated_range = mapOf(Obj.UNKOBJ to Att.ESTRNG)
    private val Exhibition = mapOf(Obj.UNKOBJ to Att.EXCLIT)
    private val Exposition = mapOf(Obj.UNKOBJ to Att.EXPSOU)
    private val Factor = mapOf(Obj.UNKOBJ to Att.ICEFAC)
    private val Frequency = mapOf(Obj.UNKOBJ to Att.SIGFRQ)

    private val Function = mapOf(
        Obj.BUISGL to Att.FUNCTN,
        Obj.LNDMRK to Att.FUNCTN,
        Obj.NOTMRK to Att.FNCTNM,
    )
    private val Generation = mapOf(Obj.UNKOBJ to Att.SIGGEN)
    private val Goods = mapOf(Obj.UNKOBJ to Att.TRSHGD)
    private val Gravity_reference = mapOf(Obj.UNKOBJ to Att.REFLEV)
    private val Group = mapOf(Obj.UNKOBJ to Att.SIGGRP)
    private val Height = mapOf(Obj.UNKOBJ to Att.HEIGHT)
    private val High_name = mapOf(Obj.UNKOBJ to Att.HIGNAM)
    private val High_value = mapOf(Obj.UNKOBJ to Att.HIGWAT)
    private val High_velocity = mapOf(Obj.UNKOBJ to Att.CURVHW)
    private val Horizontal_clearance_length = mapOf(Obj.UNKOBJ to Att.HORCLL)
    private val Horizontal_clearance_width = mapOf(Obj.UNKOBJ to Att.HORCLW)
    private val Horizontal_datum = mapOf(Obj.UNKOBJ to Att.HORDAT)
    private val Impact = mapOf(Obj.UNKOBJ to Att.DIRIMP)
    private val Information = mapOf(Obj.UNKOBJ to Att.INFORM)
    private val Jurisdiction = mapOf(Obj.UNKOBJ to Att.JRSDTN)
    private val Length = mapOf(Obj.UNKOBJ to Att.HORLEN)
    private val Local_name = mapOf(Obj.UNKOBJ to Att.OTHNAM)
    private val Local_value = mapOf(Obj.UNKOBJ to Att.OTHWAT)
    private val Low_name = mapOf(Obj.UNKOBJ to Att.LOWNAM)
    private val Low_value = mapOf(Obj.UNKOBJ to Att.LOWWAT)
    private val Low_velocity = mapOf(Obj.UNKOBJ to Att.CURVLW)
    private val Maximum_depth = mapOf(Obj.UNKOBJ to Att.DRVAL2)
    private val Maximum_elevation = mapOf(Obj.UNKOBJ to Att.ELEVA2)
    private val Maximum_load = mapOf(Obj.UNKOBJ to Att.LIFCAP)
    private val Maximum_range = mapOf(Obj.UNKOBJ to Att.VALMXR)
    private val Maximum_sounding = mapOf(Obj.UNKOBJ to Att.SDISMX)
    private val Mean_name = mapOf(Obj.UNKOBJ to Att.MEANAM)
    private val Mean_value = mapOf(Obj.UNKOBJ to Att.MEAWAT)
    private val Mean_velocity = mapOf(Obj.UNKOBJ to Att.CURVMW)
    private val Message = mapOf(Obj.UNKOBJ to Att.UPDMSG)
    private val Minimum_depth = mapOf(Obj.UNKOBJ to Att.DRVAL1)
    private val Minimum_elevation = mapOf(Obj.UNKOBJ to Att.ELEVA1)
    private val Minimum_sounding = mapOf(Obj.UNKOBJ to Att.SDISMN)
    private val Multiple = mapOf(Obj.UNKOBJ to Att.MLTYLT)
    private val Name = mapOf(Obj.UNKOBJ to Att.OBJNAM)
    private val National_information = mapOf(Obj.UNKOBJ to Att.NINFOM)
    private val Nationality = mapOf(Obj.UNKOBJ to Att.NATION)
    private val National_description = mapOf(Obj.UNKOBJ to Att.NTXTDS)
    private val National_name = mapOf(Obj.UNKOBJ to Att.NOBJNM)
    private val National_pilot_district = mapOf(Obj.UNKOBJ to Att.NPLDST)
    private val Nm_date = mapOf(Obj.UNKOBJ to Att.NMDATE)
    private val Other_velocity = mapOf(Obj.UNKOBJ to Att.CURVOW)
    private val Operation = mapOf(Obj.UNKOBJ to Att.CATTAB)
    private val Orientation = mapOf(Obj.UNKOBJ to Att.ORIENT)
    private val Passing_time = mapOf(Obj.UNKOBJ to Att.APTREF)
    private val Period = mapOf(Obj.UNKOBJ to Att.SIGPER)
    private val Period_end = mapOf(Obj.UNKOBJ to Att.PEREND)
    private val Period_start = mapOf(Obj.UNKOBJ to Att.PERSTA)
    private val Pilot_district = mapOf(Obj.UNKOBJ to Att.PILDST)
    private val Position_quality = mapOf(Obj.UNKOBJ to Att.QUAPOS)
    private val Positional_accuracy = mapOf(Obj.UNKOBJ to Att.POSACC)
    private val Producing_country = mapOf(Obj.UNKOBJ to Att.PRCTRY)
    private val Product = mapOf(Obj.UNKOBJ to Att.PRODCT)
    private val Quality = mapOf(Obj.UNKOBJ to Att.QUASOU)
    private val Range = mapOf(Obj.UNKOBJ to Att.VALNMR)
    private val Reference = mapOf(Obj.UNKOBJ to Att.PUBREF)
    private val Reflectivity = mapOf(Obj.UNKOBJ to Att.CONRAD)
    private val Restriction = mapOf(Obj.UNKOBJ to Att.RESTRN)
    private val Schedule = mapOf(Obj.UNKOBJ to Att.SCHREF)
    private val Shape = mapOf(
        Obj.BCNCAR to Att.BCNSHP,
        Obj.BCNISD to Att.BCNSHP,
        Obj.BCNLAT to Att.BCNSHP,
        Obj.BCNSAW to Att.BCNSHP,
        Obj.BCNSPP to Att.BCNSHP,
        Obj.BUISGL to Att.BUISHP,
        Obj.BOYCAR to Att.BOYSHP,
        Obj.BOYISD to Att.BOYSHP,
        Obj.BOYLAT to Att.BOYSHP,
        Obj.BOYSAW to Att.BOYSHP,
        Obj.BOYSPP to Att.BOYSHP,
        Obj.BOYINB to Att.BOYSHP,
        Obj.DAYMAR to Att.TOPSHP,
        Obj.TOPMAR to Att.TOPSHP,
        Obj.MORFAC to Att.BOYSHP,
        Obj.SILTNK to Att.BUISHP,
    )
    private val Sector_end = mapOf(Obj.UNKOBJ to Att.SECTR2)
    private val Sector_start = mapOf(Obj.UNKOBJ to Att.SECTR1)
    private val Sequence = mapOf(Obj.UNKOBJ to Att.SIGSEQ)
    private val Shift = mapOf(Obj.UNKOBJ to Att.SHIPAM)
    private val Ship = mapOf(Obj.UNKOBJ to Att.SHPTYP)
    private val Sounding_accuracy = mapOf(Obj.UNKOBJ to Att.SOUACC)
    private val Sounding_name = mapOf(Obj.UNKOBJ to Att.SDRLEV)
    private val Start_date = mapOf(Obj.UNKOBJ to Att.DATSTA)
    private val Start_time = mapOf(Obj.UNKOBJ to Att.TIMSTA)
    private val Status = mapOf(Obj.UNKOBJ to Att.STATUS)
    private val Surface = mapOf(Obj.UNKOBJ to Att.NATSUR)
    private val Surface_qualification = mapOf(Obj.UNKOBJ to Att.NATQUA)
    private val Survey = mapOf(Obj.UNKOBJ to Att.SURTYP)
    private val Survey_end = mapOf(Obj.UNKOBJ to Att.SUREND)
    private val Survey_start = mapOf(Obj.UNKOBJ to Att.SURSTA)
    private val System = mapOf(Obj.UNKOBJ to Att.MARSYS)
    private val Technique = mapOf(Obj.UNKOBJ to Att.TECSOU)
    private val Traffic_flow = mapOf(Obj.UNKOBJ to Att.TRAFIC)
    private val Units = mapOf(Obj.UNKOBJ to Att.HUNITS)
    private val Use = mapOf(Obj.UNKOBJ to Att.USESHP)
    private val Variation = mapOf(Obj.UNKOBJ to Att.VALMAG)
    private val Variation_change = mapOf(Obj.UNKOBJ to Att.VALACM)
    private val Velocity = mapOf(Obj.UNKOBJ to Att.CURVEL)
    private val Vertical_accuracy = mapOf(Obj.UNKOBJ to Att.VERACC)
    private val Vertical_datum = mapOf(Obj.UNKOBJ to Att.VERDAT)
    private val Vertical_length = mapOf(Obj.UNKOBJ to Att.VERLEN)
    private val Vertical_name = mapOf(Obj.UNKOBJ to Att.VCRLEV)
    private val Visibility = mapOf(Obj.UNKOBJ to Att.LITVIS)
    private val Water_level = mapOf(Obj.UNKOBJ to Att.WATLEV)
    private val Wavelength = mapOf(Obj.UNKOBJ to Att.RADWAL)
    private val Width = mapOf(Obj.UNKOBJ to Att.HORWID)

    private val Year = mapOf(Obj.UNKOBJ to Att.RYRMGV)
    private val StrAtt = mapOf(
        "accuracy" to Accuracy,
        "addition" to Addition,
        "agency" to Agency,
        "anomaly" to Anomaly,
        "authority" to Authority,
        "availability" to Availability,
        "bank" to Bank,
        "callsign" to Callsign,
        "category" to Category,
        "channel" to Channel,
        "character" to Character,
        "clearance_height" to Clearance_height,
        "clearance_height_closed" to Clearance_height_closed,
        "clearance_height_open" to Clearance_height_open,
        "clearance_height_safe" to Clearance_height_safe,
        "clearance_width" to Clearance_width,
        "colour" to Colour,
        "colour_pattern" to Colour_pattern,
        "communication" to Communication,
        "condition" to Condition,
        "conspicuity" to Conspicuity,
        "construction" to Construction,
        "danger_class" to Danger_class,
        "depth" to Depth,
        "depth_buried" to Depth_buried,
        "description" to Description,
        "distance" to Distance,
        "distance_down" to Distance_down,
        "distance_end" to Distance_end,
        "distance_start" to Distance_start,
        "distance_up" to Distance_up,
        "elevation" to Elevation,
        "end_date" to End_date,
        "end_time" to End_time,
        "estimated_range" to Estimated_range,
        "exhibition" to Exhibition,
        "exposition" to Exposition,
        "factor" to Factor,
        "frequency" to Frequency,
        "function" to Function,
        "generation" to Generation,
        "goods" to Goods,
        "gravity_reference" to Gravity_reference,
        "group" to Group,
        "height" to Height,
        "high_name" to High_name,
        "high_value" to High_value,
        "high_velocity" to High_velocity,
        "horizontal_clearance_length" to Horizontal_clearance_length,
        "horizontal_clearance_width" to Horizontal_clearance_width,
        "horizontal_datum" to Horizontal_datum,
        "impact" to Impact,
        "information" to Information,
        "jurisdiction" to Jurisdiction,
        "length" to Length,
        "local_name" to Local_name,
        "local_value" to Local_value,
        "low_name" to Low_name,
        "low_value" to Low_value,
        "low_velocity" to Low_velocity,
        "maximum_depth" to Maximum_depth,
        "maximum_elevation" to Maximum_elevation,
        "maximum_load" to Maximum_load,
        "maximum_range" to Maximum_range,
        "maximum_sounding" to Maximum_sounding,
        "mean_name" to Mean_name,
        "mean_value" to Mean_value,
        "mean_velocity" to Mean_velocity,
        "message" to Message,
        "minimum_depth" to Minimum_depth,
        "minimum_elevation" to Minimum_elevation,
        "minimum_sounding" to Minimum_sounding,
        "multiple" to Multiple,
        "name" to Name,
        "national_information" to National_information,
        "nationality" to Nationality,
        "national_description" to National_description,
        "national_name" to National_name,
        "national_pilot_district" to National_pilot_district,
        "nm_date" to Nm_date,
        "other_velocity" to Other_velocity,
        "operation" to Operation,
        "orientation" to Orientation,
        "passing_time" to Passing_time,
        "period" to Period,
        "period_end" to Period_end,
        "period_start" to Period_start,
        "pilot_district" to Pilot_district,
        "position_quality" to Position_quality,
        "positional_accuracy" to Positional_accuracy,
        "producing_country" to Producing_country,
        "product" to Product,
        "quality" to Quality,
        "range" to Range,
        "reference" to Reference,
        "reflectivity" to Reflectivity,
        "restriction" to Restriction,
        "schedule" to Schedule,
        "shape" to Shape,
        "sector_end" to Sector_end,
        "sector_start" to Sector_start,
        "sequence" to Sequence,
        "shift" to Shift,
        "ship" to Ship,
        "sounding_accuracy" to Sounding_accuracy,
        "sounding_name" to Sounding_name,
        "start_date" to Start_date,
        "start_time" to Start_time,
        "status" to Status,
        "surface" to Surface,
        "surface_qualification" to Surface_qualification,
        "survey" to Survey,
        "survey_end" to Survey_end,
        "survey_start" to Survey_start,
        "system" to System,
        "technique" to Technique,
        "traffic_flow" to Traffic_flow,
        "units" to Units,
        "use" to Use,
        "variation" to Variation,
        "variation_change" to Variation_change,
        "velocity" to Velocity,
        "vertical_accuracy" to Vertical_accuracy,
        "vertical_datum" to Vertical_datum,
        "vertical_length" to Vertical_length,
        "vertical_name" to Vertical_name,
        "visibility" to Visibility,
        "water_level" to Water_level,
        "wavelength" to Wavelength,
        "width" to Width,
        "year" to Year,
    )

    fun decodeAttribute(attl: Long): Att { // Convert S57 attribute code to SCM attribute enumeration
        for (att in AttS57.keys) {
            if (AttS57[att]!!.toLong() == attl) return att
        }
        for (att in AttIENC.keys) {
            if (AttIENC[att]!!.toLong() == attl) return att
        }
        return Att.UNKATT
    }

    fun encodeAttribute(attribute: Att?): Int? { // Convert SCM attribute enumeration to S57 attribute code
        return if (AttS57[attribute] != 0) AttS57[attribute] else AttIENC[attribute]
    }

    fun stringAttribute(attribute: Att): String { // Convert SCM enumeration to OSM attribute string
        val str = AttStr[attribute]
        return str ?: ""
    }

    fun enumAttribute(attribute: String?, obj: Obj?): Att? { // Convert OSM attribute string to SCM enumeration
        if (attribute != null && attribute.isNotEmpty()) {
            val map = StrAtt[attribute]
            if (map != null) {
                return if (map.containsKey(obj)) {
                    map[obj]
                } else if (map.containsKey(Obj.UNKOBJ)) {
                    map[Obj.UNKOBJ]
                } else {
                    Att.UNKATT
                }
            }
        }
        return Att.UNKATT
    }

    enum class Att {
        UNKATT, AGENCY, BCNSHP, BUISHP, BOYSHP, BURDEP, CALSGN, CATAIR, CATACH, CATBRG, CATBUA,
        CATCBL, CATCAN, CATCAM, CATCHP, CATCOA, CATCTR, CATCON, CATCRN, CATDAM, CATDIS, CATDOC,
        CATDPG, CATFNC, CATFRY, CATFIF, CATFOG, CATFOR, CATGAT, CATHAF, CATHLK, CATICE, CATINB,
        CATLND, CATLMK, CATLAM, CATLIT, CATMFA, CATMPA, CATMOR, CATNAV, CATOBS, CATOFP, CATOLB,
        CATPLE, CATPIL, CATPIP, CATPRA, CATPYL, CATRAS, CATRTB, CATROS, CATTRK, CATRSC, CATREA,
        CATROD, CATRUN, CATSEA, CATSLC, CATSIT, CATSIW, CATSIL, CATSLO, CATSCF, CATSPM, CATTSS,
        CATVEG, CATWAT, CATWED, CATWRK, COLOUR, COLPAT, COMCHA, CPDATE, CSCALE, CONDTN, CONRAD,
        CONVIS, CURVEL, DATEND, DATSTA, DRVAL1, DRVAL2, ELEVAT, ESTRNG, EXCLIT, EXPSOU, FUNCTN,
        HEIGHT, HORACC, HORCLR, HORLEN, HORWID, ICEFAC, INFORM, JRSDTN, LIFCAP, LITCHR, LITVIS,
        MARSYS, MLTYLT, NATION, NATCON, NATSUR, NATQUA, NMDATE, OBJNAM, ORIENT, PEREND, PERSTA,
        PICREP, PILDST, PRCTRY, PRODCT, PUBREF, QUASOU, RADWAL, RADIUS, RYRMGV, RESTRN, SCAMIN,
        SCVAL1, SCVAL2, SECTR1, SECTR2, SHIPAM, SIGFRQ, SIGGEN, SIGGRP, SIGPER, SIGSEQ, SOUACC,
        SDISMX, SDISMN, SORDAT, SORIND, STATUS, SURATH, SUREND, SURSTA, SURTYP, TECSOU, TXTDSC,
        TS_TSP, TS_TSV, T_ACWL, T_HWLW, T_MTOD, T_THDF, T_TINT, T_TSVL, T_VAHC, TIMEND, TIMSTA,
        TOPSHP, TRAFIC, VALACM, VALDCO, VALLMA, VALMAG, VALMXR, VALNMR, VALSOU, VERACC, VERCLR,
        VERCCL, VERCOP, VERCSA, VERDAT, VERLEN, WATLEV, CAT_TS, NINFOM, NOBJNM, NPLDST, NTXTDS,
        HORDAT, POSACC, QUAPOS, CLSDNG, DIRIMP, DISBK1, DISBK2, DISIPU, DISIPD, ELEVA1, ELEVA2,
        FNCTNM, WTWDIS, BUNVES, BNKWTW, COMCTN, HORCLL, HORCLW, TRSHGD, UNLOCD, HIGWAT, HIGNAM,
        LOWWAT, LOWNAM, MEAWAT, MEANAM, OTHWAT, OTHNAM, REFLEV, SDRLEV, VCRLEV, SCHREF, USESHP,
        CURVHW, CURVLW, CURVMW, CURVOW, APTREF, SHPTYP, UPDMSG, ADDMRK, CATNMK, CATBRT, CATBUN,
        CATCCL, CATCOM, CATHBR, CATRFD, CATTML, CATGAG, CATVTR, CATTAB, CATEXS, LG_SPD, LG_SPR,
        LG_BME, LG_LGS, LG_DRT, LG_WDP, LG_WDU, LG_REL, LG_FNC, LG_DES, LG_PBR, LC_CSI, LC_CSE,
        LC_ASI, LC_ASE, LC_CCI, LC_CCE, LC_BM1, LC_BM2, LC_LG1, LC_LG2, LC_DR1, LC_DR2, LC_SP1,
        LC_SP2, LC_WD1, LC_WD2, CATCVR, HUNITS
    }
}