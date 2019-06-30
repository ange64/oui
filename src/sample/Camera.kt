package sample

class Camera( var windowWidth : Double, var windowHeight : Double ) : Transformable() {

    val projection = Matrix4.identity()
    val near = 0.1
    val far = 100.0
    val l : Double
        get() = windowWidth /2 - windowWidth
    val r : Double
        get() = windowWidth /2
    val t : Double
        get() = windowHeight /2 - windowHeight
    val b : Double
        get() = windowHeight /2


    init {
        projection[0, 2] = (r + l) / (r - l)
        projection[1, 2] = (t + b) / (t - b)
        projection[2, 2] = -(far + near) / (far - near)
        projection[2, 3] = -(2 * far * near / (far - near))
        projection[3, 2] = -1.0
        projection[3, 3] = 0.0
    }

    override val combined: Matrix4
        get() = super.combined * projection

}