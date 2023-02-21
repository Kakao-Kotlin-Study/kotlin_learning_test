package operator.binary.collection

import org.hamcrest.CoreMatchers.hasItem
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import kotlin.test.assertContains
import org.hamcrest.CoreMatchers.not
import org.hamcrest.MatcherAssert.assertThat
import org.hamcrest.Matchers
import org.junit.jupiter.api.Assertions
import kotlin.test.assertEquals

class ImmutableListTest {
    @Test
    @DisplayName("ImmutableList에 대한 + 연산으로 기존 리스트에 원소를 추가할 수 없다.")
    fun test1(){
        // Given
        val immutableList = listOf(1, 2, 3)
        val addTarget = 5

        // When
        immutableList + addTarget

        // Then
        assertThat(immutableList, not(hasItem(addTarget)))
    }

    @Test
    @DisplayName("ImmutableList에 대한 + 연산은 원소가 추가된 새로운 리스트를 반환한다.")
    fun test2(){
        // Given
        val immutableList = listOf(1, 2, 3)
        val addTarget = 5

        // When
        val added = immutableList + addTarget

        // Then
        assertContains(added, addTarget)
        assertThat(immutableList, not(hasItem(addTarget)))
    }

    @Test
    @DisplayName("+= 연산자를 이용하여 ImmutableList에 원소를 추가하려면 레퍼런스를 변경해야한다.")
    fun test3(){
        // Given
        // * var 선언
        var immutableList = listOf(1, 2, 3)
        val addTarget = 5

        // When
        immutableList += addTarget

        // Then
        assertContains(immutableList, addTarget)
    }

    @Test
    @DisplayName("ImmutableList에 대한 += 연산으로 기존 리스트에 새로운 리스트를 추가할 수 있다.")
    fun test4(){
        // Given
        // * var 선언
        var mutableList = listOf(1, 2, 3)
        val addTargets = listOf(10, 11)

        // When
        mutableList += addTargets

        // Then
        addTargets.forEach{ elem -> assertContains(mutableList, elem) }
    }

    @Test
    @DisplayName("ImmutableList에 대한 - 연산으로 기존 리스트에서 원소를 제거할 수 없다.")
    fun test5(){
        // Given
        val immutableList = listOf(1, 2, 3)
        val removeTarget = immutableList[0]

        // When
        immutableList - removeTarget

        // Then
        assertContains(immutableList, removeTarget)
    }

    @Test
    @DisplayName("ImmutableList에 대한 - 연산은 원소가 제거된 새로운 리스트를 반환한다.")
    fun test6(){
        // Given
        val immutableList = listOf(1, 2, 3)
        val removeTarget = immutableList[0]

        // When
        val removed = immutableList - removeTarget

        // Then
        assertContains(immutableList, removeTarget)
        assertThat(removed, not(hasItem(removeTarget)))
    }


    @Test
    @DisplayName("ImmutableList에 대한 -= 연산으로 기존 리스트에서 원소를 제거할 수 없다.")
    fun test7(){
        // Given
        // * var 선언
        var immutableList = listOf(1, 2, 3)
        val removeTarget = immutableList[0]

        // When
        immutableList -= removeTarget

        // Then
        assertThat(immutableList, not(hasItem(removeTarget)))
    }

    @Test
    @DisplayName("ImmutableList에 대한 -= 연산으로 기존 리스트에서 특정 리스트의 모든 원소를 제거할 수 있다.")
    fun test8(){
        // Given
        // * var 선언
        var immutableList = listOf(1, 2, 3)
        val removeTargets = listOf(2, 3)

        // When
        immutableList -= removeTargets

        // Then
        removeTargets.forEach{ elem -> assertThat(immutableList, Matchers.not(Matchers.hasItem(elem))) }
    }
}