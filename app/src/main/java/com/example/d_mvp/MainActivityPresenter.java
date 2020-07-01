package com.example.d_mvp;
/*.MainActivityPresenter類別實作 MainActivityContract.Presenter 的doLogin(String email , String password)方法
 * 宣告MainActivityContract.View =>建構式取得View物件,就是將你所在的View傳過來
 * 這邊處理邏輯運算
 * */

import android.util.Log;

public class MainActivityPresenter implements MainActivityContract.Presenter{

    MainActivityContract.View view;

    //2.建構式讓view在Activity傳進來抓取Activity畫面,同時要玩View裡面的onSuccess方法跟onError方法
    public MainActivityPresenter(MainActivityContract.View view) {
        this.view = view;
    }

    //1.Activity宣告呼叫doLogin方法,這邊用邏輯運算
    @Override
    public void doLogin(String emaill, String password) {

        //3.失敗時將失敗的字串訊息,傳給有時做的Activity去取得失敗字串,再用Toast呈現出來
        if(emaill.equals("hank") && password.equals("123456")){
            Log.v("hank","帳密正確()");
            view.onSuccess("帳密正確");
        }else{
            //3.失敗時將成功的字串訊息,傳給有時做的Activity去取得失敗字串,再用Toast呈現出來
            Log.v("hank","帳密錯誤()");
            view.onError("帳密錯誤");
        }
    }
}
