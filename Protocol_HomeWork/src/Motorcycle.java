class Motorcycle extends Vehicle  {
    public Motorcycle(String name) {
        super(name);
    }

    @Override
    public int getFixTime() {
        return 3; // זמן תיקון באופנוע הוא 3 שניות
    }

    @Override
    public void fixed() {
        System.out.println(getName() + ": שני הגלגלים תוקנו");
    }
}
