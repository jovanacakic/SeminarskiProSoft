/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import domen.Ekvivalenti;
import domen.EkvivalentiRazmena;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author jovana
 */
public class EkvivalentiTableModel extends AbstractTableModel {

    private List<EkvivalentiRazmena> ekvivalentiRazmena;
    private final String[] kolone = {"RB", "Predmet na FON-u", "Predmet na drugom fakultetu"};

    public EkvivalentiTableModel() {
        ekvivalentiRazmena = new ArrayList<>();
    }

    public EkvivalentiTableModel(List<EkvivalentiRazmena> ekvivalentiRazmena) {
        this.ekvivalentiRazmena = ekvivalentiRazmena;
        fireTableDataChanged();
    }

    @Override
    public int getRowCount() {
        return ekvivalentiRazmena.size();
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
        EkvivalentiRazmena e = ekvivalentiRazmena.get(rowIndex);
        switch (columnIndex) {
            case 0:
                return e.getRb();
            case 1:
                return e.getEkvivalenti().getPredmetFon().toString();
            case 2:
                return e.getEkvivalenti().getPredmetDrugiFakultet().toString();
            default:
                throw new AssertionError();
        }
    }

    public void dodajRed(EkvivalentiRazmena e) {
        ekvivalentiRazmena.add(e);
        fireTableDataChanged();
    }

    public List<EkvivalentiRazmena> getLista() {
        return ekvivalentiRazmena;
    }

    public void obrisiEkvivalente(int row) {
        ekvivalentiRazmena.remove(row);
        fireTableDataChanged();
    }

    public void setLista(List<EkvivalentiRazmena> listaEkvivalenata) {
        ekvivalentiRazmena = listaEkvivalenata;
        fireTableDataChanged();
    }

    public void resetujRB() {
        for (int i = 0; i < ekvivalentiRazmena.size(); i++) {
            ekvivalentiRazmena.get(i).setRb(i + 1);
        }
        fireTableDataChanged();
    }
}
