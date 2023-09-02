import database.utils.DatabaseConnection;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVPrinter;

import java.io.FileWriter;
import java.io.IOException;
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

            ResultSet resultSet = conn.prepareStatement(sql).executeQuery();

            saveResultSetToCSV(resultSet, "./PRIMEIROS_PASSOS/output_files/outputTestes.csv");

            System.out.println(resultSet.toString());

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    private static void saveResultSetToCSV(ResultSet resultSet, String fileName) {
        try (CSVPrinter csvPrinter = new CSVPrinter(new FileWriter(fileName), CSVFormat.DEFAULT)) {
            // Escrever o cabeçalho (nomes das colunas)
            csvPrinter.printRecord("ID", "mensagem");

            // Escrever os dados
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String name = resultSet.getString("mensagem");
                csvPrinter.printRecord(id, name);
            }
        } catch (IOException | SQLException e) {
            e.printStackTrace();
        }
    }

}
