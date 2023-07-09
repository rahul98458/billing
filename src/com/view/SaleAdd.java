package com.view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import java.util.List;

import javax.swing.SwingConstants;
import javax.swing.JScrollPane;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import com.model.Cashier;
import com.model.Sale;
import com.service.CashierService;
import com.service.CashierServiceimpl;
import com.service.SaleService;
import com.service.SaleServiceImpl;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class SaleAdd extends JFrame {

	private JPanel contentPane;
	private JLabel lblNewLabel;
	private JScrollPane scrollPane;
	private JButton btnNewButton;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SaleAdd frame = new SaleAdd();
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
	public SaleAdd() {
		setTitle("Sales Info");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 765, 535);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		contentPane.add(getLblNewLabel());
		contentPane.add(getScrollPane());
		contentPane.add(getBtnNewButton());
		displayAllSale();
	}

	private JLabel getLblNewLabel() {
		if (lblNewLabel == null) {
			lblNewLabel = new JLabel("Sales Info");
			lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
			lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 20));
			lblNewLabel.setBounds(257, 45, 257, 37);
		}
		return lblNewLabel;
	}
	private JScrollPane getScrollPane() {
		if (scrollPane == null) {
			scrollPane = new JScrollPane();
			scrollPane.setBounds(34, 117, 690, 302);
			scrollPane.setViewportView(getTable());
		}
		return scrollPane;
	}
	private JButton getBtnNewButton() {
		if (btnNewButton == null) {
			btnNewButton = new JButton("Back");
			btnNewButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					new CashierPanel().setVisible(true);
					dispose();
				}
			});
			btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 15));
			btnNewButton.setBounds(627, 443, 97, 31);
		}
		return btnNewButton;
	}
	private JTable getTable() {
		if (table == null) {
			table = new JTable();
			table.setModel(new DefaultTableModel(
				new Object[][] {
				},
				new String[] {
					"Id","Bill Number", "Date", "Customer Name", "Contact", "Total Amount"
				}
			));
		}
		return table;
	}
	
	
	private void displayAllSale()
	{
	
		SaleService ss = new SaleServiceImpl();
		List<Sale> slist=ss.displaySale();
		 DefaultTableModel tmodel = (DefaultTableModel) table.getModel();
		    tmodel.setRowCount(0);  //  table reset
		    for (Sale ct : slist) {
		    	
		    	tmodel.addRow(new Object[] {ct.getId(),ct.getBillnum(),ct.getDate(),ct.getCname(),ct.getPhone(),ct.getTotal()});
				
			}
	}
	
	
	
}
