package com.view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JScrollPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.List;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import com.model.Bill;
import com.service.BillService;
import com.service.BillServiceImpl;

public class TransactionForm extends JFrame {

	private JPanel contentPane;
	private JLabel lblNewLabel;
	private JScrollPane scrollPane;
	private JButton btnNewButton;
	private JLabel lblNewLabel_1;
	private JTextField bnumTxt;
	private JTable table;
	private JButton btnSearch;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TransactionForm frame = new TransactionForm();
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
	public TransactionForm() {
		setTitle("Transactions");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1025, 525);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		contentPane.add(getLblNewLabel());
		contentPane.add(getScrollPane());
		contentPane.add(getBtnNewButton());
		contentPane.add(getLblNewLabel_1());
		contentPane.add(getBnumTxt());
		contentPane.add(getBtnSearch());
	}

	private JLabel getLblNewLabel() {
		if (lblNewLabel == null) {
			lblNewLabel = new JLabel("Transactions Details According To BillNum");
			lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 20));
			lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
			lblNewLabel.setBounds(285, 20, 458, 71);
		}
		return lblNewLabel;
	}
	private JScrollPane getScrollPane() {
		if (scrollPane == null) {
			scrollPane = new JScrollPane();
			scrollPane.setBounds(46, 201, 934, 202);
			scrollPane.setViewportView(getTable());
		}
		return scrollPane;
	}
	private JButton getBtnNewButton() {
		if (btnNewButton == null) {
			btnNewButton = new JButton("Back");
			btnNewButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					new AdminPanel().setVisible(true);
					dispose();
				}
			});
			btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 15));
			btnNewButton.setBounds(868, 424, 112, 34);
		}
		return btnNewButton;
	}
	private JLabel getLblNewLabel_1() {
		if (lblNewLabel_1 == null) {
			lblNewLabel_1 = new JLabel("Enter Bill Number");
			lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
			lblNewLabel_1.setBounds(46, 132, 137, 24);
		}
		return lblNewLabel_1;
	}
	private JTextField getBnumTxt() {
		if (bnumTxt == null) {
			bnumTxt = new JTextField();
			bnumTxt.setBounds(163, 130, 130, 34);
			bnumTxt.setColumns(10);
		}
		return bnumTxt;
	}
	private JTable getTable() {
		if (table == null) {
			table = new JTable();
			table.setModel(new DefaultTableModel(
				new Object[][] {
				},
				new String[] {
					"Id", "Bill Number", "Date", "Customer Name", "Phone", "Product Id", "Product Name", "Mrp", "Quantity", "Price"
				}
			));
		}
		return table;
	}
	
	
	private void displayAllBillByBillNum()
	{
	
		BillService bs = new BillServiceImpl();
		List<Bill> blist=bs.searchBillByBillNum(Integer.parseInt(bnumTxt.getText()));
		 DefaultTableModel tmodel = (DefaultTableModel) table.getModel();
		    tmodel.setRowCount(0);  //  table reset
		    for (Bill bt : blist) {
		    	
		    	tmodel.addRow(new Object[] {bt.getId(),bt.getBnumber(),bt.getDate(),bt.getCustomername(),bt.getPhone(),bt.getPid(),bt.getProductname(),bt.getMrp(),bt.getQuantity(),bt.getPrice()});
				
			}
	}
	
	private JButton getBtnSearch() {
		if (btnSearch == null) {
			btnSearch = new JButton("Search");
			btnSearch.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					
					if(bnumTxt.getText().isEmpty())
					{
						JOptionPane.showMessageDialog(null, "enter the bill num");
						return;
					}
					else
					{
						displayAllBillByBillNum();
					}
					
					displayAllBillByBillNum();
				}
			});
			btnSearch.setFont(new Font("Tahoma", Font.PLAIN, 15));
			btnSearch.setBounds(303, 132, 112, 34);
		}
		return btnSearch;
	}
}
