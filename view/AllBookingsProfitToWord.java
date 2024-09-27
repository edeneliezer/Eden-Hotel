// @author Eden Eliezer ID 207188038
package view;

import java.io.FileOutputStream;
import java.io.IOException;

import java.util.ArrayList;
import java.util.List;
import java.util.TreeSet;

import javax.swing.JOptionPane;

import org.apache.poi.xwpf.usermodel.ParagraphAlignment;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.poi.xwpf.usermodel.XWPFParagraph;
import org.apache.poi.xwpf.usermodel.XWPFRun;

import model.Booking;
import model.Hotel;
import model.Room;

public class AllBookingsProfitToWord {

	static double allHotelProfit = 0; // for query (not related to word)
	    public static void main(String[] args){

	    	
	    	double totalProfit = 0;
	    	
	    	// create document
	        XWPFDocument document = new XWPFDocument();  
	        XWPFParagraph title = document.createParagraph();
	        XWPFRun run = title.createRun();
	        
	        // set title
	        run.setText("Profit Of The Hotel From Each Booking:"); 
	        run.setBold(true);
	        run.setFontSize(32);
	        run.addBreak();
	        run.addBreak(); //add line breaks
	        
	        // set text to center
	        title.setAlignment(ParagraphAlignment.CENTER);
	        
	        // set paragraph
	        XWPFParagraph paragraph = document.createParagraph();
	        XWPFRun run2 = paragraph.createRun();
	       
	        // write to doc every booking that was made to word file: id and profit
	        for(Booking b : Main.hotel.getAllBookings().values()) {
	        	// calculate total profit per booking
	        	totalProfit = calculateTotalRevenue(b) - calculateTotalCost(b);
	        	AllBookingsProfitToWord.allHotelProfit += totalProfit; // for query (not related to word)
	        	run2.setText("Booking number: " + b.getBookingNumber() + ", Total Profit: " + totalProfit);
	        	run2.addBreak();
	        	run2.setFontSize(18);
	        }
	        
	        // set text to center
	        paragraph.setAlignment(ParagraphAlignment.CENTER);
	        
	        // write output and close document
	        try {
	        	FileOutputStream output = new FileOutputStream("AllBookingsProfit.docx");
	        	document.write(output);
	        	output.close();
	            JOptionPane.showMessageDialog(null, "Check out 'AllBookingsProfit.docx' File!");
	            } 
	        catch (IOException ex) {
	        	JOptionPane.showMessageDialog(null, "Error creating Word file: " + ex.getMessage(), "", JOptionPane.ERROR_MESSAGE);
	            }
	    }
	    
	    // calculating methods
	    public static double calculateTotalRevenue(Booking b) {
	    	double totalRevenue = 0;
	    	for(Room s: Main.hotel.getAllRooms().values())
		       {
		    	   if(s.getRoomNumber().equals(b.getRoomNumber()))
		    	   {
		    		  totalRevenue = b.getNumberOfDays() * s.getDailyPrice();
		    	   }
		    	   
		       }
		       return totalRevenue;
		}
		
		public static double calculateTotalCost(Booking b) {
			double totalCost = 0;
			for(Room s: Hotel.getInstance().getAllRooms().values())
		       {
		    	   if(s.getRoomNumber().equals(b.getRoomNumber()))
		    	   {
		    		  totalCost = b.getNumberOfDays() * s.getAvgDailyCost();
		    	   }   
		       }
		       return totalCost;
		}
	}