import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Objects;
import javax.imageio.ImageIO;
import javax.swing.*;

// This panel represent the animated part of the view with the car images.

public class DrawPanel extends JPanel {
    ArrayList<BufferedImage> carImages;
    // To keep track of a single cars position
    ArrayList<Point> carPoints;

    void moveit(int positionX, int positionY, int vehicleListIndex, int vehicleListSize) {
        try {
            if(vehicleListSize > 0){
                if (vehicleListSize > carPoints.size()) {
                    carImages.add(ImageIO.read(Objects.requireNonNull(DrawPanel.class.getResourceAsStream("pics/Volvo240.jpg"))));
                    carPoints.add(new Point());

                } if (vehicleListSize < carPoints.size()){
                    carImages.remove(vehicleListSize);
                    carPoints.remove(vehicleListSize);

                }
                carPoints.get(vehicleListIndex).x = positionX;
                carPoints.get(vehicleListIndex).y = positionY;

            }if(vehicleListSize == 0){
                carImages.clear();
                carPoints.clear();
            }
        }catch(IOException e){
            System.out.println("Exception error");
        }

    }


    // Initializes the panel and reads the images
    public DrawPanel(int x, int y) {
        this.setDoubleBuffered(true);
        this.setPreferredSize(new Dimension(x, y));
        this.setBackground(Color.green);
        // Print an error message in case file is not found with a try/catch block
        try {
            // You can remove the "pics" part if running outside of IntelliJ and
            // everything is in the same main folder.
            // volvoImage = ImageIO.read(new File("Volvo240.jpg"));
            // Rememember to rightclick src New -> Package -> name: pics -> MOVE *.jpg to pics.
            // if you are starting in IntelliJ.
            carImages = new ArrayList<>();
            carPoints = new ArrayList<>();

            carImages.add(ImageIO.read(Objects.requireNonNull(DrawPanel.class.getResourceAsStream("pics/Volvo240.jpg"))));
            carPoints.add(new Point());
            carImages.add(ImageIO.read(Objects.requireNonNull(DrawPanel.class.getResourceAsStream("pics/Saab95.jpg"))));
            carPoints.add(new Point());
            carImages.add(ImageIO.read(Objects.requireNonNull(DrawPanel.class.getResourceAsStream("pics/Scania.jpg"))));
            carPoints.add(new Point());
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    // This method is called each time the panel updates/refreshes/repaints itself
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        if(!carImages.isEmpty()) {
            for (int i = 0; i < carImages.size(); i++) {
                g.drawImage(carImages.get(i), carPoints.get(i).x, carPoints.get(i).y, null); // see javadoc for more info on the parameters
            }
        }
    }
}