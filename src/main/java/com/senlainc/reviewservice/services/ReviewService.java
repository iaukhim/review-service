package com.senlainc.reviewservice.services;

import com.senlainc.reviewservice.dtos.ReviewDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

public interface ReviewService {

    Page<ReviewDto> getAll(PageRequest pageRequest);

    void save (ReviewDto reviewDto);
}
