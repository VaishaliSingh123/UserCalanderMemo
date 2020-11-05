package com.example.userCalanderShedule.Sevice;

import com.example.userCalanderShedule.exceptionHelper.InvalidInputException;
import com.example.userCalanderShedule.exceptionHelper.UserException;
import com.example.userCalanderShedule.model.UserMemoModel;
import com.example.userCalanderShedule.model.UserModel;
import com.example.userCalanderShedule.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class UserService {

    @Autowired
    UserRepository userRepository;

    /**
     * Create user to add the memo
     * @param userModel
     * @return
     * @throws UserException
     */
    public UserModel createUserService(UserModel userModel) throws UserException {
        try {
            if(userModel.getName()==null||userModel.getCompany()==null){
                throw new InvalidInputException("Invalid Input Exception");
            }else {
                UserModel userModel1 = new UserModel.UserModelBuilder().uuid(UUID.randomUUID().toString())
                        .name(userModel.getName())
                        .company(userModel.getCompany()).build();
                return  userRepository.save(userModel1);
            }
        }catch (InvalidInputException ex){
            throw new InvalidInputException("Invalid Input Exception");
        }catch (Exception ex){
            System.out.println(ex);
            throw new UserException("User Exception");
        }

    }

    /**
     * get list of the user
     * @return
     * @throws UserException
     */
    public List<UserModel> getUserListService() throws UserException {
        try {
            return (List<UserModel>) userRepository.findAll();
        }catch(Exception ex){
            throw new UserException("User Exception");
        }
    }

    /**
     * get List of user by company name
     * @param company
     * @return
     * @throws UserException
     */
    public List<UserModel> getUserListByCompany(String company) throws UserException {
        try {
            return (List<UserModel>) userRepository.findByCompany(company);

        }catch (Exception ex){
            throw new UserException("User Exception");
        }
    }

}
