public interface Vehicle {
    // Makes a vehicle accelerate.
    // What that means depends greatly on the vehicle.
    void accelerate();

    // Returns a well-formatted message
    // describing the velocity.
    String getVelocityMessage();
}
