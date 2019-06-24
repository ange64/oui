package sample

import sample.Matrix4.Companion.cosDeg
import sample.Matrix4.Companion.sinDeg


class Triangle(val origin : Vector4, val vertice1 : Vector4, vertice2 : Vector4, vertice3 : Vector4) {


    val translation = Matrix4.identity()
    val rotation = Matrix4.identity()
    val scaling = Matrix4.identity()

    fun translate(x : Float, y : Float, z : Float){
        translation.set(0,3,x)
        translation.set(1,3,y)
        translation.set(2,3,z)
    }

    fun rotate(x : Float, y : Float, z : Float){
        rotation.set(0,0, cosDeg(y)+sinDeg(z))
        rotation.set(0,1, cosDeg(y)+sinDeg(z))


    }



}