package com.logesta.redissvc.repositories;


import com.logesta.redissvc.models.User;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;



@Repository
public interface UserRepository extends CrudRepository<User, String> {

}
