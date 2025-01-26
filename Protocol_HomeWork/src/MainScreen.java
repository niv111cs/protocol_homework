import java.util.Scanner;

public class MainScreen {

    private static DB db = new DB();

    public static void start() {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("בחר סוג כלי רכב: 1 - אופנוע, 2 - מכונית, 3 - משאית, 0 - סיום הזנת כלי רכב");
            int type = scanner.nextInt();

            if (type == 0) {
                break; // מסיים את הלולאה אם המשתמש הזין 0
            }

            System.out.println("הזן את שם הרכב:");
            String name = scanner.next();

            Vehicle vehicle;
            switch (type) {
                case 1 -> vehicle = new Motorcycle(name);
                case 2 -> vehicle = new Car(name);
                case 3 -> vehicle = new Truck(name);
                default -> {
                    System.out.println("סוג רכב לא תקין, נסה שוב.");
                    continue; // מדלג על ההמשך ומבקש הזנה מחדש
                }
            }

            db.addVehicle(vehicle);
        }

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
