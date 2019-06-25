package sample

import kotlin.math.sqrt

class Vector4(var x: Double = 0.0,
              var y: Double = 0.0,
              var z: Double = 0.0,
              var w: Double = 1.0) {


    constructor() : this(0.0, 0.0, 0.0)
    constructor(x: Int, y: Int, z: Int) : this(x.toDouble(), y.toDouble(), z.toDouble())
    constructor(vector: Vector4) : this(vector.x, vector.y, vector.z, vector.w)


    fun add(vector: Vector4): Vector4 {
        x += vector.x
        y += vector.y
        y += vector.z
        return this
    }

    fun sub(vector: Vector4): Vector4 {
        x -= vector.x
        y -= vector.y
        y -= vector.z
        return this
    }

    fun set(x: Double, y: Double, z: Double): Vector4 {
        this.x = x
        this.y = y
        this.z = z
        return this
    }

    fun cpy() = Vector4(x,y,z,w)

    fun mul(value: Double): Vector4 {
        x *= value
        y *= value
        z *= value
        return this
    }

    fun mul(m: Matrix4) : Vector4{
        val a = x * m[0, 0] + y * m[0, 1] + z * m[0, 2] + w * m[0, 3]
        val b = x * m[1, 0] + y * m[1, 1] + z * m[1, 2] + w * m[1, 3]
        val c = x * m[2, 0] + y * m[2, 1] + z * m[2, 2] + w * m[2, 3]
        val d = x * m[3, 0] + y * m[3, 1] + z * m[3, 2] + w * m[3, 3]
        this.set(a,b,c)
        this.w = d
        return this
    }

    fun len(): Double {
        return sqrt(x * x + y * y + z * z)
    }

    fun norm(): Vector4 {
        val len = len()
        x /= len
        y /= len
        z /= len
        return this
    }

    fun project( matrix4: Matrix4) : DoubleArray {
        val tmp = this.cpy().mul(matrix4)
        return doubleArrayOf(tmp.x, tmp.y)
    }

    override fun toString(): String {
        return "[$x,$y,$z,$w]"
    }
 }