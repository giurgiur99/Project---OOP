package com.company;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class RepairShop extends JFrame {
    private JPanel UserPanel;
    private JPanel MainPanel;
    private JLabel loginLabel;
    private JTextField userField;
    private JPasswordField passField;
    private JLabel usernameLabel;
    private JButton loginBtn;

    public RepairShop(String title) {
       super(title);
       this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
       this.setContentPane(MainPanel);
       this.pack();

        loginBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String username = userField.getText();
                String password = passField.getText();

                System.out.println(username + " " + password);

                if(username.equals("user1"))
                {
                        JFrame UserMenu = new UserMenu("UserMenu");
                        UserMenu.setVisible(true);
                        UserMenu.setLocationRelativeTo(null);
                        UserMenu.setBounds(100,100,400,400);

                }
            }
        });
    }

   public static void main(String[] args)
   {
       JFrame frame = new RepairShop("MyRepairShop");
       frame.setLocationRelativeTo(null);
       frame.setBounds(100,100,400,400);
       frame.setVisible(true);

   }


}
