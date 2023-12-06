public class Collision {
    public static boolean checkCollision(int x, int y) {
//        System.out.println(vehicle.getPositionX());
//        System.out.println(vehicle.getPositionY());

        if (x > 700) {
            return true;

        } else if (x < -10) {
            return true;

        } else if (y > 740) {
            return true;

        } else if (y < -60) {
            return true;
        }

        return false;
    }
}