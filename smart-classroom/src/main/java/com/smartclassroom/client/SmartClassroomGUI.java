package com.smartclassroom.client;

import javax.swing.*;
import java.awt.*;

public class SmartClassroomGUI extends JFrame {

    // status
    private JLabel lightStatusLabel;
    private JLabel projectorStatusLabel;
    private JLabel heatingStatusLabel;

    // Constructor to create interface
    public SmartClassroomGUI() {
        setTitle("Smart Classroom Systems");
        setSize(300, 200);
        setLayout(new BoxLayout(getContentPane(), BoxLayout.Y_AXIS));

        // light status
        JPanel lightPanel = new JPanel();
        lightPanel.setLayout(new FlowLayout(FlowLayout.LEFT));
        lightStatusLabel = new JLabel("light status：false");
        JToggleButton lightToggle = new JToggleButton("turn on");
        lightToggle.addActionListener(e -> {
            //
            boolean isOn = lightToggle.isSelected();
            String statusText = "light status：name=class room light, status=" + (isOn ? "true" : "false");
            lightStatusLabel.setText(statusText);
            lightToggle.setText(isOn ? "turn off" : "turn on");
        });
        lightPanel.add(lightStatusLabel);
        lightPanel.add(lightToggle);

        // projector status
        JPanel projectorPanel = new JPanel();
        projectorPanel.setLayout(new FlowLayout(FlowLayout.LEFT));
        projectorStatusLabel = new JLabel("projector status:false");
        JToggleButton projectorToggle = new JToggleButton("turn on");
        projectorToggle.addActionListener(e -> {
            //
            boolean isOn = projectorToggle.isSelected();
            String statusText = "projector status：name=class room projector, status=" + (isOn ? "true" : "false");
            projectorStatusLabel.setText(statusText);
            projectorToggle.setText(isOn ? "turn off" : "turn on");
        });
        projectorPanel.add(projectorStatusLabel);
        projectorPanel.add(projectorToggle);

        // heating status
        JPanel heatingPanel = new JPanel();
        heatingPanel.setLayout(new FlowLayout(FlowLayout.LEFT));
        heatingStatusLabel = new JLabel("heating status：false");
        JToggleButton heatingToggle = new JToggleButton("turn on");
        heatingToggle.addActionListener(e -> {
            //
            boolean isOn = heatingToggle.isSelected();
            String statusText = "heating status：name=class room projector, status=" + (isOn ? "true" : "false") + ", temperature=22.5";
            heatingStatusLabel.setText(statusText);
            heatingToggle.setText(isOn ? "turn off" : "turn on");
        });
        heatingPanel.add(heatingStatusLabel);
        heatingPanel.add(heatingToggle);

        // Add to main frame
        add(lightPanel);
        add(projectorPanel);
        add(heatingPanel);

        pack();
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
    }

    // program entry
    public static void main(String[] args) {
        SwingUtilities.invokeLater(SmartClassroomGUI::new);
    }
}
