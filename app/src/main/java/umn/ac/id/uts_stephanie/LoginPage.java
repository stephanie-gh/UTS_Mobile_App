package umn.ac.id.uts_stephanie;


import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.Intent;
import android.os.Bundle;
import android.provider.MediaStore;
import android.text.method.HideReturnsTransformationMethod;
import android.text.method.PasswordTransformationMethod;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

public class LoginPage extends AppCompatActivity {
    public EditText username, password, inputedPassword;
    public Button btnsignin, btnback;
    public CheckBox showPassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_page);

        username = (EditText)findViewById(R.id.username);
        password = (EditText)findViewById(R.id.password);
        btnsignin = (Button)findViewById(R.id.btnsignin);
        btnback = (Button)findViewById(R.id.btnback);
        showPassword = (CheckBox)findViewById(R.id.showPassword);
        inputedPassword = findViewById(R.id.password);

        btnback.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        btnsignin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String usernameKey = username.getText().toString();
                String passwordKey = password.getText().toString();

                if (usernameKey.equals("uasmobile") && passwordKey.equals("uasmobilegenap")){
                    Toast.makeText(getApplicationContext(), "LOGIN SUKSES",
                            Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(LoginPage.this, ListPage.class);
                    LoginPage.this.startActivity(intent);
                    finish();
                }else {
                    AlertDialog.Builder builder = new AlertDialog.Builder(LoginPage.this);
                    builder.setMessage("Username / Password salah!")
                            .setNegativeButton("Retry", null).create().show();
                }
            }
        });

        showPassword.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(showPassword.isChecked()){
                    inputedPassword.setTransformationMethod(HideReturnsTransformationMethod.getInstance());
                }else {
                    inputedPassword.setTransformationMethod(PasswordTransformationMethod.getInstance());
                }
            }
        });
    }
}