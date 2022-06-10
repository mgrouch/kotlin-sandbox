// License: GPL. For details, see LICENSE file.
package s57


/**
 * @author Malcolm Herring
 * @author mgrouch
 */
class S57map(private val sea: Boolean) {

    // S57/OSM map generation methods
    class MapBounds {
        var minlat: Double = toRadians(90.0)
        var minlon: Double = toRadians(180.0)
        var maxlat: Double = toRadians(-90.0)
        var maxlon: Double = toRadians(-180.0)
    }

    enum class Nflag {
        ANON,  // Edge inner nodes
        ISOL,  // Node not part of Edge
        CONN,  // Edge first and last nodes
        TRNK,  // Edge truncated polygon nodes
        DPTH,  // Sounding nodes
    }

    class Snode {
        // All coordinates in map
        var lat: Double // Latitude in radians
        var lon: Double // Longitude in radians

        var flg: Nflag? // Role of node
        var `val`: Double // Optional value

        constructor() {
            flg = Nflag.ANON
            lat = 0.0
            lon = 0.0
            `val` = 0.0
        }

        constructor(ilat: Double, ilon: Double) {
            flg = Nflag.ANON
            lat = ilat
            lon = ilon
            `val` = 0.0
        }

        constructor(ilat: Double, ilon: Double, iflg: Nflag?) {
            lat = ilat
            lon = ilon
            flg = iflg
            `val` = 0.0
        }

        constructor(ilat: Double, ilon: Double, ival: Double) {
            flg = Nflag.DPTH
            lat = ilat
            lon = ilon
            `val` = ival
        }
    }

    class Edge {
        // A polyline segment
        var first // First CONN node
                : Long = 0
        var last // Last CONN node
                : Long = 0
        var nodes // Inner ANON nodes
                : ArrayList<Long?>? = ArrayList()

    }

    enum class Rflag {
        UNKN, MASTER, SLAVE
    }

    class Reln(var id: Long, var reln: Rflag?)
    class RelTab : ArrayList<Reln?>()
    class ObjTab : HashMap<Int?, AttMap?>()
    class ObjMap : HashMap<S57obj.Obj?, ObjTab?>()
    class AttMap : HashMap<S57att.Att?, S57val.AttVal<*>?>()
    class NodeTab : HashMap<Long?, Snode?>()
    class EdgeTab : HashMap<Long?, Edge?>()
    class FtrMap : HashMap<S57obj.Obj?, ArrayList<Feature?>?>()

    class FtrTab : HashMap<Long?, Feature?>()
    class Prim {
        // Spatial element
        var id // Snode ID for POINTs, Edge ID for LINEs & AREAs)
                : Long
        var forward // Direction of vector used (LINEs & AREAs)
                : Boolean
        var outer // Exterior/Interior boundary (AREAs)
                : Boolean
        var trunc // Cell limit truncation
                : Boolean

        constructor() {
            id = 0
            forward = true
            outer = true
            trunc = false
        }

        constructor(i: Long) {
            id = i
            forward = true
            outer = true
            trunc = false
        }

        constructor(i: Long, o: Boolean) {
            id = i
            forward = true
            outer = o
            trunc = false
        }

        constructor(i: Long, f: Boolean, o: Boolean) {
            id = i
            forward = f
            outer = o
            trunc = false
        }

        constructor(i: Long, f: Boolean, o: Boolean, t: Boolean) {
            id = i
            forward = f
            outer = o
            trunc = t
        }
    }

    class Comp(// Composite spatial element
        var ref // ID of Comp
        : Long, // Number of Prims in this Comp
        var size: Int
    )

    enum class Pflag {
        NOSP, POINT, LINE, AREA
    }

    class Geom(  // Geometric structure of feature
        var prim: Pflag? // Geometry type
    ) {
        var elems: ArrayList<Prim?>? = ArrayList() // Ordered list of elements
        var outers: Int // Number of outers
        var inners: Int = 0 // Number of inners
        var comps: ArrayList<Comp?>? // Ordered list of compounds
        var area: Double // Area of feature
        var length: Double // Length of feature
        var centre: Snode? // Centre of feature

        init {
            outers = inners
            comps = ArrayList()
            area = 0.0
            length = 0.0
            centre = Snode()
        }
    }

