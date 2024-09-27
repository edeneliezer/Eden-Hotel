// @author Eden Eliezer ID 207188038
package view;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.SwingConstants;
import javax.swing.border.EtchedBorder;

import com.toedter.calendar.JDateChooser;
import com.toedter.calendar.JYearChooser;

import model.Customer;
import Exceptions.EmptyException;
import Exceptions.LettersOnlyException;
import Exceptions.NumbersOnlyException;
import Exceptions.PersonAlreadyExistException;
import model.VIPCustomer;
import utils.Area;
import utils.Gender;

public class AddCustomer extends JInternalFrame {

	double discount;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AddCustomer frame = new AddCustomer();
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
	public AddCustomer() {
		
		// adding and setting all components and texts
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 10, 10);
		getContentPane().add(panel);
		panel.setLayout(null);
		
		setBounds(100, 100, 800, 501);
		panel.setBackground(new Color(255, 255, 255));
		panel.setLayout(null);
		
		JPanel leftPanel = new JPanel();
		leftPanel.setBounds(0, 0, 501, 472);
		panel.add(leftPanel);
		leftPanel.setLayout(null);
		
		JLabel leftIcon_addCustomer = new JLabel("");
		leftIcon_addCustomer.setVerticalAlignment(SwingConstants.TOP);
		leftIcon_addCustomer.setIcon(new ImageIcon(AddBooking.class.getResource("/gui_icons/EmployeeMenuBackground.png")));
		leftIcon_addCustomer.setBounds(0, 0, 500, 472);
		leftPanel.add(leftIcon_addCustomer);
		
		JPanel rightPanel_addCustomer = new JPanel();
		rightPanel_addCustomer.setBackground(SystemColor.menu);
		rightPanel_addCustomer.setBounds(501, 0, 288, 472);
		panel.add(rightPanel_addCustomer);
		rightPanel_addCustomer.setLayout(null);
		
		JLabel lblCustomerID = new JLabel("Customer ID");
		lblCustomerID.setVerticalAlignment(SwingConstants.TOP);
		lblCustomerID.setFont(new Font("Segoe UI", Font.BOLD, 16));
		lblCustomerID.setBounds(12, 40, 132, 23);
		rightPanel_addCustomer.add(lblCustomerID);
		
		JLabel lblFirstName = new JLabel("First Name");
		lblFirstName.setFont(new Font("Segoe UI", Font.BOLD, 16));
		lblFirstName.setBounds(12, 93, 132, 22);
		rightPanel_addCustomer.add(lblFirstName);
		
		JLabel lblLastName = new JLabel("Last Name");
		lblLastName.setFont(new Font("Segoe UI", Font.BOLD, 16));
		lblLastName.setBounds(12, 145, 132, 22);
		rightPanel_addCustomer.add(lblLastName);
		
		JLabel lblPhoneNumber = new JLabel("Phone Number");
		lblPhoneNumber.setFont(new Font("Segoe UI", Font.BOLD, 16));
		lblPhoneNumber.setBounds(12, 197, 132, 22);
		rightPanel_addCustomer.add(lblPhoneNumber);
		
