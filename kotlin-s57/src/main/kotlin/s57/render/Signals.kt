// License: GPL. For details, see LICENSE file.
@file:Suppress("RemoveRedundantQualifierName")

package s57.render

import s57.S57att.Att
import s57.S57map
import s57.S57obj.Obj
import s57.S57val
import s57.S57val.CatROS
import s57.S57val.ColCOL
import s57.symbols.Beacons
import s57.symbols.Symbols
import s57.symbols.Topmarks

import java.awt.Color
import java.awt.Font
import java.awt.geom.AffineTransform
import java.text.DecimalFormat

/**
 * @author Malcolm Herring
 */
object Signals : Rules() {
    val LightColours = mapOf(
        ColCOL.COL_WHT to Color(0xffff00),
        ColCOL.COL_RED to Color(0xff0000),
        ColCOL.COL_GRN to Color(0x00ff00),
        ColCOL.COL_BLU to Color(0x0000ff),
        ColCOL.COL_YEL to Color(0xffff00),
        ColCOL.COL_AMB to Color(0xffc200),
        ColCOL.COL_VIO to Color(0xee82ee),
        ColCOL.COL_ORG to Color.orange,
        ColCOL.COL_MAG to Color.magenta,
    )

    val LightLetters = mapOf(
        ColCOL.COL_WHT to "W",
        ColCOL.COL_RED to "R",
        ColCOL.COL_GRN to "G",
        ColCOL.COL_BLU to "Bu",
        ColCOL.COL_YEL to "Y",
        ColCOL.COL_AMB to "Am",
        ColCOL.COL_VIO to "Vi",
        ColCOL.COL_ORG to "Or",
    )

    val LightCharacters = mapOf(
        S57val.LitCHR.CHR_F to "F",
        S57val.LitCHR.CHR_FL to "Fl",
        S57val.LitCHR.CHR_LFL to "LFl",
        S57val.LitCHR.CHR_Q to "Q",
        S57val.LitCHR.CHR_VQ to "VQ",
        S57val.LitCHR.CHR_UQ to "UQ",
        S57val.LitCHR.CHR_ISO to "Iso",
        S57val.LitCHR.CHR_OC to "Oc",
        S57val.LitCHR.CHR_IQ to "IQ",
        S57val.LitCHR.CHR_IVQ to "IVQ",
        S57val.LitCHR.CHR_IUQ to "IUQ",
        S57val.LitCHR.CHR_MO to "Mo",
        S57val.LitCHR.CHR_FFL to "FFl",
        S57val.LitCHR.CHR_FLLFL to "FlLFl",
        S57val.LitCHR.CHR_OCFL to "OcFl",
        S57val.LitCHR.CHR_FLFL to "FLFl",
        S57val.LitCHR.CHR_ALOC to "Al.Oc",
        S57val.LitCHR.CHR_ALLFL to "Al.LFl",
        S57val.LitCHR.CHR_ALFL to "Al.Fl",
        S57val.LitCHR.CHR_ALGR to "Al.Gr",
        S57val.LitCHR.CHR_QLFL to "Q+LFl",
        S57val.LitCHR.CHR_VQLFL to "VQ+LFl",
        S57val.LitCHR.CHR_UQLFL to "UQ+LFl",
        S57val.LitCHR.CHR_AL to "Al",
        S57val.LitCHR.CHR_ALFFL to "Al.FFl",
    )

    val fogSignals = mapOf(
        S57val.CatFOG.FOG_EXPL to "Explos",
        S57val.CatFOG.FOG_DIA to "Dia",
        S57val.CatFOG.FOG_SIRN to "Siren",
        S57val.CatFOG.FOG_NAUT to "Horn",
        S57val.CatFOG.FOG_REED to "Horn",
        S57val.CatFOG.FOG_TYPH to "Horn",
        S57val.CatFOG.FOG_BELL to "Bell",
        S57val.CatFOG.FOG_WHIS to "Whis",
        S57val.CatFOG.FOG_GONG to "Gong",
        S57val.CatFOG.FOG_HORN to "Horn",
    )

