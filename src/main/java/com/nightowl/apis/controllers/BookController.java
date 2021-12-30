package com.nightowl.apis.controllers;

import com.nightowl.apis.models.dtos.BookGetDto;
import com.nightowl.apis.models.entities.Book;
import com.nightowl.apis.models.dtos.BookDto;
import com.nightowl.apis.services.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "api/v1/books")
public class BookController {

    private final BookService bookService;

    @Autowired
    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @GetMapping("/")
    public ArrayList<BookGetDto> getBooks(){
        List<Book> book_optional = bookService.getAllBook();
        ArrayList<BookGetDto> books1 = new ArrayList<BookGetDto>();

        for (int i = 0; i < book_optional.size(); i++) {
            books1.add(
                    new BookGetDto(
                            book_optional.get(i).getId(),
                            book_optional.get(i).getTitle(),
                            book_optional.get(i).getAuthorName(),
                            book_optional.get(i).getCategory().getName(),
                            book_optional.get(i).getIsbn(),
                            book_optional.get(i).getPages(),
                            book_optional.get(i).getWebsiteUrl(),
                            book_optional.get(i).getCover(),
                            book_optional.get(i).getDescription()

                    )
            );
        }

        return  books1;
    }

    @PostMapping("/")
    public void addBook(@RequestBody BookDto request){

        bookService.addBook(request);
    }

    @DeleteMapping("/")
    public void deleteABook(@RequestBody Book book){
    }

    @GetMapping("/{bookId}")
    public ArrayList<BookGetDto> getBookById(@PathVariable(value = "bookId") Long Id ){


        Book book_optional = bookService.getBookById(Id).get();

        ArrayList<BookGetDto> bookGetDtos = new ArrayList<BookGetDto>();
        BookGetDto book = new BookGetDto(
                book_optional.getId(),
                book_optional.getTitle(),
                book_optional.getAuthorName(),
                book_optional.getCategory().getName(),
                book_optional.getIsbn(),
                book_optional.getPages(),
                book_optional.getWebsiteUrl(),
                book_optional.getCover(),
                book_optional.getDescription()

        );

        bookGetDtos.add(book);

        return  bookGetDtos;
    }
}

