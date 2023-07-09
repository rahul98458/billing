package com.view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.List;
import java.awt.event.ActionEvent;
import javax.swing.JSeparator;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import com.model.Cashier;

import com.service.CashierService;
import com.service.CashierServiceimpl;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class CashierAdd extends JFrame {

	private JPanel contentPane;
	private JLabel lblNewLabel;
	private JLabel lblNewLabel_1_1;
	private JLabel lblNewLabel_1_1_1;
	private JLabel lblNewLabel_1_1_1_1;
	private JLabel lblNewLabel_1_1_1_1_1;
	private JLabel lblNewLabel_1_1_1_1_1_1;
	private JLabel lblNewLabel_1_1_1_1_1_1_1;
	private JTextField nameTxt;
	private JTextField usernameTxt;
	private JTextField numberTxt;
	private JTextField addressTxt;
	private JTextField emailTxt;
	private JTextField passwordTxt;
	private JButton btnNewButton;
	private JButton updateBtn;
	private JButton deleteBtn;
	private JSeparator separator;
	private JSeparator separator_1;
	private JSeparator separator_1_1;
	private JScrollPane scrollPane;
	private JTable table;
	private int cid=0;
	private JButton btnNewButton_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CashierAdd frame = new CashierAdd();
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
	public CashierAdd() {
		setForeground(new Color(240, 240, 240));
		setFont(null);
		setTitle("Add Cashier");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1083, 785);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		contentPane.add(getLblNewLabel());
		contentPane.add(getLblNewLabel_1_1());
		contentPane.add(getLblNewLabel_1_1_1());
		contentPane.add(getLblNewLabel_1_1_1_1());
		contentPane.add(getLblNewLabel_1_1_1_1_1());
		contentPane.add(getLblNewLabel_1_1_1_1_1_1());
		contentPane.add(getLblNewLabel_1_1_1_1_1_1_1());
		contentPane.add(getNameTxt());
		contentPane.add(getUsernameTxt());
		contentPane.add(getNumberTxt());
		contentPane.add(getAddressTxt());
		contentPane.add(getEmailTxt());
		contentPane.add(getPasswordTxt());
		contentPane.add(getBtnNewButton());
		contentPane.add(getUpdateBtn());
		contentPane.add(getDeleteBtn());
		contentPane.add(getSeparator());
		contentPane.add(getSeparator_1());
		contentPane.add(getSeparator_1_1());
		contentPane.add(getScrollPane());
		contentPane.add(getBtnNewButton_1());
		displayData();
		updateBtn.setEnabled(false);
		deleteBtn.setEnabled(false);
		
	}

	private JLabel getLblNewLabel() {
		if (lblNewLabel == null) {
			lblNewLabel = new JLabel("Add Cashier Details");
			lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
			lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 20));
			lblNewLabel.setBounds(51, 42, 319, 33);
		}
		return lblNewLabel;
	}
	private JLabel getLblNewLabel_1_1() {
		if (lblNewLabel_1_1 == null) {
			lblNewLabel_1_1 = new JLabel("Cashier Name");
			lblNewLabel_1_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
			lblNewLabel_1_1.setBounds(41, 139, 131, 33);
		}
		return lblNewLabel_1_1;
	}
	private JLabel getLblNewLabel_1_1_1() {
		if (lblNewLabel_1_1_1 == null) {
			lblNewLabel_1_1_1 = new JLabel("Cashier Username");
			lblNewLabel_1_1_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
			lblNewLabel_1_1_1.setBounds(41, 205, 131, 33);
		}
		return lblNewLabel_1_1_1;
	}
	private JLabel getLblNewLabel_1_1_1_1() {
		if (lblNewLabel_1_1_1_1 == null) {
			lblNewLabel_1_1_1_1 = new JLabel("Mobile Number");
			lblNewLabel_1_1_1_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
			lblNewLabel_1_1_1_1.setBounds(41, 277, 131, 33);
		}
		return lblNewLabel_1_1_1_1;
	}
	private JLabel getLblNewLabel_1_1_1_1_1() {
		if (lblNewLabel_1_1_1_1_1 == null) {
			lblNewLabel_1_1_1_1_1 = new JLabel("Address");
			lblNewLabel_1_1_1_1_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
			lblNewLabel_1_1_1_1_1.setBounds(41, 342, 131, 33);
		}
		return lblNewLabel_1_1_1_1_1;
	}
	private JLabel getLblNewLabel_1_1_1_1_1_1() {
		if (lblNewLabel_1_1_1_1_1_1 == null) {
			lblNewLabel_1_1_1_1_1_1 = new JLabel("Email-Id");
			lblNewLabel_1_1_1_1_1_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
			lblNewLabel_1_1_1_1_1_1.setBounds(41, 423, 131, 33);
		}
		return lblNewLabel_1_1_1_1_1_1;
	}
	private JLabel getLblNewLabel_1_1_1_1_1_1_1() {
		if (lblNewLabel_1_1_1_1_1_1_1 == null) {
			lblNewLabel_1_1_1_1_1_1_1 = new JLabel("Password");
			lblNewLabel_1_1_1_1_1_1_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
			lblNewLabel_1_1_1_1_1_1_1.setBounds(41, 501, 131, 33);
		}
		return lblNewLabel_1_1_1_1_1_1_1;
	}
	private JTextField getNameTxt() {
		if (nameTxt == null) {
			nameTxt = new JTextField();
			nameTxt.setColumns(10);
			nameTxt.setBounds(176, 139, 219, 28);
		}
		return nameTxt;
	}
	private JTextField getUsernameTxt() {
		if (usernameTxt == null) {
			usernameTxt = new JTextField();
			usernameTxt.setColumns(10);
			usernameTxt.setBounds(176, 210, 219, 28);
		}
		return usernameTxt;
	}
	private JTextField getNumberTxt() {
		if (numberTxt == null) {
			numberTxt = new JTextField();
			numberTxt.setColumns(10);
			numberTxt.setBounds(176, 282, 219, 28);
		}
		return numberTxt;
	}
	private JTextField getAddressTxt() {
		if (addressTxt == null) {
			addressTxt = new JTextField();
			addressTxt.setColumns(10);
			addressTxt.setBounds(176, 347, 219, 28);
		}
		return addressTxt;
	}
	private JTextField getEmailTxt() {
		if (emailTxt == null) {
			emailTxt = new JTextField();
			emailTxt.setColumns(10);
			emailTxt.setBounds(176, 423, 219, 28);
		}
		return emailTxt;
	}
	private JTextField getPasswordTxt() {
		if (passwordTxt == null) {
			passwordTxt = new JTextField();
			passwordTxt.setColumns(10);
			passwordTxt.setBounds(176, 506, 219, 28);
		}
		return passwordTxt;
	}
	private JButton getBtnNewButton() {
		if (btnNewButton == null) {
			btnNewButton = new JButton("Add New");
			btnNewButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					
					if(nameTxt.getText().isEmpty()||usernameTxt.getText().isEmpty()||passwordTxt.getText().isEmpty()||emailTxt.getText().isEmpty()||numberTxt.getText().isEmpty()||addressTxt.getText().isEmpty())                            
					{
						JOptionPane.showMessageDialog(null, "enter all field");
					}
					else
					{
						
						Cashier c = new Cashier();
						c.setName(nameTxt.getText());
						c.setUsername(usernameTxt.getText());
						c.setPassword(passwordTxt.getText());
						c.setEmail(emailTxt.getText());
						c.setMobile(numberTxt.getText());
						c.setAddress(addressTxt.getText());
						CashierService cs = new CashierServiceimpl();
						boolean res = cs.addCashier(c);
						if(res)
						{
							JOptionPane.showMessageDialog(null, "added success");
							nameTxt.setText("");
							usernameTxt.setText("");
							passwordTxt.setText("");
							emailTxt.setText("");
							numberTxt.setText("");
							addressTxt.setText("");
							displayData();
						}
						else
						{
							JOptionPane.showMessageDialog(null, "adding failed");
						}
					}
					
					
					
					
//					
//					Cashier c = new Cashier();
//					c.setName(nameTxt.getText());
//					c.setUsername(usernameTxt.getText());
//					c.setPassword(passwordTxt.getText());
//					c.setEmail(emailTxt.getText());
//					c.setMobile(numberTxt.getText());
//					c.setAddress(addressTxt.getText());
//					CashierService cs = new CashierServiceimpl();
//					boolean res = cs.addCashier(c);
//					if(res)
//					{
//						JOptionPane.showMessageDialog(null, "added success");
//						nameTxt.setText("");
//						usernameTxt.setText("");
//						passwordTxt.setText("");
//						emailTxt.setText("");
//						numberTxt.setText("");
//						addressTxt.setText("");
//						displayData();
//					}
//					else
//					{
//						JOptionPane.showMessageDialog(null, "adding failed");
//					}
					
			
				}
			});
			btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 14));
			btnNewButton.setBounds(51, 592, 102, 33);
		}
		return btnNewButton;
	}
	private JButton getUpdateBtn() {
		if (updateBtn == null) {
			updateBtn = new JButton("Update");
			updateBtn.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					
					Cashier c = new Cashier();
					c.setId(cid);
					c.setName(nameTxt.getText());
					c.setUsername(usernameTxt.getText());
					c.setAddress(addressTxt.getText());
					c.setEmail(emailTxt.getText());
					c.setMobile(numberTxt.getText());
					c.setPassword(passwordTxt.getText());
					CashierService cs = new CashierServiceimpl();
					boolean res=cs.updateCashier(c);
					if(res)
					{
					 JOptionPane.showMessageDialog(null, "updated success");	
					 displayData();
					}
					else
					{
						JOptionPane.showMessageDialog(null, "updated failed");
					}
					 
					
				}
			});
			updateBtn.setFont(new Font("Tahoma", Font.PLAIN, 14));
			updateBtn.setBounds(176, 592, 102, 33);
		}
		return updateBtn;
	}
	private JButton getDeleteBtn() {
		if (deleteBtn == null) {
			deleteBtn = new JButton("Delete");
			deleteBtn.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					if(table.getSelectedRow()<0)
					{
						JOptionPane.showMessageDialog(null, "select the row");
						return;
					}
					int srow = table.getSelectedRow();
					int ccid=(int) table.getModel().getValueAt(srow, 0);
					CashierService cs = new CashierServiceimpl();
					boolean res=cs.deleteCashier(ccid);
					if(res)
					{
					 JOptionPane.showMessageDialog(null, "deleted success");	
					 displayData();
					}
					else
					{
						JOptionPane.showMessageDialog(null, "deleted failed");
					}
					
				}
			});
			deleteBtn.setFont(new Font("Tahoma", Font.PLAIN, 14));
			deleteBtn.setBounds(301, 592, 102, 33);
		}
		return deleteBtn;
	}
	private JSeparator getSeparator() {
		if (separator == null) {
			separator = new JSeparator();
			separator.setOrientation(SwingConstants.VERTICAL);
			separator.setBounds(428, 112, 14, 574);
		}
		return separator;
	}
	private JSeparator getSeparator_1() {
		if (separator_1 == null) {
			separator_1 = new JSeparator();
			separator_1.setBounds(428, 684, 587, 2);
		}
		return separator_1;
	}
	private JSeparator getSeparator_1_1() {
		if (separator_1_1 == null) {
			separator_1_1 = new JSeparator();
			separator_1_1.setBounds(428, 112, 587, 2);
		}
		return separator_1_1;
	}
	private JScrollPane getScrollPane() {
		if (scrollPane == null) {
			scrollPane = new JScrollPane();
			scrollPane.addMouseListener(new MouseAdapter() {
			
				
			});
			scrollPane.setBounds(438, 124, 577, 416);
			scrollPane.setViewportView(getTable());
		}
		return scrollPane;
	}
	private JTable getTable() {
		if (table == null) {
			table = new JTable();
			table.addMouseListener(new MouseAdapter() {
			
				public void mouseClicked(MouseEvent e) {
					selectData();
				}
			});
			table.setModel(new DefaultTableModel(
				new Object[][] {
				},
				new String[] {
					"Id", "Name", "User Name", "Mobile Num", "Address", "Email", "Password"
				}
			));
		}
		return table;
	}
	
	private void displayData()
	{
	
		CashierService cs = new CashierServiceimpl();
		List<Cashier> clist=cs.displayCashier();
		 DefaultTableModel tmodel = (DefaultTableModel) table.getModel();
		    tmodel.setRowCount(0);  //  table reset
		    for (Cashier ct : clist) {
		    	
		    	tmodel.addRow(new Object[] {ct.getId(),ct.getName(),ct.getUsername(),ct.getMobile(),ct.getAddress(),ct.getEmail(),ct.getPassword()});
				
			}
	}
	 private void selectData()
	 {
			int carow = table.getSelectedRow();
			cid=(int) table.getModel().getValueAt(carow, 0);
			String cname = (String) table.getModel().getValueAt(carow, 1);
			String cusername = (String) table.getModel().getValueAt(carow, 2);
			String cnumber = (String) table.getModel().getValueAt(carow, 3);
			String caddress = (String) table.getModel().getValueAt(carow, 4);
			String cemail = (String) table.getModel().getValueAt(carow, 5);
			String cpassword = (String) table.getModel().getValueAt(carow, 6);
			nameTxt.setText(cname);
			usernameTxt.setText(cusername);
			numberTxt.setText(cnumber);
			addressTxt.setText(caddress);			
			emailTxt.setText(cemail);
	        passwordTxt.setText(cpassword);
	        updateBtn.setEnabled(true);
	        deleteBtn.setEnabled(true);
	 }
	
	private JButton getBtnNewButton_1() {
		if (btnNewButton_1 == null) {
			btnNewButton_1 = new JButton("Back");
			btnNewButton_1.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					new AdminPanel().setVisible(true);
					dispose();
				}
			});
			btnNewButton_1.setFont(new Font("Tahoma", Font.BOLD, 15));
			btnNewButton_1.setBounds(910, 588, 102, 33);
		}
		return btnNewButton_1;
	}
}
