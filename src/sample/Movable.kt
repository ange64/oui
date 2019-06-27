package sample

import kotlin.math.cos
import kotlin.math.sin

abstract class Movable {


     val translation = Matrix4.identity()
     val rotation = Matrix4.identity()


    fun translate(x : Double, y : Double, z : Double){
        translation[0, 3] += x
        translation[1, 3] += y
        translation[2, 3] += z

    }

    fun setRotation(x : Double, y : Double, z : Double){
        rotation[0, 0] = + 1 + cos(y) + cos(z)
        rotation[0, 1] = -sin(z)
        rotation[0, 2] = sin(z)

        rotation[1, 0] = sin(z)
        rotation[1, 1] = cos(x) + 1 + cos(z)
        rotation[1, 2] = -sin(x)

        rotation[2, 0] = -sin(y)
        rotation[2, 1] = sin(x)
        rotation[2, 2] = cos(x) + cos(y) + 1
    }

    fun rotate(x : Double, y : Double, z : Double) {
        rotation[0,0] += cos(y) + cos(z) 
        rotation[0,1] += -sin(z)
        rotation[0,2] +=  sin(z)

        rotation[1,0] += sin(z)
        rotation[1,1] += cos(x) + cos(z)
        rotation[1,2] += -sin(x)

        rotation[2,0] += sin(y)
        rotation[2,1] += sin(x)
        rotation[2,2] += cos(x) + cos(y)
    }


}