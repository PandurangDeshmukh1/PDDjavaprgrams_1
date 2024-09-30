public class Student9 {
	private int rollno;
	private String name;
	private float fee;
	public Student9(int rollno,String name,float fee) {
		this.rollno=rollno;
		this.name=name;
		this.fee=fee;
		
	}
	public void display() {
		System.out.println(rollno+" "+name+" "+fee);
	}
	public static void main(String args[]) {
		Student9 s1=new Student9(111,"ankit",5000);
		s1.display();
	}

}
