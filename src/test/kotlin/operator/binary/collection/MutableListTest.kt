package operator.binary.collection

import org.hamcrest.MatcherAssert.assertThat
import org.hamcrest.Matchers.hasItem
import org.hamcrest.Matchers.not
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import kotlin.test.assertContains

class MutableListTest {
    @Test
    @DisplayName("MutableList에 대한 + 연산으로 기존 리스트에 원소를 추가할 수 없다.")
    fun test1(){
        // Given
        val mutableList = mutableListOf(1, 2, 3)
        val addTarget = 5

        // When
        mutableList + addTarget

        // Then
        assertThat(mutableList, not(hasItem(addTarget)))
    }

    @Test
    @DisplayName("MutableList에 대한 + 연산은 원소가 추가된 새로운 리스트를 반환한다.")
    fun test2(){
        // Given
        val mutableList = mutableListOf(1, 2, 3)
        val addTarget = 5

        // When
        val added = mutableList + addTarget

        // Then
        assertThat(mutableList, not(hasItem(addTarget)))
        assertContains(added, 5)
    }

    @Test
    @DisplayName("+= 연산자를 이용하여 레퍼런스 변경 없이 MutableList에 원소를 추가할 수 있다")
    fun test3(){
        // Given
        val mutableList = mutableListOf(1, 2, 3)
        val addTarget = 5

        // When
        mutableList += addTarget

        // Then
        assertContains(mutableList, addTarget)
    }

    @Test
    @DisplayName("MutableList에 대한 += 연산으로 기존 리스트에 새로운 리스트를 추가할 수 있다.")
    fun test4(){
        // Given
        val mutableList = mutableListOf(1, 2, 3)
        val addTargets = listOf(10, 11)

        // When
        mutableList += addTargets

        // Then
        addTargets.forEach{ elem -> assertContains(mutableList, elem) }
    }

    @Test
    @DisplayName("- 연산자를 이용하여 레퍼런스 변경 없이 MutableList에 원소를 제거할 수 없다.")
    fun test5(){
        // Given
        val mutableList = mutableListOf(1, 2, 3)
        val removeTarget = mutableList[0]

        // When
        mutableList - removeTarget

        // Then
        assertContains(mutableList, removeTarget)
    }

    @Test
    @DisplayName("MutableList에 대한 - 연산은 원소가 제거된 새로운 리스트를 반환한다.")
    fun test6(){
        // Given
        val mutableList = mutableListOf(1, 2, 3)
        val removeTarget = mutableList[0]

        // When
        val removed = mutableList - removeTarget

        // Then
        assertThat(removed, not(hasItem(removeTarget)))
    }

    @Test
    @DisplayName("-= 연산자를 이용하여 레퍼런스 변경 없이 MutableList에 원소를 제거할 수 있다.")
    fun test7(){
        // Given
        val mutableList = mutableListOf(1, 2, 3)
        val removeTarget = mutableList[0]

        // When
        mutableList -= removeTarget

        // Then
        assertThat(mutableList, not(hasItem(removeTarget)))
    }

    @Test
    @DisplayName("MutableList에 대한 -= 연산으로 기존 리스트에서 특정 리스트의 모든 원소를 제거할 수 있다.")
    fun test8(){
        // Given
        val mutableList = mutableListOf(1, 2, 3)
        val removeTargets = listOf(2, 3)

        // When
        mutableList -= removeTargets

        // Then
        removeTargets.forEach{ elem -> assertThat(mutableList, not(hasItem(elem))) }
    }

}