    class Feature internal constructor() {
        var id: Long = 0 // Ref for this feature
        var reln: Rflag? = Rflag.UNKN // Relationship status
        var geom: Geom? = Geom(Pflag.NOSP) // Geometry data
        var type: S57obj.Obj? // Feature type
        var atts: AttMap? // Feature attributes
        var rels: RelTab? // Related objects
        var objs: ObjMap? // Slave object attributes

        init {
            type = S57obj.Obj.UNKOBJ
            atts = AttMap()
            rels = RelTab()
            objs = ObjMap()
        }
    }

    var bounds: MapBounds?
    var nodes: NodeTab? = NodeTab()
    var edges: EdgeTab? = EdgeTab()
    var features: FtrMap?
    var index: FtrTab?
    var xref: Long
    private var cref: Long
    private var feature: Feature?
    private var edge: Edge? = null
    private var osm: ArrayList<S57osm.KeyVal<*>?>? = null

    init {
        // All nodes in map
        // All edges in map
        feature = Feature() // Current feature being built
        features = FtrMap() // All features in map, grouped by type
        index = FtrTab() // Feature look-up table
        bounds = MapBounds()
        cref = 0x0000ffffffff0000L // Compound reference generator
        xref = 0x0fff000000000000L // Extras reference generator
    }

    // S57 map building methods
    fun newNode(id: Long, lat: Double, lon: Double, flag: Nflag?) {
        nodes!![id] = Snode(toRadians(lat), toRadians(lon), flag)
        if (flag == Nflag.ANON) {
            edge!!.nodes!!.add(id)
        }
    }

    fun newNode(id: Long, lat: Double, lon: Double, depth: Double) {
        nodes!![id] = Snode(toRadians(lat), toRadians(lon), depth)
    }

    fun newFeature(id: Long, p: Pflag?, objl: Long) {
        feature = Feature()
        val obj = S57obj.decodeType(objl)
        feature!!.geom = Geom(p)
        feature!!.type = obj
        if (obj != S57obj.Obj.UNKOBJ) {
            index!![id] = feature
            feature!!.id = id
        }
    }

    fun refObj(id: Long, rind: Int) {
        var r = Rflag.UNKN
        when (rind) {
            1 -> r = Rflag.MASTER
            2 -> r = Rflag.SLAVE
            3 -> r = Rflag.UNKN
        }
        feature!!.rels!!.add(Reln(id, r))
    }

    fun endFeature() {}
    fun newAtt(attl: Long, atvl: String?) {
        val att = S57att.decodeAttribute(attl)
        val `val` = S57val.decodeValue(atvl, att)
        feature!!.atts!![att] = `val`
    }

    fun newPrim(id: Long, ornt: Long, usag: Long) {
        feature!!.geom!!.elems!!.add(Prim(id, ornt != 2L, usag != 2L))
    }

    fun addConn(id: Long, topi: Int) {
        if (topi == 1) {
            edge!!.first = id
        } else {
            edge!!.last = id
        }
    }

    fun newEdge(id: Long) {
        edge = Edge()
        edges!![id] = edge
    }

    fun endFile() {
        for (id in index!!.keys) {
            val feature = index!![id]
            sortGeom(feature)
            for (reln in feature!!.rels!!) {
                val rel = index!![reln!!.id]
                if (cmpGeoms(feature.geom, rel!!.geom)) {
                    when (reln.reln) {
                        Rflag.SLAVE -> feature.reln = Rflag.MASTER
                        else -> feature.reln = Rflag.UNKN
                    }
                    rel.reln = reln.reln
                } else {
                    reln.reln = Rflag.UNKN
                }
            }
        }
        for (id in index!!.keys) {
            val feature = index!![id]
            if (feature!!.reln == Rflag.UNKN) {
                feature.reln = Rflag.MASTER
            }
            if (feature.type != S57obj.Obj.UNKOBJ && feature.reln == Rflag.MASTER) {
                if (features!![feature.type] == null) {
                    features!![feature.type] = ArrayList()
                }
                features!![feature.type]!!.add(feature)
            }
        }
        for (id in index!!.keys) {
            val feature = index!![id]
            for (reln in feature!!.rels!!) {
                val rel = index!![reln!!.id]
                if (rel!!.reln == Rflag.SLAVE) {
                    if (feature.objs!![rel.type] == null) {
                        feature.objs!![rel.type] = ObjTab()
                    }
                    val tab = feature.objs!![rel.type]
                    val ix = tab!!.size
                    tab[ix] = rel.atts
                }
            }
        }
    }

