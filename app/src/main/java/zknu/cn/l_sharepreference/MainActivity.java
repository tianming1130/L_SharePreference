package zknu.cn.l_sharepreference;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    private static final String USER_INFO = "user_info";
    private EditText etUserName,etPassword;
    private Button btnLogin,btnClear;
    private CheckBox cbSaveInfo;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        etUserName=(EditText)findViewById(R.id.et_user_name);
        etPassword=(EditText)findViewById(R.id.et_password);
        cbSaveInfo=(CheckBox)findViewById(R.id.cb_save_info);
        btnLogin =(Button)findViewById(R.id.btn_login);
        btnClear=(Button)findViewById(R.id.btn_clear);

        btnLogin.setOnClickListener(this);
        btnClear.setOnClickListener(this);

        init();

    }

    private void init() {
        SharedPreferences sp=getSharedPreferences(USER_INFO,MODE_PRIVATE);
        String strUserName=sp.getString("USER","");
        String strPassword=sp.getString("PASSWORD","");
        etUserName.setText(strUserName);
        etPassword.setText(strPassword);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.btn_login:
                login();
                break;
            case R.id.btn_clear:
                clear();
                break;
        }
    }

    private void clear() {
        SharedPreferences sp = getSharedPreferences(USER_INFO, MODE_PRIVATE);
        SharedPreferences.Editor editor = sp.edit();
        editor.clear();
        editor.commit();
    }

    private void login() {
        if (cbSaveInfo.isChecked()){
            String strUserName=etUserName.getText().toString();
            String strPassword=etPassword.getText().toString();
            SharedPreferences sp=getSharedPreferences(USER_INFO,MODE_PRIVATE);
            SharedPreferences.Editor editor=sp.edit();
            editor.putString("USER",strUserName);
            editor.putString("PASSWORD",strPassword);
            editor.commit();

            Toast.makeText(this,"用户信息已经保存！",Toast.LENGTH_LONG).show();

        }else {
            Toast.makeText(this,"未保存用户信息！",Toast.LENGTH_LONG).show();
        }
    }
}
