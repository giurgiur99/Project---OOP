package com.company;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class UserMenu extends JFrame{
    private JPanel userPanel;
    private JPanel userSelction;
    private JComboBox whatOperationWouldYouComboBox;
    private JButton userNext;

    public UserMenu(String title) {
        super(title);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setContentPane(userPanel);
        this.pack();
        userNext.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int getIndex = whatOperationWouldYouComboBox.getSelectedIndex();
                System.out.println(getIndex);
                userSelction.setVisible(false);
                whatOperationWouldYouComboBox.setVisible(false);
                userNext.setVisible(false);
            }
        });
    }

    public static void main(String[] args)
    {
        JFrame frame = new UserMenu("UserMenu");
        frame.setLocationRelativeTo(null);
        frame.setBounds(100,100,400,400);
        frame.setVisible(true);

    }
}
