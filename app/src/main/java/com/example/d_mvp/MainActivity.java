package com.example.d_mvp;

/*1.MainActivityContract 介面  (這頁是專門介面)
* A. interface View
*  void onSuccess(String message);
*  void onError(String message);
*
*B. interface Presenter
*   void doLogin(String email , String password);
* */

/*2.MainActivityPresenter類別實作 MainActivityContract.Presenter 的doLogin(String email , String password)方法 (這邊處理邏輯運算)
* 宣告MainActivityContract.View =>建構式取得View物件,就是將你所在的View傳過來
* */

//3.回到Activity實作MainActivityContract.View => 發揚光大void onSuccess(String message); void onError(String message);


import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements MainActivityContract.View{//3.實作MainActivityContract.View => 發揚光大void onSuccess(String message); void onError(String message);
    private EditText editEmail, editPassword;
    private Button btnLogin;
    private String TAG ="hank";

    String email, password;

    private MainActivityPresenter presenter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Init();
    }


    private void Init() {

        //5.將View帶進去給Presenter
        presenter = new MainActivityPresenter(this);

        editEmail = findViewById(R.id.editEmail);
        editPassword = findViewById(R.id.editPassword);
        btnLogin = findViewById(R.id.btnLogin);


        //4.使用者如果有輸入時執行doLogin邏輯,沒有的話onError抱錯
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                email = editEmail.getText().toString();
                password = editPassword.getText().toString();
                if (TextUtils.isEmpty(email) || TextUtils.isEmpty(password)) {
                    onError("有少輸入");
                } else {
                    presenter.doLogin(email, password);
                }
            }
        });


    }
    //3.實作MainActivityContract.View => 發揚光大void onSuccess(String message); 當Loign邏輯演算因為有用到onSucess所以如果成功這邊實作會收到成功訊息
    @Override
    public void onSuccess(String message) {
        Log.v(TAG,"onSuccess() =>" + message);
        Toast.makeText(this,message,Toast.LENGTH_SHORT).show();
    }
    //3.實作MainActivityContract.View => 發揚光大void onError(String message);
    @Override
    public void onError(String message) {
        Log.v(TAG,"onError() =>" + message);
        Toast.makeText(this,message,Toast.LENGTH_SHORT).show();
    }
}