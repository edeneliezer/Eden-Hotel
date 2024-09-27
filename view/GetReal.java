// @author Eden Eliezer ID 207188038
package view;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Insets;
import java.awt.Point;
import java.awt.Rectangle;
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
import javax.swing.JScrollPane;
import javax.swing.JTextPane;
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

public class GetReal extends JInternalFrame {

	JComboBox comboBox;
	Object[] s;
	int i = 0; // a flag in order to realize which button was pressed
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GetReal frame = new GetReal();
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
	public GetReal() {
		
		// adding and setting all components and texts
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(207, 227, 243));
		panel.setBounds(0, 0, 790, 472);
		getContentPane().add(panel);
		panel.setLayout(null);
		
		panel.setBackground(new Color(255, 255, 255));
		panel.setLayout(null);
		
		JPanel panelBtns = new JPanel();
		panelBtns.setBackground(new Color(164, 208, 227));
		panelBtns.setBounds(0, 0, 178, 472);
		panel.add(panelBtns);
		panelBtns.setLayout(null);
		
		JPanel leftPanel = new JPanel();
		leftPanel.setBackground(new Color(207, 227, 243));
		leftPanel.setBounds(0, 0, 420, 471);
		panel.add(leftPanel);
		
		JPanel rightPanel_search = new JPanel();
		rightPanel_search.setBorder(new LineBorder(new Color(164, 208, 227), 2));
		rightPanel_search.setBackground(new Color(207, 227, 243));
		rightPanel_search.setBounds(420, 0, 370, 472);
		panel.add(rightPanel_search);
		rightPanel_search.setLayout(null);
		
		// main frame text
		JLabel lblPlease = new JLabel("What would you like to search?");
		lblPlease.setHorizontalAlignment(SwingConstants.CENTER);
		lblPlease.setFont(new Font("Segoe UI", Font.BOLD, 16));
		lblPlease.setBounds(10, 142, 360, 35);
		rightPanel_search.add(lblPlease);
		
		// main frame text
		JLabel lblSearch = new JLabel("What would you like to Search?");
		lblSearch.setBackground(new Color(164, 208, 227));
		lblSearch.setForeground(new Color(255, 255, 255));
		lblSearch.setHorizontalAlignment(SwingConstants.CENTER);
		lblSearch.setFont(new Font("Segoe UI", Font.BOLD, 16));
		lblSearch.setBounds(10, 0, 360, 29);
		rightPanel_search.add(lblSearch);
		
		JPanel headline = new JPanel();
		headline.setBackground(new Color(164, 208, 227));
		headline.setBounds(0, 0, 370, 29);
		rightPanel_search.add(headline);
		headline.setLayout(null);
		
