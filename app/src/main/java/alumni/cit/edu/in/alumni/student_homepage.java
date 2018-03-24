package alumni.cit.edu.in.alumni;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

/**
 * Created by user on 13-03-2018.
 */


public class student_homepage extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.student_homepage);


        Button btn5=(Button)findViewById(R.id.btn5);
        Button btn6= (Button)findViewById(R.id.btn6);
        Button btn7= (Button)findViewById(R.id.btn7);
        btn5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(v.getContext(), Search_Main.class);
                startActivityForResult(intent,0);

            }
        } );
        btn6.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(v.getContext(), resume_main.class);
                startActivityForResult(intent,0);

            }

        });
        btn7.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(v.getContext(), LoginActivity.class);
                startActivityForResult(intent,0);

            }

        });
    }

}



