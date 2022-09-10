package ru.netology.prodmanagtest;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;
import ru.netology.book.Book;
import ru.netology.manager.ProductManager;
import ru.netology.product.Product;
import ru.netology.repo.ProductRepository;
import ru.netology.smartphone.Smartphone;

public class ProductManagerTest {
    ProductRepository repo = new ProductRepository();
    ProductManager manager = new ProductManager(repo);

    Book product1 = new Book (  1, "book1", 20, "author1");
    Book product2 = new Book( 2, "book2", 20, "author2");
    Smartphone product3 = new Smartphone( 3, "smartphone1", 20, "manufacturer3");
    Smartphone product4 = new Smartphone(4, "smartphone2", 20, "manufacturer4");

    @Test
    public void productSearchSmartphone() {

        manager.add(product1);
        manager.add(product2);
        manager.add(product3);
        manager.add(product4);

        Product[] expected = { product3, product4 };
        Product[] actual = manager.searchBy("smartphone");

        Assertions.assertArrayEquals(expected, actual);
    }
    @Test
    public void productSearchBook() {

        manager.add(product1);
        manager.add(product2);
        manager.add(product3);
        manager.add(product4);

        Product[] expected = { product2 };
        Product[] actual = manager.searchBy("book2");

        Assertions.assertArrayEquals(expected, actual);
    }
    @Test
    public void productSearchNothing() {

        manager.add(product1);
        manager.add(product2);
        manager.add(product3);
        manager.add(product4);

        Product[] expected = { };
        Product[] actual = manager.searchBy("bok");

        Assertions.assertArrayEquals(expected, actual);
    }
}

