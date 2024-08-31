/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package database;

import java.io.Serializable;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author jovana
 */
public class KlasaZaEliminacioni implements Serializable {

    private int id;
    private String ime;
    private String prezime;
    String index;
    private int broj_razmena;

    public KlasaZaEliminacioni() {
    }

    public KlasaZaEliminacioni(int id, String ime, String prezime, String index, int broj_razmena) {
        this.id = id;
        this.ime = ime;
        this.prezime = prezime;
        this.index = index;
        this.broj_razmena = broj_razmena;
    }

    static ArrayList<KlasaZaEliminacioni> getListuSvih(ResultSet rs) {
        ArrayList<KlasaZaEliminacioni> lista = new ArrayList<>();
        try {
            while (rs.next()) {
                KlasaZaEliminacioni red = new KlasaZaEliminacioni(rs.getInt("studentID"), rs.getString("Ime"), rs.getString("Prezime"), rs.getString("Index"), rs.getInt("broj_razmena"));
                lista.add(red);
                System.out.println(red.toString());
            }
            rs.close();
        } catch (SQLException ex) {
            Logger.getLogger(KlasaZaEliminacioni.class.getName()).log(Level.SEVERE, null, ex);
        }
        return lista;
    }

    @Override
    public String toString() {
        return id + " " + ime + " " + prezime + " " + broj_razmena + " " + index;
    }

    public int getBroj_razmena() {
        return broj_razmena;
    }

    public void setBroj_razmena(int broj_razmena) {
        this.broj_razmena = broj_razmena;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getIme() {
        return ime;
    }

    public void setIme(String ime) {
        this.ime = ime;
    }

    public String getPrezime() {
        return prezime;
    }

    public void setPrezime(String prezime) {
        this.prezime = prezime;
    }

    public void setIndex(String index) {
        this.index = index;
    }

    public String getIndex() {
        return index;
    }

}
