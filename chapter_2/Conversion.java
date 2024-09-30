interface Conversion {
    double GM_TO_KG = 1000; // Changed to uppercase for constant convention
    double gmtokg(double gm);
    double kgtomg(double kg);
}

class Convert implements Conversion {
    public double gmtokg(double gm) {
        return gm / GM_TO_KG;
    }

    public double kgtomg(double kg) {
        return kg * GM_TO_KG;
    }
}

public class ImplIface1 {
    public static void main(String[] args) {
        Convert convObj = new Convert();
        Conversion c = convObj; // Use an instance of Convert
        System.out.println("2000 gm = " + c.gmtokg(2000) + " kg");
        System.out.println("50 kg = " + c.kgtomg(50) + " gm");
    }
}
