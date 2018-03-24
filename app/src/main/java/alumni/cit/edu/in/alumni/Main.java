package alumni.cit.edu.in.alumni;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.content.Intent;
/**
 * Created by shank on 30-01-2018.
 */

public class Main extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);


        Button btn2=(Button)findViewById(R.id.button2);
        Button btn= (Button)findViewById(R.id.button);
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(v.getContext(), Login.class);
                startActivityForResult(intent,0);

            }
        } );
        btn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(v.getContext(), barcode_main.class);
                startActivityForResult(intent,0);

            }

        });
    }

}
