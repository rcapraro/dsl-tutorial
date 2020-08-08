class User {
    var firstName: String = ""
    var lastName: String = ""
    var age: Int = 0

    override fun toString(): String {
        return "$firstName $lastName ($age years old)"
    }
}

fun createUser(setup: User.() -> Unit): User {
    val user = User()
    user.setup()
    return user
}

val setupUser: User.() -> Unit = {
    firstName = "Richard"
    lastName = "Capraro"
    age = 45
}

fun main() {
    createUser {
        setupUser
    }
}