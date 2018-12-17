package linearStructure

import org.junit.Test
import util.*
import org.junit.Assert.*


class SingleLinkedWithHeadTest{
    lateinit var intLink:SingleLinkedWithHead<Int>
    lateinit var strLink:SingleLinkedWithHead<String>
    lateinit var personLink:SingleLinkedWithHead<Person>
    fun init(){
        intLink = SingleLinkedWithHead<Int>()
        strLink = SingleLinkedWithHead<String>()
        personLink = SingleLinkedWithHead<Person>()

        intList.forEach{
            intLink.createFromTail(it)
        }

        stringList.forEach{
            strLink.createFromTail(it)
        }
        personList.forEach{
            personLink.createFromTail(it)
        }
    }

    @Test
    fun testCreate(){

        init()
        assertEquals(1,intLink.findLast()?.data)
        assertEquals("@",strLink.findLast()?.data)
        assertEquals(Person("李豆豆",24,"郑州",false),personLink.findLast()?.data)

        intList.forEach{

            assertEquals(intList.indexOf(it), intLink.getIndex(it))

        }
        (0..9).forEach {
            assertEquals(intList[it],intLink.getByIndex(it)?.data)
            assertEquals(stringList[it],strLink.getByIndex(it)?.data)
        }
        (0..5).forEach {
            assertEquals(personList[it],personLink.getByIndex(it)?.data)
        }

        assertEquals(10,intLink.length())
        assertEquals(10,strLink.length())
        assertEquals(6,personLink.length())

        intLink.createFromHead(198887)
        assertEquals(11,intLink.length())
        assertEquals(198887,intLink.getByIndex(0)?.data)

        strLink.createFromHead("这个单元测试不好写啊")
        assertEquals(11,strLink.length())
        assertEquals("这个单元测试不好写啊",strLink.getByIndex(0)?.data)

        personLink.createFromHead(per1)
        assertEquals(7,personLink.length())
        assertEquals(per1,personLink.getByIndex(0)?.data)
    }


    @Test
    fun testInsert(){
        init()
        var a = 584
        var b = "中间插入测试"

        intLink.insert(5,a)
        strLink.insert(5,b)
        personLink.insert(5, per1)


        for (i in 0..4){
            assertEquals(intList[i],intLink.getByIndex(i)?.data)
            assertEquals(stringList[i],strLink.getByIndex(i)?.data)
            assertEquals(personList[i],personLink.getByIndex(i)?.data)
        }
        assertEquals(a,intLink.getByIndex(5)?.data)
        assertEquals(b,strLink.getByIndex(5)?.data)
        assertEquals(per1,personLink.getByIndex(5)?.data)
        assertEquals(Person("李豆豆",24,"郑州",false),personLink.getByIndex(6)?.data)


        for (i in 6..10){
            assertEquals(intList[i-1],intLink.getByIndex(i)?.data)
            assertEquals(stringList[i-1],strLink.getByIndex(i)?.data)
        }
    }

    @Test
    fun testDelete(){
        testInsert()

        intLink.delete(5)
        strLink.delete(5)
        personLink.delete(5)

        (0..5).forEach {
            assertEquals(intList[it],intLink.getByIndex(it)?.data)
            assertEquals(stringList[it],strLink.getByIndex(it)?.data)
            assertEquals(personList[it],personLink.getByIndex(it)?.data)
        }
        (6..9).forEach {
            assertEquals(intList[it],intLink.getByIndex(it)?.data)
            assertEquals(stringList[it],strLink.getByIndex(it)?.data)
        }
    }

    @Test
    fun testDeleteByData(){
        testInsert()

        intLink.deleteByData(584)
        strLink.deleteByData("中间插入测试")
        personLink.deleteByData(per1)
        assertEquals(10,intLink.length())

        (0..5).forEach {
            assertEquals(intList[it],intLink.getByIndex(it)?.data)
            assertEquals(stringList[it],strLink.getByIndex(it)?.data)
            assertEquals(personList[it],personLink.getByIndex(it)?.data)
        }
        (6..9).forEach {
            assertEquals(intList[it],intLink.getByIndex(it)?.data)
            assertEquals(stringList[it],strLink.getByIndex(it)?.data)
        }

    }


    @Test
    fun testClear(){
        init()
        intLink.clear()
        strLink.clear()
        personLink.clear()

        assertEquals(0,intLink.length())
        assertEquals(0,strLink.length())
        assertEquals(0,personLink.length())
    }

