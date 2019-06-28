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
    val drawer  = ModelDrawer(root)

    @Throws(Exception::class)
    override fun start(primaryStage: Stage) {

        primaryStage.title = "Hello World"
        primaryStage.scene = Scene(root, 500.0, 500.0)
        var triangle = Triangle(
                Vertex3d(-100,-100,0),
                Vertex3d(0,100,0),
                Vertex3d(100,-100,0)
        )

        camera.translate(100.0,100.0,0.0)
        camera.setRotationZ(1.0)

        primaryStage.show()
        println(camera.combined)

        drawer.draw(triangle,camera)
    }







    companion object {

        @JvmStatic
        fun main(args: Array<String>) {
            launch(Main::class.java)
        }
    }


}