    val df: DecimalFormat = DecimalFormat("#.#")
    fun addSignals() {
        if (Rules.feature!!.objs!!.containsKey(Obj.RADRFL)) reflectors()
        if (Rules.feature!!.objs!!.containsKey(Obj.FOGSIG)) fogSignals()
        if (Rules.feature!!.objs!!.containsKey(Obj.RTPBCN)) radarStations()
        if (Rules.feature!!.objs!!.containsKey(Obj.RADSTA)) radarStations()
        if (Rules.feature!!.objs!!.containsKey(Obj.RDOSTA)) radioStations()
        if (Rules.feature!!.objs!!.containsKey(Obj.LIGHTS)) lights()
    }

    fun reflectors() {
        if (Renderer.zoom >= 14) {
            when (Rules.feature!!.type) {
                Obj.BCNLAT, Obj.BCNCAR, Obj.BCNISD, Obj.BCNSAW, Obj.BCNSPP -> if (Rules.feature!!.objs!!.containsKey(
                        Obj.TOPMAR
                    ) || Rules.feature!!.objs!!.containsKey(Obj.DAYMAR)
                ) {
                    Renderer.symbol(
                        Topmarks.RadarReflector,
                        Symbols.Delta(Symbols.Handle.BC, AffineTransform.getTranslateInstance(0.0, -140.0))
                    )
                } else {
                    Renderer.symbol(
                        Topmarks.RadarReflector,
                        Symbols.Delta(Symbols.Handle.BC, AffineTransform.getTranslateInstance(0.0, -80.0))
                    )
                }
                Obj.LITFLT, Obj.LITVES, Obj.BOYINB -> if (Rules.feature!!.objs!!.containsKey(
                        Obj.TOPMAR
                    ) || Rules.feature!!.objs!!.containsKey(Obj.DAYMAR)
                ) {
                    Renderer.symbol(
                        Topmarks.RadarReflector,
                        Symbols.Delta(Symbols.Handle.BC, AffineTransform.getTranslateInstance(0.0, -110.0))
                    )
                } else {
                    Renderer.symbol(
                        Topmarks.RadarReflector,
                        Symbols.Delta(Symbols.Handle.BC, AffineTransform.getTranslateInstance(0.0, -60.0))
                    )
                }
                Obj.LITMAJ, Obj.LITMIN -> if (Rules.feature!!.objs!!.containsKey(Obj.TOPMAR) || Rules.feature!!.objs!!.containsKey(
                        Obj.DAYMAR
                    )
                ) {
                    Renderer.symbol(
                        Topmarks.RadarReflector,
                        Symbols.Delta(Symbols.Handle.BC, AffineTransform.getTranslateInstance(0.0, -90.0))
                    )
                } else {
                    Renderer.symbol(
                        Topmarks.RadarReflector,
                        Symbols.Delta(Symbols.Handle.BC, AffineTransform.getTranslateInstance(0.0, -30.0))
                    )
                }
                Obj.BOYLAT, Obj.BOYCAR, Obj.BOYISD, Obj.BOYSAW, Obj.BOYSPP -> if (Rules.feature!!.objs!!.containsKey(
                        Obj.TOPMAR
                    ) || Rules.feature!!.objs!!.containsKey(Obj.DAYMAR)
                ) {
                    if (Rules.testAttribute(
                            Rules.feature!!.type,
                            Att.BOYSHP,
                            S57val.BoySHP.BOY_PILR
                        ) || Rules.testAttribute(
                            Rules.feature!!.type, Att.BOYSHP, S57val.BoySHP.BOY_SPAR
                        )
                    ) {
                        Renderer.symbol(
                            Topmarks.RadarReflector,
                            Symbols.Delta(Symbols.Handle.BC, AffineTransform.getTranslateInstance(50.0, -160.0))
                        )
                    } else {
                        Renderer.symbol(
                            Topmarks.RadarReflector,
                            Symbols.Delta(Symbols.Handle.BC, AffineTransform.getTranslateInstance(25.0, -80.0))
                        )
                    }
                } else {
                    if (Rules.testAttribute(
                            Rules.feature!!.type,
                            Att.BOYSHP,
                            S57val.BoySHP.BOY_PILR
                        ) || Rules.testAttribute(
                            Rules.feature!!.type, Att.BOYSHP, S57val.BoySHP.BOY_SPAR
                        )
                    ) {
                        Renderer.symbol(
                            Topmarks.RadarReflector,
                            Symbols.Delta(Symbols.Handle.BC, AffineTransform.getTranslateInstance(30.0, -100.0))
                        )
                    } else {
                        Renderer.symbol(
                            Topmarks.RadarReflector,
                            Symbols.Delta(Symbols.Handle.BC, AffineTransform.getTranslateInstance(10.0, -50.0))
                        )
                    }
                }
                else -> {}
            }
        }
    }

