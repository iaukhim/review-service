package com.senlainc.reviewservice.services.impl;

import com.senlainc.reviewservice.dtos.ReviewDto;
import com.senlainc.reviewservice.entities.Review;
import com.senlainc.reviewservice.repositories.ReviewRepository;
import com.senlainc.reviewservice.services.ReviewService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class ReviewServiceImpl implements ReviewService {

    private final ReviewRepository reviewRepository;


    @Override
    public Page<ReviewDto> getAll(PageRequest pageRequest) {
        Page<Review> reviews = reviewRepository.findAll(pageRequest);
        List<ReviewDto> reviewDtos = new ArrayList<>();

        return reviews.map(review -> {
            ReviewDto reviewDto = new ReviewDto();
            reviewDto.setText(review.getText());
            return reviewDto;
        });
    }

    @Override
    public void save(ReviewDto reviewDto) {
        Review review = new Review();
        review.setText(reviewDto.getText());
        reviewRepository.save(review);
    }
}
