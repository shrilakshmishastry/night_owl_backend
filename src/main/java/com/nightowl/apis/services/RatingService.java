package com.nightowl.apis.services;

import com.nightowl.apis.models.dtos.BookDto;
import com.nightowl.apis.models.dtos.RatingDto;
import com.nightowl.apis.models.dtos.UserDto;
import com.nightowl.apis.models.entities.Book;
import com.nightowl.apis.models.entities.Rating;
import com.nightowl.apis.models.entities.User;
import com.nightowl.apis.repositories.BookRepository;
import com.nightowl.apis.repositories.UserRepository;
import com.nightowl.apis.repositories.RatingRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
public class RatingService {

    private static final Logger logger = LoggerFactory.getLogger(RatingService.class);

    private final RatingRepository ratingRepository;
    private final UserRepository userRepository;
    private final BookRepository bookRepository;

    public RatingService(RatingRepository ratingRepository, UserRepository userRepository, BookRepository bookRepository) {
        this.ratingRepository = ratingRepository;
        this.userRepository = userRepository;
        this.bookRepository = bookRepository;
    }

    @Transactional
    public List<Rating> getRatingByUser(UserDto userDto) throws Exception {
        Optional<User> user = userRepository.findById(userDto.getId());
        if (!user.isPresent()) {
            throw new Exception("User not found");
        }

        return  ratingRepository.findAllByUser(user.get());
    }

    public List<Rating> getRatingForBook(BookDto bookDto) throws Exception {
        Optional<Book> book = bookRepository.findById(bookDto.getId());
        if (book == null) {
            throw new Exception("User not found");
        }
        return ratingRepository.findAllByBook(book.get());
    }

    public void addRating(RatingDto ratingDto) throws Exception {


        // Get rating by book_id and user_id
        Optional<User> user = userRepository.findById(ratingDto.getUserId());
        if (!user.isPresent()) {
            throw new Exception("User not found");
        }

        Optional<Book> book = bookRepository.findById(ratingDto.getBookId());
        if (!book.isPresent()) {
            throw new Exception("book not found");
        }


        Rating rating = ratingRepository.findFirstByBookAndUser(book.get(), user.get()).orElse(null);

        // If that exstis update, else create new
        Rating  rating_new = new Rating();
//        if (rating != null) {
//           rating_new = new Rating();
//        }


        System.out.println(ratingDto.getRating());
        rating_new.setRating(ratingDto.getRating());

       System.out.println(book.get());
        rating_new.setBook(book.get());
        System.out.println(book.get().getPages());
        rating_new.setUser(user.get());
        System.out.println(user.get().getName());

        ratingRepository.save(rating_new);
    }
}
