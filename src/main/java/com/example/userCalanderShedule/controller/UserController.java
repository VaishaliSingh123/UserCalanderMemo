package com.example.userCalanderShedule.controller;


import com.example.userCalanderShedule.exceptionHelper.InvalidInputException;
import com.example.userCalanderShedule.exceptionHelper.UserException;
import com.example.userCalanderShedule.model.UserModel;
import com.example.userCalanderShedule.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping(path = "/user/*")
public class UserController {

    @Autowired
    UserRepository userRepository;



    @PostMapping(path = "create-user")
    public ResponseEntity<UserModel> createUser(@RequestBody UserModel userModel) throws UserException {
        try {
            if(userModel.getName()==null||userModel.getCompany()==null){
                throw new InvalidInputException("Invalid Input Exception");
            }else {
                UserModel userModel1 = new UserModel.UserModelBuilder().uuid(UUID.randomUUID().toString())
                        .name(userModel.getName())
                        .company(userModel.getCompany()).build();
                return ResponseEntity.ok( userRepository.save(userModel1));
            }
        }catch (InvalidInputException ex){
            throw new InvalidInputException("Invalid Input Exception");
        }catch (Exception ex){
            System.out.println(ex);
            throw new UserException("User Exception");
        }

    }

    @GetMapping(path = "get-user")
    public ResponseEntity<List<UserModel>> fetchUserList() throws UserException {
        try {
            return new ResponseEntity(userRepository.findAll(), HttpStatus.OK);

        }catch (Exception ex){
            throw new UserException("User Exception");
        }
    }

    /**
     * Issue in this Api check later
     * @param company
     * @return
     * @throws UserException
     */
    @GetMapping(path="findBy-company")
    public ResponseEntity<List<UserModel>> findByCompany(@RequestHeader(value = "company")String company) throws UserException {
        try {
            return new ResponseEntity(userRepository.findByCompany(company),HttpStatus.OK);

        }catch (Exception ex){
            throw new UserException("User Exception");
        }
    }

    @PostMapping(path = "create-memo")
    public
}
