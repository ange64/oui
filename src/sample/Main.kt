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
    val camera = Camera()

    @Throws(Exception::class)
    override fun start(primaryStage: Stage) {

        primaryStage.title = "Hello World"
        primaryStage.scene = Scene(root, 500.0, 500.0)
        var triangle = Triangle(
                Vector4(-100,-100,0),
                Vector4(0,100,0),
                Vector4(100,-100,0)
        )

        camera.translate(100.0,100.0,0.0)
        camera.rotate(45.0,0.0,0.0)

        primaryStage.show()
        println(camera.combined)

        drawTriangle(triangle)
    }

    fun drawTriangle(triangle: Triangle){
        val shape = Polygon()
        triangle.project(camera.combined).forEachIndexed { i , vertex ->
            shape.points.add(i,vertex)
        }
        root.children.add(shape)
    }





    companion object {

        @JvmStatic
        fun main(args: Array<String>) {
            launch(Main::class.java)
        }
    }


}
