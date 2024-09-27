// @author Eden Eliezer ID 207188038
package view;

import java.awt.EventQueue;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JInternalFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.border.EtchedBorder;

import Exceptions.EmptyException;
import Exceptions.NumbersOnlyException;
import model.Department;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AddDepartment extends JInternalFrame {

	private JTextField txtDepartmentID;
	private int id;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AddDepartment frame = new AddDepartment();
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
	public AddDepartment() {
		// adding and setting all components and texts
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 10, 10);
		getContentPane().add(panel);
		
		setPreferredSize(new Dimension(800, 550));
		panel.setBackground(new Color(255, 255, 255));
		panel.setLayout(null);
		
		JPanel leftPanel = new JPanel();
		leftPanel.setBounds(0, 0, 500, 472);
		panel.add(leftPanel);
		leftPanel.setLayout(null);
		
		JLabel leftIcon_addDepartment = new JLabel("");
		leftIcon_addDepartment.setVerticalAlignment(SwingConstants.TOP);
		leftIcon_addDepartment.setIcon(new ImageIcon(AddDepartment.class.getResource("/gui_icons/EmployeeMenuBackground.png")));
		leftIcon_addDepartment.setBounds(0, 0, 500, 472);
		leftPanel.add(leftIcon_addDepartment);
		
		JPanel rightPanel_addDepartment = new JPanel();
		rightPanel_addDepartment.setBackground(new Color(255, 255, 255));
		rightPanel_addDepartment.setBounds(501, 0, 288, 472);
		panel.add(rightPanel_addDepartment);
		rightPanel_addDepartment.setLayout(null);
		
		JLabel lblDepartmentID = new JLabel("Department ID");
		lblDepartmentID.setFont(new Font("Segoe UI", Font.BOLD, 16));
		lblDepartmentID.setBounds(10, 40, 144, 22);
		rightPanel_addDepartment.add(lblDepartmentID);
		
		JLabel lblSpecialization = new JLabel("Specialization");
		lblSpecialization.setFont(new Font("Segoe UI", Font.BOLD, 16));
		lblSpecialization.setBounds(10, 129, 134, 22);
		rightPanel_addDepartment.add(lblSpecialization);
		
		JLabel lblAddDepartment = new JLabel("Add Department");
		lblAddDepartment.setBackground(new Color(177, 207, 199));
		lblAddDepartment.setForeground(new Color(255, 255, 255));
		lblAddDepartment.setHorizontalAlignment(SwingConstants.CENTER);
		lblAddDepartment.setFont(new Font("Segoe UI", Font.BOLD, 16));
		lblAddDepartment.setBounds(10, 0, 268, 29);
		rightPanel_addDepartment.add(lblAddDepartment);
		
		JPanel headline = new JPanel();
		headline.setBackground(new Color(162, 170, 132));
		headline.setBounds(0, 0, 290, 29);
		rightPanel_addDepartment.add(headline);
		headline.setLayout(null);
		
		// setting combobox items
		JComboBox comboBoxSpecialization = new JComboBox(utils.Specialization.values());
		comboBoxSpecialization.setBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(162, 170, 132), new Color(177, 207, 199)));
		comboBoxSpecialization.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 14));
		comboBoxSpecialization.setBounds(10, 154, 134, 29);
		rightPanel_addDepartment.add(comboBoxSpecialization);
		
		txtDepartmentID = new JTextField();
		txtDepartmentID.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 14));
		txtDepartmentID.setBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(162, 170, 132), new Color(177, 207, 199)));
		txtDepartmentID.setBounds(10, 63, 134, 29);
		rightPanel_addDepartment.add(txtDepartmentID);
		txtDepartmentID.setColumns(10);
		
		JButton btnAddDepartment = new JButton("ADD DEPARTMENT");
		btnAddDepartment.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnAddDepartment.setBorderPainted(false);
		btnAddDepartment.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) { // in case add department button is pressed
				try {
					if(txtDepartmentID.getText().equals("")) { // if the user didn't enter department id
						throw new EmptyException();
						}
					else if(! (txtDepartmentID.getText().equals(""))){
						try {
							id = Integer.parseInt(txtDepartmentID.getText());
						}
						catch(NumberFormatException ex){ // if the user didn't enter integer
							JOptionPane.showInternalMessageDialog(null,"Please enter *integers* only", "Department ID", 0);
						}
						if(id <= 0 ) { // if the id is negative
							JOptionPane.showInternalMessageDialog(null,"Please enter *positive* integers only", "Department ID", 0);
						}
						else if(id > 0) {
							utils.Specialization s = (utils.Specialization)comboBoxSpecialization.getSelectedItem();
								Department d = new Department(txtDepartmentID.getText(), s);
								if(! (Main.hotel.getAllDepartments().containsKey(d.getDepartmentId()))) {
									if(Main.hotel.addDepartment(d) == true) { // if department was added successfully
										JOptionPane.showInternalMessageDialog(null,"Department successfully added to the hotel!");
									}
									else
										JOptionPane.showInternalMessageDialog(null,"Department did *NOT* added to the hotel!");
								}
								else // if department already exists
									JOptionPane.showInternalMessageDialog(null,"Department already exists!");
							}
					}
				}
				catch(EmptyException ex) {
					JOptionPane.showInternalMessageDialog(null,ex.getMessage());
				}
			}
		});
		btnAddDepartment.setFont(new Font("Segoe UI", Font.BOLD, 18));
		btnAddDepartment.setBackground(new Color(162, 170, 132));
		btnAddDepartment.setBounds(10, 388, 268, 73);
		btnAddDepartment.setFocusable(false);
		rightPanel_addDepartment.add(btnAddDepartment);

	}

}
