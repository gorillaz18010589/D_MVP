package com.example.d_mvp;
//這頁是專門介面
public interface MainActivityContract {

    //在MainActivity要監聽的事件
    interface View{
        void onSuccess (String message);
        void onError (String message);
    }

    //在Presenter實作要進來的參數做運算
    interface Presenter {
        void doLogin(String emaill, String password);
    }
}
