import java.util.ArrayList;
import java.util.Scanner;

/**
 * 图书管理类 - 提供图书的增删改查操作
 */
public class BookManager {
    private ArrayList<Book> books;  // 存储图书的集合
    private Scanner scanner;        // 用户输入扫描器

    // 构造方法
    public BookManager() {
        books = new ArrayList<>();
        scanner = new Scanner(System.in);
        // 初始化一些示例数据
        initBooks();
    }

    /**
     * 初始化示例图书数据
     */
    private void initBooks() {
        books.add(new Book("001", "Java从入门到精通", "张三"));
        books.add(new Book("002", "数据结构与算法", "李四"));
        books.add(new Book("003", "设计模式", "王五"));
    }

    /**
     * 显示主菜单
     */
    public void showMenu() {
        System.out.println("\n========== 图书管理系统 ==========");
        System.out.println("1. 查看所有图书");
        System.out.println("2. 添加图书");
        System.out.println("3. 删除图书");
        System.out.println("4. 借阅图书");
        System.out.println("5. 归还图书");
        System.out.println("6. 查询图书");
        System.out.println("0. 退出系统");
        System.out.println("================================");
        System.out.print("请选择操作(0-6): ");
    }

    /**
     * 运行系统
     */
    public void run() {
        while (true) {
            showMenu();
            int choice = scanner.nextInt();
            scanner.nextLine(); // 消费换行符

            switch (choice) {
                case 1:
                    showAllBooks();
                    break;
                case 2:
                    addBook();
                    break;
                case 3:
                    deleteBook();
                    break;
                case 4:
                    borrowBook();
                    break;
                case 5:
                    returnBook();
                    break;
                case 6:
                    searchBook();
                    break;
                case 0:
                    System.out.println("感谢使用图书管理系统！");
                    return;
                default:
                    System.out.println("无效选项，请重新选择！");
            }
        }
    }

    /**
     * 显示所有图书
     */
    public void showAllBooks() {
        if (books.isEmpty()) {
            System.out.println("图书馆暂无图书！");
            return;
        }

        System.out.println("\n---------- 所有图书 ----------");
        for (int i = 0; i < books.size(); i++) {
            System.out.println((i + 1) + ". " + books.get(i));
        }
        System.out.println("-----------------------------");
    }

    /**
     * 添加图书
     */
    public void addBook() {
        System.out.print("请输入图书编号: ");
        String id = scanner.nextLine();

        // 检查图书编号是否已存在
        if (findBookById(id) != null) {
            System.out.println("图书编号已存在，请重新输入！");
            return;
        }

        System.out.print("请输入图书名称: ");
        String title = scanner.nextLine();

        System.out.print("请输入作者姓名: ");
        String author = scanner.nextLine();

        Book book = new Book(id, title, author);
        books.add(book);
        System.out.println("图书添加成功！");
    }

    /**
     * 删除图书
     */
    public void deleteBook() {
        System.out.print("请输入要删除的图书编号: ");
        String id = scanner.nextLine();

        Book book = findBookById(id);
        if (book == null) {
            System.out.println("未找到该图书！");
            return;
        }

        if (book.isBorrowed()) {
            System.out.println("该图书已被借出，无法删除！");
            return;
        }

        books.remove(book);
        System.out.println("图书删除成功！");
    }

    /**
     * 借阅图书
     */
    public void borrowBook() {
        System.out.print("请输入要借阅的图书编号: ");
        String id = scanner.nextLine();

        Book book = findBookById(id);
        if (book == null) {
            System.out.println("未找到该图书！");
            return;
        }

        if (book.isBorrowed()) {
            System.out.println("该图书已被借出！");
            return;
        }

        book.setBorrowed(true);
        System.out.println("图书借阅成功！");
    }

    /**
     * 归还图书
     */
    public void returnBook() {
        System.out.print("请输入要归还的图书编号: ");
        String id = scanner.nextLine();

        Book book = findBookById(id);
        if (book == null) {
            System.out.println("未找到该图书！");
            return;
        }

        if (!book.isBorrowed()) {
            System.out.println("该图书未被借出！");
            return;
        }

        book.setBorrowed(false);
        System.out.println("图书归还成功！");
    }

    /**
     * 查询图书
     */
    public void searchBook() {
        System.out.print("请输入图书编号或书名关键字: ");
        String keyword = scanner.nextLine();

        ArrayList<Book> result = new ArrayList<>();
        for (Book book : books) {
            if (book.getId().equals(keyword) ||
                    book.getTitle().contains(keyword)) {
                result.add(book);
            }
        }

        if (result.isEmpty()) {
            System.out.println("未找到相关图书！");
            return;
        }

        System.out.println("\n---------- 查询结果 ----------");
        for (int i = 0; i < result.size(); i++) {
            System.out.println((i + 1) + ". " + result.get(i));
        }
        System.out.println("-----------------------------");
    }

    /**
     * 根据编号查找图书
     * @param id 图书编号
     * @return 找到的图书对象，未找到返回null
     */
    private Book findBookById(String id) {
        for (Book book : books) {
            if (book.getId().equals(id)) {
                return book;
            }
        }
        return null;
    }
}
