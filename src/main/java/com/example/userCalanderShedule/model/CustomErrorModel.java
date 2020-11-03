package com.example.userCalanderShedule.model;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
public class CustomErrorModel {

    private String code;
    private String message;

    public String getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }

    public static class CustomErrorBuilder{
        private String code;
        private String message;

        public CustomErrorBuilder code(String code){
            this.code=code;
            return this;
        }
        public CustomErrorBuilder message(String message){
            this.message=message;
            return this;
        }
        public CustomErrorModel build(){
            CustomErrorModel customErrorModel=new CustomErrorModel();
            customErrorModel.code=this.code;
            customErrorModel.message=this.message;
            return customErrorModel;
        }
    }
}
