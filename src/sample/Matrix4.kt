package sample

import kotlin.math.cos
import kotlin.math.sin

class Matrix4 {

    private val values = Array(4) { Array(4) { 0.0 } }

    fun add(matrix4: Matrix4) {
        this.foreachIndexed2d { i, j, _ ->
            values[i][j] += matrix4.values[i][j]
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

    fun add(i : Int, j : Int, value : Double) {
        set(i,j, this[i, j] + value)
    }

    fun set( matrix : Matrix4){
        matrix.values.forEachIndexed { i, row ->
            row.forEachIndexed { j, value ->
                values[i][j] = value
            }
        }
    }

    fun foreachIndexed2d( action : (i : Int, j : Int, Double ) -> Unit){
        values.forEachIndexed { i, raw ->
            raw.forEachIndexed { j, _ ->
                action(i,j, values[i][j])
            }
        }
        this[3,2]
    }



    companion object{
        fun identity() : Matrix4 {
            val matrix4 = Matrix4()
            matrix4[0, 0] = 1.0
            matrix4[1, 1] = 1.0
            matrix4[2, 2] = 1.0
            matrix4[2, 2] = 1.0
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