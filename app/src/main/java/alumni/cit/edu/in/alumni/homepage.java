package alumni.cit.edu.in.alumni;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

/**
 * Created by user on 08-03-2018.
 */
public class homepage extends AppCompatActivity {

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.home_page);


            Button btn3=(Button)findViewById(R.id.btn3);
            Button btn4= (Button)findViewById(R.id.btn4);
            Button btn5= (Button)findViewById(R.id.btn5);
            Button btn6= (Button)findViewById(R.id.btn6);
            btn3.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(v.getContext(), invite.class);
                    startActivityForResult(intent,0);

                }
            } );
            btn4.setOnClickListener(new View.OnClickListener(){
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(v.getContext(), ViewUploadsActivity.class);
                    startActivityForResult(intent,0);

                }

            });
            btn5.setOnClickListener(new View.OnClickListener(){
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(v.getContext(), news_main.class);
                    startActivityForResult(intent,0);

                }

            });
            btn6.setOnClickListener(new View.OnClickListener(){
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(v.getContext(), LoginActivity.class);
                    startActivityForResult(intent,0);

                }

            });
        }

    }


