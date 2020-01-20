package charusat.com.charusatcdpc.authentication;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.TextInputEditText;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

import charusat.com.charusatcdpc.R;
import charusat.com.charusatcdpc.dashboard.AdminDashboard;
import charusat.com.charusatcdpc.dashboard.MainDashboard;
import charusat.com.charusatcdpc.student.Student;

public class LoginActivityFirebase extends AppCompatActivity {

    private EditText inputEmail, inputPassword ,inputId;
    private FirebaseAuth auth;
    private ProgressBar progressBar;
    private Button btnSignup, btnLogin, btnReset;
    private RadioGroup radioGroup_user;
    private RadioButton radioButton_user_type;
    private TextInputLayout textInputLayoutId;

    public static String email,password,id;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.factivity_login);

        //Get Firebase auth instance
        auth = FirebaseAuth.getInstance();

        /*if (auth.getCurrentUser() != null) {
            startActivity(new Intent(LoginActivityFirebase.this, MainDashboard.class));
            finish();
        }*/


        radioGroup_user = (RadioGroup)findViewById(R.id.radioGroup_user);

        inputEmail = (EditText) findViewById(R.id.email);
        inputPassword = (EditText) findViewById(R.id.password);
        inputId = (EditText) findViewById(R.id.Edittext_student_id);
        textInputLayoutId = (TextInputLayout) findViewById(R.id.student_id);
        progressBar = (ProgressBar) findViewById(R.id.progressBar);
        btnSignup = (Button) findViewById(R.id.btn_signup);
        btnLogin = (Button) findViewById(R.id.btn_login);
        btnReset = (Button) findViewById(R.id.btn_reset_password);

        //Get Firebase auth instance
        auth = FirebaseAuth.getInstance();


        btnSignup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(LoginActivityFirebase.this, SignUpActivityFirebase.class));
            }
        });

        btnReset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(LoginActivityFirebase.this, ResetPasswordActivity.class));
            }
        });

        radioGroup_user.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener()
        {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                // checkedId is the RadioButton selected


                if(checkedId == R.id.radioButton_user_student)
                {
                    textInputLayoutId.setVisibility(View.VISIBLE);
                }

                else
                {
                    textInputLayoutId.setVisibility(View.GONE);
                }
            }
        });

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
             email = inputEmail.getText().toString();
             password = inputPassword.getText().toString();
             id = inputId.getText().toString();

                if (TextUtils.isEmpty(email)) {
                    Toast.makeText(getApplicationContext(), "Enter email address!", Toast.LENGTH_SHORT).show();
                    return;
                }

                if (TextUtils.isEmpty(password)) {
                    Toast.makeText(getApplicationContext(), "Enter password!", Toast.LENGTH_SHORT).show();
                    return;
                }



                progressBar.setVisibility(View.VISIBLE);

                //authenticate user
                auth.signInWithEmailAndPassword(email, password)
                        .addOnCompleteListener(LoginActivityFirebase.this, new OnCompleteListener<AuthResult>() {
                            @Override
                            public void onComplete(@NonNull Task<AuthResult> task) {
                                // If sign in fails, display a message to the user. If sign in succeeds
                                // the auth state listener will be notified and logic to handle the
                                // signed in user can be handled in the listener.
                                progressBar.setVisibility(View.GONE);
                                if (!task.isSuccessful()) {
                                    Log.w("SignIn Failed", "signInWithEmail:failure", task.getException());
                                    // there was an error
                                    if (password.length() < 6) {
                                        inputPassword.setError(getString(R.string.minimum_password));
                                    } else {
                                        Toast.makeText(LoginActivityFirebase.this, getString(R.string.auth_failed), Toast.LENGTH_LONG).show();
                                    }
                                } else {
                                    Log.d("SignIn Successful", "signInWithEmail:success");

                                   int selectedId = radioGroup_user.getCheckedRadioButtonId();
                                   // radioButton_user_type =(RadioButton)findViewById(selectedId);



                                    if(selectedId == R.id.radioButton_user_student)
                                    {

                                        Toast.makeText(LoginActivityFirebase.this,"Student User",Toast.LENGTH_SHORT).show();

                                        Intent intent = new Intent(LoginActivityFirebase.this, MainDashboard.class);
                                        intent.putExtra("id",id);
                                        startActivity(intent);
                                        finish();
                                    }

                                    else if(selectedId == R.id.radioButton_user_admin)
                                    {
                                        Toast.makeText(LoginActivityFirebase.this,"Admin User",Toast.LENGTH_SHORT).show();
                                        Intent intent = new Intent(LoginActivityFirebase.this, AdminDashboard.class);
                                        startActivity(intent);

                                        finish();
                                    }

                                    else
                                    {
                                        Toast.makeText(LoginActivityFirebase.this,"Select User",Toast.LENGTH_SHORT).show();
                                    }

                                   /* Intent intent = new Intent(LoginActivityFirebase.this, AdminDashboard.class);
                                    startActivity(intent);
                                    finish();*/
                                }
                            }
                        });
            }
        });
    }
}