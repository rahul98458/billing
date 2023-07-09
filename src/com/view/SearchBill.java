package com.view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import java.util.List;

import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JScrollPane;
import javax.swing.JSeparator;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import com.model.Bill;
import com.model.Cashier;

import com.service.BillService;
import com.service.BillServiceImpl;
import com.service.CashierService;
import com.service.CashierServiceimpl;


import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class SearchBill extends JFrame {

	private JPanel contentPane;
	private JLabel lblNewLabel;
	private JLabel lblNewLabel_1;
	private JLabel lblNewLabel_1_1;
	private JLabel lblNewLabel_1_1_1;
	private JTextField dateTxt;
	private JTextField nameTxt;
	private JTextField numTxt;
	private JScrollPane scrollPane;
	private JSeparator separator;
	private JTable table;
	private JButton btnNewButton;
	private JLabel lblNewLabel_1_2;
	private JTextField bnumTxt;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SearchBill frame = new SearchBill();
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
	public SearchBill() {
		setTitle("Search Bill");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1107, 500);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		contentPane.add(getLblNewLabel());
		contentPane.add(getLblNewLabel_1());
		contentPane.add(getLblNewLabel_1_1());
		contentPane.add(getLblNewLabel_1_1_1());
		contentPane.add(getDateTxt());
		contentPane.add(getNameTxt());
		contentPane.add(getNumTxt());
		contentPane.add(getScrollPane());
		contentPane.add(getSeparator());
		contentPane.add(getBtnNewButton());
		contentPane.add(getLblNewLabel_1_2());
		contentPane.add(getBnumTxt());
		displayAllBill();
	}

	private JLabel getLblNewLabel() {
		if (lblNewLabel == null) {
			lblNewLabel = new JLabel("Search");
			lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
			lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 20));
			lblNewLabel.setBounds(452, 20, 174, 31);
		}
		return lblNewLabel;
	}
	private JLabel getLblNewLabel_1() {
		if (lblNewLabel_1 == null) {
			lblNewLabel_1 = new JLabel("Enter Date ");
			lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
			lblNewLabel_1.setBounds(10, 209, 174, 39);
		}
		return lblNewLabel_1;
	}
	private JLabel getLblNewLabel_1_1() {
		if (lblNewLabel_1_1 == null) {
			lblNewLabel_1_1 = new JLabel("Enter Customer Name");
			lblNewLabel_1_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
			lblNewLabel_1_1.setBounds(10, 270, 174, 39);
		}
		return lblNewLabel_1_1;
	}
	private JLabel getLblNewLabel_1_1_1() {
		if (lblNewLabel_1_1_1 == null) {
			lblNewLabel_1_1_1 = new JLabel("Enter Customer Mobile");
			lblNewLabel_1_1_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
			lblNewLabel_1_1_1.setBounds(10, 331, 174, 39);
		}
		return lblNewLabel_1_1_1;
	}
	private JTextField getDateTxt() {
		if (dateTxt == null) {
			dateTxt = new JTextField();
			dateTxt.addKeyListener(new KeyAdapter() {
				@Override
				public void keyReleased(KeyEvent e) {
					
					String sdate = dateTxt.getText().trim();
					BillService bs = new BillServiceImpl();
					List<Bill> blist =bs.searchBillByDate(sdate);
					
					  
				    DefaultTableModel tmodel = (DefaultTableModel) table.getModel();
				    tmodel.setRowCount(0);  //  table reset
				    
				    
				    
				    for (Bill bt : blist) {
				    	
				    	tmodel.addRow(new Object[] {bt.getId(),bt.getDate(),bt.getCustomername(),bt.getBnumber(),bt.getPhone(),bt.getPid(),bt.getProductname(),bt.getMrp(),bt.getQuantity(),bt.getPrice()});
						
					}
					
					
				}
			});
			dateTxt.setBounds(168, 215, 124, 31);
			dateTxt.setColumns(10);
		}
		return dateTxt;
	}
	private JTextField getNameTxt() {
		if (nameTxt == null) {
			nameTxt = new JTextField();
			nameTxt.addKeyListener(new KeyAdapter() {
				@Override
				public void keyReleased(KeyEvent e) {
					
					String sname = nameTxt.getText().trim();
					BillService bs = new BillServiceImpl();
					List<Bill> blist =bs.searchBillByName(sname);
					
					  
				    DefaultTableModel tmodel = (DefaultTableModel) table.getModel();
				    tmodel.setRowCount(0);  //  table reset
				    
				    
				    
				    for (Bill bt : blist) {
				    	
				    	tmodel.addRow(new Object[] {bt.getId(),bt.getDate(),bt.getCustomername(),bt.getBnumber(),bt.getPhone(),bt.getPid(),bt.getProductname(),bt.getMrp(),bt.getQuantity(),bt.getPrice()});
						
					}
					
				}
			});
			nameTxt.setColumns(10);
			nameTxt.setBounds(168, 276, 124, 31);
		}
		return nameTxt;
	}
	private JTextField getNumTxt() {
		if (numTxt == null) {
			numTxt = new JTextField();
			numTxt.addKeyListener(new KeyAdapter() {
				@Override
				public void keyReleased(KeyEvent e) {
					
					
					String snum = numTxt.getText().trim();
					BillService bs = new BillServiceImpl();
					List<Bill> blist =bs.searchBillByPhone(snum);
					
					  
				    DefaultTableModel tmodel = (DefaultTableModel) table.getModel();
				    tmodel.setRowCount(0);  //  table reset
				    
				    
				    
				    for (Bill bt : blist) {
				    	
				    	tmodel.addRow(new Object[] {bt.getId(),bt.getDate(),bt.getCustomername(),bt.getBnumber(),bt.getPhone(),bt.getPid(),bt.getProductname(),bt.getMrp(),bt.getQuantity(),bt.getPrice()});
						
					}
					
					
				}
			});
			numTxt.setColumns(10);
			numTxt.setBounds(168, 337, 124, 31);
		}
		return numTxt;
	}
	private JScrollPane getScrollPane() {
		if (scrollPane == null) {
			scrollPane = new JScrollPane();
			scrollPane.setBounds(314, 87, 769, 322);
			scrollPane.setViewportView(getTable());
		}
		return scrollPane;
	}
	private JSeparator getSeparator() {
		if (separator == null) {
			separator = new JSeparator();
			separator.setOrientation(SwingConstants.VERTICAL);
			separator.setBounds(302, 87, 2, 322);
		}
		return separator;
	}
	private JTable getTable() {
		if (table == null) {
			table = new JTable();
			table.setModel(new DefaultTableModel(
				new Object[][] {
				},
				new String[] {
					"Id", "Date", "Cname","Bill Num", "Phone", "Pid", "Pname", "mrp", "quantity", "Price/Item"
				}
			));
		}
		return table;
	}
	
	private void displayAllBill()
	{
	
		BillService bs = new BillServiceImpl();
		List<Bill> blist=bs.displayAllBill();
		 DefaultTableModel tmodel = (DefaultTableModel) table.getModel();
		    tmodel.setRowCount(0);  //  table reset
		    for (Bill bt : blist) {
		    	
		    	tmodel.addRow(new Object[] {bt.getId(),bt.getDate(),bt.getCustomername(),bt.getBnumber(),bt.getPhone(),bt.getPid(),bt.getProductname(),bt.getMrp(),bt.getQuantity(),bt.getPrice()});
				
			}
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
			btnNewButton.setBounds(985, 419, 98, 31);
		}
		return btnNewButton;
	}
	private JLabel getLblNewLabel_1_2() {
		if (lblNewLabel_1_2 == null) {
			lblNewLabel_1_2 = new JLabel("Enter Bill Num");
			lblNewLabel_1_2.setFont(new Font("Tahoma", Font.PLAIN, 15));
			lblNewLabel_1_2.setBounds(10, 159, 174, 39);
		}
		return lblNewLabel_1_2;
	}
	private JTextField getBnumTxt() {
		if (bnumTxt == null) {
			bnumTxt = new JTextField();
			bnumTxt.addKeyListener(new KeyAdapter() {
				@Override
				public void keyReleased(KeyEvent e) {
					

					String bnum =bnumTxt.getText().trim();
					BillService bs = new BillServiceImpl();
					List<Bill> blist =bs.searchBillLikeBillNum(bnum);
					
					  
				    DefaultTableModel tmodel = (DefaultTableModel) table.getModel();
				    tmodel.setRowCount(0);  //  table reset
				    
				    
				    
				    for (Bill bt : blist) {
				    	
				    	tmodel.addRow(new Object[] {bt.getId(),bt.getDate(),bt.getCustomername(),bt.getBnumber(),bt.getPhone(),bt.getPid(),bt.getProductname(),bt.getMrp(),bt.getQuantity(),bt.getPrice()});
						
					}
					
				}
			});
			bnumTxt.setColumns(10);
			bnumTxt.setBounds(168, 166, 124, 31);
		}
		return bnumTxt;
	}
}
