package com.example.userCalanderShedule.Sevice;

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
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class MemoService {

    @Autowired
    UserRepository userRepository;

    @Autowired
    UserMemoRepository userMemoRepository;

    public UserMemoModel addMemoService(Integer userId,UserMemoModel userMemoModel) throws UserException {
        try {
            if(userId<1){
                throw new InvalidInputException("wrong input");
            }else {
                Optional user = userRepository.findById(userId);

                if (user.isPresent()) {
                    UserMemoModel userMemoModel1 = new UserMemoModel.UserMemoBuilder().userId(userId)
                            .start(userMemoModel.getStart())
                            .end(userMemoModel.getEnd())
                            .memo(userMemoModel.getMemo()).build();

                    return userMemoRepository.save(userMemoModel1);

                }
            }

        }catch (InvalidInputException ex){
            throw new InvalidInputException("wrong input");
        }catch (Exception ex){
            throw new UserException(ex.toString());
        }
        return null;
    }


    public List<MemoModel> getAllMemoOfUserService(Integer userId) throws UserException {

        try{
            if(userId<1){
                throw new InvalidInputException("Invalid Input Exception");
            }else {
                List<UserMemoModel> userMemoModeList = userMemoRepository.findMemoByUserId(userId);

                List<MemoModel> memoList = new ArrayList<MemoModel>();

                for (UserMemoModel memo : userMemoModeList) {
                    memoList.add(new MemoModel(memo.getMemo().toString()));
                }

                return memoList;
            }
        }catch (InvalidInputException ex){
            throw new InvalidInputException("user Exception");
        }catch (Exception ex){
            throw new UserException("user Exception");
        }

    }

    public SingleUserMemoCalander getUserDateMemoListService(Integer userId,UserMemoModel userMemoModel) throws UserException {
        try {
            if (userMemoModel.getStart() == null && userMemoModel.getEnd() == null) {
                List<MemoModel> memoList = getAllMemoOfUserService(userId);

                SingleUserMemoCalander singleUserMemoCalander = new SingleUserMemoCalander(userId, memoList);

                return singleUserMemoCalander;

            } else if (userMemoModel.getStart() == null || userMemoModel.getEnd() == null) {

                throw new UserException("missing arguments");
                /**
                 * remaining
                 */


            } else {
                List<UserMemoModel> list = userMemoRepository.findAllByUserIdAndStartGreaterThanAndEndLessThan(userId, userMemoModel.getStart(), userMemoModel.getEnd());

                List<MemoModel> memoList = new ArrayList<>();
                for (UserMemoModel memo : list) {
                    memoList.add(new MemoModel(memo.getMemo()));
                    // System.out.println(memo.getMemo());
                }

                SingleUserMemoCalander singleUserMemoCalander = new SingleUserMemoCalander(userId, memoList);

                return singleUserMemoCalander;
            }
        }catch (Exception ex){
            throw new UserException("Invalid Exception");

        }
    }

}
