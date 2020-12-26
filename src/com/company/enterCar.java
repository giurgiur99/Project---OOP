package com.company;

import javax.swing.*;
import javax.swing.plaf.nimbus.State;
import javax.swing.plaf.synth.SynthScrollBarUI;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import static com.company.CarState.WAITING_FOR_DIAGNOSE;


public class enterCar extends JFrame{
        private JPanel carEnter;
        private JLabel licenseLabel;
        private JLabel ownerLabel;
        private JLabel phoneLabel;
        private JLabel dateLabel;
        private JLabel makerLabel;
        private JTextField pleaseEnterLicensePlateTextField;
        private JTextField ownerNameTextField;
        private JTextField phoneNumberTextField;
        private JTextField labelTextField;
        private JTextField dateTextField;
        private JButton addCar;
        private JTextField makerTextField;

        public enterCar(String title, ArrayList<CarData> carList) {
        super(title);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setContentPane(carEnter);
        this.setLocationRelativeTo(null);
        this.setBounds(100,100,400,400);
        this.pack();

            addCar.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    JOptionPane.showMessageDialog(carEnter, pleaseEnterLicensePlateTextField.getText() + " has been added");
                    System.out.println(pleaseEnterLicensePlateTextField.getText() + " has been added");
                    enterCar.this.setVisible(false);
                    CarData carData = new CarData();
                    carData.Maker = makerTextField.getText();
                    carData.LicensePlate = pleaseEnterLicensePlateTextField.getText();
                    //carData
                    carData.PhoneNumber = phoneNumberTextField.getText();
                    carData.Owner = ownerNameTextField.getText();
                    carData.State =  WAITING_FOR_DIAGNOSE;
                    carList.add(carData);

                }
            });
        }

        public static void main(String[] args)
        {
            /*JFrame frame = new enterCar("Enter Car", carList);
            frame.setLocationRelativeTo(null);
            frame.setBounds(100,100,400,400);
            frame.setVisible(true);*/

        }

}
