package com.timeshappy.scoresheet;
import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
//make20201030_1

public class MainStart extends AppCompatActivity {

   //
    EditText  team_A_name,team_B_name;
    Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_start);

        button =findViewById(R.id.btnStart);


        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {


                    team_A_name = findViewById(R.id.ed_team_a);
                    team_B_name = findViewById(R.id.ed_team_b);


                    String a = team_A_name.getText().toString();
                    String b = team_B_name.getText().toString();

                    if ("".equals(a)){
                        a = "TEAM A";
                    }

                    if ("".equals(b)){
                        b = "TEAM B";
                    }

                    //

                    Intent intent = new Intent(getApplication(), MainActivity.class);
                    intent.putExtra("ta",a);
                    intent.putExtra("tb",b);

                    //Toast.makeText(MainStart.this,"TIP OFF!!", Toast.LENGTH_SHORT).show();

                    startActivity(intent);


                }catch (Exception e){
                    Toast.makeText(MainStart.this, "error",Toast.LENGTH_SHORT).show();


                }
            }

        });


    }
}