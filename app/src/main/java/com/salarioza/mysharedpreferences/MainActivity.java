package com.salarioza.mysharedpreferences;

import android.content.Context;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText etUsername;
    EditText etPassword;
    TextView tvDisplay;
    Button btnSave;
    Button btnDisplay;
    SharedPreferences preferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        etUsername = (EditText) findViewById(R.id.name_edt);
        etPassword = (EditText) findViewById (R.id.pw_edt);
        btnSave = (Button) findViewById(R.id.saveinf);
        btnDisplay = (Button) findViewById(R.id.display);
        tvDisplay = (TextView) findViewById(R.id.tv_display);
        preferences = getPreferences(Context.MODE_PRIVATE);
    }
    public void saveInfo (View view) {
        SharedPreferences.Editor editor = preferences.edit();
        editor.putString("username", etUsername.getText().toString());
        editor.putString("password", etPassword.getText().toString());
        editor.commit();
        Toast.makeText(this, "Data saved", Toast.LENGTH_SHORT).show();
    }
    public void loadInfo(View view) {
        String user = preferences.getString("username", "");
        String pwd = preferences.getString("password", "");
        tvDisplay.setText("The password of " + user + " is " + pwd);
    }
}
