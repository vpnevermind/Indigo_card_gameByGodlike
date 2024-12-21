class LewisCarrollBook {
    var name = ""
        set(value) {
            field = value
            println("Now, a book called $field")
        }
        get() {
           println("The name of the book is $field")
            return field
        }
    var author = "Lewis Carroll"
        get() {
            println("The author of the book is $field")
            return field
        }
    var price = 0
    set(value) {
        field = value
        println("The new price is $field")
        }
        get() {
            println("Putting a new price...")
            return field
        }
}