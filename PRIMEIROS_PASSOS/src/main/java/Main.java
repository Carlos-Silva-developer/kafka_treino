import database.utils.DatabaseConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Main {

    public static void main(String[] args) {


        // testando a conexão com banco de dados
        try {

            Connection conn = DatabaseConnection.getConnection();
            String sql = "select * from teste_kafka";

            PreparedStatement statement = conn.prepareStatement(sql);
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                String text = resultSet.getString("mensagem");
                System.out.println(text);
            }

            System.out.println(resultSet.toString());

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }


    }
}
