package charusat.com.charusatcdpc.student;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import charusat.com.charusatcdpc.R;

public class AcademicData extends AppCompatActivity {

    EditText ETname,ETcgpa,ETproject;
    Button BTsave,BTskills;
    Spinner SPbranch,SPsem;
    Student student;
    String skills;
    String Firebase_id;
    DatabaseReference databaseReference;

    Intent i;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_academic_data);

        i = getIntent();

        student = new Student();
        databaseReference = FirebaseDatabase.getInstance().getReference("Student");

        ETname = (EditText) findViewById(R.id.EditText_name);
        ETcgpa = (EditText) findViewById(R.id.EditText_cgpa);
        ETproject = (EditText) findViewById(R.id.EditText_project);
        BTskills = (Button) findViewById(R.id.alert_dialog_skills);
        BTsave = (Button) findViewById(R.id.Button_save_academic_data);
        SPbranch = (Spinner)findViewById(R.id.spinner_branch);
        SPsem = (Spinner)findViewById(R.id.spinner_sem);

        setFirebase_id();


        BTskills.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AddSkills();
            }
        });

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
        student.setProjects(ETproject.getText().toString().trim());
        student.setCgpa(ETcgpa.getText().toString().trim());
        student.setId(id);
        student.setSem(SPsem.getSelectedItem().toString());
        student.setBranch(SPbranch.getSelectedItem().toString());
        student.setSkills(skills);

        databaseReference.child(getFirebase_id()).setValue(student);

        Toast.makeText(getApplicationContext(),"Student Academic Data Successfully",Toast.LENGTH_LONG).show();

    }

    public void AddSkills()
    {
        AlertDialog.Builder builder = new AlertDialog.Builder(AcademicData.this);

        // String array for alert dialog multi choice items
        final String[] SkillsArray = getResources().getStringArray(R.array.array_skills);

        // Boolean array for initial selected items
        final boolean[] checkedSkillsArray = new boolean[]{
                false,
                false,
                false,
                false,
                false,
                false,
                false,
                false,
                false,
                false,
                false,
                false
        };

        final List<String> SkillsList = Arrays.asList(SkillsArray);
        builder.setTitle("Select Skills");

        //set multichoice
        builder.setMultiChoiceItems(SkillsArray, checkedSkillsArray, new DialogInterface.OnMultiChoiceClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which, boolean isChecked) {
                // Update the current focused item's checked status
                checkedSkillsArray[which] = isChecked;
                // Get the current focused item
                String currentItem = SkillsList.get(which);
                // Notify the current action
                Toast.makeText(getApplicationContext(), currentItem + " " + isChecked, Toast.LENGTH_SHORT).show();
            }
        });

        // Set the positive/yes button click listener
        builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {

           // List<String> selectedSkills = new ArrayList<String>();
            @Override
            public void onClick(DialogInterface dialog, int which) {

                for (int i = 0; i<checkedSkillsArray.length; i++){
                    boolean checked = checkedSkillsArray[i];
                    if (checked) {
                        //selectedSkills.add(SkillsList.get(i));

                        if(skills == null)
                        {
                            skills = SkillsList.get(i);
                        }
                        else
                            skills =  skills + ", " + SkillsList.get(i) ;
                    }
                }
            }
        });

      /*  for (String s : SkillsList)
        {
            skills =  s + "," + skills;
        }*/

        // Set the neutral/cancel button click listener
        builder.setNeutralButton("Cancel", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                // Do something when click the neutral button
            }
        });

        AlertDialog dialog = builder.create();
        // Display the alert dialog on interface
        dialog.show();

    }

    public void setFirebase_id()
    {
        Firebase_id = databaseReference.push().getKey();
    }

    public String getFirebase_id()
    {
        return Firebase_id;
    }




    public static boolean isValidCgpa(String cgpa) {

        String regx = " ^[0-9][0-9].[0-9]{2}$ " ;
        Pattern pattern = Pattern.compile(regx,Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher(cgpa);
        return matcher.matches();

    }

}
