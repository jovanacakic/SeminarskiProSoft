/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import domen.Razmena;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author jovana
 */
public class ExchangeTableModel extends AbstractTableModel {

    List<Razmena> razmene;
    String[] kolone = {"Ime", "Prezime", "Indeks", "Semestar", "Skolska godina"};

    public ExchangeTableModel() {
        razmene = new ArrayList<>();
    }

    public ExchangeTableModel(List<Razmena> razmene) {
        this.razmene = razmene;
    }

    @Override
    public int getRowCount() {
        return razmene.size();
    }

    @Override
    public int getColumnCount() {
        return kolone.length;
    }

    @Override
    public String getColumnName(int column) {
        return kolone[column];
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Razmena r = razmene.get(rowIndex);
        switch (columnIndex) {
            case 0:
                return r.getStudent().getIme();
            case 1:
                return r.getStudent().getPrezime();
            case 2:
                return r.getStudent().getIndex();
            case 3:
                return r.getSemestar();
            case 4:
                return r.getSkolskaGodina();
            default:
                throw new AssertionError();
        }
    }

}
