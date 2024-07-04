package Controller;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import Model.Card;

public class DBController {
    
    static DatabaseHandler conn = new DatabaseHandler();

    // SEARCH/GET KTP
    public static Card getCard(int id) {

        Card card = new Card();

        try {

            conn.connect();
            String query = "SELECT * FROM users WHERE id='" + id + "'";
            Statement stmt = conn.con.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            
            if (rs.next()) {
                
                do {

                    card.setNama(rs.getString("nama"));
                    card.setJenisKelamin(rs.getString("jenis_kelamin"));
                    card.setTanggalLahir(rs.getString("tanggal_lahir"));
                    card.setTanggalPembuatan(rs.getString("tanggal_pembuatan"));
                    card.setMasaBerlaku(rs.getString("masa_berlaku"));
                    card.setNomorMember(rs.getString("nomor_member"));

                } while (rs.next());

            }
            else {

                return null;

            }

        } 
        catch (SQLException e) {

            e.printStackTrace();

        } 

        conn.disconnect();
        return card;

    }

    // INSERT
    public static boolean insertNewUser(Card card) {

        String query = "INSERT INTO users (nama, jenis_kelamin, tanggal_lahir, tanggal_pembuatan, masa_berlaku) VALUES (?, ?, ?, ?, ?)";

        try {

            conn.connect();
            PreparedStatement stmt = conn.con.prepareStatement(query);
            
            stmt.setString(1, card.getNama());
            stmt.setString(2, card.getJenisKelamin());
            stmt.setString(3, card.getTanggalLahir());
            stmt.setString(4, card.getTanggalPembuatan());
            stmt.setString(5, card.getMasaBerlaku());

            stmt.executeUpdate();
            return true;

        } 
        catch (SQLException e) {
            
            e.printStackTrace();
            return false;

        } 
        finally {

            conn.disconnect();

        }

    }

}
