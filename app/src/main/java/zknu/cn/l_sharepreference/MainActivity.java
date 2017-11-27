package zknu.cn.l_sharepreference;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    private EditText etUserName,etPassword;
    private Button btnAdd,btnDel,btnClear;
    private int number;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        etUserName=(EditText)findViewById(R.id.et_user_name);
        etPassword=(EditText)findViewById(R.id.et_password);
        btnAdd=(Button)findViewById(R.id.btn_add);
        btnDel=(Button)findViewById(R.id.btn_del);
        btnClear=(Button)findViewById(R.id.btn_clear);

        btnAdd.setOnClickListener(this);
        btnDel.setOnClickListener(this);
        btnClear.setOnClickListener(this);

    }
    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.btn_add:
                add();
                break;
            case  R.id.btn_del:
                del();
                break;
            case R.id.btn_clear:
                clear();
                break;
        }
    }

    private void clear() {
        SharedPreferences sp = getSharedPreferences("data", MODE_PRIVATE);
        SharedPreferences.Editor editor = sp.edit();
        editor.clear();
        editor.commit();
    }

    private void del() {
        SharedPreferences sp = getSharedPreferences("data", MODE_PRIVATE);
        SharedPreferences.Editor editor = sp.edit();
        String strUserNameKey = etUserName.getText().toString();
        String strPasswordKey = etPassword.getText().toString();

        editor.remove(strUserNameKey);
        editor.remove(strPasswordKey);
        editor.commit();
    }

    private void add() {
        String strUserName=etUserName.getText().toString();
        String strPassword=etPassword.getText().toString();
        SharedPreferences sp=getSharedPreferences("data",MODE_PRIVATE);
        SharedPreferences.Editor editor=sp.edit();
        number++;
        editor.putString("USER"+String.valueOf(number),strUserName);
        editor.putString("PASSWORD"+String.valueOf(number),strPassword);
        editor.commit();
    }
}
