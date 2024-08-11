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
    public String getParametre() {
        return String.format("%d, '%s', '%s', '%s', '%s'", id, username, password, ime, prezime);
    }

    @Override
    public String getNaziveParametara() {
        return "id, username, password, ime, prezime";
    }

    @Override
    public String getNazivPrimarnogKljuca() {
        return "id";
    }

    @Override
    public Integer getVrednostPrimarnogKljuca() {
        return id;
    }

    @Override
    public String getSlozeniPrimarniKljuc() {
        return null;
    }

    @Override
    public List<AbstractDomainObject> konvertujRSUListu(ResultSet rs) {
        ArrayList<AbstractDomainObject> radnici = new ArrayList<>();
        try {
            while (rs.next()) {
                int rsId = rs.getInt("id");
                String rsKorisnickoIme = rs.getString("username");
                String rsLozinka = rs.getString("password");
                String rsIme = rs.getString("ime");
                String rePrezime = rs.getString("prezime");

                radnici.add(new Radnik(rsId, rsKorisnickoIme, rsLozinka, rsIme, rePrezime));
            }
        } catch (SQLException e) {
            System.out.println("Greska u Radnik::konvertujRSUListu\n" + e.getMessage());
        }
        return radnici;
    }

    @Override
    public String getSelectUpit() {
        return "SELECT * FROM " + getTableName();
    }

    @Override
    public String getSelectUpitPoParametru() {
        return "SELECT * FROM " + getTableName() + " WHERE id = " + getVrednostPrimarnogKljuca();
    }

    @Override
    public String getInsertUpit() {
        return null;
    }

    @Override
    public String getUpdateUpit() {
        return String.format("id = %d, korisnickoIme = '%s', lozinka = '%s', ime = '%s', prezime = '%s'",
                id, username, password, ime, prezime);
    }

    @Override
    public String getUpdateParametre() {
        return null;
    }

    @Override
    public String getDeleteUpit() {
        return null;
    }

}
