package sample

import kotlin.math.cos
import kotlin.math.sin

abstract class Transformable {

    val translation = Matrix4.identity()
    val rotationX = Matrix4.identity()
    val rotationY = Matrix4.identity()
    val rotationZ = Matrix4.identity()
    val rotation : Matrix4
        get() = rotationX.cpy().mul(rotationY).mul(rotationZ)
    val scaling = Matrix4.identity()
    val origin = Vertex3d()

    open val combined: Matrix4
        get() {
            val tmp = translation.cpy()
            tmp[0,3] += origin.x
            tmp[1,3] += origin.y
            tmp[2,3] += origin.z
            return tmp.mul(rotation).mul(scaling)
        }

    fun translate(x: Double, y: Double, z: Double) {
        translation[0, 3] += x
        translation[1, 3] += y
        translation[2, 3] += z
    }

    fun scale(x: Double, y: Double, z: Double) {
        scaling[0, 0] = x
        scaling[1, 1] = y
        scaling[2, 2] = z
    }


    fun setRotationX( angle : Double){
        rotationX[1, 1] = cos(angle)
        rotationX[1, 2] = -sin(angle)
        rotationX[2, 1] = sin(angle)
        rotationX[2, 2] = cos(angle)
    }

    fun setRotationY( angle : Double){
        rotationY[0, 0] = cos(angle)
        rotationY[0, 2] = sin(angle)
        rotationY[2, 0] = -sin(angle)
        rotationY[2, 2] = cos(angle)
    }

    fun setRotationZ( angle : Double){
        rotationZ[0, 0] += cos(angle)
        rotationZ[0, 1] += -sin(angle)
        rotationZ[1, 0] += sin(angle)
        rotationZ[1, 1] += cos(angle)
    }





}