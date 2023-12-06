import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Collection;

/*
 * This class represents the Controller part in the MVC pattern.
 * It's responsibilities is to listen to the View and responds in a appropriate manner by
 * modifying the model state and the updating the view.
 */

public class CarController {

    Application app = new Application();

    // Calls the gas method for each car once
    protected void gas(int amount) {
        double gas = ((double) amount) / 100;
        for (Vehicle car : app.cars) {
            car.gas(gas);
        }
    }

    protected void brake(int amount) {
        double brake = ((double) amount) / 100;
        for (Vehicle car : app.cars) {
            car.brake(brake);
        }
    }

    protected void turboOn(){
        for (Vehicle car : app.cars) {
            if (car.modelName.equals("Saab95")) {
                Saab95 saab = (Saab95) car;
                saab.setTurboOn();
            }
        }
    }

    protected void turboOff(){
        for (Vehicle car : app.cars) {
            if (car.modelName.equals("Saab95")) {
                Saab95 saab = (Saab95) car;
                saab.setTurboOff();
            }
        }
    }

    protected void lowerBed(){
        for (Vehicle car : app.cars) {
            if (car.modelName.equals("Scania")) {
                Scania scania = (Scania) car;
                scania.lowerTrailer(70);
            }
        }
    }

    protected void liftBed(){
        for (Vehicle car : app.cars) {
            if (car.modelName.equals("Scania")) {
                Scania scania = (Scania) car;
                scania.raiseTrailer(70);
            }
        }
    }

    protected void start(){
        for(Vehicle car : app.cars){
            car.startEngine();
        }
    }

    protected void stop(){
        for(Vehicle car : app.cars){
            car.stopEngine();
        }
    }
}