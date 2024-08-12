/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import domen.Student;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author jovana
 */
public class StudentTableModel extends AbstractTableModel {

    private final List<Student> studenti;
    private final String[] kolone = {"Ime", "Prezime", "Indeks"};

    public StudentTableModel(List<Student> studenti) {
        this.studenti = studenti;
    }

    @Override
    public int getRowCount() {
        return studenti.size();
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
        Student student = studenti.get(rowIndex);
        switch (columnIndex) {
            case 0:
                return student.getIme();
            case 1:
                return student.getPrezime();
            case 2:
                return student.getIndex();
            default:
                throw new AssertionError();
        }
    }

    public Student getStudent(int red) {
        return studenti.get(red);
    }

}
