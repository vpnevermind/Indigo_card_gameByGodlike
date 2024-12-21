import java.util.Scanner

fun main(args: Array<String>) {
    val input = Scanner(System.`in`)
    val title = input.nextLine()
    val author = input.nextLine()
    val pages = input.nextInt()

    val book = Book(title, author, pages)
    println(book.description)
}

class Book(title: String, author: String, pages: Int) {
    val description = "$title by $author has $pages pages"
}