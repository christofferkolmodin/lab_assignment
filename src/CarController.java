import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

/*
 * This class represents the Controller part in the MVC pattern.
 * It's responsibilities is to listen to the View and responds in a appropriate manner by
 * modifying the model state and the updating the view.
 */

public class CarController {
    // member fields:

    // The delay (ms) corresponds to 20 updates a sec (hz)
    private final int delay = 50;
    // The timer is started with an listener (see below) that executes the statements
    // each step between delays.
    private Timer timer = new Timer(delay, new TimerListener());

    // The frame that represents this instance View of the MVC pattern
    CarView frame;
    // A list of cars, modify if needed
    ArrayList<Vehicle> cars = new ArrayList<>();

    //methods:

    public static void main(String[] args) {
        // Instance of this class
        CarController cc = new CarController();

        Volvo240 volvo = new Volvo240();
        volvo.yPosition = 0;
        cc.cars.add(volvo);

        Saab95 saab = new Saab95();
        saab.yPosition = 100;
        cc.cars.add(saab);

        Scania scania = new Scania();
        scania.yPosition = 200;
        cc.cars.add(scania);


        // Start a new view and send a reference of self
        cc.frame = new CarView("CarSim 1.0", cc);

        // Start the timer
        cc.timer.start();
    }

    public static class Collision<V extends Vehicle> {
        static boolean collided = false;

        public static void collided(Vehicle car) {
            car.stopEngine();
            car.turnRight();
            car.turnRight();
            car.startEngine();
            car.gas(20);
        }

        public static void checkCollision(Vehicle car) {
            System.out.println(car.getPositionX());
            System.out.println(car.getPositionY());

            if (car.getPositionX() > 700) {
                Collision.collided(car);
                car.xPosition = 700;


            } else if (car.getPositionX() < -10) {
                Collision.collided(car);
                car.xPosition = -10;
            }
            else if (car.getPositionY() > 740){
                Collision.collided(car);
                car.yPosition = 740;
            }
            else if (car.getPositionY() < -60){
                Collision.collided(car);
                car.yPosition = -60;
            }
        }
    }

    /* Each step the TimerListener moves all the cars in the list and tells the
     * view to update its images. Change this method to your needs.
     * */

    private class TimerListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            for (Vehicle car : cars) {
                car.move();
                int x = (int) Math.round(car.getPositionX());
                int y = (int) Math.round(car.getPositionY());
                Collision.checkCollision(car);
                frame.drawPanel.moveit(x, y);
                // repaint() calls the paintComponent method of the panel
                frame.drawPanel.repaint();

            }
        }
    }

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