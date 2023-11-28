import java.awt.*;

public class TruckBed {
    private int minPosition;
    private int maxPosition;
    private int position = 0;

    public TruckBed(int minPosition, int maxPosition) {
        this.minPosition = minPosition;
        this.maxPosition = maxPosition;
    }

    public int getTrailerPosition() {
        return position;
    }

    public void raiseTruckBed(int amount) {
        position = Math.min(position + amount, maxPosition);
    }

    public void lowerTruckBed(int amount) {
        position = Math.max(position - amount, minPosition);
    }

    public double startEngine(double currentSpeed) {
        if (currentSpeed != 0) {
            System.out.println("Engine is already on!");
        }
        else if (position == 0) {
            return 0.1;
        }
        else {
            System.out.println("Trailer position has to be 0 to start engine");
        }
        return currentSpeed;
    }

    public double gas(double amount) {
        if (position == 0) {
            return amount;
        }
        else {
            return 0;
        }
    }
}