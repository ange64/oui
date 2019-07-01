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

    fun draw( mesh: Mesh){

        //coordonés modèle
        val modelMatrix = mesh.modelMatrix
        //coordonnés mpnde
        val viewMatrix = camera.viewMatrix
        //coordonés camera
        val projectionMatrix = camera.projectionMatrix
        // coordonés projetés
        val viewportMatrix = camera.viewPortMatrix
        println(modelMatrix)

        val totalMatrix = viewportMatrix * projectionMatrix *  viewMatrix * modelMatrix

        for( triangle in mesh.triangles){
            val v1 = triangle.vertex1.cpy().project(totalMatrix)
            val v2 = triangle.vertex2.cpy().project(totalMatrix)
            val v3 = triangle.vertex3.cpy().project(totalMatrix)


            val l1 = Line(v1.x, v1.y, v2.x, v2.y)
            l1.stroke = Color.RED
            val l2 = Line(v2.x, v2.y, v3.x, v3.y)
            l2.stroke = Color.BLUE
            val l3 = Line(v3.x, v3.y, v1.x, v1.y)
            l3.stroke = Color.GREEN
            context.children.addAll(l1,l2,l3)
        }

    }

    fun clear(){
        context.children.clear()
    }
}