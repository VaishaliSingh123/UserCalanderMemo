package com.example.userCalanderShedule.controller;

import com.example.userCalanderShedule.Sevice.MemoService;
import com.example.userCalanderShedule.exceptionHelper.InvalidInputException;
import com.example.userCalanderShedule.exceptionHelper.UserException;
import com.example.userCalanderShedule.model.MemoModel;
import com.example.userCalanderShedule.model.SingleUserMemoCalander;
import com.example.userCalanderShedule.model.UserMemoModel;
import com.example.userCalanderShedule.repository.UserMemoRepository;
import com.example.userCalanderShedule.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "/memo/*")
public class UserMemoController {

    @Autowired
    UserRepository userRepository;

    @Autowired
    UserMemoRepository userMemoRepository;

    @Autowired
    MemoService memoService;




@PostMapping(path = "memo-create")
    public ResponseEntity<UserMemoModel> addMemo(@RequestHeader(name="userId")Integer userId, @RequestBody UserMemoModel userMemoModel) throws UserException {

    try {
        return ResponseEntity.ok(memoService.addMemoService(userId,userMemoModel));
    }catch (InvalidInputException ex){
        throw new InvalidInputException("wrong input");
    }catch (Exception ex){
        throw new UserException(ex.toString());
    }
}


@GetMapping(path="get-user-memo-list")
    public ResponseEntity<List<MemoModel>> getAllMemoOfUser(@RequestHeader(name="userId")Integer userId) throws UserException {

      return new ResponseEntity(memoService.getAllMemoOfUserService(userId),HttpStatus.OK);
    }

@PostMapping(path="get-user-date-memo")
    public ResponseEntity<SingleUserMemoCalander> getUserDateMemoList(@RequestHeader(name="userId")Integer userId, @RequestBody  UserMemoModel userMemoModel) throws UserException {
       try {
           memoService.getUserDateMemoListService(userId,userMemoModel);

           return new ResponseEntity(memoService.getUserDateMemoListService(userId,userMemoModel),HttpStatus.OK);
       }catch (Exception ex){
           throw new UserException("user Exception");
       }


    }

}
