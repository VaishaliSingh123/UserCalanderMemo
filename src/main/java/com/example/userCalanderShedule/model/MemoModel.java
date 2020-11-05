package com.example.userCalanderShedule.model;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
public class MemoModel {

    private String memo;

    public MemoModel(String memo) {
        this.memo=memo;
    }

    public String getMemo(){
        return memo;
    }
    public String setMemo(String memo){
        return memo;
    }

}
