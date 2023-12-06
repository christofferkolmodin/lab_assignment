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
    void gas(int amount) {
        double gas = ((double) amount) / 100;
        for (Vehicle car : cars
        ) {
            car.gas(gas);
        }
    }

    void brake(int amount) {
        double brake = ((double) amount) / 100;
        for (Vehicle car : cars
        ) {
            car.brake(brake);
        }
    }

    void turboOn(){
        for (Vehicle car : cars) {
            if (car.modelName.equals("Saab95")) {
                Saab95 saab = (Saab95) car;
                saab.setTurboOn();
            }
        }
    }

    void turboOff(){
        for (Vehicle car : cars) {
            if (car.modelName.equals("Saab95")) {
                Saab95 saab = (Saab95) car;
                saab.setTurboOff();
            }
        }
    }

    void lowerBed(){
        for (Vehicle car : cars) {
            if (car.modelName.equals("Scania")) {
                Scania scania = (Scania) car;
                scania.lowerTrailer(70);
            }
        }
    }

    void liftBed(){
        for (Vehicle car : cars) {
            if (car.modelName.equals("Scania")) {
                Scania scania = (Scania) car;
                scania.raiseTrailer(70);
            }
        }
    }

    void start(){
        for(Vehicle car : cars){
            car.startEngine();

        }

    }

    void stop(){
        for(Vehicle car : cars){
            car.stopEngine();

        }
    }
}