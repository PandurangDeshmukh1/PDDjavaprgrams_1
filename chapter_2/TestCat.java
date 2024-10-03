public class play {
    public void move(){
        System.out.println("boys want to paly");
    }
}
class game extends play {
    public void move(){
        super.move();// invoce the super class method
        System.out.println("Game play");
    }
}
public class TestCat {
    public static void main(String args[]){
         play b = new game();
         b.move();
    }
}
