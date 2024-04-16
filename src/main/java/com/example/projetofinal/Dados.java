package com.example.projetofinal;

import java.sql.*;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;


public class Dados {
    public static ObservableList<Baralho> encheALista() {
        ObservableList<Baralho> lista = FXCollections.observableArrayList();
        String url = "jdbc:mysql://localhost:3306/projetolicenciatura";
        String user = "root";
        String password = "SimpsonsTheMovie2012";

        try {
            Connection conn = DriverManager.getConnection(url, user, password);
            Statement stmt = conn.createStatement();

            String query = "SELECT DISTINCT C1.NomeBaralho, (SELECT " +
                    " COUNT(*) FROM cartas C2" +
                    " WHERE C2.NomeBaralho = C1.NomeBaralho) AS Cartas FROM cartas C1";

            ResultSet rs = stmt.executeQuery(query);

            while (rs.next()) {
                String nome = rs.getString("NomeBaralho");
                int quantidade = rs.getInt("Cartas");
                lista.add(new Baralho(nome, quantidade));
            }

            rs.close();
            stmt.close();
            conn.close();
        } catch (SQLException e) {
            System.out.println("SQL Error: " + e.getMessage());
            e.printStackTrace();
        } catch (Exception e) {
            System.out.println("General Error: " + e.getMessage());
            e.printStackTrace();
        }
        return lista;
    }

    public static void apagaBaralho(String nomeDoBaralho){//repensar
        String url = "jdbc:mysql://localhost:3306/projetolicenciatura";
        String user = "root";
        String password = "SimpsonsTheMovie2012";

        try {
            Connection conn = DriverManager.getConnection(url, user, password);

            String query = "DELETE  FROM Cartas WHERE NomeBaralho = ?";
            PreparedStatement stmt = conn.prepareStatement(query);
            stmt.setString(1,nomeDoBaralho);
            int rowsAffected = stmt.executeUpdate();

            System.out.println(rowsAffected + " linhas apagadas");


            stmt.close();
            conn.close();
        } catch (SQLException e) {
            System.out.println("Cheguei aqui");
            System.out.println(nomeDoBaralho);
            System.out.println("SQL Error: " + e.getMessage());
            e.printStackTrace();
        } catch (Exception e) {
            System.out.println("General Error: " + e.getMessage());
            e.printStackTrace();
        }
    }

}
