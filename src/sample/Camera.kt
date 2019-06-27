package sample

class Camera : Movable(){

    val projection = Matrix4.projection2d

    init {
    }

    val combined  : Matrix4
        get() =  translation.cpy().mul(rotation).mul(projection)


}