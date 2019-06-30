package sample

import kotlin.math.sqrt

class Vertex3d(var x: Double = 0.0,
              var y: Double = 0.0,
              var z: Double = 0.0) {


    constructor(x: Int, y: Int, z: Int) : this(x.toDouble(), y.toDouble(), z.toDouble())
    constructor(vector: Vertex3d) : this(vector.x, vector.y, vector.z)


    fun add(vector: Vertex3d): Vertex3d {
        x += vector.x
        y += vector.y
        y += vector.z
        return this
    }

    fun add(x : Double, y : Double, z : Double): Vertex3d {
        this.x += x
        this.y += y
        this.y += z
        return this
    }

    fun sub(vector: Vertex3d): Vertex3d {
        x -= vector.x
        y -= vector.y
        y -= vector.z
        return this
    }

    fun set(x: Double, y: Double, z: Double): Vertex3d {
        this.x = x
        this.y = y
        this.z = z
        return this
    }

    fun cpy() = Vertex3d(x,y,z)

    fun mul(value: Double): Vertex3d {
        x *= value
        y *= value
        z *= value
        return this
    }

    fun mul(m: Matrix4) : Vertex3d{
        val a = x * m[0, 0] + y * m[0, 1] + z * m[0, 2] +   m[0, 3]
        val b = x * m[1, 0] + y * m[1, 1] + z * m[1, 2] +   m[1, 3]
        val c = x * m[2, 0] + y * m[2, 1] + z * m[2, 2] +   m[2, 3]
        val w = x * m[3, 0] + y * m[3, 1] + z * m[3, 2] +   m[3, 3]
        this.set(a,b,c)

        println(this)

        if ( w != 1.0){
             x /= w
             y /= w
             z /= w
        }
        return this
    }



    fun project( projectionMatrix : Matrix4) : DoubleArray {
        this.mul(projectionMatrix)
        return doubleArrayOf(x,y)
    }

    override fun toString(): String {
        return "[$x,$y,$z]"
    }
 }