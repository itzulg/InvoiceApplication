import java.util.Scanner;

import com.itzul.invoiceapplication.model.*;

public class InvoiceApp {
    public static void main(String[] args) {
        Client client = new Client();
        client.setNif("5555-5555");
        client.setName("Andres");

        @SuppressWarnings("resource")
        Scanner sc = new Scanner(System.in);
        System.out.print("Invoice description: ");
        Invoice invoice = new Invoice(sc.nextLine(), client);

        System.out.println();

        Product product;

        for(int i = 0; i<3; i++){
            product = new Product();
            System.out.print("Product No. " + product.getId() + " Name: ");
            product.setName(sc.nextLine());

            System.out.print("Price: ");
            product.setPrice(sc.nextFloat());

            System.out.print("Product quantity: ");
            invoice.addInvoiceItem(new InvoiceItem(sc.nextInt(),product));

            System.out.println();
            sc.nextLine();
        }
        System.out.println(invoice.getDetails());

    }

}
