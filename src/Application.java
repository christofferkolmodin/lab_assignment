
public class Application {
    public static void main(String[] args) {
        UpdateVehicle update = new UpdateVehicle();

        Volvo240 volvo = new Volvo240();
        update.addVehicle(volvo);

        Saab95 saab = new Saab95();
        update.addVehicle(saab);

        Scania scania = new Scania();
        update.addVehicle(scania);

        new CarController("CarSim 1.0");

        update.startTimer();
    }
}
