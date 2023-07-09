package com.view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class AdminPanel extends JFrame {

	private JPanel contentPane;
	private JButton btnNewButton;
	private JButton btnTransactions;
	private JButton btnNewButton_1_1;
	private JButton btnNewButton_1_1_1;
	private JButton btnNewButton_1_1_1_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AdminPanel frame = new AdminPanel();
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
	public AdminPanel() {
		setTitle("Admin Panel");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1067, 638);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		contentPane.add(getBtnNewButton());
		contentPane.add(getBtnTransactions());
		contentPane.add(getBtnNewButton_1_1());
		contentPane.add(getBtnNewButton_1_1_1());
		contentPane.add(getBtnNewButton_1_1_1_1());
	}

	private JButton getBtnNewButton() {
		if (btnNewButton == null) {
			btnNewButton = new JButton("Cashier");
			btnNewButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					new CashierAdd().setVisible(true);
				}
			});
			btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 15));
			btnNewButton.setBounds(66, 47, 142, 34);
		}
		return btnNewButton;
	}
	private JButton getBtnTransactions() {
		if (btnTransactions == null) {
			btnTransactions = new JButton("Transactions");
			btnTransactions.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					new TransactionForm().setVisible(true);
				}
			});
			btnTransactions.setFont(new Font("Tahoma", Font.PLAIN, 15));
			btnTransactions.setBounds(246, 47, 142, 34);
		}
		return btnTransactions;
	}
	private JButton getBtnNewButton_1_1() {
		if (btnNewButton_1_1 == null) {
			btnNewButton_1_1 = new JButton("Stock Information");
			btnNewButton_1_1.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					new ProductAdd().setVisible(true);
				}
			});
			btnNewButton_1_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
			btnNewButton_1_1.setBounds(424, 47, 165, 34);
		}
		return btnNewButton_1_1;
	}
	private JButton getBtnNewButton_1_1_1() {
		if (btnNewButton_1_1_1 == null) {
			btnNewButton_1_1_1 = new JButton("Sale Information");
			btnNewButton_1_1_1.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					new SaleAddAdmin().setVisible(true);
				}
			});
			btnNewButton_1_1_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
			btnNewButton_1_1_1.setBounds(636, 47, 151, 34);
		}
		return btnNewButton_1_1_1;
	}
	private JButton getBtnNewButton_1_1_1_1() {
		if (btnNewButton_1_1_1_1 == null) {
			btnNewButton_1_1_1_1 = new JButton("Exit");
			btnNewButton_1_1_1_1.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					System.exit(0);
				}
			});
			btnNewButton_1_1_1_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
			btnNewButton_1_1_1_1.setBounds(849, 47, 142, 34);
		}
		return btnNewButton_1_1_1_1;
	}
}
