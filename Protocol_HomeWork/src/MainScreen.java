import java.util.Scanner;

public class MainScreen {

    private static DB db = new DB();

    public static void start() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("בחר סוג כלי רכב: 1 - אופנוע, 2 - מכונית, 3 - משאית");
        int type = scanner.nextInt();

        System.out.println("הזן את שם הרכב:");
        String name = scanner.next();

        Vehicle vehicle;
        switch (type) {
            case 1 -> vehicle = new Motorcycle(name);
            case 2 -> vehicle = new Car(name);
            case 3 -> vehicle = new Truck(name);
            default -> throw new IllegalArgumentException("סוג רכב לא תקין");
        }

        db.addVehicle(vehicle);

        Garage garage = new Garage(protocolGarage, db.getVehicles());
        garage.start();
    }

    private static Protocol_Garage protocolGarage = new Protocol_Garage() {
        @Override
        public void fixed() {
            System.out.println("כלי הרכב תוקנו בהצלחה!");
        }
    };

    public static void main(String[] args) {
        start();
    }
}
