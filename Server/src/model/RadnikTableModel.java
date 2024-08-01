/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import domen.Radnik;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author jovana
 */
public class RadnikTableModel extends AbstractTableModel {

    private final List<Radnik> radnici;
    private final String[] kolone = {"Ime", "Prezime"};

    public RadnikTableModel(List<Radnik> radnici) {
        this.radnici = radnici;
    }

    @Override
    public int getRowCount() {
        return radnici.size();
    }

    @Override
    public int getColumnCount() {
        return kolone.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Radnik r = radnici.get(rowIndex);
        switch (columnIndex) {
            case 0:
                return r.getIme();
            case 1:
                return r.getPrezime();
            default:
                throw new AssertionError();
        }
    }

    @Override
    public String getColumnName(int column) {
        return kolone[column];
    }

}
