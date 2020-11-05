package com.example.userCalanderShedule.model;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.NonNull;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Date;

@Entity(name="memo")
@NoArgsConstructor
@AllArgsConstructor
public class UserMemoModel {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="id")
    private Integer id;

    private Integer userId;

   // @NonNull
  //  private Date date;

    @NonNull
    private Date start;

    @NonNull
    private Date end;

    @NonNull
    private String memo;

    public Integer getId(){ return id;}

    public Integer getUserId() {
        return userId;
    }

   /* public Date getDate() {
        return date;
    }*/

    public Date getStart() {
        return start;
    }

    public Date getEnd() {
        return end;
    }

    public String getMemo() {
        return memo;
    }

    public static class UserMemoBuilder{
        private Integer id;
        private Integer userId;
       // private Date date;
        private Date start;
        private Date end;
        private String memo;

        public UserMemoBuilder id(Integer id){
            this.id=id;
            return this;
        }

        public UserMemoBuilder userId(Integer userId){
            this.userId=userId;
            return this;
        }
       /* public UserMemoBuilder date(Date date){
            this.date=date;
            return  this;
        }*/
        public UserMemoBuilder start(Date start){
            this.start=start;
            return this;
        }
        public UserMemoBuilder end(Date end){
            this.end=end;
            return this;
        }
        public UserMemoBuilder memo(String memo){
            this.memo=memo;
            return this;
        }

        public UserMemoModel build(){
            UserMemoModel userMemoModel=new UserMemoModel();
            userMemoModel.userId=this.userId;
        //    userMemoModel.date=this.date;
            userMemoModel.start=this.start;
            userMemoModel.end=this.end;
            userMemoModel.memo=this.memo;
            return userMemoModel;
        }
    }
}
