import exceptions.CarAlreadyParkedException;
import exceptions.FullParkingLotException;

import java.util.HashSet;

public class ParkingLotFragment {

    private int capacity;
    private HashSet<Vehicle> parkedCars = new HashSet<>();

    ParkingLotFragment(int capacity) {
        this.capacity = capacity;
    }

    public void park(Vehicle vehicle) {
        if (parkedCars.size() == capacity) {
            throw new FullParkingLotException();
        } else if (parkedCars.contains(vehicle)) {
            throw new CarAlreadyParkedException();
        }

        parkedCars.add(vehicle);
    }

    public boolean hasRoom() {
        return capacity > parkedCars.size();
    }

    public int size() {
        return parkedCars.size();
    }
}
