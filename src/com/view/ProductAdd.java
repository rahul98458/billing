package com.view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JSeparator;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import com.model.Cashier;
import com.model.Product;
import com.service.CashierService;
import com.service.CashierServiceimpl;
import com.service.ProductService;
import com.service.ProductServiceImpl;

import java.awt.event.ActionListener;
import java.util.List;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class ProductAdd extends JFrame {

	private JPanel qtyaddTxt;
	private JLabel lblNewLabel;
	private JLabel lblNewLabel_1;
	private JTextField idTxt;
	private JLabel lblNewLabel_1_1;
	private JLabel lblNewLabel_1_1_1;
	private JLabel lblNewLabel_1_1_1_1;
	private JLabel lblNewLabel_1_1_1_1_1;
	private JTextField nameTxt;
	private JTextField qtyavailableTxt;
	private JTextField qtyaddedTxt;
	private JTextField mrpTxt;
	private JButton addBtn;
	private JButton updateBtn;
	private JSeparator separator;
	private JScrollPane scrollPane;
	private JTable table;
	private int pid=0;
	private JButton qtyaddBtn;
	private JButton btnNewButton;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ProductAdd frame = new ProductAdd();
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
	public ProductAdd() {
		setTitle("Update Product");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 864, 625);
		qtyaddTxt = new JPanel();
		qtyaddTxt.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(qtyaddTxt);
		qtyaddTxt.setLayout(null);
		qtyaddTxt.add(getLblNewLabel());
		qtyaddTxt.add(getLblNewLabel_1());
		qtyaddTxt.add(getIdTxt());
		qtyaddTxt.add(getLblNewLabel_1_1());
		qtyaddTxt.add(getLblNewLabel_1_1_1());
		qtyaddTxt.add(getLblNewLabel_1_1_1_1());
		qtyaddTxt.add(getLblNewLabel_1_1_1_1_1());
		qtyaddTxt.add(getNameTxt());
		qtyaddTxt.add(getQtyavailableTxt());
		qtyaddTxt.add(getQtyaddedTxt());
		qtyaddTxt.add(getMrpTxt());
		qtyaddTxt.add(getAddBtn());
		qtyaddTxt.add(getUpdateBtn());
		qtyaddTxt.add(getSeparator());
		qtyaddTxt.add(getScrollPane());
		//idTxt.setVisible(false);
		
		qtyaddTxt.add(getQtyaddBtn());
		viewProduct();
		idTxt.enable(false);
		qtyaddedTxt.enable(false);
		updateBtn.setEnabled(false);
	     qtyaddBtn.setEnabled(false);
	     qtyaddTxt.add(getBtnNewButton());
	}
	private JLabel getLblNewLabel() {
		if (lblNewLabel == null) {
			lblNewLabel = new JLabel("Update Product");
			lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
			lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 18));
			lblNewLabel.setBounds(70, 54, 253, 47);
		}
		return lblNewLabel;
	}
	private JLabel getLblNewLabel_1() {
		if (lblNewLabel_1 == null) {
			lblNewLabel_1 = new JLabel("Product Id");
			lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
			lblNewLabel_1.setBounds(38, 133, 123, 29);
		}
		return lblNewLabel_1;
	}
	private JTextField getIdTxt() {
		if (idTxt == null) {
			idTxt = new JTextField();
			idTxt.setBounds(162, 135, 161, 29);
			idTxt.setColumns(10);
		}
		return idTxt;
	}
	private JLabel getLblNewLabel_1_1() {
		if (lblNewLabel_1_1 == null) {
			lblNewLabel_1_1 = new JLabel("Product Name");
			lblNewLabel_1_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
			lblNewLabel_1_1.setBounds(38, 203, 123, 29);
		}
		return lblNewLabel_1_1;
	}
	private JLabel getLblNewLabel_1_1_1() {
		if (lblNewLabel_1_1_1 == null) {
			lblNewLabel_1_1_1 = new JLabel("Quantity Available");
			lblNewLabel_1_1_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
			lblNewLabel_1_1_1.setBounds(38, 267, 123, 29);
		}
		return lblNewLabel_1_1_1;
	}
	private JLabel getLblNewLabel_1_1_1_1() {
		if (lblNewLabel_1_1_1_1 == null) {
			lblNewLabel_1_1_1_1 = new JLabel("Quantity Added");
			lblNewLabel_1_1_1_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
			lblNewLabel_1_1_1_1.setBounds(38, 334, 123, 29);
		}
		return lblNewLabel_1_1_1_1;
	}
	private JLabel getLblNewLabel_1_1_1_1_1() {
		if (lblNewLabel_1_1_1_1_1 == null) {
			lblNewLabel_1_1_1_1_1 = new JLabel("Mrp");
			lblNewLabel_1_1_1_1_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
			lblNewLabel_1_1_1_1_1.setBounds(38, 404, 123, 29);
		}
		return lblNewLabel_1_1_1_1_1;
	}
	private JTextField getNameTxt() {
		if (nameTxt == null) {
			nameTxt = new JTextField();
			nameTxt.setColumns(10);
			nameTxt.setBounds(162, 205, 161, 29);
		}
		return nameTxt;
	}
	private JTextField getQtyavailableTxt() {
		if (qtyavailableTxt == null) {
			qtyavailableTxt = new JTextField();
			qtyavailableTxt.setColumns(10);
			qtyavailableTxt.setBounds(162, 267, 161, 29);
		}
		return qtyavailableTxt;
	}
	private JTextField getQtyaddedTxt() {
		if (qtyaddedTxt == null) {
			qtyaddedTxt = new JTextField();
			qtyaddedTxt.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					qtyaddBtn.setEnabled(true);
					updateBtn.setEnabled(true);
					qtyaddedTxt.setEnabled(true);
				}
			});
			qtyaddedTxt.setColumns(10);
			qtyaddedTxt.setBounds(162, 334, 161, 29);
		}
		return qtyaddedTxt;
	}
	private JTextField getMrpTxt() {
		if (mrpTxt == null) {
			mrpTxt = new JTextField();
			mrpTxt.setColumns(10);
			mrpTxt.setBounds(162, 404, 161, 29);
		}
		return mrpTxt;
	}
	private JButton getAddBtn() {
		if (addBtn == null) {
			addBtn = new JButton("Add Product");
			addBtn.setHorizontalAlignment(SwingConstants.LEFT);
			addBtn.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					
					
					if(nameTxt.getText().isEmpty()||qtyavailableTxt.getText().isEmpty()||mrpTxt.getText().isEmpty())
					{
					   	JOptionPane.showMessageDialog(null, "enter all field");
					}
					else
					{

						Product p = new Product();
						p.setName(nameTxt.getText());
						p.setQuantityavailabe(Integer.parseInt(qtyavailableTxt.getText()));
						p.setMrp(Integer.parseInt(mrpTxt.getText()));
						ProductService ps = new ProductServiceImpl();
						boolean res=ps.addProduct(p);
						if(res)
						{
							JOptionPane.showMessageDialog(null, "product added success");
							viewProduct();
					
						//	qtyaddedTxt.setEnabled(true);
						}
						else
						{
							JOptionPane.showMessageDialog(null, "product added failed");
						}
						nameTxt.setText("");
						qtyavailableTxt.setText("");
						mrpTxt.setText("");
					}
					
//					
//					Product p = new Product();
//					p.setName(nameTxt.getText());
//					p.setQuantityavailabe(Integer.parseInt(qtyavailableTxt.getText()));
//					p.setMrp(Integer.parseInt(mrpTxt.getText()));
//					ProductService ps = new ProductServiceImpl();
//					boolean res=ps.addProduct(p);
//					if(res)
//					{
//						JOptionPane.showMessageDialog(null, "product added success");
//						viewProduct();
//				
//					//	qtyaddedTxt.setEnabled(true);
//					}
//					else
//					{
//						JOptionPane.showMessageDialog(null, "product added failed");
//					}
					
//					nameTxt.setText("");
//					qtyavailableTxt.setText("");
//					mrpTxt.setText("");
				}
			});
			addBtn.setFont(new Font("Tahoma", Font.PLAIN, 12));
			addBtn.setBounds(38, 486, 106, 36);
		}
		return addBtn;
	}
	private JButton getUpdateBtn() {
		if (updateBtn == null) {
			updateBtn = new JButton("Update");
			updateBtn.setHorizontalAlignment(SwingConstants.LEFT);
			updateBtn.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					
					ProductService ps = new ProductServiceImpl();
					Product p = new Product();
					p.setId(pid);
					p.setName(nameTxt.getText());
					p.setQuantityavailabe(Integer.parseInt(qtyavailableTxt.getText()));
					p.setMrp(Integer.parseInt(mrpTxt.getText()));
				Boolean rs =ps.updateProduct(p);
				if(rs)
				{
					JOptionPane.showMessageDialog(null, "updated success");
					viewProduct();
					
				}
				else
				{
					JOptionPane.showMessageDialog(null, "updated failed");
				}
				nameTxt.setText("");
				qtyavailableTxt.setText("");
				mrpTxt.setText("");
				}
			});
			updateBtn.setFont(new Font("Tahoma", Font.PLAIN, 12));
			updateBtn.setBounds(145, 486, 89, 36);
		}
		return updateBtn;
	}
	private JSeparator getSeparator() {
		if (separator == null) {
			separator = new JSeparator();
			separator.setOrientation(SwingConstants.VERTICAL);
			separator.setBounds(349, 71, 15, 453);
		}
		return separator;
	}
	private JScrollPane getScrollPane() {
		if (scrollPane == null) {
			scrollPane = new JScrollPane();
			scrollPane.setBounds(363, 85, 466, 263);
			scrollPane.setViewportView(getTable());
		}
		return scrollPane;
	}
	private JTable getTable() {
		if (table == null) {
			table = new JTable();
			table.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					selectProduct();
					addBtn.setEnabled(false);
					updateBtn.setEnabled(true);
					qtyaddedTxt.setEnabled(true);
					//qtyaddBtn.setEnabled(true);
					
				}
			});
			table.setModel(new DefaultTableModel(
				new Object[][] {
				},
				new String[] {
					"Id", "Name", "Quantity Available", "Mrp"
				}
			));
		}
		return table;
	}
	
	private void viewProduct()
	{
		ProductService ps = new ProductServiceImpl();
		List<Product> plist=ps.getAllProduct();
		 DefaultTableModel tmodel = (DefaultTableModel) table.getModel();
		    tmodel.setRowCount(0);  //  table reset
		    for (Product pt : plist) {
		    	
		    	tmodel.addRow(new Object[] {pt.getId(),pt.getName(),pt.getQuantityavailabe(),pt.getMrp()});
				
			}
	}
	private void selectProduct()
	{
		int prow = table.getSelectedRow();
		pid=(int) table.getModel().getValueAt(prow, 0);
		String pname = (String) table.getModel().getValueAt(prow, 1);
		int quantity =  (int) table.getModel().getValueAt(prow, 2);
		int mrp = (int) table.getModel().getValueAt(prow, 3);
		nameTxt.setText(pname);
		qtyavailableTxt.setText(Integer.toString(quantity));
		mrpTxt.setText(Integer.toString(mrp));
		
		
	}
	private JButton getQtyaddBtn() {
		if (qtyaddBtn == null) {
			qtyaddBtn = new JButton("Add Quantity");
			qtyaddBtn.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					
					int qty = Integer.parseInt(qtyavailableTxt.getText());
					int aq= Integer.parseInt(qtyaddedTxt.getText());
					int fq = qty+aq;
					
					ProductService ps = new ProductServiceImpl();
					Product p = new Product();
					p.setId(pid);
					p.setName(nameTxt.getText());
					p.setQuantityavailabe(fq);
					p.setMrp(Integer.parseInt(mrpTxt.getText()));
				Boolean rs =ps.updateProduct(p);
				if(rs)
				{
					JOptionPane.showMessageDialog(null, "stock added success");
					viewProduct();
					
				}
				else
				{
					JOptionPane.showMessageDialog(null, "stock added failed");
				}
				nameTxt.setText("");
				qtyavailableTxt.setText("");
				mrpTxt.setText("");
				qtyaddedTxt.setText("");
				}
			});
			qtyaddBtn.setHorizontalAlignment(SwingConstants.LEFT);
			qtyaddBtn.setFont(new Font("Tahoma", Font.PLAIN, 12));
			qtyaddBtn.setEnabled(false);
			qtyaddBtn.setBounds(235, 486, 103, 36);
		}
		return qtyaddBtn;
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
			btnNewButton.setBounds(687, 486, 98, 30);
		}
		return btnNewButton;
	}
}
