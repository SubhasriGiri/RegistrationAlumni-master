  package alumni.cit.edu.in.alumni;

import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.storage.StorageReference;
import com.weiwangcn.betterspinner.library.material.MaterialBetterSpinner;

import me.dm7.barcodescanner.core.ViewFinderView;


  public class Registration extends AppCompatActivity implements View.OnClickListener{

      String [] SPINNERLIST={"IT","CSE","MECHANICAL","EEE","ECE","CHEMICAL","CIVIL"};
      String [] SPINNERLIST1={"Male","Female"};

      private EditText editUsername;
    private EditText editEmail;
    private EditText editPassword;
    private EditText editMobileno;
      private EditText editGender;
      private EditText editAddress;
      private EditText editCountry;
      private EditText editState;
      private EditText editPincode;
      private EditText editProfession;
      private EditText editCompanyname;
      private EditText editSpecialization;
      private EditText editCaddress;
      private EditText editDepartment;
      private EditText editRegno;
      private EditText editBatch;
    private EditText editYear;


    private Button registerButton;
    private TextView loginRedirect;

    private ProgressDialog progressDialog;

    private FirebaseAuth firebaseAuth;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);

        ArrayAdapter<String> arrayAdapter=new ArrayAdapter<String>(this,android.R.layout.simple_dropdown_item_1line,SPINNERLIST);
        MaterialBetterSpinner betterSpinner= (MaterialBetterSpinner)findViewById(R.id.editDepartment);
        betterSpinner.setAdapter(arrayAdapter);

        ArrayAdapter<String> arrayAdapter1=new ArrayAdapter<String>(this,android.R.layout.simple_dropdown_item_1line,SPINNERLIST1);
        MaterialBetterSpinner betterSpinner1= (MaterialBetterSpinner)findViewById(R.id.editGender);
        betterSpinner1.setAdapter(arrayAdapter1);


        //Initialization of the FirebaseAuth Object
        firebaseAuth = FirebaseAuth.getInstance();

        //Checking whether a user as already Logged In
        if(firebaseAuth.getCurrentUser() != null){
            finish();
            //Starting the User Profile Activity if the user is already Logged in
            startActivity(new Intent(getApplicationContext(), UserProfile.class));
        }

        //Initialization of the ProgressDialog object
        progressDialog = new ProgressDialog(this);

        //Retrieving EditText field values from the XML and storing them in java Variables
        editUsername = (EditText) findViewById(R.id.editUsername);
        editEmail = (EditText) findViewById(R.id.editEmail);
        editPassword = (EditText) findViewById(R.id.editPassword);
        editMobileno = (EditText) findViewById(R.id.editMobileno);
        editGender = (EditText) findViewById(R.id.editGender);
        editAddress = (EditText) findViewById(R.id.editAddress);
        editCountry= (EditText) findViewById(R.id.editCountry);
        editState = (EditText) findViewById(R.id.editState);
        editPincode = (EditText) findViewById(R.id.editPincode);
        editProfession = (EditText) findViewById(R.id.editProfession);
        editCompanyname = (EditText) findViewById(R.id.editCompanyname);
        editSpecialization = (EditText) findViewById(R.id.editSpecialization);
        editCaddress = (EditText) findViewById(R.id.editCaddress);
        editDepartment = (EditText) findViewById(R.id.editDepartment);
        editRegno = (EditText) findViewById(R.id.editRegno);
        editBatch = (EditText) findViewById(R.id.editBatch);
        editYear= (EditText) findViewById(R.id.editYear);

        registerButton = (Button) findViewById(R.id.registerButton);

        loginRedirect = (TextView) findViewById(R.id.loginRedirect);

        //Adding the listener function to both the register button and the login redirection link (Text)
        registerButton.setOnClickListener(this);
        loginRedirect.setOnClickListener(this);

    }

    private void registerNewUser() {

        //Converting EditText type variables to String type variables
        final String username = editUsername.getText().toString().trim();
        final String email = editEmail.getText().toString().trim();
        final String password = editPassword.getText().toString().trim();
        final String mobileno = editMobileno.getText().toString().trim();
        final String gender = editGender.getText().toString().trim();
        final String address = editAddress.getText().toString().trim();
        final String country= editCountry.getText().toString().trim();
        final String state = editState.getText().toString().trim();
        final String pincode = editPincode.getText().toString().trim();
        final String profession= editProfession.getText().toString().trim();
        final String companyname = editCompanyname.getText().toString().trim();
        final String specialization = editSpecialization.getText().toString().trim();
        final String caddress = editCaddress.getText().toString().trim();
        final String department = editDepartment.getText().toString().trim();
        final String regno = editRegno.getText().toString().trim();
        final String batch = editBatch.getText().toString().trim();
        final String year = editYear.getText().toString().trim();



        //Checking whether the email field is empty and displaying a error message through Toast
        if (TextUtils.isEmpty(email)) {
            Toast.makeText(this, "Please enter a valid email address", Toast.LENGTH_SHORT).show();
            return;
        }

        //Checking whether the password field is empty and displaying a error message through Toast
        if (TextUtils.isEmpty(password)) {
            Toast.makeText(this, "Please enter a preferred password", Toast.LENGTH_SHORT).show();
            return;
        }


        /**Have to implement the DeviceID cross check**/


        //Giving the ProgressDialog a message to display while the action in is progress
        progressDialog.setMessage("In Progress...");
        //Displaying the ProgressDialog
        progressDialog.show();

        /**
         *
         * @param email user email
         * @param password user password
         */
        firebaseAuth.createUserWithEmailAndPassword(email, password).addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {

            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                progressDialog.dismiss();
                //checks whether the user has been successfully registered
                if(task.isSuccessful()){
                    FirebaseDatabase database = FirebaseDatabase.getInstance();
                    DatabaseReference users = database.getReference("users");
                    users.child(username).child("Username").setValue(username);
                    users.child(username).child("Email").setValue(email);
                    users.child(username).child("Password").setValue(password);
                    users.child(username).child("Mobile No").setValue(mobileno);
                    users.child(username).child("Gender").setValue(gender);
                    users.child(username).child("Address").setValue(address);
                    users.child(username).child("Country").setValue(country);
                    users.child(username).child("State").setValue(state);
                    users.child(username).child("Pincode").setValue(pincode);
                    users.child(username).child("Profession").setValue(profession);
                    users.child(username).child("Company Name").setValue(companyname);
                    users.child(username).child("Specialization").setValue(specialization);
                    users.child(username).child("Caddress").setValue(caddress);
                    users.child(username).child("Department").setValue(department);
                    users.child(username).child("Regno").setValue(regno);
                    users.child(username).child("Batch").setValue(batch);
                    users.child(username).child("Year").setValue(year);
                    /*DatabaseReference myRef = database.getReference("message");
                    myRef.setValue("World");*/
                    //Displays a registration successful message through Toast
                    Toast.makeText(Registration.this, "User Registered", Toast.LENGTH_SHORT).show();
                    finish();
                    //Redirects to the User Profile Activity
                    startActivity(new Intent(getApplicationContext(), UserProfile.class));
                }else{
                    //Displays a registration Unsuccessful message through Toast
                    Toast.makeText(Registration.this, "Registration Unsuccessful", Toast.LENGTH_SHORT).show();
                }
            }
        });

    }

    //Method to switch from Registration page to the Login Page
    private void redirectToLogin(){
        finish();
        //starts the Login Activity
        startActivity(new Intent(this, Login.class));
    }

    @Override
    public void onClick(View view) {
        //when registerButton is clicked registerNewUser method is invoked
        if(view == registerButton){
            registerNewUser();
        }

        //when loginRedirect button is clicked redirectToLogin method is invoked
        if(view == loginRedirect){
            redirectToLogin();
        }

    }
}
