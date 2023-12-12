import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

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
        if (vehicles.isEmpty()) {
            for (VehicleObserver observer : observers) {
                try {
                    observer.updateVehiclePosition();
                } catch (IOException ex) {
                    throw new RuntimeException(ex);
                }
            }
        }
        for (Vehicle vehicle : vehicles) {
            vehicle.move();
            int x = (int) Math.round(vehicle.getPositionX());
            int y = (int) Math.round(vehicle.getPositionY());

            if (Collision.checkCollision(x, y)) {
                stopAndTurnAround(vehicle);
            }

            for (VehicleObserver observer : observers) {
                try {
                    observer.updateVehiclePosition();
                } catch (IOException ex) {
                    throw new RuntimeException(ex);
                }
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

    protected void gas(int amount) {
        double gas = ((double) amount) / 100;
        for (Vehicle car : vehicles) {
            car.gas(gas);
        }
    }

    protected void brake(int amount) {
        double brake = ((double) amount) / 100;
        for (Vehicle car : vehicles) {
            car.brake(brake);
        }
    }

    protected void turboOn(){
        for (Vehicle car : vehicles) {
            if (car.modelName.equals("Saab95")) {
                Saab95 saab = (Saab95) car;
                saab.setTurboOn();
            }
        }
    }

    protected void turboOff(){
        for (Vehicle car : vehicles) {
            if (car.modelName.equals("Saab95")) {
                Saab95 saab = (Saab95) car;
                saab.setTurboOff();
            }
        }
    }

    protected void lowerBed(){
        for (Vehicle car : vehicles) {
            if (car.modelName.equals("Scania")) {
                Scania scania = (Scania) car;
                scania.lowerTrailer(70);
            }
        }
    }

    protected void liftBed(){
        for (Vehicle car : vehicles) {
            if (car.modelName.equals("Scania")) {
                Scania scania = (Scania) car;
                scania.raiseTrailer(70);
            }
        }
    }

    protected void start(){
        for(Vehicle car : vehicles){
            car.startEngine();
        }
    }

    protected void stop(){
        for(Vehicle car : vehicles){
            car.stopEngine();
        }
    }
}
	