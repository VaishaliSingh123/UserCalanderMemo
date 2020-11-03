package com.example.userCalanderShedule.repository;

import com.example.userCalanderShedule.model.UserModel;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<UserModel,Integer> {

    UserModel findByCompany(String company);
}
