/*
 * Quang Minh Dong
 * INSY - 4305 - 004
 * Lab 4
 * 11/4/2024
 */

import javax.swing.JFrame;

public class ConvertApp{
    public static void main(String[] args){
        ConvertFrame convertFrame = new ConvertFrame();
        convertFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        convertFrame.setSize(360,380); // set frame size
        convertFrame.setVisible(true); // display frame
    }
}