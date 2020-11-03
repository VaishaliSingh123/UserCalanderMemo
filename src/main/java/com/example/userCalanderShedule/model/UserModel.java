package com.example.userCalanderShedule.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity(name="wal_user")
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class UserModel {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @NotNull
    private String uuid;

    @NotNull
    private String name;

    @NotNull
    @Column(name="company_name")
    private String company;

    public Integer getId(){
        return id;
    }
    public String getUuid(){
        return uuid;
    }
    public String getName(){
        return name;
    }
    public String getCompany(){
        return company;
    }

    public static class UserModelBuilder{
        private Integer id;
        private String uuid;
        private String name;
        private String company;

        public UserModelBuilder id(Integer id){
            this.id=id;
            return this;
        }
        public UserModelBuilder uuid(String uuid){
            this.uuid=uuid;
            return this;
        }
        public UserModelBuilder name(String name){
            this.name=name;
            return this;
        }
        public UserModelBuilder company(String company){
            this.company=company;
            return this;
        }

        public UserModel build(){
            UserModel userModel=new UserModel();
            userModel.id=this.id;
            userModel.uuid=this.uuid;
            userModel.name=this.name;
            userModel.company=this.company;
            return  userModel;
        }

    }

}
