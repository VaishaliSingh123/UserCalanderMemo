package com.example.userCalanderShedule.repository;

import com.example.userCalanderShedule.model.MemoModel;
import com.example.userCalanderShedule.model.UserMemoModel;
import org.springframework.data.repository.CrudRepository;
import org.springframework.http.ResponseEntity;

import java.util.Date;
import java.util.List;

public interface UserMemoRepository extends CrudRepository<UserMemoModel,Integer> {
    List<UserMemoModel> findMemoByUserId(Integer userId);

   // List<UserMemoModel> findByUserIdStartGreaterThanAndEndLessThan(Integer userId,Date start,Date end);

   //  List<UserMemoModel> findAllByStartGreaterThanAndEndLessThan(Date start,Date end);

    List<UserMemoModel> findAllByUserIdAndStartGreaterThanAndEndLessThan(Integer userId,Date start,Date end);

    List<UserMemoModel> findAllByEnd(Date end);
}
