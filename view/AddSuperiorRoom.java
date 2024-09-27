// @author Eden Eliezer ID 207188038
package view;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JInternalFrame;
import javax.swing.JOptionPane;
import javax.swing.SpinnerNumberModel;

import Exceptions.MaxPopulationCapacityException;
import model.SuperiorRoom;

public class AddSuperiorRoom extends AddStandardRoom {

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AddSuperiorRoom frame = new AddSuperiorRoom();
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
	public AddSuperiorRoom() {
		// change relevant components to superior room 
		
		leftIcon_addRoom.setIcon(new ImageIcon(AddStandardRoom.class.getResource("/gui_icons/Superior.png")));
		lblAddRoom.setText("Add Superior Room");
		btnAddRoom.setText("ADD SUPERIOR ROOM");
		lblHasJaccozi.setVisible(true);
		comboBoxHasJaccozi.setVisible(true);
		spinnerMaxPopulationCapacity.setModel(new SpinnerNumberModel(3, 3, 5, 1));
		

	}

}
