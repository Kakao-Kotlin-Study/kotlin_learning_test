package operator.unary

import java.math.BigDecimal

operator fun BigDecimal.inc() : BigDecimal{
    return this + BigDecimal.ONE
}

operator fun BigDecimal.dec() : BigDecimal{
    return this - BigDecimal.ONE
}