package sample


class Triangle(val vertex1: Vertex3d, val vertex2: Vertex3d, val vertex3: Vertex3d)  {


    constructor(x1: Double, y1: Double, z1: Double,
                x2: Double, y2: Double, z2: Double,
                x3: Double, y3: Double, z3: Double) :
            this(Vertex3d(x1, y1, z1), Vertex3d(x2, y2, z2), Vertex3d(x3, y3, z3))


    override fun toString(): String {
        return "[ $vertex1 , $vertex2, $vertex3 ]"
    }


}