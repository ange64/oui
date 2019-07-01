package sample

import java.lang.Exception

open class Mesh(vararg vertices: Double) : Transformable() {

    val modelMatrix: Matrix4
        get() = super.combined

    val triangles = mutableListOf<Triangle>()

    init {
        if (vertices.size % 9.0 != 0.0) {
            throw Exception("invalid number of vertices")
        }
        for (i in 0 until vertices.size step 9) {
            triangles.add(
                    Triangle(
                            vertices[i], vertices[i + 1], vertices[i + 2],
                            vertices[i + 3], vertices[i + 4], vertices[i + 5],
                            vertices[i + 6], vertices[i + 7], vertices[i + 8]
                    )
            )
        }
    }

}