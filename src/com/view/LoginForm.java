package com.view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JCheckBox;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JPasswordField;
import javax.swing.event.ChangeListener;
import javax.swing.event.ChangeEvent;

public class LoginForm extends JFrame {

	private JPanel contentPane;
	private JLabel lblNewLabel;
	private JTextField usernameTxt;
	private JLabel lblPassword;
	private JCheckBox chkbox;
	private JButton btnNewButton;
	private JButton btnCancel;
	private JPasswordField passwordTxt;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LoginForm frame = new LoginForm();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public LoginForm() {
		setTitle("Login Form");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 633, 483);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		contentPane.add(getLblNewLabel());
		contentPane.add(getUsernameTxt());
		contentPane.add(getLblPassword());
		contentPane.add(getChkbox());
		contentPane.add(getBtnNewButton());
		contentPane.add(getBtnCancel());
		contentPane.add(getPasswordTxt());
	}

	private JLabel getLblNewLabel() {
		if (lblNewLabel == null) {
			lblNewLabel = new JLabel("Username :");
			lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 20));
			lblNewLabel.setBounds(26, 94, 136, 37);
		}
		return lblNewLabel;
	}
	private JTextField getUsernameTxt() {
		if (usernameTxt == null) {
			usernameTxt = new JTextField();
			usernameTxt.setBounds(172, 94, 267, 37);
			usernameTxt.setColumns(10);
		}
		return usernameTxt;
	}
	private JLabel getLblPassword() {
		if (lblPassword == null) {
			lblPassword = new JLabel("Password :");
			lblPassword.setFont(new Font("Tahoma", Font.BOLD, 20));
			lblPassword.setBounds(26, 204, 136, 37);
		}
		return lblPassword;
	}
	private JCheckBox getChkbox() {
		if (chkbox == null) {
			chkbox = new JCheckBox("Show Password");
			chkbox.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					if(chkbox.isSelected())
					{
						passwordTxt.setEchoChar((char)0);
					}
					else {
						passwordTxt.setEchoChar('*');
					}
				}
			});
			
			chkbox.setFont(new Font("Tahoma", Font.PLAIN, 12));
			chkbox.setHorizontalAlignment(SwingConstants.RIGHT);
			chkbox.setBounds(302, 260, 137, 21);
		}
		return chkbox;
	}
	private JButton getBtnNewButton() {
		if (btnNewButton == null) {
			btnNewButton = new JButton("Login");
			btnNewButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					
					String username = usernameTxt.getText();
					String password = passwordTxt.getText();
					
					
					if(username.isEmpty() || password.isEmpty()){
					   JOptionPane.showMessageDialog(null, "enter the all field");
					}else{

						if(username.equals("admin")&& password.equals("admin"))
						{
							JOptionPane.showMessageDialog(null, "login success");
							new AdminPanel().setVisible(true);
							dispose();
						}
						else {
							JOptionPane.showMessageDialog(null, "login failed,wrong info");
						}
					}
					
					
//					if(username.equals("admin")&& password.equals("admin"))
//					{
//						JOptionPane.showMessageDialog(null, "login success");
//						new AdminPanel().setVisible(true);
//						dispose();
//					}
//					else {
//						JOptionPane.showMessageDialog(null, "login failed,wrong info");
//					}
//					
					
				}
			});
			btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 15));
			btnNewButton.setBounds(172, 300, 107, 37);
		}
		return btnNewButton;
	}
	private JButton getBtnCancel() {
		if (btnCancel == null) {
			btnCancel = new JButton("Cancel");
			btnCancel.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					
					
					new Home().setVisible(true);
					dispose();
					
				}
			});
			btnCancel.setFont(new Font("Tahoma", Font.PLAIN, 15));
			btnCancel.setBounds(332, 300, 107, 37);
		}
		return btnCancel;
	}
	private JPasswordField getPasswordTxt() {
		if (passwordTxt == null) {
			passwordTxt = new JPasswordField();
			passwordTxt.setBounds(172, 204, 267, 32);
		}
		return passwordTxt;
	}
}
