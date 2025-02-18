import java.util.List;
import java.util.ArrayList;

interface MealPlan {
    String getMealType();
    String getDescription();
}

class VegetarianMeal implements MealPlan {
    private String description;

    public VegetarianMeal(String description) {
        this.description = description;
    }

    @Override
    public String getMealType() {
        return "Vegetarian";
    }

    @Override
    public String getDescription() {
        return description;
    }
}

class VeganMeal implements MealPlan {
    private String description;

    public VeganMeal(String description) {
        this.description = description;
    }

    @Override
    public String getMealType() {
        return "Vegan";
    }

    @Override
    public String getDescription() {
        return description;
    }
}

class KetoMeal implements MealPlan {
    private String description;

    public KetoMeal(String description) {
        this.description = description;
    }

    @Override
    public String getMealType() {
        return "Keto";
    }

    @Override
    public String getDescription() {
        return description;
    }
}

class HighProteinMeal implements MealPlan {
    private String description;

    public HighProteinMeal(String description) {
        this.description = description;
    }

    @Override
    public String getMealType() {
        return "High-Protein";
    }

    @Override
    public String getDescription() {
        return description;
    }
}

class Meal<T extends MealPlan> {
    private T mealPlan;

    public Meal(T mealPlan) {
        this.mealPlan = mealPlan;
    }

    public void displayMealDetails() {
        System.out.println("Meal Type: " + mealPlan.getMealType());
        System.out.println("Description: " + mealPlan.getDescription());
    }

    public static <T extends MealPlan> void generateMealPlan(T mealPlan) {
        System.out.println("Generating personalized meal plan for " + mealPlan.getMealType());
        System.out.println("Description: " + mealPlan.getDescription());
    }
}

public class MealPlanGenerator {
    public static void main(String[] args) {
        VegetarianMeal vegetarianMeal = new VegetarianMeal("A delicious plant-based meal with vegetables and grains.");
        VeganMeal veganMeal = new VeganMeal("A fully vegan meal with plant-based ingredients.");
        KetoMeal ketoMeal = new KetoMeal("A low-carb, high-fat meal for those following the keto diet.");
        HighProteinMeal highProteinMeal = new HighProteinMeal("A meal rich in protein for muscle building and recovery.");

        Meal<VegetarianMeal> vegetarianMealObj = new Meal<>(vegetarianMeal);
        Meal<VeganMeal> veganMealObj = new Meal<>(veganMeal);
        Meal<KetoMeal> ketoMealObj = new Meal<>(ketoMeal);
        Meal<HighProteinMeal> highProteinMealObj = new Meal<>(highProteinMeal);

        vegetarianMealObj.displayMealDetails();
        veganMealObj.displayMealDetails();
        ketoMealObj.displayMealDetails();
        highProteinMealObj.displayMealDetails();

        System.out.println("\nGenerating Meal Plans:");
        Meal.generateMealPlan(vegetarianMeal);
        Meal.generateMealPlan(veganMeal);
        Meal.generateMealPlan(ketoMeal);
        Meal.generateMealPlan(highProteinMeal);
    }
}
