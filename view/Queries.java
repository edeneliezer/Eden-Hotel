// @author Eden Eliezer ID 207188038
package view;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import java.util.TreeSet;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;
import javax.swing.SwingConstants;
import javax.swing.border.BevelBorder;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EtchedBorder;
import javax.swing.border.LineBorder;

import model.Booking;
import model.Customer;
import model.Employee;
import model.Hotel;
import javax.swing.JTextPane;
import javax.swing.ScrollPaneConstants;

import java.awt.Rectangle;
import java.awt.Point;
import javax.swing.JScrollPane;

public class Queries extends JInternalFrame {

	JPanel panel;
	JButton btnOK;
	JComboBox comboBox;
	JLabel lblQuery_1 ;
	JTextPane textPaneToString;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Queries frame = new Queries();
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
	public Queries() {
		// adding and setting components and texts
		
		panel = new JPanel();
		panel.setBounds(0, 0, 790, 471);
		getContentPane().add(panel);
		panel.setLayout(null);
		
		panel.setBackground(new Color(255, 255, 255));
		panel.setLayout(null);
		
		JPanel leftPanel = new JPanel();
		leftPanel.setBounds(0, 0, 500, 472);
		panel.add(leftPanel);
		leftPanel.setLayout(null);
		
		JLabel leftIcon_more = new JLabel("");
		leftIcon_more.setVerticalAlignment(SwingConstants.TOP);
		leftIcon_more.setIcon(new ImageIcon(Queries.class.getResource("/gui_icons/more2.png")));
		leftIcon_more.setBounds(0, 0, 500, 472);
		leftPanel.add(leftIcon_more);
		
		JPanel rightPanel_more = new JPanel();
		rightPanel_more.setBackground(new Color(248, 220, 192));
		rightPanel_more.setBounds(502, 0, 288, 472);
		panel.add(rightPanel_more);
		rightPanel_more.setLayout(null);
		
		// main frame text
		JLabel lblQuery = new JLabel("");
		lblQuery.setHorizontalAlignment(SwingConstants.CENTER);
		lblQuery.setFont(new Font("Segoe UI", Font.BOLD, 17));
		lblQuery.setBounds(10, 59, 268, 29);
		rightPanel_more.add(lblQuery);
		
		// main frame text
		JLabel lblMore = new JLabel("");
		lblMore.setBackground(new Color(240, 183, 119));
		lblMore.setForeground(new Color(255, 255, 255));
		lblMore.setHorizontalAlignment(SwingConstants.CENTER);
		lblMore.setFont(new Font("Segoe UI", Font.BOLD, 16));
		lblMore.setBounds(10, 0, 268, 29);
		rightPanel_more.add(lblMore);
		
		JPanel headline = new JPanel();
		headline.setBackground(new Color(240, 183, 119));
		headline.setBounds(0, 0, 290, 29);
		rightPanel_more.add(headline);
		headline.setLayout(null);
		
		JSpinner spinnerKEmployees = new JSpinner();
		spinnerKEmployees.setBackground(new Color(242, 199, 151));
		spinnerKEmployees.setModel(new SpinnerNumberModel(Integer.valueOf(1), Integer.valueOf(1), null, Integer.valueOf(1)));
		spinnerKEmployees.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 14));
		spinnerKEmployees.setBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(240, 183, 119), new Color(242, 199, 151)));
		spinnerKEmployees.setBounds(118, 118, 40, 29);
		rightPanel_more.add(spinnerKEmployees);
		spinnerKEmployees.setVisible(false);
		
		btnOK = new JButton("OK");
		btnOK.setMargin(new Insets(1, 1, 1, 1));
		btnOK.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnOK.setBorderPainted(false);
		rightPanel_more.add(btnOK);
		btnOK.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {	
				switch(EmployeeMenu.more) { // more is a flag in employee menu that let us know which button was pressed
					case(1):{ // pressed 'List of 'k' employees' button
						//change to the relevant text, make components visible
						//show a message if there are no objects in combobox
						lblQuery.setText("List of 'k' employees");
						lblMore.setText("Please choose size of List");
						spinnerKEmployees.setVisible(true);
						comboBox.setVisible(false);
						btnOK.setVisible(true);
						lblQuery_1.setVisible(false);
						List<Employee> list = Main.hotel.KEmployees((int)spinnerKEmployees.getValue());
						if(list.isEmpty()) // in case there is no list to show
							textPaneToString.setText("There are no employees in the system");
						else // show list details
							textPaneToString.setText(list.toString());
						break;
					}
					case(6):{ // pressed 'All bookings of a customer' button
						//change to the relevant text, make components visible
						//show a message if there are no objects in combobox
						lblQuery.setText("All bookings of a customer");
						lblMore.setText("Please choose customer ID");
						spinnerKEmployees.setVisible(false);
						comboBox.setVisible(true);
						btnOK.setVisible(true);
						lblQuery_1.setVisible(false);
						List<Booking> list = Main.hotel.allBookingsOfSpecCustomer(String.valueOf(comboBox.getSelectedItem()));
						if(list.isEmpty()) // in case there is no list to show
							textPaneToString.setText("This customer has no bookings yet");
						else // show list details
							textPaneToString.setText(list.toString());
						break;
					}
				}
			}
		});
		btnOK.setFont(new Font("Segoe UI", Font.BOLD, 18));
		btnOK.setBackground(new Color(240, 183, 119));
		btnOK.setBounds(80, 158, 122, 27);
		btnOK.setFocusable(false);
		
		comboBox = new JComboBox();
		comboBox.setBorder(new LineBorder(new Color(240, 183, 119), 2));
		comboBox.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 16));
		comboBox.setBounds(31, 118, 206, 35);
		rightPanel_more.add(comboBox);
		comboBox.setVisible(false);
		
		// main frame text
		lblQuery_1 = new JLabel("of bookings");
		lblQuery_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblQuery_1.setFont(new Font("Segoe UI", Font.BOLD, 17));
		lblQuery_1.setBounds(10, 90, 268, 29);
		rightPanel_more.add(lblQuery_1);
		lblQuery_1.setVisible(false);
		
		textPaneToString = new JTextPane();
		textPaneToString.setMargin(new Insets(5, 15, 5, 5));
		textPaneToString.setLocation(new Point(5, 5));
		textPaneToString.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 14));
		textPaneToString.setEditable(false);
		textPaneToString.setBounds(new Rectangle(5, 5, 200, 280));
		textPaneToString.setBorder(new LineBorder(new Color(255, 255, 255), 2));
		textPaneToString.setBackground(new Color(240, 183, 119));
		textPaneToString.setBounds(15, 179, 251, 239);
		rightPanel_more.add(textPaneToString);
		
		// main frame text
		JLabel lblFrame = new JLabel("");
		lblFrame.setOpaque(true);
		lblFrame.setBackground(new Color(248, 220, 192));
		lblFrame.setBorder(new CompoundBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(240, 183, 119), new Color(242, 199, 151)), new LineBorder(new Color(242, 199, 151), 2)));
		lblFrame.setBounds(5, 40, 273, 421);
		rightPanel_more.add(lblFrame);
		
		JScrollPane scrollPane = new JScrollPane(textPaneToString, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		scrollPane.setBackground(new Color(240, 183, 119));
		scrollPane.setBounds(new Rectangle(10, 150, 250, 240));
		lblFrame.add(scrollPane);
		
		
		
		Object[] s = Main.hotel.getAllCustomers().keySet().toArray();
		if(s.length == 0)   // if combobox is empty, show message
			textPaneToString.setText("There are no customers in the system");

		switch(EmployeeMenu.more) { // more is a flag in employee menu that let us know which button was pressed
			case(1):{ // pressed 'List of 'k' employees' button
				//change to the relevant text, make components visible
				//show a message if there are no objects in combobox
				lblQuery.setText("List of 'k' employees");
				lblMore.setText("Please choose size of List");
				spinnerKEmployees.setVisible(true);
				comboBox.setVisible(false);
				btnOK.setVisible(true);
				lblQuery_1.setVisible(false);
				break;
			}
			case(2):{ // pressed 'All customers by PK' button
				//change to the relevant text, make components visible
				//show a message if there are no objects in combobox
				lblQuery.setText("All customers by PK");
				lblMore.setText("");
				spinnerKEmployees.setVisible(false);
				comboBox.setVisible(false);
				btnOK.setVisible(false);
				lblQuery_1.setVisible(false);
				ArrayList<Customer> al = Main.hotel.allCustomersByPK();
				if(al.isEmpty()) // in case there is no array list to show
					textPaneToString.setText("There are no Customers in the system");
				else
					textPaneToString.setText(al.toString());
				break;
			}
			case(3):{ // pressed 'All bookings by revenue' button
				//change to the relevant text, make components visible
				//show a message if there are no objects in combobox
				lblQuery.setText("All bookings by revenue");
				lblMore.setText("");
				spinnerKEmployees.setVisible(false);
				comboBox.setVisible(false);
				btnOK.setVisible(false);
				lblQuery_1.setVisible(false);
				TreeSet<Booking> ts = Main.hotel.allBookingByRevenue();
				if(ts.isEmpty()) // in case tree set is empty
					textPaneToString.setText("There are no Bookings in the system");
				else
					textPaneToString.setText(ts.toString());
				break;
			}
			case(4):{ // pressed 'All customers by number' button
				//change to the relevant text, make components visible
				//show a message if there are no objects in combobox
				lblQuery.setText("All customers by number");
				lblMore.setText("");
				spinnerKEmployees.setVisible(false);
				comboBox.setVisible(false);
				btnOK.setVisible(false);
				lblQuery_1.setVisible(true);
				TreeSet<Customer> ts = Main.hotel.allCustomersCmp();
				if(ts.isEmpty()) // in case tree set is empty
					textPaneToString.setText("There are no customers in the system");
				else
					textPaneToString.setText(ts.toString());
				break;
			}
			case(5):{ // pressed 'Total profit' button
				//change to the relevant text, make components visible
				//show a message if there are no objects in combobox
				lblQuery.setText("Total profit");
				lblMore.setText("");
				spinnerKEmployees.setVisible(false);
				comboBox.setVisible(false);
				btnOK.setVisible(false);
				lblQuery_1.setVisible(false);
				int tp = (int)AllBookingsProfitToWord.allHotelProfit;
				textPaneToString.setText("Total profit is " + tp);
				break;
			}
			case(6):{ // pressed 'All bookings of a customer' button
				//change to the relevant text, make components visible
				//show a message if there are no objects in combobox
				lblQuery.setText("All bookings of a customer");
				spinnerKEmployees.setVisible(false);
				comboBox.setVisible(true);
				lblQuery_1.setVisible(false);
				for(int j = 0; j< s.length ; j++) {
					comboBox.addItem(s[j]);
				}
				if(comboBox.getItemCount() == 0) // in case the combobox is empty to show
					textPaneToString.setText("There are no customers in the system");
				else {
					lblMore.setText("Please choose customer ID");

					btnOK.setVisible(true);
				}
					break;
			}
			case(7):{ // pressed 'Customer booked the most rooms' button
				//change to the relevant text, make components visible
				//show a message if there are no objects in combobox
				lblQuery.setText("Customer booked the");
				lblMore.setText("");
				spinnerKEmployees.setVisible(false);
				comboBox.setVisible(false);
				btnOK.setVisible(false);
				lblQuery_1.setText("most rooms");
				lblQuery_1.setVisible(true);
				Customer c = Main.hotel.customerBookedTheMostRooms();
				if(c == null) // in case there is no customer to show
					textPaneToString.setText("There are no customers in the system");
				else
					textPaneToString.setText(c.toString());
				break;
			}
		}
		
	
		
	}
}
