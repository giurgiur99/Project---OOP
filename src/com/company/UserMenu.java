package com.company;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class UserMenu extends JFrame{
    private JPanel userPanel;
    private JPanel userSelction;
    private JComboBox whatOperationWouldYouComboBox;
    private JButton userNext;
    private JPanel addCar;

    public UserMenu(String title, ArrayList<CarData> carList) {
        super(title);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setContentPane(userPanel);
        this.pack();
        userNext.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int getIndex = whatOperationWouldYouComboBox.getSelectedIndex();
                System.out.println(getIndex);

                if(getIndex == 1) {
                    JFrame enterCar = new enterCar("Enter car form", carList);
                    enterCar.setLocationRelativeTo(null);
                    enterCar.setBounds(100, 100, 400, 400);
                    enterCar.setVisible(true);
                }
            }
        });
    }

    public static void main(String[] args)
    {
        ArrayList <CarData> carList = new ArrayList<>();
        JFrame frame = new UserMenu("UserMenu", carList);
        frame.setLocationRelativeTo(null);
        frame.setBounds(100,100,400,400);
        frame.setVisible(true);

    }
}
