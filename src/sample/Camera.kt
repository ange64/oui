package sample

class Camera( var windowWidth : Double, var windowHeight : Double ) : Transformable() {

    val projectionMatrix = Matrix4.identity()
    val viewPortMatrix = Matrix4()
    val near = 0.1
    val far = 10.0

    val viewMatrix : Matrix4
        get() = super.combined

    init {
        projectionMatrix[0, 0] = near
        projectionMatrix[1, 1] = near
        projectionMatrix[2, 2] = -(far + near) / (far - near)
        projectionMatrix[2, 3] = -(2 * far * near / (far - near))
        projectionMatrix[3, 2] = -1.0
        projectionMatrix[3, 3] = 0.0

        viewPortMatrix[0,0] = windowWidth/2
        viewPortMatrix[0,3] = windowWidth/2
        viewPortMatrix[1,1] = windowHeight/2
        viewPortMatrix[1,3] = windowHeight/2
        viewPortMatrix[2,2] = 1.0/2
        viewPortMatrix[2,3] = 1.0/2
        viewPortMatrix[3,3] = 1.0
    }

}