    fun fogSignals() {
        if (Renderer.zoom >= 11) Renderer.symbol(Beacons.FogSignal)
        if (Renderer.zoom >= 15) {
            val atts: S57map.AttMap? = Rules.feature!!.objs!!.get(Obj.FOGSIG)!!.get(0)
            if (atts != null) {
                var str: String? = ""
                if (atts.containsKey(Att.CATFOG)) {
                    str += fogSignals[(atts[Att.CATFOG]!!.value as ArrayList<*>?)!![0]]
                }
                str += if (atts.containsKey(Att.SIGGRP)) {
                    "(" + atts[Att.SIGGRP]!!.value + ")"
                } else {
                    " "
                }
                if (atts.containsKey(Att.SIGPER)) {
                    str += df.format(atts[Att.SIGPER]!!.value) + "s"
                }
                if (atts.containsKey(Att.VALMXR)) {
                    str += df.format(atts[Att.VALMXR]!!.value) + "M"
                }
                if (!str!!.isEmpty()) {
                    Renderer.labelText(
                        str, Font("Arial", Font.PLAIN, 40), Color.black,
                        Symbols.Delta(Symbols.Handle.TR, AffineTransform.getTranslateInstance(-60.0, -30.0))
                    )
                }
            }
        }
    }

    fun radarStations() {
        if (Renderer.zoom >= 11) Renderer.symbol(Beacons.RadarStation)
        if (Renderer.zoom >= 15) {
            var bstr = ""
            val cat = Rules.getAttEnum(Obj.RTPBCN, Att.CATRTB) as S57val.CatRTB
            val wal: String = Rules.getAttStr(Obj.RTPBCN, Att.RADWAL)
            when (cat) {
                S57val.CatRTB.RTB_RAMK -> bstr += " Ramark"
                S57val.CatRTB.RTB_RACN -> {
                    bstr += " Racon"
                    val astr: String = Rules.getAttStr(Obj.RTPBCN, Att.SIGGRP)
                    if (!astr.isEmpty()) {
                        bstr += "($astr)"
                    }
                    val per = Rules.getAttVal(Obj.RTPBCN, Att.SIGPER) as Double
                    val mxr = Rules.getAttVal(Obj.RTPBCN, Att.VALMXR) as Double
                    if (per != null || mxr != null) {
                        bstr += if (astr.isEmpty()) " " else ""
                        if (per != null) bstr += if (per != 0.0) per.toString() + "s" else ""
                        if (mxr != null) bstr += if (mxr != 0.0) mxr.toString() + "M" else ""
                    }
                }
                else -> {}
            }
            if (!wal.isEmpty()) {
                when (wal) {
                    "0.03-X" -> bstr += "(3cm)"
                    "0.10-S" -> bstr += "(10cm)"
                }
            }
            if (!bstr.isEmpty()) {
                Renderer.labelText(
                    bstr, Font("Arial", Font.PLAIN, 40), Symbols.Msymb,
                    Symbols.Delta(Symbols.Handle.TR, AffineTransform.getTranslateInstance(-30.0, -70.0))
                )
            }
        }
    }

