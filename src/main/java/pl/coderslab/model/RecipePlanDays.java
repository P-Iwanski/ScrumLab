package pl.coderslab.model;

public class RecipePlanDays {

    private String dayName;
    private String mealName;
    private String recipeName;
    private int recipeId;

    public int getRecipeId() {
        return recipeId;
    }

    public void setRecipeId(int recipeId) {
        this.recipeId = recipeId;
    }

    public String getDayName() {
        return dayName;
    }
    public void setDayName(String dayName) {
        this.dayName = dayName;
    }

    public String getMealName() {
        return mealName;
    }

    public void setMealName(String mealName) {
        this.mealName = mealName;
    }

    public String getRecipeName() {
        return recipeName;
    }

    public void setRecipeName(String recipeName) {
        this.recipeName = recipeName;
    }
    public String toString() {
        return this.dayName + " " + this.mealName + " "+ this.recipeName;
    }
}