		JDateChooser dateChooserDateOfJoining = new JDateChooser();
		dateChooserDateOfJoining.setToolTipText("");
		dateChooserDateOfJoining.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 14));
		dateChooserDateOfJoining.setBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(162, 170, 132), new Color(177, 207, 199)));
		dateChooserDateOfJoining.setBounds(160, 331, 118, 29);
		LocalDate today = LocalDate.now();
		Date now = Date.from(today.atStartOfDay(ZoneId.systemDefault()).toInstant());
		
		JLabel lblAddCustomer = new JLabel("Add Customer");
		lblAddCustomer.setBackground(new Color(177, 207, 199));
		lblAddCustomer.setForeground(new Color(255, 255, 255));
		lblAddCustomer.setHorizontalAlignment(SwingConstants.CENTER);
		lblAddCustomer.setFont(new Font("Segoe UI", Font.BOLD, 16));
		lblAddCustomer.setBounds(10, 0, 268, 29);
		rightPanel_addCustomer.add(lblAddCustomer);
		dateChooserDateOfJoining.setMaxSelectableDate(now);
		rightPanel_addCustomer.add(dateChooserDateOfJoining);
		
		JPanel headline = new JPanel();
		headline.setBackground(new Color(162, 170, 132));
		headline.setBounds(0, 0, 290, 29);
		rightPanel_addCustomer.add(headline);
		headline.setLayout(null);
		
		// setting comboxbox options
		JComboBox comboBoxArea = new JComboBox(utils.Area.values());
		comboBoxArea.setBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(162, 170, 132), new Color(177, 207, 199)));
		comboBoxArea.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 14));
		comboBoxArea.setBounds(12, 268, 132, 29);
		rightPanel_addCustomer.add(comboBoxArea);
		
		JTextArea txtID = new JTextArea();
		txtID.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		txtID.setBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(162, 170, 132), new Color(177, 207, 199)));
		txtID.setBounds(10, 60, 134, 22);
		rightPanel_addCustomer.add(txtID);
		
		JTextArea txtFirstName = new JTextArea();
		txtFirstName.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		txtFirstName.setBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(162, 170, 132), new Color(177, 207, 199)));
		txtFirstName.setBounds(10, 114, 134, 22);
		rightPanel_addCustomer.add(txtFirstName);
		
		JTextArea txtLastName = new JTextArea();
		txtLastName.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		txtLastName.setBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(162, 170, 132), new Color(177, 207, 199)));
		txtLastName.setBounds(10, 164, 134, 22);
		rightPanel_addCustomer.add(txtLastName);
		
		JTextArea txtPhoneNum = new JTextArea();
		txtPhoneNum.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		txtPhoneNum.setBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(162, 170, 132), new Color(177, 207, 199)));
		txtPhoneNum.setBounds(12, 219, 134, 22);
		rightPanel_addCustomer.add(txtPhoneNum);
		
		JLabel lblGender = new JLabel("Gender");
		lblGender.setFont(new Font("Segoe UI", Font.BOLD, 16));
		lblGender.setBounds(12, 308, 132, 22);
		rightPanel_addCustomer.add(lblGender);
		
		JLabel lblArea = new JLabel("Area");
		lblArea.setFont(new Font("Segoe UI", Font.BOLD, 16));
		lblArea.setBounds(12, 246, 278, 22);
		rightPanel_addCustomer.add(lblArea);
		
		// setting comboxbox options
		JComboBox comboBoxGender = new JComboBox(utils.Gender.values());
		comboBoxGender.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 14));
		comboBoxGender.setBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(162, 170, 132), new Color(177, 207, 199)));
		comboBoxGender.setBounds(12, 331, 132, 29);
		rightPanel_addCustomer.add(comboBoxGender);
		
		JLabel lblYearOfBirth = new JLabel("Year of Birth");
		lblYearOfBirth.setVerticalAlignment(SwingConstants.TOP);
		lblYearOfBirth.setFont(new Font("Segoe UI", Font.BOLD, 16));
		lblYearOfBirth.setBounds(160, 246, 124, 22);
		rightPanel_addCustomer.add(lblYearOfBirth);
		
		JYearChooser yearChooser = new JYearChooser();
		yearChooser.setMaximum(2023);
		yearChooser.getSpinner().setFont(new Font("Segoe UI", Font.PLAIN, 14));
		yearChooser.setBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(162, 170, 132), new Color(177, 207, 199)));
		yearChooser.setEndYear(2023);
		yearChooser.setBounds(160, 268, 118, 29);
		rightPanel_addCustomer.add(yearChooser);
		
		JLabel lblDateOfJoining = new JLabel("Date of Joining");
		lblDateOfJoining.setFont(new Font("Segoe UI", Font.BOLD, 16));
		lblDateOfJoining.setBounds(158, 308, 132, 22);
		rightPanel_addCustomer.add(lblDateOfJoining);
		
		JLabel lblDiscountPercentage = new JLabel("Discount (%)");
		lblDiscountPercentage.setFont(new Font("Segoe UI", Font.BOLD, 16));
		lblDiscountPercentage.setBounds(158, 183, 132, 22);
		rightPanel_addCustomer.add(lblDiscountPercentage);
		lblDiscountPercentage.setVisible(false);
		
		JLabel lblexampleOfDiscount = new JLabel("For example: 0.1 is 10%");
		lblexampleOfDiscount.setVerticalAlignment(SwingConstants.BOTTOM);
		lblexampleOfDiscount.setForeground(Color.LIGHT_GRAY);
		lblexampleOfDiscount.setFont(new Font("Segoe UI", Font.BOLD, 11));
		lblexampleOfDiscount.setBounds(154, 196, 136, 22);
		rightPanel_addCustomer.add(lblexampleOfDiscount);
		lblexampleOfDiscount.setVisible(false);
		
		JTextArea txtDiscountPercentage = new JTextArea();
		txtDiscountPercentage.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		txtDiscountPercentage.setBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(162, 170, 132), new Color(177, 207, 199)));
		txtDiscountPercentage.setBounds(156, 219, 122, 22);
		rightPanel_addCustomer.add(txtDiscountPercentage);
		txtDiscountPercentage.setVisible(false);
		
		// setting comboxbox options
		JComboBox comboBoxIsVipCustomer = new JComboBox(new String[] {"No", "Yes"});
		comboBoxIsVipCustomer.setBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(162, 170, 132), new Color(177, 207, 199)));
		comboBoxIsVipCustomer.setBounds(160, 60, 118, 23);
		rightPanel_addCustomer.add(comboBoxIsVipCustomer);
		
		JLabel lblIsVip = new JLabel("Is VIP?");
		lblIsVip.setVerticalAlignment(SwingConstants.TOP);
		lblIsVip.setFont(new Font("Segoe UI", Font.BOLD, 16));
		lblIsVip.setBounds(160, 40, 132, 23);
		rightPanel_addCustomer.add(lblIsVip);
		
		JButton btnAddCustomer = new JButton("ADD CUSTOMER");
		btnAddCustomer.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnAddCustomer.setBorderPainted(false);
		btnAddCustomer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) { // in case add customer button was pressed
				if(btnAddCustomer.getText().equals("ADD CUSTOMER")) { // if regular customer
					try {
						if(dateChooserDateOfJoining.getDate() == null) { // if user didn't choose date
								
							}
						else if(txtID.getText().equals("")) { // if user didn't enter customer id
							throw new EmptyException();
						}
						else if(txtFirstName.getText().equals("")) { // if user didn't enter first name
							throw new EmptyException();
						}
						else if(txtLastName.getText().equals("")) { // if user didn't enter last name
							throw new EmptyException();
						}
						else if(txtPhoneNum.getText().equals("")) { // if user didn't enter phone number
							throw new EmptyException();
						}
						else if(!(txtID.getText().matches("\\d+"))){  // if not numbers
							throw new NumbersOnlyException();
						}
						else if(!(txtFirstName.getText().matches("[a-zA-Z]+"))) { // if not letters
							throw new LettersOnlyException();
						}
						else if(!(txtLastName.getText().matches("[a-zA-Z]+"))) { // if not letters
							throw new LettersOnlyException();
						}
						else if(!(txtPhoneNum.getText().matches("\\d+"))) { // if not numbers
							throw new NumbersOnlyException();
						}
						else { // in case user entered everything
							Gender g = (Gender) comboBoxGender.getSelectedItem();
							Area a = (Area) comboBoxArea.getSelectedItem();
							Customer c = new Customer(txtID.getText(), txtFirstName.getText(), txtLastName.getText(), txtPhoneNum.getText(),
										a, g, yearChooser.getValue(), dateChooserDateOfJoining.getDate());
							if(! (Main.hotel.getAllCustomers().containsKey(c.getId()))) {
								try {
									if(Main.hotel.addCustomer(c) == true) { // if customer was added successfully
										JOptionPane.showInternalMessageDialog(null,"Customer successfully added to the hotel!");
									}
									else 
										JOptionPane.showInternalMessageDialog(null,"Customer did *NOT* added to the hotel!");
								} catch (PersonAlreadyExistException e1) { //in case customer already exist
									// TODO Auto-generated catch block
									e1.printStackTrace();
								}
							}
						}
					}
					catch(EmptyException ex) {
						JOptionPane.showInternalMessageDialog(null,ex.getMessage());
					}
					catch(LettersOnlyException exc) {
						JOptionPane.showInternalMessageDialog(null,exc.getMessage());
					}
					catch(NumbersOnlyException exce) {
						JOptionPane.showInternalMessageDialog(null,exce.getMessage());
					}
				}
				else { // if vip customer
					try {
						lblDiscountPercentage.setText("Discount (%)");
						lblDiscountPercentage.setForeground(Color.black);
						lblDiscountPercentage.setFont(new Font("Segoe UI", Font.BOLD, 16));
						discount = Double.parseDouble(txtDiscountPercentage.getText());
						if(discount < 0 || discount > 1) // if discount empty field it sets to zero
							throw new NumberFormatException();
					}
					catch(NumberFormatException ex){ // if user entered not a double
						lblDiscountPercentage.setText("*must be double 0-1*");
						lblDiscountPercentage.setFont(new Font("Segoe UI", Font.BOLD, 10));
						lblDiscountPercentage.setForeground(Color.red);
					}
					if(discount >= 0 && discount <= 1) {
						try {
							if(dateChooserDateOfJoining.getDate() == null) { // if user didn't enter date
								JOptionPane.showMessageDialog(null,"Please enter date of joining");
								}
							else if(txtID.getText().equals("")) { // if user didn't enter vip customer id
								throw new EmptyException();
							}
							else if(txtFirstName.getText().equals("")) { // if user didn't enter first name
								throw new EmptyException();
							}
							else if(txtLastName.getText().equals("")) { // if user didn't enter last name
								throw new EmptyException();
							}
							else if(txtPhoneNum.getText().equals("")) { //if user didn't enter phone number
								throw new EmptyException();
							}
							else if(!(txtID.getText().matches("\\d+"))) { // if not numbers
								throw new NumbersOnlyException();
							}
							else if(!(txtFirstName.getText().matches("[a-zA-Z]+"))) { // if not letters
								throw new LettersOnlyException();
							}
							else if(!(txtLastName.getText().matches("[a-zA-Z]+"))) { // if not letters
								throw new LettersOnlyException();
							}
							else if(!(txtPhoneNum.getText().matches("\\d+"))) { // if not numbers
								throw new NumbersOnlyException();
							}
							else { // in case user entered everything
								Gender g = (Gender) comboBoxGender.getSelectedItem();
								Area a = (Area) comboBoxArea.getSelectedItem();
								VIPCustomer VIPc = new VIPCustomer(txtID.getText(), txtFirstName.getText(), txtLastName.getText(),
										txtPhoneNum.getText(),a, g, yearChooser.getValue(), dateChooserDateOfJoining.getDate(), discount);
								if(! (Main.hotel.getAllCustomers().containsKey(VIPc.getId()))) {
									try {
										if(Main.hotel.addVIPCustomer(VIPc) == true) { // if vip customer was added successfully
											JOptionPane.showInternalMessageDialog(null,"VIP Customer successfully added to the hotel!");
										}
										else
											JOptionPane.showInternalMessageDialog(null,"VIP Customer did *NOT* added to the hotel!");
									} catch (PersonAlreadyExistException e1) { //in case vip customer already exist
										// TODO Auto-generated catch block
										e1.printStackTrace();
									}
								}
							}
						}
						catch(EmptyException ex) {
							JOptionPane.showInternalMessageDialog(null,ex.getMessage());
						}
						catch(LettersOnlyException exc) {
							JOptionPane.showInternalMessageDialog(null,exc.getMessage());
						}
						catch(NumbersOnlyException exce) {
							JOptionPane.showInternalMessageDialog(null,exce.getMessage());
						}
					}
				}
			}
		});
		btnAddCustomer.setFont(new Font("Segoe UI", Font.BOLD, 18));
		btnAddCustomer.setBackground(new Color(162, 170, 132));
		btnAddCustomer.setBounds(10, 388, 268, 73);
		btnAddCustomer.setFocusable(false);
		rightPanel_addCustomer.add(btnAddCustomer);
		
		// if user marked vip customer box then show discount component and all relevant components and texts
		comboBoxIsVipCustomer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String yesNo = String.valueOf(comboBoxIsVipCustomer.getSelectedItem());
				if(yesNo.equals("Yes")) {
					lblDiscountPercentage.setVisible(true);
					lblexampleOfDiscount.setVisible(true);
					txtDiscountPercentage.setVisible(true);
					lblAddCustomer.setText("Add VIP Customer");
					btnAddCustomer.setText("ADD VIP CUSTOMER");
				}
				else {
					lblDiscountPercentage.setVisible(false);
					lblexampleOfDiscount.setVisible(false);
					txtDiscountPercentage.setVisible(false);
					lblAddCustomer.setText("Add Customer");
					btnAddCustomer.setText("ADD CUSTOMER");
				}
			}
		});
	}

}
