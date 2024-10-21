import java.util.Scanner;

class Product {
    int id;
    String name;
    double price;

   
    public Product(int id, String name, double price) {
        this.id = id;
        this.name = name;
        this.price = price;
    }
}

public class ProductMinPrice {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Product[] products = new Product[5];

      
        for (int i = 0; i < 5; i++) {
            System.out.print("Enter Product ID: ");
            int id = scanner.nextInt();
            scanner.nextLine(); // Consume newline
            System.out.print("Enter Product Name: ");
            String name = scanner.nextLine();
            System.out.print("Enter Product Price: ");
            double price = scanner.nextDouble();
            products[i] = new Product(id, name, price);
        }

        
        Product minPriceProduct = products[0];
        for (int i = 1; i < products.length; i++) {
            if (products[i].price < minPriceProduct.price) {
                minPriceProduct = products[i];
            }
        }

       
        System.out.println("Product with minimum price: " + minPriceProduct.name);

        scanner.close();
    }
}
