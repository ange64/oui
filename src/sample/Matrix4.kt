package sample

import kotlin.math.cos
import kotlin.math.sin

class Matrix4() {

    private val values = Array(4) { Array(4) { 0.0 } }

    constructor(matrix: Matrix4) : this() {
        this.foreachIndexed2d { i, j, _ ->
            this[i,j] =  matrix[i,j]
        }
    }

    operator fun get(i : Int, j : Int) : Double{
        return values[i][j]
    }

    operator fun set ( i : Int, j : Int, value : Double){
        values[i][j] = value
    }

    fun set( values : DoubleArray){
        foreachIndexed2d { i, j, _ ->
            this.values[i][j] = values[(i*4)+j]
        }
    }
    
    fun set( matrix : Matrix4) : Matrix4{
        matrix.foreachIndexed2d { i, j, d ->
            this[i,j] = d
        }
        return this
    }

    fun cpy() : Matrix4 {
        return Matrix4(this)
    }

    fun foreachIndexed2d( action : (i : Int, j : Int, Double ) -> Unit){
        values.forEachIndexed { i, raw ->
            raw.forEachIndexed { j, _ ->
                action(i,j, values[i][j])
            }
        }
        this[3,2]
    }

    fun mul(m: Matrix4) : Matrix4{
        val tmp = Matrix4(this)
        for( i in 0..3) {
            for( j in 0..3){
                this[i,j] = 0.0
                for ( k in 0..3){
                    this[i,j] += tmp[i,k] * m[k,j]
                }
            }
        }
        return this
    }

    override fun toString(): String {
        var string = ""
        values.forEachIndexed { i, doubles ->
            string += "["
            doubles.forEachIndexed { j, d ->
                string += " $d "
            }
            string += " ] \n"
        }
        return string
    }




    companion object{
        fun identity() : Matrix4 {
            val matrix4 = Matrix4()
            matrix4[0, 0] = 1.0
            matrix4[1, 1] = 1.0
            matrix4[2, 2] = 1.0
            matrix4[3, 3] = 1.0
            return matrix4
        }

        val projection2d = Matrix4()

        init{
            projection2d.set( doubleArrayOf(
                    1.0, 0.0,  0.0,  0.0,
                    0.0, 1.0,  0.0,  0.0,
                    0.0, 0.0,  0.0,  0.0,
                    0.0, 0.0,  0.0,  1.0
                )
            )
        }


    }



}