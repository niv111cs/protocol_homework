import java.util.ArrayList;
import java.util.List;

public class DB {
    private List<Vehicle> vehicles;

    public DB() {
        this.vehicles = new ArrayList<>();
    }

    // הוספת כלי רכב למערך
    public void addVehicle(Vehicle vehicle) {
        vehicles.add(vehicle);
    }

    // החזרת המערך
    public List<Vehicle> getVehicles() {
        return vehicles;
    }
}
