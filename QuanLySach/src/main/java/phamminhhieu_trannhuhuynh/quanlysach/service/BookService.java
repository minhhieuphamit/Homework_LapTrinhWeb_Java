package phamminhhieu_trannhuhuynh.quanlysach.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import phamminhhieu_trannhuhuynh.quanlysach.model.Book;
import phamminhhieu_trannhuhuynh.quanlysach.repository.IBookRepository;

import java.util.List;

@Service
public class BookService {
    @Autowired
    private IBookRepository bookRepository;

    public List<Book> getAll() {
        return bookRepository.findAll();
    }

    public Book getBookById(Long id) {
        return bookRepository.findById(id).orElse(null);
    }

    public void addBook(Book book) {
        bookRepository.save(book);
    }

    public void updateBook(Book book) {
        bookRepository.save(book);
    }

    public void deleteBook(Long id) {
        bookRepository.deleteById(id);
    }
}
