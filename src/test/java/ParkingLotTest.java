import exceptions.CarAlreadyParkedException;
import exceptions.FullParkingLotException;
import org.junit.Assert;
import org.junit.Test;

public final class ParkingLotTest {

    private Vehicle mitchsCar = Vehicle.builder()
            .isCompact(true)
            .owner("Mitch")
            .make("Ford")
            .model("Fusion")
            .year(2010)
            .build();

    private Vehicle noellesCar = Vehicle.builder()
            .owner("Noelle")
            .make("Toyota")
            .model("Camry")
            .year(2011)
            .build();

    private Vehicle angiesCar = Vehicle.builder()
            .isHandicapped(true)
            .owner("Angie")
            .make("Honda")
            .model("Accord")
            .year(2008)
            .build();

    @Test
    public void addCarToParkingLot() {
        ParkingLot parkingLot = ParkingLot.builder()
                .compactCarCapacity(1)
                .build();
        parkingLot.park(mitchsCar);

        Assert.assertEquals(1, parkingLot.size());
    }

    @Test(expected = FullParkingLotException.class)
    public void addCarToFullParkingLot() {
        ParkingLot parkingLot = ParkingLot.builder()
                .compactCarCapacity(1)
                .build();
        parkingLot.park(mitchsCar);
        parkingLot.park(noellesCar);
    }

    @Test(expected = CarAlreadyParkedException.class)
    public void parkSameCarTwice() {
        ParkingLot parkingLot = ParkingLot.builder()
                .compactCarCapacity(2)
                .build();
        parkingLot.park(mitchsCar);
        parkingLot.park(mitchsCar);
    }

    @Test
    public void compact() {
        ParkingLot parkingLot = ParkingLot.builder()
                .compactCarCapacity(1)
                .build();
        Assert.assertTrue(parkingLot.hasRoom(mitchsCar));
        Assert.assertFalse(parkingLot.hasRoom(noellesCar));

        parkingLot.park(mitchsCar);
        Assert.assertFalse(parkingLot.hasRoom(mitchsCar));
    }

    @Test
    public void regular() {
        ParkingLot parkingLot = ParkingLot.builder()
                .regularCarCapacity(1)
                .build();
        Assert.assertTrue(parkingLot.hasRoom(mitchsCar));
        Assert.assertTrue(parkingLot.hasRoom(noellesCar));

        parkingLot.park(noellesCar);
        Assert.assertFalse(parkingLot.hasRoom(noellesCar));
    }

    @Test
    public void handicapped() {
        ParkingLot parkingLot = ParkingLot.builder()
                .handicappedCarCapacity(1)
                .build();
        Assert.assertTrue(parkingLot.hasRoom(angiesCar));

        parkingLot.park(angiesCar);
        Assert.assertFalse(parkingLot.hasRoom(angiesCar));
    }

    /*
        valet parking
     */

}
