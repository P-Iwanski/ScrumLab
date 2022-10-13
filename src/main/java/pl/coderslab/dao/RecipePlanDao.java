package pl.coderslab.dao;

import pl.coderslab.model.Plan;
import pl.coderslab.model.RecipePlan;
import pl.coderslab.utils.DbUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class RecipePlanDao {

    private static final String FIND_ALL_BY_PLAN_ID = "SELECT * FROM recipe_plan WHERE plan_id = ? ORDER BY day_name_id, display_order";

    public List<RecipePlan> findAll(Integer planId) {
        List<RecipePlan> recipePlanList = new ArrayList<>();
        try (Connection connection = DbUtil.getConnection();
             PreparedStatement statement = connection.prepareStatement(FIND_ALL_BY_PLAN_ID);
        ) {
            statement.setInt(1, planId);
            try (ResultSet resultSet = statement.executeQuery()) {
                while (resultSet.next()) {
                    RecipePlan recipePlanToAdd = new RecipePlan();
                    recipePlanToAdd.setId(resultSet.getInt("id"));
                    recipePlanToAdd.setRecipeId(resultSet.getInt("recipe_id"));
                    recipePlanToAdd.setMealName(resultSet.getString("meal_name"));
                    recipePlanToAdd.setDisplayOrder(resultSet.getInt("display_order"));
                    recipePlanToAdd.setDayNameId(resultSet.getInt("day_name_id"));
                    recipePlanToAdd.setPlanId(resultSet.getInt("plan_id"));
                    recipePlanList.add(recipePlanToAdd);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return recipePlanList;
    }
}
