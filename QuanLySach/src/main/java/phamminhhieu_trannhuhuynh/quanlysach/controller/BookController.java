package phamminhhieu_trannhuhuynh.quanlysach.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import phamminhhieu_trannhuhuynh.quanlysach.model.Book;
import phamminhhieu_trannhuhuynh.quanlysach.service.BookService;
import phamminhhieu_trannhuhuynh.quanlysach.service.CategoryService;

import java.util.List;

@Controller
@RequestMapping("/books")
public class BookController {
    @Autowired
    private BookService bookService;

    @Autowired
    private CategoryService categoryService;

    @GetMapping
    public String showAllBooks(Model model) {
        List<Book> books = bookService.getAll();
        model.addAttribute("book", books);
        return "book/list";
    }

    @GetMapping("/add")
    public String addBookForm(Model model) {
        model.addAttribute("book", new Book());
        model.addAttribute("categories", categoryService.getAll());
        return "book/add";
    }

    @PostMapping("/add")
    public String addBookForm(@ModelAttribute("book") Book book) {
        bookService.addBook(book);
        return "redirect:/books";
    }

    @GetMapping("/delete/{id}")
    public String delete(@ModelAttribute("id") Long id) {
        bookService.deleteBook(id);
        return "redirect:/books";
    }

    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") Long id, Model model) {
        Book book = bookService.getBookById(id);
        model.addAttribute("book", book);
        return "book/edit";
    }

    @PostMapping("/edit/{id}")
    public String edit(@PathVariable("id") Long id, Book book, Model model) {
        bookService.updateBook(book);
        return "redirect:/home";
    }
}
