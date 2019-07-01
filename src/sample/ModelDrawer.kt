package sample

import com.sun.javafx.geom.transform.BaseTransform
import javafx.scene.paint.Color;
import javafx.scene.paint.CycleMethod;
import javafx.scene.paint.LinearGradient;
import javafx.scene.paint.Stop;
import javafx.scene.Group
import javafx.scene.shape.Line
import javafx.scene.shape.Polygon
import javafx.scene.shape.Rectangle

class ModelDrawer(val context : Group, val camera : Camera) {

    private val triangleMap = HashMap<Triangle,Polygon>()

    fun draw( triangle: Triangle){

        //coordonés modèle
        val modelMatrix = triangle.modelMatrix
        //coordonnés mpnde
        val viewMatrix = camera.viewMatrix
        //coordonés camera
        val projectionMatrix = camera.projectionMatrix
        // coordonés projetés
        var viewportMatrix = camera.viewPortMatrix

        val totalMatrix = viewportMatrix * projectionMatrix *  viewMatrix * modelMatrix
        println(viewMatrix)

        val v1 = triangle.vertex1.cpy().project(totalMatrix)
        val v2 = triangle.vertex2.cpy().project(totalMatrix)
        val v3 = triangle.vertex3.cpy().project(totalMatrix)




/*
        if ( !triangleMap.containsKey(triangle)) {
            triangleMap[triangle] = Polygon(v1.x, v1.y, v2.x, v2.y, v3.x, v3.y)
            context.children.add(triangleMap[triangle])
        } else {
            triangleMap[triangle]!!.points[0] = v1.x
            triangleMap[triangle]!!.points[1] = v1.y
            triangleMap[triangle]!!.points[2] = v2.x
            triangleMap[triangle]!!.points[3] = v2.y
            triangleMap[triangle]!!.points[4] = v3.x
            triangleMap[triangle]!!.points[5] = v3.y
        }

*/

        context.children.clear()
        val l1 = Line(v1.x, v1.y, v2.x, v2.y)
        l1.stroke = Color.RED
        val l2 = Line(v2.x, v2.y, v3.x, v3.y)
        l2.stroke = Color.BLUE
        val l3 = Line(v3.x, v3.y, v1.x, v1.y)
        l3.stroke = Color.GREEN

        context.children.addAll(l1,l2,l3)
    }
}