package com.company;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class BMR {
    public static void main(String[] args) {
        JFrame frame = new JFrame("BMR Calculator");
        frame.setContentPane(new BMR().panel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }

    private JPanel panel;
    private JTextField textUmur;
    private JTextField textBB;
    private JTextField textTB;
    private JRadioButton lakiLakiRadioButton;
    private JRadioButton perempuanRadioButton;
    private JTextArea textBMR;
    private JButton submitButton;
    private JButton clearButton;
    private JLabel Umur;
    private JLabel BB;
    private JLabel TB;
    private JLabel Kelamin;


    public BMR() {
        lakiLakiRadioButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (lakiLakiRadioButton.isSelected()){
                    perempuanRadioButton.setSelected(false);

                }
            }
        });

        perempuanRadioButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (perempuanRadioButton.isSelected()) {
                    lakiLakiRadioButton.setSelected(false);
                }
            }
        });

        submitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int Umur, BB , TB;
                double BMR;
                Umur = Integer.parseInt(textUmur.getText());
                BB   = Integer.parseInt(textBB.getText());
                TB   = Integer.parseInt(textTB.getText());

                if (lakiLakiRadioButton.isSelected()) {
                    BMR = 88.362 + (13.397 * BB) + (4.799 * TB) - (5.677 * Umur);
                    textBMR.setText("Kamu membutuhkan " + (String.format("%.2f", BMR)) + " kalori per hari");

                } else if (perempuanRadioButton.isSelected()) {
                    BMR = 447.593 + (9.247 * BB) + (3.098 * TB) - (4.330 * Umur);
                    textBMR.setText("Kamu membutuhkan " + (String.format("%.2f", BMR)) + " kalori per hari");
                }
            }
        });

        clearButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                textUmur.setText("");
                textBB.setText("");
                textTB.setText("");
                textBMR.setText("");
                lakiLakiRadioButton.setSelected(false);
                perempuanRadioButton.setSelected(false);
            }
        });
    }
}
