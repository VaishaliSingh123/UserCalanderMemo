package com.example.userCalanderShedule.exceptionHelper;

import com.example.userCalanderShedule.model.CustomErrorModel;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ExceptionHelper {

    @ExceptionHandler(value = {InvalidInputException.class})
    public ResponseEntity<CustomErrorModel> handleInvalidInputException(InvalidInputException ex){
        CustomErrorModel customErrorModel=new CustomErrorModel.CustomErrorBuilder().message(ex.getMessage()).build();
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(customErrorModel);
    }

    @ExceptionHandler(value = {UserException.class})
    public ResponseEntity<CustomErrorModel> handleUserException(UserException ex){
        CustomErrorModel customErrorModel=new CustomErrorModel.CustomErrorBuilder().message(ex.getMessage()).build();
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(customErrorModel);
    }



}