    // OSM map building methods
    fun addNode(id: Long, lat: Double, lon: Double) {
        nodes!![id] = Snode(toRadians(lat), toRadians(lon))
        feature = Feature()
        feature!!.id = id
        feature!!.reln = Rflag.UNKN
        feature!!.geom!!.prim = Pflag.POINT
        feature!!.geom!!.elems!!.add(Prim(id))
        edge = null
        osm = ArrayList()
    }

    fun addEdge(id: Long) {
        feature = Feature()
        feature!!.id = id
        feature!!.reln = Rflag.UNKN
        feature!!.geom!!.prim = Pflag.LINE
        feature!!.geom!!.elems!!.add(Prim(id))
        edge = Edge()
        osm = ArrayList()
    }

    fun addToEdge(node: Long) {
        if (edge!!.first == 0L) {
            edge!!.first = node
            nodes!![node]!!.flg = Nflag.CONN
        } else {
            if (edge!!.last != 0L) {
                edge!!.nodes!!.add(edge!!.last)
            }
            edge!!.last = node
        }
    }

    fun addArea(id: Long) {
        feature = Feature()
        feature!!.id = id
        feature!!.reln = Rflag.UNKN
        feature!!.geom!!.prim = Pflag.AREA
        edge = null
        osm = ArrayList()
    }

    fun addToArea(id: Long, outer: Boolean) {
        feature!!.geom!!.elems!!.add(Prim(id, outer))
    }

    fun addTag(key: String?, `val`: String?) {
        feature!!.reln = Rflag.MASTER
        val subkeys: Array<String?> = key!!.split(":".toRegex()).dropLastWhile { it.isEmpty() }.toTypedArray()
        if (subkeys.size > 1 && subkeys[0] == "seamark") {
            var obj = S57obj.enumType(subkeys[1])
            if (subkeys.size > 2 && obj != S57obj.Obj.UNKOBJ) {
                var idx = 0
                var att: S57att.Att? = S57att.Att.UNKATT
                try {
                    idx = subkeys[2]!!.toInt()
                    if (subkeys.size == 4) {
                        att = S57att.enumAttribute(subkeys[3], obj)
                    }
                } catch (e: Exception) {
                    att = S57att.enumAttribute(subkeys[2], obj)
                }
                var objs = feature!!.objs!![obj]
                if (objs == null) {
                    objs = ObjTab()
                    feature!!.objs!![obj] = objs
                }
                var atts = objs[idx]
                if (atts == null) {
                    atts = AttMap()
                    objs[idx] = atts
                }
                val attval = S57val.convertValue(`val`, att)
                if (attval!!.`val` != null) {
                    if (att == S57att.Att.VALSOU) {
                        val node = nodes!![feature!!.geom!!.elems!![0]!!.id]
                        node!!.`val` = (attval.`val` as Double)
                    }
                    atts[att] = attval
                }
            } else {
                if (subkeys[1] == "type") {
                    obj = S57obj.enumType(`val`)
                    feature!!.type = obj
                    var objs = feature!!.objs!![obj]
                    if (objs == null) {
                        objs = ObjTab()
                        feature!!.objs!![obj] = objs
                    }
                    var atts = objs[0]
                    if (atts == null) {
                        atts = AttMap()
                        objs[0] = atts
                    }
                    if (obj == S57obj.Obj.SOUNDG && feature!!.geom!!.prim == Pflag.POINT) {
                        val node = nodes!![feature!!.geom!!.elems!![0]!!.id]
                        node!!.flg = Nflag.DPTH
                    }
                } else {
                    if (obj != S57obj.Obj.UNKOBJ) {
                        if (`val` == "yes") {
                            var objs = feature!!.objs!![obj]
                            if (objs == null) {
                                objs = ObjTab()
                                feature!!.objs!![obj] = objs
                            }
                        }
                    } else {
                        val att = S57att.enumAttribute(subkeys[1], S57obj.Obj.UNKOBJ)
                        if (att != S57att.Att.UNKATT) {
                            val attval = S57val.convertValue(`val`, att)
                            if (attval!!.`val` != null) feature!!.atts!![att] = attval
                        }
                    }
                }
            }
        } else if (!sea) {
            S57osm.OSMtag(osm, key, `val`)
        }
    }

