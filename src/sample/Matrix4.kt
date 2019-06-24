package sample

import kotlin.math.cos
import kotlin.math.sin

class Matrix4 {

    private val values = Array(4) { Array(4) { 0f } }



    fun add(matrix4: Matrix4) {
        values.forEachIndexed { i, raw ->
            raw.forEachIndexed { j, _ ->
                values[i][j] += matrix4.values[i][j]
            }
        }
    }

    fun get( i : Int, j : Int) : Float{
        return values[i][j]
    }

    fun set ( i : Int, j : Int, value : Float){
        values[i][j] = value
    }


    companion object{
        fun identity() : Matrix4 {
            val matrix4 = Matrix4()
            matrix4.set(0,0,1f)
            matrix4.set(1,1, 1f)
            matrix4.set(2,2, 1f)
            matrix4.set(2,2, 1f)
            return matrix4
        }

        fun cosDeg(float: Float) : Float{
            return Math.toDegrees(cos(float.toDouble())).toFloat()
        }

        fun sinDeg(float: Float) : Float{
            return Math.toDegrees(sin(float.toDouble())).toFloat()
        }



    }


}