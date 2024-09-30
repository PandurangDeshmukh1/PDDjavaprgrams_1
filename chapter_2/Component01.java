public class Component01 {
    private  String name;
    private  String type;
    private double price;
    public Component01(String name,String type,double price){
        this.name=name;
        this.type=type;
        this.price=price;
    }
    public void dispalyInfo(){
        System.out.println("This type of"+ type);
        System.out.println("This is the name"+name);
        System.out.println("This is price $"+price);
        System.out.println();
    }
   public class ComputerComponents{
    public static void main(String[] args) {
        Component01 cpu = new  Component01 ("intel core i7","CPU",299.99);
        Component01 ram = new  Component01 ("Corceare veranges","Ram",89.99);
        Component01 HDD =new   Component01 ("seagate 1tb","Hard Drive",49.99);
        System.out.println("Computer component");
        cpu.dispalyInfo();
        ram.dispalyInfo();
        HDD.dispalyInfo();


    }
   }
}
