package main.kotlin

import java.awt.event.MouseEvent
import java.awt.event.MouseListener

/*
val s = object: MouseListener
{
    override fun mouseReleased(p0: MouseEvent?) {
        TODO("Not yet implemented")
    }

    override fun mouseEntered(p0: MouseEvent?) {
        TODO("Not yet implemented")
    }

    override fun mouseClicked(p0: MouseEvent?) {
        TODO("Not yet implemented")
    }

    override fun mouseExited(p0: MouseEvent?) {
        TODO("Not yet implemented")
    }

    override fun mousePressed(p0: MouseEvent?) {
        TODO("Not yet implemented")
    }

}
*/


class AdHoc()
{
    /*private fun useAdHoc() = object
    {
        val x = 5
        val y = 9
    }

    fun adHoc()
    {
        val obj = useAdHoc()
        obj.x
        obj.y
    }*/

    private fun useAdHoc() = object
    {
        val x = 5
        val y = 9
        val z = 10
    }

    fun useAdHoc2()
    {
        val obj = object {
            val x = 5
            val y = 8
        }
    }

    fun adHoc()
    {
        val obj = useAdHoc()
        obj.x
        obj.y
        obj.z
    }

}

object UtilFile
{
    const val NAME_FILE = "test.txt"

    fun read()
    {
        println("leyendo el archivo")
    }

    fun write()
    {
        println("Escribiendo el archivo")
    }
}

fun main()
{
    UtilFile.read()
    UtilFile.write()
}