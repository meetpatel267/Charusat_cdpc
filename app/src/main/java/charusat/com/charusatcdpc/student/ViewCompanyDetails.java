package charusat.com.charusatcdpc.student;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

import charusat.com.charusatcdpc.R;
import charusat.com.charusatcdpc.admin.Admin;
import charusat.com.charusatcdpc.admin.Company;
import charusat.com.charusatcdpc.admin.CompanyAdapter;

public class ViewCompanyDetails extends AppCompatActivity {

    Company company;
    DatabaseReference databaseReference , new_databaseReference;
    private RecyclerView recyclerview_company;
    private CompanyAdapter adapter;
    private List<Company> companyList;

    String Firebase_id;

    Admin admin;

    Intent i;

    private Button btn_apply;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_company_details);

        i = getIntent();

        company = new Company();
        admin = new Admin();
        btn_apply = (Button) findViewById(R.id.Button_apply) ;
        recyclerview_company = (RecyclerView) findViewById(R.id.recyclerView_company_details);
        recyclerview_company.setHasFixedSize(true);
        recyclerview_company.setLayoutManager(new LinearLayoutManager (this));
        companyList = new ArrayList<>();
        adapter = new CompanyAdapter(this, companyList);
        recyclerview_company.setAdapter(adapter);


        databaseReference = FirebaseDatabase.getInstance().getReference("Company Details");

        databaseReference.addListenerForSingleValueEvent(valueEventListener);

        setFirebase_id();

        btn_apply.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Apply_Company();
            }
        });
    }

    public void Apply_Company() {

        String id = i.getStringExtra("id");
        admin.setSelected_student_id(id);

        new_databaseReference = FirebaseDatabase.getInstance().getReference("Admin");
        new_databaseReference.child(getFirebase_id()).setValue(admin);

        Toast.makeText(getApplicationContext(),"Applied for this company Successfully",Toast.LENGTH_LONG).show();

    }

    ValueEventListener valueEventListener = new ValueEventListener() {
        @Override
        public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
            companyList.clear();
            if (dataSnapshot.exists()) {
                for (DataSnapshot snapshot : dataSnapshot.getChildren()) {
                    company = snapshot.getValue(Company.class);
                    companyList.add(company);

                }
                adapter.notifyDataSetChanged();

            }
        }

        @Override
        public void onCancelled(@NonNull DatabaseError databaseError) {
            Toast.makeText(getApplicationContext(),"Data Not Found. ",Toast.LENGTH_LONG).show();
        }
    };

    public void setFirebase_id()
    {
        Firebase_id = databaseReference.push().getKey();
    }

    public String getFirebase_id()
    {
        return Firebase_id;
    }


}