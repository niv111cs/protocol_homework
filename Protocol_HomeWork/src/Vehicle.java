public abstract class Vehicle implements Fixable {
    private String name;

    public Vehicle(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }


    // פונקציה מופשטת שמחזירה את הזמן הנדרש לתיקון
    public abstract int getFixTime();
}
