package sample

class Camera : Transformable(){

    val projection = Matrix4.projection2d

    init {
    }

    override val combined  : Matrix4
        get() =  super.combined.mul(projection)


}