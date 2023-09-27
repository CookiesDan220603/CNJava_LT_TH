

import java.util.List;
import java.util.Scanner;

public class Program {
    private static Scanner sc = new Scanner(System.in);

    public static void main(String args[]) {

        // Nhập thông tin kết nối vào database
        System.out.print("Enter server's url: "); // Vd: "jdbc:postgresql://localhost:5432"
        String serverUrl = sc.nextLine();
        System.out.print("Enter user: "); // Vd: "root"
        String user = sc.nextLine();
        System.out.print("Enter password: "); // Vd: "root"
        String password = sc.nextLine();

        // Khởi tạo productDao dùng để thao tác với db
        ProductDAO productDao = new ProductDAO(serverUrl, user, password);

        if (productDao.getConnection() != null) {
            System.out.println("Connect database successfully!");

            handleUserChoose(productDao);

        } else {
            System.out.println("Connect database failure!");
            System.out.println("-------End program-------");
        }
    }

    // Hàm hiển thị các lựa chọn cho người dùng
    private static void handleUserChoose(ProductDAO productDao) {
        boolean existOption = false;

        do {
            System.out.println("\n-----------Options-----------");
            System.out.println("1. Read all products.");
            System.out.println("2. Read detail of a product by id.");
            System.out.println("3. Add a new product.");
            System.out.println("4. Update a product.");
            System.out.println("5. Delete a product by id.");
            System.out.println("6. Exit program.");
            System.out.print("\nYour choice: ");
            String choice = sc.nextLine();

            switch (choice) {
                case "1":
                    handleReadAllProducts(productDao);
                    break;
                case "2":
                    handleReadProductDetailById(productDao);
                    break;
                case "3":
                    handleAddNewProduct(productDao);
                    break;
                case "4":
                    handleUpdateProduct(productDao);
                    break;
                case "5":
                    handleDeleteProductById(productDao);
                    break;
                case "6":
                    existOption = true;
                    System.out.println("-------End program-------");
                    break;
                default:
                    System.out.println("Your select is not exist, please choose again.");
            }
        } while (!existOption);

    }

    // Hàm xử lý đọc tất cả thông tin sản phẩm
    private static void handleReadAllProducts(ProductDAO productDao) {
        List<Product> products = productDao.readAll();

        System.out.println("\nProduct list:");
        for (Product product : products) {
            System.out.println(product.toString());
        }
    }

    // Hàm xử lý đọc thông tin sản phẩm theo id
    private static void handleReadProductDetailById(ProductDAO productDao) {
        System.out.print("Enter product's id:");
        Integer id = sc.nextInt();
        sc.nextLine();
        Product product = productDao.read(id);
        if (product != null) {
            System.out.println(product.toString());
        } else {
            System.out.println("Product with id=" + id + " does not exist.");
        }
    }

    // Hàm xử lý thêm sản phẩm mới
    private static void handleAddNewProduct(ProductDAO productDao) {
        System.out.print("Enter product's name: ");
        String name = sc.nextLine();
        System.out.print("Enter product's price: ");
        Integer price = sc.nextInt();
        sc.nextLine();
        Product product = new Product();
        product.setName(name);
        product.setPrice(price);
        if (productDao.add(product) != null) {
            System.out.println("Add product sucessfully!");
        } else {
            System.out.println("Add product failure, please try again");
        }
    }

    // Hảm xử lý cập nhật sản phẩm
    private static void handleUpdateProduct(ProductDAO productDao) {
        System.out.print("Enter product's id: ");
        Integer id = sc.nextInt();
        sc.nextLine();
        Product product = productDao.read(id);
        if (product != null) {
            System.out.print("Enter a new name for product: ");
            String name = sc.nextLine();
            System.out.print("Enter a new price for product: ");
            Integer price = sc.nextInt();
            sc.nextLine();
            product.setName(name);
            product.setPrice(price);
            if (productDao.update(product)) {
                System.out.println("Update product successfully!");
            } else {
                System.out.println("Update product failure, please try again.");
            }
        } else {
            System.out.println("Product with id=" + id + " does not exist.");
        }

    }

    // Hảm xử lý xóa sản phẩm
    private static void handleDeleteProductById(ProductDAO productDao) {
        System.out.print("Enter product's id: ");
        Integer id = sc.nextInt();
        sc.nextLine();
        if (productDao.delete(id)) {
            System.out.println("Delete product successfully!");
        } else {
            System.out.println("Product with id=" + id + " does not exist.");
        }
    }
}