package com.smartclassroom.client;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SmartClassroomGui extends JFrame {

    public SmartClassroomGui() {
        createAndShowGUI();
    }

    private void createAndShowGUI() {
        // 设置窗口基本属性
        setTitle("Smart Classroom Systems");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 300);
        setLayout(new GridLayout(0, 1)); // 使用网格布局

        // 添加灯光控制部分
        JPanel lightPanel = new JPanel(new FlowLayout());
        JLabel lightLabel = new JLabel("Light (turn off at 22:00 everyday)");
        JToggleButton lightToggle = new JToggleButton("Turn On");
        lightToggle.setSelected(true);
        lightToggle.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (lightToggle.isSelected()) {
                    lightToggle.setText("Turn Off");
                    // TODO: 实现开灯的代码
                } else {
                    lightToggle.setText("Turn On");
                    // TODO: 实现关灯的代码
                }
            }
        });
        lightPanel.add(lightLabel);
        lightPanel.add(lightToggle);

        // 添加投影仪控制部分
        JPanel projectorPanel = new JPanel(new FlowLayout());
        JLabel projectorLabel = new JLabel("Projector (turn off at 22:00 everyday)");
        JToggleButton projectorToggle = new JToggleButton("Turn On");
        projectorToggle.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (projectorToggle.isSelected()) {
                    projectorToggle.setText("Turn Off");
                    // TODO: 实现开启投影仪的代码
                } else {
                    projectorToggle.setText("Turn On");
                    // TODO: 实现关闭投影仪的代码
                }
            }
        });
        projectorPanel.add(projectorLabel);
        projectorPanel.add(projectorToggle);

        // 将组件添加到窗口
        add(lightPanel);
        add(projectorPanel);

        // 显示窗口
        setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new SmartClassroomGui();
            }
        });
    }
}
