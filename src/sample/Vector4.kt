package sample

class Vector4(var x : Float, var y : Float, var z : Float) {

    var w : Int = 1

    fun add( vector : Vector4){
        x += vector.x
        y += vector.y
        y += vector.z
    }

    fun sub( vector: Vector4){
        x -= vector.x
        y -= vector.y
        y -= vector.z
    }


}