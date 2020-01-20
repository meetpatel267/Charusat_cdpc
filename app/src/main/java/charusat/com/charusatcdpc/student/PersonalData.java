package charusat.com.charusatcdpc.student;


import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import android.util.Log;
import android.view.View;

import android.widget.Button;
import android.widget.EditText;

import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import charusat.com.charusatcdpc.R;
import charusat.com.charusatcdpc.authentication.LoginActivityFirebase;
import charusat.com.charusatcdpc.student.Student;


public class PersonalData extends AppCompatActivity {


    EditText ETname,ETemail,ETaddress,ETphone,ETbdate;
    Button BTsave;
    Student student;
    String Firebase_id;
    DatabaseReference databaseReference;
    LoginActivityFirebase loginActivityFirebase;

    Intent i;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_personal_data);

        student = new Student();
        i = getIntent();
        loginActivityFirebase = new LoginActivityFirebase();
        databaseReference = FirebaseDatabase.getInstance().getReference("Student");

        setFirebase_id();

        ETname = (EditText) findViewById(R.id.EditText_name);
        ETphone = (EditText) findViewById(R.id.EditText_phone);
        ETaddress = (EditText) findViewById(R.id.EditText_address);
        ETbdate = (EditText) findViewById(R.id.EditText_birthdate);
        ETemail = (EditText) findViewById(R.id.EditText_email);
        BTsave = (Button) findViewById(R.id.Button_save_personal_data);

        BTsave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AddData();
            }
        });



    }

    public void AddData() {

        String id = i.getStringExtra("id");

        student.setName(ETname.getText().toString().trim());
        student.setAddress(ETaddress.getText().toString().trim());
        student.setBirthdate(ETbdate.getText().toString().trim());
        student.setPhone(ETphone.getText().toString().trim());
        student.setEmail(ETemail.getText().toString().trim());
        student.setId(id);


        databaseReference.child(getFirebase_id()).setValue(student);

        Toast.makeText(getApplicationContext(),"Student Personal Data Successfully",Toast.LENGTH_LONG).show();

    }

    public void setFirebase_id()
    {
        Firebase_id = databaseReference.push().getKey();
    }

    public String getFirebase_id()
    {
        return Firebase_id;
    }

    private boolean isValidEmail(String email) {

        String email_pattern =  "^[A-Za-z0-9._%+\\-]+@[A-Za-z0-9.\\-]+\\.[A-Za-z]{2,4}$" ;
        Pattern pattern = Pattern.compile(email_pattern);
        Matcher matcher = pattern.matcher(email);

        return matcher.matches();


    }

    private boolean isValidMobno(String mobno) {

        String mob_pattern = "^[2-9]{2}[0-9]{8}$" ;
        Pattern pattern = Pattern.compile(mob_pattern);
        Matcher matcher = pattern.matcher(mobno);

        return matcher.matches();


    }

    private boolean isValidDate(String date) {

        String date_pattern = "^(?:(?:31(\\/|-|\\.)(?:0?[13578]|1[02]))\\1|(?:(?:29|30)(\\/|-|\\.)(?:0?[1,3-9]|1[0-2])\\2))(?:(?:1[6-9]|[2-9]\\d)?\\d{2})$|^(?:29(\\/|-|\\.)0?2\\3(?:(?:(?:1[6-9]|[2-9]\\d)?(?:0[48]|[2468][048]|[13579][26])|(?:(?:16|[2468][048]|[3579][26])00))))$|^(?:0?[1-9]|1\\d|2[0-8])(\\/|-|\\.)(?:(?:0?[1-9])|(?:1[0-2]))\\4(?:(?:1[6-9]|[2-9]\\d)?\\d{2})$";

        Pattern pattern = Pattern.compile(date_pattern);
        Matcher matcher = pattern.matcher(date);
        return matcher.matches();

    }

    public static boolean isValidName(String name) {

        String regx = "^[A-Za-z\\s]{1,}[\\.]{0,1}[A-Za-z\\s]{0,}$";
        Pattern pattern = Pattern.compile(regx,Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher(name);
        return matcher.matches();

    }
}
