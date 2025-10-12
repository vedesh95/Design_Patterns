package creational.builder;

class Meal {
    // demonstrates the Builder pattern
    private String mainCourse;
    private String sideDish;
    private String drink;
    private String dessert;
    public Meal(String mainCourse, String sideDish, String drink, String dessert) {
        this.mainCourse = mainCourse;
        this.sideDish = sideDish;
        this.drink = drink;
        this.dessert = dessert;
    }
    public String getMainCourse() { return mainCourse;}
    public String getSideDish() { return sideDish; }
    public String getDrink() { return drink; }
    public String getDessert() { return dessert; }

    public void setDessert(String dessert) { this.dessert = dessert;}
    public void setDrink(String drink) { this.drink = drink;}
    public void setMainCourse(String mainCourse) {this.mainCourse = mainCourse;}
    public void setSideDish(String sideDish) {this.sideDish = sideDish;}

    @Override
    public String toString() {
        return "Meal{" +
                "dessert='" + dessert + '\'' +
                ", mainCourse='" + mainCourse + '\'' +
                ", sideDish='" + sideDish + '\'' +
                ", drink='" + drink + '\'' +
                '}';
    }
}

class MealBuilder {
    private String mainCourse;
    private String sideDish;
    private String drink;
    private String dessert;

    public MealBuilder setMainCourse(String mainCourse) {
        this.mainCourse = mainCourse;
        return this;
    }

    public MealBuilder setSideDish(String sideDish) {
        this.sideDish = sideDish;
        return this;
    }

    public MealBuilder setDrink(String drink) {
        this.drink = drink;
        return this;
    }

    public MealBuilder setDessert(String dessert) {
        this.dessert = dessert;
        return this;
    }

    public Meal build() {
        return new Meal(mainCourse, sideDish, drink, dessert);
    }
}

public class Builder {
    public static void main(String[] args) {
        Meal meal = new MealBuilder()
                .setMainCourse("Steak")
                .setSideDish("Fries")
                .setDrink("Cola")
                .setDessert("Ice Cream")
                .build();
        System.out.println(meal);
    }
}