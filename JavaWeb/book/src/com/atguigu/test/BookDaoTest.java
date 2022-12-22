package com.atguigu.test;
import com.atguigu.dao.BookDao;
import com.atguigu.dao.impl.BookDaoImpl;
import com.atguigu.pojo.Book;
import org.junit.Test;
import java.math.BigDecimal;
import java.util.List;



public class BookDaoTest {

    private BookDao bookDao = new BookDaoImpl();

    @Test
    public void addBook() {
        bookDao.addBook(new Book(null, "我爱中国共产党", "hbb", new BigDecimal(9999), 100, 99, null));
    }

    @Test
    public void deleteBookById() {

//        bookDao.deleteBookById(12);
    }

    @Test
    public void updateBook() {


        bookDao.updateBook(new Book(21,"我爱中国","hqb",new BigDecimal(9999),null,null,null));

    }

    @Test
    public void queryBookById() {
        System.out.println(bookDao.queryBookById(21));
    }

   /* @Test
    public void queryBookByName() {
        System.out.println(bookDao.queryBookByName("编程思想"));
    }*/

    @Test
    public void queryBook() {
        List<Book> books = bookDao.queryBooks();
        for (Book queryBook : books){
            System.out.println(queryBook);
        }
    }

    @Test
    public void queryForPageTotalCount(){
        System.out.println(bookDao.queryForPageTotalCount());
    }

    @Test
    public void queryForPageItems(){
        List<Book> books = bookDao.queryForPageItems(8, 4);
        for(Book queryBook : books){
            System.out.println(queryBook);
        }
    }

    @Test
    public void queryForPagePrice(){
        List<Book> books = bookDao.queryForPagePrice(10, 50, 0, 4);
        for (Book queryBook : books){
            System.out.println(queryBook);
        }
    }

    @Test
    public void queryPriceTotalCount(){

        System.out.println(bookDao.queryPriceTotalCount(10,50));
    }
}