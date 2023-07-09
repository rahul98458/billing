package com.view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class CashierPanel extends JFrame {

	private JPanel contentPane;
	private JButton btnNewButton;
	private JButton btnSearchBill;
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
					CashierPanel frame = new CashierPanel();
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
	public CashierPanel() {
		setTitle("Cashier Panel");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1040, 631);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		contentPane.add(getBtnNewButton());
		contentPane.add(getBtnSearchBill());
		contentPane.add(getBtnNewButton_1_1());
		contentPane.add(getBtnNewButton_1_1_1());
		contentPane.add(getBtnNewButton_1_1_1_1());
	}
	private JButton getBtnNewButton() {
		if (btnNewButton == null) {
			btnNewButton = new JButton("Create Bill");
			btnNewButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					new BillAdd().setVisible(true);
				}
			});
			btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 12));
			btnNewButton.setBounds(44, 46, 152, 42);
		}
		return btnNewButton;
	}
	private JButton getBtnSearchBill() {
		if (btnSearchBill == null) {
			btnSearchBill = new JButton("Search Bill");
			btnSearchBill.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					new SearchBill().setVisible(true);
				}
			});
			btnSearchBill.setFont(new Font("Tahoma", Font.BOLD, 12));
			btnSearchBill.setBounds(244, 46, 152, 42);
		}
		return btnSearchBill;
	}
	private JButton getBtnNewButton_1_1() {
		if (btnNewButton_1_1 == null) {
			btnNewButton_1_1 = new JButton("Product Information");
			btnNewButton_1_1.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					new ProductInfo().setVisible(true);
					
				}
			});
			btnNewButton_1_1.setFont(new Font("Tahoma", Font.BOLD, 12));
			btnNewButton_1_1.setBounds(434, 46, 161, 42);
		}
		return btnNewButton_1_1;
	}
	private JButton getBtnNewButton_1_1_1() {
		if (btnNewButton_1_1_1 == null) {
			btnNewButton_1_1_1 = new JButton("Sales Information");
			btnNewButton_1_1_1.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					new SaleAdd().setVisible(true);
				}
			});
			btnNewButton_1_1_1.setFont(new Font("Tahoma", Font.BOLD, 12));
			btnNewButton_1_1_1.setBounds(632, 46, 152, 42);
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
			btnNewButton_1_1_1_1.setFont(new Font("Tahoma", Font.BOLD, 12));
			btnNewButton_1_1_1_1.setBounds(829, 46, 152, 42);
		}
		return btnNewButton_1_1_1_1;
	}
}
