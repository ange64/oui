package sample


class Triangle(val vertice1 : Vector4, val vertice2 : Vector4, val vertice3 : Vector4) : Transformable() {

    private val origin = Vector4()






    override fun toString(): String {
        return "[ $vertice1 , $vertice2, $vertice3 ]"
    }


    fun project(matrix4: Matrix4) : DoubleArray{
        return vertice1.project(matrix4) + vertice2.project(matrix4) + vertice3.project(matrix4)
    }


}