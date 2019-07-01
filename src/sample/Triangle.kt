package sample


class Triangle(val vertex1 : Vertex3d, val vertex2 : Vertex3d, val vertex3 : Vertex3d) : Transformable() {


    val modelMatrix : Matrix4
        get() = super.combined

    override fun toString(): String {
        return "[ $vertex1 , $vertex2, $vertex3 ]"
    }


}