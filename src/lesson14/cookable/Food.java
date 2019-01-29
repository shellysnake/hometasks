package lesson14.cookable;

public class Food {
    public void prepare(Cookable c) {
        c.cook();
    }

    public static void main(String[] args) {
        Food food = new Food();
        food.prepare(new Cookable() {
            @Override
            public void cook() {
                System.out.println("Cooking");
            }
        });
    }
}
