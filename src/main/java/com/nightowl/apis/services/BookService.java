package com.nightowl.apis.services;

import com.nightowl.apis.models.dtos.BookDto;
import com.nightowl.apis.models.entities.Category;
import com.nightowl.apis.repositories.BookRepository;
import com.nightowl.apis.repositories.CategoryRepository;
import com.nightowl.apis.models.entities.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
public class BookService {

    private  final BookRepository bookRepository;
    private final CategoryRepository categoryRepository;

    public BookService(BookRepository bookRepository, CategoryRepository categoryRepository) {
        this.bookRepository = bookRepository;
        this.categoryRepository = categoryRepository;
    }

    @Autowired
    public List<Book> getAllBook(){
        return  bookRepository.findAll();
    }

    public Optional<Book> getBookById(Long Id){
        Optional<Book> bookOptional =
                bookRepository.findById(Id);
        if(bookOptional.isPresent()){

            return bookRepository.findById(Id);
        }
        throw new  IllegalStateException("Book not found");
    }

    @Transactional
    public void addBook(BookDto bookDto) {

        Optional<Book> bookOptional = bookRepository.findBookByName(bookDto.getTitle());

        if(bookOptional.isPresent()){
            throw new IllegalStateException("Book already there");
        }


        Book book = new Book(
                bookDto.getTitle(),
                bookDto.getAuthorName(),
                bookDto.getIsbn(),
                bookDto.getPages(),
                bookDto.getWebsiteUrl(),
                bookDto.getCover(),
                bookDto.getDescription()
        );

//        System.out.println(bookDto.getCategoryId());
        Category category = categoryRepository.findCategoryByName(bookDto.getCategoryId()).orElse(null);
        book.setCategory(category);
//        System.out.println(category);
        bookRepository.save(book);
    }
}
