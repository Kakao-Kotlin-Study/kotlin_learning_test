package operator.binary.point

import operator.PointPlusJava
import operator.binary.point.PointPlus
import operator.binary.point.PointPlusAssign
import operator.binary.point.times
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test

class PointTest {
    @Test
    @DisplayName("클래스 내에 정의된 연산자 오버로딩 메서드를 해당 연산자를 이용하여 호출할 수 있다.")
    fun test1() {
        // Given
        val pointPlus1 = PointPlus(3, 4)
        val pointPlus2 = PointPlus(2, 6)

        // When
        val plusResult = pointPlus1 + pointPlus2

        // Then
        assertEquals(plusResult.x, 5)
        assertEquals(plusResult.y, 10)
    }

    @Test
    @DisplayName("확장함수도 클래스 내에 정의된 연산자 오버로딩과 동일한 방식으로 호출할 수 있다.")
    fun test2() {
        // Given
        val pointPlus1 = PointPlus(3, 4)
        val scale = 3.0

        // When
        val timesResult = pointPlus1 * scale

        // Then
        assertEquals(timesResult.x, 9)
        assertEquals(timesResult.y, 12)
    }

    @Test
    @DisplayName("java의 관례에 맞는 메서드명을 연산자 식을 사용해 호출할 수 있다.")
    fun test3(){
        // Given
        val point1 = PointPlusJava(1, 3)
        val point2 = PointPlusJava(2, 4)

        // When
        val plusResult = point1 + point2

        // Then
        assertEquals(plusResult.x, 3)
        assertEquals(plusResult.y, 7)
    }

    @Test
    @DisplayName("plus 연산자만 오버로딩해도, += 연산자를 사용할 수 있다.")
    fun test4(){
        // Given
        var pointPlus1 = PointPlus(1, 3)
        val pointPlus2 = PointPlus(2, 4)

        // When
        // * 해당 연산은 point1 = point1 + point2와 같으므로, point1은 var로 선언되어야 한다.
        // * 단, PointPlus에 plus와 같은 파라미터를 갖는 plusAssign 메서드가 있는 경우, 컴파일 에러가 발생한다.
        // * PointPlus의 주석 처리된 메서드를 주석 해제하면, 아래 코드에서 컴파일 에러가 발생한다.
        // * 하지만, 파라미터 같은 plusAssign 메서드가 있더라도, pointPlus1을 val로 바꾸면, 주석 처리되어 있는 plusAssign 메서드가 호출된다.
        pointPlus1 += pointPlus2

        // Then
        assertEquals(pointPlus1.x, 3)
        assertEquals(pointPlus1.y, 7)
    }

    @Test
    @DisplayName("PlusAssign 메서드를 정의하여, += 연산이 새로운 참조를 반환하지 않도록 할 수 있다.")
    fun test5(){
        // Given
        val pointPlusAssign1 = PointPlusAssign(1, 3)
        val pointPlusAssign2 = PointPlusAssign(2, 4)

        // When
        pointPlusAssign1 += pointPlusAssign2

        // Then
        assertEquals(pointPlusAssign1.x, 3)
        assertEquals(pointPlusAssign1.y, 7)
    }
}