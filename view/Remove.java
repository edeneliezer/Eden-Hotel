// @author Eden Eliezer ID 207188038
package view;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EtchedBorder;
import javax.swing.border.LineBorder;

import model.Booking;
import model.Customer;
import model.Department;
import model.DepartmentManager;
import model.Employee;
import model.Room;
import model.StandardRoom;
import model.Suite;
import model.SuperiorRoom;
import model.VIPCustomer;


public class Remove extends JInternalFrame {

	JPanel panelBtns2; // buttons only for admin
	Object[] s;
	JComboBox comboBox;
	JButton btnRemove;
	int i = 0; // a flag in order to acknowledge which button was pressed
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Remove frame = new Remove();
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
	public Remove() {
		
		// adding and setting all components and texts
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 790, 472);
		getContentPane().add(panel);
		panel.setLayout(null);
		
		panel.setBackground(new Color(255, 255, 255));
		panel.setLayout(null);
		
		JPanel panelBtns = new JPanel();
		panelBtns.setLayout(null);
		panelBtns.setBackground(new Color(202, 147, 152));
		panelBtns.setBounds(0, 0, 140, 472);
		panel.add(panelBtns);
		
		panelBtns2 = new JPanel();
		panelBtns2.setBackground(new Color(202, 147, 152));
		panelBtns2.setBounds(138, 0, 282, 68);
		panel.add(panelBtns2);
		panelBtns2.setLayout(null);
		panelBtns2.setVisible(false); // default: not visible
		
		JPanel leftPanel = new JPanel();
		leftPanel.setBackground(new Color(242, 227, 231));
		leftPanel.setBounds(0, 0, 420, 472);
		panel.add(leftPanel);
		
		JPanel rightPanel_remove = new JPanel();
		rightPanel_remove.setBorder(new LineBorder(new Color(202, 147, 152), 2));
		rightPanel_remove.setBackground(new Color(242, 227, 231));
		rightPanel_remove.setBounds(419, 0, 370, 472);
		panel.add(rightPanel_remove);
		rightPanel_remove.setLayout(null);
		
		// main frame text
		JLabel lblPlease = new JLabel(" What would you like to remove?");
		lblPlease.setHorizontalAlignment(SwingConstants.CENTER);
		lblPlease.setFont(new Font("Segoe UI", Font.BOLD, 18));
		lblPlease.setBounds(10, 149, 350, 35);
		rightPanel_remove.add(lblPlease);

		// main frame text
		JLabel lblRemove = new JLabel("What would you like to remove?");
		lblRemove.setBackground(new Color(177, 207, 199));
		lblRemove.setForeground(new Color(255, 255, 255));
		lblRemove.setHorizontalAlignment(SwingConstants.CENTER);
		lblRemove.setFont(new Font("Segoe UI", Font.BOLD, 16));
		lblRemove.setBounds(0, 0, 370, 67);
		rightPanel_remove.add(lblRemove);
		
		JPanel headline = new JPanel();
		headline.setBackground(new Color(202, 147, 152));
		headline.setBounds(0, 0, 370, 68);
		rightPanel_remove.add(headline);
		headline.setLayout(null);
		
		// main frame text
		JLabel lblToRemove = new JLabel("");
		lblToRemove.setFont(new Font("Segoe UI", Font.BOLD, 18));
		lblToRemove.setHorizontalAlignment(SwingConstants.CENTER);
		lblToRemove.setBounds(10, 177, 350, 21);
		rightPanel_remove.add(lblToRemove);
		
		comboBox = new JComboBox();
		comboBox.setBorder(new LineBorder(new Color(202, 147, 152), 2));
		comboBox.setBounds(43, 228, 283, 41);
		rightPanel_remove.add(comboBox);
		comboBox.setVisible(false);
		
