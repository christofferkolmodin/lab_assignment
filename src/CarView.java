import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Objects;

/**
 * This class represents the full view of the MVC pattern of your car simulator.
 * It initializes with being center on the screen and attaching it's controller in it's state.
 * It communicates with the Controller by calling methods of it when an action fires of in
 * each of it's components.
 **/

public class CarView extends JPanel implements VehicleObserver {
    
    ArrayList<BufferedImage> carImages;

    // Constructor
    public CarView(int x, int y) {

        this.setDoubleBuffered(true);
        this.setPreferredSize(new Dimension(x, y-240));
        this.setBackground(Color.green);
        // Print an error message in case file is not found with a try/catch block
        try {
            carImages = new ArrayList<>();
            carImages.add(ImageIO.read(Objects.requireNonNull(CarView.class.getResourceAsStream("pics/Volvo240.jpg"))));
            carImages.add(ImageIO.read(Objects.requireNonNull(CarView.class.getResourceAsStream("pics/Saab95.jpg"))));
            carImages.add(ImageIO.read(Objects.requireNonNull(CarView.class.getResourceAsStream("pics/Scania.jpg"))));

        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    public void updateVehiclePosition() {
        if (UpdateVehicle.vehicles.isEmpty()) {
            this.carImages.clear();
            this.repaint();
        }
        else {
            try {
                if(!UpdateVehicle.vehicles.isEmpty()){
                    if (UpdateVehicle.vehicles.size() > carImages.size()) {
                        carImages.add(ImageIO.read(Objects.requireNonNull(CarView.class.getResourceAsStream("pics/Volvo240.jpg"))));
                        this.repaint();
                    }
                }
                if (UpdateVehicle.vehicles.size() < carImages.size()) {
                    carImages.remove(UpdateVehicle.vehicles.size());
                }
                if (UpdateVehicle.vehicles.isEmpty()) {
                    this.carImages.clear();
                }
                this.repaint();
                } catch (IOException e) {
                System.out.println("Exception error");
            }
        }
    }

    // This method is called each time the panel updates/refreshes/repaints itself
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        if(!carImages.isEmpty()) {
            for (int i = 0; i < carImages.size(); i++) {
                g.drawImage(carImages.get(i), (int) Math.round(UpdateVehicle.vehicles.get(i).getPositionX()),
                        (int) Math.round(UpdateVehicle.vehicles.get(i).getPositionY()), null); // see javadoc for more info on the parameters
            }
        }
    }
}