package main.kotlin

open class Employee(name: String, lastName: String)

data class Manager(val  name: String, val lastName: String, val age: Int): Employee(name, lastName)

data class Company(val name: String, val phone: String, val addresses: List<Address>)

data class Address(val street: String = "", val city: String = "", val country: String = "")

fun main()
{
    val addresses = ArrayList<Address>().apply {
        add(Address(street = "Valle 59", country = "MX"))
        add(Address(street = "Valle33", country = "MX", city = "CDMX"))
        add(Address("Valle 59", "Cali", "Colombia"))
    }

    val employee = Employee("Juan", "Gomez")



    val company = Company( "Devhack", "2222233333", addresses )
    println(company)
}