    fun tagsDone(id: Long) {
        when (feature!!.geom!!.prim) {
            Pflag.POINT -> {
                val node = nodes!![id]
                if (node!!.flg != Nflag.CONN && node.flg != Nflag.DPTH && (!feature!!.objs!!.isEmpty() || osm!!.isNotEmpty())) {
                    node.flg = Nflag.ISOL
                }
            }
            Pflag.LINE -> {
                edges!![id] = edge
                nodes!![edge!!.first]!!.flg = Nflag.CONN
                nodes!![edge!!.last]!!.flg = Nflag.CONN
                if (edge!!.first == edge!!.last) {
                    feature!!.geom!!.prim = Pflag.AREA
                }
            }
            Pflag.AREA -> {}
            else -> {}
        }
        if (sortGeom(feature) && (edge != null && edge!!.last) != 0L) {
            if (feature!!.type != S57obj.Obj.UNKOBJ) {
                index!![id] = feature
                if (features!![feature!!.type] == null) {
                    features!![feature!!.type] = ArrayList()
                }
                features!![feature!!.type]!!.add(feature)
            }
            for (kvx in osm!!) {
                val base = Feature()
                base.reln = Rflag.MASTER
                base.geom = feature!!.geom
                base.type = kvx!!.obj
                val objs = ObjTab()
                base.objs!![kvx.obj] = objs
                val atts = AttMap()
                objs[0] = atts
                if (kvx.att != S57att.Att.UNKATT) {
                    atts[kvx.att] = S57val.AttVal(kvx.conv, kvx.`val`)
                }
                index!![++xref] = base
                if (features!![kvx.obj] == null) {
                    features!![kvx.obj] = ArrayList()
                }
                features!![kvx.obj]!!.add(base)
            }
        }
    }

    fun mapDone() {
        if (!sea) {
            S57box.bBox(this)
        }
    }

    // Utility methods
    fun sortGeom(feature: Feature?): Boolean {
        return try {
            val sort = Geom(feature!!.geom!!.prim)
            var first: Long = 0
            var last: Long = 0
            var comp: Comp? = null
            var next = true
            feature.geom!!.length = 0.0
            feature.geom!!.area = 0.0
            if (feature.geom!!.elems!!.isEmpty()) {
                return false
            }
            if (feature.geom!!.prim == Pflag.POINT) {
                feature.geom!!.centre = nodes!![feature.geom!!.elems!![0]!!.id]
                return true
            }
            var outer: Geom? = Geom(feature.geom!!.prim)
            val inner = Geom(feature.geom!!.prim)
            for (prim in feature.geom!!.elems!!) {
                if (prim!!.outer) {
                    outer!!.elems!!.add(prim)
                } else {
                    inner.elems!!.add(prim)
                }
            }
            var outin = true
            var sweep = outer!!.elems!!.size
            if (sweep == 0) {
                return false
            }
            var prev = sweep
            var top = 0
            while (outer!!.elems!!.isNotEmpty()) {
                val prim = outer.elems!!.removeAt(0)
                val edge = edges!![prim!!.id] ?: return false
                if (next == true) {
                    next = false
                    first = edge.first
                    last = edge.last
                    prim.forward = true
                    sort.elems!!.add(prim)
                    if (prim.outer) {
                        sort.outers++
                    } else {
                        sort.inners++
                    }
                    comp = Comp(cref++, 1)
                    sort.comps!!.add(comp)
                } else {
                    if (edge.first == last) {
                        sort.elems!!.add(prim)
                        last = edge.last
                        prim.forward = true
                        comp!!.size++
                    } else if (edge.last == first) {
                        sort.elems!!.add(top, prim)
                        first = edge.first
                        prim.forward = true
                        comp!!.size++
                    } else if (edge.last == last) {
                        sort.elems!!.add(prim)
                        last = edge.first
                        prim.forward = false
                        comp!!.size++
                    } else if (edge.first == first) {
                        sort.elems!!.add(top, prim)
                        first = edge.last
                        prim.forward = false
                        comp!!.size++
                    } else {
                        outer.elems!!.add(prim)
                    }
                }
                if (--sweep == 0) {
                    sweep = outer.elems!!.size
                    if (sweep == 0 || sweep == prev) {
                        if (sort.prim == Pflag.AREA && first != last) {
                            return false
                        }
                        if (outin) {
                            if (sweep != 0) {
                                return false
                            }
                            outer = inner
                            outin = false
                            sweep = outer.elems!!.size
                        }
                        next = true
                        top = sort.elems!!.size
                    }
                    prev = sweep
                }
            }
            if (sort.prim == Pflag.LINE && sort.outers == 1 && sort.inners == 0 && first == last) {
                sort.prim = Pflag.AREA
            }
            feature.geom = sort
            if (feature.geom!!.prim == Pflag.AREA) {
                var ie = 0
                var ic = 0
                while (ie < feature.geom!!.elems!!.size) {
                    val area = calcArea(feature.geom, ic)
                    if (ie == 0) feature.geom!!.area = Math.abs(area) * 3444 * 3444
                    if (ie == 0 && area < 0.0 || ie > 0 && area >= 0.0) {
                        val tmp = ArrayList<Prim?>()
                        for (i in 0 until feature.geom!!.comps!![ic]!!.size) {
                            val p = feature.geom!!.elems!!.removeAt(ie)
                            p!!.forward = !p.forward
                            tmp.add(0, p)
                        }
                        feature.geom!!.elems!!.addAll(ie, tmp)
                    }
                    ie += feature.geom!!.comps!![ic]!!.size
                    ic++
                }
            }
            feature.geom!!.length = calcLength(feature.geom)
            feature.geom!!.centre = calcCentroid(feature)
            true
        } catch (e: Exception) {
            false
        }
    }

