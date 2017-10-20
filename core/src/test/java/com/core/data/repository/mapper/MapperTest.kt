package com.core.data.repository.mapper

import org.junit.Test
import org.junit.Assert.*

/**
 * Created by jhonnybarrios on 31-08-17.
 */
class MapperTest {

    class MockMapper : Mapper<Long, String>() {
        override fun map(value: Long): String = value.toString()

        override fun reverseMap(value: String): Long = value.toLong()
    }

    @Test
    fun mappingObjects() {
        val mapper =MockMapper()
        val string = "45"
        val long = mapper.reverseMap(string)
        assertTrue(long == 45L)
        assertTrue(mapper.map(long) == string)
    }

    @Test
    fun mappingLists() {
        val stringList=listOf("1", "2", "3")
        val mapper =MockMapper()
        val longList = mapper.reverseMap(stringList)
        assertTrue(longList == listOf(1L, 2L, 3L))
        assertTrue(mapper.map(longList)==stringList)
    }
}