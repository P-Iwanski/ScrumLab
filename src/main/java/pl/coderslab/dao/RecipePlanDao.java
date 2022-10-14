package pl.coderslab.dao;

import pl.coderslab.model.RecipePlan;
import pl.coderslab.utils.DbUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class RecipePlanDao {

    private static final String FIND_ALL_BY_PLAN_ID = "SELECT day_name.name as day_name, meal_name, recipe.name as recipe_name, recipe.id as recipe_id\n" +
            "FROM `recipe_plan`\n" +
            "         JOIN day_name on day_name.id=day_name_id\n" +
            "         JOIN recipe on recipe.id=recipe_id WHERE plan_id = ?\n" +
            "ORDER by day_name.display_order, recipe_plan.display_order;";

    public static List<RecipePlan> findById(int planId) {
        List<RecipePlan> recipePlanList = new ArrayList<>();
        try (Connection connection = DbUtil.getConnection();
             PreparedStatement statement = connection.prepareStatement(FIND_ALL_BY_PLAN_ID)
        ) {
            statement.setInt(1, planId);
            try (ResultSet resultSet = statement.executeQuery()) {
                while (resultSet.next()) {
                    RecipePlan recipePlan = new RecipePlan();
                    recipePlan.setMealName(resultSet.getString("meal_name"));
                    recipePlan.setDayName(resultSet.getString("day_name"));
                    recipePlan.setRecipeName(resultSet.getString("recipe_name"));
                    recipePlan.setRecipeId(resultSet.getInt("recipe_id"));
                    recipePlanList.add(recipePlan);

                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return recipePlanList;
    }
}