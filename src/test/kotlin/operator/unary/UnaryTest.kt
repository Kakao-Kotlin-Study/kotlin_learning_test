package operator.unary

import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import java.math.BigDecimal
import kotlin.test.assertEquals

class UnaryTest {
    @Test
    @DisplayName("- 단항 연산자를 이용하여 unaryMinus 메서드를 호출할 수 있다.")
    fun test1(){
        // Given
        val originX = 1;
        val originY = 2;
        val unaryPoint = UnaryPoint(originX, originY);

        // When
        val updated = -unaryPoint;

        // Then
        assertEquals(updated.x, -originX)
        assertEquals(updated.y, -originY)
    }

    @Test
    @DisplayName("+ 단항 연산자를 이용하여 unaryPlus 메서드를 호출할 수 있다.")
    fun test2(){
        // Given
        val originX = 1;
        val originY = 2;
        val unaryPoint = UnaryPoint(originX, originY);

        // When
        val updated = +unaryPoint;

        // Then
        assertEquals(updated.x, originX)
        assertEquals(updated.y, originY)
    }

    @Test
    @DisplayName("! 단항 연산자를 이용하여 not 메서드를 호출할 수 있다.")
    fun test3(){
        // Given
        val booleanValue = false
        val booleanObj = BooleanObj(booleanValue);

        // When
        val updated = !booleanObj

        // Then
        assertEquals(updated.value, !booleanValue)
    }

    @Test
    @DisplayName("++ 단항 연산자를 이용하여 inc 메서드를 호출할 수 있으며, 전위 연산자의 역할을 수행할 수 있다.")
    fun test4(){
        // Given
        val decimalValue = 3
        // * var 선언
        var bigDecimal = BigDecimal(decimalValue);

        // When
        ++bigDecimal

        // Then
        assertEquals(bigDecimal, BigDecimal(decimalValue + 1))
    }

    @Test
    @DisplayName("++ 단항 연산자를 이용하여 inc 메서드를 호출할 수 있으며, 후위 연산자의 역할을 수행할 수 있다.")
    fun test5(){
        // Given
        val decimalValue = 3
        // * var 선언
        var bigDecimal = BigDecimal(decimalValue);

        // When
        val before = bigDecimal++
        val after = bigDecimal

        // Then
        assertEquals(before, BigDecimal(decimalValue))
        assertEquals(after, BigDecimal(decimalValue + 1))
    }

    @Test
    @DisplayName("-- 단항 연산자를 이용하여 dec 메서드를 호출할 수 있으며, 전위 연산자의 역할을 수행할 수 있다.")
    fun test6(){
        // Given
        val decimalValue = 3
        // * var 선언
        var bigDecimal = BigDecimal(decimalValue)

        // When
        --bigDecimal

        // Then
        assertEquals(bigDecimal, BigDecimal(decimalValue - 1))
    }

    @Test
    @DisplayName("-- 단항 연산자를 이용하여 dec 메서드를 호출할 수 있으며, 후위 연산자의 역할을 수행할 수 있다.")
    fun test7(){
        // Given
        val decimalValue = 3
        // * var 선언
        var bigDecimal = BigDecimal(decimalValue);

        // When
        val before = bigDecimal--
        val after = bigDecimal

        // Then
        assertEquals(before, BigDecimal(decimalValue))
        assertEquals(after, BigDecimal(decimalValue - 1))
    }
}