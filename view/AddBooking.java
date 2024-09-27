// @author Eden Eliezer ID 207188038
package view;

import java.awt.EventQueue;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JInternalFrame;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Cursor;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;

import javax.swing.SwingConstants;
import javax.swing.border.EtchedBorder;

import com.toedter.calendar.JDateChooser;

import model.Booking;
import model.Customer;

public class AddBooking extends JInternalFrame {

	Object[] r, c;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AddBooking frame = new AddBooking();
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
	public AddBooking() {
		// adding and setting all components and texts
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 789, 472);
		getContentPane().add(panel);
		
		panel.setBackground(new Color(255, 255, 255));
		panel.setLayout(null);
		
		JPanel leftPanel = new JPanel();
		leftPanel.setBounds(0, 0, 500, 472);
		panel.add(leftPanel);
		leftPanel.setLayout(null);
		
		JLabel leftIcon_addBooking = new JLabel("");
		leftIcon_addBooking.setBounds(0, 0, 500, 472);
		leftIcon_addBooking.setVerticalAlignment(SwingConstants.TOP);
		leftIcon_addBooking.setIcon(new ImageIcon(AddBooking.class.getResource("/gui_icons/EmployeeMenuBackground.png")));
		leftPanel.add(leftIcon_addBooking);
		
		JPanel rightPanel_addBooking = new JPanel();
		rightPanel_addBooking.setBounds(501, 0, 288, 472);
		rightPanel_addBooking.setBackground(new Color(255, 255, 255));
		panel.add(rightPanel_addBooking);
		rightPanel_addBooking.setLayout(null);
		
		JLabel lblRoomNumber = new JLabel(" Room number");
		lblRoomNumber.setFont(new Font("Segoe UI", Font.BOLD, 16));
		lblRoomNumber.setBounds(0, 40, 278, 22);
		rightPanel_addBooking.add(lblRoomNumber);
		
		JLabel lblCustomer = new JLabel(" Customer ID");
		lblCustomer.setFont(new Font("Segoe UI", Font.BOLD, 16));
		lblCustomer.setBounds(0, 129, 278, 22);
		rightPanel_addBooking.add(lblCustomer);
		
		JLabel lblChekInDate = new JLabel(" Check-In date");
		lblChekInDate.setFont(new Font("Segoe UI", Font.BOLD, 16));
		lblChekInDate.setBounds(0, 212, 278, 22);
		rightPanel_addBooking.add(lblChekInDate);
		
		JLabel lblNumberOfDays = new JLabel(" Number of Days");
		lblNumberOfDays.setFont(new Font("Segoe UI", Font.BOLD, 16));
		lblNumberOfDays.setBounds(0, 297, 278, 22);
		rightPanel_addBooking.add(lblNumberOfDays);
		
