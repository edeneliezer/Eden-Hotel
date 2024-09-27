// @author Eden Eliezer ID 207188038
package view;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Insets;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;
import java.util.HashMap;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JSpinner;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SpinnerNumberModel;
import javax.swing.SwingConstants;
import javax.swing.border.EtchedBorder;

import com.toedter.calendar.JYearChooser;

import model.Department;
import model.DepartmentManager;
import model.Employee;
import model.Hotel;
import Exceptions.EmptyException;
import Exceptions.LettersOnlyException;
import Exceptions.NumbersOnlyException;
import Exceptions.PersonAlreadyExistException;
import utils.Area;
import utils.Gender;

public class AddEmployee extends JInternalFrame {

	private JTextField txtUsername;
	private JPasswordField pwdPassword;
	// to save user names and passwords of employees
	public static HashMap<String,String> security = new HashMap<>(); 
	Object[] s;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AddEmployee frame = new AddEmployee();
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
	public AddEmployee() {
		// adding and setting all components and texts
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 10, 10);
		getContentPane().add(panel);
		panel.setLayout(null);
		
		setBounds(100, 100, 800, 501);
		panel.setBackground(new Color(255, 255, 255));
		panel.setLayout(null);
		
		JPanel leftPanel = new JPanel();
		leftPanel.setBounds(0, 0, 500, 472);
		panel.add(leftPanel);
		leftPanel.setLayout(null);
		
		JLabel leftIcon_addEmployee = new JLabel("");
		leftIcon_addEmployee.setVerticalAlignment(SwingConstants.TOP);
		leftIcon_addEmployee.setIcon(new ImageIcon(AddBooking.class.getResource("/gui_icons/employeeANDmanager.png")));
		leftIcon_addEmployee.setBounds(0, 0, 500, 472);
		leftPanel.add(leftIcon_addEmployee);
		
		JPanel rightPanel_addEmployee = new JPanel();
		rightPanel_addEmployee.setBackground(SystemColor.menu);
		rightPanel_addEmployee.setBounds(501, 0, 288, 472);
		panel.add(rightPanel_addEmployee);
		rightPanel_addEmployee.setLayout(null);
		
		JLabel lblEmployeeID = new JLabel("Employee ID");
		lblEmployeeID.setVerticalAlignment(SwingConstants.TOP);
		lblEmployeeID.setFont(new Font("Segoe UI", Font.BOLD, 16));
		lblEmployeeID.setBounds(12, 93, 132, 23);
		rightPanel_addEmployee.add(lblEmployeeID);
		
		JLabel lblFirstName = new JLabel("First Name");
		lblFirstName.setFont(new Font("Segoe UI", Font.BOLD, 16));
		lblFirstName.setBounds(12, 146, 132, 22);
		rightPanel_addEmployee.add(lblFirstName);
		
		JLabel lblLastName = new JLabel("Last Name");
		lblLastName.setFont(new Font("Segoe UI", Font.BOLD, 16));
		lblLastName.setBounds(12, 198, 132, 22);
		rightPanel_addEmployee.add(lblLastName);
		
		JLabel lblPhoneNumber = new JLabel("Phone Number");
		lblPhoneNumber.setFont(new Font("Segoe UI", Font.BOLD, 16));
		lblPhoneNumber.setBounds(12, 249, 132, 22);
		rightPanel_addEmployee.add(lblPhoneNumber);
		LocalDate today = LocalDate.now();
		Date now = Date.from(today.atStartOfDay(ZoneId.systemDefault()).toInstant());
		
		JLabel lblAddEmployee = new JLabel("Add Employee");
		lblAddEmployee.setBackground(new Color(177, 207, 199));
		lblAddEmployee.setForeground(new Color(255, 255, 255));
		lblAddEmployee.setHorizontalAlignment(SwingConstants.CENTER);
		lblAddEmployee.setFont(new Font("Segoe UI", Font.BOLD, 16));
		lblAddEmployee.setBounds(10, 0, 268, 29);
		rightPanel_addEmployee.add(lblAddEmployee);
		
