package operator.unary

data class UnaryPoint(var x: Int, var y: Int) {
    operator fun unaryPlus() : UnaryPoint{
        return UnaryPoint(+x, +y)
    }

    operator fun unaryMinus() : UnaryPoint{
        return UnaryPoint(-x, -y)
    }
}