		JSpinner spinnerNumOfDays = new JSpinner();
		spinnerNumOfDays.setBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(162, 170, 132), new Color(177, 207, 199)));
		spinnerNumOfDays.setModel(new SpinnerNumberModel(Integer.valueOf(1), Integer.valueOf(1), null, Integer.valueOf(1)));
		spinnerNumOfDays.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 14));
		spinnerNumOfDays.setBounds(10, 324, 118, 29);
		rightPanel_addBooking.add(spinnerNumOfDays);
		
		JDateChooser dateChooser = new JDateChooser();
		dateChooser.setToolTipText("");
		dateChooser.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 14));
		dateChooser.setBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(162, 170, 132), new Color(177, 207, 199)));
		dateChooser.setBounds(10, 235, 118, 29);
		LocalDate today = LocalDate.now();
		Date now = Date.from(today.atStartOfDay(ZoneId.systemDefault()).toInstant());
		
		JLabel lblAddBooking = new JLabel("Add Booking");
		lblAddBooking.setBackground(new Color(177, 207, 199));
		lblAddBooking.setForeground(new Color(255, 255, 255));
		lblAddBooking.setHorizontalAlignment(SwingConstants.CENTER);
		lblAddBooking.setFont(new Font("Segoe UI", Font.BOLD, 16));
		lblAddBooking.setBounds(10, 0, 268, 29);
		rightPanel_addBooking.add(lblAddBooking);
		dateChooser.setMinSelectableDate(now);
		rightPanel_addBooking.add(dateChooser);
		
		JPanel headline = new JPanel();
		headline.setBackground(new Color(162, 170, 132));
		headline.setBounds(0, 0, 290, 29);
		rightPanel_addBooking.add(headline);
		headline.setLayout(null);
		
		JLabel lblRoomNumberExample = new JLabel("  For example: SuperiorRoom3");
		lblRoomNumberExample.setFont(new Font("Segoe UI", Font.BOLD, 11));
		lblRoomNumberExample.setForeground(new Color(192, 192, 192));
		lblRoomNumberExample.setBounds(0, 56, 198, 22);
		rightPanel_addBooking.add(lblRoomNumberExample);
		
		// setting comboxbox options
		r = Main.hotel.getAllRooms().keySet().toArray();
		JComboBox comboBoxRoomNum = new JComboBox(r);
		comboBoxRoomNum.setBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(162, 170, 132), new Color(177, 207, 199)));
		comboBoxRoomNum.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 14));
		comboBoxRoomNum.setBounds(10, 81, 150, 29);
		rightPanel_addBooking.add(comboBoxRoomNum);
		
		c = Main.hotel.getAllCustomers().keySet().toArray();
		JComboBox comboBoxCustomerID = new JComboBox(c);
		comboBoxCustomerID.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 14));
		comboBoxCustomerID.setBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(162, 170, 132), new Color(177, 207, 199)));
		comboBoxCustomerID.setBounds(10, 154, 150, 29);
		rightPanel_addBooking.add(comboBoxCustomerID);
		
		JButton btnAddBooking = new JButton("ADD BOOKING");
		btnAddBooking.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnAddBooking.setBorderPainted(false);
		btnAddBooking.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) { // in case add booking button is pressed
				Customer c = Main.hotel.getAllCustomers().get(String.valueOf(comboBoxCustomerID.getSelectedItem()));
				if(c != null) { // if there is customer
					if(dateChooser.getDate() == null) { // if the user didn't choose date
							JOptionPane.showInternalMessageDialog(null,"Please enter Check-In date");
						}
					else { // if the user chose date
						String roomNum = String.valueOf(comboBoxRoomNum.getSelectedItem());
						if(roomNum != null) { 
							Booking b = new Booking(roomNum, c, dateChooser.getDate(), (int)spinnerNumOfDays.getValue());
							if(! (Main.hotel.getAllBookings().containsKey(b.getBookingNumber()))) {
								if(Main.hotel.addBooking(b) == true) { // if booking was added successfully
									// adding money sound
									File bookSound = new File("src/gui_sounds/cash.wav");
									try {
										AudioInputStream a = AudioSystem.getAudioInputStream(bookSound);
										Clip clip = AudioSystem.getClip();
										clip.open(a);
										clip.start();
									} catch (UnsupportedAudioFileException e1) {
										// TODO Auto-generated catch block
										e1.printStackTrace();
									} catch (IOException e1) {
										// TODO Auto-generated catch block
										e1.printStackTrace();
									} catch (LineUnavailableException e1) {
										// TODO Auto-generated catch block
										e1.printStackTrace();
									} // show message
									JOptionPane.showInternalMessageDialog(null,"Booking successfully added to the hotel!");
								}
								else
									JOptionPane.showInternalMessageDialog(null,"Booking did *NOT* added to the hotel!");
							}
							else // if booking is already exist
								JOptionPane.showInternalMessageDialog(null,"Booking already exists!");
						}
						else // if there is no room
							JOptionPane.showInternalMessageDialog(null,"Room does *NOT* exist!");
					}
				}
				else // if there is no customer
					JOptionPane.showInternalMessageDialog(null,"Customer does *NOT* exist!");	
			}
		});
		btnAddBooking.setFont(new Font("Segoe UI", Font.BOLD, 18));
		btnAddBooking.setBackground(new Color(162, 170, 132));
		btnAddBooking.setBounds(10, 388, 268, 73);
		btnAddBooking.setFocusable(false);
		rightPanel_addBooking.add(btnAddBooking);
		
		

	}
}
