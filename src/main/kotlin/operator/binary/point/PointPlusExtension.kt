package operator.binary.point

operator fun PointPlus.times(scale: Double) : PointPlus {
    // * 단, private 필드를 확장 함수에서 사용할 수는 없다.
    return PointPlus((x * scale).toInt(), (y * scale).toInt())
}
