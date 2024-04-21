package com.example.projetofinal;

import java.sql.*;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;


public class Dados {
    private static String url = "jdbc:mysql://localhost:3306/projetolicenciatura";
    private static String user = "root";
    private static String password = "SimpsonsTheMovie2012";
    public static ObservableList<Baralho> encheALista() {
        ObservableList<Baralho> lista = FXCollections.observableArrayList();

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

    public static void apagaBaralho(String nomeDoBaralho) {

        try {
            Connection conn = DriverManager.getConnection(url, user, password);

            String query = "DELETE  FROM Cartas WHERE NomeBaralho = ?";
            PreparedStatement stmt = conn.prepareStatement(query);
            stmt.setString(1, nomeDoBaralho);
            int rowsAffected = stmt.executeUpdate();

            System.out.println(rowsAffected + " linhas apagadas");

            query = "DELETE  FROM Baralhos WHERE NomeBaralho = ?";
            stmt = conn.prepareStatement(query);
            stmt.setString(1, nomeDoBaralho);
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

    public static void criaBaralho(String nomeDoBaralho) {
        try {
            Connection conn = DriverManager.getConnection(url, user, password);

            String query = "INSERT INTO Baralhos(NomeBaralho) VALUES(?)";
            PreparedStatement stmt = conn.prepareStatement(query);
            stmt.setString(1, nomeDoBaralho);
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

    public static boolean baralhoInexistente(String nomeDoBaralho) {
        try {
            Connection conn = DriverManager.getConnection(url, user, password);

            String query = "SELECT NomeBaralho  FROM Baralhos WHERE NomeBaralho = ?";

            PreparedStatement stmt = conn.prepareStatement(query);
            stmt.setString(1, nomeDoBaralho);

            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
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

    public static int idMaisBaixoDoBaralho(String nomeDoBaralho) {

        int idMaisBaixo = 0;
        try {
            Connection conn = DriverManager.getConnection(url, user, password);

            String query = "SELECT MIN(ID)  FROM cartas WHERE NomeBaralho = ?";

            PreparedStatement stmt = conn.prepareStatement(query);
            stmt.setString(1, nomeDoBaralho);

            ResultSet rs = stmt.executeQuery();

            rs.next();
            idMaisBaixo = rs.getInt(1);
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
        return idMaisBaixo;
    }

    public static String encheAreaDoTextoDePergunta(int idCarta)
    {
        String texto = "Texto Inicial";
        try {
            Connection conn = DriverManager.getConnection(url, user, password);

            String query = "SELECT Pergunta  FROM cartas WHERE ID = ?";

            PreparedStatement stmt = conn.prepareStatement(query);
            stmt.setString(1, Integer.toString(idCarta));

            ResultSet rs = stmt.executeQuery();

            rs.next();
            texto = rs.getString(1);

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
        return texto;
    }
    public static String encheAreaDoTextoDeResposta(int idCarta)
    {
        String texto = "Texto Inicial";
        try {
            Connection conn = DriverManager.getConnection(url, user, password);

            String query = "SELECT Resposta  FROM cartas WHERE ID = ?";

            PreparedStatement stmt = conn.prepareStatement(query);
            stmt.setString(1, Integer.toString(idCarta));

            ResultSet rs = stmt.executeQuery();

            rs.next();

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
        return texto;
    }

    public static void criaCarta(Carta carta) {
        try {
            Connection conn = DriverManager.getConnection(url, user, password);


            String query = "INSERT INTO cartas( NomeBaralho,Pergunta, Resposta,   EF,  Def1, Def2,  Intervalo, PrimeiroTermo, SegundoTermo) VALUES(?,?,?,?,?,?,?,?,?)";
            PreparedStatement stmt = conn.prepareStatement(query);
            stmt.setString(1, carta.getNomeDoBaralho());
            stmt.setString(2, carta.getPergunta());
            stmt.setString(3, carta.getResposta());
            stmt.setString(4, Double.toString(carta.getEasinessFactor()));
            stmt.setString(5, carta.getDefinicao1());
            stmt.setString(6, carta.getDefinicao2());
            stmt.setString(7, Integer.toString(carta.getIntervalo()));
            stmt.setString(8, carta.getTermo1());
            stmt.setString(9, carta.getTermo2());
            int rowsAffected = stmt.executeUpdate();

            System.out.println(rowsAffected + " cartas criadas");


        } catch (SQLException e) {
            System.out.println("Cheguei aqui");
            System.out.println(carta.getNomeDoBaralho());
            System.out.println("SQL Error: " + e.getMessage());
            e.printStackTrace();
        } catch (Exception e) {
            System.out.println("General Error: " + e.getMessage());
            e.printStackTrace();
        }
    }
}