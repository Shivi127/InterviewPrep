/*
Imagine you have a call center with three levels of employees: respondent, manager, and director. 
An incoming telephone call must be first allocated to a respondent who is free. If the respondent 
can't handle the call, he or she must escalate the call to a manager. If the manager is not free or 
notable to handle it, then the call should be escalated to a director. Design the classes and data 
structures for this problem. Implement a method dispatchCaL L() which assigns a call to the first 
available employee.
*/

// Need a superclass Employees contaianing mutual stuff.

class Employee{
	int EID;
	String name
	boolean available;

	public Employee(int eid,String name){
		EID=eid;
		this.name= name;
		available=true;
	}

	public void takeCall(){
		available=false;
	}
	public void finshCall(){
		 available=true;
	}

	public boolean getAvailability(){
		return available;
	}

}


class Respondent extends Employee{

public Respondent(int eid, String name){
	super(eid,name);
}

}



class Manager extends Employee{
	public Manager(int eid, String name){
	super(eid,name);
}

}



class Director extends Employee{
	public Director(int eid, String name){
	super(eid,name);
}

}



public class CallHandler{
	// call comes in and we have to manage it

	ArrayList<Respondent> r= new ArrayList<Respondent>();
	ArrayList<Manager> m= new ArrayList<Manager>();
	ArrayList<Director> d= new ArrayList<Director>();

	// create instances of the employees
	// x= number of Respondents
	// y= number of managers
	// z= number of directors
	public createEmployees(int x, int y, int z){
		// eid rep problem + name problem
		int eid=1;
		int mid=111;
		int did=1111;
		for(int i=0;i<x;i++){
			r.add(new Respondent(eid+i,"Respondent"));
		}
		for(int i=0;i<y;i++){
			r.add(new Respondent(eid+i,"Manager"));
		}
		for(int i=0;i<z;i++){
			r.add(new Respondent(eid+i,"Director"));
		}
	}

	public void dispatchCall(){
		// Look for Respondents 
		for(Respondents res :r){
			if(res.getAvailability){
				res.takeCall();
				System.out.println("The call was assigned to a respondent");
				return;
			}
		}
		// Look for Managers 
		for(Managers res :m){
			if(mes.getAvailability){
				mes.takeCall();
				System.out.println("The call was assigned to a manager");
				return;
			}
		}
		// Look for Director 
		for(Director dd :d){
			if(d.getAvailability){
				d.takeCall();
				System.out.println("The call was assigned to a Director");
				return;
			}
		}

		// Drawbacks is that we the call might be passed on to a senior in
		// cases where an employee gets free after the loop has iterated.
		// CONCURRENCY issues. Maybe we can just make this method Static.
	}

}

