package pl.coderslab.dao;

import pl.coderslab.model.RecipePlan;
import pl.coderslab.model.RecipePlan;
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
    private static final String GET_PLAN_ID = "SELECT id FROM plan WHERE name = ?";
    private static final String GET_RECIPE_ID = "SELECT id FROM recipe WHERE name = ?";
    private static final String GET_DAY_ID = "SELECT id FROM day_name WHERE name = ?";
    private static final String CREATE_RECIPE_PLAN = "INSERT INTO recipe_plan (recipe_id, meal_name, display_order, day_name_id, plan_id) VALUES (?, ?, ?, ?, ?)";

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

    public RecipePlan create(RecipePlan recipePlan) {
        try (Connection connection = DbUtil.getConnection();
             PreparedStatement statement = connection.prepareStatement(CREATE_RECIPE_PLAN, PreparedStatement.RETURN_GENERATED_KEYS)) {
            statement.setInt(1, recipePlan.getRecipeId());
            statement.setString(2, recipePlan.getMealName());
            statement.setInt(3, recipePlan.getDisplayOrder());
            statement.setInt(4, recipePlan.getDayNameId());
            statement.setInt(5, recipePlan.getPlanId());

            int result = statement.executeUpdate();

            if (result != 1) {
                throw new RuntimeException("Execute update returned " + result);
            }

            try (ResultSet generatedKeys = statement.getGeneratedKeys()) {
                if (generatedKeys.first()) {
                    recipePlan.setId(generatedKeys.getInt(1));
                    return recipePlan;
                } else {
                    throw new RuntimeException("Generated key was not found");
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return recipePlan;
    }

    public int readPlanId(String name) {
        int planId = 0;
        try (Connection connection = DbUtil.getConnection();
             PreparedStatement statement = connection.prepareStatement(GET_PLAN_ID)
        ) {
            statement.setString(1, name);
            try (ResultSet resultSet = statement.executeQuery()) {
                if (resultSet.next()) {
                    planId += resultSet.getInt("id");
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return planId;
    }

    public int readRecipeId(String name) {
        int recipeId = 0;
        try (Connection connection = DbUtil.getConnection();
             PreparedStatement statement = connection.prepareStatement(GET_RECIPE_ID)
        ) {
            statement.setString(1, name);
            try (ResultSet resultSet = statement.executeQuery()) {
                if (resultSet.next()) {
                    recipeId += resultSet.getInt("id");
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return recipeId;
    }

    public int readDayId(String name) {
        int dayId = 0;
        try (Connection connection = DbUtil.getConnection();
             PreparedStatement statement = connection.prepareStatement(GET_DAY_ID)
        ) {
            statement.setString(1, name);
            try (ResultSet resultSet = statement.executeQuery()) {
                if (resultSet.next()) {
                    dayId = resultSet.getInt("id");
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return dayId;
    }
}