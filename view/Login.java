// @author Eden Eliezer ID 207188038
package view;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.IOException;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;


public class Login extends JFrame {

	JPanel contentPane;
	
	Image two = new ImageIcon(Login.class.getResource("/gui_icons/UserNameLogo.png")).getImage().getScaledInstance(30, 30, Image.SCALE_SMOOTH);
	Image three = new ImageIcon(Login.class.getResource("/gui_icons/EDEN HOTEL.png")).getImage().getScaledInstance(486, 363, Image.SCALE_SMOOTH);
	
	JTextField txtUsername;
	JPasswordField txtPassword;
	JPanel LoginPassword;
	JLabel UsernameIcon;
	JLabel PasswordIcon;
	JLabel LoginWelcome;
	JLabel loginMessage;
	JButton btnLogIn;
	static int i = 0; // a flag in order to know if an admin was logged in or an employee

	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login frame = new Login();
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
	public Login() {
		// adding and setting all components and texts
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 496, 394);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel LoginUsername = new JPanel();
		LoginUsername.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		LoginUsername.setBackground(new Color(217, 185, 132));
		LoginUsername.setBounds(130, 179, 230, 45);
		contentPane.add(LoginUsername);
		LoginUsername.setLayout(null);
		
		txtUsername = new JTextField();
		txtUsername.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				if(txtUsername.getText().equals("Username"))
					txtUsername.setText("");
				else
					txtUsername.selectAll();
			}
			@Override
			public void focusLost(FocusEvent e) {
				if(txtUsername.getText().equals(""))
					txtUsername.setText("Username");
			}
		});
		txtUsername.setBorder(null);
		txtUsername.setText("Username");
		txtUsername.setFont(new Font("Segoe UI Semilight", Font.BOLD | Font.ITALIC, 14));
		txtUsername.setBackground(new Color(217, 185, 132));
		txtUsername.setBounds(10, 11, 160, 25);
		LoginUsername.add(txtUsername);
		txtUsername.setColumns(10);
		
		UsernameIcon = new JLabel("");
		UsernameIcon.setBounds(190, 6, 30, 30);
		LoginUsername.add(UsernameIcon);
		UsernameIcon.setIcon(new ImageIcon(two));
		
		LoginPassword = new JPanel();
		LoginPassword.setLayout(null);
		LoginPassword.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		LoginPassword.setBackground(new Color(217, 185, 132));
		LoginPassword.setBounds(130, 226, 230, 45);
		contentPane.add(LoginPassword);
		
		// when pressing 'enter' it will do the same as if the mouse was clicked on login button
		KeyAdapter keyAdapter = new KeyAdapter() {  
			@Override
			public void keyPressed(KeyEvent e) {
				if(e.getKeyCode() == KeyEvent.VK_ENTER) {
					String password = new String(txtPassword.getPassword());
					// if it's admin open admin page, if employee then open employee page
					//showing messages if user details are incorrect
					if(txtUsername.getText().equals("admin") && password.equals("admin")) { // if admin user name and password correct
						i = 1;
						// adding 'welcome' sound
						File bookSound = new File("src/gui_sounds/welcome.wav");
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
						}
						Login.this.dispose();
						AdminMenu adminMenu = new AdminMenu();
						adminMenu.setVisible(true);
					}
					else if((txtUsername.getText().equals("admin") && ! (password.equals("admin")))) {
						i = 0; // if password incorrect
						JOptionPane.showInternalMessageDialog(null, "Password is incorrect, try again");
					}
					else if(AddEmployee.security.containsKey(txtUsername.getText()) && AddEmployee.security.containsValue(password)) {
						i = 0; // if employee enters correct user name and password
						File bookSound = new File("src/gui_sounds/welcome.wav");
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
						}
						JOptionPane.showInternalMessageDialog(null, "Welcome " + txtUsername.getText() + "!!!");
						Login.this.dispose();
						EmployeeMenu employeeMenu = new EmployeeMenu();
						employeeMenu.setVisible(true);
					}
					else if(! (AddEmployee.security.containsKey(txtUsername.getText()))) { // if empty or no user name
						i = 0;
						JOptionPane.showInternalMessageDialog(null, "Sorry, there is no such username in the system");
					}
					else if(AddEmployee.security.containsKey(txtUsername.getText()) && !(AddEmployee.security.containsValue(password))) {
						i = 0; // if empty or no password
						JOptionPane.showInternalMessageDialog(null, "Password is incorrect, try again");
					}
				}
			}
		};
		
		txtPassword = new JPasswordField();
		txtPassword.addKeyListener(keyAdapter); 
		txtPassword.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				String enteredPassword = new String(txtPassword.getPassword());
				if(enteredPassword.equals("Password")) {
					txtPassword.setEchoChar('●'); // hide the digits because it's password
					txtPassword.setText("");
				}
				else
					txtPassword.selectAll();
				
			}
			@Override
			public void focusLost(FocusEvent e) {
				String enteredPassword = new String(txtPassword.getPassword());
				if(enteredPassword.equals("")) {
					txtPassword.setText("Password");
					txtPassword.setEchoChar((char)0);
				}
			}
		});
		txtPassword.setEchoChar((char)0); 
		txtPassword.setBounds(10, 11, 160, 25);
		LoginPassword.add(txtPassword);
		txtPassword.setText("Password");
		txtPassword.setBorder(null);
		txtPassword.setFont(new Font("Segoe UI Semibold", Font.BOLD, 16));
		txtPassword.setBackground(new Color(217, 185, 132));
		
		PasswordIcon = new JLabel("");
		PasswordIcon.setBounds(190, 6, 30, 32);
		LoginPassword.add(PasswordIcon);
		PasswordIcon.setIcon(new ImageIcon(Login.class.getResource("/gui_icons/PasswordLogo.png")));
		
		loginMessage = new JLabel("");
		loginMessage.setBackground(new Color(217, 185, 132));
		loginMessage.setFont(new Font("Tahoma", Font.PLAIN, 12));
		loginMessage.setForeground(new Color(255, 255, 255));
		loginMessage.setBounds(130, 271, 256, 33);
		contentPane.add(loginMessage);
		
		// everything is same as key adaptor
		btnLogIn = new JButton("LOG  IN");
		btnLogIn.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnLogIn.addKeyListener(keyAdapter);
		btnLogIn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			String password = new String(txtPassword.getPassword());
				if(txtUsername.getText().equals("admin") && password.equals("admin")) {
					i = 1;
					File bookSound = new File("src/gui_sounds/welcome.wav");
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
					}

					Login.this.dispose();
					AdminMenu adminMenu = new AdminMenu();
					adminMenu.setVisible(true);
				}
				else if((txtUsername.getText().equals("admin") && ! (password.equals("admin")))) {
					i = 0;
					JOptionPane.showInternalMessageDialog(null, "Password is incorrect, try again");
				}
				else if(AddEmployee.security.containsKey(txtUsername.getText()) && AddEmployee.security.containsValue(password)) {
					i = 0;
					JOptionPane.showInternalMessageDialog(null, "Welcome " + txtUsername.getText() + "!!!");
					Login.this.dispose();
					EmployeeMenu employeeMenu = new EmployeeMenu();
					employeeMenu.setVisible(true);
				}
				else if(! (AddEmployee.security.containsKey(txtUsername.getText()))) {
					i = 0;
					JOptionPane.showInternalMessageDialog(null, "Sorry, there is no such username in the system");
				}
				else if(AddEmployee.security.containsKey(txtUsername.getText()) && !(AddEmployee.security.containsValue(password))) {
					i = 0;
					JOptionPane.showInternalMessageDialog(null, "Password is incorrect, try again");
				}
			}
		});
		btnLogIn.setBorderPainted(false);
		btnLogIn.setForeground(new Color(255, 255, 255));
		btnLogIn.setFont(new Font("Verdana", Font.BOLD, 22));
		btnLogIn.setBackground(new Color(217, 185, 132));
		btnLogIn.setBounds(130, 296, 230, 56);
		btnLogIn.setFocusable(false);
		contentPane.add(btnLogIn);
		
		LoginWelcome = new JLabel("");
		LoginWelcome.setIcon(new ImageIcon(three));
		LoginWelcome.setBounds(0, 0, 486, 363);
		contentPane.add(LoginWelcome);
	}

}
