import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        int n;
        Scanner sc = new Scanner(System.in);
        System.out.println("Nhập vào số lượng sản phẩm: ");
        n = sc.nextInt();
        Product[] listProduct = new Product[n];
        input(listProduct);
        output(listProduct);
        System.out.println("Tổng giá của các sản phẩm: " +  totalPrice(listProduct));

        findName(listProduct);
        changeProduct(listProduct);
        deleteProduct(listProduct);
    }

    public static void input (Product[] listProduct) {
        for (int i = 0; i < listProduct.length; i++) {
            Scanner sc = new Scanner(System.in);
            System.out.println("Nhập vào thông tin sản phẩm: "+ (i+1));
            System.out.print("Nhập Id sản phẩm: ");
            int id = sc.nextInt();
            System.out.print("Nhập tên sản phẩm: ");
            sc.nextLine();
            String name = sc.nextLine();
            System.out.print("Nhập giá sản phẩm: ");
            double price = sc.nextDouble();
            System.out.print("Nhập loại sản phẩm: ");
            sc.nextLine();
            String category = sc.nextLine();
            Product product = new Product(id, name, price, category);
            listProduct[i] = product;
        }
    }

    public static void output(Product[] listProduct) {
        for (int i = 0; i < listProduct.length; i++) {
            System.out.println(listProduct[i]);
        }
    }

    public static double totalPrice(Product[] listProduct) {
        double sum = 0;
        for (int i = 0; i < listProduct.length; i++) {
            sum += listProduct[i].price;
        }
        return sum;
    }

    public static void findName(Product[] listProduct) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Nhập tên sản phẩm muốn tìm");
        String name = scanner.nextLine();
        for (int i = 0; i < listProduct.length; i++) {
            if (listProduct[i].name.equals(name)) {
                System.out.println(listProduct[i]);
            }
        }
    }

    public static void changeProduct(Product[] listProduct) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Nhập Id sản phẩm muốn sửa");
        int idValue = sc.nextInt();
        for (int i = 0; i < listProduct.length; i++) {
            if (listProduct[i].id == idValue) {
                Scanner scanner = new Scanner(System.in);
                System.out.println("Nhập vào thông tin sản phẩm muốn sửa: ");
                int id = listProduct[i].id;
                System.out.print("Nhập tên sản phẩm: ");
                String name = scanner.nextLine();
                System.out.print("Nhập giá sản phẩm: ");
                double price = scanner.nextDouble();
                scanner.nextLine();
                System.out.print("Nhập loại sản phẩm: ");
                String category = scanner.nextLine();

                Product product = new Product(id, name, price, category);
                listProduct[i] = product;
            }
        }
        for (int i = 0; i < listProduct.length; i++) {
            System.out.println("\n" + listProduct[i]);
        }
    }
    public static void deleteProduct(Product[] listProduct) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Nhập Id sản phẩm muốn xóa");
        int idValue = sc.nextInt();
        int index = -1;
        for (int i = 0; i< listProduct.length; i++){
                if (listProduct[i].id == idValue) {
                    index = i;
                }
            }
        Product[] newListProduct = new Product[listProduct.length-1];
            for (int i=0; i<index; i++){
                newListProduct[i] = listProduct[i];
            }
            for (int i=index + 1; i<listProduct.length; i++){
                newListProduct[i-1] = listProduct[i];
            }
        for (int i = 0; i < newListProduct.length; i++) {
            System.out.println("\n" + newListProduct[i]);
            }
        }
    }

