package seedu.duke;

import java.util.ArrayList;
import java.util.Random;

public class FoodList {
    private ArrayList<Food> foods;

    public FoodList() {
        this.foods = new ArrayList<>();
    }

    public FoodList(ArrayList<Food> foods) {
        this.foods = foods;
    }

    public int size() {
        return foods.size();
    }

    public Food get(int i) {
        return foods.get(i);
    }

    public Food getRandomFood() {
        Random random = new Random();
        int foodIndex = random.nextInt(9);
        return foods.get(foodIndex);
    }

    public Food getFilteredFood(String preferredLocation, String preferredPrice) {
        ArrayList<Food> filteredFoods = new ArrayList<>();
        for (Food eachFood : foods) {
            if (eachFood.location.equals(preferredLocation) && eachFood.price.equals(preferredPrice)) {
                filteredFoods.add(eachFood);
            }
        }
        
        Random random = new Random();
        int filteredFoodIndex = random.nextInt(filteredFoods.size());
        return filteredFoods.get(filteredFoodIndex);
    }

    public Food getCustomisedFood(String preferredLocation, String preferredCuisine) {
        ArrayList<Food> filteredFoods = new ArrayList<>();
        for (Food eachFood : foods) {
            if (eachFood.location.equals(preferredLocation) && eachFood.cuisine.equals(preferredCuisine)) {
                filteredFoods.add(eachFood);
            }
        }
        
        Random random = new Random();
        int filteredFoodIndex = random.nextInt(filteredFoods.size());
        return filteredFoods.get(filteredFoodIndex);
    }
}


