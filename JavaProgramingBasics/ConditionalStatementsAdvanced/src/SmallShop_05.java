import java.util.Scanner;

public class SmallShop_05 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String product = input.nextLine();
        String city = input.nextLine();
        double quantity = Double.parseDouble(input.nextLine());
        double price = 0;
        if (city.equals("Sofia")) {
            switch (product) {
                case "coffee":
                    price = 0.5;
                    break;
                case "water":
                    price = 0.8;
                    break;
                case "beer":
                    price = 1.2;
                    break;
                case "sweets":
                    price = 1.45;
                    break;
                case "peanuts":
                    price = 1.6;
                    break;
            }
        } else if (city.equals("Plovdiv")) {
            switch (product) {
                case "coffee":
                    price = 0.4;
                    break;
                case "water":
                    price = 0.7;
                    break;
                case "beer":
                    price = 1.15;
                    break;
                case "sweets":
                    price = 1.3;
                    break;
                case "peanuts":
                    price = 1.5;
                    break;
            }
        } else if (city.equals("Varna")) {
            switch (product) {
                case "coffee":
                    price = 0.45;
                    break;
                case "water":
                    price = 0.7;
                    break;
                case "beer":
                    price = 1.1;
                    break;
                case "sweets":
                    price = 1.35;
                    break;
                case "peanuts":
                    price = 1.55;
                    break;
            }
        }

        double totalPrice = price * quantity;
        System.out.println(totalPrice);
    }
}
