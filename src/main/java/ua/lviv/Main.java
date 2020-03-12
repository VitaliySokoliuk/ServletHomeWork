package ua.lviv;

// Each for test DB
public class Main {
    public static void main(String[] args) {
        Users_DAO us = new Users_DAO();
        us.insert("Vitaliy", "Sokoliuk", 20, "vit@gmail.com", "qweiop");
        us.insert("qqqwwq", "ertet", 20, "cxv@gmail.com", "qwgbnbfd");
        System.out.println(us.get("qweiop"));
    }
}
