/*
 * This class represents the Controller part in the MVC pattern.
 * It's responsibilities is to listen to the View and responds in a appropriate manner by
 * modifying the model state and the updating the view.
 */
import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CarController extends JFrame {
    CarView carview = new CarView("CarSim 1.0");
    UpdateVehicle update = new UpdateVehicle();

    // Calls the gas method for each car once
    // This actionListener is for the gas button only

        carview.gasButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                update.gas(gasAmount);
            }
        });

        brakeButton.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            update.brake(gasAmount);
        }
    });

        turboOnButton.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            update.turboOn();

        }
    });

        turboOffButton.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            update.turboOff();

        }
    });

        liftBedButton.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            update.liftBed();

        }
    });

        lowerBedButton.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            update.lowerBed();

        }
    });

        stopButton.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            update.stop();

        }
    });

        startButton.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            update.start();

        }
    });

        addCar.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            update.addCar();

        }
    });

        removeVehicle.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            update.removeCar();

        }
}
