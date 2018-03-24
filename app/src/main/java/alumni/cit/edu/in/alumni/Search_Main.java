package alumni.cit.edu.in.alumni;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;

import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;

public class Search_Main extends AppCompatActivity {

    private EditText mSearchText;
    private ImageButton mSearchbtn;

    private RecyclerView mList;

    //firebase
    private DatabaseReference mContentRef;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.search_activity_main);

        mSearchText = (EditText) findViewById(R.id.searchTextView);
        mSearchbtn = (ImageButton) findViewById(R.id.searchBtn);
        mList = (RecyclerView) findViewById(R.id.listView);
        mList.setHasFixedSize(true);
        mList.setLayoutManager( new LinearLayoutManager(this));

        //firebase database reference of content we are search
        mContentRef = FirebaseDatabase.getInstance().getReference().child("users");

        mSearchbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //get the text from the edit text as string into a variable searchText
                String searchText = mSearchText.getText().toString();

                //pass the variable search text in the method searchText
                firebaseSearch(searchText);
            }
        });



    }


    //here we declear a method to carryout the search and display it in recycler view
    //using firebase ui recycler adapater
    private void firebaseSearch(String searchText) {


        //declear a firebase query to retrieve the search text,
        //start at the letter typed and end at the letter typed
        //
        Query searchQuery = mContentRef.orderByChild("Department").startAt(searchText).endAt(searchText + "\uf8ff");

        /*
        * FirebaseRecycler add accept the model claa and view holder class
        * also we pass in four arguments:
        * the model class , the single item layout, the view Holder class and the search query
         */
        FirebaseRecyclerAdapter<Search, ContentViewHolder> fireAdapter = new FirebaseRecyclerAdapter<Search, ContentViewHolder>(
                Search.class,
                R.layout.item_layout,
                ContentViewHolder.class,
                searchQuery


        ) {
            @Override
            protected void populateViewHolder(ContentViewHolder viewHolder, Search model, int position) {

                viewHolder.setContents(model.getUsername(), model.getEmail(), model.getAddress(),model.getMobileno(),model.getCountry(), model.getState() ,model.getPincode(),model.getProfession(),model.getCompanyname(), model.getSpecialization(), model.getCaddress(),model.getDepartment(),model.getRegno(),model.getBatch(),model.getYear());
            }
        };

        mList.setAdapter(fireAdapter);
    }


    //View holder class
    //we set the contents to the view widget

    public static class ContentViewHolder extends RecyclerView.ViewHolder{
        View mView;
        public ContentViewHolder(View itemView) {
            super(itemView);
            mView = itemView;
        }
        public void setContents(String Username,String Email,String Address,String Mobileno,String Country,String State,String Pincode,String Profession,String Companyname, String Specialization,String Caddress,String Department,String Regno,String Batch,String Year){
            TextView UsernameText = (TextView) mView.findViewById(R.id.UsernameText);
            TextView EmailText = (TextView) mView.findViewById(R.id.EmailText);
            TextView MobilenoText = (TextView) mView.findViewById(R.id.MobilenoText);

            TextView PincodeText = (TextView) mView.findViewById(R.id.PincodeText);

            TextView AddressText = (TextView) mView.findViewById(R.id.AddressText);
            TextView CountryText = (TextView) mView.findViewById(R.id.CountryText);
            TextView StateText = (TextView) mView.findViewById(R.id.StateText);
            TextView ProfessionText = (TextView) mView.findViewById(R.id.ProfessionText);
            TextView CompanynameText = (TextView) mView.findViewById(R.id.CompanynameText);
            TextView SpecializationText = (TextView) mView.findViewById(R.id.SpecializationText);
            TextView CaddressText = (TextView) mView.findViewById(R.id.CaddressText);
            TextView DepartmentText = (TextView) mView.findViewById(R.id.DepartmentText);
            TextView RegnoText = (TextView) mView.findViewById(R.id.RegnoText);
            TextView BatchText = (TextView) mView.findViewById(R.id.BatchText);
            TextView YearText = (TextView) mView.findViewById(R.id.YearText);


            UsernameText.setText(Username);
            EmailText.setText(Email);
            MobilenoText.setText(Mobileno);
            AddressText.setText(Address);
            PincodeText.setText(Pincode);
            CountryText.setText(Country);
            StateText.setText(State);
            ProfessionText.setText(Profession);
            CompanynameText.setText(Companyname);
            SpecializationText.setText(Specialization);
            CaddressText.setText(Caddress);
            DepartmentText.setText(Department);
            RegnoText.setText(Regno);
            BatchText.setText(Batch);
            YearText.setText(Year);
        }


    }

}
