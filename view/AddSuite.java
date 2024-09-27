// @author Eden Eliezer ID 207188038
package view;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JInternalFrame;
import javax.swing.JOptionPane;
import javax.swing.SpinnerNumberModel;

import model.Hotel;
import Exceptions.MaxPopulationCapacityException;
import model.Suite;

public class AddSuite extends AddSuperiorRoom {

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AddSuite frame = new AddSuite();
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
	public AddSuite() {
		// change relevant components to suite
		
		leftIcon_addRoom.setIcon(new ImageIcon(AddStandardRoom.class.getResource("/gui_icons/Suite.png")));
		lblAddRoom.setText("Add Suite");
		btnAddRoom.setText("ADD SUITE");
		lblHasJaccozi.setVisible(true);
		comboBoxHasJaccozi.setVisible(true);
		lblBalconySize.setVisible(true);
		spinnerBalconySize.setVisible(true);
		spinnerMaxPopulationCapacity.setModel(new SpinnerNumberModel(1, 1, 7, 1));

	}

}
