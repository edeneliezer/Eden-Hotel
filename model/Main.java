package model;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import Exceptions.MaxPopulationCapacityException;
import Exceptions.PersonAlreadyExistException;
import utils.Area;
import utils.CSVExporter;
import utils.Gender;
import utils.MyFileLogWriter;
import utils.Specialization;
import autopilot.OutputDocument;
import autopilot.Section;

public class Main {


	private static Hotel hotel = Hotel.getInstance();
	private static OutputDocument document = new OutputDocument();
	private static Map<String,Command> commands = new HashMap<>();
	private static Map<String,Section> sections = new HashMap<>();
	private static final String OUTPUT_FILE = "output.txt";
	private interface Command {  
		void execute(Section section,String... args);
	} 
	static {
		Section space = document.nextSection();
		Section finish = document.nextSection();
		
		//ADD 
		Section addStandardRoom = document.nextSection();
		Section addSuperiorRoom = document.nextSection();
		Section addSuite = document.nextSection();
		Section addCustomer = document.nextSection();
		Section addVIPCustomer = document.nextSection();
		Section addEmployee = document.nextSection();
		Section addDepartmentManager = document.nextSection();
		Section addBooking = document.nextSection();
		Section addDepartment = document.nextSection();


		//Remove
		Section removeStandardRoom = document.nextSection();
		Section removeSuperiorRoom = document.nextSection();
		Section removeSuite = document.nextSection();
		Section removeCustomer = document.nextSection();
		Section removeVIPCustomer = document.nextSection();
		Section removeEmployee = document.nextSection();
		Section removeDepartmentManager = document.nextSection();
		Section removeBooking = document.nextSection();
		Section removeDepartment = document.nextSection();
		
		//Query
		Section Kemployees = document.nextSection();
		Section allCustomersByPK = document.nextSection();
		Section allBookingByRevenue = document.nextSection();
		Section allCustomersCmp = document.nextSection();
		Section totalProfit = document.nextSection();
		Section allBookingsOfSpecCustomer = document.nextSection();
		Section customerBookedTheMostRooms = document.nextSection();
		Section KEmployeesStream = document.nextSection();


		
		
		//Sections's HashMap PUT
		sections.put("addStandardRoom",addStandardRoom);
		sections.put("addSuperiorRoom",addSuperiorRoom);
		sections.put("addSuite",addSuite);
		sections.put("addCustomer",addCustomer);
		sections.put("addVIPCustomer",addVIPCustomer); 
		sections.put("addDepartmentManager",addDepartmentManager);
		sections.put("addBooking",addBooking);
		sections.put("addDepartment",addDepartment);
		
		sections.put("removeStandardRoom",removeStandardRoom);
		sections.put("removeSuperiorRoom",removeSuperiorRoom);
		sections.put("removeSuite",removeSuite);
		sections.put("removeCustomer",removeCustomer);
		sections.put("removeVIPCustomer",removeVIPCustomer);
		sections.put("removeDepartmentManager",removeDepartmentManager);
		sections.put("removeBooking",removeBooking);
		sections.put("removeDepartment",removeDepartment);
		sections.put("addEmployee", addEmployee);
		sections.put("removeEmployee", removeEmployee);
		
		sections.put("Kemployees",Kemployees);
		sections.put("allCustomersByPK",allCustomersByPK);
		sections.put("allBookingByRevenue",allBookingByRevenue);
		sections.put("allCustomersCmp",allCustomersCmp);
		sections.put("totalProfit",totalProfit);
		sections.put("allBookingsOfSpecCustomer",allBookingsOfSpecCustomer);
		sections.put("customerBookedTheMostRooms",customerBookedTheMostRooms);
		sections.put("KEmployeesStream", KEmployeesStream);

		
		
		sections.put("space",space);
		sections.put("finish",finish);

		commands.put("space", (section, args) -> {
			MyFileLogWriter.println(""); 
		});

		commands.put("finish", (section, args) -> {
			MyFileLogWriter.saveLogFile();
		}); 
		
		commands.put("addStandardRoom", (section, args) -> {
			StandardRoom s = new StandardRoom(Double.parseDouble(args[0]), Integer.parseInt(args[1]),
					Double.parseDouble(args[2]),Double.parseDouble(args[3]),Integer.parseInt(args[4]), Integer.parseInt(args[5]), Boolean.parseBoolean(args[6]));
			try {
				if(hotel.addStandardRoom(s)) 
					MyFileLogWriter.println("successfully added StandardRoom "+s.getRoomNumber());
				else
					MyFileLogWriter.println("failed to add StandardRoom "+s.getRoomNumber());
			} catch (MaxPopulationCapacityException e) {
				// TODO Auto-generated catch block
				MyFileLogWriter.println(e.getMessage());
			}
		});
		commands.put("addSuperiorRoom", (sections,args) -> {
			SuperiorRoom s = new SuperiorRoom(Double.parseDouble(args[0]), Integer.parseInt(args[1]),
					Double.parseDouble(args[2]),Double.parseDouble(args[3]),Integer.parseInt(args[4]), Integer.parseInt(args[5]),
					Boolean.parseBoolean(args[6]),Boolean.parseBoolean(args[7]));	
			try {
				if(hotel.addSuperiorRoom(s))
					MyFileLogWriter.println("successfully added SuperiorRoom "+s.getRoomNumber());
				else
					MyFileLogWriter.println("failed to add SuperiorRoom "+s.getRoomNumber());
			} catch (MaxPopulationCapacityException e) {
				// TODO Auto-generated catch block
				MyFileLogWriter.println(e.getMessage());
			}
		});
		commands.put("addSuite", (sections,args) -> {
			Suite s = new Suite(Double.parseDouble(args[0]),Integer.parseInt(args[1]),
					Double.parseDouble(args[2]),Double.parseDouble(args[3]),Integer.parseInt(args[4]), Integer.parseInt(args[5]),
					Boolean.parseBoolean(args[6]),Boolean.parseBoolean(args[7]),Double.parseDouble(args[8]));	
			try {
				if(hotel.addSuite(s))
					MyFileLogWriter.println("successfully added Suite "+s.getRoomNumber());
				else
					MyFileLogWriter.println("failed to add Suite "+s.getRoomNumber());
			} catch (MaxPopulationCapacityException e) {
				// TODO Auto-generated catch block
				MyFileLogWriter.println(e.getMessage());
			}
		});
		commands.put("addCustomer", (sections,args) -> {
			Date date = null;
			try {
				date = new SimpleDateFormat("dd/MM/yyyy").parse(args[7]);
			} catch (ParseException e) {
				e.printStackTrace();
			}
			Customer c = new Customer(args[0], args[1], args[2],args[3],Area.valueOf(args[4]),Gender.valueOf(args[5]),Integer.valueOf(args[6]), date);	
			try {
				if(hotel.addCustomer(c))
					MyFileLogWriter.println("successfully added Customer "+c.getId());
				else
					MyFileLogWriter.println("failed to add Customer "+c.getId());
			} catch (PersonAlreadyExistException e) {
				// TODO Auto-generated catch block
				MyFileLogWriter.println(e.getMessage());
			}
		});
		commands.put("addVIPCustomer", (sections,args) -> {
			Date date = null;
			try {
				date = new SimpleDateFormat("dd/MM/yyyy").parse(args[7]);

			} catch (ParseException e) {
				e.printStackTrace();
			}
			VIPCustomer c = new VIPCustomer(args[0], args[1], args[2],args[3], Area.valueOf(args[4]),Gender.valueOf(args[5]), Integer.valueOf(args[6]), date, Double.parseDouble(args[8]));	
			try {
				if(hotel.addVIPCustomer(c))
					MyFileLogWriter.println("successfully added VIPCustomer "+c.getId());
				else
					MyFileLogWriter.println("failed to add VIPCustomer "+c.getId());
			} catch (PersonAlreadyExistException e) {
				// TODO Auto-generated catch block
				MyFileLogWriter.println(e.getMessage());
			}
		});
		
		commands.put("addDepartmentManager", (sections,args) -> {
			Department d = hotel.getRealDepartment(String.valueOf(args[9]));
			DepartmentManager dm = new DepartmentManager(args[0], args[1], args[2], args[3],Area.valueOf(args[4]),Gender.valueOf(args[5]), Integer.valueOf(args[6]), Integer.valueOf(args[7]), Double.valueOf(args[8]),
					d, Double.valueOf(args[10]));
			try {
				if(hotel.addDepartmentManager(dm))
					MyFileLogWriter.println("successfully added DepartmentManager "+dm.getId());
				else
					MyFileLogWriter.println("failed to add DepartmentManager "+dm.getId());
			} catch (PersonAlreadyExistException e) {
				// TODO Auto-generated catch block
				MyFileLogWriter.println(e.getMessage());
			}
		});
		commands.put("addDepartment", (sections,args) -> {
			Department d = new Department(String.valueOf(args[0]),Specialization.valueOf( args[1]));
			if(hotel.addDepartment(d)) 
				MyFileLogWriter.println("successfully added Department "+d.getDepartmentId());
			else
				MyFileLogWriter.println("failed to add Department "+d.getDepartmentId());
		});
		commands.put("addBooking", (sections,args) -> {
			Date date = null;
			try {
				date = new SimpleDateFormat("dd/MM/yyyy").parse(args[2]);
			} catch (ParseException e) {
				e.printStackTrace();
			}
			Customer c = Hotel.getInstance().getRealCustomer(String.valueOf(args[1]));
			VIPCustomer vc = Hotel.getInstance().getRealVIPCustomer(String.valueOf(args[1]));
			if(c!= null)
			{
				Booking b = new Booking(String.valueOf(args[0]),c,date,Integer.valueOf(args[3]));
				if(hotel.addBooking(b)) 
					MyFileLogWriter.println("successfully added Booking "+b.getBookingNumber());
				else
					MyFileLogWriter.println("failed to add Booking "+b.getBookingNumber());
			}
			else
			{
				Booking b = new Booking(String.valueOf(args[0]),vc,date,Integer.valueOf(args[3]));
				if(hotel.addBooking(b)) 
					MyFileLogWriter.println("successfully added Booking "+b.getBookingNumber());
				else
					MyFileLogWriter.println("failed to add Booking "+b.getBookingNumber());
			}
			
		});
		commands.put("removeStandardRoom", (sections,args) -> {
			if(hotel.removeStandardRoom(hotel.getRealStandardRoom(args[0])))
				MyFileLogWriter.println("successfully removed StandardRoom "+args[0]);
			else
				MyFileLogWriter.println("failed to remove StandardRoom "+args[0]);
		});
		commands.put("removeSuperiorRoom", (sections,args) -> {
			if(hotel.removeSuperiorRoom(hotel.getRealSuperiorRoom(args[0])))
				MyFileLogWriter.println("successfully removed SuperiorRoom "+args[0]);
			else
				MyFileLogWriter.println("failed to remove SuperiorRoom "+args[0]);
		});
		commands.put("removeSuite", (sections,args) -> {
			
			if(hotel.removeSuite(hotel.getRealSuite(args[0])))
				MyFileLogWriter.println("successfully removed Suite "+args[0]);
			else
				MyFileLogWriter.println("failed to remove Suite "+args[0]);
		});
		commands.put("removeCustomer", (sections,args) -> {
			
			if(hotel.removeCustomer(hotel.getRealCustomer(args[0])))
				MyFileLogWriter.println("successfully removed Customer "+args[0]);
			else
				MyFileLogWriter.println("failed to remove Customer "+args[0]);
		});
		commands.put("removeVIPCustomer", (sections,args) -> {
			
			if(hotel.removeVIPCustomer(hotel.getRealVIPCustomer(args[0])))
				MyFileLogWriter.println("successfully removed VIPCustomer "+args[0]);
			else
				MyFileLogWriter.println("failed to remove VIPCustomer "+args[0]);
		});
		commands.put("removeDepartmentManager", (sections,args) -> {
			
			if(hotel.removeDepartmentManager(hotel.getRealDepartmentManager(args[0])))
				MyFileLogWriter.println("successfully removed DepartmentManager "+args[0]);
			else
				MyFileLogWriter.println("failed to remove DepartmentManager "+args[0]);
		});
		commands.put("removeBooking", (sections,args) -> {

			if(hotel.removeBooking(hotel.getRealBooking(args[0])))
				MyFileLogWriter.println("successfully removed Booking "+args[0]);
			else
				MyFileLogWriter.println("failed to remove Booking "+args[0]);
		});
		commands.put("removeDepartment", (sections,args) -> {
			
			if(hotel.removeDepartment(hotel.getRealDepartment(String.valueOf(args[0]))))
				MyFileLogWriter.println("successfully removed Department "+args[0]);
			else
				MyFileLogWriter.println("failed to remove Department "+args[0]);
		});
		commands.put("removeEmployee", (sections,args) -> {
			
			if(hotel.removeEmployee(hotel.getRealEmployee(args[0])))
				MyFileLogWriter.println("successfully removed Employee "+args[0]);
			else
				MyFileLogWriter.println("failed to remove Employee "+args[0]);
		});
		commands.put("addEmployee", (sections,args) -> {
			Employee e = new Employee(args[0], args[1], args[2], args[3],Area.valueOf(args[4]),Gender.valueOf(args[5]),Integer.valueOf(args[6]),Integer.valueOf(args[7]),Double.valueOf(args[8]), hotel.getRealDepartment(String.valueOf(args[9])));
			try {
				if(hotel.addEmployee(e))
					MyFileLogWriter.println("successfully added Employee "+args[0]);
				else
					MyFileLogWriter.println("failed to add Employee "+args[0]);
			} catch (PersonAlreadyExistException e1) {
				// TODO Auto-generated catch block
				MyFileLogWriter.println(e1.getMessage());
			}
		});
		
		
	
		
		
		commands.put("allCustomersBookings", (sections,args) -> {
			MyFileLogWriter.println("Customers And Bookings");
			MyFileLogWriter.println("\n");

			
			for(Customer c : hotel.getAllCustomers().values()){
				MyFileLogWriter.println("Customer"+ c.getId());
				MyFileLogWriter.println("\n");

				if(c.getAllBookings().size()==0) {
					MyFileLogWriter.println("No Bookings");
					MyFileLogWriter.println("\n");
				}
				else {
					MyFileLogWriter.println(c.toString()+"");
				MyFileLogWriter.println("\n");

				
			}}
			for(Customer c : hotel.getAllCustomers().values()){
				MyFileLogWriter.println("VIPCustomer"+ c.getId());
				MyFileLogWriter.println("\n");

				if(c.getAllBookings().size()==0) {
					MyFileLogWriter.println("No Bookings");
				MyFileLogWriter.println("\n");
				}

				else {
				for(Booking b:c.getAllBookings())
					MyFileLogWriter.println(b.toString()+"");
				MyFileLogWriter.println("\n");

				}
			}

		});

		commands.put("allDepartmentEmployees", (sections,args) -> {
			MyFileLogWriter.println("Departments And Employee");
			MyFileLogWriter.println("\n");

			
			for(Department d : hotel.getAllDepartments().values()){
				MyFileLogWriter.println("Department"+ d.getDepartmentId());
				MyFileLogWriter.println("\n");

				if(d.getAllEmployees().size()==0)
					MyFileLogWriter.println("No Employees");
				else {
				for(Employee c:d.getAllEmployees())
					MyFileLogWriter.println(c.toString()+"");
				}
				MyFileLogWriter.println("\n");
			}

		});

		commands.put("Kemployees", (sections,args) -> {
			MyFileLogWriter.println("Top "+args[0]+" Employees");
			MyFileLogWriter.println("\n");
			for(Employee e : hotel.KEmployees(Integer.parseInt(args[0]))) {
				MyFileLogWriter.println(e.toString());
			}
			

		});
		
		commands.put("KEmployeesStream", (sections,args) -> {
			MyFileLogWriter.println("Top "+args[0]+" Employees with Stream");
			MyFileLogWriter.println("\n");
			for(Employee e : hotel.KEmployees(Integer.parseInt(args[0]))) {
				MyFileLogWriter.println(e.toString());
			}
			

		});
		
		
		commands.put("customerBookedTheMostRooms", (sections,args) -> {
			MyFileLogWriter.println("The customer who has booked the most rooms is "+hotel.customerBookedTheMostRooms().getFirstName());

			

		});
		commands.put("allBookingsOfSpecCustomer", (sections,args) -> {
			MyFileLogWriter.println("all Bookings Of Customer with ID "+args[0]);
			MyFileLogWriter.println("\n");
			for(Booking b : hotel.allBookingsOfSpecCustomer(args[0])) {
				MyFileLogWriter.println(b.toString());
			}
			

		});
		
		commands.put("totalProfit", (sections,args) -> {
			MyFileLogWriter.println("The Total Profit with Stream "+hotel.totalProfit()+" $");
			

		});
		
		commands.put("allCustomersByPK", (sections,args) -> {
			MyFileLogWriter.println("all Customers By PK");
			MyFileLogWriter.println("\n");
			for(Customer e : hotel.allCustomersByPK()) {
				MyFileLogWriter.println(e.toString());
			}
			

		});
		
		commands.put("allBookingByRevenue", (sections,args) -> {
			MyFileLogWriter.println("all Booking By Revenue");
			MyFileLogWriter.println("\n");
			for(Booking e : hotel.allBookingByRevenue()) {
				MyFileLogWriter.println(e.toString());
			}
			

		});
		
		commands.put("allCustomersCmp", (sections,args) -> {
			MyFileLogWriter.println("all Customers By number of Booking");
			MyFileLogWriter.println("\n");
			for(Customer e : hotel.allCustomersCmp()) {
				MyFileLogWriter.println(e.toString());
			}
			

		});
	}
	
	
	public static void main(String[] args) throws IOException{
			
		// TODO Auto-generated method stu
		MyFileLogWriter.initializeMyFileWriter();

		try{
			List<String[]> input = CSVExporter.importCSV("INPUT.csv");

			for (int i = 1; i < input.size(); i++) {

				//get row
				String[] values = input.get(i);

				if(values.length == 0)
					continue;
				//get command
				String command = values[0];

				//get params
				String[] params = Arrays.copyOfRange(values,1,values.length);

				//send to func 
				try {
					func(command, params);
				}catch (Exception e){
					e.printStackTrace();
				}
			}
		}finally {  
			// Shared s = Shared.getInstance();
			System.out.println("All commands executed. Please check \"" + OUTPUT_FILE + "\".");
		}
	
	}

	private static void func(String command,String[] args){
		//extract command
		Command c = commands.get(command);

		//check that command exists
		if (c != null){
			//get relevant section
			Section section = sections.get(command);

			//execute
			c.execute(section,args);
		}
	}

}
