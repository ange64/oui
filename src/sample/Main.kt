package sample

import javafx.animation.AnimationTimer
import javafx.application.Application
import javafx.scene.Group

import javafx.scene.Scene
import javafx.stage.Stage

class Main : Application() {
    val root = Group()
    lateinit var camera : Camera
    lateinit var  drawer  : ModelDrawer

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
        drawer = ModelDrawer(root, camera)


        triangle.position.x += 0
        triangle.position.y += 0
        triangle.position.z += -1



        val lol =  object: AnimationTimer(){
            override fun handle(p0: Long) {
                triangle.rotation.y += 0.01
                drawer.draw(triangle)
            }
        }.start()
    }

    companion object {

        @JvmStatic
        fun main(args: Array<String>) {
            launch(Main::class.java)
        }
    }
}