		JTextPane textPaneToString = new JTextPane();
		textPaneToString.setBounds(new Rectangle(5, 5, 0, 0));
		textPaneToString.setLocation(new Point(5, 5));
		textPaneToString.setMargin(new Insets(5, 15, 5, 5));
		textPaneToString.setEditable(false);
		textPaneToString.setBorder(new LineBorder(new Color(255, 255, 255), 2));
		textPaneToString.setBackground(new Color(164, 208, 227));
		textPaneToString.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 14));
		textPaneToString.setBounds(15, 228, 345, 120);
		rightPanel_search.add(textPaneToString);
		
		comboBox = new JComboBox();
		comboBox.setBorder(new LineBorder(new Color(164, 208, 227), 2));
		comboBox.setBounds(20, 188, 272, 29);
		rightPanel_search.add(comboBox);
		comboBox.setVisible(false);
		
		JButton btnSearch = new JButton("SEARCH");
		btnSearch.setMargin(new Insets(1, 1, 1, 1));
		btnSearch.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnSearch.setBorderPainted(false);
		btnSearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {	
				switch(i) {
					case(1):{ // pressed department
						Department d = Main.hotel.getRealDepartment(String.valueOf(comboBox.getSelectedItem()));
						if(d != null) {
							textPaneToString.setText(d.toString());
						}
						break;
					}
					case(2):{ // pressed booking
						Booking b = Main.hotel.getRealBooking(String.valueOf(comboBox.getSelectedItem()));
						if(b != null) {
							textPaneToString.setText(b.toString());
						}
						break;
					}
					case(3):{ // pressed customer
						Customer c = Main.hotel.getRealCustomer(String.valueOf(comboBox.getSelectedItem()));
						if(c != null) {
							textPaneToString.setText(c.toString());
						}
						break;
					}
					case(4):{ // pressed vip customer
						VIPCustomer vipc = Main.hotel.getRealVIPCustomer(String.valueOf(comboBox.getSelectedItem()));
						if(vipc != null) {
							textPaneToString.setText(vipc.toString());
						}
						break;
					}
					case(5):{ // pressed employee
						Employee emp = Main.hotel.getRealEmployee(String.valueOf(comboBox.getSelectedItem()));
						if(emp != null) {
							textPaneToString.setText(emp.toString());
						}
						break;
					}
					case(6):{ // pressed dep manager
						DepartmentManager dm = Main.hotel.getRealDepartmentManager(String.valueOf(comboBox.getSelectedItem()));
						if(dm != null) {
							textPaneToString.setText(dm.toString());
						}
						break;
					}
					case(7):{ // pressed standard room
						StandardRoom s = Main.hotel.getRealStandardRoom(String.valueOf(comboBox.getSelectedItem()));
						if(s != null) {
							textPaneToString.setText(s.toString());
						}
						break;
					}
					case(8):{ // pressed superior room
						SuperiorRoom s = Main.hotel.getRealSuperiorRoom(String.valueOf(comboBox.getSelectedItem()));
						if(s != null) {
							textPaneToString.setText(s.toString());
						}
						break;
					}
					case(9):{ // pressed suite
						Suite s = Main.hotel.getRealSuite(String.valueOf(comboBox.getSelectedItem()));
						if(s != null) {
							textPaneToString.setText(s.toString());
						}
						break;
					}
				}
			}
		});
		btnSearch.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 12));
		btnSearch.setBackground(new Color(164, 208, 227));
		btnSearch.setBounds(300, 188, 55, 29);
		btnSearch.setFocusable(false);
		rightPanel_search.add(btnSearch);
		btnSearch.setVisible(false);
		
		// main frame text
		JLabel lblFrame = new JLabel("");
		lblFrame.setOpaque(true);
		lblFrame.setBackground(new Color(207, 227, 243));
		lblFrame.setBorder(new CompoundBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(164, 208, 227), new Color(207, 227, 243)), new LineBorder(new Color(164, 208, 227), 2)));
		lblFrame.setBounds(5, 126, 365, 247);
		rightPanel_search.add(lblFrame);
		
		//change to the relevant text, make components visible
		//show a message if there are no objects in combobox
		JButton btnDepartment = new JButton("Department");
		btnDepartment.setFocusable(false);
		btnDepartment.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnDepartment.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				i = 1;
				comboBox.removeAllItems();
				lblSearch.setText("Search Department"); 
				lblPlease.setText(" Please choose department ID ");
				comboBox.setVisible(true);
				btnSearch.setVisible(true);
				s = Main.hotel.getAllDepartments().keySet().toArray();  // setting combobox items
				for(int j = 0; j< s.length ; j++) {
					comboBox.addItem(s[j]);
				}
				textPaneToString.setText("");
				if(s.length == 0) // if no items
					textPaneToString.setText("There are no departments in the system");
			}
		});
		btnDepartment.setMargin(new Insets(2, 10, 2, 10));
		btnDepartment.setFont(new Font("Segoe UI Black", Font.PLAIN, 14));
		btnDepartment.setMaximumSize(new Dimension(89, 20));
		btnDepartment.setMinimumSize(new Dimension(89, 20));
		btnDepartment.setPreferredSize(new Dimension(90, 20));
		btnDepartment.setBounds(0, 0, 178, 52);
		panelBtns.add(btnDepartment);
		
		//change to the relevant text, make components visible
		//show a message if there are no objects in combobox
		JButton btnBooking = new JButton("Booking");
		btnBooking.setFocusable(false);
		btnBooking.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnBooking.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				i = 2;
				comboBox.removeAllItems();
				lblSearch.setText("Search Booking");
				lblPlease.setText(" Please choose booking number ");
				comboBox.setVisible(true);
				btnSearch.setVisible(true);
				s = Main.hotel.getAllBookings().keySet().toArray(); // setting combobox items
				for(int j = 0; j< s.length ; j++) {
					comboBox.addItem(s[j]);
				}
				textPaneToString.setText("");
				if(s.length == 0) // if no items
					textPaneToString.setText("There are no bookings in the system");
			}
		});
		btnBooking.setMargin(new Insets(2, 10, 2, 10));
		btnBooking.setFont(new Font("Segoe UI Black", Font.PLAIN, 14));
		btnBooking.setMaximumSize(new Dimension(89, 20));
		btnBooking.setMinimumSize(new Dimension(89, 20));
		btnBooking.setPreferredSize(new Dimension(90, 20));
		btnBooking.setBounds(0, 52, 178, 52);
		panelBtns.add(btnBooking);
		
		//change to the relevant text, make components visible
		//show a message if there are no objects in combobox
		JButton btnCustomer = new JButton("Customer");
		btnCustomer.setFocusable(false);
		btnCustomer.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnCustomer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				i = 3;
				comboBox.removeAllItems();
				lblSearch.setText("Search Customer");
				lblPlease.setText(" Please choose customer ID ");
				comboBox.setVisible(true);
				btnSearch.setVisible(true);
				s = Main.hotel.getAllCustomers().keySet().toArray(); // setting combobox items
				for(int j = 0; j< s.length ; j++) {
					comboBox.addItem(s[j]);
				}
				textPaneToString.setText("");
				if(s.length == 0) // if no items
					textPaneToString.setText("There are no customers in the system");
			}
		});
		btnCustomer.setMargin(new Insets(2, 10, 2, 10));
		btnCustomer.setFont(new Font("Segoe UI Black", Font.PLAIN, 14));
		btnCustomer.setSize(new Dimension(90, 40));
		btnCustomer.setMaximumSize(new Dimension(89, 20));
		btnCustomer.setMinimumSize(new Dimension(89, 20));
		btnCustomer.setPreferredSize(new Dimension(90, 20));
		btnCustomer.setBounds(0, 104, 178, 52);
		panelBtns.add(btnCustomer);
		
		//change to the relevant text, make components visible
		//show a message if there are no objects in combobox
		JButton btnVipCustomer = new JButton("VIP Customer");
		btnVipCustomer.setFocusable(false);
		btnVipCustomer.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnVipCustomer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				i = 4;
				comboBox.removeAllItems();
				lblSearch.setText("Search VIP Customer");
				lblPlease.setText(" Please choose VIP customer ID ");
				comboBox.setVisible(true);
				btnSearch.setVisible(true);
				for(Customer c : Main.hotel.getAllCustomers().values()){
					if(c instanceof VIPCustomer) { // setting combobox items
						comboBox.addItem(c.getId());
					}
				}
				textPaneToString.setText("");
				if(comboBox.getItemCount() == 0)  // if no items
					textPaneToString.setText("There are no VIP customers in the system");
			}
		});
		btnVipCustomer.setMargin(new Insets(2, 10, 2, 10));
		btnVipCustomer.setFont(new Font("Segoe UI Black", Font.PLAIN, 14));
		btnVipCustomer.setMaximumSize(new Dimension(89, 20));
		btnVipCustomer.setMinimumSize(new Dimension(89, 20));
		btnVipCustomer.setPreferredSize(new Dimension(90, 20));
		btnVipCustomer.setBounds(0, 156, 178, 52);
		panelBtns.add(btnVipCustomer);
		
		//change to the relevant text, make components visible
		//show a message if there are no objects in combobox
		JButton btnEmployee = new JButton("Employee");
		btnEmployee.setFocusable(false);
		btnEmployee.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnEmployee.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				i = 5;
				comboBox.removeAllItems();
				lblSearch.setText("Search Employee");
				lblPlease.setText(" Please choose employee ID ");
				comboBox.setVisible(true);
				btnSearch.setVisible(true);
				s = Main.hotel.getAllEmployees().keySet().toArray(); // setting combobox items
				for(int j = 0; j< s.length ; j++) {
					comboBox.addItem(s[j]);
				}
				textPaneToString.setText("");
				if(s.length == 0)  // if no items
					textPaneToString.setText("There are no employees in the system");
			}
		});
		btnEmployee.setMargin(new Insets(2, 10, 2, 10));
		btnEmployee.setFont(new Font("Segoe UI Black", Font.PLAIN, 14));
		btnEmployee.setMaximumSize(new Dimension(89, 20));
		btnEmployee.setMinimumSize(new Dimension(89, 20));
		btnEmployee.setPreferredSize(new Dimension(90, 20));
		btnEmployee.setBounds(0, 208, 178, 52);
		panelBtns.add(btnEmployee);
		
		//change to the relevant text, make components visible
		//show a message if there are no objects in combobox
		JButton btnDepartmentManager = new JButton("Department Manager");
		btnDepartmentManager.setFocusable(false);
		btnDepartmentManager.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnDepartmentManager.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				i = 6;
				comboBox.removeAllItems();
				lblSearch.setText("Search Department Manager");
				lblPlease.setText(" Please choose department manager ID ");
				comboBox.setVisible(true);
				btnSearch.setVisible(true);
				for(Employee dm : Main.hotel.getAllEmployees().values()){
					if(dm instanceof DepartmentManager) { // setting combobox items
						comboBox.addItem(dm.getId());
					}
				}
				textPaneToString.setText("");
				if(comboBox.getItemCount() == 0)  // if no items
					textPaneToString.setText("There are no department managers in the system");
			}
		});
		btnDepartmentManager.setMargin(new Insets(2, 10, 2, 10));
		btnDepartmentManager.setFont(new Font("Segoe UI Black", Font.PLAIN, 14));
		btnDepartmentManager.setMaximumSize(new Dimension(89, 20));
		btnDepartmentManager.setMinimumSize(new Dimension(89, 20));
		btnDepartmentManager.setPreferredSize(new Dimension(90, 20));
		btnDepartmentManager.setBounds(0, 260, 178, 52);
		panelBtns.add(btnDepartmentManager);
		
		//change to the relevant text, make components visible
		//show a message if there are no objects in combobox
		JButton btnStandardRoom = new JButton("Standard Room");
		btnStandardRoom.setFocusable(false);
		btnStandardRoom.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnStandardRoom.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				i = 7;
				comboBox.removeAllItems();
				lblSearch.setText("Search Standard Room");
				lblPlease.setText(" Please choose standard room number ");
				comboBox.setVisible(true);
				btnSearch.setVisible(true);
				for(Room s : Main.hotel.getAllRooms().values()){
					if(s instanceof StandardRoom && !(s instanceof SuperiorRoom) && !(s instanceof Suite)) {
						comboBox.addItem(s.getRoomNumber()); // setting combobox items
					}
				}
				textPaneToString.setText("");
				if(comboBox.getItemCount() == 0) // if no items
					textPaneToString.setText("There are no standard rooms in the system");
			}
		});
		btnStandardRoom.setMargin(new Insets(2, 10, 2, 10));
		btnStandardRoom.setFont(new Font("Segoe UI Black", Font.PLAIN, 14));
		btnStandardRoom.setMaximumSize(new Dimension(89, 20));
		btnStandardRoom.setMinimumSize(new Dimension(89, 20));
		btnStandardRoom.setPreferredSize(new Dimension(90, 20));
		btnStandardRoom.setBounds(0, 312, 178, 52);
		panelBtns.add(btnStandardRoom);
		
		//change to the relevant text, make components visible
		//show a message if there are no objects in combobox
		JButton btnSuperiorRoom = new JButton("Superior Room");
		btnSuperiorRoom.setFocusable(false);
		btnSuperiorRoom.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnSuperiorRoom.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				i = 8;
				comboBox.removeAllItems();
				lblSearch.setText("Search Superior Room");
				lblPlease.setText(" Please choose superior room number ");
				comboBox.setVisible(true);
				btnSearch.setVisible(true);
				for(Room s : Main.hotel.getAllRooms().values()){
					if(s instanceof SuperiorRoom && !(s instanceof Suite)) { 
						comboBox.addItem(s.getRoomNumber());  // setting combobox items
					}
				}
				textPaneToString.setText("");
				if(comboBox.getItemCount() == 0)  // if no items
					textPaneToString.setText("There are no superior rooms in the system");
			}
		});
		btnSuperiorRoom.setMargin(new Insets(2, 10, 2, 10));
		btnSuperiorRoom.setFont(new Font("Segoe UI Black", Font.PLAIN, 14));
		btnSuperiorRoom.setMaximumSize(new Dimension(89, 20));
		btnSuperiorRoom.setMinimumSize(new Dimension(89, 20));
		btnSuperiorRoom.setPreferredSize(new Dimension(90, 20));
		btnSuperiorRoom.setBounds(0, 364, 178, 52);
		panelBtns.add(btnSuperiorRoom);
		
		//change to the relevant text, make components visible
		//show a message if there are no objects in combobox
		JButton btnSuite = new JButton("Suite");
		btnSuite.setFocusable(false);
		btnSuite.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnSuite.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				i = 9;
				comboBox.removeAllItems();
				lblSearch.setText("Search Suite");
				lblPlease.setText(" Please choose suite number ");
				comboBox.setVisible(true);
				btnSearch.setVisible(true);
				for(Room s : Main.hotel.getAllRooms().values()){
					if(s instanceof Suite) {
						comboBox.addItem(s.getRoomNumber());   // setting combobox items
					}
				}
				textPaneToString.setText("");
				if(comboBox.getItemCount() == 0)  // if no items
					textPaneToString.setText("There are no suites in the system");
			}
		});
		btnSuite.setMargin(new Insets(2, 10, 2, 10));
		btnSuite.setFont(new Font("Segoe UI Black", Font.PLAIN, 14));
		btnSuite.setPreferredSize(new Dimension(90, 20));
		btnSuite.setMinimumSize(new Dimension(89, 20));
		btnSuite.setMaximumSize(new Dimension(89, 20));
		btnSuite.setBounds(0, 416, 178, 53);
		panelBtns.add(btnSuite);
		
		JScrollPane scrollPane = new JScrollPane(textPaneToString, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		scrollPane.setViewportBorder(new LineBorder(new Color(164, 208, 227), 2));
		scrollPane.setBackground(new Color(164, 208, 227));
		scrollPane.setBounds(new Rectangle(10, 110, 345, 120));
		lblFrame.add(scrollPane);
		

	}

}
