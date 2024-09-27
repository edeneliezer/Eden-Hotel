// @author Eden Eliezer ID 207188038
package view;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import javax.swing.JOptionPane;

import model.Hotel;

public class Main {
	
	static Hotel hotel;

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		hotel = getMyHotel();
		Login login = new Login(); // start with login page
		login.setVisible(true);
	}
	

	static void saveMyHotel() {
		try {
			FileOutputStream fileOutput = new FileOutputStream("EdenHotel.ser");
			ObjectOutputStream output = new ObjectOutputStream(fileOutput);
			
			// write changes to EdenHotel.ser
			output.writeObject(hotel);
			output.close();
			fileOutput.close();
			
			// success message
			JOptionPane.showInternalMessageDialog(null, "The changes were successfully saved!");
			
		} catch (IOException e) { // failure message
			// TODO Auto-generated catch block
			JOptionPane.showInternalMessageDialog(null, "Serialization of the hotel was not possible.");
		}
	}
	
	static Hotel getMyHotel() {
		Hotel hotel = null;
		try {
			FileInputStream fileInput = new FileInputStream("EdenHotel.ser");
			ObjectInputStream input = new ObjectInputStream(fileInput);
			// read existing hotel
			hotel = (Hotel)input.readObject();
			
			input.close();
			fileInput.close();
			// first time message
			JOptionPane.showMessageDialog(null, "Welcome Back! we missed you :)");
			
			return hotel;
		} // if EdenHotel.ser already exist
		catch(FileNotFoundException e) {
			// welcome back message
			JOptionPane.showMessageDialog(null, "Welcome To Eden Hotel!\n Let's get it started!");
			return Hotel.getInstance();
		}
		catch(IOException e){ 
			e.printStackTrace();
			System.out.println("Sorry, can't deserialized");
			return Hotel.getInstance();
		}
		catch (ClassNotFoundException e) {
			System.out.println("Class was not found");
			return Hotel.getInstance();
		}
	}

}
