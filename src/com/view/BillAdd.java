package com.view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;
import javax.swing.JScrollPane;
import javax.swing.JSeparator;
import javax.swing.SwingConstants;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import com.db.Db;
import com.model.Bill;
import com.model.Cashier;
import com.model.Product;
import com.model.Sale;
import com.service.BillService;
import com.service.BillServiceImpl;
import com.service.CashierService;
import com.service.CashierServiceimpl;
import com.service.ProductService;
import com.service.ProductServiceImpl;
import com.service.SaleService;
import com.service.SaleServiceImpl;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.print.PrinterException;
import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;
import javax.swing.DefaultComboBoxModel;

public class BillAdd extends JFrame {

	private JPanel contentPane;
	private JLabel lblNewLabel;
	private JLabel lblProductId;
	private JLabel lblNewLabel_1_1;
	private JLabel lblNewLabel_1_1_1;
	private JLabel lblNewLabel_1_1_1_1;
	private JButton addBtn;
	private JButton remBtn;
	private JTextField nameTxt;
	private JTextField pidTxt;
	private JComboBox pnameCmb;
	private JTextField mrpTxt;
	private JTextField qtyTxt;
	private JScrollPane scrollPane;
	private JSeparator separator;
	private JTable table;
	private JLabel lblTotal;
	private JTextField totalTxt;
	private JButton btnPrint;
	private JLabel lblDate;
	private JTextField dateTxt;
	private int a=0;
	private int b=0;
	private JLabel lblMobileNum;
	private JTextField numTxt;

	private JLabel lblNewLabel_1;
	private JTextField bnTxt;
	private JButton btnBack;
	
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					BillAdd frame = new BillAdd();
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
	public BillAdd() {
		setTitle("Billing");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1001, 573);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		contentPane.add(getLblNewLabel());
		contentPane.add(getLblProductId());
		contentPane.add(getLblNewLabel_1_1());
		contentPane.add(getLblNewLabel_1_1_1());
		contentPane.add(getLblNewLabel_1_1_1_1());
		contentPane.add(getAddBtn());
		contentPane.add(getRemBtn());
		contentPane.add(getNameTxt());
		contentPane.add(getPidTxt());
		contentPane.add(getPnameCmb());
		contentPane.add(getMrpTxt());
		contentPane.add(getQtyTxt());
		contentPane.add(getScrollPane());
		contentPane.add(getSeparator());
		contentPane.add(getLblTotal());
		contentPane.add(getTotalTxt());
		contentPane.add(getBtnPrint());
		contentPane.add(getLblDate());
		contentPane.add(getDateTxt());
		displayProduct();
		remBtn.setEnabled(false);
		
		contentPane.add(getLblMobileNum());
		contentPane.add(getNumTxt());
		contentPane.add(getLblNewLabel_1());
		contentPane.add(getBnTxt());
		
