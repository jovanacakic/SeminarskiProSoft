/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import domen.Predmet;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author jovana
 */
public class SubjectTableModel extends AbstractTableModel {

    List<Predmet> predmeti;
    String[] kolone = {"Naziv", "Univerzitet", "Semestar", "ESPB"};

    public SubjectTableModel() {
        predmeti = new ArrayList<>();
    }

    public SubjectTableModel(List<Predmet> predmeti) {
        this.predmeti = predmeti;
    }

    @Override
    public int getRowCount() {
        return predmeti.size();
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
        Predmet p = predmeti.get(rowIndex);
        switch (columnIndex) {
            case 0:
                return p.getNaziv();
            case 1:
                return p.getUniverzitet().toString();
            case 2:
                return p.getSemestar();
            case 3:
                return p.getEspb();
            default:
                throw new AssertionError();
        }
    }

    public Predmet getPredmet(int row) {
        return predmeti.get(row);
    }

}
