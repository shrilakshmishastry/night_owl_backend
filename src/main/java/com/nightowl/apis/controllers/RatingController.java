package com.nightowl.apis.controllers;

import com.nightowl.apis.models.dtos.BookDto;
import com.nightowl.apis.models.dtos.RatingByUserDto;
import com.nightowl.apis.models.dtos.RatingDto;
import com.nightowl.apis.models.dtos.UserDto;
import com.nightowl.apis.models.entities.Rating;
import com.nightowl.apis.services.RatingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/v1/rating")
public class RatingController {

    private final RatingService ratingService;

    @Autowired
    public RatingController(RatingService ratingService) {
        this.ratingService = ratingService;
    }

    @GetMapping("/by_user")
    @Transactional
    public ArrayList<RatingByUserDto> getRatingByUser(@RequestBody UserDto user ) throws Exception {
        List<Rating> user_list = ratingService.getRatingByUser(user);

        ArrayList<RatingByUserDto> ratingByUserDtos = new ArrayList<RatingByUserDto>();

        for (int i = 0; i < user_list.size(); i++) {
            ratingByUserDtos.add( new RatingByUserDto(
                    user_list.get(i).getBook().getTitle(),
                    user_list.get(i).getUser().getName(),
                    user_list.get(i).getBook().getId(),
                    user_list.get(i).getUser().getId(),
                    user_list.get(i).getRating()

                    )
            );
        }

        return ratingByUserDtos;
    }

    @GetMapping("/for_book")
    public ArrayList<RatingByUserDto> getRatingForBook(@RequestBody BookDto book) throws Exception {
        List<Rating> user_list = ratingService.getRatingForBook(book);
        ArrayList<RatingByUserDto> rating = new ArrayList<RatingByUserDto>();
        for (int i = 0; i < user_list.size(); i++) {
            rating.add(
                    new RatingByUserDto(
                            user_list.get(i).getBook().getTitle(),
                            user_list.get(i).getUser().getName(),
                            user_list.get(i).getBook().getId(),
                            user_list.get(i).getUser().getId(),
                            user_list.get(i).getRating()
                    )
            );
        }

       return rating;
    }

    @PostMapping("/add_rating")
    public void addRating(@RequestBody RatingDto rating) throws Exception {
        ratingService.addRating(rating);
    }
}


