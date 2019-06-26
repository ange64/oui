package sample

class Camera : Movable(){

    val projection = Matrix4.projection2d

    val combined : Matrix4
        get() = Matrix4().add(transation)

    init {

    }
}