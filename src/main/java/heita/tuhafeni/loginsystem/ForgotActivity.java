package heita.tuhafeni.loginsystem;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class ForgotActivity extends AppCompatActivity {

    String name = "", email = "", new_password = "";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forgot);

        TextView username = (TextView) findViewById(R.id.forgot_username);
        Intent intent = getIntent();
        Bundle extras = intent.getExtras();
        if(extras != null){
            name += extras.getString("username");
        }
        username.setText(name);

        final EditText et_email = (EditText) findViewById(R.id.email_recovery_et);
        final EditText et_password = (EditText) findViewById(R.id.et_new_password);

        Button btn_set_new_pw = (Button) findViewById(R.id.btn_new_password);
        btn_set_new_pw.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                email = et_email.getText().toString();
                new_password = et_password.getText().toString();

                Toast.makeText(getApplicationContext(),
                        "Recovery Password was sent to " + email + ".",
                        Toast.LENGTH_SHORT).show();

                Intent intent = new Intent(getApplicationContext(), MainActivity.class);

                /****** Change user password to new password *******/



                startActivity(intent);
            }
        });

    }
}
