package ua.lviv;

import java.sql.ResultSet;
import java.sql.SQLException;

public class Users {
    public Users() {
    }

    public Users(int id, String first_name, String second_name, int age, String email, String password) {
        this.id = id;
        this.first_name = first_name;
        this.second_name = second_name;
        this.age = age;
        this.email = email;
        this.password = password;
    }

    private int id;
    private String first_name;
    private String second_name;
    private int age;
    private String email;
    private String password;

    public static Users of(ResultSet resultSet) {
        Users user = new Users();
        try {
            user.setId(resultSet.getInt("id"));
            user.setFirst_name(resultSet.getString("first_name"));
            user.setSecond_name(resultSet.getString("second_name"));
            user.setAge(resultSet.getInt("age"));
            user.setEmail(resultSet.getString("email"));
            user.setPassword(resultSet.getString("password"));
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return user;
    }

    @Override
    public String toString() {
        return "Users{" +
                "id=" + id +
                ", first_name='" + first_name + '\'' +
                ", second_name='" + second_name + '\'' +
                ", age=" + age +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public String getSecond_name() {
        return second_name;
    }

    public void setSecond_name(String second_name) {
        this.second_name = second_name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