    fun cmpGeoms(g1: Geom?, g2: Geom?): Boolean {
        return g1!!.prim == g2!!.prim && g1.outers == g2.outers && g1.inners == g2.inners && g1.elems!!.size == g2.elems!!.size
    }

    inner class EdgeIterator(var edge: Edge?, var forward: Boolean) {
        var it: ListIterator<Long?>? = null
        operator fun hasNext(): Boolean {
            return edge != null
        }

        fun nextRef(): Long {
            var ref: Long
            if (forward) {
                if (it == null) {
                    ref = edge!!.first
                    it = edge!!.nodes!!.listIterator()
                } else {
                    if (it!!.hasNext()) {
                        ref = it!!.next()!!
                    } else {
                        ref = edge!!.last
                        edge = null
                    }
                }
            } else {
                if (it == null) {
                    ref = edge!!.last
                    it = edge!!.nodes!!.listIterator(edge!!.nodes!!.size)
                } else {
                    if (it!!.hasPrevious()) {
                        ref = it!!.previous()!!
                    } else {
                        ref = edge!!.first
                        edge = null
                    }
                }
            }
            return ref
        }

        operator fun next(): Snode? {
            return nodes!![nextRef()]
        }
    }

    inner class GeomIterator(var geom: Geom?) {
        var prim: Prim? = null
        var eit: EdgeIterator? = null
        var ite: ListIterator<Prim?>? = geom!!.elems!!.listIterator()
        var itc: ListIterator<Comp?>?
        var comp: Comp? = null
        var ec = 0
        var lastref: Long = 0

        init {
            itc = geom!!.comps!!.listIterator()
        }

        fun hasComp(): Boolean {
            return itc!!.hasNext()
        }

        fun nextComp(): Long {
            comp = itc!!.next()
            ec = comp!!.size
            lastref = 0
            return comp!!.ref
        }

        fun hasEdge(): Boolean {
            return ec > 0 && ite!!.hasNext()
        }

        fun nextEdge(): Long {
            prim = ite!!.next()
            eit = EdgeIterator(edges!![prim!!.id], prim!!.forward)
            ec--
            return prim!!.id
        }

        fun hasNode(): Boolean {
            return eit!!.hasNext()
        }

        fun nextRef(all: Boolean = false): Long {
            var ref = eit!!.nextRef()
            if (!all && ref == lastref) {
                ref = eit!!.nextRef()
            }
            lastref = ref
            return ref
        }

        operator fun next(): Snode? {
            return nodes!![nextRef()]
        }
    }