		bnTxt.setText(Integer.toString(bn()));
		bnTxt.setEnabled(false);
		contentPane.add(getBtnBack());
		 
	}
	private JLabel getLblNewLabel() {
		if (lblNewLabel == null) {
			lblNewLabel = new JLabel("Customer Name");
			lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 12));
			lblNewLabel.setBounds(34, 70, 132, 33);
		}
		return lblNewLabel;
	}
	private JLabel getLblProductId() {
		if (lblProductId == null) {
			lblProductId = new JLabel("Product Id");
			lblProductId.setFont(new Font("Tahoma", Font.BOLD, 12));
			lblProductId.setBounds(34, 197, 132, 33);
		}
		return lblProductId;
	}
	private JLabel getLblNewLabel_1_1() {
		if (lblNewLabel_1_1 == null) {
			lblNewLabel_1_1 = new JLabel("Product Name");
			lblNewLabel_1_1.setFont(new Font("Tahoma", Font.BOLD, 12));
			lblNewLabel_1_1.setBounds(34, 261, 132, 33);
		}
		return lblNewLabel_1_1;
	}
	private JLabel getLblNewLabel_1_1_1() {
		if (lblNewLabel_1_1_1 == null) {
			lblNewLabel_1_1_1 = new JLabel("Mrp");
			lblNewLabel_1_1_1.setFont(new Font("Tahoma", Font.BOLD, 12));
			lblNewLabel_1_1_1.setBounds(34, 327, 132, 33);
		}
		return lblNewLabel_1_1_1;
	}
	private JLabel getLblNewLabel_1_1_1_1() {
		if (lblNewLabel_1_1_1_1 == null) {
			lblNewLabel_1_1_1_1 = new JLabel("Quantity");
			lblNewLabel_1_1_1_1.setFont(new Font("Tahoma", Font.BOLD, 12));
			lblNewLabel_1_1_1_1.setBounds(34, 386, 132, 33);
		}
		return lblNewLabel_1_1_1_1;
	}
	private JButton getAddBtn() {
		if (addBtn == null) {
			addBtn = new JButton("Add");
			addBtn.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					
					
					if(nameTxt.getText().isEmpty()||pidTxt.getText().isEmpty()||pnameCmb.getSelectedIndex()==0||mrpTxt.getText().isEmpty()||qtyTxt.getText().isEmpty()||dateTxt.getText().isEmpty()||numTxt.getText().isEmpty())                     
					{
						JOptionPane.showMessageDialog(null, "enter all field");
					}
					else
					{
						
						if(showCombo())
						{
						BillService bs = new BillServiceImpl();
						Bill b = new Bill();
						b.setBnumber(Integer.parseInt(bnTxt.getText()));
						b.setCustomername(nameTxt.getText());
						b.setPid(Integer.parseInt(pidTxt.getText()));
						b.setProductname((String) pnameCmb.getSelectedItem());
						b.setMrp(Integer.parseInt(mrpTxt.getText()));
						b.setQuantity(Integer.parseInt(qtyTxt.getText()));
						b.setDate((dateTxt.getText()));
						b.setPhone(numTxt.getText());
						
						int fmrp = Integer.parseInt(mrpTxt.getText());
						int fqua = Integer.parseInt(qtyTxt.getText());
						int fprice = fmrp*fqua;
						b.setPrice(fprice);
						stockReduce();
						bs.addBill(b);
					showCombo();
					
						viewBillId();
					//	viewBill();
						
						
						pidTxt.setText("");
						pnameCmb.setSelectedIndex(0);
						mrpTxt.setText("");
						qtyTxt.setText("");
						}
						else {
							JOptionPane.showMessageDialog(null, "no stock");
						}
						
					}
					
//					
//					if(showCombo())
//					{
//					BillService bs = new BillServiceImpl();
//					Bill b = new Bill();
//					b.setBnumber(Integer.parseInt(bnTxt.getText()));
//					b.setCustomername(nameTxt.getText());
//					b.setPid(Integer.parseInt(pidTxt.getText()));
//					b.setProductname((String) pnameCmb.getSelectedItem());
//					b.setMrp(Integer.parseInt(mrpTxt.getText()));
//					b.setQuantity(Integer.parseInt(qtyTxt.getText()));
//					b.setDate((dateTxt.getText()));
//					b.setPhone(numTxt.getText());
//					
//					int fmrp = Integer.parseInt(mrpTxt.getText());
//					int fqua = Integer.parseInt(qtyTxt.getText());
//					int fprice = fmrp*fqua;
//					b.setPrice(fprice);
//					stockReduce();
//					bs.addBill(b);
//				showCombo();
//				
//					viewBillId();
//				//	viewBill();
//					
//					
//					pidTxt.setText("");
//					pnameCmb.setSelectedIndex(0);
//					mrpTxt.setText("");
//					qtyTxt.setText("");
//					}
//					else {
//						JOptionPane.showMessageDialog(null, "no stock");
//					}
//					
					
				}
			});
			addBtn.setFont(new Font("Tahoma", Font.PLAIN, 14));
			addBtn.setBounds(144, 452, 104, 28);
		}
		return addBtn;
	}
	private JButton getRemBtn() {
		if (remBtn == null) {
			remBtn = new JButton("Remove");
			remBtn.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					
					if(table.getSelectedRow()<0)
					{
						JOptionPane.showMessageDialog(null, "select the row");
						return;
					}
					int srow = table.getSelectedRow();
					int ccid=(int) table.getModel().getValueAt(srow, 0);
					BillService bs = new BillServiceImpl();
					boolean res=bs.deleteProduct(ccid);
					if(res)
					{
					 JOptionPane.showMessageDialog(null, "removed success");	
					 viewBill();
					 addBtn.setEnabled(true);
					}
					else
					{
						JOptionPane.showMessageDialog(null, "removed failed");
					}
					
				}
			});
			remBtn.setFont(new Font("Tahoma", Font.PLAIN, 14));
			remBtn.setBounds(285, 452, 104, 28);
		}
		return remBtn;
	}
	private JTextField getNameTxt() {
		if (nameTxt == null) {
			nameTxt = new JTextField();
			nameTxt.setBounds(174, 71, 215, 33);
			nameTxt.setColumns(10);
		}
		return nameTxt;
	}
	private JTextField getPidTxt() {
		if (pidTxt == null) {
			pidTxt = new JTextField();
			pidTxt.setEnabled(false);
			pidTxt.setColumns(10);
			pidTxt.setBounds(174, 198, 215, 33);
		}
		return pidTxt;
	}
	private JComboBox getPnameCmb() {
		if (pnameCmb == null) {
			pnameCmb = new JComboBox();
			pnameCmb.setModel(new DefaultComboBoxModel(new String[] {"select"}));
			pnameCmb.addItemListener(new ItemListener() {
				public void itemStateChanged(ItemEvent e) {
					getSelectedData();
				}
			});
			
			
			pnameCmb.setBounds(174, 262, 215, 33);
		}
		return pnameCmb;
	}
	private JTextField getMrpTxt() {
		if (mrpTxt == null) {
			mrpTxt = new JTextField();
			mrpTxt.setColumns(10);
			mrpTxt.setBounds(174, 328, 215, 33);
		}
		return mrpTxt;
	}
	private JTextField getQtyTxt() {
		if (qtyTxt == null) {
			qtyTxt = new JTextField();
			qtyTxt.setColumns(10);
			qtyTxt.setBounds(174, 387, 215, 33);
		}
		return qtyTxt;
	}
	private JScrollPane getScrollPane() {
		if (scrollPane == null) {
			scrollPane = new JScrollPane();
			scrollPane.setBounds(424, 70, 536, 360);
			scrollPane.setViewportView(getTable());
		}
		return scrollPane;
	}
	private JSeparator getSeparator() {
		if (separator == null) {
			separator = new JSeparator();
			separator.setOrientation(SwingConstants.VERTICAL);
			separator.setBounds(397, 70, 17, 360);
		}
		return separator;
	}
	private JTable getTable() {
		if (table == null) {
			table = new JTable();
			table.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					addBtn.setEnabled(false);
					remBtn.setEnabled(true);
					
				}
			});
			table.setModel(new DefaultTableModel(
				new Object[][] {
				},
				new String[] {
					"Id", "Product Name", "Quantity", "Mrp", "Price"
				}
			));
		}
		return table;
	}
	private JLabel getLblTotal() {
		if (lblTotal == null) {
			lblTotal = new JLabel("Total");
			lblTotal.setHorizontalAlignment(SwingConstants.CENTER);
			lblTotal.setFont(new Font("Tahoma", Font.BOLD, 12));
			lblTotal.setBounds(609, 453, 132, 33);
		}
		return lblTotal;
	}
	private JTextField getTotalTxt() {
		if (totalTxt == null) {
			totalTxt = new JTextField();
			totalTxt.setColumns(10);
			totalTxt.setBounds(746, 451, 215, 33);
		}
		return totalTxt;
	}
	private JButton getBtnPrint() {
		if (btnPrint == null) {
			btnPrint = new JButton("Print");
			btnPrint.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					Sale s = new Sale();
					int bn = Integer.parseInt(bnTxt.getText());
					String date = dateTxt.getText();
					String name = nameTxt.getText();
					String phone = numTxt.getText();
					int total=Integer.parseInt(totalTxt.getText());
					s.setDate(date);
					s.setCname(name);
					s.setPhone(phone);
					s.setTotal(total);
					s.setBillnum(bn);
					SaleService ss = new SaleServiceImpl();
				Boolean res=ss.saleAdd(s);
				if(res)
				{     
					JOptionPane.showMessageDialog(null, "sales completed take the bill");
				
					try {
						table.print();
					} catch (PrinterException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					new CashierPanel().setVisible(true);
					dispose();
				}
				else {
					JOptionPane.showMessageDialog(null, "errror");
				}
					
				}
			});
			btnPrint.setFont(new Font("Tahoma", Font.PLAIN, 14));
			btnPrint.setBounds(750, 494, 104, 28);
		}
		return btnPrint;
	
	}
	private void displayProduct()
	{
		String sql = "select name from product where quantity_available>=1";
		try {
			Statement stmt = Db.getDbConnection().createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			while(rs.next())
			{
				String pname = rs.getString("name");
				pnameCmb.addItem(pname);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	private void getSelectedData()
	{
		String tmp = (String) pnameCmb.getSelectedItem();
		String sql = "select * from product where name='"+tmp+"'";
		try {
			Statement stmt = Db.getDbConnection().createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			while(rs.next())
			{
				pidTxt.setText(rs.getString("id"));
				mrpTxt.setText(rs.getString("mrp"));
				
			}
		} catch (SQLException e) {
			// TODO Auto-gene)rated catch block
			e.printStackTrace();
		}
	}
	
	private JLabel getLblDate() {
		if (lblDate == null) {
			lblDate = new JLabel("Date");
			lblDate.setHorizontalAlignment(SwingConstants.CENTER);
			lblDate.setFont(new Font("Tahoma", Font.BOLD, 12));
			lblDate.setBounds(199, 24, 132, 33);
		}
		return lblDate;
	}
	private JTextField getDateTxt() {
		if (dateTxt == null) {
			dateTxt = new JTextField();
			dateTxt.setColumns(10);
			dateTxt.setBounds(320, 24, 215, 33);
		}
		return dateTxt;
	}
	
	private void viewBill()
	{
        int totall=0;
		BillService cs = new BillServiceImpl();
		List<Bill> clist=cs.displayBillByName(nameTxt.getText(),dateTxt.getText(),numTxt.getText());
		 DefaultTableModel tmodel = (DefaultTableModel) table.getModel();
		    tmodel.setRowCount(0);  //  table reset
		    for (Bill ct : clist) {
		    	
		    	tmodel.addRow(new Object[] {ct.getId(),ct.getProductname(),ct.getQuantity(),ct.getMrp(),ct.getPrice()});
		    	 totall = ct.getPrice()+ totall;
		    	totalTxt.setText(Integer.toString(totall));
				
			}
	}
	private void stockReduce()
	{

		String tmp = (String) pnameCmb.getSelectedItem();
		String sql = "select * from product where name='"+tmp+"'";
		try {
			Statement stmt = Db.getDbConnection().createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			if(rs.next())
			{
                  a =Integer.parseInt(rs.getString("quantity_available"));
                  b = Integer.parseInt(qtyTxt.getText());
                 int fiq = a-b;
                 String sqll = "update product set quantity_available='"+fiq+"' where name='"+tmp+"'";
                 stmt.executeUpdate(sqll);
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	private boolean showCombo()   //showing stock greater than 1
	{

		String tmp = (String) pnameCmb.getSelectedItem();
		String sql = "select * from product where name='"+tmp+"'";
		try {
			Statement stmt = Db.getDbConnection().createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			while(rs.next())
			{
                  a =Integer.parseInt(rs.getString("quantity_available"));
                  b = Integer.parseInt(qtyTxt.getText());
                  if(a>=b)
                  return true;
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}
	private JLabel getLblMobileNum() {
		if (lblMobileNum == null) {
			lblMobileNum = new JLabel("Mobile Num");
			lblMobileNum.setFont(new Font("Tahoma", Font.BOLD, 12));
			lblMobileNum.setBounds(34, 138, 132, 33);
		}
		return lblMobileNum;
	}
	private JTextField getNumTxt() {
		if (numTxt == null) {
			numTxt = new JTextField();
			numTxt.setColumns(10);
			numTxt.setBounds(174, 139, 215, 33);
		}
		return numTxt;
	}
	
	
	private void viewBillId()
	{
       int totall=0;
		BillService cs = new BillServiceImpl();
		List<Bill> clist=cs.displayById(nameTxt.getText(),dateTxt.getText(),numTxt.getText(),Integer.parseInt(bnTxt.getText()));
		 DefaultTableModel tmodel = (DefaultTableModel) table.getModel();
		    tmodel.setRowCount(0);  //  table reset
		    for (Bill ct : clist) {
		    	
		    	tmodel.addRow(new Object[] {ct.getId(),ct.getProductname(),ct.getQuantity(),ct.getMrp(),ct.getPrice()});
		    	 totall = ct.getPrice()+ totall;
		    	totalTxt.setText(Integer.toString(totall));
				
			}
	}
	private JLabel getLblNewLabel_1() {
		if (lblNewLabel_1 == null) {
			lblNewLabel_1 = new JLabel("B.No");
			lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 12));
			lblNewLabel_1.setBounds(34, 28, 38, 24);
		}
		return lblNewLabel_1;
	}
	private JTextField getBnTxt() {
		if (bnTxt == null) {
			bnTxt = new JTextField();
			bnTxt.setBounds(82, 30, 58, 24);
			bnTxt.setColumns(10);
		}
		return bnTxt;
	}
	private int bn()
	{
		int abno = 0;
		String sql = "select bill_number from bill ORDER BY id DESC LIMIT 1";
		try {
			Statement stmt = Db.getDbConnection().createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			while (rs.next()) {
				 abno=Integer.parseInt(rs.getString("bill_number"));
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
		return abno+1;
	}
	private JButton getBtnBack() {
		if (btnBack == null) {
			btnBack = new JButton("Back");
			btnBack.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					new CashierPanel().setVisible(true);
					dispose();
				}
			});
			btnBack.setFont(new Font("Tahoma", Font.PLAIN, 14));
			btnBack.setBounds(861, 494, 104, 28);
		}
		return btnBack;
	}
}
