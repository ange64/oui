package sample

import javafx.scene.Group
import javafx.scene.shape.Polygon

class ModelDrawer(val context : Group) {


    private val triangleMap = HashMap<Triangle,Polygon>()
    var projectionMatrix = Matrix4.identity()

    fun draw( triangle: Triangle){

        val totalMatrix = projectionMatrix.cpy() * triangle.combined
        val v1 = triangle.vertex1.cpy().project(totalMatrix)
        val v2 = triangle.vertex2.cpy().project(totalMatrix)
        val v3 = triangle.vertex3.cpy().project(totalMatrix)
        println("${v1[0]} ${v1[1]} ")

        if ( !triangleMap.containsKey(triangle)) {
            triangleMap[triangle] = Polygon(v1[0], v1[1], v2[0], v2[1], v3[0], v3[1])
            context.children.add(triangleMap[triangle])
        } else {
            triangleMap[triangle]!!.points[0] = v1[0]
            triangleMap[triangle]!!.points[1] = v1[1]
            triangleMap[triangle]!!.points[2] = v2[0]
            triangleMap[triangle]!!.points[3] = v2[1]
            triangleMap[triangle]!!.points[4] = v3[0]
            triangleMap[triangle]!!.points[5] = v3[1]
        }

    }
}