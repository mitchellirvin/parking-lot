public final class ParkingLot {

    private ParkingLotFragment compactCarsFragment;
    private ParkingLotFragment regularCarsFragment;
    private ParkingLotFragment handicappedCarsFragment;

    private ParkingLot(
            ParkingLotFragment compactCarsFragment,
            ParkingLotFragment regularCarsFragment,
            ParkingLotFragment handicappedCarsFragment) {
        this.compactCarsFragment = compactCarsFragment;
        this.regularCarsFragment = regularCarsFragment;
        this.handicappedCarsFragment = handicappedCarsFragment;
    }

    public void park(Vehicle vehicle) {
        if (vehicle.isHandicapped()) {
            handicappedCarsFragment.park(vehicle);
        } else if (vehicle.isCompact()) {
            compactCarsFragment.park(vehicle);
        } else {
            regularCarsFragment.park(vehicle);
        }
    }

    public boolean hasRoom(Vehicle vehicle) {
        if (vehicle.isHandicapped()) {
            return handicappedCarsFragment.hasRoom();
        } else if (vehicle.isCompact()) {
            return compactCarsFragment.hasRoom() || regularCarsFragment.hasRoom();
        } else {
            return regularCarsFragment.hasRoom();
        }
    }

    public int size() {
        return compactCarsFragment.size() + regularCarsFragment.size();
    }


    public static Builder builder() {
        return new Builder();
    }

    public static class Builder {

        private int compactCarCapacity;
        private int regularCarCapacity;
        private int handicappedCarCapacity;

        public Builder compactCarCapacity(int compactCarCapacity) {
            this.compactCarCapacity = compactCarCapacity;
            return this;
        }

        public Builder regularCarCapacity(int regularCarCapacity) {
            this.regularCarCapacity = regularCarCapacity;
            return this;
        }

        public Builder handicappedCarCapacity(int handicappedCarCapacity) {
            this.handicappedCarCapacity = handicappedCarCapacity;
            return this;
        }

        public ParkingLot build() {
            return new ParkingLot(
                    new ParkingLotFragment(compactCarCapacity),
                    new ParkingLotFragment(regularCarCapacity),
                    new ParkingLotFragment(handicappedCarCapacity)
            );
        }
    }

}
