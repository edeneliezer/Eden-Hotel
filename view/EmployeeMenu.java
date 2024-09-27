// @author Eden Eliezer ID 207188038
package view;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;


import javax.swing.JLayeredPane;
import java.awt.CardLayout;
import java.awt.Color;

import javax.swing.JLabel;
import javax.swing.JToolBar;
import javax.swing.JButton;
import java.awt.Cursor;
import java.awt.Insets;
import javax.swing.border.LineBorder;

import model.Hotel;

import javax.swing.JMenuBar;
import javax.swing.JMenu;
import java.awt.Rectangle;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JComboBox;
import java.awt.Dimension;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class EmployeeMenu extends JFrame {

	JPanel contentPane;
	final JLayeredPane layeredPane = new JLayeredPane();
	
	// creating a video
	Image video = new ImageIcon(EmployeeMenu.class.getResource("/gui_icons/Animation3.gif")).getImage().getScaledInstance(786, 467, DO_NOTHING_ON_CLOSE);

	JMenuItem menuAddEmployee;
	JMenuItem menuRemove;
	
	AddDepartment addDepartment;
	AddBooking addBooking;
	AddCustomer addCustomer;
	AddEmployee addEmployee;
	AddStandardRoom addStandardRoom;
	AddSuperiorRoom addSuperiorRoom;
	AddSuite addSuite;
	GetReal getReal;
	Remove remove;
	
	public static int more = 0, rt = 0; // flags in order to recognize which button was pressed
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					EmployeeMenu frame = new EmployeeMenu();
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
	public EmployeeMenu() {
		// adding and setting all components and texts
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 800, 550);
		
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(null);

		setContentPane(contentPane);
		layeredPane.setBounds(0, 0, 786, 467);
		contentPane.add(layeredPane);
		layeredPane.setLayout(new CardLayout(0, 0));
		
		JPanel panelHome = new JPanel();
		layeredPane.add(panelHome, "name_13610896081800");
		panelHome.setLayout(null);
		
		JLabel lblHome = new JLabel("");
		lblHome.setBounds(0, 0, 786, 467);
		lblHome.setIcon(new ImageIcon(video));
		panelHome.add(lblHome);
		
		JLabel txtWelcome = new JLabel("Welcome!");
		txtWelcome.setForeground(new Color(122, 74, 46));
		txtWelcome.setHorizontalAlignment(SwingConstants.CENTER);
		txtWelcome.setBounds(0, 380, 786, 35);
		txtWelcome.setFont(new Font("Segoe UI Black", Font.PLAIN, 25));
		lblHome.add(txtWelcome);
		
		JLabel txtWhatWouldYouLikeToDo = new JLabel("what would you like to do?");
		txtWhatWouldYouLikeToDo.setHorizontalAlignment(SwingConstants.CENTER);
		txtWhatWouldYouLikeToDo.setBounds(0, 415, 786, 27);
		txtWhatWouldYouLikeToDo.setFont(new Font("Segoe UI", Font.BOLD, 20));
		lblHome.add(txtWhatWouldYouLikeToDo);
		
		JMenuBar menuBar = new JMenuBar();
		menuBar.setPreferredSize(new Dimension(0, 46));
		setJMenuBar(menuBar);
		
		JMenu menuFile = new JMenu("FILE");
		menuFile.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		menuFile.setFont(new Font("Segoe UI Black", Font.PLAIN, 18));
		menuFile.setForeground(new Color(211, 174, 112));
		menuBar.add(menuFile);
		
		JButton menuSave = new JButton("SAVE");
		menuSave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Main.saveMyHotel();
			}
		});
		menuSave.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		menuSave.setMaximumSize(new Dimension(85, 23));
		menuSave.setHorizontalTextPosition(SwingConstants.CENTER);
		menuSave.setMargin(new Insets(2, 5, 2, 5));
		menuSave.setPreferredSize(new Dimension(85, 23));
		menuSave.setForeground(Color.BLACK);
		menuSave.setFont(new Font("Segoe UI", Font.BOLD, 14));
		menuSave.setFocusable(false);
		menuSave.setBackground(new Color(255, 255, 255));
		menuFile.add(menuSave);
		
		JButton menuLogOut = new JButton("LOG OUT");
		menuLogOut.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// pop-up question before exit, if yes then log out and open new login screen
				if(JOptionPane.showConfirmDialog(menuLogOut, "Did you save all your changes?", "Bye Bye!", JOptionPane.YES_NO_OPTION) == 0) {
					EmployeeMenu.this.dispose();
					Login login = new Login();
					login.setVisible(true);
				}
			}
		});
		menuLogOut.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		menuLogOut.setMaximumSize(new Dimension(85, 23));
		menuLogOut.setMargin(new Insets(2, 2, 2, 2));
		menuLogOut.setPreferredSize(new Dimension(85, 23));
		menuLogOut.setForeground(Color.BLACK);
		menuLogOut.setFont(new Font("Segoe UI", Font.BOLD, 13));
		menuLogOut.setFocusable(false);
		menuLogOut.setBackground(Color.WHITE);
		menuFile.add(menuLogOut);
		
		// when pressing word file, 'allbookingsprofit' doc will be created
		JButton menuWordFile = new JButton("WORD FILE");
		menuWordFile.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AllBookingsProfitToWord.main(null);
			}
		});
		menuWordFile.setPreferredSize(new Dimension(85, 23));
		menuWordFile.setMaximumSize(new Dimension(85, 23));
		menuWordFile.setMargin(new Insets(2, 2, 2, 2));
		menuWordFile.setForeground(Color.BLACK);
		menuWordFile.setFont(new Font("Segoe UI", Font.BOLD, 13));
		menuWordFile.setFocusable(false);
		menuWordFile.setBackground(Color.WHITE);
		menuFile.add(menuWordFile);
		
		// when pressing home, it will show home page
		JMenuItem menuHome = new JMenuItem("HOME ");
		menuHome.setBorder(new LineBorder(new Color(223, 222, 224)));
		menuHome.setBorderPainted(true);
		menuHome.setOpaque(true);
		menuHome.setBackground(new Color(215, 182, 125));
		menuHome.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				layeredPane.removeAll();
				layeredPane.add(panelHome);
				layeredPane.repaint();
				layeredPane.revalidate();
				
			}
		});
		menuHome.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		menuHome.setIcon(new ImageIcon(EmployeeMenu.class.getResource("/gui_icons/HomeLogo.png")));
		menuHome.setFont(new Font("Segoe UI Black", Font.PLAIN, 18));
		menuHome.setForeground(new Color(0, 0, 0));
		menuHome.setBounds(new Rectangle(0, 0, 85, 46));
		menuHome.setSize(new Dimension(85, 46));
		menuHome.setPreferredSize(new Dimension(85, 27));
		menuBar.add(menuHome);
		
		// when pressing add, it will show add options
		JMenu menuAdd = new JMenu("ADD");
		menuAdd.setBorder(new LineBorder(new Color(223, 222, 224)));
		menuAdd.setBorderPainted(true);
		menuAdd.setOpaque(true);
		menuAdd.setBackground(new Color(215, 182, 125));
		menuAdd.setIcon(new ImageIcon(EmployeeMenu.class.getResource("/gui_icons/AddLogo.png")));
		menuAdd.setFont(new Font("Segoe UI Black", Font.PLAIN, 18));
		menuAdd.setForeground(new Color(0, 0, 0));
		menuAdd.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		menuAdd.setPreferredSize(new Dimension(150, 46));
		menuAdd.setBounds(new Rectangle(0, 0, 150, 46));
		menuBar.add(menuAdd);
		
		// when pressing add department, it will show add department page
		JMenuItem menuAddDepartment = new JMenuItem("Department");
		menuAddDepartment.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				layeredPane.removeAll();
				addDepartment = new AddDepartment();
				layeredPane.add(addDepartment.getContentPane());
				layeredPane.repaint();
				layeredPane.revalidate();
			}
		});
		menuAddDepartment.setFont(new Font("Segoe UI Black", Font.PLAIN, 12));
		menuAddDepartment.setForeground(new Color(0, 0, 0));
		menuAddDepartment.setPreferredSize(new Dimension(150, 27));
		menuAdd.add(menuAddDepartment);
		
		// when pressing add booking, it will show add booking page
		JMenuItem menuAddBooking = new JMenuItem("Booking");
		menuAddBooking.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				layeredPane.removeAll();
				addBooking = new AddBooking();
				layeredPane.add(addBooking.getContentPane());
				layeredPane.repaint();
				layeredPane.revalidate();
			}
		});
		menuAddBooking.setPreferredSize(new Dimension(150, 27));
		menuAddBooking.setForeground(Color.BLACK);
		menuAddBooking.setFont(new Font("Segoe UI Black", Font.PLAIN, 12));
		menuAdd.add(menuAddBooking);
		
		//when pressing add customer, it will show add customer page
		JMenuItem menuAddCustomer = new JMenuItem("Customer");
		menuAddCustomer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				layeredPane.removeAll();
				addCustomer = new AddCustomer();
				layeredPane.add(addCustomer.getContentPane());
				layeredPane.repaint();
				layeredPane.revalidate();
			}
		});
		menuAddCustomer.setPreferredSize(new Dimension(150, 27));
		menuAddCustomer.setForeground(Color.BLACK);
		menuAddCustomer.setFont(new Font("Segoe UI Black", Font.PLAIN, 12));
		menuAdd.add(menuAddCustomer);
		
		//when pressing add employee, it will show add employee page
		menuAddEmployee = new JMenuItem("Employee");
		menuAddEmployee.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				layeredPane.removeAll();
				addEmployee = new AddEmployee();
				layeredPane.add(addEmployee.getContentPane());
				layeredPane.repaint();
				layeredPane.revalidate();
			}
		});
		menuAddEmployee.setPreferredSize(new Dimension(150, 27));
		menuAddEmployee.setForeground(Color.BLACK);
		menuAddEmployee.setFont(new Font("Segoe UI Black", Font.PLAIN, 12));
		menuAdd.add(menuAddEmployee);
		
		// when pressing room, it will open room types list
		JMenu menuAddRoom = new JMenu("Room");
		menuAddRoom.setFont(new Font("Segoe UI Black", Font.PLAIN, 12));
		menuAdd.add(menuAddRoom);
		
		//when pressing add standard, it will show add standard room page
		JMenuItem menuAddStandard = new JMenuItem("Standard");
		menuAddStandard.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				rt = 1;
				layeredPane.removeAll();
				addStandardRoom = new AddStandardRoom();
				layeredPane.add(addStandardRoom.getContentPane());
				layeredPane.repaint();
				layeredPane.revalidate();
			}
		});
		menuAddStandard.setPreferredSize(new Dimension(150, 27));
		menuAddStandard.setForeground(Color.BLACK);
		menuAddStandard.setFont(new Font("Segoe UI Black", Font.PLAIN, 12));
		menuAddRoom.add(menuAddStandard);
		
		//when pressing add superior, it will show add superior room page
		JMenuItem menuAddSuperior = new JMenuItem("Superior");
		menuAddSuperior.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				rt = 2;
				layeredPane.removeAll();
				addSuperiorRoom = new AddSuperiorRoom();
				layeredPane.add(addSuperiorRoom.getContentPane());
				layeredPane.repaint();
				layeredPane.revalidate();
			}
		});
		menuAddSuperior.setPreferredSize(new Dimension(150, 27));
		menuAddSuperior.setForeground(Color.BLACK);
		menuAddSuperior.setFont(new Font("Segoe UI Black", Font.PLAIN, 12));
		menuAddRoom.add(menuAddSuperior);
		
		//when pressing add suite, it will show add suite page
		JMenuItem menuAddSuite = new JMenuItem("Suite");
		menuAddSuite.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				rt = 3;
				layeredPane.removeAll();
				addSuite = new AddSuite();
				layeredPane.add(addSuite.getContentPane());
				layeredPane.repaint();
				layeredPane.revalidate();
			}
		});
		menuAddSuite.setPreferredSize(new Dimension(150, 27));
		menuAddSuite.setForeground(Color.BLACK);
		menuAddSuite.setFont(new Font("Segoe UI Black", Font.PLAIN, 12));
		menuAddRoom.add(menuAddSuite);
		menuAddEmployee.setVisible(false);
		
		// when pressing remove, it will show remove screen
		//if it's admin it will include all options, otherwise won't show remove employee
		menuRemove = new JMenuItem("REMOVE");
		menuRemove.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		menuRemove.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				layeredPane.removeAll();
				remove = new Remove();
				if(Login.i == 1) {
					remove.panelBtns2.setVisible(true);
				}
				layeredPane.add(remove.getContentPane());
				layeredPane.repaint();
				layeredPane.revalidate();
			}
		});
		menuRemove.setBorder(new LineBorder(new Color(223, 222, 224)));
		menuRemove.setBorderPainted(true);
		menuRemove.setOpaque(true);
		menuRemove.setBackground(new Color(215, 182, 125));
		menuRemove.setIcon(new ImageIcon(EmployeeMenu.class.getResource("/gui_icons/RemoveLogo.png")));
		menuRemove.setSize(new Dimension(85, 46));
		menuRemove.setPreferredSize(new Dimension(85, 27));
		menuRemove.setForeground(Color.BLACK);
		menuRemove.setFont(new Font("Segoe UI Black", Font.PLAIN, 18));
		menuRemove.setBounds(new Rectangle(0, 0, 85, 46));
		menuBar.add(menuRemove);
		
		// when pressing more, it will open all query options
		JMenu menuMore = new JMenu("MORE");
		menuMore.setBorder(new LineBorder(new Color(223, 222, 224)));
		menuMore.setBorderPainted(true);
		menuMore.setOpaque(true);
		menuMore.setBackground(new Color(215, 182, 125));
		menuMore.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		menuMore.setForeground(new Color(0, 0, 0));
		menuMore.setIcon(new ImageIcon(EmployeeMenu.class.getResource("/gui_icons/MoreLogo.png")));
		menuMore.setFont(new Font("Segoe UI Black", Font.PLAIN, 18));
		menuMore.setPreferredSize(new Dimension(150, 46));
		menuBar.add(menuMore);
		
		// when pressing, it will show 'List of 'k' employees' page
		JMenuItem menuMore1 = new JMenuItem("List of 'k' employees");
		menuMore1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				more = 1;
				Queries query1 = new Queries();
				layeredPane.removeAll();
				layeredPane.add(query1.getContentPane());
				layeredPane.repaint();
				layeredPane.revalidate();
			}
		});
		menuMore1.setFont(new Font("Segoe UI Black", Font.PLAIN, 12));
		menuMore.add(menuMore1);
		
		// when pressing, it will show 'All customers by PK' page
		JMenuItem menuMore2 = new JMenuItem("All customers by PK");
		menuMore2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				more = 2;
				Queries query2 = new Queries();
				layeredPane.removeAll();
				layeredPane.add(query2.getContentPane());
				layeredPane.repaint();
				layeredPane.revalidate();
			}
		});
		menuMore2.setFont(new Font("Segoe UI Black", Font.PLAIN, 12));
		menuMore.add(menuMore2);
		
		// when pressing, it will show 'All bookings by revenue' page
		JMenuItem menuMore3 = new JMenuItem("All bookings by revenue");
		menuMore3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				more = 3;
				Queries query3 = new Queries();
				layeredPane.removeAll();
				layeredPane.add(query3.getContentPane());
				layeredPane.repaint();
				layeredPane.revalidate();
			}
		});
		menuMore3.setFont(new Font("Segoe UI Black", Font.PLAIN, 12));
		menuMore.add(menuMore3);
		
		// when pressing, it will show 'All customers by num of bookings' page
		JMenuItem menuMore4 = new JMenuItem("All customers by num of bookings");
		menuMore4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				more = 4;
				Queries query4 = new Queries();
				layeredPane.removeAll();
				layeredPane.add(query4.getContentPane());
				layeredPane.repaint();
				layeredPane.revalidate();
			}
		});
		menuMore4.setFont(new Font("Segoe UI Black", Font.PLAIN, 12));
		menuMore.add(menuMore4);
		
		// when pressing, it will show 'Total profit' page
		JMenuItem menuMore5 = new JMenuItem("Total profit");
		menuMore5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				more = 5;
				Queries query5 = new Queries();
				layeredPane.removeAll();
				layeredPane.add(query5.getContentPane());
				layeredPane.repaint();
				layeredPane.revalidate();
			}
		});
		menuMore5.setFont(new Font("Segoe UI Black", Font.PLAIN, 12));
		menuMore.add(menuMore5);
		
		// when pressing, it will show 'All bookings of a customer' page
		JMenuItem menuMore6 = new JMenuItem("All bookings of a customer");
		menuMore6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				more = 6;
				Queries query6 = new Queries();
				layeredPane.removeAll();
				layeredPane.add(query6.getContentPane());
				layeredPane.repaint();
				layeredPane.revalidate();
			}
		});
		menuMore6.setFont(new Font("Segoe UI Black", Font.PLAIN, 12));
		menuMore.add(menuMore6);
		
		// when pressing, it will show 'Customer booked the most rooms' page
		JMenuItem menuMore7 = new JMenuItem("Customer booked the most rooms");
		menuMore7.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				more = 7;
				Queries query7 = new Queries();
				layeredPane.removeAll();
				layeredPane.add(query7.getContentPane());
				layeredPane.repaint();
				layeredPane.revalidate();
			}
		});
		menuMore7.setFont(new Font("Segoe UI Black", Font.PLAIN, 12));
		menuMore.add(menuMore7);
		
		// when pressing search, it will show get real screen with all options
		JMenuItem menuSearch = new JMenuItem("SEARCH");
		menuSearch.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		menuSearch.setBorder(new LineBorder(new Color(223, 222, 224)));
		menuSearch.setBorderPainted(true);
		menuSearch.setOpaque(true);
		menuSearch.setBackground(new Color(215, 182, 125));
		menuSearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				layeredPane.removeAll();
				getReal = new GetReal();
				layeredPane.add(getReal.getContentPane());
				layeredPane.repaint();
				layeredPane.revalidate();
			}
		});
		menuSearch.setIcon(new ImageIcon(EmployeeMenu.class.getResource("/gui_icons/FindLogo.png")));
		menuSearch.setSize(new Dimension(85, 46));
		menuSearch.setPreferredSize(new Dimension(85, 27));
		menuSearch.setForeground(Color.BLACK);
		menuSearch.setFont(new Font("Segoe UI Black", Font.PLAIN, 18));
		menuSearch.setBounds(new Rectangle(0, 0, 85, 46));
		menuBar.add(menuSearch);
		
		
	}
}
