package model;



import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.TreeSet;
import java.util.stream.Collectors;

import javax.swing.JOptionPane;

import Exceptions.MaxPopulationCapacityException;
import Exceptions.PersonAlreadyExistException;


public class Hotel implements Serializable {
    // Singleton instance
    private static Hotel instance = null;
    
    // Fields
    private HashMap <String,Employee> allEmployees;
    private HashMap <String, Customer> allCustomers;
    private HashMap <String, Room> allRooms;
    private HashMap <String, Booking> allBookings;
    private HashMap <String, Department> allDepartments;
    
    // Private constructor to prevent direct instantiation
    private Hotel() {
        allEmployees = new HashMap<String,Employee>();
        allCustomers = new HashMap<String, Customer>();
        allRooms = new HashMap<String, Room>();
        allBookings = new HashMap<String, Booking>();
        allDepartments = new HashMap<String, Department>();
    }
    
    // all getters and setters
    
    
    public HashMap<String, Employee> getAllEmployees() {
		return allEmployees;
	}

	public void setAllEmployees(HashMap<String, Employee> allEmployees) {
		this.allEmployees = allEmployees;
	}

	public HashMap<String, Customer> getAllCustomers() {
		return allCustomers;
	}

	public void setAllCustomers(HashMap<String, Customer> allCustomers) {
		this.allCustomers = allCustomers;
	}

	public HashMap<String, Room> getAllRooms() {
		return allRooms;
	}

	public void setAllRooms(HashMap<String, Room> allRooms) {
		this.allRooms = allRooms;
	}

	public HashMap<String, Booking> getAllBookings() {
		return allBookings;
	}

	public void setAllBookings(HashMap<String, Booking> allBookings) {
		this.allBookings = allBookings;
	}

	public HashMap<String, Department> getAllDepartments() {
		return allDepartments;
	}

	public void setAllDepartments(HashMap<String, Department> allDepartments) {
		this.allDepartments = allDepartments;
	}
    
    
    
    // Getter for singleton instance
    public static Hotel getInstance() {
        if (instance == null) {
            instance = new Hotel();
        }
        return instance;
    }
 
	// all add functions

	public boolean addStandardRoom(StandardRoom standardRoom)throws MaxPopulationCapacityException{
        if(allRooms.containsValue(standardRoom)) 
        	return false;
        
        if(standardRoom.getMaxPopulationCapacity() > 2 || standardRoom.getMaxPopulationCapacity() < 1)
        	throw new MaxPopulationCapacityException();
        
        allRooms.put(standardRoom.getRoomNumber(), standardRoom);
        return true;
    }
    
    public boolean addSuperiorRoom(SuperiorRoom superiorRoom)throws MaxPopulationCapacityException{
        if(allRooms.containsValue(superiorRoom))
        	return false;
        
        if(superiorRoom.getMaxPopulationCapacity() > 5 || superiorRoom.getMaxPopulationCapacity() < 3)
        	throw new MaxPopulationCapacityException();
        
        allRooms.put(superiorRoom.getRoomNumber(), superiorRoom);
        
        return true;

    }
    
    public boolean addSuite(Suite suite)throws MaxPopulationCapacityException{
        if(allRooms.containsValue(suite))
        	return false;
        
        if(suite.getMaxPopulationCapacity() > 7 || suite.getMaxPopulationCapacity() < 1)
        	throw new MaxPopulationCapacityException();
        
        allRooms.put(suite.getRoomNumber(), suite);
           
        return true;


    }
    
    public boolean addBooking(Booking booking){
        if(allBookings.containsValue(booking)!=true) {
        	booking.getCustomer().addBooking(booking);
        	allBookings.put(booking.getBookingNumber(), booking);
            return true;
        } else {
            return false;
        }
    }
    
    public boolean addCustomer(Customer customer)throws PersonAlreadyExistException{
        if(allCustomers.containsValue(customer)!=true) {
            allCustomers.put(customer.getId(), customer);
            return true;
        } else {
           throw new PersonAlreadyExistException(customer.getFirstName(), customer.getLastName());
        }
    }
    
