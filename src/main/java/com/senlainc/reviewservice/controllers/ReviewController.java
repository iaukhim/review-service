package com.senlainc.reviewservice.controllers;

import com.senlainc.reviewservice.dtos.ReviewDto;
import com.senlainc.reviewservice.services.ReviewService;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/review")
@RequiredArgsConstructor
public class ReviewController {

    private final ReviewService reviewService;
    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public Page<ReviewDto> loadAllReviews(
            @RequestParam(name = "offset", defaultValue = "0") @Min(0) Integer offset,
            @RequestParam(name = "limit", defaultValue = "10") @Min(1) @Max(50) Integer limit
            ){
        Page<ReviewDto> reviewDtos = reviewService.getAll(PageRequest.of(offset, limit));
        return reviewDtos;
    }

    @PutMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void save(@RequestBody ReviewDto reviewDto){
        reviewService.save(reviewDto);
    }

}
