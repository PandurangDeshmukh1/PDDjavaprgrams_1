import java.io.DataOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class OutputExample {
    public static void main(String[] args) throws IOException {
        FileOutputStream f = new FileOutputStream("c:\\temp.txt");
        DataOutputStream d = new DataOutputStream(f);
        d.writeInt(70);
        d.flush();
        d.close();
        System.out.println("File written successfully.");
    }
}          