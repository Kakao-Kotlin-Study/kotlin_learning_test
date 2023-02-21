package operator.binary.point;

import operator.binary.point.PointPlus;
import operator.binary.point.PointPlusExtensionKt;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class PointJavaTest {
    @Test
    @DisplayName("관례를 따르는 메서드명을 사용하여 코틀린의 연산자 오버로딩 메서드를 호출할 수 있다.")
    void test1(){
        // Given
        PointPlus pointPlus1 = new PointPlus(3, 4);
        PointPlus pointPlus2 = new PointPlus(2, 6);

        // When
        PointPlus plusResult = pointPlus1.plus(pointPlus2);

        // Then
        Assertions.assertEquals(plusResult.getX(), 5);
        Assertions.assertEquals(plusResult.getY(), 10);
    }

    @Test
    @DisplayName("확장함수를 호출하려면 Static 메서드를 이용하여 호출할 수 있다.")
    void test2(){
        // Given
        PointPlus pointPlus1 = new PointPlus(3, 4);
        double scale = 3.0;

        // When
        PointPlus timesResult = PointPlusExtensionKt.times(pointPlus1, scale);

        // Then
        Assertions.assertEquals(timesResult.getX(), 9);
        Assertions.assertEquals(timesResult.getY(), 12);
    }
}