		JLabel lblFrame = new JLabel("");
		lblFrame.setOpaque(true);
		lblFrame.setBackground(new Color(238, 219, 224));
		lblFrame.setBorder(new CompoundBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(202, 147, 152), new Color(255, 255, 255)), new LineBorder(new Color(202, 147, 152), 2)));
		lblFrame.setBounds(8, 126, 355, 188);
		rightPanel_remove.add(lblFrame);
		
		//change to the relevant text, make components visible
		//show a message if there are no objects in combobox
		JButton btnEmployee = new JButton("Employee");
		btnEmployee.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				i=8;
				comboBox.removeAllItems();
				lblRemove.setText("Remove Employee");
				lblPlease.setText("Please choose employee ID");
				lblToRemove.setVisible(true);
				comboBox.setVisible(true);
				s = Main.hotel.getAllEmployees().keySet().toArray();
				for(int j = 0; j< s.length ; j++) {
					comboBox.addItem(s[j]);
				}
				if(s.length == 0) {
					lblPlease.setText("There are no employees in the system");
					lblToRemove.setVisible(false);
					btnRemove.setVisible(false);
				}
				else
					btnRemove.setVisible(true);
			}
		});
		btnEmployee.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnEmployee.setPreferredSize(new Dimension(90, 20));
		btnEmployee.setMinimumSize(new Dimension(89, 20));
		btnEmployee.setMaximumSize(new Dimension(89, 20));
		btnEmployee.setMargin(new Insets(2, 10, 2, 10));
		btnEmployee.setFont(new Font("Segoe UI Black", Font.PLAIN, 14));
		btnEmployee.setFocusable(false);
		btnEmployee.setBackground(new Color(202, 147, 152));
		btnEmployee.setBounds(1, 1, 140, 67);
		panelBtns2.add(btnEmployee);
		
		//change to the relevant text, make components visible
		//show a message if there are no objects in combobox
		JButton btnDepManager = new JButton("Dep Manager");
		btnDepManager.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				i=9;
				comboBox.removeAllItems();
				lblRemove.setText("Remove Department Manager");
				lblPlease.setText("Please choose dep manager ID");
				lblToRemove.setVisible(true);
				comboBox.setVisible(true);
				// adding to combobox only dep manager related
				for(Employee dm : Main.hotel.getAllEmployees().values()){
					if(dm instanceof DepartmentManager) {
						comboBox.addItem(dm.getId());
					}
				}
				if(comboBox.getItemCount() == 0) {
					lblPlease.setText("There are no dep managers in system");
					lblToRemove.setVisible(false);
					btnRemove.setVisible(false);
				}
				else
					btnRemove.setVisible(true);
			}
		});
		btnDepManager.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnDepManager.setPreferredSize(new Dimension(90, 20));
		btnDepManager.setMinimumSize(new Dimension(89, 20));
		btnDepManager.setMaximumSize(new Dimension(89, 20));
		btnDepManager.setMargin(new Insets(2, 2, 2, 2));
		btnDepManager.setFont(new Font("Segoe UI Black", Font.PLAIN, 14));
		btnDepManager.setFocusable(false);
		btnDepManager.setBackground(new Color(202, 147, 152));
		btnDepManager.setBounds(141, 1, 140, 67);
		panelBtns2.add(btnDepManager);
		
		//change to the relevant text, make components visible
		//show a message if there are no objects in combobox
		JButton btnCustomer = new JButton("Customer");
		btnCustomer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				i=3;
				comboBox.removeAllItems();
				lblRemove.setText("Remove Customer");
				lblPlease.setText("Please choose customer ID");
				lblToRemove.setVisible(true);
				comboBox.setVisible(true);
				s = Main.hotel.getAllCustomers().keySet().toArray();
				for(int j = 0; j< s.length ; j++) {
					comboBox.addItem(s[j]);
				}
				if(s.length == 0) {
					lblPlease.setText("There are no customers in the system");
					lblToRemove.setVisible(false);
					btnRemove.setVisible(false);
				}
				else
					btnRemove.setVisible(true);
			}
		});
		btnCustomer.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnCustomer.setBackground(new Color(202, 147, 152));
		btnCustomer.setSize(new Dimension(90, 40));
		btnCustomer.setPreferredSize(new Dimension(90, 20));
		btnCustomer.setMinimumSize(new Dimension(89, 20));
		btnCustomer.setMaximumSize(new Dimension(89, 20));
		btnCustomer.setMargin(new Insets(2, 10, 2, 10));
		btnCustomer.setFont(new Font("Segoe UI Black", Font.PLAIN, 14));
		btnCustomer.setFocusable(false);
		btnCustomer.setBounds(0, 135, 140, 67);
		panelBtns.add(btnCustomer);
		
		//change to the relevant text, make components visible
		//show a message if there are no objects in combobox
		JButton btnSuperiorRoom = new JButton("Superior Room");
		btnSuperiorRoom.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				i=6;
				comboBox.removeAllItems();
				lblRemove.setText("Remove Superior Room");
				lblPlease.setText("Please choose superior room number");
				lblToRemove.setVisible(true);
				comboBox.setVisible(true);
				// adding to combobox only superior room related
				for(Room s : Main.hotel.getAllRooms().values()){
					if(s instanceof SuperiorRoom) {
						comboBox.addItem(s.getRoomNumber());
					}
				}
				if(comboBox.getItemCount() == 0) {
					lblPlease.setText("There are no superior rooms in the system");
					lblToRemove.setVisible(false);
					btnRemove.setVisible(false);
				}
				else
					btnRemove.setVisible(true);
			}
		});
		btnSuperiorRoom.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnSuperiorRoom.setBackground(new Color(202, 147, 152));
		btnSuperiorRoom.setPreferredSize(new Dimension(90, 20));
		btnSuperiorRoom.setMinimumSize(new Dimension(89, 20));
		btnSuperiorRoom.setMaximumSize(new Dimension(89, 20));
		btnSuperiorRoom.setMargin(new Insets(2, 10, 2, 10));
		btnSuperiorRoom.setFont(new Font("Segoe UI Black", Font.PLAIN, 14));
		btnSuperiorRoom.setFocusable(false);
		btnSuperiorRoom.setBounds(0, 336, 140, 67);
		panelBtns.add(btnSuperiorRoom);
		
		//change to the relevant text, make components visible
		//show a message if there are no objects in combobox
		JButton btnDepartment = new JButton("Department");
		btnDepartment.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				i=1;
				comboBox.removeAllItems();
				lblRemove.setText("Remove Department");
				lblPlease.setText("Please choose department ID");
				lblToRemove.setVisible(true);
				comboBox.setVisible(true);
				s = Main.hotel.getAllDepartments().keySet().toArray();
				for(int j = 0; j< s.length ; j++) {
					comboBox.addItem(s[j]);
				}
				if(s.length == 0) {
					lblPlease.setText("There are no departments in the system");
					lblToRemove.setVisible(false);
					btnRemove.setVisible(false);
				}
				else
					btnRemove.setVisible(true);
			}
		});
		btnDepartment.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnDepartment.setBackground(new Color(202, 147, 152));
		btnDepartment.setPreferredSize(new Dimension(90, 20));
		btnDepartment.setMinimumSize(new Dimension(89, 20));
		btnDepartment.setMaximumSize(new Dimension(89, 20));
		btnDepartment.setMargin(new Insets(2, 10, 2, 10));
		btnDepartment.setFont(new Font("Segoe UI Black", Font.PLAIN, 14));
		btnDepartment.setFocusable(false);
		btnDepartment.setBounds(0, 1, 140, 67);
		panelBtns.add(btnDepartment);
		
		//change to the relevant text, make components visible
		//show a message if there are no objects in combobox
		JButton btnVipCustomer = new JButton("VIP Customer");
		btnVipCustomer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				i=4;
				comboBox.removeAllItems();
				lblRemove.setText("Remove VIP Customer");
				lblPlease.setText("Please choose VIP customer ID");
				lblToRemove.setVisible(true);
				comboBox.setVisible(true);
				// adding to combobox only vip customer related
				for(Customer c : Main.hotel.getAllCustomers().values()){
					if(c instanceof VIPCustomer) {
						comboBox.addItem(c.getId());
					}
				}
				if(comboBox.getItemCount() == 0) {
					lblPlease.setText("There are no VIP customers in the system");
					lblToRemove.setVisible(false);
					btnRemove.setVisible(false);
				}
				else
					btnRemove.setVisible(true);
			}
		});
		btnVipCustomer.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnVipCustomer.setBackground(new Color(202, 147, 152));
		btnVipCustomer.setPreferredSize(new Dimension(90, 20));
		btnVipCustomer.setMinimumSize(new Dimension(89, 20));
		btnVipCustomer.setMaximumSize(new Dimension(89, 20));
		btnVipCustomer.setMargin(new Insets(2, 10, 2, 10));
		btnVipCustomer.setFont(new Font("Segoe UI Black", Font.PLAIN, 14));
		btnVipCustomer.setFocusable(false);
		btnVipCustomer.setBounds(0, 202, 140, 67);
		panelBtns.add(btnVipCustomer);
		
		//change to the relevant text, make components visible
		//show a message if there are no objects in combobox
		JButton btnSuite = new JButton("Suite");
		btnSuite.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				i=7;
				comboBox.removeAllItems();
				lblRemove.setText("Remove Suite");
				lblPlease.setText("Please choose suite number");
				lblToRemove.setVisible(true);
				comboBox.setVisible(true);
				// adding to combobox only suite related
				for(Room s : Main.hotel.getAllRooms().values()){
					if(s instanceof Suite) {
						comboBox.addItem(s.getRoomNumber());
					}
				}
				if(comboBox.getItemCount() == 0) {
					lblPlease.setText("There are no suites in the system");
					lblToRemove.setVisible(false);
					btnRemove.setVisible(false);
				}
				else
					btnRemove.setVisible(true);
			}
		});
		btnSuite.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnSuite.setBackground(new Color(202, 147, 152));
		btnSuite.setPreferredSize(new Dimension(90, 20));
		btnSuite.setMinimumSize(new Dimension(89, 20));
		btnSuite.setMaximumSize(new Dimension(89, 20));
		btnSuite.setMargin(new Insets(2, 10, 2, 10));
		btnSuite.setFont(new Font("Segoe UI Black", Font.PLAIN, 14));
		btnSuite.setFocusable(false);
		btnSuite.setBounds(0, 403, 140, 67);
		panelBtns.add(btnSuite);
		
		//change to the relevant text, make components visible
		//show a message if there are no objects in combobox
		JButton btnBooking = new JButton("Booking");
		btnBooking.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				i=2;
				comboBox.removeAllItems();
				lblRemove.setText("Remove Booking");
				lblPlease.setText("Please choose booking number");
				lblToRemove.setVisible(true);
				comboBox.setVisible(true);
				s = Main.hotel.getAllBookings().keySet().toArray();
				for(int j = 0; j< s.length ; j++) {
					comboBox.addItem(s[j]);
				}
				if(s.length == 0) {
					lblPlease.setText("There are no bookings in the system");
					lblToRemove.setVisible(false);
					btnRemove.setVisible(false);
				}
				else
					btnRemove.setVisible(true);
			}
		});
		btnBooking.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnBooking.setBackground(new Color(202, 147, 152));
		btnBooking.setPreferredSize(new Dimension(90, 20));
		btnBooking.setMinimumSize(new Dimension(89, 20));
		btnBooking.setMaximumSize(new Dimension(89, 20));
		btnBooking.setMargin(new Insets(2, 10, 2, 10));
		btnBooking.setFont(new Font("Segoe UI Black", Font.PLAIN, 14));
		btnBooking.setFocusable(false);
		btnBooking.setBounds(0, 68, 140, 67);
		panelBtns.add(btnBooking);
		
		//change to the relevant text, make components visible
		//show a message if there are no objects in combobox
		JButton btnStandardRoom = new JButton("Standard Room");
		btnStandardRoom.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				i=5;
				comboBox.removeAllItems();
				lblRemove.setText("Remove Standard Room");
				lblPlease.setText("Please choose standard room number");
				lblToRemove.setVisible(true);
				comboBox.setVisible(true);
				// adding to combobox only standard room related
				for(Room s : Main.hotel.getAllRooms().values()){
					if(s instanceof StandardRoom) {
						comboBox.addItem(s.getRoomNumber());
					}
				}
				if(comboBox.getItemCount() == 0) {
					lblPlease.setText("There are no standard rooms in the system");
					lblToRemove.setVisible(false);
					btnRemove.setVisible(false);
				}
				else
					btnRemove.setVisible(true);
			}
		});
		btnStandardRoom.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnStandardRoom.setBackground(new Color(202, 147, 152));
		btnStandardRoom.setPreferredSize(new Dimension(90, 20));
		btnStandardRoom.setMinimumSize(new Dimension(89, 20));
		btnStandardRoom.setMaximumSize(new Dimension(89, 20));
		btnStandardRoom.setMargin(new Insets(2, 10, 2, 10));
		btnStandardRoom.setFont(new Font("Segoe UI Black", Font.PLAIN, 14));
		btnStandardRoom.setFocusable(false);
		btnStandardRoom.setBounds(0, 269, 140, 67);
		panelBtns.add(btnStandardRoom);
		
		btnRemove = new JButton("REMOVE");
		btnRemove.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnRemove.setBorderPainted(false);
		btnRemove.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {	
				switch(i) {
					case(1):{ // pressed department
						// making sure by pop up message
						if(JOptionPane.showInternalConfirmDialog(null,"Are you sure?, this action cannot be undone.", "", JOptionPane.YES_NO_OPTION) == 0) {
							Department d = Main.hotel.getRealDepartment(String.valueOf(comboBox.getSelectedItem())); 
							if(Main.hotel.removeDepartment(d) == true) { // removing
								// success message	
								JOptionPane.showInternalMessageDialog(null,"Department successfully removed from the hotel!");
								}
							else // failure message
								JOptionPane.showInternalMessageDialog(null,"Department did *NOT* removed from the hotel!");
						}
						break;
					}
					case(2):{ // pressed booking
						// making sure by pop up message
						if(JOptionPane.showInternalConfirmDialog(null,"Are you sure?, this action cannot be undone.", "", JOptionPane.YES_NO_OPTION) == 0) {
							Booking b = Main.hotel.getRealBooking(String.valueOf(comboBox.getSelectedItem())); 
							if(Main.hotel.removeBooking(b) == true) { // removing
								// success message	
								JOptionPane.showInternalMessageDialog(null,"Booking successfully removed from the hotel!");
								}
							else // failure message
								JOptionPane.showInternalMessageDialog(null,"Booking did *NOT* removed from the hotel!");
						}
						break;
					}
					case(3):{ // pressed customer
						// making sure by pop up message
						if(JOptionPane.showInternalConfirmDialog(null,"Are you sure?, this action cannot be undone.", "", JOptionPane.YES_NO_OPTION) == 0) {
							Customer c = Main.hotel.getRealCustomer(String.valueOf(comboBox.getSelectedItem())); 
							if(Main.hotel.removeCustomer(c) == true) { // removing
								// success message
									JOptionPane.showInternalMessageDialog(null,"Customer successfully removed from the hotel!");
								}
							else // failure message
								JOptionPane.showInternalMessageDialog(null,"Customer did *NOT* removed from the hotel!");
						}
						break;
					}
					case(4):{ // pressed vip customer
						// making sure by pop up message
						if(JOptionPane.showInternalConfirmDialog(null,"Are you sure?, this action cannot be undone.", "", JOptionPane.YES_NO_OPTION) == 0) {
							VIPCustomer vipc = Main.hotel.getRealVIPCustomer(String.valueOf(comboBox.getSelectedItem())); 
							if(Main.hotel.removeVIPCustomer(vipc) == true) { // removing
								// success message
									JOptionPane.showInternalMessageDialog(null,"VIP Customer successfully removed from the hotel!");
								}
							else // failure message
								JOptionPane.showInternalMessageDialog(null,"VIP Customer did *NOT* removed from the hotel!");
						}
						break;				
					}
					case(5):{ // pressed standard room
						// making sure by pop up message
						if(JOptionPane.showInternalConfirmDialog(null,"Are you sure?, this action cannot be undone.", "", JOptionPane.YES_NO_OPTION) == 0) {
							StandardRoom s = Main.hotel.getRealStandardRoom(String.valueOf(comboBox.getSelectedItem())); 
							if(Main.hotel.removeStandardRoom(s) == true) { // removing
								// success message
									JOptionPane.showInternalMessageDialog(null,"Standard Room successfully removed from the hotel!");
								}
							else // failure message
								JOptionPane.showInternalMessageDialog(null,"Standard Room did *NOT* removed from the hotel!");
						}
						break;
					}
					case(6):{ // pressed superior room
						// making sure by pop up message
						if(JOptionPane.showInternalConfirmDialog(null,"Are you sure?, this action cannot be undone.", "", JOptionPane.YES_NO_OPTION) == 0) {
							SuperiorRoom s = Main.hotel.getRealSuperiorRoom(String.valueOf(comboBox.getSelectedItem())); 
							if(Main.hotel.removeSuperiorRoom(s) == true) { // removing
								// success message
									JOptionPane.showInternalMessageDialog(null,"Superior Room successfully removed from the hotel!");
								}
							else // failure message
								JOptionPane.showInternalMessageDialog(null,"Superior Room did *NOT* removed from the hotel!");
						}
						break;
					}
					case(7):{ // pressed suite
						// making sure by pop up message
						if(JOptionPane.showInternalConfirmDialog(null,"Are you sure?, this action cannot be undone.", "", JOptionPane.YES_NO_OPTION) == 0) {
							Suite s = Main.hotel.getRealSuite(String.valueOf(comboBox.getSelectedItem())); 
							if(Main.hotel.removeSuite(s) == true) { // removing
								// success message
									JOptionPane.showInternalMessageDialog(null,"Suite successfully removed from the hotel!");
								}
							else // failure message
								JOptionPane.showInternalMessageDialog(null,"Suite did *NOT* removed from the hotel!");
						}
						break;
					}
					case(8):{ // pressed employee
						// making sure by pop up message
						if(JOptionPane.showInternalConfirmDialog(null,"Are you sure?, this action cannot be undone.", "", JOptionPane.YES_NO_OPTION) == 0) {
							Employee emp = Main.hotel.getRealEmployee(String.valueOf(comboBox.getSelectedItem())); 
							if(Main.hotel.removeEmployee(emp) == true) { // removing
								// success message
									JOptionPane.showInternalMessageDialog(null,"Employee successfully removed from the hotel!");
									AddEmployee.security.remove(emp.getUsername()); // removing from 'username and password' list
								}
							else // failure message
								JOptionPane.showInternalMessageDialog(null,"Employee did *NOT* removed from the hotel!");
						}
						break;
					}
					case(9):{ // pressed dep manager
						// making sure by pop up message
						if(JOptionPane.showInternalConfirmDialog(null,"Are you sure?, this action cannot be undone.", "", JOptionPane.YES_NO_OPTION) == 0) {
							DepartmentManager dm = Main.hotel.getRealDepartmentManager(String.valueOf(comboBox.getSelectedItem())); 
							if(Main.hotel.removeDepartmentManager(dm) == true) { // removing
								// success message
									JOptionPane.showInternalMessageDialog(null,"Department Manager successfully removed from the hotel!");
									AddEmployee.security.remove(dm.getUsername()); // removing from 'username and password' list
								}
							else // failure message
								JOptionPane.showInternalMessageDialog(null,"Department Manager did *NOT* removed from the hotel!");
						}
						break;
					}

				}
			}
		});
		btnRemove.setFont(new Font("Segoe UI", Font.BOLD, 18));
		btnRemove.setBackground(new Color(202, 147, 152));
		btnRemove.setBounds(10, 388, 350, 73);
		btnRemove.setFocusable(false);
		rightPanel_remove.add(btnRemove);
		btnRemove.setVisible(false);
		
		
	}

}
