package operator.binary.comparable

data class Person(private val age: Int) : Comparable<Person>{
    override fun compareTo(other: Person): Int {
        return compareValuesBy(this, other,
            Person::age)
    }
}
