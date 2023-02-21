package operator.binary.point

data class PointPlusAssign(var x: Int, var y: Int) {
    operator fun plusAssign(other: PointPlusAssign){
        x += other.x
        y += other.y
    }
}