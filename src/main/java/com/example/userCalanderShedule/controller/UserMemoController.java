package com.example.userCalanderShedule.controller;

import com.example.userCalanderShedule.exceptionHelper.InvalidInputException;
import com.example.userCalanderShedule.exceptionHelper.UserException;
import com.example.userCalanderShedule.model.MemoModel;
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




@PostMapping(path = "memo-create")
    public ResponseEntity<UserMemoModel> addMemo(@RequestHeader(name="userId")Integer userId, @RequestBody UserMemoModel userMemoModel) throws UserException {

    try {
        if(userId<1){
            throw new InvalidInputException("wrong input");
        }else {
            Optional user = userRepository.findById(userId);

            if (user.isPresent()) {
                UserMemoModel userMemoModel1 = new UserMemoModel.UserMemoBuilder().userId(userId).date(userMemoModel.getDate())
                        .start(userMemoModel.getStart())
                        .end(userMemoModel.getEnd())
                        .memo(userMemoModel.getMemo()).build();

                return ResponseEntity.ok(userMemoRepository.save(userMemoModel1));


            }
        }

    }catch (InvalidInputException ex){
        throw new InvalidInputException("wrong input");
    }catch (Exception ex){
        throw new UserException(ex.toString());
    }
    return null;
}
@GetMapping(path="get-user-memo")
    public ResponseEntity<List<MemoModel>> getAllMemoOfUser(@RequestHeader(name="userId")Integer userId){

     List<UserMemoModel> userMemoModeList=  userMemoRepository.findMemoByUserId(userId);

     List<MemoModel> memoList=new ArrayList<MemoModel>();

    for(UserMemoModel memo:userMemoModeList){
       System.out.println(memo);
       memoList.add(new MemoModel(memo.getMemo().toString()));
    }

    return new ResponseEntity(memoList,HttpStatus.OK);
}

}
