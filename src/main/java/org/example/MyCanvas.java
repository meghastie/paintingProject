package org.example;
import javax.swing.*;
import java.awt.*;

public class MyCanvas extends JPanel {
    //JPanel is a container which can store a group of componenents
    public MyCanvas() {
        setPreferredSize(new Dimension(900, 600)); //set canvas size
        setBackground(Color.white); //set canvas background to white
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        //objects will be painted from the back

        Paintbrush myBrush = new Paintbrush(g);
        myBrush.drawSky();
        myBrush.drawGrass();
        myBrush.drawMountains();
        myBrush.drawTree();
        //myBrush.finishingTouches();
    }
}

