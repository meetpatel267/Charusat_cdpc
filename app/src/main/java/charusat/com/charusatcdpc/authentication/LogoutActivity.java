package charusat.com.charusatcdpc.authentication;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

import charusat.com.charusatcdpc.R;
import charusat.com.charusatcdpc.dashboard.AdminDashboard;
import charusat.com.charusatcdpc.dashboard.MainDashboard;

public class LogoutActivity extends AppCompatActivity{

    private FirebaseAuth.AuthStateListener authListener;
    private FirebaseAuth auth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //get firebase auth instance
        auth = FirebaseAuth.getInstance();

        signOut();
        if (auth.getCurrentUser() == null) {
            startActivity(new Intent(LogoutActivity.this, LoginActivityFirebase.class));
            finish();
        }


        //get current user
        //final FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();




       /* authListener = new FirebaseAuth.AuthStateListener() {
            @Override
            public void onAuthStateChanged(@NonNull FirebaseAuth firebaseAuth) {
                FirebaseUser user = firebaseAuth.getCurrentUser();
                if (user == null) {
                    // user auth state is changed - user is null
                    // launch login activity
                    startActivity(new Intent(LogoutActivity.this, LoginActivityFirebase.class));
                    finish();
                }
            }
        };*/



    }

    //sign out method
    public void signOut() {
        auth.signOut();
    }
}



