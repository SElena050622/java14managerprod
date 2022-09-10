package ru.netology.prodrepotest;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;
import ru.netology.book.Book;
import ru.netology.exception.NotFoundException;
import ru.netology.manager.ProductManager;
import ru.netology.product.Product;
import ru.netology.repo.ProductRepository;
import ru.netology.smartphone.Smartphone;

public class ProductRepositoryTest {

    ProductRepository repo = new ProductRepository();


    Book product1 = new Book(1, "book1", 20, "author1");
    Book product2 = new Book( 2, "book2", 20, "author2");
    Smartphone product3 = new Smartphone( 3, "smartphone1", 20, "manufacturer3");
    Smartphone product4 = new Smartphone(4, "smartphone2", 20, "manufacturer4");
    @Test
    public void productSave() {

        repo.add(product1);
        repo.add(product2);
        repo.add(product3);
        repo.add(product4);

        Product[] expected = { product1, product2, product3, product4 };
        Product[] actual = repo.findAll();

        Assertions.assertArrayEquals(expected, actual);
    }
    @Test
    public void productRemoveBy() {

        repo.add(product1);
        repo.add(product2);
        repo.add(product3);
        repo.add(product4);
        repo.removeById(product3.getId());

        Product[] expected = { product1, product2, product4 };
        Product[] actual = repo.findAll();

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void testIfExceptionThrowIfProductDosNotExist() {

        repo.add(product1);
        repo.add(product2);
        repo.add(product3);
        repo.add(product4);

        Assertions.assertThrows(RuntimeException.class, () -> {
            repo.removeById(5);
        });
    }

    @Test
    public void testIfExceptionThrowIfProductDosMinus() {

        repo.add(product1);
        repo.add(product2);
        repo.add(product3);
        repo.add(product4);

        Assertions.assertThrows(RuntimeException.class, () -> {
            repo.removeById(-1);
        });
    }
}


