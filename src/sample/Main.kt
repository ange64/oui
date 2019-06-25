package sample

import javafx.application.Application
import javafx.scene.Group

import javafx.scene.Scene
import javafx.scene.shape.Polygon
import javafx.scene.shape.Shape
import javafx.scene.shape.TriangleMesh
import javafx.stage.Stage

class Main : Application() {
    val root = Group()
    @Throws(Exception::class)
    override fun start(primaryStage: Stage) {

        primaryStage.title = "Hello World"
        primaryStage.scene = Scene(root, 1000.0, 1000.0)
        var triangle = Triangle(
                Vector4(-100,-100,0),
                Vector4(0,100,0),
                Vector4(100,-100,0)
        )


        primaryStage.show()

        drawTriangle(triangle)
    }

    fun drawTriangle(triangle: Triangle){
        val shape = Polygon()
        triangle.project(Matrix4.projection2d).forEachIndexed { i , vertex ->
            shape.points.add(i,vertex)
        }
        println(triangle)

        root.children.add(shape)
    }





    companion object {

        @JvmStatic
        fun main(args: Array<String>) {
            launch(Main::class.java)
        }
    }


}
