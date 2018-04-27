package heita.tuhafeni.loginsystem;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class WelcomeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);

        final ImageView img_hello = (ImageView) findViewById(R.id.img_wave);

        Button btn_wave = (Button) findViewById(R.id.btn_hello);
        btn_wave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                img_hello.setImageResource(R.drawable.so_so);
            }
        });

        String name = "";
        TextView username = (TextView) findViewById(R.id.welcome_user);

        Intent intent = getIntent();
        Bundle extras = intent.getExtras();
        if(extras != null){
            name += extras.getString("username");
        }

        username.setText(name);

    }
}
