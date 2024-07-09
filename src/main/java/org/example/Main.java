package org.example;

import javax.swing.*;


/**
 * My first practice of creating 2D graphics in java.
 * A recreation of a simple Bob Ross inspired painting using the Swing library.
 * Based on the youtube tutorial by 'Lean Code by Gaming'.
 * This code features a series of inline comments to help me understand the fundemental concepts of creating 2d graphics.
 **/
class Main {
    public static void main(String[] args) {
        JFrame window = new JFrame("Painting"); //create main window for GUI and title in toolbar
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //stop app when window is closed

        MyCanvas canvas = new MyCanvas(); //create canvas to draw on
        window.add(canvas); //add canvas to the window

        window.pack(); //fit the window size around canvas
        window.setResizable(false); //users cant resize window
        window.setLocationRelativeTo(null); //open window in center of screen
        window.setVisible(true); //show window
    }
}