import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import java.util.Collection;

public class UpdateVehicle<V extends Vehicle> implements ActionListener {
    private static final int delay = 50;
    private static Timer timer = new Timer(delay, new UpdateVehicle());
    static ArrayList<Vehicle> vehicles = new ArrayList<>();
    public void startTimer() {
        timer.start();
    }
    public void addVehicle (V vehicle) {
        if (vehicles.size() < 10) {
            vehicle.yPosition = vehicles.size() * 60;
            vehicles.add(vehicle);
        }
    }
    private static final List<VehicleObserver> observers = new ArrayList<>();

    public void addObserver(VehicleObserver observer){
        observers.add(observer);
    }

    protected static void removeVehicle(){
        if(!vehicles.isEmpty()){
            vehicles.remove(vehicles.size() - 1);
        }
    }

    public void actionPerformed(ActionEvent e) {
        int index = 0;
        for (Vehicle vehicle : vehicles) {
            vehicle.move();
            int x = (int) Math.round(vehicle.getPositionX());
            int y = (int) Math.round(vehicle.getPositionY());

            if (Collision.checkCollision(x, y)) {
                stopAndTurnAround(vehicle);
            }
            for (VehicleObserver observer : observers) {
                observer.updateVehiclePosition(x, y, index, vehicles.size());

                if (vehicles.isEmpty()){
                    observer.updateVehiclePosition(0, 0, 0, vehicles.size());
                }
                index++;
            }
        }
    }

    private static void stopAndTurnAround(Vehicle vehicle) {
        if (vehicle.direction == Direction.RIGHT) {
            vehicle.xPosition -= vehicle.getCurrentSpeed();
        }
        else if (vehicle.direction == Direction.LEFT) {
            vehicle.xPosition += vehicle.getCurrentSpeed();
        }
        vehicle.stopEngine();
        turnAround(vehicle);
        vehicle.startEngine();
        vehicle.gas((vehicle.getCurrentSpeed()/2));
    }

    private static void turnAround(Vehicle vehicle) {
        vehicle.turnRight();
        vehicle.turnRight();
    }
}
	