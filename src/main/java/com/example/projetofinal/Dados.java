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

            String query = "SELECT DISTINCT B.NomeBaralho, (SELECT " +
                    " COUNT(*) FROM Cartas C" +
                    " WHERE C.NomeBaralho = B.NomeBaralho) AS Cartas FROM Baralhos B";

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

    public static void apagaBaralho(String nomeDoBaralho){
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

            query = "DELETE  FROM Baralhos WHERE NomeBaralho = ?";
            stmt = conn.prepareStatement(query);
            stmt.setString(1,nomeDoBaralho);
            rowsAffected = stmt.executeUpdate();

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

    public static void criaBaralho(String nomeDoBaralho){
        String url = "jdbc:mysql://localhost:3306/projetolicenciatura";
        String user = "root";
        String password = "SimpsonsTheMovie2012";
        try {
            Connection conn = DriverManager.getConnection(url, user, password);

            String query = "INSERT INTO Baralhos(NomeBaralho) VALUES(?)";
            PreparedStatement stmt = conn.prepareStatement(query);
            stmt.setString(1,nomeDoBaralho);
            int rowsAffected = stmt.executeUpdate();

            System.out.println(rowsAffected + " baralhos criados");


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

    public static boolean baralhoInexistente(String nomeDoBaralho){
        String url = "jdbc:mysql://localhost:3306/projetolicenciatura";
        String user = "root";
        String password = "SimpsonsTheMovie2012";
        try {
            Connection conn = DriverManager.getConnection(url, user, password);

            String query = "SELECT NomeBaralho  FROM Baralhos WHERE NomeBaralho = ?";

            PreparedStatement stmt = conn.prepareStatement(query);
            stmt.setString(1,nomeDoBaralho);

            ResultSet rs = stmt.executeQuery();

            if(rs.next()){
                return false;
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
        return true;
    }

}
