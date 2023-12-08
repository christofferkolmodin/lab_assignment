/*
 * This class represents the Controller part in the MVC pattern.
 * It's responsibilities is to listen to the View and responds in a appropriate manner by
 * modifying the model state and the updating the view.
 */

public class CarController {
    UpdateVehicle update = new UpdateVehicle();
    // Calls the gas method for each car once
    protected void gas(int amount) {
        double gas = ((double) amount) / 100;
        for (Vehicle car : update.vehicles) {
            car.gas(gas);
        }
    }

    protected void brake(int amount) {
        double brake = ((double) amount) / 100;
        for (Vehicle car : update.vehicles) {
            car.brake(brake);
        }
    }

    protected void turboOn(){
        for (Vehicle car : update.vehicles) {
            if (car.modelName.equals("Saab95")) {
                Saab95 saab = (Saab95) car;
                saab.setTurboOn();
            }
        }
    }

    protected void turboOff(){
        for (Vehicle car : update.vehicles) {
            if (car.modelName.equals("Saab95")) {
                Saab95 saab = (Saab95) car;
                saab.setTurboOff();
            }
        }
    }

    protected void lowerBed(){
        for (Vehicle car : update.vehicles) {
            if (car.modelName.equals("Scania")) {
                Scania scania = (Scania) car;
                scania.lowerTrailer(70);
            }
        }
    }

    protected void liftBed(){
        for (Vehicle car : update.vehicles) {
            if (car.modelName.equals("Scania")) {
                Scania scania = (Scania) car;
                scania.raiseTrailer(70);
            }
        }
    }

    protected void start(){
        for(Vehicle car : update.vehicles){
            car.startEngine();
        }
    }

    protected void stop(){
        for(Vehicle car : update.vehicles){
            car.stopEngine();
        }
    }

    protected void addCar(){
        update.addVehicle(new Volvo240());

    }
    protected void removeCar(){
        update.removeVehicle();

    }
}