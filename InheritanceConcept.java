package CloudNativeJava;
import java.util.Scanner;

interface Staff_Op {
	void Display();
}

interface Student_Op {
	void Display();
}

abstract class Person implements Staff_Op, Student_Op {
	public String name;
	public String address;
	public double phone;
	
	public Person(String name, String address, double phone) {
		this.name = name;
		this.address = address;
		this.phone = phone;
	}
}

class Staff extends Person {
	private int empid;
	private String company;
	private String designation;
	
	public Staff(String name, String address, double phone, int empid, String company, String designation) {
		super(name,address,phone);
		this.empid = empid;
		this.company = company;
		this.designation = designation;
	}
	public void Display() {
		System.out.println("-----Staff details------")
		System.out.println("Staff Name:" + name);
		System.out.println("Address:" + address);
		System.out.println("Phone number:" + phone);
		System.out.println("Staff id:" + empid);
		System.out.println("Company:" + company);
		System.out.println("Designation:" + designation);
	}
}

class Student extends Person {
	private String usn;
	private String branch;
	private double fees;
	
	public Student(String name, String address, double phone, String usn, String branch, double fees) {
		super(name,address,phone);
		this.usn = usn;
		this.branch = branch;
		this.fees = fees;
	}
	public void Display() {
		System.out.println("----Student details------")
		System.out.println("Student Name:" + name);
		System.out.println("Address:" + address);
		System.out.println("Phone number:" + phone);
		System.out.println("USN:" + usn);
		System.out.println("Branch:" + branch);
		System.out.println("Fees:" + fees);
	}
}

public class InheritanceConcept {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Staff details:");
		System.out.print("Name:");
		String sfname = sc.nextLine();
		System.out.print("Address:");
		String sfaddr = sc.nextLine();
		System.out.print("Phone number:");
		double sfnum = sc.nextDouble();
		System.out.print("Id:");
		int sfid = sc.nextInt();
		sc.nextLine();
		System.out.print("Comapany:");
		String sfcom = sc.nextLine();
		System.out.print("Designation:");
		String sfdes = sc.nextLine();
		Staff sf = new Staff(sfname, sfaddr, sfnum, sfid, sfcom, sfdes);
		sf.Display();
		
		System.out.println("Student details:");
		System.out.print("Name:");
		String stname = sc.nextLine();
		System.out.print("Address:");
		String staddr = sc.nextLine();
		System.out.print("Phone number:");
		double stnum = sc.nextDouble();
		sc.nextLine();
		System.out.print("USN:");
		String stusn = sc.nextLine();
		System.out.print("Branch:");
		String stbr = sc.nextLine();
		System.out.print("Fees:");
		double stfee = sc.nextDouble();
		Student st = new Student(stname, staddr, stnum, stusn, stbr, stfee);
		st.Display();
	}
}
