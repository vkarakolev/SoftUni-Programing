import java.util.Scanner;

public class E05_PrintPartOfASCIITable {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int startNum = Integer.parseInt(scanner.nextLine());
        int endNum = Integer.parseInt(scanner.nextLine());

        for (int i = startNum; i <= endNum; i++) {
            System.out.print((char) i + " ");
        }
    }
}
