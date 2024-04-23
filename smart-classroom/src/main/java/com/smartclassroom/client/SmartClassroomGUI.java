package com.smartclassroom.client;

import javax.swing.*;
import java.awt.*;

public class SmartClassroomGUI extends JFrame {

    // 状态标签
    private JLabel lightStatusLabel;
    private JLabel projectorStatusLabel;
    private JLabel heatingStatusLabel;

    // 构造函数创建界面
    public SmartClassroomGUI() {
        setTitle("Smart Classroom Systems");
        setSize(300, 200);
        setLayout(new BoxLayout(getContentPane(), BoxLayout.Y_AXIS));

        // 灯光状态
        JPanel lightPanel = new JPanel();
        lightPanel.setLayout(new FlowLayout(FlowLayout.LEFT));
        lightStatusLabel = new JLabel("灯光状态：未知");
        JToggleButton lightToggle = new JToggleButton("turn on");
        lightToggle.addActionListener(e -> {
            // TODO: 在这里添加与LightClient通信的代码
            boolean isOn = lightToggle.isSelected();
            String statusText = "灯光状态：名称=教室前排的灯, 是否开启=" + (isOn ? "true" : "false");
            lightStatusLabel.setText(statusText);
            lightToggle.setText(isOn ? "turn off" : "turn on");
        });
        lightPanel.add(lightStatusLabel);
        lightPanel.add(lightToggle);

        // 投影仪状态
        JPanel projectorPanel = new JPanel();
        projectorPanel.setLayout(new FlowLayout(FlowLayout.LEFT));
        projectorStatusLabel = new JLabel("投影仪状态：未知");
        JToggleButton projectorToggle = new JToggleButton("turn on");
        projectorToggle.addActionListener(e -> {
            // TODO: 在这里添加与ProjectorClient通信的代码
            boolean isOn = projectorToggle.isSelected();
            String statusText = "投影仪状态：名称=主投影仪, 是否开启=" + (isOn ? "true" : "false");
            projectorStatusLabel.setText(statusText);
            projectorToggle.setText(isOn ? "turn off" : "turn on");
        });
        projectorPanel.add(projectorStatusLabel);
        projectorPanel.add(projectorToggle);

        // 暖气状态
        JPanel heatingPanel = new JPanel();
        heatingPanel.setLayout(new FlowLayout(FlowLayout.LEFT));
        heatingStatusLabel = new JLabel("暖气状态：未知");
        JToggleButton heatingToggle = new JToggleButton("turn on");
        heatingToggle.addActionListener(e -> {
            // TODO: 在这里添加与HeatingClient通信的代码
            boolean isOn = heatingToggle.isSelected();
            String statusText = "暖气状态：名称=教室暖气, 是否开启=" + (isOn ? "true" : "false") + ", 当前温度=22.5";
            heatingStatusLabel.setText(statusText);
            heatingToggle.setText(isOn ? "turn off" : "turn on");
        });
        heatingPanel.add(heatingStatusLabel);
        heatingPanel.add(heatingToggle);

        // 添加到主框架
        add(lightPanel);
        add(projectorPanel);
        add(heatingPanel);

        pack();
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
    }

    // 程序入口
    public static void main(String[] args) {
        SwingUtilities.invokeLater(SmartClassroomGUI::new);
    }
}
