package sample

import kotlin.math.cos
import kotlin.math.sin

abstract class Transformable {


    val origin = Vertex3d()
    val rotation = Vertex3d()
    val position = Vertex3d()
    val scale = Vertex3d(1,1,1)

    open val combined: Matrix4
        get() {
            val translation = Matrix4.identity()
            val rotationX = Matrix4.identity()
            val rotationY = Matrix4.identity()
            val rotationZ = Matrix4.identity()
            val scaling = Matrix4.identity()

            translation[0,3] = origin.x + position.x
            translation[1,3] = origin.y + position.y
            translation[2,3] = origin.z + position.z

            rotationX[1, 1] = cos(rotation.x)
            rotationX[1, 2] = -sin(rotation.x)
            rotationX[2, 1] = sin(rotation.x)
            rotationX[2, 2] = cos(rotation.x)

            rotationY[0, 0] = cos(rotation.y)
            rotationY[0, 2] = sin(rotation.y)
            rotationY[2, 0] = -sin(rotation.y)
            rotationY[2, 2] = cos(rotation.y)

            rotationZ[0, 0] = cos(rotation.z)
            rotationZ[0, 1] = -sin(rotation.z)
            rotationZ[1, 0] = sin(rotation.z)
            rotationZ[1, 1] = cos(rotation.z)

            scaling[0, 0] = scale.x
            scaling[1, 1] = scale.y
            scaling[2, 2] = scale.z

            return translation * rotationZ * rotationY * rotationX * scaling
        }



}