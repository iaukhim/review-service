package com.senlainc.reviewservice.repositories;

import com.senlainc.reviewservice.entities.Review;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReviewRepository extends MongoRepository<Review, String> {

}