		JPanel headline = new JPanel();
		headline.setBackground(new Color(162, 170, 132));
		headline.setBounds(0, 0, 290, 29);
		rightPanel_addEmployee.add(headline);
		headline.setLayout(null);
		
		// setting combo box options
		JComboBox comboBoxArea = new JComboBox(utils.Area.values());
		comboBoxArea.setBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(162, 170, 132), new Color(177, 207, 199)));
		comboBoxArea.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 14));
		comboBoxArea.setBounds(12, 316, 125, 25);
		rightPanel_addEmployee.add(comboBoxArea);
		
		JTextArea txtID = new JTextArea();
		txtID.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		txtID.setBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(162, 170, 132), new Color(177, 207, 199)));
		txtID.setBounds(10, 113, 125, 25);
		rightPanel_addEmployee.add(txtID);
		
		JTextArea txtFirstName = new JTextArea();
		txtFirstName.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		txtFirstName.setBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(162, 170, 132), new Color(177, 207, 199)));
		txtFirstName.setBounds(10, 167, 125, 25);
		rightPanel_addEmployee.add(txtFirstName);
		
		JTextArea txtLastName = new JTextArea();
		txtLastName.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		txtLastName.setBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(162, 170, 132), new Color(177, 207, 199)));
		txtLastName.setBounds(10, 217, 125, 25);
		rightPanel_addEmployee.add(txtLastName);
		
		JTextArea txtPhoneNum = new JTextArea();
		txtPhoneNum.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		txtPhoneNum.setBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(162, 170, 132), new Color(177, 207, 199)));
		txtPhoneNum.setBounds(12, 270, 125, 25);
		rightPanel_addEmployee.add(txtPhoneNum);
		
		JLabel lblGender = new JLabel("Gender");
		lblGender.setFont(new Font("Segoe UI", Font.BOLD, 16));
		lblGender.setBounds(12, 346, 132, 22);
		rightPanel_addEmployee.add(lblGender);
		
		JLabel lblArea = new JLabel("Area");
		lblArea.setFont(new Font("Segoe UI", Font.BOLD, 16));
		lblArea.setBounds(12, 295, 132, 22);
		rightPanel_addEmployee.add(lblArea);
		
		// setting combo box options
		JComboBox comboBoxGender = new JComboBox(utils.Gender.values());
		comboBoxGender.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 14));
		comboBoxGender.setBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(162, 170, 132), new Color(177, 207, 199)));
		comboBoxGender.setBounds(12, 366, 125, 25);
		rightPanel_addEmployee.add(comboBoxGender);
		
		JLabel lblYearOfBirth = new JLabel("  Year of Birth");
		lblYearOfBirth.setVerticalAlignment(SwingConstants.TOP);
		lblYearOfBirth.setFont(new Font("Segoe UI", Font.BOLD, 16));
		lblYearOfBirth.setBounds(154, 40, 112, 22);
		rightPanel_addEmployee.add(lblYearOfBirth);
		
		JYearChooser yearChooser = new JYearChooser();
		yearChooser.setMaximum(2023);
		yearChooser.getSpinner().setFont(new Font("Segoe UI", Font.PLAIN, 14));
		yearChooser.setBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(162, 170, 132), new Color(177, 207, 199)));
		yearChooser.setEndYear(2023);
		yearChooser.setBounds(160, 60, 118, 25);
		rightPanel_addEmployee.add(yearChooser);
		
		JLabel lblStartOfWork = new JLabel(" Start of Work");
		lblStartOfWork.setFont(new Font("Segoe UI", Font.BOLD, 16));
		lblStartOfWork.setBounds(160, 93, 112, 22);
		rightPanel_addEmployee.add(lblStartOfWork);
		
		JSpinner spinnerSalary = new JSpinner();
		spinnerSalary.setModel(new SpinnerNumberModel(Double.valueOf(0), Double.valueOf(0), null, Double.valueOf(1)));
		spinnerSalary.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 14));
		spinnerSalary.setBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(162, 170, 132), new Color(177, 207, 199)));
		spinnerSalary.setBounds(160, 164, 118, 25);
		rightPanel_addEmployee.add(spinnerSalary);
		
		JLabel lblSalary = new JLabel("  Salary");
		lblSalary.setFont(new Font("Segoe UI", Font.BOLD, 16));
		lblSalary.setBounds(154, 145, 115, 22);
		rightPanel_addEmployee.add(lblSalary);
		
		JLabel lblDepartment = new JLabel("Department ID");
		lblDepartment.setVerticalAlignment(SwingConstants.TOP);
		lblDepartment.setFont(new Font("Segoe UI", Font.BOLD, 16));
		lblDepartment.setBounds(160, 197, 120, 23);
		rightPanel_addEmployee.add(lblDepartment);
		
		JYearChooser yearChooserStartOfWork = new JYearChooser();
		yearChooserStartOfWork.getSpinner().setFont(new Font("Segoe UI", Font.PLAIN, 14));
		yearChooserStartOfWork.setMaximum(2023);
		yearChooserStartOfWork.setEndYear(2023);
		yearChooserStartOfWork.setBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(162, 170, 132), new Color(177, 207, 199)));
		yearChooserStartOfWork.setBounds(160, 114, 118, 25);
		rightPanel_addEmployee.add(yearChooserStartOfWork);
		
		// setting combo box options
		JComboBox comboBoxIsManager = new JComboBox(new String[] {"No","Yes"});
		comboBoxIsManager.setFont(new Font("Segoe UI", Font.BOLD, 14));
		comboBoxIsManager.setBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(162, 170, 132), new Color(177, 207, 199)));
		comboBoxIsManager.setBounds(12, 55, 125, 30);
		rightPanel_addEmployee.add(comboBoxIsManager);
		
		JLabel lblIsManager = new JLabel("Is Manager?");
		lblIsManager.setFont(new Font("Segoe UI", Font.BOLD, 16));
		lblIsManager.setBounds(10, 35, 127, 22);
		rightPanel_addEmployee.add(lblIsManager);
		
		JLabel lblBonus = new JLabel("  Bonus");
		lblBonus.setFont(new Font("Segoe UI", Font.BOLD, 16));
		lblBonus.setBounds(154, 249, 115, 22);
		rightPanel_addEmployee.add(lblBonus);
		lblBonus.setVisible(false);
		
		JSpinner spinnerBonus = new JSpinner();
		spinnerBonus.setModel(new SpinnerNumberModel(Double.valueOf(0), Double.valueOf(0), null, Double.valueOf(1)));
		spinnerBonus.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 14));
		spinnerBonus.setBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(162, 170, 132), new Color(177, 207, 199)));
		spinnerBonus.setBounds(160, 268, 118, 25);
		rightPanel_addEmployee.add(spinnerBonus);
		spinnerBonus.setVisible(false);
		
		s = Main.hotel.getAllDepartments().keySet().toArray();
		JComboBox comboBoxDepartmentID = new JComboBox(s);
		comboBoxDepartmentID.setFont(new Font("Segoe UI", Font.BOLD, 14));
		comboBoxDepartmentID.setBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(162, 170, 132), new Color(177, 207, 199)));
		comboBoxDepartmentID.setBounds(160, 217, 118, 25);
		rightPanel_addEmployee.add(comboBoxDepartmentID);
		
		txtUsername = new JTextField();
		txtUsername.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) { // if written Username, then make it empty
				if(txtUsername.getText().equals(" Username"))
					txtUsername.setText("");
				else
					txtUsername.selectAll();
			}
			@Override
			public void focusLost(FocusEvent e) { // if empty write "Username"
				if(txtUsername.getText().equals(""))
					txtUsername.setText(" Username");
			}
		});
		txtUsername.setText(" Username");
		txtUsername.setFont(new Font("Segoe UI Variable", Font.PLAIN, 14));
		txtUsername.setColumns(10);
		txtUsername.setBorder(null);
		txtUsername.setBackground(new Color(199, 214, 211));
		txtUsername.setBounds(160, 338, 114, 25);
		rightPanel_addEmployee.add(txtUsername);
		
		pwdPassword = new JPasswordField();
		pwdPassword.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				if(security.containsKey(txtUsername.getText())) { // in case the user name is used already
					JOptionPane.showInternalMessageDialog(null, "Sorry, username already exists");
				}	
			}
		});
		pwdPassword.setText(" Password");
		pwdPassword.setFont(new Font("Segoe UI Variable", Font.PLAIN, 15));
		pwdPassword.setBorder(null);
		pwdPassword.setBackground(new Color(199, 214, 211));
		pwdPassword.setBounds(160, 367, 114, 25);
		rightPanel_addEmployee.add(pwdPassword);
		
		JLabel lblSecurity = new JLabel("");
		lblSecurity.setIcon(new ImageIcon(AddEmployee.class.getResource("/gui_icons/security.png")));
		lblSecurity.setBounds(160, 300, 114, 30);
		rightPanel_addEmployee.add(lblSecurity);
		
		JButton btnAddEmployee = new JButton("ADD EMPLOYEE");
		btnAddEmployee.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnAddEmployee.setMargin(new Insets(2, 2, 2, 2));
		btnAddEmployee.setBorderPainted(false);
		btnAddEmployee.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) { // in case add employee button is pressed
				String enteredPassword = new String(pwdPassword.getPassword());
				if(btnAddEmployee.getText().equals("ADD EMPLOYEE")) { // if employee
					try {
						if(txtID.getText().equals("")) { // if the user didn't enter employee id
							throw new EmptyException();
						}
						else if(txtFirstName.getText().equals("")) { // if user didn't enter first name
							throw new EmptyException();
						}
						else if(txtLastName.getText().equals("")) { // if user didn't enter last name
							throw new EmptyException();
						}
						else if(txtPhoneNum.getText().equals("")) { // if the user didn't enter phone number
							throw new EmptyException();
						}
						else if(comboBoxDepartmentID.getItemCount() == 0) { // if there are no departments
							JOptionPane.showInternalMessageDialog(null,"There are no departments in system");
						}
						else if(!(txtID.getText().matches("\\d+"))) {
							throw new NumbersOnlyException();
						}
						else if(!(txtFirstName.getText().matches("[a-zA-Z]+"))) {
							throw new LettersOnlyException();
						}
						else if(!(txtLastName.getText().matches("[a-zA-Z]+"))) {
							throw new LettersOnlyException();
						}
						else if(!(txtPhoneNum.getText().matches("\\d+"))) {
							throw new NumbersOnlyException();
						}
						else { // if user entered everything
							Gender g = (Gender) comboBoxGender.getSelectedItem();
							Area a = (Area) comboBoxArea.getSelectedItem();
							Department d = Main.hotel.getAllDepartments().get(String.valueOf(comboBoxDepartmentID.getSelectedItem()));
							Employee emp = new Employee(txtID.getText(), txtFirstName.getText(), txtLastName.getText(), txtPhoneNum.getText(),
										a, g, yearChooser.getValue(), (int)yearChooserStartOfWork.getValue(), (double)spinnerSalary.getValue(), d);
							try {
								if(! (Main.hotel.getAllEmployees().containsKey(emp.getId()))) { 
									try { //if admin didn't enter user name or password
										if(txtUsername.getText().equals("") || txtUsername.getText().equals(" Username") || enteredPassword.equals("") || enteredPassword.equals(" Password")) {
											throw new EmptyException();
										}
									}
									catch(EmptyException emptyField){ 
										JOptionPane.showInternalMessageDialog(null,emptyField.getMessage());
										return;
									}
									if(Main.hotel.addEmployee(emp) == true) { // if employee was added successfully 
										JOptionPane.showInternalMessageDialog(null,"Employee successfully added to the hotel!");
										security.put(txtUsername.getText(),enteredPassword); // add user name and password to hashmap
										emp.setUsername(txtUsername.getText()); // set user name of employee
									}
									else
										JOptionPane.showInternalMessageDialog(null,"Employee did *NOT* added to the hotel!");
								}
								else
									throw new PersonAlreadyExistException("","Person");
							} catch (PersonAlreadyExistException person) { // if employee already exist
								// TODO Auto-generated catch block
								JOptionPane.showInternalMessageDialog(null,person.getMessage());
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
				else if(btnAddEmployee.getText().equals("ADD DEPARTMENT MANAGER")) { // if dep manager
					try {
						if(txtID.getText().equals("")) { // if the user didn't enter dep manager id
							throw new EmptyException();
						}
						else if(txtFirstName.getText().equals("")) { // if user didn't enter first name
							throw new EmptyException();
						}
						else if(txtLastName.getText().equals("")) { // if user didn't enter last name
							throw new EmptyException();
						}
						else if(txtPhoneNum.getText().equals("")) { // if the user didn't enter phone number
							throw new EmptyException();
						}
						else if(comboBoxDepartmentID.getItemCount() == 0) { // if there are no departments
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
						else { // if user entered everything
							Gender g = (Gender) comboBoxGender.getSelectedItem();
							Area a = (Area) comboBoxArea.getSelectedItem();
							Department d = Main.hotel.getAllDepartments().get(String.valueOf(comboBoxDepartmentID.getSelectedItem()));
							DepartmentManager dm = new DepartmentManager(txtID.getText(), txtFirstName.getText(), txtLastName.getText(), txtPhoneNum.getText(),
										a, g, yearChooser.getValue(), (int)yearChooserStartOfWork.getValue(), (double)spinnerSalary.getValue(), d, (double)spinnerBonus.getValue());
							try {
								if(! (Main.hotel.getAllEmployees().containsKey(dm.getId()))) {
										try { //if admin didn't enter user name or password
											if(txtUsername.getText().equals("") || txtUsername.getText().equals(" Username")  || enteredPassword.equals(" Password")) {
												throw new EmptyException();
											}
										}
										catch(EmptyException emptyField){
											JOptionPane.showInternalMessageDialog(null,emptyField.getMessage());
											return;
										}
										if(Main.hotel.addDepartmentManager(dm) == true){ // if dep manager was added successfully 
											security.put(txtUsername.getText(),enteredPassword); // add user name and password to hashmap
											dm.setUsername(txtUsername.getText()); // set user name of dep manager
											JOptionPane.showInternalMessageDialog(null,"Department Manager successfully added to the hotel!");
										}
										else
											JOptionPane.showInternalMessageDialog(null,"Department Manager did *NOT* added to the hotel!");
								}
								else
									throw new PersonAlreadyExistException("","Person");
							}
							catch(PersonAlreadyExistException person) { // if sep manager already exist
								JOptionPane.showInternalMessageDialog(null,person.getMessage());
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
		});
		btnAddEmployee.setFont(new Font("Segoe UI", Font.BOLD, 18));
		btnAddEmployee.setBackground(new Color(162, 170, 132));
		btnAddEmployee.setBounds(10, 400, 268, 65);
		btnAddEmployee.setFocusable(false);
		rightPanel_addEmployee.add(btnAddEmployee);
		
		
		
		// if user marked dep manager box then show bonus component and all relevant components and texts
		comboBoxIsManager.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String yesNo = String.valueOf(comboBoxIsManager.getSelectedItem());
				if(yesNo.equals("Yes")) {
					lblEmployeeID.setText("Manager ID");
					lblBonus.setVisible(true);
					spinnerBonus.setVisible(true);
					lblAddEmployee.setText("Add Department Manager");
					btnAddEmployee.setText("ADD DEPARTMENT MANAGER");
					btnAddEmployee.setFont(new Font("Segoe UI", Font.BOLD, 16));
				}
				else {
					lblEmployeeID.setText("Employee ID");
					lblBonus.setVisible(false);
					spinnerBonus.setVisible(false);
					lblAddEmployee.setText("Add Employee");
					btnAddEmployee.setText("ADD EMPLOYEE");
					btnAddEmployee.setFont(new Font("Segoe UI", Font.BOLD, 18));
				}
			}
		});
		

	}
}
