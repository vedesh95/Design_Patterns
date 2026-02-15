package creational;

class Meal {
    private String i1, i2, i3;

    public void setI1(String i1) { this.i1 = i1; }
    public void setI2(String i2) { this.i2 = i2; }
    public void setI3(String i3) { this.i3 = i3;}
}

class MealBuilder {
    private String i1, i2, i3;

    public MealBuilder setI1 (String i1) { this.i1 = i1; return this; }
    public MealBuilder setI2 (String i2) { this.i2 = i2; return this; }
    public MealBuilder setI3 (String i3) { this.i3 = i3; return this; }

    public Meal build() {
        Meal meal = new Meal();
        meal.setI1(i1);
        meal.setI2(i2);
        meal.setI3(i3);
        return meal;
    }
}
public class builder {
        public static void main(String[] args) {
            Meal meal = new MealBuilder()
                .setI1("Bread")
                .setI2("Butter")
                .setI3("Jam")
                .build();
        }
}
