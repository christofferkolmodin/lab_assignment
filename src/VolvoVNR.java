import java.awt.*;
import java.util.Stack;

public class VolvoVNR extends Vehicle {
    private final int loadedCarCapacity = 4;
    private final int loadingRange = 2;
    private final int carWeightLimit = 2500;
    private final Stack<Vehicle> loadedCars = new Stack<>();

    private final TruckBed parent = new TruckBed(0, 1);

    public VolvoVNR(){
        super(2, 150, Color.cyan, "VolvoVNR", 6500);
    }

    public int getloadedCarsSize() {
        return loadedCars.size();
    }

    public int getRampPosition() {
        return parent.getTrailerPosition();
    }

    public void lowerRamp(int decrementPosition) {
        parent.raiseTruckBed(decrementPosition);
    }

    // Ramp can only be lowered if the car is not moving
    public void raiseRamp(int incrementPosition){
        parent.lowerTruckBed(incrementPosition);
    }

    @Override
    public void startEngine(){
        currentSpeed = parent.startEngine(currentSpeed);
    }

    @Override
    public void gas(double amount){
        super.gas(parent.gas(amount));
    }

    public void loadCar(Vehicle car){
        if (parent.getTrailerPosition() == 1 && car.getCarWeightInKG() <= carWeightLimit) {
            if (car.getPositionX() >= xPosition - loadingRange &&
                    car.getPositionX() <= xPosition + loadingRange &&
                    car.getPositionY() >= yPosition - loadingRange &&
                    car.getPositionY() <= yPosition + loadingRange &&
                    loadedCars.size() != loadedCarCapacity &&
                    // Checks if car is already loaded. search(car) returns -1 if it is not loaded.
                    loadedCars.search(car) == -1) {

                loadedCars.push(car);
                car.xPosition = xPosition;
                car.yPosition = yPosition;
            }
        }
    }

    //Unloading can only happen if the ramp is the lowered mode
    //Unloaded cars should be close to the truck directly after unloading
    //Unloaded cars should unload in reverse order of the loading (first in, last out)
    protected void unloadCar(){
        if (parent.getTrailerPosition() == 1 && loadedCars.size() != 0) {
            loadedCars.peek().xPosition = xPosition - loadingRange;
            loadedCars.pop(); }
    }

    @Override
    public void move() {
        super.move();
        for (Vehicle car : loadedCars) {
            car.xPosition = xPosition;
            car.yPosition = yPosition;
        }
    }
}
