package sample

import javafx.animation.AnimationTimer
import javafx.application.Application
import javafx.scene.Group

import javafx.scene.Scene
import javafx.stage.Stage

class Main : Application() {
    val root = Group()
    lateinit var camera: Camera
    lateinit var drawer: ModelDrawer

    @Throws(Exception::class)
    override fun start(primaryStage: Stage) {


        primaryStage.title = "Hello World"
        primaryStage.scene = Scene(root, 500.0, 500.0)

        primaryStage.show()
        camera = Camera(primaryStage.scene.width, primaryStage.scene.height)
        drawer = ModelDrawer(root, camera)

        val teapot = Teapot()
        val cube = Cube()
        teapot.position.z = -2.0
        teapot.position.y = 1.0
        cube .position.z = -5.0
        cube .position.y = -1.0
        camera.origin.set(0.0,0.0,-10.0)


        val lol = object : AnimationTimer() {
            override fun handle(p0: Long) {
                drawer.clear()
                drawer.draw(teapot)
                drawer.draw(cube)
                //teapot.rotation.y += 0.01
                //cube.rotation.y -= 0.01
                camera.rotation.y += 0.01

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
