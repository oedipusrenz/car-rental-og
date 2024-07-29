/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Lib;

/**
 *
 * @author anyadanielle
 */
public class Factory {
    public static ICar getFactory(boolean isAutomatic) {
        if (isAutomatic) {
            return new AutoCarFactory();
        } else {
            return new ManCarFactory();
        }
    }
}