    public boolean addVIPCustomer(VIPCustomer vipCustomer)throws PersonAlreadyExistException{
        if(allCustomers.containsValue(vipCustomer)!=true) {
        	allCustomers.put(vipCustomer.getId(), vipCustomer);
            return true;
        } else {
            throw new PersonAlreadyExistException(vipCustomer.getFirstName(), vipCustomer.getLastName());
        }
    }
    
    public boolean addEmployee(Employee employee)throws PersonAlreadyExistException{
        if(allEmployees.containsValue(employee)!=true) {
        	
        	employee.getDepartment().addEmployee(employee);
        	allEmployees.put(employee.getId(), employee);
            return true;
        } else {
            throw new PersonAlreadyExistException(employee.getFirstName(), employee.getLastName());
        }
    }
    
    public boolean addDepartmentManager(DepartmentManager departmentManager)throws PersonAlreadyExistException{
        if(allEmployees.containsValue(departmentManager)!=true) {
        	{
        		departmentManager.getDepartment().addEmployee(departmentManager);
        		departmentManager.getDepartment().setDepManager(departmentManager);
        		allEmployees.put(departmentManager.getId(), departmentManager);
               return true;
        	}
        } else {
            throw new PersonAlreadyExistException(departmentManager.getFirstName(), departmentManager.getLastName());
        }
    }


    public boolean addDepartment(Department department){
        if(allDepartments.containsValue(department)!=true) {
            allDepartments.put(department.getDepartmentId(), department);
            return true;
        } else {
            return false;
        }
    }

    // all remove functions
    
    public boolean removeStandardRoom(StandardRoom standardRoom) {
    	
        if (standardRoom == null)
            return false;

        if (allRooms.containsValue(standardRoom)) {
        	allRooms.remove(standardRoom.getRoomNumber());
            return true;
        }

        return false;
    }

    public boolean removeSuperiorRoom(SuperiorRoom superiorRoom) {
        if (superiorRoom == null)
            return false;

        if (allRooms.containsValue(superiorRoom)) {
        	allRooms.remove(superiorRoom.getRoomNumber());
            return true;
        }

        return false;
    }

    public boolean removeSuite(Suite suite) {
        if (suite == null)
            return false;

        if (allRooms.containsValue(suite)) {
        	allRooms.remove(suite.getRoomNumber());
            return true;
        }

        return false;
    }

    public boolean removeBooking(Booking booking) {
        if (booking == null)
            return false;
        if (allBookings.containsValue(booking)) {
        	booking.getCustomer().removeBooking(booking);
            allBookings.remove(booking.getBookingNumber());

            return true;
        }

        return false;
    }

    public boolean removeCustomer(Customer customer) {
        if (customer == null)
            return false;
        if (allCustomers.containsValue(customer)) {
            allCustomers.remove(customer.getId());
            return true;
        }

        return false;
    }

    public boolean removeVIPCustomer(VIPCustomer vipCustomer) {
        if (vipCustomer == null)
            return false;

        if (allCustomers.containsValue(vipCustomer)) {
        	allCustomers.remove(vipCustomer.getId());
            return true;
        }

        return false;
    }

    public boolean removeEmployee(Employee employee) {
        if (employee == null)
            return false;
        if (allEmployees.containsValue(employee)) {
        	employee.getDepartment().removeEmployee(employee);
            allEmployees.remove(employee.getId());
            return true;
        }
        return false;
    }

    public boolean removeDepartmentManager(DepartmentManager departmentManager) {
        if (departmentManager == null)
            return false;

        if (allEmployees.containsValue(departmentManager)) {
        	allEmployees.remove(departmentManager.getId());
            // set department's manager to null
            departmentManager.getDepartment().setDepManager(null);
            departmentManager.getDepartment().removeEmployee(departmentManager);
            return true;
        }

        return false;
    }

