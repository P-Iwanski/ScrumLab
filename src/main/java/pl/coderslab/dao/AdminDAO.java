package pl.coderslab.dao;

import org.mindrot.jbcrypt.BCrypt;
import pl.coderslab.exception.NotFoundException;
import pl.coderslab.model.Admin;
import pl.coderslab.utils.DbUtil;

import java.io.UnsupportedEncodingException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import static org.mindrot.jbcrypt.BCrypt.gensalt;
import static org.mindrot.jbcrypt.BCrypt.hashpw;

public class AdminDAO {

    private static final String CREATE_ADMIN_QUERY = "INSERT INTO admins(first_name, last_name, email, password, superadmin, enable) VALUES (?,?,?,?,?,?);";
    private static final String DELETE_ADMIN_QUERY = "DELETE FROM admins where id = ?;";
    private static final String FIND_ALL_ADMINS_QUERY = "SELECT * FROM admins;";
    private static final String READ_ADMIN_QUERY = "SELECT * from admins where id = ?;";
    private static final String UPDATE_ADMIN_QUERY = "UPDATE admins SET first_name = ? , last_name = ?, email = ?, password = ?, superadmin = ?, enable = ? WHERE	id = ?;";
    private static final String CHECK_EMAIL = "SELECT password FROM admins where email = ?;";

    //private static final String SALT = BCrypt.gensalt(6);
    private static final String SALT = "$2a$06$bjyVhqrhzzg592VySdTcuu";


    /**
     * Get admin by id
     *
     * @param adminId
     * @return
     */

    public static Admin read(Integer adminId) {
        Admin admin = new Admin();
        try (Connection connection = DbUtil.getConnection();
             PreparedStatement statement = connection.prepareStatement(READ_ADMIN_QUERY)
        ) {
            statement.setInt(1, adminId);
            try (ResultSet resultSet = statement.executeQuery()) {
                while (resultSet.next()) {
                    admin.setId(resultSet.getInt("id"));
                    admin.setFirstName(resultSet.getString("first_name"));
                    admin.setLastName(resultSet.getString("last_name"));
                    admin.setEmail(resultSet.getString("email"));
                    admin.setSuperadmin(resultSet.getInt("superadmin"));
                    admin.setEnable(resultSet.getInt("enable"));

                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return admin;

    }

    /**
     * Return all admins
     *
     * @return
     */
    public static List<Admin> findAll() {
        List<Admin> adminsList = new ArrayList<>();
        try (Connection connection = DbUtil.getConnection();
             PreparedStatement statement = connection.prepareStatement(FIND_ALL_ADMINS_QUERY);
             ResultSet resultSet = statement.executeQuery()) {

            while (resultSet.next()) {
                Admin adminToAdd = new Admin();
                adminToAdd.setId(resultSet.getInt("id"));
                adminToAdd.setFirstName(resultSet.getString("first_name"));
                adminToAdd.setLastName(resultSet.getString("last_name"));
                adminToAdd.setEmail(resultSet.getString("email"));
                adminToAdd.setPassword(resultSet.getString("password"));
                adminToAdd.setSuperadmin(resultSet.getInt("superadmin"));
                adminToAdd.setEnable(resultSet.getInt("enable"));
                adminsList.add(adminToAdd);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return adminsList;

    }

    /**
     * Create admin
     *
     * @param admin
     * @return
     */
    public static Admin create(Admin admin) {
        try (Connection connection = DbUtil.getConnection();
             PreparedStatement insertStm = connection.prepareStatement(CREATE_ADMIN_QUERY,
                     Statement.RETURN_GENERATED_KEYS)) {
            insertStm.setString(1, admin.getFirstName());
            insertStm.setString(2, admin.getLastName());
            insertStm.setString(3, admin.getEmail());
            insertStm.setString(4, hashPassword(admin.getPassword()));
            insertStm.setInt(5, admin.getSuperadmin());
            insertStm.setInt(6, admin.getEnable());
            int result = insertStm.executeUpdate();

            if (result != 1) {
                throw new RuntimeException("Execute update returned " + result);
            }

            try (ResultSet generatedKeys = insertStm.getGeneratedKeys()) {
                if (generatedKeys.first()) {
                    admin.setId(generatedKeys.getInt(1));
                    return admin;
                } else {
                    throw new RuntimeException("Generated key was not found");
                }

            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return admin;
    }

    /**
     * Remove admin by id
     *
     * @param adminId
     */
    public static void delete(Integer adminId) {
        try (Connection connection = DbUtil.getConnection();
             PreparedStatement statement = connection.prepareStatement(DELETE_ADMIN_QUERY)) {
            statement.setInt(1, adminId);
            statement.executeUpdate();

            boolean deleted = statement.execute();
            if (!deleted) {
                throw new NotFoundException("Product not found");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * Update admin
     *
     * @param admin
     */
    public static void update(Admin admin) {
        try (Connection connection = DbUtil.getConnection();
             PreparedStatement statement = connection.prepareStatement(UPDATE_ADMIN_QUERY)) {
            statement.setInt(7, admin.getId());
            statement.setString(1, admin.getFirstName());
            statement.setString(2, admin.getLastName());
            statement.setString(3, admin.getEmail());
            statement.setString(4, admin.getPassword());
            statement.setInt(5, admin.getSuperadmin());
            statement.setInt(6, admin.getEnable());

            statement.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static String hashPassword(String password) {
        return hashpw(password, SALT);
    }

    public static boolean checkLogin(String email, String password) {

        try (Connection connection = DbUtil.getConnection();
             PreparedStatement statement = connection.prepareStatement(CHECK_EMAIL)
        ) {
            statement.setString(1, email);
            try (ResultSet resultSet = statement.executeQuery()) {
                if (!resultSet.next()) {
                    return false;
                }
                if (!resultSet.getString("password").equals(hashPassword(password)) ) {
                    System.out.println(hashPassword(password));
                    System.out.println(resultSet.getString("password"));
                    return false;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
            return true;
    }

}
