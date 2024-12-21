open class Animal {
     fun glgl() {
        println("fafs")
    }
}

open class Mammal: Animal() {

}
open class Fish: Animal()
open class Bird: Animal()

class Lion: Mammal()

class Salmon: Fish()
class Carp: Fish()

class Eagle: Bird()