/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import domen.Ekvivalenti;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author jovana
 */
public class EkvivalentiTableModel extends AbstractTableModel {

    private List<Ekvivalenti> ekvivalenti;
    private final String[] kolone = {"Predmet na FON-u", "Predmet na drugom fakultetu"};

    public EkvivalentiTableModel() {
        ekvivalenti = new ArrayList<>();
    }

    @Override
    public int getRowCount() {
        return ekvivalenti.size();
    }

    @Override
    public int getColumnCount() {
        return kolone.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Ekvivalenti e = ekvivalenti.get(rowIndex);
        switch (columnIndex) {
            case 0:
                return e.getPredmetFon();
            case 1:
                return e.getPredmetDrugiFakultet();
            default:
                throw new AssertionError();
        }
    }

    public void dodajRed(Ekvivalenti e) {
        ekvivalenti.add(e);
        fireTableDataChanged();
    }

    public List<Ekvivalenti> getLista() {
        return ekvivalenti;
    }

    public void obrisiEkvivalente(int row) {
        ekvivalenti.remove(row);
        fireTableDataChanged();
    }

}
