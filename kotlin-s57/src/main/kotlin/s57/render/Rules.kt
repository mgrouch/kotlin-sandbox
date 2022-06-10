// License: GPL. For details, see LICENSE file.
package s57.render

import s57.S57att.Att
import s57.S57map
import s57.S57obj.Obj
import s57.S57val
import s57.S57val.unknAtt
import s57.render.Renderer.labelText
import s57.symbols.*
import s57.symbols.Notices.getNotice
import s57.symbols.Notices.getScheme

import java.awt.Color
import java.awt.Font
import java.awt.geom.AffineTransform
import java.text.DecimalFormat

/**
 * @author Malcolm Herring
 */
open class Rules {
    companion object {
        val df = DecimalFormat("#.#")
        val bodyColours = mapOf(
            S57val.ColCOL.COL_UNK to Color(0, true),
            S57val.ColCOL.COL_WHT to Color(0xffffff),
            S57val.ColCOL.COL_BLK to Color(0x000000),
            S57val.ColCOL.COL_RED to Color(0xd40000),
            S57val.ColCOL.COL_GRN to Color(0x00d400),
            S57val.ColCOL.COL_BLU to Color.blue,
            S57val.ColCOL.COL_YEL to Color(0xffd400),
            S57val.ColCOL.COL_GRY to Color.gray,
            S57val.ColCOL.COL_BRN to Color(0x8b4513),
            S57val.ColCOL.COL_AMB to Color(0xfbf00f),
            S57val.ColCOL.COL_VIO to Color(0xee82ee),
            S57val.ColCOL.COL_ORG to Color.orange,
            S57val.ColCOL.COL_MAG to Color(0xf000f0),
            S57val.ColCOL.COL_PNK to Color.pink,
        )

        val pattMap = mapOf(
            S57val.ColPAT.PAT_UNKN to Symbols.Patt.Z,
            S57val.ColPAT.PAT_HORI to Symbols.Patt.H,
            S57val.ColPAT.PAT_VERT to Symbols.Patt.V,
            S57val.ColPAT.PAT_DIAG to Symbols.Patt.D,
            S57val.ColPAT.PAT_BRDR to Symbols.Patt.B,
            S57val.ColPAT.PAT_SQUR to Symbols.Patt.S,
            S57val.ColPAT.PAT_CROS to Symbols.Patt.C,
            S57val.ColPAT.PAT_SALT to Symbols.Patt.X,
            S57val.ColPAT.PAT_STRP to Symbols.Patt.H,
        )

        val name: String?
            get() {
                var name = feature!!.atts!![Att.OBJNAM]
                if (name == null) {
                    if (feature!!.objs != null && !feature!!.objs!!.isEmpty()) {
                        val atts = feature!!.objs!![feature!!.type]!![0]
                        if (atts != null) {
                            name = atts[Att.OBJNAM]
                        }
                    }
                }
                return if (name != null) name.value as String? else null
            }

        fun addName(z: Int, font: Font, delta: Symbols.Delta?) {
            addName(z, font, Color.black, delta)
        }

        fun addName(
            z: Int, font: Font, colour: Color? = Color.black, delta: Symbols.Delta? = Symbols.Delta(
                Symbols.Handle.CC, AffineTransform()
            )
        ) {
            if (Renderer.zoom >= z) {
                val name = name
                if (name != null) {
                    Renderer.labelText(name, font, colour, delta)
                }
            }
        }

        fun getAtts(obj: Obj, idx: Int): S57map.AttMap? {
            val objs = feature!!.objs!![obj]
            return objs?.get(idx)
        }

        fun getAttVal(obj: Obj?, att: Att): Any? {
            val atts: S57map.AttMap
            var objs: HashMap<Int?, S57map.AttMap?>
            var item: S57val.AttVal<*>
            if (feature!!.objs!![obj].also { objs = it!! } != null) atts = objs[0] else return null
            return if (atts[att].also { item = it!! } == null) null else item.value
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
            var list = getAttVal(obj, att) as ArrayList<Enum<*>?>?
            if (list != null) {
                return list
            }
            list = ArrayList()
            list.add(unknAtt(att))
            return list
        }

        fun getScheme(obj: Obj?): Symbols.Scheme {
            val colours = ArrayList<Color?>()
            for (col in getAttList(obj, Att.COLOUR) as ArrayList<S57val.ColCOL>) {
                colours.add(bodyColours[col])
            }
            val patterns = ArrayList<Symbols.Patt?>()
            for (pat in getAttList(obj, Att.COLPAT) as ArrayList<S57val.ColPAT>) {
                patterns.add(pattMap[pat])
            }
            return Symbols.Scheme(patterns, colours)
        }

        fun hasAttribute(obj: Obj, att: Att): Boolean {
            var atts: S57map.AttMap
            if (getAtts(obj, 0).also { atts = it!! } != null) {
                val item = atts[att]
                return item != null
            }
            return false
        }

        fun testAttribute(obj: Obj?, att: Att, value: Any): Boolean {
            var atts: S57map.AttMap
            if (getAtts(obj!!, 0).also { atts = it!! } != null) {
                val item = atts[att]
                if (item != null) {
                    when (item.conv) {
                        S57val.Conv.S, S57val.Conv.A -> return item.value as String == value
                        S57val.Conv.E, S57val.Conv.L -> return (item.value as ArrayList<*>).contains(value)
                        S57val.Conv.F, S57val.Conv.I -> return item.value === value
                    }
                }
            }
            return false
        }

        fun hasObject(obj: Obj): Boolean {
            return feature!!.objs!!.containsKey(obj)
        }

        var feature: S57map.Feature? = null
        var objects: ArrayList<S57map.Feature>? = null
        fun testObject(obj: Obj): Boolean {
            return Renderer.map!!.features!![obj].also { objects = it } != null
        }

        fun testFeature(f: S57map.Feature): Boolean {
            return f.also { feature = it }.reln === S57map.Rflag.MASTER
        }

        fun rules(): Boolean {
            try {
                if (Renderer.context!!.ruleset() === ChartContext.RuleSet.ALL || Renderer.context!!.ruleset() === ChartContext.RuleSet.BASE) {
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
                if (Renderer.context!!.ruleset() === ChartContext.RuleSet.ALL) {
                    if (testObject(Obj.SOUNDG)) for (f in objects!!) if (testFeature(f)) depths()
                    if (testObject(Obj.DEPCNT)) for (f in objects!!) if (testFeature(f)) depths()
                }
                if (testObject(Obj.SLCONS)) for (f in objects!!) if (testFeature(f)) shoreline()
                if (Renderer.context!!.ruleset() === ChartContext.RuleSet.ALL || Renderer.context!!.ruleset() === ChartContext.RuleSet.SEAMARK) {
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
            } catch (e: ConcurrentModificationException) {
                return false
            } catch (e: Exception) {
                return true
            }
            return true
        }

        private fun areas() {
            val name = name
            when (feature!!.type) {
                Obj.BUAARE -> Renderer.lineVector(Symbols.LineStyle(Color(0x20000000, true)))
                Obj.COALNE -> if (Renderer.zoom >= 12) Renderer.lineVector(Symbols.LineStyle(Color.black, 10f))
                Obj.DEPARE -> {
                    var depmax = 0.0
                    if ((getAttVal(Obj.DEPARE, Att.DRVAL2) as Double?).also {
                            depmax = it!!
                        } != null && depmax <= 0.0) {
                        Renderer.lineVector(Symbols.LineStyle(Symbols.Gdries))
                    }
                }
                Obj.LAKARE -> if (Renderer.zoom >= 12 || feature!!.geom!!.area > 10.0) Renderer.lineVector(
                    Symbols.LineStyle(Symbols.Bwater)
                )
                Obj.DRGARE -> {
                    if (Renderer.zoom < 16) Renderer.lineVector(
                        Symbols.LineStyle(
                            Color.black,
                            8f,
                            floatArrayOf(25f, 25f),
                            Color(0x40ffffff, true)
                        )
                    ) else Renderer.lineVector(
                        Symbols.LineStyle(Color.black, 8f, floatArrayOf(25f, 25f))
                    )
                    addName(12, Font("Arial", Font.PLAIN, 100), Symbols.Delta(Symbols.Handle.CC, AffineTransform()))
                }
                Obj.FAIRWY -> if (feature!!.geom!!.area > 2.0) {
                    if (Renderer.zoom < 16) Renderer.lineVector(
                        Symbols.LineStyle(Symbols.Mline, 8f, floatArrayOf(50f, 50f), Color(0x40ffffff, true))
                    ) else Renderer.lineVector(
                        Symbols.LineStyle(Symbols.Mline, 8f, floatArrayOf(50f, 50f))
                    )
                } else {
                    if (Renderer.zoom >= 14) Renderer.lineVector(Symbols.LineStyle(Color(0x40ffffff, true)))
                }
                Obj.LKBSPT, Obj.LOKBSN, Obj.HRBBSN -> if (Renderer.zoom >= 12) {
                    Renderer.lineVector(Symbols.LineStyle(Color.black, 10f, Symbols.Bwater))
                } else {
                    Renderer.lineVector(Symbols.LineStyle(Symbols.Bwater))
                }
                Obj.HRBFAC -> if (feature!!.objs!![Obj.HRBBSN] != null) {
                    if (Renderer.zoom >= 12) {
                        Renderer.lineVector(Symbols.LineStyle(Color.black, 10f, Symbols.Bwater))
                    } else {
                        Renderer.lineVector(Symbols.LineStyle(Symbols.Bwater))
                    }
                }
                Obj.LNDARE -> Renderer.lineVector(Symbols.LineStyle(Symbols.Yland))
                Obj.MARCUL -> if (Renderer.zoom >= 12) {
                    if (Renderer.zoom >= 14) {
                        Renderer.symbol(Areas.MarineFarm)
                    }
                    if (((feature!!.geom!!.area > 0.2 || feature!!.geom!!.area > 0.05 && Renderer.zoom) >= 14 || feature!!.geom!!.area > 0.005 && Renderer.zoom) >= 16) {
                        Renderer.lineVector(Symbols.LineStyle(Color.black, 4f, floatArrayOf(10f, 10f)))
                    }
                }
                Obj.OSPARE -> if (testAttribute(feature!!.type, Att.CATPRA, S57val.CatPRA.PRA_WFRM)) {
                    Renderer.symbol(Areas.WindFarm)
                    Renderer.lineVector(Symbols.LineStyle(Color.black, 20f, floatArrayOf(40f, 40f)))
                    addName(
                        15, Font("Arial", Font.BOLD, 80),
                        Symbols.Delta(Symbols.Handle.TC, AffineTransform.getTranslateInstance(0.0, 10.0))
                    )
                }
                Obj.RESARE, Obj.MIPARE -> if (Renderer.zoom >= 12) {
                    Renderer.lineSymbols(Areas.Restricted, 1.0, null, null, 0, Symbols.Mline)
                    if (testAttribute(feature!!.type, Att.CATREA, S57val.CatREA.REA_NWAK)) {
                        Renderer.symbol(Areas.NoWake)
                    }
                }
                Obj.PRCARE -> if (Renderer.zoom >= 12) {
                    Renderer.lineVector(Symbols.LineStyle(Symbols.Mline, 10f, floatArrayOf(40f, 40f)))
                }
                Obj.SEAARE -> when (getAttEnum(feature!!.type, Att.CATSEA) as S57val.CatSEA) {
                    S57val.CatSEA.SEA_RECH -> if (Renderer.zoom >= 10 && name != null) if (feature!!.geom!!.prim === S57map.Pflag.LINE) {
                        Renderer.lineText(name, Font("Arial", Font.PLAIN, 150), Color.black, -40.0)
                    } else {
                        Renderer.labelText(
                            name, Font("Arial", Font.PLAIN, 150), Color.black,
                            Symbols.Delta(Symbols.Handle.BC, AffineTransform.getTranslateInstance(0.0, -40.0))
                        )
                    }
                    S57val.CatSEA.SEA_BAY -> if (Renderer.zoom >= 12 && name != null) if (feature!!.geom!!.prim === S57map.Pflag.LINE) {
                        Renderer.lineText(name, Font("Arial", Font.PLAIN, 150), Color.black, -40.0)
                    } else {
                        Renderer.labelText(
                            name, Font("Arial", Font.PLAIN, 150), Color.black,
                            Symbols.Delta(Symbols.Handle.BC, AffineTransform.getTranslateInstance(0.0, -40.0))
                        )
                    }
                    S57val.CatSEA.SEA_SHOL -> if (Renderer.zoom >= 14) {
                        if (feature!!.geom!!.prim === S57map.Pflag.AREA) {
                            Renderer.lineVector(Symbols.LineStyle(Color(0xc480ff), 4f, floatArrayOf(25f, 25f)))
                            if (name != null) {
                                Renderer.labelText(
                                    name, Font("Arial", Font.ITALIC, 75), Color.black,
                                    Symbols.Delta(Symbols.Handle.BC, AffineTransform.getTranslateInstance(0.0, -40.0))
                                )
                                Renderer.labelText(
                                    "(Shoal)", Font("Arial", Font.PLAIN, 60), Color.black,
                                    Symbols.Delta(Symbols.Handle.BC)
                                )
                            }
                        } else if (feature!!.geom!!.prim === S57map.Pflag.LINE) {
                            if (name != null) {
                                Renderer.lineText(name, Font("Arial", Font.ITALIC, 75), Color.black, -40.0)
                                Renderer.lineText("(Shoal)", Font("Arial", Font.PLAIN, 60), Color.black, 0.0)
                            }
                        } else {
                            if (name != null) {
                                Renderer.labelText(
                                    name, Font("Arial", Font.ITALIC, 75), Color.black,
                                    Symbols.Delta(Symbols.Handle.BC, AffineTransform.getTranslateInstance(0.0, -40.0))
                                )
                                Renderer.labelText(
                                    "(Shoal)", Font("Arial", Font.PLAIN, 60), Color.black,
                                    Symbols.Delta(Symbols.Handle.BC)
                                )
                            }
                        }
                    }
                    S57val.CatSEA.SEA_GAT, S57val.CatSEA.SEA_NRRW -> addName(12, Font("Arial", Font.PLAIN, 100))
                    else -> {}
                }
                Obj.SNDWAV -> if (Renderer.zoom >= 12) Renderer.fillPattern(Areas.Sandwaves)
                Obj.WEDKLP -> if (Renderer.zoom >= 12) {
                    when (getAttEnum(feature!!.type, Att.CATWED) as S57val.CatWED) {
                        S57val.CatWED.WED_KELP -> if (feature!!.geom!!.prim === S57map.Pflag.AREA) {
                            Renderer.fillPattern(Areas.KelpA)
                        } else {
                            Renderer.symbol(Areas.KelpS)
                        }
                        else -> {}
                    }
                }
                Obj.SPLARE -> {
                    if (Renderer.zoom >= 12) {
                        Renderer.symbol(Areas.Plane, Symbols.Scheme(Symbols.Msymb))
                        Renderer.lineSymbols(Areas.Restricted, 0.5, Areas.LinePlane, null, 10, Symbols.Mline)
                    }
                    addName(
                        15, Font("Arial", Font.BOLD, 80),
                        Symbols.Delta(Symbols.Handle.BC, AffineTransform.getTranslateInstance(0.0, -90.0))
                    )
                }
                else -> {}
            }
        }

        private fun beacons() {
            if ((Renderer.zoom >= 14 || Renderer.zoom >= 12) && (feature!!.type === Obj.BCNLAT || feature!!.type) === Obj.BCNCAR || Renderer.zoom >= 11 && (feature!!.type === Obj.BCNSAW || hasObject(
                    Obj.RTPBCN
                ))
            ) {
                var shape = getAttEnum(feature!!.type, Att.BCNSHP) as S57val.BcnSHP
                if (shape === S57val.BcnSHP.BCN_UNKN) shape = S57val.BcnSHP.BCN_PILE
                if (shape === S57val.BcnSHP.BCN_WTHY && feature!!.type === Obj.BCNLAT) {
                    when (getAttEnum(feature!!.type, Att.CATLAM) as S57val.CatLAM) {
                        S57val.CatLAM.LAM_PORT -> Renderer.symbol(Beacons.WithyPort)
                        S57val.CatLAM.LAM_STBD -> Renderer.symbol(Beacons.WithyStarboard)
                        else -> Renderer.symbol(Beacons.Stake, getScheme(feature!!.type))
                    }
                } else if (shape === S57val.BcnSHP.BCN_PRCH && feature!!.type === Obj.BCNLAT
                    && !feature!!.objs!!.containsKey(Obj.TOPMAR)
                ) {
                    when (getAttEnum(feature!!.type, Att.CATLAM) as S57val.CatLAM) {
                        S57val.CatLAM.LAM_PORT -> Renderer.symbol(Beacons.PerchPort)
                        S57val.CatLAM.LAM_STBD -> Renderer.symbol(Beacons.PerchStarboard)
                        else -> Renderer.symbol(Beacons.Stake, getScheme(feature!!.type))
                    }
                } else {
                    Renderer.symbol(Beacons.Shapes[shape], getScheme(feature!!.type))
                    if (feature!!.objs!!.containsKey(Obj.TOPMAR)) {
                        val topmap = feature!!.objs!![Obj.TOPMAR]!![0]
                        if (topmap!!.containsKey(Att.TOPSHP)) {
                            Renderer.symbol(
                                Topmarks.Shapes[(topmap[Att.TOPSHP].value as ArrayList<S57val.TopSHP?>)[0]],
                                getScheme(Obj.TOPMAR), Topmarks.BeaconDelta
                            )
                        }
                    } else if (feature!!.objs!!.containsKey(Obj.DAYMAR)) {
                        val topmap = feature!!.objs!![Obj.DAYMAR]!![0]
                        if (topmap!!.containsKey(Att.TOPSHP)) {
                            Renderer.symbol(
                                Topmarks.Shapes[(topmap[Att.TOPSHP].value as ArrayList<S57val.TopSHP?>)[0]],
                                getScheme(Obj.DAYMAR), Topmarks.BeaconDelta
                            )
                        }
                    }
                }
                if (hasObject(Obj.NOTMRK)) notices()
                addName(
                    15, Font("Arial", Font.BOLD, 40),
                    Symbols.Delta(Symbols.Handle.BL, AffineTransform.getTranslateInstance(60.0, -50.0))
                )
                Signals.addSignals()
            }
        }

        private fun buoys() {
            if (Renderer.zoom >= 14 || Renderer.zoom >= 12 && (feature!!.type === Obj.BOYLAT || feature!!.type) === Obj.BOYCAR || Renderer.zoom >= 11 && (feature!!.type === Obj.BOYSAW || hasObject(
                    Obj.RTPBCN
                ))
            ) {
                var shape = getAttEnum(feature!!.type, Att.BOYSHP) as S57val.BoySHP
                if (shape === S57val.BoySHP.BOY_UNKN) shape = S57val.BoySHP.BOY_PILR
                Renderer.symbol(Buoys.Shapes[shape], getScheme(feature!!.type))
                if (feature!!.objs!!.containsKey(Obj.TOPMAR)) {
                    val topmap = feature!!.objs!![Obj.TOPMAR]!![0]
                    if (topmap!!.containsKey(Att.TOPSHP)) {
                        Renderer.symbol(
                            Topmarks.Shapes[(topmap[Att.TOPSHP].value as ArrayList<S57val.TopSHP?>)[0]],
                            getScheme(Obj.TOPMAR), Topmarks.BuoyDeltas[shape]
                        )
                    }
                } else if (feature!!.objs!!.containsKey(Obj.DAYMAR)) {
                    val topmap = feature!!.objs!![Obj.DAYMAR]!![0]
                    if (topmap!!.containsKey(Att.TOPSHP)) {
                        Renderer.symbol(
                            Topmarks.Shapes[(topmap[Att.TOPSHP].value as ArrayList<S57val.TopSHP?>)[0]],
                            getScheme(Obj.DAYMAR), Topmarks.BuoyDeltas[shape]
                        )
                    }
                }
                addName(
                    15, Font("Arial", Font.BOLD, 40),
                    Symbols.Delta(Symbols.Handle.BL, AffineTransform.getTranslateInstance(60.0, -50.0))
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
                val atts = feature!!.objs!![Obj.BRIDGE]!![0]
                var vstr = ""
                var hstr = ""
                if (atts != null) {
                    if (atts.containsKey(Att.HORCLR)) {
                        horclr = (atts[Att.HORCLR].value as Double?)!!
                        hstr = horclr.toString()
                    }
                    verclr = if (atts.containsKey(Att.VERCLR)) {
                        (atts[Att.VERCLR].value as Double?)!!
                    } else {
                        if (atts.containsKey(Att.VERCSA)) (atts[Att.VERCSA].value as Double?)!! else 0.0
                    }
                    verccl =
                        if (atts.containsKey(Att.VERCCL)) (atts[Att.VERCCL].value as Double?)!! else 0.0
                    vercop =
                        if (atts.containsKey(Att.VERCOP)) (atts[Att.VERCOP].value as Double?)!! else 0.0
                    if (verclr > 0) {
                        vstr += verclr.toString()
                    } else if (verccl > 0) {
                        vstr += if (vercop == 0.0) {
                            "$verccl/-"
                        } else {
                            "$verccl/$vercop"
                        }
                    }
                    if (hstr.isEmpty() && !vstr.isEmpty()) {
                        Renderer.labelText(
                            vstr, Font("Arial", Font.PLAIN, 30), Color.black, Renderer.LabelStyle.VCLR,
                            Color.black, Color.white, Symbols.Delta(Symbols.Handle.CC)
                        )
                    } else if (!hstr.isEmpty() && !vstr.isEmpty()) {
                        Renderer.labelText(
                            vstr, Font("Arial", Font.PLAIN, 30), Color.black, Renderer.LabelStyle.VCLR,
                            Color.black, Color.white, Symbols.Delta(Symbols.Handle.BC)
                        )
                        Renderer.labelText(
                            hstr, Font("Arial", Font.PLAIN, 30), Color.black, Renderer.LabelStyle.HCLR,
                            Color.black, Color.white, Symbols.Delta(Symbols.Handle.TC)
                        )
                    } else if (!hstr.isEmpty() && vstr.isEmpty()) {
                        Renderer.labelText(
                            hstr, Font("Arial", Font.PLAIN, 30), Color.black, Renderer.LabelStyle.HCLR,
                            Color.black, Color.white, Symbols.Delta(Symbols.Handle.CC)
                        )
                    }
                }
            }
        }

        private fun cables() {
            if (Renderer.zoom >= 16 && feature!!.geom!!.length < 2) {
                if (feature!!.type === Obj.CBLSUB) {
                    Renderer.lineSymbols(Areas.Cable, 0.0, null, null, 0, Symbols.Mline)
                } else if (feature!!.type === Obj.CBLOHD) {
                    val atts = feature!!.objs!![Obj.CBLOHD]!![0]
                    if (atts != null && atts.containsKey(Att.CATCBL) && atts[Att.CATCBL].value === S57val.CatCBL.CBL_POWR) {
                        Renderer.lineSymbols(Areas.CableDash, 0.0, Areas.CableDot, Areas.CableFlash, 2, Color.black)
                    } else {
                        Renderer.lineSymbols(Areas.CableDash, 0.0, Areas.CableDot, null, 2, Color.black)
                    }
                    if (atts != null) {
                        if (atts.containsKey(Att.VERCLR)) {
                            Renderer.labelText(
                                java.lang.String.valueOf(atts[Att.VERCLR].value), Font("Arial", Font.PLAIN, 50),
                                Color.black, Renderer.LabelStyle.VCLR, Color.black,
                                Symbols.Delta(Symbols.Handle.TC, AffineTransform.getTranslateInstance(0.0, 25.0))
                            )
                        } else if (atts.containsKey(Att.VERCSA)) {
                            Renderer.labelText(
                                java.lang.String.valueOf(atts[Att.VERCSA].value), Font("Arial", Font.PLAIN, 50),
                                Color.black, Renderer.LabelStyle.PCLR, Color.black,
                                Symbols.Delta(Symbols.Handle.TC, AffineTransform.getTranslateInstance(0.0, 25.0))
                            )
                        }
                    }
                }
            }
        }

        private fun callpoint() {
            if (Renderer.zoom >= 14) {
                var symb = Harbours.CallPoint2
                val trf = getAttEnum(feature!!.type, Att.TRAFIC) as S57val.TrfTRF
                if (trf !== S57val.TrfTRF.TRF_TWOW) {
                    symb = Harbours.CallPoint1
                }
                var orient: Double? = 0.0
                if ((getAttVal(feature!!.type, Att.ORIENT) as Double?).also { orient = it } == null) {
                    orient = 0.0
                }
                Renderer.symbol(
                    symb, Symbols.Delta(
                        Symbols.Handle.CC, AffineTransform.getRotateInstance(
                            Math.toRadians(
                                orient!!
                            )
                        )
                    )
                )
                var chn: String?
                if (!getAttStr(feature!!.type, Att.COMCHA).also { chn = it }
                        .isEmpty()) {
                    Renderer.labelText(
                        "Ch.$chn", Font("Arial", Font.PLAIN, 50), Color.black,
                        Symbols.Delta(Symbols.Handle.TC, AffineTransform.getTranslateInstance(0.0, 50.0))
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
                    var dd: String? = ""
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
                    Renderer.labelText(
                        ul, Font("Arial", Font.PLAIN, 30), Color.black,
                        Symbols.Delta(Symbols.Handle.RC, AffineTransform.getTranslateInstance(10.0, 15.0))
                    )
                    Renderer.labelText(
                        id, Font("Arial", Font.PLAIN, 30), Color.black,
                        Symbols.Delta(Symbols.Handle.RC, AffineTransform.getTranslateInstance(10.0, 0.0))
                    )
                    Renderer.labelText(
                        dd, Font("Arial", Font.PLAIN, 20), Color.black,
                        Symbols.Delta(Symbols.Handle.LC, AffineTransform.getTranslateInstance(15.0, 10.0))
                    )
                }
                Obj.DEPCNT -> {}
                else -> {}
            }
        }

        private fun distances() {
            if (Renderer.zoom >= 14) {
                if (!testAttribute(Obj.DISMAR, Att.CATDIS, S57val.CatDIS.DIS_NONI)) {
                    Renderer.symbol(Harbours.DistanceI)
                } else {
                    Renderer.symbol(Harbours.DistanceU)
                }
                if (Renderer.zoom >= 15) {
                    val atts = getAtts(Obj.DISMAR, 0)
                    if (atts != null && atts.containsKey(Att.WTWDIS)) {
                        val dist = atts[Att.WTWDIS].value as Double?
                        var str = ""
                        if (atts.containsKey(Att.HUNITS)) {
                            when (getAttEnum(Obj.DISMAR, Att.HUNITS) as S57val.UniHLU) {
                                S57val.UniHLU.HLU_METR -> str += "m "
                                S57val.UniHLU.HLU_FEET -> str += "ft "
                                S57val.UniHLU.HLU_HMTR -> str += "hm "
                                S57val.UniHLU.HLU_KMTR -> str += "km "
                                S57val.UniHLU.HLU_SMIL -> str += "M "
                                S57val.UniHLU.HLU_NMIL -> str += "NM "
                                else -> {}
                            }
                        }
                        str += String.format("%1.0f", dist)
                        Renderer.labelText(
                            str, Font("Arial", Font.PLAIN, 40), Color.black,
                            Symbols.Delta(Symbols.Handle.CC, AffineTransform.getTranslateInstance(0.0, 45.0))
                        )
                    }
                }
            }
        }

        private fun floats() {
            if (Renderer.zoom >= 12 || (Renderer.zoom >= 11
                        && (feature!!.type === Obj.LITVES || feature!!.type === Obj.BOYINB || hasObject(
                    Obj.RTPBCN
                )))
            ) {
                when (feature!!.type) {
                    Obj.LITVES -> Renderer.symbol(
                        Buoys.Super, getScheme(
                            feature!!.type
                        )
                    )
                    Obj.LITFLT -> Renderer.symbol(
                        Buoys.Float, getScheme(
                            feature!!.type
                        )
                    )
                    Obj.BOYINB -> Renderer.symbol(
                        Buoys.Super, getScheme(
                            feature!!.type
                        )
                    )
                    else -> {}
                }
                if (feature!!.objs!!.containsKey(Obj.TOPMAR)) {
                    val topmap = feature!!.objs!![Obj.TOPMAR]!![0]
                    if (topmap!!.containsKey(Att.TOPSHP)) {
                        Renderer.symbol(
                            Topmarks.Shapes[(topmap[Att.TOPSHP].value as ArrayList<S57val.TopSHP?>?)!![0]],
                            getScheme(Obj.TOPMAR), Topmarks.FloatDelta
                        )
                    }
                } else if (feature!!.objs!!.containsKey(Obj.DAYMAR)) {
                    val topmap = feature!!.objs!![Obj.DAYMAR]!![0]
                    if (topmap!!.containsKey(Att.TOPSHP)) {
                        Renderer.symbol(
                            Topmarks.Shapes[(topmap[Att.TOPSHP].value as ArrayList<S57val.TopSHP?>?)!![0]],
                            getScheme(Obj.DAYMAR), Topmarks.FloatDelta
                        )
                    }
                }
                addName(
                    15, Font("Arial", Font.BOLD, 40),
                    Symbols.Delta(Symbols.Handle.BL, AffineTransform.getTranslateInstance(20.0, -50.0))
                )
                Signals.addSignals()
            }
        }

        private fun gauges() {
            if (Renderer.zoom >= 14) {
                Renderer.symbol(Harbours.TideGauge)
                addName(
                    15, Font("Arial", Font.BOLD, 40),
                    Symbols.Delta(Symbols.Handle.BL, AffineTransform.getTranslateInstance(20.0, -50.0))
                )
                Signals.addSignals()
            }
        }

        private fun harbours() {
            val name = name
            when (feature!!.type) {
                Obj.ACHBRT -> {
                    if (Renderer.zoom >= 14) {
                        Renderer.symbol(Harbours.Anchor, Symbols.Scheme(Symbols.Msymb))
                        if (Renderer.zoom >= 15) {
                            Renderer.labelText(
                                name ?: "", Font("Arial", Font.PLAIN, 30), Symbols.Msymb,
                                Renderer.LabelStyle.RRCT, Symbols.Msymb, Color.white, Symbols.Delta(Symbols.Handle.BC)
                            )
                        }
                    }
                    if (getAttVal(Obj.ACHBRT, Att.RADIUS) != null) {
                        var radius: Double
                        if ((getAttVal(Obj.ACHBRT, Att.RADIUS) as Double?).also { radius = it } != 0.0) {
                            var units = getAttEnum(Obj.ACHBRT, Att.HUNITS) as S57val.UniHLU
                            if (units === S57val.UniHLU.HLU_UNKN) {
                                units = S57val.UniHLU.HLU_METR
                            }
                            Renderer.lineCircle(
                                Symbols.LineStyle(Symbols.Mline, 4f, floatArrayOf(10f, 10f), null),
                                radius,
                                units
                            )
                        }
                    }
                }
                Obj.ACHARE -> if (Renderer.zoom >= 12) {
                    if (feature!!.geom!!.prim !== S57map.Pflag.AREA) {
                        Renderer.symbol(Harbours.Anchorage, Symbols.Scheme(Color.black))
                    } else {
                        Renderer.symbol(Harbours.Anchorage, Symbols.Scheme(Symbols.Mline))
                        Renderer.lineSymbols(Areas.Restricted, 1.0, Areas.LineAnchor, null, 10, Symbols.Mline)
                    }
                    addName(
                        15, Font("Arial", Font.BOLD, 60), Symbols.Mline,
                        Symbols.Delta(Symbols.Handle.LC, AffineTransform.getTranslateInstance(70.0, 0.0))
                    )
                    val sts = getAttList(Obj.ACHARE, Att.STATUS) as ArrayList<S57val.StsSTS?>
                    if (Renderer.zoom >= 15 && sts.contains(S57val.StsSTS.STS_RESV)) {
                        Renderer.labelText(
                            "Reserved", Font("Arial", Font.PLAIN, 50), Symbols.Mline,
                            Symbols.Delta(Symbols.Handle.TC, AffineTransform.getTranslateInstance(0.0, 60.0))
                        )
                    }
                    val cats = getAttList(Obj.ACHARE, Att.CATACH) as ArrayList<S57val.CatACH?>
                    var dy = (cats.size - 1) * -30
                    for (cat in cats) {
                        when (cat) {
                            S57val.CatACH.ACH_DEEP -> {
                                Renderer.labelText(
                                    "DW", Font("Arial", Font.BOLD, 50), Symbols.Msymb,
                                    Symbols.Delta(
                                        Symbols.Handle.RC,
                                        AffineTransform.getTranslateInstance(-60.0, dy.toDouble())
                                    )
                                )
                                dy += 60
                            }
                            S57val.CatACH.ACH_TANK -> {
                                Renderer.labelText(
                                    "Tanker", Font("Arial", Font.BOLD, 50), Symbols.Msymb,
                                    Symbols.Delta(
                                        Symbols.Handle.RC,
                                        AffineTransform.getTranslateInstance(-60.0, dy.toDouble())
                                    )
                                )
                                dy += 60
                            }
                            S57val.CatACH.ACH_H24P -> {
                                Renderer.labelText(
                                    "24h", Font("Arial", Font.BOLD, 50), Symbols.Msymb,
                                    Symbols.Delta(
                                        Symbols.Handle.RC,
                                        AffineTransform.getTranslateInstance(-60.0, dy.toDouble())
                                    )
                                )
                                dy += 60
                            }
                            S57val.CatACH.ACH_EXPL -> {
                                Renderer.symbol(
                                    Harbours.Explosives, Symbols.Scheme(Symbols.Msymb),
                                    Symbols.Delta(
                                        Symbols.Handle.RC,
                                        AffineTransform.getTranslateInstance(-60.0, dy.toDouble())
                                    )
                                )
                                dy += 60
                            }
                            S57val.CatACH.ACH_QUAR -> {
                                Renderer.symbol(
                                    Harbours.Hospital, Symbols.Scheme(Symbols.Msymb),
                                    Symbols.Delta(
                                        Symbols.Handle.RC,
                                        AffineTransform.getTranslateInstance(-60.0, dy.toDouble())
                                    )
                                )
                                dy += 60
                            }
                            S57val.CatACH.ACH_SEAP -> {
                                Renderer.symbol(
                                    Areas.Seaplane, Symbols.Scheme(Symbols.Msymb),
                                    Symbols.Delta(
                                        Symbols.Handle.RC,
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
                    Renderer.lineVector(Symbols.LineStyle(Symbols.Mline, 6f, floatArrayOf(20f, 20f)))
                    labelText(
                        name ?: " ", Font("Arial", Font.PLAIN, 40), Symbols.Msymb,
                        Renderer.LabelStyle.RRCT, Symbols.Mline, Color.white
                    )
                }
                Obj.BUISGL -> if (Renderer.zoom >= 16) {
                    val symbols = ArrayList<Symbols.Symbol?>()
                    val fncs = getAttList(Obj.BUISGL, Att.FUNCTN) as ArrayList<S57val.FncFNC?>
                    for (fnc in fncs) {
                        symbols.add(Landmarks.Funcs.get(fnc))
                    }
                    if (feature!!.objs!!.containsKey(Obj.SMCFAC)) {
                        val scfs = getAttList(Obj.SMCFAC, Att.CATSCF) as ArrayList<S57val.CatSCF?>
                        for (scf in scfs) {
                            symbols.add(Facilities.Cats.get(scf))
                        }
                    }
                    Renderer.cluster(symbols)
                }
                Obj.HRBFAC -> if (Renderer.zoom >= 12) {
                    val cathaf = getAttList(Obj.HRBFAC, Att.CATHAF) as ArrayList<S57val.CatHAF?>
                    if (cathaf.size == 1) {
                        when (cathaf[0]) {
                            S57val.CatHAF.HAF_MRNA -> Renderer.symbol(Harbours.Marina)
                            S57val.CatHAF.HAF_MANF -> Renderer.symbol(Harbours.MarinaNF)
                            S57val.CatHAF.HAF_FISH -> Renderer.symbol(Harbours.Fishing)
                            else -> Renderer.symbol(Harbours.Harbour)
                        }
                    } else {
                        Renderer.symbol(Harbours.Harbour)
                    }
                }
                else -> {}
            }
        }

        private fun highways() {
            when (feature!!.type) {
                Obj.ROADWY -> {
                    val cat = getAttList(Obj.ROADWY, Att.CATROD) as ArrayList<S57val.CatROD?>
                    if (cat.size > 0) {
                        when (cat[0]) {
                            S57val.CatROD.ROD_MWAY -> Renderer.lineVector(Symbols.LineStyle(Color.black, 20f))
                            S57val.CatROD.ROD_MAJR -> Renderer.lineVector(Symbols.LineStyle(Color.black, 15f))
                            S57val.CatROD.ROD_MINR -> Renderer.lineVector(Symbols.LineStyle(Color.black, 10f))
                            else -> Renderer.lineVector(Symbols.LineStyle(Color.black, 5f))
                        }
                    } else {
                        Renderer.lineVector(Symbols.LineStyle(Color.black, 5f))
                    }
                }
                Obj.RAILWY -> {
                    Renderer.lineVector(Symbols.LineStyle(Color.gray, 10f))
                    Renderer.lineVector(Symbols.LineStyle(Color.black, 10f, floatArrayOf(30f, 30f)))
                }
                else -> {}
            }
        }

        private fun landmarks() {
            if (!hasAttribute(Obj.LNDMRK, Att.CATLMK)
                && (!hasAttribute(Obj.LNDMRK, Att.FUNCTN) || testAttribute(
                    Obj.LNDMRK,
                    Att.FUNCTN,
                    S57val.FncFNC.FNC_LGHT
                ))
                && hasObject(Obj.LIGHTS)
            ) lights() else if (Renderer.zoom >= 12) {
                when (feature!!.type) {
                    Obj.LNDMRK -> {
                        val cats = getAttList(feature!!.type, Att.CATLMK) as ArrayList<S57val.CatLMK?>
                        var catSym = Landmarks.Shapes[cats[0]]
                        val fncs = getAttList(feature!!.type, Att.FUNCTN) as ArrayList<S57val.FncFNC?>
                        var fncSym = Landmarks.Funcs[fncs[0]]
                        if (fncs[0] === S57val.FncFNC.FNC_CHCH && cats[0] === S57val.CatLMK.LMK_TOWR) catSym =
                            Landmarks.ChurchTower
                        if (cats[0] === S57val.CatLMK.LMK_RADR) fncSym = Landmarks.RadioTV
                        Renderer.symbol(catSym)
                        Renderer.symbol(fncSym)
                    }
                    Obj.SILTNK -> if (testAttribute(
                            feature!!.type,
                            Att.CATSIL,
                            S57val.CatSIL.SIL_WTRT
                        )
                    ) Renderer.symbol(
                        Landmarks.WaterTower
                    )
                    else -> {}
                }
                if (Renderer.zoom >= 15) addName(
                    15, Font("Arial", Font.BOLD, 40),
                    Symbols.Delta(Symbols.Handle.BL, AffineTransform.getTranslateInstance(60.0, -50.0))
                )
                Signals.addSignals()
            }
        }

        private fun points() {
            var ok = false
            when (feature!!.type) {
                Obj.FOGSIG -> if (Renderer.zoom >= 12) {
                    if (feature!!.objs!!.containsKey(Obj.LIGHTS)) lights() else Renderer.symbol(Harbours.Post)
                    ok = true
                }
                else -> if (Renderer.zoom >= 14) {
                    if (feature!!.objs!!.containsKey(Obj.LIGHTS)) lights() else Renderer.symbol(Harbours.Post)
                    ok = true
                }
            }
            if (ok) {
                if (feature!!.objs!!.containsKey(Obj.TOPMAR)) {
                    val topmap = feature!!.objs!![Obj.TOPMAR]!![0]
                    if (topmap!!.containsKey(Att.TOPSHP)) {
                        Renderer.symbol(
                            Topmarks.Shapes[(topmap[Att.TOPSHP].value as ArrayList<S57val.TopSHP?>?)!![0]],
                            getScheme(Obj.TOPMAR), null
                        )
                    }
                } else if (feature!!.objs!!.containsKey(Obj.DAYMAR)) {
                    val topmap = feature!!.objs!![Obj.DAYMAR]!![0]
                    if (topmap!!.containsKey(Att.TOPSHP)) {
                        Renderer.symbol(
                            Topmarks.Shapes[(topmap[Att.TOPSHP].value as ArrayList<S57val.TopSHP?>?)!![0]],
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
                    Renderer.symbol(Beacons.LightMajor)
                    ok = true
                }
                Obj.LITMIN, Obj.LIGHTS, Obj.PILPNT -> if (Renderer.zoom >= 14) {
                    Renderer.symbol(Beacons.LightMinor)
                    ok = true
                }
                else -> {}
            }
            if (ok) {
                if (feature!!.objs!!.containsKey(Obj.TOPMAR)) {
                    val topmap = feature!!.objs!![Obj.TOPMAR]!![0]
                    if (topmap!!.containsKey(Att.TOPSHP)) {
                        Renderer.symbol(
                            Topmarks.Shapes[(topmap[Att.TOPSHP].value as ArrayList<S57val.TopSHP?>?)!![0]],
                            getScheme(Obj.TOPMAR), Topmarks.LightDelta
                        )
                    }
                } else if (feature!!.objs!!.containsKey(Obj.DAYMAR)) {
                    val topmap = feature!!.objs!![Obj.DAYMAR]!![0]
                    if (topmap!!.containsKey(Att.TOPSHP)) {
                        Renderer.symbol(
                            Topmarks.Shapes[(topmap[Att.TOPSHP].value as ArrayList<S57val.TopSHP?>?)!![0]],
                            getScheme(Obj.DAYMAR), Topmarks.LightDelta
                        )
                    }
                }
                Signals.addSignals()
            }
        }

        private fun marinas() {
            if (Renderer.zoom >= 16) {
                val symbols = ArrayList<Symbols.Symbol?>()
                val scfs = getAttList(Obj.SMCFAC, Att.CATSCF) as ArrayList<S57val.CatSCF?>
                for (scf in scfs) {
                    symbols.add(Facilities.Cats.get(scf))
                }
                Renderer.cluster(symbols)
            }
        }

        private fun moorings() {
            if (Renderer.zoom >= 14) {
                when (getAttEnum(feature!!.type, Att.CATMOR) as S57val.CatMOR) {
                    S57val.CatMOR.MOR_DLPN -> Renderer.symbol(Harbours.Dolphin)
                    S57val.CatMOR.MOR_DDPN -> Renderer.symbol(Harbours.DeviationDolphin)
                    S57val.CatMOR.MOR_BLRD, S57val.CatMOR.MOR_POST -> Renderer.symbol(Harbours.Bollard)
                    S57val.CatMOR.MOR_BUOY -> {
                        var shape = getAttEnum(feature!!.type, Att.BOYSHP) as S57val.BoySHP
                        if (shape === S57val.BoySHP.BOY_UNKN) {
                            shape = S57val.BoySHP.BOY_SPHR
                        }
                        Renderer.symbol(Buoys.Shapes[shape], getScheme(feature!!.type))
                        Renderer.symbol(Topmarks.TopMooring, Topmarks.BuoyDeltas[shape])
                    }
                    else -> {}
                }
                Signals.addSignals()
            }
        }

        private fun notices() {
            if (Renderer.zoom >= 14) {
                val dx = 0.0
                var dy = 0.0
                dy = when (feature!!.type) {
                    Obj.BCNCAR, Obj.BCNISD, Obj.BCNLAT, Obj.BCNSAW, Obj.BCNSPP -> if (testAttribute(
                            Obj.TOPMAR, Att.TOPSHP, S57val.TopSHP.TOP_BORD
                        )
                        || testAttribute(Obj.DAYMAR, Att.TOPSHP, S57val.TopSHP.TOP_BORD)
                    ) {
                        -100.0
                    } else {
                        -45.0
                    }
                    Obj.NOTMRK -> 0.0
                    else -> return
                }
                var sys: S57val.MarSYS? = S57val.MarSYS.SYS_CEVN
                var bnk: S57val.BnkWTW? = S57val.BnkWTW.BWW_UNKN
                var att = feature!!.atts!![Att.MARSYS]
                if (att != null) sys = att.value as S57val.MarSYS?
                att = feature!!.atts!![Att.BNKWTW]
                if (att != null) bnk = att.value as S57val.BnkWTW?
                val objs = feature!!.objs!![Obj.NOTMRK]
                val n = objs!!.size
                if (n > 5) {
                    Renderer.symbol(
                        Notices.Notice,
                        Symbols.Delta(Symbols.Handle.CC, AffineTransform.getTranslateInstance(dx, dy))
                    )
                } else {
                    var i = 0
                    for (atts in objs.values) {
                        if (atts!![Att.MARSYS] != null) sys =
                            (atts[Att.MARSYS]!!.value as ArrayList<S57val.MarSYS>?)!![0]
                        if (atts[Att.BNKWTW] != null) bnk =
                            (atts[Att.BNKWTW]!!.value as ArrayList<S57val.BnkWTW>?)!![0]
                        var cat: S57val.CatNMK? = S57val.CatNMK.NMK_UNKN
                        if (atts[Att.CATNMK] != null) cat =
                            (atts[Att.CATNMK]!!.value as ArrayList<S57val.CatNMK>?)!![0]
                        val sym = getNotice(cat!!, sys, bnk)
                        val sch = getScheme(sys, bnk)
                        var add: ArrayList<S57val.AddMRK?>? = ArrayList()
                        if (atts[Att.ADDMRK] != null) add =
                            atts[Att.ADDMRK]!!.value as ArrayList<S57val.AddMRK>?
                        var h: Symbols.Handle? = Symbols.Handle.CC
                        var ax = 0.0
                        var ay = 0.0
                        when (i) {
                            0 -> if (n != 1) h = null
                            1 -> if (n <= 3) {
                                h = Symbols.Handle.RC
                                ax = -30.0
                                ay = dy
                            } else {
                                h = Symbols.Handle.BR
                            }
                            2 -> h = if (n <= 3) Symbols.Handle.LC else Symbols.Handle.BL
                            3 -> h = if (n == 4) Symbols.Handle.TC else Symbols.Handle.TR
                            4 -> h = Symbols.Handle.TL
                        }
                        if (h != null) {
                            Renderer.symbol(sym, sch, Symbols.Delta(h, AffineTransform.getTranslateInstance(dx, dy)))
                            if (!add!!.isEmpty()) Renderer.symbol(
                                Notices.NoticeBoard,
                                Symbols.Delta(Symbols.Handle.BC, AffineTransform.getTranslateInstance(ax, ay - 30))
                            )
                        }
                        i++
                    }
                }
            }
        }

        private fun obstructions() {
            if (Renderer.zoom >= 12 && feature!!.type === Obj.OBSTRN) {
                if (getAttEnum(feature!!.type, Att.CATOBS) === S57val.CatOBS.OBS_BOOM) {
                    Renderer.lineVector(Symbols.LineStyle(Color.black, 5f, floatArrayOf(20f, 20f), null))
                    if (Renderer.zoom >= 15) {
                        Renderer.lineText("Boom", Font("Arial", Font.PLAIN, 80), Color.black, -20.0)
                    }
                }
            }
            if (Renderer.zoom >= 14 && feature!!.type === Obj.UWTROC) {
                when (getAttEnum(feature!!.type, Att.WATLEV) as S57val.WatLEV) {
                    S57val.WatLEV.LEV_CVRS -> Renderer.symbol(Areas.RockC)
                    S57val.WatLEV.LEV_AWSH -> Renderer.symbol(Areas.RockA)
                    else -> Renderer.symbol(Areas.Rock)
                }
            } else {
                Renderer.symbol(Areas.Rock)
            }
        }

        private fun pipelines() {
            if (Renderer.zoom >= 16 && feature!!.geom!!.length < 2) {
                if (feature!!.type === Obj.PIPSOL) {
                    Renderer.lineSymbols(Areas.Pipeline, 1.0, null, null, 0, Symbols.Mline)
                } else if (feature!!.type === Obj.PIPOHD) {
                    Renderer.lineVector(Symbols.LineStyle(Color.black, 8f))
                    val atts = feature!!.atts
                    var verclr = 0.0
                    if (atts != null) {
                        verclr = if (atts.containsKey(Att.VERCLR)) {
                            (atts[Att.VERCLR]!!.value as Double?)!!
                        } else {
                            if (atts.containsKey(Att.VERCSA)) (atts[Att.VERCSA]!!.value as Double?)!! else 0.0
                        }
                        if (verclr > 0) {
                            Renderer.labelText(
                                verclr.toString(), Font("Arial", Font.PLAIN, 50), Color.black,
                                Renderer.LabelStyle.VCLR, Color.black,
                                Symbols.Delta(Symbols.Handle.TC, AffineTransform.getTranslateInstance(0.0, 25.0))
                            )
                        }
                    }
                }
            }
        }

        private fun platforms() {
            val cats = getAttList(Obj.OFSPLF, Att.CATOFP) as ArrayList<S57val.CatOFP?>
            if (cats[0] === S57val.CatOFP.OFP_FPSO) Renderer.symbol(Buoys.Storage) else Renderer.symbol(Landmarks.Platform)
            addName(
                15, Font("Arial", Font.BOLD, 40),
                Symbols.Delta(Symbols.Handle.BL, AffineTransform.getTranslateInstance(20.0, -50.0))
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
                    ) Renderer.symbol(
                        Harbours.ContainerCrane
                    ) else Renderer.symbol(Harbours.PortCrane)
                } else if (feature!!.type === Obj.HULKES) {
                    Renderer.lineVector(Symbols.LineStyle(Color.black, 4f, null, Color(0xffe000)))
                    addName(15, Font("Arial", Font.BOLD, 40))
                }
            }
        }

        private fun separation() {
            when (feature!!.type) {
                Obj.TSEZNE, Obj.TSSCRS, Obj.TSSRON -> {
                    if (Renderer.zoom <= 15) Renderer.lineVector(Symbols.LineStyle(Symbols.Mtss)) else Renderer.lineVector(
                        Symbols.LineStyle(Symbols.Mtss, 20f, null, null)
                    )
                    addName(10, Font("Arial", Font.BOLD, 150), Symbols.Mline)
                }
                Obj.TSELNE -> Renderer.lineVector(Symbols.LineStyle(Symbols.Mtss, 20f, null, null))
                Obj.TSSLPT -> Renderer.lineSymbols(Areas.LaneArrow, 0.5, null, null, 0, Symbols.Mtss)
                Obj.TSSBND -> Renderer.lineVector(
                    Symbols.LineStyle(
                        Symbols.Mtss,
                        20f,
                        floatArrayOf(40f, 40f),
                        null
                    )
                )
                Obj.ISTZNE -> Renderer.lineSymbols(Areas.Restricted, 1.0, null, null, 0, Symbols.Mtss)
                else -> {}
            }
        }

        private fun shoreline() {
            val cat = getAttEnum(feature!!.type, Att.CATSLC) as S57val.CatSLC
            if (Renderer.context!!.ruleset() === ChartContext.RuleSet.ALL || Renderer.context!!.ruleset() === ChartContext.RuleSet.BASE) {
                if (cat !== S57val.CatSLC.SLC_SWAY && cat !== S57val.CatSLC.SLC_TWAL) {
                    if (Renderer.zoom >= 12) {
                        Renderer.lineVector(Symbols.LineStyle(Color.black, 10f, Symbols.Yland))
                    } else {
                        Renderer.lineVector(Symbols.LineStyle(Symbols.Yland))
                    }
                }
            }
            if (Renderer.context!!.ruleset() === ChartContext.RuleSet.ALL || Renderer.context!!.ruleset() === ChartContext.RuleSet.SEAMARK) {
                if (Renderer.zoom >= 12) {
                    when (cat) {
                        S57val.CatSLC.SLC_TWAL -> {
                            val lev = getAttEnum(feature!!.type, Att.WATLEV) as S57val.WatLEV
                            if (lev === S57val.WatLEV.LEV_CVRS) {
                                Renderer.lineVector(Symbols.LineStyle(Color.black, 10f, floatArrayOf(40f, 40f), null))
                                if (Renderer.zoom >= 15) Renderer.lineText(
                                    "(covers)",
                                    Font("Arial", Font.PLAIN, 60),
                                    Color.black,
                                    80.0
                                )
                            } else {
                                Renderer.lineVector(Symbols.LineStyle(Color.black, 10f, null, null))
                            }
                            if (Renderer.zoom >= 15) Renderer.lineText(
                                "Training Wall",
                                Font("Arial", Font.PLAIN, 60),
                                Color.black,
                                -30.0
                            )
                        }
                        S57val.CatSLC.SLC_SWAY -> {
                            Renderer.lineVector(Symbols.LineStyle(Color.black, 2f, null, Color(0xffe000)))
                            if (Renderer.zoom >= 16 && feature!!.objs!!.containsKey(Obj.SMCFAC)) {
                                val symbols = ArrayList<Symbols.Symbol?>()
                                val scfs = getAttList(Obj.SMCFAC, Att.CATSCF) as ArrayList<S57val.CatSCF?>
                                for (scf in scfs) {
                                    symbols.add(Facilities.Cats.get(scf))
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
                        Renderer.symbol(Harbours.SignalStation)
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
                        Renderer.symbol(Harbours.SignalStation)
                        str = "SS"
                        str = "SS"
                        val wcats = getAttList(Obj.SISTAW, Att.CATSIW) as ArrayList<S57val.CatSIW?>
                        when (wcats[0]) {
                            S57val.CatSIW.SIW_STRM -> str += "(Storm)"
                            S57val.CatSIW.SIW_WTHR -> str += "(Weather)"
                            S57val.CatSIW.SIW_ICE -> str += "(Ice)"
                            S57val.CatSIW.SIW_TIDG -> str = "Tide gauge"
                            S57val.CatSIW.SIW_TIDS -> str = "Tide scale"
                            S57val.CatSIW.SIW_TIDE -> str += "(Tide)"
                            S57val.CatSIW.SIW_TSTR -> str += "(Stream)"
                            S57val.CatSIW.SIW_DNGR -> str += "(Danger)"
                            S57val.CatSIW.SIW_MILY -> str += "(Firing)"
                            S57val.CatSIW.SIW_TIME -> str += "(Time)"
                            else -> {}
                        }
                    }
                    Obj.RDOSTA, Obj.RTPBCN -> {
                        Renderer.symbol(Harbours.SignalStation)
                        Renderer.symbol(Beacons.RadarStation)
                    }
                    Obj.RADRFL -> Renderer.symbol(Topmarks.RadarReflector)
                    Obj.RADSTA -> {
                        Renderer.symbol(Harbours.SignalStation)
                        Renderer.symbol(Beacons.RadarStation)
                        Renderer.labelText(
                            "Ra", Font("Arial", Font.PLAIN, 40), Symbols.Msymb,
                            Symbols.Delta(Symbols.Handle.TR, AffineTransform.getTranslateInstance(-30.0, -70.0))
                        )
                    }
                    Obj.PILBOP -> {
                        Renderer.symbol(Harbours.Pilot)
                        addName(
                            15, Font("Arial", Font.BOLD, 40), Symbols.Msymb,
                            Symbols.Delta(Symbols.Handle.LC, AffineTransform.getTranslateInstance(70.0, -40.0))
                        )
                        val cat = getAttEnum(feature!!.type, Att.CATPIL) as S57val.CatPIL
                        if (cat === S57val.CatPIL.PIL_HELI) {
                            Renderer.labelText(
                                "H", Font("Arial", Font.PLAIN, 40), Symbols.Msymb,
                                Symbols.Delta(Symbols.Handle.LC, AffineTransform.getTranslateInstance(70.0, 0.0))
                            )
                        }
                    }
                    Obj.CGUSTA -> {
                        Renderer.symbol(Harbours.SignalStation)
                        str = "CG"
                        if (feature!!.objs!!.containsKey(Obj.RSCSTA)) Renderer.symbol(
                            Harbours.Rescue,
                            Symbols.Delta(Symbols.Handle.CC, AffineTransform.getTranslateInstance(130.0, 0.0))
                        )
                    }
                    Obj.RSCSTA -> Renderer.symbol(Harbours.Rescue)
                    else -> {}
                }
                if (Renderer.zoom >= 15 && !str.isEmpty()) {
                    Renderer.labelText(
                        str, Font("Arial", Font.PLAIN, 40), Color.black,
                        Symbols.Delta(Symbols.Handle.LC, AffineTransform.getTranslateInstance(40.0, 0.0))
                    )
                }
                Signals.addSignals()
            }
        }

        private fun transits() {
            if (Renderer.zoom >= 14) {
                if (feature!!.type === Obj.RECTRC) Renderer.lineVector(
                    Symbols.LineStyle(
                        Color.black,
                        10f,
                        null,
                        null
                    )
                ) else if (feature!!.type === Obj.NAVLNE) Renderer.lineVector(
                    Symbols.LineStyle(Color.black, 10f, floatArrayOf(25f, 25f), null)
                )
            }
            if (Renderer.zoom >= 15) {
                var str = ""
                val name = name
                if (name != null) str += "$name "
                var ort: Double?
                if ((getAttVal(feature!!.type, Att.ORIENT) as Double?).also { ort = it } != null) {
                    str += df.format(ort) + "º"
                    if (!str.isEmpty()) Renderer.lineText(str, Font("Arial", Font.PLAIN, 80), Color.black, -20.0)
                }
            }
        }

        private fun waterways() {
            Renderer.lineVector(
                Symbols.LineStyle(
                    Symbols.Bwater,
                    20f,
                    if (feature!!.geom!!.prim === S57map.Pflag.AREA) Symbols.Bwater else null
                )
            )
        }

        private fun wrecks() {
            if (Renderer.zoom >= 14) {
                when (getAttEnum(feature!!.type, Att.CATWRK) as S57val.CatWRK) {
                    S57val.CatWRK.WRK_DNGR, S57val.CatWRK.WRK_MSTS -> Renderer.symbol(Areas.WreckD)
                    S57val.CatWRK.WRK_HULS -> Renderer.symbol(Areas.WreckS)
                    else -> Renderer.symbol(Areas.WreckND)
                }
            }
        }
    }
}