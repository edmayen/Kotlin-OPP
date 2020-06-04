package main.kotlin

import java.time.Year

abstract class Person(name: String, lastName: String)
{
    private var _fullName: String = ""

    var fullName: String
        get() = _fullName
        set(value)
        {
            if (value.isNotEmpty())
            {
                _fullName = value
            }
        }

    init {
        _fullName = "$name $lastName"
    }

    constructor(name: String, lastName: String, age: Int): this(name, lastName)
    {
        _fullName = "$name $lastName tiene $age años"
    }

    override fun toString() = _fullName

    abstract fun getRole(): String
}

class Pilot(name: String, lastName: String, private val experienceYears: Int): Person(name, lastName)
{
    companion object {
        const val COPILOTO = "Copiloto"
        const val CAPITAN = "Capitan"
    }

    override fun getRole() =
        when(experienceYears)
        {
            in 1..5 -> Companion.COPILOTO
            else -> CAPITAN
        }

    override fun toString() = "$fullName tiene $experienceYears de experiencia y su rol es ${getRole()}"
}

class FlightAttendant(name: String, lastName: String, val age: Int): Person(name, lastName, age)
{

    override fun getRole() =
        when(age)
        {
            in 20..30 -> Companion.LEADER
            else -> Companion.ASSISTANT
        }

    companion object {
        const val LEADER = "Lider"
        const val ASSISTANT = "Asistente"
    }

}

interface AirPlane
{
    val brand: String

    fun raising()
    fun landing()
    infix fun accelarate(velocity: Int)

    fun calling(){
        print("Llamando a la torre de control $brand")
    }
}



class AirPlaneSmall(private val airCompany: String, private val code: String, private val pilot: Person): AirPlane{
    override val brand: String
        get() = "Boeing"

    override fun raising() {
        println("Elevando el avion con codigo $code y el piloto es ${pilot}")
    }

    override fun landing() {
        calling()
        println("Aterrizando el avion con codigo $code")
    }

    override fun accelarate(velocity: Int) {
        println("Acelerando el avion con codigo $code")
    }

}

fun FactoryPeople(role: Int): Person =
    when(role)
    {
        1 -> Pilot("Juan", "Gomez", 3)
        else -> FlightAttendant("pepito", "Perez", 25)
    }

fun main() {
    val pilot = FactoryPeople(1)
    val flightAttendant = FactoryPeople(2)
    val airPlane = AirPlaneSmall("Avianca", "0001", pilot)

    airPlane.raising()
    airPlane accelarate 100
    println(pilot.getRole())
    println(flightAttendant.getRole())



}