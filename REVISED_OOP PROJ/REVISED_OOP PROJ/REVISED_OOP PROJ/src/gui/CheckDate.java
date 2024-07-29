/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gui;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import javax.swing.JComponent;
import javax.swing.InputVerifier;
import javax.swing.JFormattedTextField;
/**
 *
 * @author ranip
 */
public class CheckDate extends InputVerifier{

    @Override
    public boolean verify(JComponent input) {
        
        JFormattedTextField tfield = (JFormattedTextField) input;
        
        try {
            DateTimeFormatter dtf = DateTimeFormatter.ofPattern("MM/dd/yyyy");
            LocalDate ld = LocalDate.parse(tfield.getText(), dtf);
            return ld.equals(LocalDate.now()) || ld.isAfter(LocalDate.now());
            
        } catch (Exception e) {
            return false;
        }
}
}