    @Test
    fun testDeleteLast(){
        testInsert()
        var a = 584
        var b = "中间插入测试"

        intLink.insert(7,a)
        strLink.insert(7,b)
        personLink.insert(3, per1)
        intLink.insert(10,a)
        strLink.insert(10,b)
        personLink.insert(1, per1)

        intLink.deleteLast(a)
        strLink.deleteLast(b)
        personLink.deleteLast(per1)

        assertEquals(12,intLink.length())

        assertEquals(intList[0],intLink.getByIndex(0)?.data)
        assertEquals(intList[1],intLink.getByIndex(1)?.data)
        assertEquals(intList[2],intLink.getByIndex(2)?.data)
        assertEquals(intList[3],intLink.getByIndex(3)?.data)
        assertEquals(intList[4],intLink.getByIndex(4)?.data)
        assertEquals(a,intLink.getByIndex(5)?.data)
        assertEquals(intList[5],intLink.getByIndex(6)?.data)
        assertEquals(a,intLink.getByIndex(7)?.data)
        assertEquals(intList[6],intLink.getByIndex(8)?.data)
        assertEquals(intList[7],intLink.getByIndex(9)?.data)
        assertEquals(intList[8],intLink.getByIndex(10)?.data)
        assertEquals(intList[9],intLink.getByIndex(11)?.data)


        assertEquals(stringList[0],strLink.getByIndex(0)?.data)
        assertEquals(stringList[1],strLink.getByIndex(1)?.data)
        assertEquals(stringList[2],strLink.getByIndex(2)?.data)
        assertEquals(stringList[3],strLink.getByIndex(3)?.data)
        assertEquals(stringList[4],strLink.getByIndex(4)?.data)
        assertEquals(b,strLink.getByIndex(5)?.data)
        assertEquals(stringList[5],strLink.getByIndex(6)?.data)
        assertEquals(b,strLink.getByIndex(7)?.data)
        assertEquals(stringList[6],strLink.getByIndex(8)?.data)
        assertEquals(stringList[7],strLink.getByIndex(9)?.data)
        assertEquals(stringList[8],strLink.getByIndex(10)?.data)
        assertEquals(stringList[9],strLink.getByIndex(11)?.data)

        assertEquals(personList[0],personLink.getByIndex(0)?.data)
        assertEquals(per1,personLink.getByIndex(1)?.data)
        assertEquals(personList[1],personLink.getByIndex(2)?.data)
        assertEquals(personList[2],personLink.getByIndex(3)?.data)
        assertEquals(per1,personLink.getByIndex(4)?.data)
        assertEquals(personList[3],personLink.getByIndex(5)?.data)
        assertEquals(personList[4],personLink.getByIndex(6)?.data)
        assertEquals(personList[5],personLink.getByIndex(7)?.data)
    }

    @Test
    fun testAllDefSpecialParameters(){
        init()
        assertEquals(intList[0],intLink.getByIndex(-5)?.data)
        assertEquals(intList[0],intLink.getByIndex(-8)?.data)
        assertEquals(intList[0],intLink.getByIndex(0)?.data)
        assertEquals(intList[0],intLink.getByIndex(-1)?.data)

        assertEquals(intList[8],intLink.getByIndex(8)?.data)
        assertEquals(intList[9],intLink.getByIndex(9)?.data)
        assertEquals(intList[9],intLink.getByIndex(10)?.data)
        assertEquals(intList[9],intLink.getByIndex(11)?.data)

        assertEquals(0,intLink.getIndex(intList[0]))
        assertEquals(-1,intLink.getIndex(1854))

        strLink.insert(-100,"实际插入到第一个")
        strLink.insert(100,"实际最后一个")

        assertEquals(12,strLink.length())
        assertEquals("实际插入到第一个",strLink.getByIndex(0)?.data)
        assertEquals(stringList[0],strLink.getByIndex(1)?.data)
        assertEquals(stringList[9],strLink.getByIndex(10)?.data)
        assertEquals("实际最后一个",strLink.getByIndex(11)?.data)
        assertEquals("实际最后一个",strLink.getByIndex(12)?.data)

        strLink.delete(100)
        strLink.delete(-100)

        assertEquals(12,strLink.length())

        strLink.deleteByData("654679")
        strLink.deleteLast("654679")
        assertEquals(12,strLink.length())


        intLink.clear()
        strLink.clear()
        personLink.clear()

        assertEquals(0,intLink.length())
        assertEquals(0,strLink.length())
        assertEquals(0,personLink.length())

        intLink.deleteLast(54)
        intLink.delete(152)
        intLink.deleteByData(77)


        assertEquals(null,intLink.getByIndex(132))
        assertEquals(null,intLink.getByIndex(0))

        assertEquals(-1,intLink.getIndex(0))
        assertEquals(-1,intLink.getIndex(156))
        assertEquals(-1,intLink.getIndex(-156))


    }
}