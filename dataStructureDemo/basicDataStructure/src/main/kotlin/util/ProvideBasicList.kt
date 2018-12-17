package util

val intList = listOf<Int>(77,99,88,45,666,8869,1001,444,354,1)

val stringList = listOf<String>("hello","data","structure","world","good",
        "study","day","up","188","@")

val personList: List<Person>
    get() = listOf<Person>(person1, person2, person3, person4, person5, person6)

// 提供两个person对象给操作使用
val  per1 = Person("李栖晨",2,"焦作",false)
val  per2 = Person("赵建光",24,"青岛")

data class Person(var name:String,var age:Int,var add:String,var isMan:Boolean = true)

private var person1 = Person("李斌斌",25,"焦作")
private var person2 = Person("陈嘉斌",22,"上海")
private var person3 = Person("谢鸿宇",20,"焦作",false)
private var person4 = Person("李明",40,"厦门")
private var person5 = Person("李兴明",37,"北京")
private var person6 = Person("李豆豆",24,"郑州",false)