public class Collision {
    //
    private static final int rightWall = 700, leftWall = - 10, roof = 740, floor = - 60;
    public static boolean checkCollision(int x, int y) {

        if (x > rightWall) {
            return true;

        } else if (x < leftWall) {
            return true;

        } else if (y > roof) {
            return true;

        } else if (y < floor) {
            return true;
        }

        return false;
    }
}