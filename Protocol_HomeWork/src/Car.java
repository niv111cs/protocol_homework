class Car extends Vehicle  {
    public Car(String name) {
        super(name);
    }

    @Override
    public int getFixTime() {
        return 5; // זמן תיקון במכונית הוא 5 שניות
    }

    @Override
    public void fixed() {
        System.out.println(getName() + ": כל ארבעת הגלגלים תוקנו");
    }
}