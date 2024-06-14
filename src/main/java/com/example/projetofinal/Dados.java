package com.example.projetofinal;

import java.sql.*;
import java.time.LocalDate;


import javafx.collections.FXCollections;
import javafx.collections.ObservableList;


public class Dados {
    private static String url = "jdbc:mysql://83.212.82.184:3306/projetolicenciatura";
    private static String user = "pc";
    private static String password = "RKFTEGB4uZ";
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

    public static ObservableList<Baralho> encheAListaDoRever() {
        ObservableList<Baralho> lista = FXCollections.observableArrayList();

        try {
            Connection conn = DriverManager.getConnection(url, user, password);
            Statement stmt = conn.createStatement();

            String query = "SELECT DISTINCT B.NomeBaralho, (SELECT " +
                    " COUNT(*) FROM Cartas C WHERE ((DATEDIFF(CURDATE(),DataUltimoUso) >= C.Intervalo)" +
                    " OR Intervalo IS NULL  )" +
                    " AND C.NomeBaralho = B.NomeBaralho ) AS Cartas FROM Baralhos B";

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

            conn.close();
            stmt.close();

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
            stmt.setInt(1, idCarta);

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
            stmt.setInt(1, idCarta);

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

    public static void criaCarta(Carta carta) {
        try {
            Connection conn = DriverManager.getConnection(url, user, password);


            String query = "INSERT INTO cartas( NomeBaralho,Pergunta, Resposta,   EF,  Def1, Def2,  PrimeiroTermo, SegundoTermo, OrdemDaRepeticao) VALUES(?,?,?,?,?,?,?,?,?)";
            PreparedStatement stmt = conn.prepareStatement(query);
            stmt.setString(1, carta.getNomeDoBaralho());
            stmt.setString(2, carta.getPergunta());
            stmt.setString(3, carta.getResposta());

            stmt.setDouble(4, carta.getEasinessFactor());
            stmt.setString(5, carta.getDefinicao1());
            stmt.setString(6, carta.getDefinicao2());
            stmt.setString(7, carta.getTermo1());
            stmt.setString(8, carta.getTermo2());
            stmt.setInt(9,carta.getOrdemDaRepeticao());
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

    public static int encontraIdProximaCarta(int ID , String nomeBaralho)
    {
        int valor = -1;
        try {
            Connection conn = DriverManager.getConnection(url, user, password);

            String query = "SELECT MIN(ID) AS next  FROM cartas WHERE ID > ? AND NomeBaralho = ? ";

            PreparedStatement stmt = conn.prepareStatement(query);
            stmt.setInt(1, ID);
            stmt.setString(2, nomeBaralho);

            ResultSet rs = stmt.executeQuery();

            rs.next();
            valor = rs.getInt(1);
            if(valor == 0){
                valor = Dados.idMaisBaixoDoBaralho(nomeBaralho);
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
        return valor;
    }

    public static int idMaisAltoDoBaralho(String nomeDoBaralho)
    {
        int idMaisAlto = 0;
        try {
            Connection conn = DriverManager.getConnection(url, user, password);

            String query = "SELECT MAX(ID)  FROM cartas WHERE NomeBaralho = ?";

            PreparedStatement stmt = conn.prepareStatement(query);
            stmt.setString(1, nomeDoBaralho);

            ResultSet rs = stmt.executeQuery();

            rs.next();
            idMaisAlto = rs.getInt(1);
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
        return idMaisAlto;
    }

    public static int encontraIdCartaAnterior(int ID, String nomeBaralho)
    {
        int valor = -1;
        try {
            Connection conn = DriverManager.getConnection(url, user, password);

            String query = "SELECT MAX(ID) AS preceeding FROM cartas WHERE ID < ? AND NomeBaralho = ? ";

            PreparedStatement stmt = conn.prepareStatement(query);
            stmt.setInt(1, ID);
            stmt.setString(2, nomeBaralho);

            ResultSet rs = stmt.executeQuery();

            rs.next();
            valor = rs.getInt(1);
            if(valor == 0){
                valor = Dados.idMaisAltoDoBaralho(nomeBaralho);
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
        return valor;
    }

    public static void removerCarta(int ID)
    {
        try {
            Connection conn = DriverManager.getConnection(url, user, password);


            String query = "DELETE FROM cartas WHERE ID = ?";
            PreparedStatement stmt = conn.prepareStatement(query);
            stmt.setInt(1, ID);

            int rowsAffected = stmt.executeUpdate();

            System.out.println(rowsAffected + " cartas apagadas");
            stmt.close();
            conn.close();


        } catch (SQLException e) {
            System.out.println("Cheguei aqui");

            System.out.println("SQL Error: " + e.getMessage());
            e.printStackTrace();
        } catch (Exception e) {
            System.out.println("General Error: " + e.getMessage());
            e.printStackTrace();
        }
    }

    public static void alteraPergunta(String novaPergunta, int ID)
    {
        try {
            Connection conn = DriverManager.getConnection(url, user, password);

            String query = "UPDATE cartas SET Pergunta = ? WHERE ID = ?";
            PreparedStatement stmt = conn.prepareStatement(query);
            stmt.setString(1, novaPergunta);
            stmt.setInt(2,ID);
            int rowsAffected = stmt.executeUpdate();

            System.out.println(rowsAffected + " cartas alteradas");

            conn.close();
            stmt.close();

        } catch (SQLException e) {
            System.out.println("Cheguei aqui");
            System.out.println("SQL Error: " + e.getMessage());
            e.printStackTrace();
        } catch (Exception e) {
            System.out.println("General Error: " + e.getMessage());
            e.printStackTrace();
        }
    }

    public static void alteraResposta(String novaResposta, int ID)
    {
        try {
            Connection conn = DriverManager.getConnection(url, user, password);

            String query = "UPDATE cartas SET Resposta = ? WHERE ID = ?";
            PreparedStatement stmt = conn.prepareStatement(query);
            stmt.setString(1, novaResposta);
            stmt.setInt(2,ID);
            int rowsAffected = stmt.executeUpdate();

            System.out.println(rowsAffected + " cartas alteradas");

            conn.close();
            stmt.close();

        } catch (SQLException e) {
            System.out.println("Cheguei aqui");
            System.out.println("SQL Error: " + e.getMessage());
            e.printStackTrace();
        } catch (Exception e) {
            System.out.println("General Error: " + e.getMessage());
            e.printStackTrace();
        }

    }

    public static void novaDefinicao1(String novoTermo1 ,String novaDefinicao1, int ID)
    {
        try {
            Connection conn = DriverManager.getConnection(url, user, password);

            String query = "UPDATE cartas SET PrimeiroTermo = ? , Def1 = ? WHERE ID = ?";
            PreparedStatement stmt = conn.prepareStatement(query);
            stmt.setString(1, novoTermo1);
            stmt.setString(2,novaDefinicao1);
            stmt.setInt(3,ID);
            int rowsAffected = stmt.executeUpdate();

            System.out.println(rowsAffected + " cartas alteradas");

            conn.close();
            stmt.close();

        } catch (SQLException e) {
            System.out.println("Cheguei aqui");
            System.out.println("SQL Error: " + e.getMessage());
            e.printStackTrace();
        } catch (Exception e) {
            System.out.println("General Error: " + e.getMessage());
            e.printStackTrace();
        }
    }

    public static void novaDefinicao2(String novoTermo2, String novaDefinicao2, int ID)
    {
        try {
            Connection conn = DriverManager.getConnection(url, user, password);

            String query = "UPDATE cartas SET SegundoTermo = ?, Def2 = ? WHERE ID = ?";
            PreparedStatement stmt = conn.prepareStatement(query);
            stmt.setString(1, novoTermo2);
            stmt.setString(2,novaDefinicao2);
            stmt.setInt(3,ID);
            int rowsAffected = stmt.executeUpdate();

            System.out.println(rowsAffected + " cartas alteradas");

            conn.close();
            stmt.close();

        } catch (SQLException e) {
            System.out.println("Cheguei aqui");
            System.out.println("SQL Error: " + e.getMessage());
            e.printStackTrace();
        } catch (Exception e) {
            System.out.println("General Error: " + e.getMessage());
            e.printStackTrace();
        }
    }

    public static String encontraTermo1(int ID)
    {
        String texto = "Texto Inicial";
        try {
            Connection conn = DriverManager.getConnection(url, user, password);

            String query = "SELECT PrimeiroTermo  FROM cartas WHERE ID = ?";

            PreparedStatement stmt = conn.prepareStatement(query);
            stmt.setInt(1, ID);

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

    public static String encontraTermo2(int ID)
    {
        String texto = "Texto Inicial";
        try {
            Connection conn = DriverManager.getConnection(url, user, password);

            String query = "SELECT SegundoTermo  FROM cartas WHERE ID = ?";

            PreparedStatement stmt = conn.prepareStatement(query);
            stmt.setInt(1, ID);

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

    public static String encontraDefinicao1(int ID)
    {
        String texto = "Texto Inicial";
        try {
            Connection conn = DriverManager.getConnection(url, user, password);

            String query = "SELECT Def1  FROM cartas WHERE ID = ?";

            PreparedStatement stmt = conn.prepareStatement(query);
            stmt.setInt(1, ID);

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

    public static String encontraDefinicao2(int ID)
    {
        String texto = "Texto Inicial";
        try {
            Connection conn = DriverManager.getConnection(url, user, password);

            String query = "SELECT Def2  FROM cartas WHERE ID = ?";

            PreparedStatement stmt = conn.prepareStatement(query);
            stmt.setInt(1, ID);

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

    public static int encontraOrdemDeRepeticao(int ID)
    {
        int ordem = -1;
        try {
            Connection conn = DriverManager.getConnection(url, user, password);

            String query = "SELECT OrdemDaRepeticao  FROM cartas WHERE ID = ?";

            PreparedStatement stmt = conn.prepareStatement(query);
            stmt.setInt(1, ID);

            ResultSet rs = stmt.executeQuery();

            rs.next();
            ordem = rs.getInt(1);

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
        System.out.println("Classe dados OR desta: " + ordem);
        return ordem;
    }

    public static double encontraEF(int ID)
    {
        double EF = -1.0;
        try {
            Connection conn = DriverManager.getConnection(url, user, password);

            String query = "SELECT EF  FROM cartas WHERE ID = ?";

            PreparedStatement stmt = conn.prepareStatement(query);
            stmt.setInt(1, ID);

            ResultSet rs = stmt.executeQuery();

            rs.next();
            EF = rs.getDouble(1);

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
        System.out.println("Classe dados EF desta:" + EF);
        return EF;
    }

    public static int encontraIntervaloAtual(int ID)
    {
        int intervalo = -1;
        try {
            Connection conn = DriverManager.getConnection(url, user, password);

            String query = "SELECT Intervalo  FROM cartas WHERE ID = ?";

            PreparedStatement stmt = conn.prepareStatement(query);
            stmt.setInt(1, ID);

            ResultSet rs = stmt.executeQuery();

            rs.next();
            intervalo = rs.getInt(1);

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
        System.out.println("Classe dados intervalo atual desta antes do algoritmo: " + intervalo);
        return intervalo;
    }

    ///Dados do revisor

    public static void carregaIntervaloAtual(int intervaloAtual, int ID)
    {
        try {
            Connection conn = DriverManager.getConnection(url, user, password);

            String query = "UPDATE cartas SET Intervalo = ? WHERE ID = ?";
            PreparedStatement stmt = conn.prepareStatement(query);
            stmt.setInt(1, intervaloAtual);
            stmt.setInt(2,ID);
            int rowsAffected = stmt.executeUpdate();

            System.out.println(rowsAffected + " cartas alteradas");

            conn.close();
            stmt.close();

        } catch (SQLException e) {
            System.out.println("Cheguei aqui");
            System.out.println("SQL Error: " + e.getMessage());
            e.printStackTrace();
        } catch (Exception e) {
            System.out.println("General Error: " + e.getMessage());
            e.printStackTrace();
        }
    }

    public static void carregaOrdemDeRepeticao(int OR, int ID)
    {
        try {
            Connection conn = DriverManager.getConnection(url, user, password);

            String query = "UPDATE cartas SET OrdemDaRepeticao = ? WHERE ID = ?";
            PreparedStatement stmt = conn.prepareStatement(query);
            stmt.setInt(1, OR);
            stmt.setInt(2,ID);
            int rowsAffected = stmt.executeUpdate();

            System.out.println(rowsAffected + " cartas alteradas");

            conn.close();
            stmt.close();

        } catch (SQLException e) {
            System.out.println("Cheguei aqui");
            System.out.println("SQL Error: " + e.getMessage());
            e.printStackTrace();
        } catch (Exception e) {
            System.out.println("General Error: " + e.getMessage());
            e.printStackTrace();
        }
    }

    public static void carregaDataAtual(LocalDate localDate, int ID)
    {
        java.sql.Date date = java.sql.Date.valueOf(localDate);
        try {
            Connection conn = DriverManager.getConnection(url, user, password);

            String query = "UPDATE cartas SET DataUltimoUso = ? WHERE ID = ?";
            PreparedStatement stmt = conn.prepareStatement(query);
            stmt.setDate(1, date);
            stmt.setInt(2, ID);
            int rowsAffected = stmt.executeUpdate();

            System.out.println(rowsAffected + " cartas alteradas");

            conn.close();
            stmt.close();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static void carregaEF(double EF, int ID)
    {

        try {
            Connection conn = DriverManager.getConnection(url, user, password);

            String query = "UPDATE cartas SET EF = ? WHERE ID = ?";
            PreparedStatement stmt = conn.prepareStatement(query);
            stmt.setDouble(1, EF);
            stmt.setInt(2,ID);
            int rowsAffected = stmt.executeUpdate();

            System.out.println(rowsAffected + " cartas alteradas");

            conn.close();
            stmt.close();

        } catch (SQLException e) {
            System.out.println("Cheguei aqui");
            System.out.println("SQL Error: " + e.getMessage());
            e.printStackTrace();
        } catch (Exception e) {
            System.out.println("General Error: " + e.getMessage());
            e.printStackTrace();
        }
    }

    public static void carregaIntervaloAnterior(int intervaloAnterior, int ID)
    {

        try {
            Connection conn = DriverManager.getConnection(url, user, password);

            String query = "UPDATE cartas SET IntervaloAnterior = ? WHERE ID = ?";
            PreparedStatement stmt = conn.prepareStatement(query);
            stmt.setInt(1, intervaloAnterior);
            stmt.setInt(2,ID);
            int rowsAffected = stmt.executeUpdate();

            System.out.println(rowsAffected + " cartas alteradas");

            conn.close();
            stmt.close();

        } catch (SQLException e) {
            System.out.println("Cheguei aqui");
            System.out.println("SQL Error: " + e.getMessage());
            e.printStackTrace();
        } catch (Exception e) {
            System.out.println("General Error: " + e.getMessage());
            e.printStackTrace();
        }
    }


    public static void algoritmoQueReve(int ID, int qualidadeDaResposta)
    {
        double EF = encontraEF(ID);
        if(qualidadeDaResposta >= 3) {
            int OR = encontraOrdemDeRepeticao(ID), intervaloAtual, intervaloAnterior;

            LocalDate agora ;


            if(OR == 1) {
                intervaloAtual = 1;
                OR++;
                agora= LocalDate.now();
                EF = EF + (0.1- (5- qualidadeDaResposta) * (0.08 + (5- qualidadeDaResposta)* 0.02));

                carregaIntervaloAtual(intervaloAtual,ID);
                carregaOrdemDeRepeticao(OR,ID);
                carregaDataAtual(agora,ID);
                if(EF < 1.3)
                    EF = 1.3;
                carregaEF(EF, ID);
                //carregar o intervalo atual e OR e a data e o EF
            }
            else if (OR == 2) {
                intervaloAtual = Dados.encontraIntervaloAtual(ID);
                intervaloAnterior = intervaloAtual;
                EF = EF + (0.1- (5- qualidadeDaResposta) * (0.08 + (5- qualidadeDaResposta)* 0.02));
                intervaloAtual = 6;
                OR++;
                agora= LocalDate.now();


                carregaIntervaloAtual(intervaloAtual,ID);
                carregaIntervaloAnterior(intervaloAnterior,ID);
                carregaOrdemDeRepeticao(OR,ID);
                carregaDataAtual(agora,ID);
                if(EF < 1.3)
                    EF = 1.3;
                carregaEF(EF,ID);
                //carregar o intervalo atual e anterior e OR e a data e o EF
            }
            else{
                intervaloAtual = Dados.encontraIntervaloAtual(ID);
                intervaloAnterior = intervaloAtual;
                EF = EF + (0.1- (5- qualidadeDaResposta) * (0.08 + (5- qualidadeDaResposta)* 0.02));
                intervaloAtual = (int) (intervaloAnterior * EF);
                OR++;
                agora= LocalDate.now();
                carregaIntervaloAtual(intervaloAtual,ID);
                carregaIntervaloAnterior(intervaloAnterior,ID);
                if(EF < 1.3)
                    EF = 1.3;
                carregaEF(EF,ID);
                carregaOrdemDeRepeticao(OR, ID);
                carregaDataAtual(agora,ID);

                //carregar o intervalo atual, o anterior, ef e OR e a data
            }
        }
        else{
            EF = EF + (0.1- (5- qualidadeDaResposta) * (0.08 + (5- qualidadeDaResposta)* 0.02));
            if(EF < 1.3)
                EF = 1.3;
            carregaEF(EF, ID);
            //carrega o EF

            //volta para uma carta aleatoria qualquer
        }

    }

    public static int encontraIDAleatorioDosRevisiveis(String nomeDoBaralho){///Por Testar
        int id = 0;
        try {
            Connection conn = DriverManager.getConnection(url, user, password);

            String query = "SELECT ID  FROM cartas WHERE (NomeBaralho = ?)"+
                    "AND ((DATEDIFF(CURDATE(),DataUltimoUso) >= Intervalo)OR Intervalo IS NULL  )"+
                    "ORDER BY RAND()"+
                    "LIMIT 1";

            PreparedStatement stmt = conn.prepareStatement(query);
            stmt.setString(1, nomeDoBaralho);

            ResultSet rs = stmt.executeQuery();

            rs.next();
            id = rs.getInt(1);
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
        return id;
    }

   /* public static int encontraIDMaisBaixoDoBaralhoDasRevisiveis(String nomeDoBaralho)///Vai cair em desuso
    {
        int idMaisBaixo = 0;
        try {
            Connection conn = DriverManager.getConnection(url, user, password);

            String query = "SELECT MIN(ID)  FROM cartas WHERE (NomeBaralho = ?)"+
                    "AND ((DATEDIFF(CURDATE(),DataUltimoUso) >= Intervalo)OR Intervalo IS NULL  )";

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
    }*/
}