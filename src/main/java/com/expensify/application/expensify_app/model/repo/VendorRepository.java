package com.expensify.application.expensify_app.model.repo;

import com.expensify.application.expensify_app.model.Vendor;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface VendorRepository extends MongoRepository<Vendor, String> {

}
