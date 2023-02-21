package operator.unary

data class BooleanObj(var value : Boolean){
    operator fun not() : BooleanObj{
        return BooleanObj(!value)
    }
}