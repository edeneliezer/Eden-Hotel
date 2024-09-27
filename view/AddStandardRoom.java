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
import javax.swing.JSpinner;
import javax.swing.JTextArea;
import javax.swing.SpinnerNumberModel;
import javax.swing.SwingConstants;
import javax.swing.border.EtchedBorder;


import model.Hotel;
import Exceptions.MaxPopulationCapacityException;
import Exceptions.PersonAlreadyExistException;
import model.StandardRoom;
import model.Suite;
import model.SuperiorRoom;

public class AddStandardRoom extends JInternalFrame {

	JPanel panel;
	JPanel leftPanel;
	JLabel leftIcon_addRoom;
	JPanel rightPanel_addRoom;
	JLabel lblDailyPrice;
	JLabel lblRoomGrade;
	LocalDate today;
	Date now;
	JLabel lblAddRoom;
	JPanel headline;
	JLabel lblHasView;
	JLabel lblMaxPopulationCapacity;
	JComboBox comboBoxHasView;
	JLabel lblSize;
	JSpinner spinnerFloor;
	JSpinner spinnerDailyPrice;
	JSpinner spinnerAverageDailyCost;
	JSpinner spinnerRoomGrade;
	JSpinner spinnerMaxPopulationCapacity;
	JSpinner spinnerSize;
	JLabel lblFloor;
	JLabel lblAverageDailyCost;
	JLabel lblHasJaccozi;
	JComboBox comboBoxHasJaccozi;
	JLabel lblBalconySize;
	JSpinner spinnerBalconySize;
	JButton btnAddRoom;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AddStandardRoom frame = new AddStandardRoom();
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
	public AddStandardRoom() {
		// adding and setting all components and texts
		
		panel = new JPanel();
		panel.setBounds(0, 0, 10, 10);
		getContentPane().add(panel);
		panel.setLayout(null);
		
		setBounds(100, 100, 800, 503);
		panel.setBackground(new Color(255, 255, 255));
		panel.setLayout(null);
		
		leftPanel = new JPanel();
		leftPanel.setBounds(0, 0, 500, 472);
		panel.add(leftPanel);
		leftPanel.setLayout(null);
		
		leftIcon_addRoom = new JLabel("");
		leftIcon_addRoom.setVerticalAlignment(SwingConstants.TOP);
		leftIcon_addRoom.setIcon(new ImageIcon(AddStandardRoom.class.getResource("/gui_icons/StandardRoom.png")));
		leftIcon_addRoom.setBounds(0, 0, 500, 472);
		leftPanel.add(leftIcon_addRoom);
		
		rightPanel_addRoom = new JPanel();
		rightPanel_addRoom.setBackground(SystemColor.menu);
		rightPanel_addRoom.setBounds(501, 0, 288, 472);
		panel.add(rightPanel_addRoom);
		rightPanel_addRoom.setLayout(null);
		
		lblDailyPrice = new JLabel("Daily Price");
		lblDailyPrice.setVerticalAlignment(SwingConstants.TOP);
		lblDailyPrice.setFont(new Font("Segoe UI", Font.BOLD, 16));
		lblDailyPrice.setBounds(12, 31, 132, 22);
		rightPanel_addRoom.add(lblDailyPrice);
		
		lblFloor = new JLabel("Floor");
		lblFloor.setFont(new Font("Segoe UI", Font.BOLD, 16));
		lblFloor.setBounds(12, 84, 132, 22);
		rightPanel_addRoom.add(lblFloor);
		
		lblAverageDailyCost = new JLabel("Average Daily Cost");
		lblAverageDailyCost.setFont(new Font("Segoe UI", Font.BOLD, 16));
		lblAverageDailyCost.setBounds(12, 137, 152, 22);
		rightPanel_addRoom.add(lblAverageDailyCost);
		
		lblRoomGrade = new JLabel("Room Grade");
		lblRoomGrade.setFont(new Font("Segoe UI", Font.BOLD, 16));
		lblRoomGrade.setBounds(12, 197, 105, 22);
		rightPanel_addRoom.add(lblRoomGrade);
		today = LocalDate.now();
		now = Date.from(today.atStartOfDay(ZoneId.systemDefault()).toInstant());
		
		lblAddRoom = new JLabel("Add Standard Room");
		lblAddRoom.setBackground(new Color(177, 207, 199));
		lblAddRoom.setForeground(new Color(255, 255, 255));
		lblAddRoom.setHorizontalAlignment(SwingConstants.CENTER);
		lblAddRoom.setFont(new Font("Segoe UI", Font.BOLD, 16));
		lblAddRoom.setBounds(10, 0, 268, 29);
		rightPanel_addRoom.add(lblAddRoom);
		
		headline = new JPanel();
		headline.setBackground(new Color(162, 170, 132));
		headline.setBounds(0, 0, 290, 29);
		rightPanel_addRoom.add(headline);
		headline.setLayout(null);
		
		lblHasView = new JLabel("Has View");
		lblHasView.setFont(new Font("Segoe UI", Font.BOLD, 16));
		lblHasView.setBounds(12, 318, 132, 22);
		rightPanel_addRoom.add(lblHasView);
		
		lblMaxPopulationCapacity = new JLabel("Max Population Capacity");
		lblMaxPopulationCapacity.setFont(new Font("Segoe UI", Font.BOLD, 16));
		lblMaxPopulationCapacity.setBounds(12, 256, 194, 22);
		rightPanel_addRoom.add(lblMaxPopulationCapacity);
		
		// setting combobox options
		comboBoxHasView = new JComboBox(new String[] {"No", "Yes"});
		comboBoxHasView.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 14));
		comboBoxHasView.setBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(162, 170, 132), new Color(177, 207, 199)));
		comboBoxHasView.setBounds(12, 341, 105, 27);
		rightPanel_addRoom.add(comboBoxHasView);
		
		lblSize = new JLabel("Size");
		lblSize.setFont(new Font("Segoe UI", Font.BOLD, 16));
		lblSize.setBounds(158, 318, 97, 22);
		rightPanel_addRoom.add(lblSize);
		
		spinnerFloor = new JSpinner();
		spinnerFloor.setModel(new SpinnerNumberModel(Integer.valueOf(0), Integer.valueOf(0), null, Integer.valueOf(1)));
		spinnerFloor.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 14));
		spinnerFloor.setBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(162, 170, 132), new Color(177, 207, 199)));
		spinnerFloor.setBounds(12, 106, 105, 27);
		rightPanel_addRoom.add(spinnerFloor);
		
		spinnerDailyPrice = new JSpinner();
		spinnerDailyPrice.setModel(new SpinnerNumberModel(Double.valueOf(0), Double.valueOf(0), null, Double.valueOf(1)));
		spinnerDailyPrice.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 14));
		spinnerDailyPrice.setBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(162, 170, 132), new Color(177, 207, 199)));
		spinnerDailyPrice.setBounds(12, 54, 105, 27);
		rightPanel_addRoom.add(spinnerDailyPrice);
		
		spinnerAverageDailyCost = new JSpinner();
		spinnerAverageDailyCost.setModel(new SpinnerNumberModel(Double.valueOf(0), Double.valueOf(0), null, Double.valueOf(1)));
		spinnerAverageDailyCost.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 14));
		spinnerAverageDailyCost.setBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(162, 170, 132), new Color(177, 207, 199)));
		spinnerAverageDailyCost.setBounds(12, 159, 105, 27);
		rightPanel_addRoom.add(spinnerAverageDailyCost);
		
		spinnerRoomGrade = new JSpinner();
		spinnerRoomGrade.setModel(new SpinnerNumberModel(Double.valueOf(0), Double.valueOf(0), null, Double.valueOf(1)));
		spinnerRoomGrade.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 14));
		spinnerRoomGrade.setBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(162, 170, 132), new Color(177, 207, 199)));
		spinnerRoomGrade.setBounds(12, 218, 105, 27);
		rightPanel_addRoom.add(spinnerRoomGrade);
		
		spinnerMaxPopulationCapacity = new JSpinner();
		spinnerMaxPopulationCapacity.setModel(new SpinnerNumberModel(1, 1, 2, 1));
		spinnerMaxPopulationCapacity.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 14));
		spinnerMaxPopulationCapacity.setBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(162, 170, 132), new Color(177, 207, 199)));
		spinnerMaxPopulationCapacity.setBounds(12, 280, 105, 27);
		rightPanel_addRoom.add(spinnerMaxPopulationCapacity);
		
		spinnerSize = new JSpinner();
		spinnerSize.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 14));
		spinnerSize.setBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(162, 170, 132), new Color(177, 207, 199)));
		spinnerSize.setBounds(154, 341, 105, 27);
		rightPanel_addRoom.add(spinnerSize);
		
		lblHasJaccozi = new JLabel("Has Jaccozi");
		lblHasJaccozi.setFont(new Font("Segoe UI", Font.BOLD, 16));
		lblHasJaccozi.setBounds(154, 31, 132, 22);
		rightPanel_addRoom.add(lblHasJaccozi);
		lblHasJaccozi.setVisible(false);
		
		// setting combobox options
		comboBoxHasJaccozi = new JComboBox(new String[] {"No", "Yes"});
		comboBoxHasJaccozi.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 14));
		comboBoxHasJaccozi.setBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(162, 170, 132), new Color(177, 207, 199)));
		comboBoxHasJaccozi.setBounds(154, 54, 105, 27);
		rightPanel_addRoom.add(comboBoxHasJaccozi);
		comboBoxHasJaccozi.setVisible(false);
		
		lblBalconySize = new JLabel("Balcony Size");
		lblBalconySize.setVerticalAlignment(SwingConstants.TOP);
		lblBalconySize.setFont(new Font("Segoe UI", Font.BOLD, 16));
		lblBalconySize.setBounds(154, 84, 132, 22);
		rightPanel_addRoom.add(lblBalconySize);
		lblBalconySize.setVisible(false);
		
		spinnerBalconySize = new JSpinner();
		spinnerBalconySize.setModel(new SpinnerNumberModel(Double.valueOf(0), Double.valueOf(0), null, Double.valueOf(1)));
		spinnerBalconySize.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 14));
		spinnerBalconySize.setBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(162, 170, 132), new Color(177, 207, 199)));
		spinnerBalconySize.setBounds(154, 106, 105, 27);
		rightPanel_addRoom.add(spinnerBalconySize);
		spinnerBalconySize.setVisible(false);
		
		btnAddRoom = new JButton("ADD STANDARD ROOM");
		btnAddRoom.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnAddRoom.setBorderPainted(false);
		btnAddRoom.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) { // if add standard room button is pressed
				switch(EmployeeMenu.rt) { // rt is a flag in employee menu that let us know which room the user chose
					case(1):{ // user chose standard room
						boolean hasView =false;
						if(comboBoxHasView.getSelectedItem().equals("Yes")) { // if room has view
							hasView = true;
						}
						StandardRoom s = new StandardRoom((double)spinnerDailyPrice.getValue(), (int)spinnerFloor.getValue(), (double)spinnerAverageDailyCost.getValue(),
								(double)spinnerRoomGrade.getValue(), (int)spinnerMaxPopulationCapacity.getValue(), (int)spinnerSize.getValue(), hasView);
						if(! (Main.hotel.getAllRooms().containsKey(s.getRoomNumber()))) {
								try {
									if(Main.hotel.addStandardRoom(s) == true) { // if Standard room added successfully
										JOptionPane.showInternalMessageDialog(null,"StandardRoom successfully added to the hotel!");
									}
									else
										JOptionPane.showInternalMessageDialog(null,"StandardRoom did *NOT* added to the hotel!");
								} catch (MaxPopulationCapacityException e1) { // in case more or below capacity
									// TODO Auto-generated catch block
									e1.printStackTrace();
								}
						}
						else // if already exist
							JOptionPane.showInternalMessageDialog(null,"Standard room already exists!");
						break;
					}
					case(2):{ // user chose superior room
						boolean hasView = false, hasJaccozi = false;
						if(comboBoxHasView.getSelectedItem().equals("Yes")) { // if room has view
							hasView = true;
						}
						if(comboBoxHasJaccozi.getSelectedItem().equals("Yes")) { // if room has jaccozi
							hasJaccozi = true;
						}
						SuperiorRoom s = new SuperiorRoom((double)spinnerDailyPrice.getValue(), (int)spinnerFloor.getValue(), (double)spinnerAverageDailyCost.getValue(),
								(double)spinnerRoomGrade.getValue(), (int)spinnerMaxPopulationCapacity.getValue(), (int)spinnerSize.getValue(), hasView, hasJaccozi);
						if(! (Main.hotel.getAllRooms().containsKey(s.getRoomNumber()))) {
								try {
									if(Main.hotel.addSuperiorRoom(s) == true) { // if Superior room added successfully
										JOptionPane.showInternalMessageDialog(null,"SuperiorRoom successfully added to the hotel!");
									}
									else
										JOptionPane.showInternalMessageDialog(null,"SuperiorRoom did *NOT* added to the hotel!");
								} catch (MaxPopulationCapacityException e1) { // in case more or below capacity
									// TODO Auto-generated catch block
									e1.printStackTrace();
								}
						}
						else // if already exist
							JOptionPane.showInternalMessageDialog(null,"Standard room already exists!");
						break;
					}
					case(3):{ // user chose suite
						boolean hasView = false, hasJaccozi = false;
						if(comboBoxHasView.getSelectedItem().equals("Yes")) { // if room has view
							hasView = true;
						}
						if(comboBoxHasJaccozi.getSelectedItem().equals("Yes")) { // if room has jaccozi
							hasJaccozi = true;
						}
						Suite s = new Suite((double)spinnerDailyPrice.getValue(), (int)spinnerFloor.getValue(), (double)spinnerAverageDailyCost.getValue(),
								(double)spinnerRoomGrade.getValue(), (int)spinnerMaxPopulationCapacity.getValue(), (int)spinnerSize.getValue(), hasView, hasJaccozi, (double)spinnerBalconySize.getValue());
						if(! (Main.hotel.getAllRooms().containsKey(s.getRoomNumber()))) {
								try {
									if(Main.hotel.addSuite(s) == true) { // if Suite added successfully
										JOptionPane.showInternalMessageDialog(null,"Suite successfully added to the hotel!");
									}
									else
										JOptionPane.showInternalMessageDialog(null,"Suite did *NOT* added to the hotel!");
								} catch (MaxPopulationCapacityException e1) { // in case more or below capacity
									// TODO Auto-generated catch block
									e1.printStackTrace();
								}
						}
						else // if already exist
							JOptionPane.showInternalMessageDialog(null,"Suite already exists!");
						break;
					}
				}	
			}
			
		});
		btnAddRoom.setFont(new Font("Segoe UI", Font.BOLD, 18));
		btnAddRoom.setBackground(new Color(162, 170, 132));
		btnAddRoom.setBounds(10, 388, 268, 73);
		btnAddRoom.setFocusable(false);
		rightPanel_addRoom.add(btnAddRoom);
		
		

	}

}
