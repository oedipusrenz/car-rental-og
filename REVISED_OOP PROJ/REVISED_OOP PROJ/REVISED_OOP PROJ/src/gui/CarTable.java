/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gui;

import Lib.CarRep;
import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author ranip
 */
public class CarTable extends AbstractTableModel implements ITable{
    private final ArrayList<CarRep> reps;
    private final String[] colNames = {"Plate#", "Brand", "Model", "Description", "Transmission", "Availability", "Base Price"};

    public CarTable (ArrayList<CarRep> reps) {
        this.reps = reps;
    }

    @Override
    public int getRowCount() {
        return reps.size();
    }

    @Override
    public int getColumnCount() {
        return colNames.length;
    }
    
    @Override
    public CarRep getReport(int rIndex) {
        return reps.get(rIndex);
    }

    @Override
    public String getColumnName(int col) {
        return colNames[col];
    }

    @Override
    public Object getValueAt(int rIndex, int cIndex) {
        CarRep cr = reps.get(rIndex);
            switch (cIndex) {
                case 0:
                    return cr.getCar().getPlateNum();
                    
                case 1:
                    return cr.getCar().getBrand();
                
                case 2:
                    return cr.getCar().getModel();
                
                case 3:
                    return cr.getCar().getDescription();
                    
                case 4:
                    return cr.getCar().geTrans();
                    
                case 5:
                    return cr.isAvailable() ? "Available" : "Rented";
                
                case 6:
                    return cr.getCar().getPrice();
                
                default:
                    throw new IllegalArgumentException("Invalid column index");
            }
    }

    
}