    fun radioStations() {
        var vais = false
        var bstr = ""
        if (Renderer.zoom >= 11) {
            val cats = Rules.getAttList(Obj.RDOSTA, Att.CATROS) as ArrayList<CatROS?>
            for (ros in cats) {
                when (ros) {
                    CatROS.ROS_OMNI -> bstr += " RC"
                    CatROS.ROS_DIRL -> bstr += " RD"
                    CatROS.ROS_ROTP -> bstr += " RW"
                    CatROS.ROS_CNSL -> bstr += " Consol"
                    CatROS.ROS_RDF -> bstr += " RG"
                    CatROS.ROS_QTA -> bstr += " R"
                    CatROS.ROS_AERO -> bstr += " AeroRC"
                    CatROS.ROS_DECA -> bstr += " Decca"
                    CatROS.ROS_LORN -> bstr += " Loran"
                    CatROS.ROS_DGPS -> bstr += " DGPS"
                    CatROS.ROS_TORN -> bstr += " Toran"
                    CatROS.ROS_OMGA -> bstr += " Omega"
                    CatROS.ROS_SYLD -> bstr += " Syledis"
                    CatROS.ROS_CHKA -> bstr += " Chiaka"
                    CatROS.ROS_PCOM, CatROS.ROS_COMB, CatROS.ROS_FACS, CatROS.ROS_TIME -> {}
                    CatROS.ROS_PAIS, CatROS.ROS_SAIS -> bstr += " AIS"
                    CatROS.ROS_VAIS -> vais = true
                    CatROS.ROS_VANC -> {
                        vais = true
                        Renderer.symbol(
                            Topmarks.TopNorth,
                            Symbols.Delta(Symbols.Handle.BC, AffineTransform.getTranslateInstance(0.0, -25.0))
                        )
                    }
                    CatROS.ROS_VASC -> {
                        vais = true
                        Renderer.symbol(
                            Topmarks.TopSouth,
                            Symbols.Delta(Symbols.Handle.BC, AffineTransform.getTranslateInstance(0.0, -25.0))
                        )
                    }
                    CatROS.ROS_VAEC -> {
                        vais = true
                        Renderer.symbol(
                            Topmarks.TopEast,
                            Symbols.Delta(Symbols.Handle.BC, AffineTransform.getTranslateInstance(0.0, -25.0))
                        )
                    }
                    CatROS.ROS_VAWC -> {
                        vais = true
                        Renderer.symbol(
                            Topmarks.TopWest,
                            Symbols.Delta(Symbols.Handle.BC, AffineTransform.getTranslateInstance(0.0, -25.0))
                        )
                    }
                    CatROS.ROS_VAPL -> {
                        vais = true
                        Renderer.symbol(
                            Topmarks.TopCan,
                            Symbols.Delta(Symbols.Handle.BC, AffineTransform.getTranslateInstance(0.0, -25.0))
                        )
                    }
                    CatROS.ROS_VASL -> {
                        vais = true
                        Renderer.symbol(
                            Topmarks.TopCone,
                            Symbols.Delta(Symbols.Handle.BC, AffineTransform.getTranslateInstance(0.0, -25.0))
                        )
                    }
                    CatROS.ROS_VAID -> {
                        vais = true
                        Renderer.symbol(
                            Topmarks.TopIsol,
                            Symbols.Delta(Symbols.Handle.BC, AffineTransform.getTranslateInstance(0.0, -25.0))
                        )
                    }
                    CatROS.ROS_VASW -> {
                        vais = true
                        Renderer.symbol(
                            Topmarks.TopSphere,
                            Symbols.Delta(Symbols.Handle.BC, AffineTransform.getTranslateInstance(0.0, -25.0))
                        )
                    }
                    CatROS.ROS_VASP -> {
                        vais = true
                        Renderer.symbol(
                            Topmarks.TopX,
                            Symbols.Delta(Symbols.Handle.BC, AffineTransform.getTranslateInstance(0.0, -25.0))
                        )
                    }
                    CatROS.ROS_VAWK -> {
                        vais = true
                        Renderer.symbol(
                            Topmarks.TopCross,
                            Symbols.Delta(Symbols.Handle.BC, AffineTransform.getTranslateInstance(0.0, -25.0))
                        )
                    }
                    else -> {}
                }
            }
            if (!vais) {
                Renderer.symbol(Beacons.RadarStation)
            }
        }
        if (Renderer.zoom >= 15) {
            if (vais) {
                Renderer.labelText(
                    "V-AIS", Font("Arial", Font.PLAIN, 40), Symbols.Msymb,
                    Symbols.Delta(Symbols.Handle.BC, AffineTransform.getTranslateInstance(0.0, 70.0))
                )
            }
            if (!bstr.isEmpty()) {
                Renderer.labelText(
                    bstr, Font("Arial", Font.PLAIN, 40), Symbols.Msymb,
                    Symbols.Delta(Symbols.Handle.TR, AffineTransform.getTranslateInstance(-30.0, -110.0))
                )
            }
        }
    }

