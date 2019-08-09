import org.junit.Assert;
import org.junit.Test;

public final class VehicleTest {

    @Test
    public void vehicleEquals() {
        Vehicle a = Vehicle.builder()
                .owner("Mitch")
                .make("Ford")
                .model("Fusion")
                .year(2010)
                .build();

        Vehicle b = Vehicle.builder()
                .owner("Mitch")
                .make("Ford")
                .model("Fusion")
                .year(2010)
                .build();

        Assert.assertEquals(a, b);

        a = Vehicle.builder()
                .owner("Noelle")
                .make("Ford")
                .model("Fusion")
                .year(2010)
                .build();

        b = Vehicle.builder()
                .owner("Mitch")
                .make("Ford")
                .model("Fusion")
                .year(2010)
                .build();

        Assert.assertNotEquals(a, b);
    }

    @Test
    public void compactVehicle() {
        Vehicle vehicle = Vehicle.builder()
                .isCompact(true)
                .build();

        Assert.assertTrue(vehicle.isCompact());
        Assert.assertFalse(vehicle.isHandicapped());
    }

    @Test
    public void handicappedVehicle() {
        Vehicle vehicle = Vehicle.builder()
                .isHandicapped(true)
                .build();

        Assert.assertTrue(vehicle.isHandicapped());
        Assert.assertFalse(vehicle.isCompact());
    }

}
