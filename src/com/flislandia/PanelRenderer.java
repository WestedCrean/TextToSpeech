package com.flislandia;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.io.File;
import java.util.ArrayList;

class TileRenderer extends JPanel {


    TileRenderer() {
        this.setLayout(new GridLayout(3,2, 10, 10));
        this.setBackground(new Color(0x383838));
        this.setForeground(Color.white);
        this.setBorder(new EmptyBorder(8, 8, 8, 8) );
    }

    public void render(ArrayList<File> fl){
        this.removeAll();

        for(File f:fl) {
            addNewTile(f);
        }

        this.revalidate();
        this.repaint();
    }

    public void addNewTile(File f){
        JPanel tile = new JPanel(new GridBagLayout());
        tile.setBorder(new EmptyBorder(8, 8, 8, 8) );

        JLabel title = new JLabel(f.getName());
        JButton playButton = new JButton("Play");


        tile.add(title);
        tile.add(playButton);

        //tile.setPreferredSize(new Dimension(100,100));
        tile.setBackground(Color.darkGray);
        this.add(tile);
    }

}