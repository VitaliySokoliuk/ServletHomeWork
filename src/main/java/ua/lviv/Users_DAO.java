package ua.lviv;

import java.sql.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Users_DAO {

    private Connection connection;
    public static final String SELECT = "SELECT * FROM users;";
    public static final String INSERT = "insert into users (first_name, second_name, age, email, password) values(?, ?, ?, ?, ?);";

    public Users_DAO() {
        this.connection = ConnectionUtil.getConnection();
    }

    public List<Users> get(String pass){
        List<Users> usersList = new ArrayList<>();
        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(SELECT);
            while(resultSet.next()){
                usersList.add(Users.of(resultSet));
            }
            Iterator<Users> it = usersList.iterator();
            while (it.hasNext()){
                Users user = it.next();
                if (!user.getPassword().equals(pass))
                    it.remove();
            }
            statement.close();
            return usersList;
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException("Can't use data from table");
        }
    }

    public int insert(String first_name, String second_name, int age, String email, String password){
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(INSERT, Statement.RETURN_GENERATED_KEYS);
            preparedStatement.setString(1, first_name);
            preparedStatement.setString(2, second_name);
            preparedStatement.setInt(3, age);
            preparedStatement.setString(4, email);
            preparedStatement.setString(5, password);
            preparedStatement.executeUpdate();
            ResultSet key = preparedStatement.getGeneratedKeys();
            key.next();
            int res = key.getInt(1);
            preparedStatement.close();
            key.close();
            return res;
        } catch (SQLException e) {
            e.printStackTrace();
            new RuntimeException("Can't insert data into table");
            return 0;
        }
    }
}
