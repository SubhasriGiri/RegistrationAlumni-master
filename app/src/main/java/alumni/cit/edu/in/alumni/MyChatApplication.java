package alumni.cit.edu.in.alumni;


import android.app.Application;

import com.google.firebase.database.FirebaseDatabase;

/**
 * Created by ramdani on 9/18/16.
 */
public class MyChatApplication extends Application{

    public void onCreate(){
        super.onCreate();
        FirebaseDatabase instance = FirebaseDatabase.getInstance();
        instance.setPersistenceEnabled(true);
        instance.getReference().keepSynced(true);
    }
}
