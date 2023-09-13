package com.tdtu.lab03;

/**
 * Hello world!
 *
 */
public class App 
{
	public static void main( String[] args )
    {
        // Phone
    	System.out.println("Phone");
    	
    	// them 6 phone vao data
    	System.out.println("them 6 phone vao data");
    	PhoneDAO phoneDAO = new PhoneDAO();
        phoneDAO.add(new Phone("iPhone 13 Pro Max", 13000, "Deep Blue", "VN", 20));
        phoneDAO.add(new Phone("iPhone 16 Pro Max", 16000000, "Pink", "US", 1));
    	phoneDAO.add(new Phone("iPhone 14", 799, "Blue", "USB", 10));
    	phoneDAO.add(new Phone("iPhone 14 Plus", 899, "Deep Blue", "USB", 20));
    	phoneDAO.add(new Phone("iPhone 14 Pro", 33000000, "Pink", "VN", 30));
    	phoneDAO.add(new Phone("iPhone 14 Pro Max", 53000000, "Deep Purple", "VN", 40));
    	System.out.println("------------------------------------------------------------------");
    	
    	// lay phone co id = 1
    	System.out.println("lay phone co id = 1");
    	System.out.println(phoneDAO.get(1).toString());
    	System.out.println("------------------------------------------------------------------");
    	
    	//thay doi ten cho phone co id=1 bang ten moi "Iphone 15 ProMax"
    	System.out.println("thay doi ten cho phone co id=1 bang ten moi \"Iphone 15 ProMax\"");
        Phone phoneUpdate = phoneDAO.get(1);
        phoneUpdate.setName("Iphone 15 ProMax");
        phoneDAO.update(phoneUpdate);
        System.out.println("------------------------------------------------------------------");
        
        //lay danh sach all phone
        System.out.println("lay danh sach all phone");
        for(Phone phone : phoneDAO.getAll()) {
        	System.out.println(phone.toString());
        }
        System.out.println("------------------------------------------------------------------");
        
        //Phone co gia ban cao nhat
        System.out.println("Phone co gia ban cao nhat");
        System.out.println(phoneDAO.getHighestSellingPrice().toString());
        System.out.println("------------------------------------------------------------------");
        
        //Phone tang theo ten QG, neu trung ten QG thi sx giam theo GIA
        System.out.println("Phone tang theo ten QG, neu trung ten QG thi sx giam theo GIA");
        for(Phone phone : phoneDAO.sortByCountryName()) {
        	System.out.println(phone.toString());
        }
        System.out.println("------------------------------------------------------------------");
        
        //Ton tai Phone nao co gia >50M (true/false)
        System.out.println("Ton tai Phone nao co gia >50M (true/false)");
        System.out.println(phoneDAO.checkAbove50M());
        System.out.println("------------------------------------------------------------------");
        
        //Phone mau hong va >15M
        System.out.println("Phone mau hong va >15M");
        System.out.println(phoneDAO.getPinkAndOver15M().toString());
        System.out.println("------------------------------------------------------------------");
        
        
        // Manufacture
        ManufactureDAO manufactureDAO = new ManufactureDAO();
        
        manufactureDAO.add(new Manufacture("VN Phone", "VN", 120));
        manufactureDAO.add(new Manufacture("USA Phone", "USB", 130));
        manufactureDAO.add(new Manufacture("USB Phone", "US", 180));
        manufactureDAO.add(new Manufacture("US Pe", "US", 670));
        System.out.println("------------------------------------------------------------------");
        
        System.out.println("Hien thi toan bo Manufacture");
        for(Manufacture manufacture : manufactureDAO.getAll()) {
        	System.out.println(manufacture.toString());
        }
        System.out.println("------------------------------------------------------------------");
        
        //Nha Sx co tren 100 NV
        System.out.println("Nha Sx co tren 100 NV");
        System.out.println("All manufacturers have more than 100 employee: " + manufactureDAO.checkMoreThan100Employee());
        System.out.println("------------------------------------------------------------------");

        //Tong cac NV
        System.out.println("Tong cac NV");
        System.out.println("Employee count: " + manufactureDAO.countAllEmployee());
        System.out.println("------------------------------------------------------------------");
        
        //Tra nha SX cuoi cung
        System.out.println("Tra nha SX cuoi cung");
        try {
			System.out.println("The last manufacture in us: " + manufactureDAO.checkInUS());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
}
