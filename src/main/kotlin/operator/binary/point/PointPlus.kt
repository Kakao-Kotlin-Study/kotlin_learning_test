package operator.binary.point

data class PointPlus(var x: Int, var y: Int) {
    operator fun plus(other: PointPlus): PointPlus {
        return PointPlus(x + other.x, y + other.y)
    }

//    operator fun plusAssign(other: PointPlus){
//        x += other.x
//        y += other.y
//    }
}