    public boolean removeDepartment(Department department) {
        if (department == null)
            return false;

        if (allDepartments.containsValue(department)) {
            allDepartments.remove(department.getDepartmentId());
            // remove all employees in the department
            for(Employee e: department.getAllEmployees()) {
				allEmployees.remove(e.getId());	
			}
            // remove department manager
            //removeDepartmentManager(department.getDepManager());
            if(department.getDepManager() != null)
            allEmployees.remove(department.getDepManager().getId());
            return true;
        }

        return false;
    }
    
    // all getReal functions
    
    
    public StandardRoom getRealStandardRoom(String roomNumber) {
        return (StandardRoom) allRooms.get(roomNumber);
    }

    public SuperiorRoom getRealSuperiorRoom(String roomNumber) {
    	  return (SuperiorRoom) allRooms.get(roomNumber);
    }

    public Suite getRealSuite(String roomNumber) {
    	return (Suite) allRooms.get(roomNumber);
    }

    public Booking getRealBooking(String bookingNumber) {
    	return allBookings.get(bookingNumber);
    }

    public Customer getRealCustomer(String ID) {
    	return allCustomers.get(ID);
    }

    public VIPCustomer getRealVIPCustomer(String ID) {
    	if(allCustomers.get(ID) instanceof VIPCustomer)
    		return (VIPCustomer) allCustomers.get(ID);
    	return null;
    }

    public Employee getRealEmployee(String ID) {
    	return allEmployees.get(ID);
    }

    public DepartmentManager getRealDepartmentManager(String ID) {
    	return (DepartmentManager) allEmployees.get(ID);
    }

    public Department getRealDepartment(String departmentID) {
    	return allDepartments.get(departmentID);
    }
   
    //new queries
    public List<Employee> KEmployees(int k){
    	
    	List<Employee> employees = new ArrayList<Employee>(getAllEmployees().values());
		Collections.sort(employees);
		
		if(employees.size()<=k) 
			return employees;
		
		return employees.subList(0, k);
    }
    
	public ArrayList<Customer> allCustomersByPK(){
		ArrayList<Customer> allCustomers = new ArrayList<Customer>(getAllCustomers().values());
		Collections.sort(allCustomers);
		return allCustomers;
	}
	
	public TreeSet<Booking> allBookingByRevenue(){
		TreeSet<Booking> t = new TreeSet<Booking>(new Comparator<Booking>() {

			@Override
			public int compare(Booking o1, Booking o2) {
				Double temp1 = o1.getTotalRevenue();
				Double temp2 = o2.getTotalRevenue();
				if(temp1.equals(temp2))
					return o1.getBookingNumber().compareTo(o2.getBookingNumber());
				return -1*Double.compare(temp1,temp2);
			}
		});
		t.addAll(getAllBookings().values());
		return t;
		
	}
	
	public TreeSet<Customer> allCustomersCmp(){
		
		TreeSet<Customer> t = new TreeSet<Customer>(new Comparator<Customer>() {

			@Override
			public int compare(Customer o1, Customer o2) {
				// TODO Auto-generated method stub
				if(o1.getAllBookings().size()==o2.getAllBookings().size())
					return -1*o1.getFirstName().compareTo(o2.getFirstName());
				return o1.getAllBookings().size()-o2.getAllBookings().size();
			}
		});
		t.addAll(getAllCustomers().values());
		return t;
		
		
	}
	
	public int totalProfit() {
	    double sum = allBookings.values().stream()
	            .mapToDouble(d -> d.getTotalRevenue() - d.getTotalCost())
	            .sum();
	    return (int) sum;
	}
	
	public List<Booking> allBookingsOfSpecCustomer(String customerID) {
	    return getAllCustomers().values().stream()
	            .filter(customer -> customer.getId().equals(customerID))
	            .findFirst()
	            .map(customer -> new ArrayList<>(customer.getAllBookings()))
	            .orElse(new ArrayList<>());
	}
	
	public Customer customerBookedTheMostRooms() {
	    return getAllCustomers().values().stream()
	            .max(Comparator.comparingInt(c -> c.getAllBookings().size()))
	            .orElse(null);
	}
	
	public List<Employee> KEmployeesStream(int k){
		    return getAllEmployees().values().stream()
		            .sorted()
		            .limit(k)
		            .collect(Collectors.toList());
		}
}
