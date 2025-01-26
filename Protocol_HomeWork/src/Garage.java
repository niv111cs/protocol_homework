import java.util.List;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class Garage {

    private Protocol_Garage protocol;
    private List<Vehicle> vehicles;
    private int currentIndex = 0;
    private int remainingFixTime = 0;

    public Garage(Protocol_Garage protocol, List<Vehicle> vehicles) {
        this.protocol = protocol;
        this.vehicles = vehicles;
    }

    public void start() {
        ScheduledExecutorService executor = Executors.newScheduledThreadPool(1);
        executor.scheduleAtFixedRate(() -> tick(), 0, 1, TimeUnit.SECONDS);
    }

    private void tick() {
        if (currentIndex < vehicles.size()) {
            Vehicle currentVehicle = vehicles.get(currentIndex);

            // הגדרה של זמן התיקון הנותר אם זה הצעד הראשון עבור הרכב הזה
            if (remainingFixTime == 0) {
                remainingFixTime = currentVehicle.getFixTime();
                System.out.println("מתקן את: " + currentVehicle.getName());
            }

            // הקטנה של הזמן הנותר לתיקון
            remainingFixTime--;

            // כאשר זמן התיקון מגיע ל-0, מתקן את הרכב
            if (remainingFixTime == 0) {
                if (currentVehicle instanceof Fixable) {
                    ((Fixable) currentVehicle).fixed();
                }
                currentIndex++;
            }
        } else {
            // כאשר כל הרכבים תוקנו
            System.out.println("כל כלי הרכב תוקנו!");
            protocol.fixed();
        }
    }
}
