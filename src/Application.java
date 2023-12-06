import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Collection;

public class Application {
    // member fields:
    // The delay (ms) corresponds to 20 updates a sec (hz)
    private static final int delay = 50;
    // The timer is started with a listener (see below) that executes the statements
    // each step between delays.
    private static Timer timer = new Timer(delay, new TimerListener());
    // The frame that represents this instance View of the MVC pattern
    static CarView frame;
    Collision collision;
    static ArrayList<Vehicle> cars = new ArrayList<>();
    public static void main(String[] args) {
        // Instance of this class

        Volvo240 volvo = new Volvo240();
        volvo.yPosition = 0;
        cars.add(volvo);

        Saab95 saab = new Saab95();
        saab.yPosition = 100;
        cars.add(saab);

        Scania scania = new Scania();
        scania.yPosition = 200;
        cars.add(scania);


        // Start a new view and send a reference of self
        CarView frame = new CarView("CarSim 1.0");

        // Start the timer
        timer.start();
    }

    /* Each step the TimerListener moves all the cars in the list and tells the
     * view to update its images. Change this method to your needs.
     * */
    public static class TimerListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            int index = 0;
            for (Vehicle car : cars) {
                car.move();
                int x = (int) Math.round(car.getPositionX());
                int y = (int) Math.round(car.getPositionY());
                Collision.checkCollision(car);
                frame.drawPanel.moveit(x, y, index);
                // repaint() calls the paintComponent method of the panel
                frame.drawPanel.repaint();
                index++;
            }
        }
    }
}
