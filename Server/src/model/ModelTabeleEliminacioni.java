/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import database.DBBroker;
import database.KlasaZaEliminacioni;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author jovana
 */
public class ModelTabeleEliminacioni extends AbstractTableModel {

    String[] kolone = {"StudentID", "Ime", "Prezime", "Indeks", "Broj razmena"};
    List<KlasaZaEliminacioni> lista;

    public ModelTabeleEliminacioni() {
        try {
            DBBroker.getInstance().otvoriKonekciju();
            lista = DBBroker.getInstance().vrati();
            DBBroker.getInstance().commit();
            DBBroker.getInstance().zatvoriKonekciju();
        } catch (Exception ex) {
            System.err.println(ex.getMessage());
            DBBroker.getInstance().rollback();
            DBBroker.getInstance().zatvoriKonekciju();
        }
    }

    @Override
    public String getColumnName(int column) {
        return kolone[column];
    }

    @Override
    public int getRowCount() {
        return lista.size();
    }

    @Override
    public int getColumnCount() {
        return kolone.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        KlasaZaEliminacioni red = lista.get(rowIndex);
        switch (columnIndex) {
            case 0:
                return red.getId();
            case 1:
                return red.getIme();
            case 2:
                return red.getPrezime();
            case 3:
                return red.getIndex();
            case 4:
                return red.getBroj_razmena();
            default:
                throw new AssertionError();
        }
    }

}