    fun lights() {
        var col: Enum<ColCOL>? = null
        var tcol: Enum<ColCOL>? = null
        val lights = Rules.feature!!.objs!!.get(Obj.LIGHTS)
        for (atts in lights!!.values) {
            if (atts!!.containsKey(Att.COLOUR)) {
                val cols = atts[Att.COLOUR]!!.value as ArrayList<Enum<ColCOL>>?
                if (cols!!.size == 1) {
                    tcol = cols[0]
                    if (col == null) {
                        col = tcol
                    } else if (tcol !== col) {
                        col = ColCOL.COL_MAG
                        break
                    }
                } else {
                    col = ColCOL.COL_MAG
                    break
                }
            }
        }
        Renderer.symbol(
            Beacons.LightFlare, Symbols.Scheme(LightColours.get(col)),
            Symbols.Delta(Symbols.Handle.BC, AffineTransform.getRotateInstance(Math.toRadians(120.0)))
        )
        if (Renderer.zoom >= 12) {
            var str: String? = ""
            if (lights[1] != null) {
                for (atts in lights.values) {
                    var col1: Enum<ColCOL>? = null
                    var col2: Enum<ColCOL>? = null
                    val radius = 0.2
                    var s1 = 361.0
                    var s2 = 361.0
                    var dir: Double? = null
                    if (atts!!.containsKey(Att.COLOUR)) {
                        val cols = atts[Att.COLOUR]!!.value as ArrayList<ColCOL>?
                        col1 = cols!![0]
                        if (cols.size > 1) col2 = cols[1]
                    } else {
                        continue
                    }
                    if (atts.containsKey(Att.CATLIT)) {
                        val cats = atts[Att.CATLIT]!!.value as ArrayList<S57val.CatLIT?>?
                        if (cats!!.contains(S57val.CatLIT.LIT_DIR)) {
                            if (atts.containsKey(Att.ORIENT)) {
                                dir = atts[Att.ORIENT]!!.value as Double?
                                s1 = (dir!! - 4 + 360) % 360
                                s2 = (dir + 4) % 360
                                for (satts in lights.values) {
                                    val srad = 0.2
                                    var ss1 = 361.0
                                    var ss2 = 361.0
                                    var sdir: Double? = null
                                    if (satts === atts) continue
                                    if (srad == radius) {
                                        val scats =
                                            (if (satts!!.containsKey(Att.CATLIT)) satts[Att.CATLIT]!!.value as ArrayList<S57val.CatLIT?>? else ArrayList<Any?>()) as ArrayList<S57val.CatLIT?>?
                                        if (scats!!.contains(S57val.CatLIT.LIT_DIR)) {
                                            if (satts.containsKey(Att.ORIENT)) {
                                                sdir = satts[Att.ORIENT]!!.value as Double?
                                                ss1 = sdir!!
                                                ss2 = sdir
                                            }
                                        } else {
                                            if (satts.containsKey(Att.SECTR1)) {
                                                ss1 = (satts[Att.SECTR1]!!.value as Double?)!!
                                            }
                                            if (satts.containsKey(Att.SECTR2)) {
                                                ss2 = (satts[Att.SECTR2]!!.value as Double?)!!
                                            }
                                        }
                                        if (ss1 > 360 || ss2 > 360) continue
                                        if (sdir != null) {
                                            if ((dir - sdir + 360) % 360 < 8) {
                                                s1 = ((if (sdir > dir) 360 else 0) + sdir + dir) / 2 % 360
                                            }
                                            if ((sdir - dir + 360) % 360 < 8) {
                                                s2 = ((if (dir > sdir) 360 else 0) + sdir + dir) / 2 % 360
                                            }
                                        } else {
                                            if ((dir - ss2 + 360) % 360 < 4) {
                                                s1 = ss2
                                            }
                                            if ((ss1 - dir + 360) % 360 < 4) {
                                                s2 = ss1
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                    if (s1 > 360 && atts.containsKey(Att.SECTR1)) {
                        s1 = (atts[Att.SECTR1]!!.value as Double?)!!
                    } else if (dir == null) {
                        continue
                    }
                    if (s2 > 360 && atts.containsKey(Att.SECTR2)) {
                        s2 = (atts[Att.SECTR2]!!.value as Double?)!!
                    } else if (dir == null) {
                        continue
                    }
                    str = ""
                    if (atts.containsKey(Att.LITCHR)) {
                        str += LightCharacters[(atts[Att.LITCHR]!!.value as ArrayList<S57val.LitCHR>?)!![0]]
                    }
                    if (atts.containsKey(Att.SIGGRP)) {
                        str += "(" + atts[Att.SIGGRP]!!.value + ")"
                    } else if (!str.isEmpty()) {
                        str += "."
                    }
                    if (atts.containsKey(Att.COLOUR)) {
                        val cols = atts[Att.COLOUR]!!.value as ArrayList<Enum<ColCOL>?>?
                        str += LightLetters.get(cols!![0])
                        if (cols.size > 1) str += LightLetters.get(cols[1])
                    }
                    if (atts.containsKey(Att.SIGPER)) {
                        str += "." + df.format(atts[Att.SIGPER]!!.value) + "s"
                    }
                    if (s1 <= 360 && s2 <= 360 && s1 != s2) Renderer.lightSector(
                        LightColours.get(col1), LightColours.get(col2), radius, s1, s2, dir,
                        if (Renderer.zoom >= 15) str else ""
                    )
                }
                if (Renderer.zoom >= 15) {
                    class LitSect {
                        var dir = false
                        var chr: S57val.LitCHR? = null
                        var col: ColCOL? = null
                        var grp: String? = null
                        var per = 0.0
                        var rng = 0.0
                        var hgt = 0.0
                    }

                    val litatts = ArrayList<LitSect?>()
                    for (atts in lights.values) {
                        val sect = LitSect()
                        sect.dir =
                            atts!!.containsKey(Att.CATLIT) && (atts[Att.CATLIT]!!.value as ArrayList<S57val.CatLIT?>?)!!.contains(
                                S57val.CatLIT.LIT_DIR
                            )
                        sect.chr =
                            if (atts.containsKey(Att.LITCHR)) (atts[Att.LITCHR]!!.value as ArrayList<S57val.LitCHR?>?)!![0] else S57val.LitCHR.CHR_UNKN
                        when (sect.chr) {
                            S57val.LitCHR.CHR_AL -> sect.chr = S57val.LitCHR.CHR_F
                            S57val.LitCHR.CHR_ALOC -> sect.chr = S57val.LitCHR.CHR_OC
                            S57val.LitCHR.CHR_ALLFL -> sect.chr = S57val.LitCHR.CHR_LFL
                            S57val.LitCHR.CHR_ALFL -> sect.chr = S57val.LitCHR.CHR_FL
                            S57val.LitCHR.CHR_ALFFL -> sect.chr = S57val.LitCHR.CHR_FFL
                            else -> {}
                        }
                        sect.grp =
                            if (atts.containsKey(Att.SIGGRP)) atts[Att.SIGGRP]!!.value as String? else ""
                        sect.per =
                            if (atts.containsKey(Att.SIGPER)) (atts[Att.SIGPER]!!.value as Double?)!! else 0.0
                        sect.rng =
                            if (atts.containsKey(Att.VALNMR)) (atts[Att.VALNMR]!!.value as Double?)!! else 0.0
                        sect.hgt =
                            if (atts.containsKey(Att.HEIGHT)) (atts[Att.HEIGHT]!!.value as Double?)!! else 0.0
                        val cols =
                            (if (atts.containsKey(Att.COLOUR)) atts[Att.COLOUR]!!.value else ArrayList<Any?>()) as ArrayList<ColCOL>
                        sect.col = if (cols.size > 0) cols[0] else ColCOL.COL_UNK
                        if (sect.chr !== S57val.LitCHR.CHR_UNKN && sect.col != null) litatts.add(sect)
                    }
                    val groupings = ArrayList<ArrayList<LitSect?>?>()
                    for (lit in litatts) {
                        var found = false
                        for (group in groupings) {
                            val mem = group!![0]
                            if (lit!!.dir == mem!!.dir && lit.chr === mem.chr && lit.grp == mem.grp && lit.per == mem.per && lit.hgt == mem.hgt) {
                                group.add(lit)
                                found = true
                            }
                        }
                        if (!found) {
                            val tmp = ArrayList<LitSect?>()
                            tmp.add(lit)
                            groupings.add(tmp)
                        }
                    }
                    var moved = true
                    while (moved) {
                        moved = false
                        for (i in 0 until groupings.size - 1) {
                            if (groupings[i]!!.size < groupings[i + 1]!!.size) {
                                val tmp = groupings.removeAt(i)
                                groupings.add(i + 1, tmp)
                                moved = true
                            }
                        }
                    }
                    class ColRng(c: ColCOL?, r: Double) {
                        var col: ColCOL? = null
                        var rng: Double

                        init {
                            col = c
                            rng = r
                        }
                    }

                    var y = -30
                    for (group in groupings) {
                        val colrng = ArrayList<ColRng?>()
                        for (lit in group!!) {
                            var found = false
                            for (cr in colrng) {
                                if (cr!!.col === lit!!.col) {
                                    if (lit!!.rng > cr!!.rng) {
                                        cr.rng = lit.rng
                                    }
                                    found = true
                                }
                            }
                            if (!found) {
                                colrng.add(ColRng(lit!!.col, lit.rng))
                            }
                        }
                        var moved = true
                        while (moved) {
                            moved = false
                            for (i in 0 until colrng.size - 1) {
                                if (colrng[i]!!.rng < colrng[i + 1]!!.rng) {
                                    val tmp = colrng.removeAt(i)
                                    colrng.add(i + 1, tmp)
                                    moved = true
                                }
                            }
                        }
                        val tmp = group[0]
                        str = if (tmp!!.dir) "Dir" else ""
                        str += LightCharacters[tmp.chr]
                        str += if (!tmp.grp!!.isEmpty()) "(" + tmp.grp + ")" else "."
                        for (cr in colrng) {
                            str += LightLetters[cr!!.col]
                        }
                        if (tmp.per > 0 || tmp.hgt > 0 || colrng[0]!!.rng > 0) str += "."
                        if (tmp.per > 0) str += df.format(tmp.per) + "s"
                        if (tmp.hgt > 0) str += df.format(tmp.hgt) + "m"
                        if (colrng[0]!!.rng > 0) str += df.format(colrng[0]!!.rng) + (if (colrng.size > 1) if (colrng.size > 2) "-" + df.format(
                            colrng[colrng.size - 1]!!.rng
                        ) else "/" + df.format(colrng[1]!!.rng) else "") + "M"
                        Renderer.labelText(
                            str, Font("Arial", Font.PLAIN, 40), Color.black,
                            Symbols.Delta(Symbols.Handle.TL, AffineTransform.getTranslateInstance(60.0, y.toDouble()))
                        )
                        y += 40
                        str = ""
                    }
                }
            } else {
                if (Renderer.zoom >= 15) {
                    val atts = lights[0]
                    var cats: ArrayList<S57val.CatLIT?>? = ArrayList()
                    if (atts!!.containsKey(Att.CATLIT)) {
                        cats = atts[Att.CATLIT]!!.value as ArrayList<S57val.CatLIT?>?
                    }
                    str = if (cats!!.contains(S57val.CatLIT.LIT_DIR)) "Dir" else ""
                    str += if (atts.containsKey(Att.MLTYLT)) atts[Att.MLTYLT]!!.value else ""
                    if (atts.containsKey(Att.LITCHR)) {
                        val chr = (atts[Att.LITCHR]!!.value as ArrayList<S57val.LitCHR?>?)!![0]
                        str += if (atts.containsKey(Att.SIGGRP)) {
                            val grp = atts[Att.SIGGRP]!!.value as String?
                            when (chr) {
                                S57val.LitCHR.CHR_QLFL -> String.format("Q(%s)+LFl", grp)
                                S57val.LitCHR.CHR_VQLFL -> String.format("VQ(%s)+LFl", grp)
                                S57val.LitCHR.CHR_UQLFL -> String.format("UQ(%s)+LFl", grp)
                                else -> String.format("%s(%s)", LightCharacters[chr], grp)
                            }
                        } else {
                            LightCharacters[chr]
                        }
                    }
                    if (atts.containsKey(Att.COLOUR)) {
                        val cols = atts[Att.COLOUR]!!.value as ArrayList<ColCOL>?
                        if (!(cols!!.size == 1 && cols[0] === ColCOL.COL_WHT)) {
                            if (!str.isEmpty() && !str.endsWith(")")) {
                                str += "."
                            }
                            for (acol in cols) {
                                str += LightLetters[acol]
                            }
                        }
                    }
                    str += if (cats.contains(S57val.CatLIT.LIT_VERT)) "(vert)" else ""
                    str += if (cats.contains(S57val.CatLIT.LIT_HORI)) "(hor)" else ""
                    str += if (!str.isEmpty() && (atts.containsKey(Att.SIGPER) || atts.containsKey(Att.HEIGHT) || atts.containsKey(
                            Att.VALMXR
                        ))
                        && !str.endsWith(")")
                    ) "." else ""
                    str += if (atts.containsKey(Att.SIGPER)) df.format(atts[Att.SIGPER]!!.value) + "s" else ""
                    str += if (atts.containsKey(Att.HEIGHT)) df.format(atts[Att.HEIGHT]!!.value) + "m" else ""
                    str += if (atts.containsKey(Att.VALNMR)) df.format(atts[Att.VALNMR]!!.value) + "M" else ""
                    str += if (cats.contains(S57val.CatLIT.LIT_FRNT)) "(Front)" else ""
                    str += if (cats.contains(S57val.CatLIT.LIT_REAR)) "(Rear)" else ""
                    str += if (cats.contains(S57val.CatLIT.LIT_UPPR)) "(Upper)" else ""
                    str += if (cats.contains(S57val.CatLIT.LIT_LOWR)) "(Lower)" else ""
                    Renderer.labelText(
                        str, Font("Arial", Font.PLAIN, 40), Color.black,
                        Symbols.Delta(Symbols.Handle.TL, AffineTransform.getTranslateInstance(60.0, -30.0))
                    )
                }
            }
        }
    }

    internal class Sect {
        var dir = 0
        var chr: S57val.LitCHR? = null
        var col: ColCOL? = null
        var alt: ColCOL? = null
        var grp: String? = null
        var per = 0.0
        var rng = 0.0
    }
}