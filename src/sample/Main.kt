package sample

import javafx.animation.AnimationTimer
import javafx.application.Application
import javafx.scene.Group

import javafx.scene.Scene
import javafx.scene.shape.Polygon
import javafx.scene.shape.Shape
import javafx.scene.shape.TriangleMesh
import javafx.stage.Stage

class Main : Application() {
    val root = Group()
    lateinit var camera : Camera
    val drawer  = ModelDrawer(root)

    @Throws(Exception::class)
    override fun start(primaryStage: Stage) {


        primaryStage.title = "Hello World"
        primaryStage.scene = Scene(root, 500.0, 500.0)
        var triangle = Triangle(
                Vertex3d(-1,-1,0),
                Vertex3d(0,1,0),
                Vertex3d(1,-1,0)
        )

        primaryStage.show()
        camera = Camera(primaryStage.scene.width,primaryStage.scene.height)


        triangle.position.x += 0
        triangle.position.y += 0
        triangle.position.z += 1

        drawer.projectionMatrix = camera.combined
        drawer.draw(triangle)
    }

    companion object {

        @JvmStatic
        fun main(args: Array<String>) {
            launch(Main::class.java)
        }
    }
}
