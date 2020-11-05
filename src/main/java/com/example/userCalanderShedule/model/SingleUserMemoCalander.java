package com.example.userCalanderShedule.model;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
public class SingleUserMemoCalander {

    private Integer userId;

    private List<MemoModel> memoModel;

    public SingleUserMemoCalander(Integer userId, List<MemoModel> memoList) {
        this.userId=userId;
        this.memoModel=memoList;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public List<MemoModel> getMemoModel() {
        return memoModel;
    }

    public void setMemoModel(List<MemoModel> memoModel) {
        this.memoModel = memoModel;
    }
}
