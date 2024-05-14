import java.util.ArrayList;
import java.util.List;

class Category {
    private String name;
    private List<Product> products;

    // Создаю пустую категорию
    Category() {
        this.name = "Main Category";
        this.products = new ArrayList<>();
    }

    // Создаю категорию с именем
    Category(String name) {
        this.name = name;
        this.products = new ArrayList<>();
    }

    // Создаю категорию с именем и списком продуктов
    Category(String name, List<Product> products) {
        this.name = name;
        this.products = products;
    }

    // Добавляем продукты в категорию
    void addProduct(Product product) {
        products.add(product);
    }

    // Удаляем продукты с категории
    void removeProduct(Product product) {
        products.remove(product);
    }
}

class ShoppingCart {
    private List<Product> products;
    private User user;

    // Пустая корзина
    ShoppingCart() {
        this.products = new ArrayList<>();
        this.user = null;
    }

    // Корзина с юзером
    ShoppingCart(User user) {
        this.products = new ArrayList<>();
        this.user = user;
    }

    // Корзина с продуктами и юзером
    ShoppingCart(User user, List<Product> products) {
        this.products = products;
        this.user = user;
    }

    // Тут мы добавляем продукты в корзину
    void addProduct(Product product) {
        products.add(product);
    }

    // Удаляем продукты с корзины
    void removeProduct(Product product) {
        products.remove(product);
    }

    // Считаем сумму товаров в корзине
    double calculateTotalPrice() {
        double totalPrice = 0.0;
        for (Product product : products) {
            totalPrice += product.getPrice();
        }
        return totalPrice;
    }

    // Оплата покупки
    void pay() {
        System.out.println("Total Price: $" + calculateTotalPrice());
    }
}

public class Main {
    public static void main(String[] args) {
        // Создаем категорию и добавляем в нее продукты
        Category category1 = new Category("Electronics");
        Category category2 = new Category("Clothing", List.of(new Product("T-Shirt", 19.99, "C001")));

        Product laptop = new Product("Laptop", 999.99, "P001");
        category1.addProduct(laptop);

        // Создаю корзину
        ShoppingCart cart1 = new ShoppingCart(guest1, List.of(product1, product2));
        ShoppingCart cart2 = new ShoppingCart(user1);

        // Добавляю продукты в корзину
        cart1.addProduct(product1);
        cart1.addProduct(product2);
        cart2.addProduct(product3);

        // Удаляю продукты в корзину
        cart1.removeProduct(product1);

        // Оплата покупки
        System.out.println("Cart 1 Total:");
        cart1.pay();
        System.out.println("Cart 2 Total:");
        cart2.pay();
    }
}
