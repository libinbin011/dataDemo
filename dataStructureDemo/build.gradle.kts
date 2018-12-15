//subprojects 闭包是给每一个子模块配置，就是所有子模块共用的配置可以写在这个闭包中
// 需要注意 dependencies  ， repositories这两个个闭包属于特殊情况  只能写在各自的配置文件中 不可以提取公共部分写在这

subprojects{

    // 但是目前写的这种导入依赖方式idea支持的不是太好，暂时不考虑脚本提取了
    // 下次练习一下使用另一种导入依赖的脚本表达方式
    plugins {
        kotlin("jvm") version "1.2.71"
    }


}