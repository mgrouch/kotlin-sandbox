// License: GPL. For details, see LICENSE file.
package s57.render

import s57.parser.S57att.Att
import s57.parser.S57map.*
import s57.parser.S57obj.Obj
import s57.parser.S57val
import s57.parser.S57val.AddMRK
import s57.parser.S57val.BcnSHP
import s57.parser.S57val.BnkWTW
import s57.parser.S57val.BoySHP
import s57.parser.S57val.CatACH
import s57.parser.S57val.CatDIS
import s57.parser.S57val.CatHAF
import s57.parser.S57val.CatLAM
import s57.parser.S57val.CatLMK
import s57.parser.S57val.CatNMK
import s57.parser.S57val.CatROD
import s57.parser.S57val.CatSCF
import s57.parser.S57val.CatSEA
import s57.parser.S57val.CatSIW
import s57.parser.S57val.CatWED
import s57.parser.S57val.CatWRK
import s57.parser.S57val.ColCOL
import s57.parser.S57val.ColPAT
import s57.parser.S57val.FncFNC
import s57.parser.S57val.MarSYS
import s57.parser.S57val.TopSHP
import s57.parser.S57val.TrfTRF
import s57.parser.S57val.UniHLU
import s57.parser.S57val.unknAtt
import s57.parser.deg2rad

import s57.render.Renderer.LabelStyle
import s57.render.Renderer.fillPattern
import s57.render.Renderer.labelText
import s57.render.Renderer.lineSymbols
import s57.render.Renderer.lineText
import s57.render.Renderer.lineVector
import s57.render.Renderer.symbol

import s57.symbols.*
import s57.symbols.Notices.getNotice
import s57.symbols.Notices.getScheme
import s57.symbols.Symbols.Delta
import s57.symbols.Symbols.Handle
import s57.symbols.Symbols.LineStyle
import s57.symbols.Symbols.Patt
import s57.symbols.Symbols.Scheme

import java.awt.Color
import java.awt.Color.black
import java.awt.Color.white
import java.awt.Font
import java.awt.Font.BOLD
import java.awt.Font.PLAIN
import java.awt.geom.AffineTransform
import java.text.DecimalFormat

/**
 * @author Malcolm Herring
 */
