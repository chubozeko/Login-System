package heita.tuhafeni.loginsystem;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    EditText edit_username, edit_password;
    String username = "", password = "";
    String[] user1 = {"Tuhafeni",  "heita"};
    String[] user2 = {"Thato",     "mashego"};
    String[] user3 = {"Lloyd",     "matsweru"};
    ArrayList<String[]> users = new ArrayList<String[]>();
    boolean usernameValid = false;
    boolean passwordValid = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        users.add(user1);   users.add(user2);
        boolean add = users.add(user3);

        /****** Handle new password somehow *******/


        edit_username = (EditText) findViewById(R.id.username);
        edit_password = (EditText) findViewById(R.id.password);

        Button btn_sign_in = (Button) findViewById(R.id.btn_sign_in);
        btn_sign_in.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                validateUser();
                if( usernameValid == true && passwordValid == true ){
                    signIn();
                } else if( usernameValid == true && passwordValid == false ){
                    Toast.makeText(getApplicationContext(),
                            "Incorrect password! Please try again.",
                            Toast.LENGTH_SHORT).show();
                } else if( usernameValid == false && passwordValid == false ){
                    Toast.makeText(getApplicationContext(),
                            "Incorrect username & password! Please try again.",
                            Toast.LENGTH_SHORT).show();
                } else if( usernameValid == false ){
                    Toast.makeText(getApplicationContext(),
                            "Incorrect username! Please try again.",
                            Toast.LENGTH_SHORT).show();
                }
            }
        });

        TextView forgotPW = (TextView) findViewById(R.id.text_forgotPassword);
        forgotPW.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), ForgotActivity.class);
                intent.putExtra("username", username);
                startActivity(intent);
            }
        });

    }

    public void signIn(){
        Intent intent = new Intent(this, WelcomeActivity.class);
        intent.putExtra("username", username);

        usernameValid = false;
        passwordValid = false;

        startActivity(intent);
    }

    public void validateUser(){
        usernameValid = false;
        passwordValid = false;
        username = edit_username.getText().toString();
        password = edit_password.getText().toString();

        for( int i=0; i<users.size(); i++){
            String[] user = users.get(i);
            if( username.contains( user[0] ) ){
                usernameValid = true;
                if( password.contains( user[1] ) ){
                    passwordValid = true;
                } else passwordValid = false;
                break;
            } else usernameValid = false;
        }
    }

}
