package charusat.com.charusatcdpc.admin;

import android.content.DialogInterface;
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

import charusat.com.charusatcdpc.R;

public class AddCompanyDetails extends AppCompatActivity {

    EditText ETcompany_name,ETcompany_location,ET_company_email,ET_company_type;
    EditText ETwebsite,ETrequired_students;
    Button BTsave,BTrequired_skills;
    Company company;
    String skills;
    String Firebase_id;
    DatabaseReference databaseReference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_company_details);

        company = new Company();
        databaseReference = FirebaseDatabase.getInstance().getReference("Company Details");

        ETcompany_name = (EditText) findViewById(R.id.EditText_company_name);
        ET_company_email = (EditText) findViewById(R.id.EditText_company_email);
        ET_company_type = (EditText) findViewById(R.id.EditText_company_type);
        ETcompany_location = (EditText) findViewById(R.id.EditText_location);
        ETrequired_students = (EditText) findViewById(R.id.EditText_required_students);
        ETwebsite = (EditText) findViewById(R.id.EditText_website);
        BTrequired_skills = (Button) findViewById(R.id.alert_dialog_skills);
        BTsave = (Button) findViewById(R.id.Button_save_company_details);


        setFirebase_id();


        BTrequired_skills.setOnClickListener(new View.OnClickListener() {
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
        company.setCompany_name(ETcompany_name.getText().toString().trim());
        company.setCompany_email(ET_company_email.getText().toString().trim());
        company.setRequired_students(ETrequired_students.getText().toString().trim());
        company.setCompany_location(ETcompany_location.getText().toString().trim());
        company.setCompany_type(ET_company_type.getText().toString().trim());
        company.setWebsite(ETwebsite.getText().toString().trim());

        company.setRequired_skills(skills);

        databaseReference.child(getFirebase_id()).setValue(company);

        Toast.makeText(getApplicationContext(),"Company Details Added Successfully",Toast.LENGTH_LONG).show();

    }

    public void AddSkills()
    {
        AlertDialog.Builder builder = new AlertDialog.Builder(AddCompanyDetails.this);

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
                       // selectedSkills.add(SkillsList.get(i));

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

       /* for (String s : SkillsList)
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

}
