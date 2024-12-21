fun main() {
    val name: String? = null
    val age: Int? = name?.length
    val result: Int? = age?.plus(3)
    print(result)
}