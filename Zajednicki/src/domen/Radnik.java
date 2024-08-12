/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package domen;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author jovana
 */
public class Radnik extends AbstractDomainObject {

    private int id;
    private String username;
    private String password;
    private String ime;
    private String prezime;

    @Override
    public String toString() {
        return ime + " " + prezime;
    }

    public Radnik() {
    }

    public Radnik(int id, String username, String password, String ime, String prezime) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.ime = ime;
        this.prezime = prezime;
    }

    public String getPrezime() {
        return prezime;
    }

    public void setPrezime(String prezime) {
        this.prezime = prezime;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getIme() {
        return ime;
    }

    public void setIme(String ime) {
        this.ime = ime;
    }

    @Override
    public String getTableName() {
        return "radnik";
    }

    @Override
    public String getAlijas() {
        return " r ";
    }

    @Override
    public String getJoin() {
        // Ako postoji potreba za spajanjem sa drugim tabelama, dodaj join naredbe ovde
        return "";
    }

    @Override
    public ArrayList<AbstractDomainObject> getListuSvih(ResultSet rs) throws SQLException {
        ArrayList<AbstractDomainObject> lista = new ArrayList<>();
        while (rs.next()) {
            Radnik radnik = new Radnik(
                    rs.getInt("ID"),
                    rs.getString("Username"),
                    rs.getString("Password"),
                    rs.getString("Ime"),
                    rs.getString("Prezime"));
            lista.add(radnik);
        }
        rs.close();
        return lista;
    }

    @Override
    public String getKoloneZaInsert() {
        return "(Username, Password, Ime, Prezime)";
    }

    @Override
    public String getVrednostZaPrimarniKljuc() {
        return " id = " + id;
    }

    @Override
    public String getVrednostiZaInsert() {
        return "'" + username + "', '" + password + "', '" + ime + "', '" + prezime + "'";
    }

    @Override
    public String getVrednostiZaUpdate() {
        return " Username = '" + username
                + "', Password = '" + password
                + "', Ime = '" + ime
                + "', Prezime = '" + prezime + "' ";
    }

    @Override
    public String getUslov() {
        return " ORDER BY r.Ime ASC, r.Prezime ASC";
    }

}
