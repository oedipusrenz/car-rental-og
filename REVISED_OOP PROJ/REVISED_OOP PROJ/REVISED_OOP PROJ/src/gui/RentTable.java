/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gui;

import Lib.RentRecord;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author ranip
 */
public class RentTable extends AbstractTableModel implements ITable{
    private ArrayList<RentRecord> reps;
    private String[] colNames = {"Plate#", "Unit", "Start of Rent", "End of Rent", "Duration", "Status"};

    public RentTable (ArrayList<RentRecord> reports) {
        this.reps = reports;
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
    public String getColumnName(int col) {
        return colNames[col];
    }
    
    @Override
    public RentRecord getReport(int rIndex) {
        return reps.get(rIndex);
    }

    @Override
    public Object getValueAt(int rIndex, int cIndex) {
        RentRecord report = reps.get(rIndex);
            switch (cIndex) {
                case 0:
                    return report.getRent().getPlateNum();

                case 1:
                    return report.getRent().getCar().getBrand() + " " + report.getRent().getCar().getModel();

                case 2:
                    return report.getRent().getStartDate().format(DateTimeFormatter.ofPattern("MM/dd/yyyy"));

                case 3:
                    return report.getRent().getLastDate().format(DateTimeFormatter.ofPattern("MM/dd/yyyy"));

                case 4:
                    return report.getDuration();

                case 5:
                    return report.getStatus();

                default:
                    throw new IllegalArgumentException("Invalid column index");
            }
    }


    

    
}
