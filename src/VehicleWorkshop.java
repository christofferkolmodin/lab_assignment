import java.util.ArrayList;

public class    VehicleWorkshop<W extends Vehicle> {

    private final ArrayList<W> vehiclesInWorkshop = new ArrayList<>();
    private int vehicleCapacity;

    public VehicleWorkshop(int vehicleCapacity) {
        this.vehicleCapacity = vehicleCapacity;
    }

    public ArrayList<W> getListOfVehicles() {
        return vehiclesInWorkshop;
    }

    public void putVehicleInWorkshop(W vehicle) {
        if (vehiclesInWorkshop.size() < vehicleCapacity) {
            vehiclesInWorkshop.add(vehicle);
        }
    }

    // Vid uthämtning av en bil från verkstaden ska vi kunna få så precis typinformation som möjligt statiskt.
    // Workshopen tar endast emot bilar av en specifierad typ så måste det förtydliga det vid uthämtning?
    public boolean retrieveVehicleFromWorkshop(W vehicle) {
        return vehiclesInWorkshop.remove(vehicle);
    }
}
