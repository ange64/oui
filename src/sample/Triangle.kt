package sample

import javafx.geometry.Point3D
import kotlin.math.cos
import kotlin.math.sin


class Triangle(val vertice1 : Vector4, val vertice2 : Vector4, val vertice3 : Vector4) {

    private val origin = Vector4()
    private val translation = Matrix4.identity()
    private val rotation = Matrix4.identity()
    private val scaling = Matrix4.identity()
    val vertices  = arrayOf(vertice1,vertice2, vertice3)



    fun translate(x : Double, y : Double, z : Double){
        translation[0, 3] = x
        translation[1, 3] = y
        translation[2, 3] = z
    }

    fun setRotation(x : Double, y : Double, z : Double){
        rotation[0, 0] = + 1 + cos(y) + cos(z)
        rotation[0, 1] = -sin(z)
        rotation[0, 2] = sin(z)

        rotation[1, 0] = sin(z)
        rotation.set(1,1, cos(x) + 1 + cos(z))
        rotation.set(1,2, -sin(x))

        rotation.set(2,0, -sin(y))
        rotation.set(2,1,  sin(x))
        rotation.set(2,2, cos(x) + cos(y) + 1)
    }

    fun rotate(x : Double, y : Double, z : Double) {
        rotation.add(0,0, cos(y) + cos(z) )
        rotation.add(0,1, -sin(z))
        rotation.add(0,2,  sin(z))

        rotation.add(1,0,  sin(z))
        rotation.add(1,1, cos(x) + cos(z))
        rotation.add(1,2, -sin(x))

        rotation.add(2,0, -sin(y))
        rotation.add(2,1,  sin(x))
        rotation.add(2,2, cos(x) + cos(y))
    }

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