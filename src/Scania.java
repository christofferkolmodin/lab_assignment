import java.awt.*;
public class Scania extends Vehicle {

    private final TruckBed parent = new TruckBed(0, 70);

    protected Scania(){
        super(2, 110, Color.magenta, "Scania", 5000);
    }

    public void raiseTrailer(int angle){
        parent.raiseTruckBed(angle);
    }

    public void lowerTrailer(int angle){
        parent.lowerTruckBed(angle);
    }

    public int getTrailerAngle(){
        return parent.getTrailerPosition();
    }

    @Override
    public void startEngine(){
        currentSpeed = parent.startEngine(currentSpeed);
    }

    @Override
    public void gas(double amount) {
        super.gas(parent.gas(amount));
    }
}