    fun calcArea(geom: Geom?, comp: Int): Double {
        var node: Snode?
        var lat: Double
        var lon: Double
        var llon: Double
        var llat: Double
        llat = 0.0
        llon = llat
        lon = llon
        lat = lon
        var sigma = 0.0
        val git = GeomIterator(geom)
        for (i in 0..comp) {
            if (git.hasComp()) {
                git.nextComp()
                while (git.hasEdge()) {
                    git.nextEdge()
                    while (git.hasNode()) {
                        node = git.next()
                        if (node == null) continue
                        llon = lon
                        llat = lat
                        lat = node.lat
                        lon = node.lon
                        sigma += lon * Math.sin(llat) - llon * Math.sin(lat)
                    }
                }
                if (i != comp) {
                    llat = 0.0
                    llon = llat
                    lon = llon
                    lat = lon
                    sigma = lat
                }
            }
        }
        return sigma / 2.0
    }

    fun calcLength(geom: Geom?): Double {
        var node: Snode?
        var lat: Double
        var lon: Double
        var llon: Double
        var llat: Double
        llat = 0.0
        llon = llat
        lon = llon
        lat = lon
        var sigma = 0.0
        var first = true
        val git = GeomIterator(geom)
        while (git.hasComp()) {
            git.nextComp()
            while (git.hasEdge()) {
                git.nextEdge()
                while (git.hasNode()) {
                    node = git.next()
                    if (first) {
                        first = false
                        lat = node!!.lat
                        lon = node.lon
                    } else if (node != null) {
                        llat = lat
                        llon = lon
                        lat = node.lat
                        lon = node.lon
                        sigma += Math.acos(
                            Math.sin(lat) * Math.sin(llat) + Math.cos(lat) * Math.cos(llat) * Math.cos(
                                llon - lon
                            )
                        )
                    }
                }
            }
        }
        return sigma * 3444
    }

    fun calcCentroid(feature: Feature?): Snode? {
        var lat: Double
        var lon: Double
        var slat: Double
        var llat: Double
        var llon: Double
        var slon: Double = 0.0
        slat = slon
        lon = slat
        lat = lon
        llon = lat
        llat = llon
        var sarc = 0.0
        var first = true
        when (feature!!.geom!!.prim) {
            Pflag.POINT -> return nodes!![feature.geom!!.elems!![0]!!.id]
            Pflag.LINE -> {
                var git: GeomIterator? = GeomIterator(feature.geom)
                while (git!!.hasComp()) {
                    git.nextComp()
                    while (git.hasEdge()) {
                        git.nextEdge()
                        while (git.hasNode()) {
                            val node = git.next() ?: continue
                            lat = node.lat
                            lon = node.lon
                            if (first) {
                                first = false
                            } else {
                                sarc += Math.acos(Math.cos(lon - llon) * Math.cos(lat - llat))
                            }
                            llat = lat
                            llon = lon
                        }
                    }
                }
                var harc = sarc / 2
                sarc = 0.0
                first = true
                git = GeomIterator(feature.geom)
                while (git.hasComp()) {
                    git.nextComp()
                    while (git.hasEdge()) {
                        git.nextEdge()
                        while (git.hasNode()) {
                            val node = git.next() ?: continue
                            lat = node.lat
                            lon = node.lon
                            if (first) {
                                first = false
                            } else {
                                sarc = Math.acos(Math.cos(lon - llon) * Math.cos(lat - llat))
                                if (sarc > harc) break
                            }
                            harc -= sarc
                            llat = lat
                            llon = lon
                        }
                    }
                }
                return Snode(llat + (lat - llat) * harc / sarc, llon + (lon - llon) * harc / sarc)
            }
            Pflag.AREA -> {
                val git = GeomIterator(feature.geom)
                while (git.hasComp()) {
                    git.nextComp()
                    while (git.hasEdge()) {
                        git.nextEdge()
                        while (git.hasNode()) {
                            val node: Snode? = git.next()
                            lat = node!!.lat
                            lon = node.lon
                            if (first) {
                                first = false
                            } else {
                                val arc = Math.acos(Math.cos(lon - llon) * Math.cos(lat - llat))
                                slat += (lat + llat) / 2 * arc
                                slon += (lon + llon) / 2 * arc
                                sarc += arc
                            }
                            llon = lon
                            llat = lat
                        }
                    }
                }
                return Snode(if (sarc > 0.0) slat / sarc else 0.0, if (sarc > 0.0) slon / sarc else 0.0)
            }
            else -> {}
        }
        return null
    }
}