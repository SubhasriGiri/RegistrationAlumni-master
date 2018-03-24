package alumni.cit.edu.in.alumni;

/**
 * Created by shank on 15-03-2018.
 */



        import android.content.Intent;
        import android.graphics.Color;
        import android.support.v7.app.AppCompatActivity;
        import android.os.Bundle;
        import android.support.v7.widget.CardView;
        import android.view.View;
        import android.widget.ImageButton;
        import android.widget.GridLayout;
        import android.widget.GridView;
        import android.widget.Toast;

public class news_main extends AppCompatActivity {

    GridLayout mainGrid;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.news_main);
        ImageButton meet=(ImageButton)findViewById(R.id.meet);
        meet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(v.getContext(), ActivityOne.class);
                startActivityForResult(intent,0);

            }
        } );
        ImageButton alumniday=(ImageButton)findViewById(R.id.alumniday);
        alumniday.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(v.getContext(), ActivityTwo.class);
                startActivityForResult(intent,0);

            }
        } );

        ImageButton osan=(ImageButton)findViewById(R.id.osan);
        osan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(v.getContext(), ActivityThree.class);
                startActivityForResult(intent,0);

            }
        } );
        ImageButton gold=(ImageButton)findViewById(R.id.gold);
        gold.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(v.getContext(), ActivityFour.class);
                startActivityForResult(intent,0);

            }
        } );



        mainGrid = (GridLayout) findViewById(R.id.mainGrid);

        //Set Event
        setSingleEvent(mainGrid);
        //setToggleEvent(mainGrid);
    }

    private void setToggleEvent(GridLayout mainGrid) {
        //Loop all child item of Main Grid
        for (int i = 0; i < mainGrid.getChildCount(); i++) {
            //You can see , all child item is CardView , so we just cast object to CardView
            final CardView cardView = (CardView) mainGrid.getChildAt(i);
            cardView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if (cardView.getCardBackgroundColor().getDefaultColor() == -1) {
                        //Change background color
                        cardView.setCardBackgroundColor(Color.parseColor("#FF6F00"));
                        Toast.makeText(news_main.this, "State : True", Toast.LENGTH_SHORT).show();

                    } else {
                        //Change background color
                        cardView.setCardBackgroundColor(Color.parseColor("#FFFFFF"));
                        Toast.makeText(news_main.this, "State : False", Toast.LENGTH_SHORT).show();
                    }
                }
            });
        }
    }

    private void setSingleEvent(GridLayout mainGrid) {
        //Loop all child item of Main Grid
        for (int i = 0; i < mainGrid.getChildCount(); i++) {
            //You can see , all child item is CardView , so we just cast object to CardView
            CardView cardView = (CardView) mainGrid.getChildAt(i);


            final int finalI = i;
            cardView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    switch (view.getId()) {
                        case R.id.meet: {

                            Intent intent = new Intent(news_main.this, ActivityOne.class);
                            startActivity(intent);
                            break;
                        }
                        case R.id.alumniday: {

                            Intent intent = new Intent(news_main.this, ActivityTwo.class);
                            startActivity(intent);
                            break;
                        }
                        case R.id.osan: {

                            Intent intent = new Intent(news_main.this, ActivityThree.class);
                            startActivity(intent);
                            break;
                        }
                        case R.id.gold: {

                            Intent intent = new Intent(news_main.this, ActivityFour.class);
                            startActivity(intent);
                            break;
                        }
                    }
                }
            });
        }
    }
}

