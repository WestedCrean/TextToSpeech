package com.flislandia;

import com.flislandia.TileRenderer;
import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.ArrayList;

public class TextSpeechApplication {
    JFrame frame;
    JFileChooser fc;
    ArrayList<File> filesModel = new ArrayList<>();
    TileRenderer filesList;

    TextSpeechApplication() {
        fc = new JFileChooser();
        buildApplicationLayout();

    }

    private void buildApplicationLayout() {
        frame = new JFrame();
        frame.setTitle("TextSpeech");
        JPanel mainContainer = new JPanel();
        mainContainer.setLayout(new BorderLayout());


        JPanel labelPanel = new JPanel(new FlowLayout());

        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT));

        // label at top



        JLabel mainLabel = new JLabel("Add files you want to transcribe");


        mainLabel.setFont(new Font("Arial", Font.PLAIN, 23));
        mainLabel.setForeground(Color.white);
        labelPanel.setBackground(new Color(0x121212));
        labelPanel.add(mainLabel);


        // list of files in the main section of window


        filesList = new TileRenderer();
        JScrollPane mainPanel = new JScrollPane(filesList);
        mainPanel.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);

        mainPanel.setBackground(new Color(0x121212));

        // buttons


        JButton addButton = new JButton("Add new file");
        addButton.setFont(new Font("Arial", Font.PLAIN, 15));
        addButton.setBackground(Color.BLACK);

        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //Handle open button action.
                if (e.getSource() == addButton) {
                    int returnValue = fc.showOpenDialog(null);

                    if (returnValue== JFileChooser.APPROVE_OPTION) {
                        File file = fc.getSelectedFile();
                        filesModel.add(file);
                        filesList.render(filesModel);
                    }
                }
            }
        });
        //addButton.setForeground(Color.white);
        buttonPanel.add(addButton);
        buttonPanel.setBackground(new Color(0x121212));

        mainContainer.setBorder(new EmptyBorder(30, 30, 30, 30) );
        mainContainer.add(labelPanel, BorderLayout.PAGE_START);
        mainContainer.add(mainPanel, BorderLayout.CENTER);
        mainContainer.add(buttonPanel, BorderLayout.PAGE_END);
        mainContainer.setBackground(new Color(0x121212));
        frame.add(mainContainer);
        frame.setSize(800,600);
        frame.setVisible(true);
    }
}
