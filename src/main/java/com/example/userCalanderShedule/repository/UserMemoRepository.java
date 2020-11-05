package com.example.userCalanderShedule.repository;

import com.example.userCalanderShedule.model.MemoModel;
import com.example.userCalanderShedule.model.UserMemoModel;
import org.springframework.data.repository.CrudRepository;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface UserMemoRepository extends CrudRepository<UserMemoModel,Integer> {
    List<UserMemoModel> findMemoByUserId(Integer userId);
}
