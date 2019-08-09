import java.util.Objects;

public final class Vehicle {

    private boolean isCompact;
    private boolean isHandicapped;
    private String owner;
    private String make;
    private String model;
    private int year;

    private Vehicle(
            boolean isCompact,
            boolean isHandicapped,
            String owner,
            String make,
            String model,
            int year) {
        this.isCompact = isCompact;
        this.isHandicapped = isHandicapped;
        this.owner = owner;
        this.make = make;
        this.model = model;
        this.year = year;
    }

    public boolean isCompact() {
        return this.isCompact;
    }

    public boolean isHandicapped() {
        return this.isHandicapped;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Vehicle vehicle = (Vehicle) o;
        return isCompact == vehicle.isCompact &&
                isHandicapped == vehicle.isHandicapped &&
                year == vehicle.year &&
                owner.equals(vehicle.owner) &&
                make.equals(vehicle.make) &&
                model.equals(vehicle.model);
    }

    @Override
    public int hashCode() {
        return Objects.hash(isCompact, isHandicapped, owner, make, model, year);
    }

    public static Builder builder() {
        return new Builder();
    }

    public static class Builder {

        private boolean isCompact;
        private boolean isHandicapped;
        private String owner;
        private String make;
        private String model;
        private int year;

        Builder() { }

        public Builder isCompact(boolean isCompact) {
            this.isCompact = isCompact;
            return this;
        }

        public Builder isHandicapped(boolean isHandicapped) {
            this.isHandicapped = isHandicapped;
            return this;
        }

        public Builder owner(String owner) {
            this.owner = owner;
            return this;
        }

        public Builder make(String make) {
            this.make = make;
            return this;
        }

        public Builder model(String model) {
            this.model = model;
            return this;
        }

        public Builder year(int year) {
            this.year = year;
            return this;
        }

        public Vehicle build() {
            if (owner == null) {
                throw new IllegalArgumentException("Vehicle Builder: Owner must not be null.");
            } else if (make == null) {
                throw new IllegalArgumentException("Vehicle Builder: Make must not be null.");
            } else if (model == null) {
                throw new IllegalArgumentException("Vehicle Builder: Model must not be null.");
            } else if (year > 2019 || year < 1900) {
                throw new IllegalArgumentException("Vehicle Builder: Year must not be between 1900 and 2019.");
            }

            return new Vehicle(
                    this.isCompact,
                    this.isHandicapped,
                    this.owner,
                    this.make,
                    this.model,
                    this.year);
        }

    }

}
