package operator.binary.comparable

import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test

class ComparableTest {
    @Test
    @DisplayName("Comaparable을 구현한 클래스의 인스턴스를 비교 연산자를 이용하여 대소를 비교할 수 있다.")
    fun test1(){
        val person1 = Person(21);
        val person2 = Person(25);

        // * 단, Comparable을 구현하지 않는 클래스인 경우, 아래 코드에서 컴파일 에러가 발생한다.
        assertTrue(person1 < person2)
    }
}