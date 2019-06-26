package sample

import kotlin.math.cos
import kotlin.math.sin


class Triangle(val vertice1 : Vector4, val vertice2 : Vector4, val vertice3 : Vector4) : Movable() {

    private val origin = Vector4()
    private val scaling = Matrix4.identity()



    fun scale( x : Double, y : Double, z : Double){
        scaling[0, 0] = x
        scaling[1, 1] = y
        scaling[2, 2] = z
    }

    override fun toString(): String {
        return "[ $vertice1 , $vertice2, $vertice3 ]"
    }


    fun project(matrix4: Matrix4) : DoubleArray{
        return vertice1.project(matrix4) + vertice2.project(matrix4) + vertice3.project(matrix4)
    }


}