open class Rules {
    companion object {
        val df = DecimalFormat("#.#")
        val bodyColours = mapOf(
            ColCOL.COL_UNK to Color(0, true),
            ColCOL.COL_WHT to Color(0xffffff),
            ColCOL.COL_BLK to Color(0x000000),
            ColCOL.COL_RED to Color(0xd40000),
            ColCOL.COL_GRN to Color(0x00d400),
            ColCOL.COL_BLU to Color.blue,
            ColCOL.COL_YEL to Color(0xffd400),
            ColCOL.COL_GRY to Color.gray,
            ColCOL.COL_BRN to Color(0x8b4513),
            ColCOL.COL_AMB to Color(0xfbf00f),
            ColCOL.COL_VIO to Color(0xee82ee),
            ColCOL.COL_ORG to Color.orange,
            ColCOL.COL_MAG to Color(0xf000f0),
            ColCOL.COL_PNK to Color.pink,
        )

        val pattMap = mapOf(
            ColPAT.PAT_UNKN to Patt.Z,
            ColPAT.PAT_HORI to Patt.H,
            ColPAT.PAT_VERT to Patt.V,
            ColPAT.PAT_DIAG to Patt.D,
            ColPAT.PAT_BRDR to Patt.B,
            ColPAT.PAT_SQUR to Patt.S,
            ColPAT.PAT_CROS to Patt.C,
            ColPAT.PAT_SALT to Patt.X,
            ColPAT.PAT_STRP to Patt.H,
        )

        val name: String?
            get() {
                var name = feature!!.atts[Att.OBJNAM]
                if (name == null) {
                    if (feature!!.objs != null && !feature!!.objs.isEmpty()) {
                        val atts = feature!!.objs[feature!!.type]!![0]
                        if (atts != null) {
                            name = atts[Att.OBJNAM]
                        }
                    }
                }
                return if (name != null) name.value as String? else null
            }

        fun addName(z: Int, font: Font, delta: Delta?) {
            addName(z, font, black, delta)
        }

        fun addName(
            z: Int, font: Font, colour: Color? = black, delta: Delta? = Delta(Handle.CC, AffineTransform())
        ) {
            if (Renderer.zoom >= z) {
                val name = name
                if (name != null) {
                    labelText(name, font, colour, delta)
                }
            }
        }

        fun getAtts(obj: Obj, idx: Int): AttMap? {
            val objs = feature!!.objs[obj]
            return objs?.get(idx)
        }

        fun getAttVal(obj: Obj?, att: Att): Any? {
            val objs = feature!!.objs[obj]
            val atts = if (objs != null) objs[0]
            else return null
            return atts!![att]?.value
        }

        fun getAttStr(obj: Obj?, att: Att): String {
            val str = getAttVal(obj, att) as String?
            return str ?: ""
        }

        fun getAttEnum(obj: Obj?, att: Att): Enum<*> {
            val list = getAttVal(obj, att) as ArrayList<*>?
            return if (list != null) {
                (list as ArrayList<Enum<*>>)[0]
            } else unknAtt(att)
        }

        fun getAttList(obj: Obj?, att: Att): ArrayList<*> {
            val list = getAttVal(obj, att)
            if (list != null) {
                list as ArrayList<Enum<*>>
                return list
            }
            val listAlt = ArrayList<Enum<*>>()
            listAlt.add(unknAtt(att))
            return listAlt
        }

        fun getScheme(obj: Obj?): Scheme {
            val colours = ArrayList<Color?>()
            for (col in getAttList(obj, Att.COLOUR) as ArrayList<ColCOL>) {
                colours.add(bodyColours[col])
            }
            val patterns = ArrayList<Patt>()
            for (pat in getAttList(obj, Att.COLPAT) as ArrayList<ColPAT>) {
                patterns.add(pattMap[pat]!!)
            }
            return Scheme(patterns, colours)
        }

        fun hasAttribute(obj: Obj, att: Att): Boolean {
            val atts = getAtts(obj, 0)
            if (atts != null) {
                val item = atts[att]
                return item != null
            }
            return false
        }

        fun testAttribute(obj: Obj?, att: Att, value: Any): Boolean {
            val atts = getAtts(obj!!, 0)
            if (atts != null) {
                val item = atts[att]
                if (item != null) {
                    return when (item.conv) {
                        S57val.Conv.S, S57val.Conv.A -> item.value as String == value
                        S57val.Conv.E, S57val.Conv.L -> (item.value as ArrayList<*>).contains(value)
                        S57val.Conv.F, S57val.Conv.I -> item.value === value
                    }
                }
            }
            return false
        }

        fun hasObject(obj: Obj): Boolean {
            return feature!!.objs.containsKey(obj)
        }

        var feature: Feature? = null
        var objects: ArrayList<Feature?>? = null

        fun testObject(obj: Obj): Boolean {
            objects = Renderer.map!!.features[obj]
            return objects != null
        }

        fun testFeature(f: Feature?): Boolean {
            feature = f
            return feature!!.reln === Rflag.MASTER
        }

        fun rules(): Boolean {
            if (Renderer.context.ruleset() === ChartContext.RuleSet.ALL
                || Renderer.context.ruleset() === ChartContext.RuleSet.BASE
            ) {
                if (testObject(Obj.LNDARE)) for (f in objects!!) if (testFeature(f)) areas()
                if (testObject(Obj.BUAARE)) for (f in objects!!) if (testFeature(f)) areas()
                if (testObject(Obj.HRBFAC)) for (f in objects!!) if (testFeature(f)) areas()
                if (testObject(Obj.HRBBSN)) for (f in objects!!) if (testFeature(f)) areas()
                if (testObject(Obj.LOKBSN)) for (f in objects!!) if (testFeature(f)) areas()
                if (testObject(Obj.LKBSPT)) for (f in objects!!) if (testFeature(f)) areas()
                if (testObject(Obj.LAKARE)) for (f in objects!!) if (testFeature(f)) areas()
                if (testObject(Obj.RIVERS)) for (f in objects!!) if (testFeature(f)) waterways()
                if (testObject(Obj.CANALS)) for (f in objects!!) if (testFeature(f)) waterways()
                if (testObject(Obj.DEPARE)) for (f in objects!!) if (testFeature(f)) areas()
                if (testObject(Obj.COALNE)) for (f in objects!!) if (testFeature(f)) areas()
                if (testObject(Obj.ROADWY)) for (f in objects!!) if (testFeature(f)) highways()
                if (testObject(Obj.RAILWY)) for (f in objects!!) if (testFeature(f)) highways()
            }
            if (Renderer.context.ruleset() === ChartContext.RuleSet.ALL) {
                if (testObject(Obj.SOUNDG)) for (f in objects!!) if (testFeature(f)) depths()
                if (testObject(Obj.DEPCNT)) for (f in objects!!) if (testFeature(f)) depths()
            }
            if (testObject(Obj.SLCONS)) for (f in objects!!) if (testFeature(f)) shoreline()
            if (Renderer.context.ruleset() === ChartContext.RuleSet.ALL
                || Renderer.context.ruleset() === ChartContext.RuleSet.SEAMARK
            ) {
                if (testObject(Obj.PIPSOL)) for (f in objects!!) if (testFeature(f)) pipelines()
                if (testObject(Obj.CBLSUB)) for (f in objects!!) if (testFeature(f)) cables()
                if (testObject(Obj.PIPOHD)) for (f in objects!!) if (testFeature(f)) pipelines()
                if (testObject(Obj.CBLOHD)) for (f in objects!!) if (testFeature(f)) cables()
                if (testObject(Obj.TSEZNE)) for (f in objects!!) if (testFeature(f)) separation()
                if (testObject(Obj.TSSCRS)) for (f in objects!!) if (testFeature(f)) separation()
                if (testObject(Obj.TSSRON)) for (f in objects!!) if (testFeature(f)) separation()
                if (testObject(Obj.TSELNE)) for (f in objects!!) if (testFeature(f)) separation()
                if (testObject(Obj.TSSLPT)) for (f in objects!!) if (testFeature(f)) separation()
                if (testObject(Obj.TSSBND)) for (f in objects!!) if (testFeature(f)) separation()
                if (testObject(Obj.ISTZNE)) for (f in objects!!) if (testFeature(f)) separation()
                if (testObject(Obj.SNDWAV)) for (f in objects!!) if (testFeature(f)) areas()
                if (testObject(Obj.WEDKLP)) for (f in objects!!) if (testFeature(f)) areas()
                if (testObject(Obj.OSPARE)) for (f in objects!!) if (testFeature(f)) areas()
                if (testObject(Obj.FAIRWY)) for (f in objects!!) if (testFeature(f)) areas()
                if (testObject(Obj.DRGARE)) for (f in objects!!) if (testFeature(f)) areas()
                if (testObject(Obj.RESARE)) for (f in objects!!) if (testFeature(f)) areas()
                if (testObject(Obj.PRCARE)) for (f in objects!!) if (testFeature(f)) areas()
                if (testObject(Obj.SPLARE)) for (f in objects!!) if (testFeature(f)) areas()
                if (testObject(Obj.SEAARE)) for (f in objects!!) if (testFeature(f)) areas()
                if (testObject(Obj.OBSTRN)) for (f in objects!!) if (testFeature(f)) obstructions()
                if (testObject(Obj.UWTROC)) for (f in objects!!) if (testFeature(f)) obstructions()
                if (testObject(Obj.MARCUL)) for (f in objects!!) if (testFeature(f)) areas()
                if (testObject(Obj.RECTRC)) for (f in objects!!) if (testFeature(f)) transits()
                if (testObject(Obj.NAVLNE)) for (f in objects!!) if (testFeature(f)) transits()
                if (testObject(Obj.HRBFAC)) for (f in objects!!) if (testFeature(f)) harbours()
                if (testObject(Obj.ACHARE)) for (f in objects!!) if (testFeature(f)) harbours()
                if (testObject(Obj.ACHBRT)) for (f in objects!!) if (testFeature(f)) harbours()
                if (testObject(Obj.BERTHS)) for (f in objects!!) if (testFeature(f)) harbours()
                if (testObject(Obj.DISMAR)) for (f in objects!!) if (testFeature(f)) distances()
                if (testObject(Obj.HULKES)) for (f in objects!!) if (testFeature(f)) ports()
                if (testObject(Obj.CRANES)) for (f in objects!!) if (testFeature(f)) ports()
                if (testObject(Obj.LNDMRK)) for (f in objects!!) if (testFeature(f)) landmarks()
                if (testObject(Obj.SILTNK)) for (f in objects!!) if (testFeature(f)) landmarks()
                if (testObject(Obj.BUISGL)) for (f in objects!!) if (testFeature(f)) harbours()
                if (testObject(Obj.MORFAC)) for (f in objects!!) if (testFeature(f)) moorings()
                if (testObject(Obj.NOTMRK)) for (f in objects!!) if (testFeature(f)) notices()
                if (testObject(Obj.SMCFAC)) for (f in objects!!) if (testFeature(f)) marinas()
                if (testObject(Obj.BRIDGE)) for (f in objects!!) if (testFeature(f)) bridges()
                if (testObject(Obj.PILPNT)) for (f in objects!!) if (testFeature(f)) points()
                if (testObject(Obj.TOPMAR)) for (f in objects!!) if (testFeature(f)) points()
                if (testObject(Obj.DAYMAR)) for (f in objects!!) if (testFeature(f)) points()
                if (testObject(Obj.FOGSIG)) for (f in objects!!) if (testFeature(f)) points()
                if (testObject(Obj.RDOCAL)) for (f in objects!!) if (testFeature(f)) callpoint()
                if (testObject(Obj.LITMIN)) for (f in objects!!) if (testFeature(f)) lights()
                if (testObject(Obj.LITMAJ)) for (f in objects!!) if (testFeature(f)) lights()
                if (testObject(Obj.LIGHTS)) for (f in objects!!) if (testFeature(f)) lights()
                if (testObject(Obj.SISTAT)) for (f in objects!!) if (testFeature(f)) stations()
                if (testObject(Obj.SISTAW)) for (f in objects!!) if (testFeature(f)) stations()
                if (testObject(Obj.CGUSTA)) for (f in objects!!) if (testFeature(f)) stations()
                if (testObject(Obj.RDOSTA)) for (f in objects!!) if (testFeature(f)) stations()
                if (testObject(Obj.RADRFL)) for (f in objects!!) if (testFeature(f)) stations()
                if (testObject(Obj.RADSTA)) for (f in objects!!) if (testFeature(f)) stations()
                if (testObject(Obj.RTPBCN)) for (f in objects!!) if (testFeature(f)) stations()
                if (testObject(Obj.RSCSTA)) for (f in objects!!) if (testFeature(f)) stations()
                if (testObject(Obj.PILBOP)) for (f in objects!!) if (testFeature(f)) stations()
                if (testObject(Obj.WTWGAG)) for (f in objects!!) if (testFeature(f)) gauges()
                if (testObject(Obj.OFSPLF)) for (f in objects!!) if (testFeature(f)) platforms()
                if (testObject(Obj.WRECKS)) for (f in objects!!) if (testFeature(f)) wrecks()
                if (testObject(Obj.LITVES)) for (f in objects!!) if (testFeature(f)) floats()
                if (testObject(Obj.LITFLT)) for (f in objects!!) if (testFeature(f)) floats()
                if (testObject(Obj.BOYINB)) for (f in objects!!) if (testFeature(f)) floats()
                if (testObject(Obj.BOYLAT)) for (f in objects!!) if (testFeature(f)) buoys()
                if (testObject(Obj.BOYCAR)) for (f in objects!!) if (testFeature(f)) buoys()
                if (testObject(Obj.BOYISD)) for (f in objects!!) if (testFeature(f)) buoys()
                if (testObject(Obj.BOYSAW)) for (f in objects!!) if (testFeature(f)) buoys()
                if (testObject(Obj.BOYSPP)) for (f in objects!!) if (testFeature(f)) buoys()
                if (testObject(Obj.BCNLAT)) for (f in objects!!) if (testFeature(f)) beacons()
                if (testObject(Obj.BCNCAR)) for (f in objects!!) if (testFeature(f)) beacons()
                if (testObject(Obj.BCNISD)) for (f in objects!!) if (testFeature(f)) beacons()
                if (testObject(Obj.BCNSAW)) for (f in objects!!) if (testFeature(f)) beacons()
                if (testObject(Obj.BCNSPP)) for (f in objects!!) if (testFeature(f)) beacons()
            }
            return true
        }

        private fun areas() {
            val name = name
            when (feature!!.type) {
                Obj.BUAARE -> lineVector(LineStyle(Color(0x20000000, true)))
                Obj.COALNE -> if (Renderer.zoom >= 12) lineVector(LineStyle(black, 10f))
                Obj.DEPARE -> {
                    val depmax = getAttVal(Obj.DEPARE, Att.DRVAL2) as Double?
                    if (depmax != null && depmax <= 0.0) {
                        lineVector(LineStyle(Symbols.Gdries))
                    }
                }
                Obj.LAKARE -> if (Renderer.zoom >= 12 || feature!!.geom.area > 10.0) lineVector(
                    LineStyle(Symbols.Bwater)
                )
                Obj.DRGARE -> {
                    if (Renderer.zoom < 16) lineVector(
                        LineStyle(
                            black,
                            8f,
                            floatArrayOf(25f, 25f),
                            Color(0x40ffffff, true)
                        )
                    ) else lineVector(
                        LineStyle(black, 8f, floatArrayOf(25f, 25f))
                    )
                    addName(12, Font("Arial", PLAIN, 100), Delta(Handle.CC, AffineTransform()))
                }
                Obj.FAIRWY -> if (feature!!.geom.area > 2.0) {
                    if (Renderer.zoom < 16) lineVector(
                        LineStyle(Symbols.Mline, 8f, floatArrayOf(50f, 50f), Color(0x40ffffff, true))
                    ) else lineVector(
                        LineStyle(Symbols.Mline, 8f, floatArrayOf(50f, 50f))
                    )
                } else {
                    if (Renderer.zoom >= 14) lineVector(LineStyle(Color(0x40ffffff, true)))
                }
                Obj.LKBSPT, Obj.LOKBSN, Obj.HRBBSN -> if (Renderer.zoom >= 12) {
                    lineVector(LineStyle(black, 10f, Symbols.Bwater))
                } else {
                    lineVector(LineStyle(Symbols.Bwater))
                }
                Obj.HRBFAC -> if (feature!!.objs[Obj.HRBBSN] != null) {
                    if (Renderer.zoom >= 12) {
                        lineVector(LineStyle(black, 10f, Symbols.Bwater))
                    } else {
                        lineVector(LineStyle(Symbols.Bwater))
                    }
                }
                Obj.LNDARE -> lineVector(LineStyle(Symbols.Yland))
                Obj.MARCUL -> if (Renderer.zoom >= 12) {
                    if (Renderer.zoom >= 14) {
                        symbol(Areas.MarineFarm)
                    }

                    if (feature!!.geom.area > 0.2 || (feature!!.geom.area > 0.05 && Renderer.zoom >= 14) ||
                        (feature!!.geom.area > 0.005 && Renderer.zoom >= 16)
                    ) {
                        lineVector(LineStyle(black, 4f, floatArrayOf(10f, 10f)))
                    }
                }
                Obj.OSPARE -> if (testAttribute(feature!!.type, Att.CATPRA, S57val.CatPRA.PRA_WFRM)) {
                    symbol(Areas.WindFarm)
                    lineVector(LineStyle(black, 20f, floatArrayOf(40f, 40f)))
                    addName(
                        15, Font("Arial", BOLD, 80),
                        Delta(Handle.TC, AffineTransform.getTranslateInstance(0.0, 10.0))
                    )
                }
                Obj.RESARE, Obj.MIPARE -> if (Renderer.zoom >= 12) {
                    lineSymbols(Areas.Restricted, 1.0, null, null, 0, Symbols.Mline)
                    if (testAttribute(feature!!.type, Att.CATREA, S57val.CatREA.REA_NWAK)) {
                        symbol(Areas.NoWake)
                    }
                }
                Obj.PRCARE -> if (Renderer.zoom >= 12) {
                    lineVector(LineStyle(Symbols.Mline, 10f, floatArrayOf(40f, 40f)))
                }
                Obj.SEAARE -> when (getAttEnum(feature!!.type, Att.CATSEA) as CatSEA) {
                    CatSEA.SEA_RECH -> if (Renderer.zoom >= 10 && name != null) if (feature!!.geom.prim === Pflag.LINE) {
                        lineText(name, Font("Arial", PLAIN, 150), black, -40.0)
                    } else {
                        labelText(
                            name, Font("Arial", PLAIN, 150), black,
                            Delta(Handle.BC, AffineTransform.getTranslateInstance(0.0, -40.0))
                        )
                    }
                    CatSEA.SEA_BAY -> if (Renderer.zoom >= 12 && name != null) if (feature!!.geom.prim === Pflag.LINE) {
                        lineText(name, Font("Arial", PLAIN, 150), black, -40.0)
                    } else {
                        labelText(
                            name, Font("Arial", PLAIN, 150), black,
                            Delta(Handle.BC, AffineTransform.getTranslateInstance(0.0, -40.0))
                        )
                    }
                    CatSEA.SEA_SHOL -> if (Renderer.zoom >= 14) {
                        if (feature!!.geom.prim === Pflag.AREA) {
                            lineVector(LineStyle(Color(0xc480ff), 4f, floatArrayOf(25f, 25f)))
                            if (name != null) {
                                labelText(
                                    name, Font("Arial", Font.ITALIC, 75), black,
                                    Delta(Handle.BC, AffineTransform.getTranslateInstance(0.0, -40.0))
                                )
                                labelText(
                                    "(Shoal)", Font("Arial", PLAIN, 60), black,
                                    Delta(Handle.BC)
                                )
                            }
                        } else if (feature!!.geom.prim === Pflag.LINE) {
                            if (name != null) {
                                lineText(name, Font("Arial", Font.ITALIC, 75), black, -40.0)
                                lineText("(Shoal)", Font("Arial", PLAIN, 60), black, 0.0)
                            }
                        } else {
                            if (name != null) {
                                labelText(
                                    name, Font("Arial", Font.ITALIC, 75), black,
                                    Delta(Handle.BC, AffineTransform.getTranslateInstance(0.0, -40.0))
                                )
                                labelText(
                                    "(Shoal)", Font("Arial", PLAIN, 60), black,
                                    Delta(Handle.BC)
                                )
                            }
                        }
                    }
                    CatSEA.SEA_GAT, CatSEA.SEA_NRRW -> addName(12, Font("Arial", PLAIN, 100))
                    else -> {}
                }
                Obj.SNDWAV -> if (Renderer.zoom >= 12) fillPattern(Areas.Sandwaves)
                Obj.WEDKLP -> if (Renderer.zoom >= 12) {
                    when (getAttEnum(feature!!.type, Att.CATWED) as CatWED) {
                        CatWED.WED_KELP -> if (feature!!.geom.prim === Pflag.AREA) {
                            fillPattern(Areas.KelpA)
                        } else {
                            symbol(Areas.KelpS)
                        }
                        else -> {}
                    }
                }
                Obj.SPLARE -> {
                    if (Renderer.zoom >= 12) {
                        symbol(Areas.Plane, Scheme(Symbols.Msymb))
                        lineSymbols(Areas.Restricted, 0.5, Areas.LinePlane, null, 10, Symbols.Mline)
                    }
                    addName(
                        15, Font("Arial", BOLD, 80),
                        Delta(Handle.BC, AffineTransform.getTranslateInstance(0.0, -90.0))
                    )
                }
                else -> {}
            }
        }

        private fun beacons() {
            if (Renderer.zoom >= 14
                || (Renderer.zoom >= 12 && (feature!!.type === Obj.BCNLAT || feature!!.type === Obj.BCNCAR))
                || (Renderer.zoom >= 11 && (feature!!.type === Obj.BCNSAW || hasObject(Obj.RTPBCN)))
            ) {
                var shape = getAttEnum(feature!!.type, Att.BCNSHP) as BcnSHP
                if (shape === BcnSHP.BCN_UNKN) shape = BcnSHP.BCN_PILE
                if (shape === BcnSHP.BCN_WTHY && feature!!.type === Obj.BCNLAT) {
                    when (getAttEnum(feature!!.type, Att.CATLAM) as CatLAM) {
                        CatLAM.LAM_PORT -> symbol(Beacons.WithyPort)
                        CatLAM.LAM_STBD -> symbol(Beacons.WithyStarboard)
                        else -> symbol(Beacons.Stake, getScheme(feature!!.type))
                    }
                } else if (shape === BcnSHP.BCN_PRCH && feature!!.type === Obj.BCNLAT
                    && !feature!!.objs.containsKey(Obj.TOPMAR)
                ) {
                    when (getAttEnum(feature!!.type, Att.CATLAM) as CatLAM) {
                        CatLAM.LAM_PORT -> symbol(Beacons.PerchPort)
                        CatLAM.LAM_STBD -> symbol(Beacons.PerchStarboard)
                        else -> symbol(Beacons.Stake, getScheme(feature!!.type))
                    }
                } else {
                    symbol(Beacons.Shapes[shape], getScheme(feature!!.type))
                    if (feature!!.objs.containsKey(Obj.TOPMAR)) {
                        val topmap = feature!!.objs[Obj.TOPMAR]!![0]
                        if (topmap!!.containsKey(Att.TOPSHP)) {
                            symbol(
                                Topmarks.Shapes[(topmap[Att.TOPSHP]!!.value as ArrayList<TopSHP?>)[0]],
                                getScheme(Obj.TOPMAR), Topmarks.BeaconDelta
                            )
                        }
                    } else if (feature!!.objs.containsKey(Obj.DAYMAR)) {
                        val topmap = feature!!.objs[Obj.DAYMAR]!![0]
                        if (topmap!!.containsKey(Att.TOPSHP)) {
                            symbol(
                                Topmarks.Shapes[(topmap[Att.TOPSHP]!!.value as ArrayList<TopSHP?>)[0]],
                                getScheme(Obj.DAYMAR), Topmarks.BeaconDelta
                            )
                        }
                    }
                }
                if (hasObject(Obj.NOTMRK)) notices()
                addName(
                    15, Font("Arial", BOLD, 40),
                    Delta(Handle.BL, AffineTransform.getTranslateInstance(60.0, -50.0))
                )
                Signals.addSignals()
            }
        }

        private fun buoys() {
            if (Renderer.zoom >= 14
                || (Renderer.zoom >= 12 && (feature!!.type == Obj.BOYLAT || feature!!.type == Obj.BOYCAR))
                || (Renderer.zoom >= 11 && (feature!!.type == Obj.BOYSAW || hasObject(Obj.RTPBCN)))
            ) {
                var shape = getAttEnum(feature!!.type, Att.BOYSHP) as BoySHP
                if (shape === BoySHP.BOY_UNKN) shape = BoySHP.BOY_PILR
                symbol(Buoys.Shapes[shape], getScheme(feature!!.type))
                if (feature!!.objs.containsKey(Obj.TOPMAR)) {
                    val topmap = feature!!.objs[Obj.TOPMAR]!![0]
                    if (topmap!!.containsKey(Att.TOPSHP)) {
                        symbol(
                            Topmarks.Shapes[(topmap[Att.TOPSHP]!!.value as ArrayList<TopSHP?>)[0]],
                            getScheme(Obj.TOPMAR), Topmarks.BuoyDeltas[shape]
                        )
                    }
                } else if (feature!!.objs.containsKey(Obj.DAYMAR)) {
                    val topmap = feature!!.objs[Obj.DAYMAR]!![0]
                    if (topmap!!.containsKey(Att.TOPSHP)) {
                        symbol(
                            Topmarks.Shapes[(topmap[Att.TOPSHP]!!.value as ArrayList<TopSHP?>)[0]],
                            getScheme(Obj.DAYMAR), Topmarks.BuoyDeltas[shape]
                        )
                    }
                }
                addName(
                    15, Font("Arial", BOLD, 40),
                    Delta(Handle.BL, AffineTransform.getTranslateInstance(60.0, -50.0))
                )
                Signals.addSignals()
            }
        }

        private fun bridges() {
            if (Renderer.zoom >= 16) {
                val verclr: Double
                val verccl: Double
                val vercop: Double
                val horclr: Double
                val objTab = feature!!.objs[Obj.BRIDGE]
                val atts = objTab?.let { objTab[0] }
                var vstr = ""
                var hstr = ""
                if (atts != null) {
                    if (atts.containsKey(Att.HORCLR)) {
                        horclr = (atts[Att.HORCLR]!!.value as Double?)!!
                        hstr = horclr.toString()
                    }
                    verclr = if (atts.containsKey(Att.VERCLR)) {
                        (atts[Att.VERCLR]!!.value as Double?)!!
                    } else {
                        if (atts.containsKey(Att.VERCSA)) (atts[Att.VERCSA]!!.value as Double?)!! else 0.0
                    }
                    verccl =
                        if (atts.containsKey(Att.VERCCL)) (atts[Att.VERCCL]!!.value as Double?)!! else 0.0
                    vercop =
                        if (atts.containsKey(Att.VERCOP)) (atts[Att.VERCOP]!!.value as Double?)!! else 0.0
                    if (verclr > 0) {
                        vstr += verclr.toString()
                    } else if (verccl > 0) {
                        vstr += if (vercop == 0.0) {
                            "$verccl/-"
                        } else {
                            "$verccl/$vercop"
                        }
                    }
                    if (hstr.isEmpty() && vstr.isNotEmpty()) {
                        labelText(vstr, mkFont(), black, LabelStyle.VCLR, black, white, Delta(Handle.CC))
                    } else if (hstr.isNotEmpty() && vstr.isNotEmpty()) {
                        labelText(vstr, mkFont(), black, LabelStyle.VCLR, black, white, Delta(Handle.BC))
                        labelText(hstr, mkFont(), black, LabelStyle.HCLR, black, white, Delta(Handle.TC))
                    } else if (hstr.isNotEmpty() && vstr.isEmpty()) {
                        labelText(hstr, mkFont(), black, LabelStyle.HCLR, black, white, Delta(Handle.CC))
                    }
                }
            }
        }

        private fun cables() {
            if (Renderer.zoom >= 16 && feature!!.geom.length < 2) {
                if (feature!!.type === Obj.CBLSUB) {
                    lineSymbols(Areas.Cable, 0.0, null, null, 0, Symbols.Mline)
                } else if (feature!!.type === Obj.CBLOHD) {
                    val objTab = feature!!.objs[Obj.CBLOHD]
                    val atts = objTab?.let { objTab[0] }
                    if (atts != null && atts.containsKey(Att.CATCBL) && atts[Att.CATCBL]!!.value === S57val.CatCBL.CBL_POWR) {
                        lineSymbols(Areas.CableDash, 0.0, Areas.CableDot, Areas.CableFlash, 2, black)
                    } else {
                        lineSymbols(Areas.CableDash, 0.0, Areas.CableDot, null, 2, black)
                    }
                    if (atts != null) {
                        if (atts.containsKey(Att.VERCLR)) {
                            labelText(
                                "$atts[Att.VERCLR]!!.value)", Font("Arial", PLAIN, 50),
                                black, LabelStyle.VCLR, black,
                                Delta(Handle.TC, AffineTransform.getTranslateInstance(0.0, 25.0))
                            )
                        } else if (atts.containsKey(Att.VERCSA)) {
                            labelText(
                                "$atts[Att.VERCSA]!!.value)", Font("Arial", PLAIN, 50),
                                black, LabelStyle.PCLR, black,
                                Delta(Handle.TC, AffineTransform.getTranslateInstance(0.0, 25.0))
                            )
                        }
                    }
                }
            }
        }

        private fun callpoint() {
            if (Renderer.zoom >= 14) {
                var symb = Harbours.CallPoint2
                val trf = getAttEnum(feature!!.type, Att.TRAFIC) as TrfTRF
                if (trf !== TrfTRF.TRF_TWOW) {
                    symb = Harbours.CallPoint1
                }
                var orient: Double?
                if ((getAttVal(feature!!.type, Att.ORIENT) as Double?).also { orient = it } == null) {
                    orient = 0.0
                }
                symbol(
                    symb, Delta(
                        Handle.CC, AffineTransform.getRotateInstance(
                            deg2rad(orient!!)
                        )
                    )
                )
                var chn: String?
                if (getAttStr(feature!!.type, Att.COMCHA).also { chn = it }.isNotEmpty()) {
                    labelText(
                        "Ch.$chn", Font("Arial", PLAIN, 50), black,
                        Delta(Handle.TC, AffineTransform.getTranslateInstance(0.0, 50.0))
                    )
                }
            }
        }

        private fun depths() {
            when (feature!!.type) {
                Obj.SOUNDG -> if (Renderer.zoom >= 14 && hasAttribute(Obj.SOUNDG, Att.VALSOU)) {
                    val depth = getAttVal(Obj.SOUNDG, Att.VALSOU) as Double
                    val dstr = df.format(depth)
                    val tok: Array<String?> = dstr!!.split("[-.]".toRegex()).dropLastWhile { it.isEmpty() }
                        .toTypedArray()
                    var ul = ""
                    var id = tok[0]
                    val dd: String?
                    if (tok[0] == "") {
                        var i = 0
                        while (i < tok[1]!!.length) {
                            ul += "_"
                            i++
                        }
                        id = tok[1]
                        dd = if (tok.size == 3) tok[2] else ""
                    } else {
                        dd = if (tok.size == 2) tok[1] else ""
                    }
                    labelText(
                        ul, mkFont(), black,
                        Delta(Handle.RC, AffineTransform.getTranslateInstance(10.0, 15.0))
                    )
                    labelText(
                        id, mkFont(), black,
                        Delta(Handle.RC, AffineTransform.getTranslateInstance(10.0, 0.0))
                    )
                    labelText(
                        dd, Font("Arial", PLAIN, 20), black,
                        Delta(Handle.LC, AffineTransform.getTranslateInstance(15.0, 10.0))
                    )
                }
                Obj.DEPCNT -> {}
                else -> {}
            }
        }

        private fun distances() {
            if (Renderer.zoom >= 14) {
                if (!testAttribute(Obj.DISMAR, Att.CATDIS, CatDIS.DIS_NONI)) {
                    symbol(Harbours.DistanceI)
                } else {
                    symbol(Harbours.DistanceU)
                }
                if (Renderer.zoom >= 15) {
                    val atts = getAtts(Obj.DISMAR, 0)
                    if (atts != null && atts.containsKey(Att.WTWDIS)) {
                        val dist = atts[Att.WTWDIS]!!.value as Double?
                        var str = ""
                        if (atts.containsKey(Att.HUNITS)) {
                            when (getAttEnum(Obj.DISMAR, Att.HUNITS) as UniHLU) {
                                UniHLU.HLU_METR -> str += "m "
                                UniHLU.HLU_FEET -> str += "ft "
                                UniHLU.HLU_HMTR -> str += "hm "
                                UniHLU.HLU_KMTR -> str += "km "
                                UniHLU.HLU_SMIL -> str += "M "
                                UniHLU.HLU_NMIL -> str += "NM "
                                else -> {}
                            }
                        }
                        str += String.format("%1.0f", dist)
                        labelText(
                            str, Font("Arial", PLAIN, 40), black,
                            Delta(Handle.CC, AffineTransform.getTranslateInstance(0.0, 45.0))
                        )
                    }
                }
            }
        }

        private fun floats() {
            if (Renderer.zoom >= 12 || (Renderer.zoom >= 11
                        && (feature!!.type === Obj.LITVES || feature!!.type === Obj.BOYINB || hasObject(Obj.RTPBCN)))
            ) {
                when (feature!!.type) {
                    Obj.LITVES -> symbol(Buoys.Super, getScheme(feature!!.type))
                    Obj.LITFLT -> symbol(Buoys.Float, getScheme(feature!!.type))
                    Obj.BOYINB -> symbol(Buoys.Super, getScheme(feature!!.type))
                    else -> {}
                }
                if (feature!!.objs.containsKey(Obj.TOPMAR)) {
                    val topmap = feature!!.objs[Obj.TOPMAR]!![0]
                    if (topmap!!.containsKey(Att.TOPSHP)) {
                        symbol(
                            Topmarks.Shapes[(topmap[Att.TOPSHP]!!.value as ArrayList<TopSHP?>?)!![0]],
                            getScheme(Obj.TOPMAR), Topmarks.FloatDelta
                        )
                    }
                } else if (feature!!.objs.containsKey(Obj.DAYMAR)) {
                    val topmap = feature!!.objs[Obj.DAYMAR]!![0]
                    if (topmap!!.containsKey(Att.TOPSHP)) {
                        symbol(
                            Topmarks.Shapes[(topmap[Att.TOPSHP]!!.value as ArrayList<TopSHP?>?)!![0]],
                            getScheme(Obj.DAYMAR), Topmarks.FloatDelta
                        )
                    }
                }
                addName(
                    15, Font("Arial", BOLD, 40),
                    Delta(Handle.BL, AffineTransform.getTranslateInstance(20.0, -50.0))
                )
                Signals.addSignals()
            }
        }

        private fun gauges() {
            if (Renderer.zoom >= 14) {
                symbol(Harbours.TideGauge)
                addName(
                    15, Font("Arial", BOLD, 40),
                    Delta(Handle.BL, AffineTransform.getTranslateInstance(20.0, -50.0))
                )
                Signals.addSignals()
            }
        }

        private fun harbours() {
            val name = name
            when (feature!!.type) {
                Obj.ACHBRT -> {
                    if (Renderer.zoom >= 14) {
                        symbol(Harbours.Anchor, Scheme(Symbols.Msymb))
                        if (Renderer.zoom >= 15) {
                            labelText(
                                name ?: "", mkFont(), Symbols.Msymb,
                                LabelStyle.RRCT, Symbols.Msymb, white, Delta(Handle.BC)
                            )
                        }
                    }
                    if (getAttVal(Obj.ACHBRT, Att.RADIUS) != null) {
                        var radius: Double
                        if ((getAttVal(Obj.ACHBRT, Att.RADIUS) as Double?).also { radius = it!! } != 0.0) {
                            var units = getAttEnum(Obj.ACHBRT, Att.HUNITS) as UniHLU
                            if (units === UniHLU.HLU_UNKN) {
                                units = UniHLU.HLU_METR
                            }
                            Renderer.lineCircle(
                                LineStyle(Symbols.Mline, 4f, floatArrayOf(10f, 10f), null),
                                radius, units)
                        }
                    }
                }
                Obj.ACHARE -> if (Renderer.zoom >= 12) {
                    if (feature!!.geom.prim !== Pflag.AREA) {
                        symbol(Harbours.Anchorage, Scheme(black))
                    } else {
                        symbol(Harbours.Anchorage, Scheme(Symbols.Mline))
                        lineSymbols(Areas.Restricted, 1.0, Areas.LineAnchor, null, 10, Symbols.Mline)
                    }
                    addName(
                        15, Font("Arial", BOLD, 60), Symbols.Mline,
                        Delta(Handle.LC, AffineTransform.getTranslateInstance(70.0, 0.0))
                    )
                    val sts = getAttList(Obj.ACHARE, Att.STATUS) as ArrayList<S57val.StsSTS?>
                    if (Renderer.zoom >= 15 && sts.contains(S57val.StsSTS.STS_RESV)) {
                        labelText(
                            "Reserved", Font("Arial", PLAIN, 50), Symbols.Mline,
                            Delta(Handle.TC, AffineTransform.getTranslateInstance(0.0, 60.0))
                        )
                    }
                    val cats = getAttList(Obj.ACHARE, Att.CATACH) as ArrayList<CatACH?>
                    var dy = (cats.size - 1) * -30
                    for (cat in cats) {
                        when (cat) {
                            CatACH.ACH_DEEP -> {
                                labelText(
                                    "DW", Font("Arial", BOLD, 50), Symbols.Msymb,
                                    Delta(
                                        Handle.RC,
                                        AffineTransform.getTranslateInstance(-60.0, dy.toDouble())
                                    )
                                )
                                dy += 60
                            }
                            CatACH.ACH_TANK -> {
                                labelText(
                                    "Tanker", Font("Arial", BOLD, 50), Symbols.Msymb,
                                    Delta(
                                        Handle.RC,
                                        AffineTransform.getTranslateInstance(-60.0, dy.toDouble())
                                    )
                                )
                                dy += 60
                            }
                            CatACH.ACH_H24P -> {
                                labelText(
                                    "24h", Font("Arial", BOLD, 50), Symbols.Msymb,
                                    Delta(
                                        Handle.RC,
                                        AffineTransform.getTranslateInstance(-60.0, dy.toDouble())
                                    )
                                )
                                dy += 60
                            }
                            CatACH.ACH_EXPL -> {
                                symbol(
                                    Harbours.Explosives, Scheme(Symbols.Msymb),
                                    Delta(
                                        Handle.RC,
                                        AffineTransform.getTranslateInstance(-60.0, dy.toDouble())
                                    )
                                )
                                dy += 60
                            }
                            CatACH.ACH_QUAR -> {
                                symbol(
                                    Harbours.Hospital, Scheme(Symbols.Msymb),
                                    Delta(
                                        Handle.RC,
                                        AffineTransform.getTranslateInstance(-60.0, dy.toDouble())
                                    )
                                )
                                dy += 60
                            }
                            CatACH.ACH_SEAP -> {
                                symbol(
                                    Areas.Seaplane, Scheme(Symbols.Msymb),
                                    Delta(
                                        Handle.RC,
                                        AffineTransform.getTranslateInstance(-60.0, dy.toDouble())
                                    )
                                )
                                dy += 60
                            }
                            else -> {}
                        }
                    }
                }
                Obj.BERTHS -> if (Renderer.zoom >= 14) {
                    lineVector(LineStyle(Symbols.Mline, 6f, floatArrayOf(20f, 20f)))
                    labelText(
                        name ?: " ", Font("Arial", PLAIN, 40), Symbols.Msymb,
                        LabelStyle.RRCT, Symbols.Mline, white
                    )
                }
                Obj.BUISGL -> if (Renderer.zoom >= 16) {
                    val symbols = ArrayList<Symbols.Symbol>()
                    val fncs = getAttList(Obj.BUISGL, Att.FUNCTN) as ArrayList<FncFNC?>
                    for (fnc in fncs) {
                        Landmarks.Funcs[fnc]?.let { symbols.add(it) }
                    }
                    if (feature!!.objs.containsKey(Obj.SMCFAC)) {
                        val scfs = getAttList(Obj.SMCFAC, Att.CATSCF) as ArrayList<CatSCF?>
                        for (scf in scfs) {
                            symbols.add(Facilities.Cats[scf]!!)
                        }
                    }
                    Renderer.cluster(symbols)
                }
                Obj.HRBFAC -> if (Renderer.zoom >= 12) {
                    val cathaf = getAttList(Obj.HRBFAC, Att.CATHAF) as ArrayList<CatHAF?>
                    if (cathaf.size == 1) {
                        when (cathaf[0]) {
                            CatHAF.HAF_MRNA -> symbol(Harbours.Marina)
                            CatHAF.HAF_MANF -> symbol(Harbours.MarinaNF)
                            CatHAF.HAF_FISH -> symbol(Harbours.Fishing)
                            else -> symbol(Harbours.Harbour)
                        }
                    } else {
                        symbol(Harbours.Harbour)
                    }
                }
                else -> {}
            }
        }

        private fun mkFont() = Font("Arial", PLAIN, 30)

        private fun highways() {
            when (feature!!.type) {
                Obj.ROADWY -> {
                    val cat = getAttList(Obj.ROADWY, Att.CATROD) as ArrayList<CatROD?>
                    if (cat.size > 0) {
                        when (cat[0]) {
                            CatROD.ROD_MWAY -> lineVector(LineStyle(black, 20f))
                            CatROD.ROD_MAJR -> lineVector(LineStyle(black, 15f))
                            CatROD.ROD_MINR -> lineVector(LineStyle(black, 10f))
                            else -> lineVector(LineStyle(black, 5f))
                        }
                    } else {
                        lineVector(LineStyle(black, 5f))
                    }
                }
                Obj.RAILWY -> {
                    lineVector(LineStyle(Color.gray, 10f))
                    lineVector(LineStyle(black, 10f, floatArrayOf(30f, 30f)))
                }
                else -> {}
            }
        }

        private fun landmarks() {
            if (!hasAttribute(Obj.LNDMRK, Att.CATLMK)
                && (!hasAttribute(Obj.LNDMRK, Att.FUNCTN) || testAttribute(
                    Obj.LNDMRK,
                    Att.FUNCTN,
                    FncFNC.FNC_LGHT
                ))
                && hasObject(Obj.LIGHTS)
            ) lights() else if (Renderer.zoom >= 12) {
                when (feature!!.type) {
                    Obj.LNDMRK -> {
                        val cats = getAttList(feature!!.type, Att.CATLMK) as ArrayList<CatLMK?>
                        var catSym = Landmarks.Shapes[cats[0]]
                        val fncs = getAttList(feature!!.type, Att.FUNCTN) as ArrayList<FncFNC?>
                        var fncSym = Landmarks.Funcs[fncs[0]]
                        if (fncs[0] === FncFNC.FNC_CHCH && cats[0] === CatLMK.LMK_TOWR) catSym =
                            Landmarks.ChurchTower
                        if (cats[0] === CatLMK.LMK_RADR) fncSym = Landmarks.RadioTV
                        symbol(catSym)
                        symbol(fncSym)
                    }
                    Obj.SILTNK -> if (testAttribute(
                            feature!!.type,
                            Att.CATSIL,
                            S57val.CatSIL.SIL_WTRT
                        )
                    ) symbol(
                        Landmarks.WaterTower
                    )
                    else -> {}
                }
                if (Renderer.zoom >= 15) addName(
                    15, Font("Arial", BOLD, 40),
                    Delta(Handle.BL, AffineTransform.getTranslateInstance(60.0, -50.0))
                )
                Signals.addSignals()
            }
        }

        private fun points() {
            var ok = false
            when (feature!!.type) {
                Obj.FOGSIG -> if (Renderer.zoom >= 12) {
                    if (feature!!.objs.containsKey(Obj.LIGHTS)) lights() else symbol(Harbours.Post)
                    ok = true
                }
                else -> if (Renderer.zoom >= 14) {
                    if (feature!!.objs.containsKey(Obj.LIGHTS)) lights() else symbol(Harbours.Post)
                    ok = true
                }
            }
            if (ok) {
                if (feature!!.objs.containsKey(Obj.TOPMAR)) {
                    val topmap = feature!!.objs[Obj.TOPMAR]!![0]
                    if (topmap!!.containsKey(Att.TOPSHP)) {
                        symbol(
                            Topmarks.Shapes[(topmap[Att.TOPSHP]!!.value as ArrayList<TopSHP?>?)!![0]],
                            getScheme(Obj.TOPMAR), null
                        )
                    }
                } else if (feature!!.objs.containsKey(Obj.DAYMAR)) {
                    val topmap = feature!!.objs[Obj.DAYMAR]!![0]
                    if (topmap!!.containsKey(Att.TOPSHP)) {
                        symbol(
                            Topmarks.Shapes[(topmap[Att.TOPSHP]!!.value as ArrayList<TopSHP?>?)!![0]],
                            getScheme(Obj.DAYMAR), null
                        )
                    }
                }
                Signals.addSignals()
            }
        }

        private fun lights() {
            var ok = false
            when (feature!!.type) {
                Obj.LITMAJ, Obj.LNDMRK -> if (Renderer.zoom >= 12) {
                    symbol(Beacons.LightMajor)
                    ok = true
                }
                Obj.LITMIN, Obj.LIGHTS, Obj.PILPNT -> if (Renderer.zoom >= 14) {
                    symbol(Beacons.LightMinor)
                    ok = true
                }
                else -> {}
            }
            if (ok) {
                if (feature!!.objs.containsKey(Obj.TOPMAR)) {
                    val topmap = feature!!.objs[Obj.TOPMAR]!![0]
                    if (topmap!!.containsKey(Att.TOPSHP)) {
                        symbol(
                            Topmarks.Shapes[(topmap[Att.TOPSHP]!!.value as ArrayList<TopSHP?>?)!![0]],
                            getScheme(Obj.TOPMAR), Topmarks.LightDelta
                        )
                    }
                } else if (feature!!.objs.containsKey(Obj.DAYMAR)) {
                    val topmap = feature!!.objs[Obj.DAYMAR]!![0]
                    if (topmap!!.containsKey(Att.TOPSHP)) {
                        symbol(
                            Topmarks.Shapes[(topmap[Att.TOPSHP]!!.value as ArrayList<TopSHP?>?)!![0]],
                            getScheme(Obj.DAYMAR), Topmarks.LightDelta
                        )
                    }
                }
                Signals.addSignals()
            }
        }

        private fun marinas() {
            if (Renderer.zoom >= 16) {
                val symbols = ArrayList<Symbols.Symbol>()
                val scfs = getAttList(Obj.SMCFAC, Att.CATSCF) as ArrayList<CatSCF?>
                for (scf in scfs) {
                    symbols.add(Facilities.Cats[scf]!!)
                }
                Renderer.cluster(symbols)
            }
        }

        private fun moorings() {
            if (Renderer.zoom >= 14) {
                when (getAttEnum(feature!!.type, Att.CATMOR) as S57val.CatMOR) {
                    S57val.CatMOR.MOR_DLPN -> symbol(Harbours.Dolphin)
                    S57val.CatMOR.MOR_DDPN -> symbol(Harbours.DeviationDolphin)
                    S57val.CatMOR.MOR_BLRD, S57val.CatMOR.MOR_POST -> symbol(Harbours.Bollard)
                    S57val.CatMOR.MOR_BUOY -> {
                        var shape = getAttEnum(feature!!.type, Att.BOYSHP) as BoySHP
                        if (shape === BoySHP.BOY_UNKN) {
                            shape = BoySHP.BOY_SPHR
                        }
                        symbol(Buoys.Shapes[shape], getScheme(feature!!.type))
                        symbol(Topmarks.TopMooring, Topmarks.BuoyDeltas[shape])
                    }
                    else -> {}
                }
                Signals.addSignals()
            }
        }

        private fun notices() {
            if (Renderer.zoom >= 14) {
                val dx = 0.0
                val dy = when (feature!!.type) {
                    Obj.BCNCAR, Obj.BCNISD, Obj.BCNLAT, Obj.BCNSAW, Obj.BCNSPP -> if (testAttribute(
                            Obj.TOPMAR, Att.TOPSHP, TopSHP.TOP_BORD
                        )
                        || testAttribute(Obj.DAYMAR, Att.TOPSHP, TopSHP.TOP_BORD)
                    ) {
                        -100.0
                    } else {
                        -45.0
                    }
                    Obj.NOTMRK -> 0.0
                    else -> return
                }
                var sys: MarSYS? = MarSYS.SYS_CEVN
                var bnk: BnkWTW? = BnkWTW.BWW_UNKN
                var att = feature!!.atts[Att.MARSYS]
                if (att != null) sys = att.value as MarSYS?
                att = feature!!.atts[Att.BNKWTW]
                if (att != null) bnk = att.value as BnkWTW?
                val objs = feature!!.objs[Obj.NOTMRK]
                val n = objs!!.size
                if (n > 5) {
                    symbol(
                        Notices.Notice,
                        Delta(Handle.CC, AffineTransform.getTranslateInstance(dx, dy))
                    )
                } else {
                    for ((i, atts) in objs.values.withIndex()) {
                        if (atts[Att.MARSYS] != null) sys = (atts[Att.MARSYS]!!.value as ArrayList<MarSYS>?)!![0]
                        if (atts[Att.BNKWTW] != null) bnk = (atts[Att.BNKWTW]!!.value as ArrayList<BnkWTW>?)!![0]

                        var cat: CatNMK? = CatNMK.NMK_UNKN
                        if (atts[Att.CATNMK] != null) cat = (atts[Att.CATNMK]!!.value as ArrayList<CatNMK>?)!![0]
                        val sym = getNotice(cat!!, sys, bnk)
                        val sch = getScheme(sys, bnk)
                        var add: ArrayList<AddMRK>? = ArrayList()
                        if (atts[Att.ADDMRK] != null) add = atts[Att.ADDMRK]!!.value as ArrayList<AddMRK>?
                        var h: Handle? = Handle.CC
                        var ax = 0.0
                        var ay = 0.0
                        when (i) {
                            0 -> if (n != 1) h = null
                            1 -> if (n <= 3) {
                                h = Handle.RC
                                ax = -30.0
                                ay = dy
                            } else {
                                h = Handle.BR
                            }
                            2 -> h = if (n <= 3) Handle.LC else Handle.BL
                            3 -> h = if (n == 4) Handle.TC else Handle.TR
                            4 -> h = Handle.TL
                        }
                        if (h != null) {
                            symbol(sym, sch, Delta(h, AffineTransform.getTranslateInstance(dx, dy)))
                            if (add!!.isNotEmpty()) symbol(
                                Notices.NoticeBoard,
                                Delta(Handle.BC, AffineTransform.getTranslateInstance(ax, ay - 30))
                            )
                        }
                    }
                }
            }
        }

        private fun obstructions() {
            if (Renderer.zoom >= 12 && feature!!.type === Obj.OBSTRN) {
                if (getAttEnum(feature!!.type, Att.CATOBS) === S57val.CatOBS.OBS_BOOM) {
                    lineVector(LineStyle(black, 5f, floatArrayOf(20f, 20f), null))
                    if (Renderer.zoom >= 15) {
                        lineText("Boom", Font("Arial", PLAIN, 80), black, -20.0)
                    }
                }
            }
            if (Renderer.zoom >= 14 && feature!!.type === Obj.UWTROC) {
                when (getAttEnum(feature!!.type, Att.WATLEV) as S57val.WatLEV) {
                    S57val.WatLEV.LEV_CVRS -> symbol(Areas.RockC)
                    S57val.WatLEV.LEV_AWSH -> symbol(Areas.RockA)
                    else -> symbol(Areas.Rock)
                }
            } else {
                symbol(Areas.Rock)
            }
        }

        private fun pipelines() {
            if (Renderer.zoom >= 16 && feature!!.geom.length < 2) {
                if (feature!!.type === Obj.PIPSOL) {
                    lineSymbols(Areas.Pipeline, 1.0, null, null, 0, Symbols.Mline)
                } else if (feature!!.type === Obj.PIPOHD) {
                    lineVector(LineStyle(black, 8f))
                    val atts = feature!!.atts
                    val verclr: Double
                    if (atts != null) {
                        verclr = if (atts.containsKey(Att.VERCLR)) {
                            (atts[Att.VERCLR]!!.value as Double?)!!
                        } else {
                            if (atts.containsKey(Att.VERCSA)) (atts[Att.VERCSA]!!.value as Double?)!! else 0.0
                        }
                        if (verclr > 0) {
                            labelText(
                                verclr.toString(), Font("Arial", PLAIN, 50), black,
                                LabelStyle.VCLR, black,
                                Delta(Handle.TC, AffineTransform.getTranslateInstance(0.0, 25.0))
                            )
                        }
                    }
                }
            }
        }

        private fun platforms() {
            val cats = getAttList(Obj.OFSPLF, Att.CATOFP) as ArrayList<S57val.CatOFP?>
            if (cats[0] === S57val.CatOFP.OFP_FPSO) symbol(Buoys.Storage) else symbol(Landmarks.Platform)
            addName(
                15, Font("Arial", BOLD, 40),
                Delta(Handle.BL, AffineTransform.getTranslateInstance(20.0, -50.0))
            )
            Signals.addSignals()
        }

        private fun ports() {
            if (Renderer.zoom >= 14) {
                if (feature!!.type === Obj.CRANES) {
                    if (getAttEnum(
                            feature!!.type,
                            Att.CATCRN
                        ) as S57val.CatCRN === S57val.CatCRN.CRN_CONT
                    ) symbol(
                        Harbours.ContainerCrane
                    ) else symbol(Harbours.PortCrane)
                } else if (feature!!.type === Obj.HULKES) {
                    lineVector(LineStyle(black, 4f, null, Color(0xffe000)))
                    addName(15, Font("Arial", BOLD, 40))
                }
            }
        }

        private fun separation() {
            when (feature!!.type) {
                Obj.TSEZNE, Obj.TSSCRS, Obj.TSSRON -> {
                    if (Renderer.zoom <= 15) lineVector(LineStyle(Symbols.Mtss)) else lineVector(
                        LineStyle(Symbols.Mtss, 20f, null, null)
                    )
                    addName(10, Font("Arial", BOLD, 150), Symbols.Mline)
                }
                Obj.TSELNE -> lineVector(LineStyle(Symbols.Mtss, 20f, null, null))
                Obj.TSSLPT -> lineSymbols(Areas.LaneArrow, 0.5, null, null, 0, Symbols.Mtss)
                Obj.TSSBND -> lineVector(
                    LineStyle(
                        Symbols.Mtss,
                        20f,
                        floatArrayOf(40f, 40f),
                        null
                    )
                )
                Obj.ISTZNE -> lineSymbols(Areas.Restricted, 1.0, null, null, 0, Symbols.Mtss)
                else -> {}
            }
        }

        private fun shoreline() {
            val cat = getAttEnum(feature!!.type, Att.CATSLC) as S57val.CatSLC
            if (Renderer.context.ruleset() === ChartContext.RuleSet.ALL || Renderer.context.ruleset() === ChartContext.RuleSet.BASE) {
                if (cat !== S57val.CatSLC.SLC_SWAY && cat !== S57val.CatSLC.SLC_TWAL) {
                    if (Renderer.zoom >= 12) {
                        lineVector(LineStyle(black, 10f, Symbols.Yland))
                    } else {
                        lineVector(LineStyle(Symbols.Yland))
                    }
                }
            }
            if (Renderer.context.ruleset() === ChartContext.RuleSet.ALL || Renderer.context.ruleset() === ChartContext.RuleSet.SEAMARK) {
                if (Renderer.zoom >= 12) {
                    when (cat) {
                        S57val.CatSLC.SLC_TWAL -> {
                            val lev = getAttEnum(feature!!.type, Att.WATLEV) as S57val.WatLEV
                            if (lev === S57val.WatLEV.LEV_CVRS) {
                                lineVector(LineStyle(black, 10f, floatArrayOf(40f, 40f), null))
                                if (Renderer.zoom >= 15) lineText(
                                    "(covers)",
                                    Font("Arial", PLAIN, 60),
                                    black,
                                    80.0
                                )
                            } else {
                                lineVector(LineStyle(black, 10f, null, null))
                            }
                            if (Renderer.zoom >= 15) lineText(
                                "Training Wall",
                                Font("Arial", PLAIN, 60),
                                black,
                                -30.0
                            )
                        }
                        S57val.CatSLC.SLC_SWAY -> {
                            lineVector(LineStyle(black, 2f, null, Color(0xffe000)))
                            if (Renderer.zoom >= 16 && feature!!.objs.containsKey(Obj.SMCFAC)) {
                                val symbols = ArrayList<Symbols.Symbol>()
                                val scfs = getAttList(Obj.SMCFAC, Att.CATSCF) as ArrayList<CatSCF?>
                                for (scf in scfs) {
                                    symbols.add(Facilities.Cats[scf]!!)
                                }
                                Renderer.cluster(symbols)
                            }
                        }
                        else -> {}
                    }
                }
            }
        }

        private fun stations() {
            if (Renderer.zoom >= 14) {
                var str = ""
                when (feature!!.type) {
                    Obj.SISTAT -> {
                        symbol(Harbours.SignalStation)
                        str = "SS"
                        val tcats = getAttList(Obj.SISTAT, Att.CATSIT) as ArrayList<S57val.CatSIT?>
                        when (tcats[0]) {
                            S57val.CatSIT.SIT_IPT -> str += "(INT)"
                            S57val.CatSIT.SIT_PRTE -> str += "(Traffic)"
                            S57val.CatSIT.SIT_PRTC -> str += "(Port Control)"
                            S57val.CatSIT.SIT_LOCK -> str += "(Lock)"
                            S57val.CatSIT.SIT_BRDG -> str += "(Bridge)"
                            else -> {}
                        }
                    }
                    Obj.SISTAW -> {
                        symbol(Harbours.SignalStation)
                        str = "SS"
                        str = "SS"
                        val wcats = getAttList(Obj.SISTAW, Att.CATSIW) as ArrayList<CatSIW?>
                        when (wcats[0]) {
                            CatSIW.SIW_STRM -> str += "(Storm)"
                            CatSIW.SIW_WTHR -> str += "(Weather)"
                            CatSIW.SIW_ICE -> str += "(Ice)"
                            CatSIW.SIW_TIDG -> str = "Tide gauge"
                            CatSIW.SIW_TIDS -> str = "Tide scale"
                            CatSIW.SIW_TIDE -> str += "(Tide)"
                            CatSIW.SIW_TSTR -> str += "(Stream)"
                            CatSIW.SIW_DNGR -> str += "(Danger)"
                            CatSIW.SIW_MILY -> str += "(Firing)"
                            CatSIW.SIW_TIME -> str += "(Time)"
                            else -> {}
                        }
                    }
                    Obj.RDOSTA, Obj.RTPBCN -> {
                        symbol(Harbours.SignalStation)
                        symbol(Beacons.RadarStation)
                    }
                    Obj.RADRFL -> symbol(Topmarks.RadarReflector)
                    Obj.RADSTA -> {
                        symbol(Harbours.SignalStation)
                        symbol(Beacons.RadarStation)
                        labelText(
                            "Ra", Font("Arial", PLAIN, 40), Symbols.Msymb,
                            Delta(Handle.TR, AffineTransform.getTranslateInstance(-30.0, -70.0))
                        )
                    }
                    Obj.PILBOP -> {
                        symbol(Harbours.Pilot)
                        addName(
                            15, Font("Arial", BOLD, 40), Symbols.Msymb,
                            Delta(Handle.LC, AffineTransform.getTranslateInstance(70.0, -40.0))
                        )
                        val cat = getAttEnum(feature!!.type, Att.CATPIL) as S57val.CatPIL
                        if (cat === S57val.CatPIL.PIL_HELI) {
                            labelText(
                                "H", Font("Arial", PLAIN, 40), Symbols.Msymb,
                                Delta(Handle.LC, AffineTransform.getTranslateInstance(70.0, 0.0))
                            )
                        }
                    }
                    Obj.CGUSTA -> {
                        symbol(Harbours.SignalStation)
                        str = "CG"
                        if (feature!!.objs.containsKey(Obj.RSCSTA)) symbol(
                            Harbours.Rescue,
                            Delta(Handle.CC, AffineTransform.getTranslateInstance(130.0, 0.0))
                        )
                    }
                    Obj.RSCSTA -> symbol(Harbours.Rescue)
                    else -> {}
                }
                if (Renderer.zoom >= 15 && str.isNotEmpty()) {
                    labelText(
                        str, Font("Arial", PLAIN, 40), black,
                        Delta(Handle.LC, AffineTransform.getTranslateInstance(40.0, 0.0))
                    )
                }
                Signals.addSignals()
            }
        }

        private fun transits() {
            if (Renderer.zoom >= 14) {
                if (feature!!.type === Obj.RECTRC) lineVector(
                    LineStyle(
                        black,
                        10f,
                        null,
                        null
                    )
                ) else if (feature!!.type === Obj.NAVLNE) lineVector(
                    LineStyle(black, 10f, floatArrayOf(25f, 25f), null)
                )
            }
            if (Renderer.zoom >= 15) {
                var str = ""
                val name = name
                if (name != null) str += "$name "
                var ort: Double?
                if ((getAttVal(feature!!.type, Att.ORIENT) as Double?).also { ort = it } != null) {
                    str += df.format(ort) + "º"
                    if (str.isNotEmpty()) lineText(str, Font("Arial", PLAIN, 80), black, -20.0)
                }
            }
        }

        private fun waterways() {
            lineVector(
                LineStyle(
                    Symbols.Bwater,
                    20f,
                    if (feature!!.geom.prim === Pflag.AREA) Symbols.Bwater else null
                )
            )
        }

        private fun wrecks() {
            if (Renderer.zoom >= 14) {
                when (getAttEnum(feature!!.type, Att.CATWRK) as CatWRK) {
                    CatWRK.WRK_DNGR, CatWRK.WRK_MSTS -> symbol(Areas.WreckD)
                    CatWRK.WRK_HULS -> symbol(Areas.WreckS)
                    else -> symbol(Areas.WreckND)
                }
            }
        }
    }
}