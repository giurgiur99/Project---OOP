package com.company;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.ArrayList;

public class AdminMenu extends JFrame{
    private JPanel carStatePanel;
    private JComboBox listCarCombobox;
    private JLabel carStateLabel;
    private JButton nextState;
    private JButton prevState;
    private JButton modifyData;
    private JButton removeCar;

    public AdminMenu(String title, ArrayList<CarData> carList) {
        super(title);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setContentPane(carStatePanel);
        this.pack();

        for(int i = 0 ; i < carList.size() ; i++)
            System.out.println(carList.get(i).LicensePlate);

        //Add licensePlate to comboBox
        String[] array = new String[carList.size()];
        for(int i = 0; i < array.length; i++) {
            listCarCombobox.addItem(carList.get(i).LicensePlate);
        }


        listCarCombobox.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                int getIndex = listCarCombobox.getSelectedIndex();
                System.out.println(getIndex);
                carStateLabel.setText(carList.get(getIndex).State.toString());


            }
        });

        prevState.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int getIndex = listCarCombobox.getSelectedIndex();
                switch(carList.get(getIndex).State)
                {
                    case WAITING_FOR_DIAGNOSE:
                        System.out.println("This is the first state");
                        JOptionPane.showMessageDialog(carStatePanel, "There is no previous state");
                        break;


                    case DIAGNOSED:
                        carStateLabel.setText("WAITING_FOR_DIAGNOSE");
                        carList.get(getIndex).State = CarState.WAITING_FOR_DIAGNOSE;
                        JOptionPane.showMessageDialog(carStatePanel, "State has been changed");
                        break;

                    case WAITING_FOR_PARTS:
                        carStateLabel.setText("DIAGNOSED");
                        carList.get(getIndex).State = CarState.DIAGNOSED;
                        JOptionPane.showMessageDialog(carStatePanel, "State has been changed");
                        break;

                    case IN_REPAIR:
                        carStateLabel.setText("WAITING_FOR_PARTS");
                        carList.get(getIndex).State = CarState.WAITING_FOR_PARTS;
                        JOptionPane.showMessageDialog(carStatePanel, "State has been changed");
                        break;

                    case READY:
                        carStateLabel.setText("IN_REPAIR");
                        carList.get(getIndex).State = CarState.IN_REPAIR;
                        JOptionPane.showMessageDialog(carStatePanel, "State has been changed");
                        break;

                }
            }
        });

        nextState.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int getIndex = listCarCombobox.getSelectedIndex();
                switch(carList.get(getIndex).State)
                {
                    case WAITING_FOR_DIAGNOSE:
                        carStateLabel.setText("DIAGNOSED");
                        carList.get(getIndex).State = CarState.DIAGNOSED;
                        JOptionPane.showMessageDialog(carStatePanel, "State has been changed");
                        break;


                    case DIAGNOSED:
                        carStateLabel.setText("WAITING_FOR_PARTS");
                        carList.get(getIndex).State = CarState.WAITING_FOR_PARTS;
                        JOptionPane.showMessageDialog(carStatePanel, "State has been changed");
                        break;

                    case WAITING_FOR_PARTS:
                        carStateLabel.setText("IN_REPAIR");
                        carList.get(getIndex).State = CarState.IN_REPAIR;
                        JOptionPane.showMessageDialog(carStatePanel, "State has been changed");
                        break;

                    case IN_REPAIR:
                        carStateLabel.setText("READY");
                        carList.get(getIndex).State = CarState.READY;
                        JOptionPane.showMessageDialog(carStatePanel, "State has been changed");
                        break;

                    case READY:
                        JOptionPane.showMessageDialog(carStatePanel, "Car is READY !");
                        break;


                }

            }
        });
    }

    public static void main(String[] args)
    {
        ArrayList <CarData> carList = new ArrayList<>();
        populateCarData.populate(carList);
        JFrame frame = new AdminMenu("AdminMenu", carList);
        frame.setLocationRelativeTo(null);
        frame.setBounds(100,100,450,450);
        frame.setVisible(true);

    }
}
