public class Collision {

    private static void stopAndTurnAround(Vehicle vehicle) {
        vehicle.stopEngine();
        vehicle.turnRight();
        vehicle.turnRight();
        vehicle.startEngine();
        vehicle.gas((vehicle.getCurrentSpeed()/4));
    }

    public static void checkCollision(Vehicle vehicle) {
        System.out.println(vehicle.getPositionX());
        System.out.println(vehicle.getPositionY());

        if (vehicle.getPositionX() > 700) {
            stopAndTurnAround(vehicle);
            vehicle.xPosition = 700;

        } else if (vehicle.getPositionX() < -10) {
            stopAndTurnAround(vehicle);
            vehicle.xPosition = -10;
        }
        else if (vehicle.getPositionY() > 740){
            stopAndTurnAround(vehicle);
            vehicle.yPosition = 740;
        }
        else if (vehicle.getPositionY() < -60){
            stopAndTurnAround(vehicle);
            vehicle.yPosition = -60;
        }
    }
}