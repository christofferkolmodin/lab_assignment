import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Objects;
import javax.imageio.ImageIO;
import javax.swing.*;

// This panel represent the animated part of the view with the car images.

public class DrawPanel extends JPanel {

    // Just a single image, TODO: Generalize
    ArrayList<BufferedImage> carImages;
    // To keep track of a single cars position
    ArrayList<Point> carPoints;

    // TODO: Make this general for all cars
    void moveit(int x, int y, int index, int length) {
        try {
            if(length > 0){
                if (length > carPoints.size()) {
                    carImages.add(ImageIO.read(Objects.requireNonNull(DrawPanel.class.getResourceAsStream("pics/Volvo240.jpg"))));
                    carPoints.add(new Point());

                } if (length < carPoints.size()){
                    carImages.remove(length);
                    carPoints.remove(length);

                }
                carPoints.get(index).x = x;
                carPoints.get(index).y = y;

            }if(length == 0){
                carImages.clear();
                carPoints.clear();


            }}catch(IOException e){
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
    // TODO: Change to suit your needs.
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