package sample

import javafx.application.Application
import javafx.scene.Group

import javafx.scene.Scene
import javafx.stage.Stage

class Main : Application() {

    @Throws(Exception::class)
    override fun start(primaryStage: Stage) {
        val root = Group()
        primaryStage.title = "Hello World"
        primaryStage.scene = Scene(root, 1000.0, 1000.0)
        primaryStage.show()
    }

    companion object {


        @JvmStatic
        fun main(args: Array<String>) {
            launch(Main::class.java)
        }
    }
}
