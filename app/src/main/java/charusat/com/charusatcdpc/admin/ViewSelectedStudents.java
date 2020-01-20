package charusat.com.charusatcdpc.admin;

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

public class ViewSelectedStudents extends AppCompatActivity {

    DatabaseReference databaseReference;
    private RecyclerView recyclerview_selected_student;
    private AdminAdapter adapter;
    private Admin admin;
    private List<Admin> selectedstudentList;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_selected_student_details);

        admin = new Admin();

        recyclerview_selected_student = (RecyclerView) findViewById(R.id.recyclerView_selected_student);
        recyclerview_selected_student.setHasFixedSize(true);
        recyclerview_selected_student.setLayoutManager(new LinearLayoutManager(this));
        selectedstudentList = new ArrayList<>();
        adapter = new AdminAdapter(this, selectedstudentList);
        recyclerview_selected_student.setAdapter(adapter);


        databaseReference = FirebaseDatabase.getInstance().getReference("Admin");

        databaseReference.addListenerForSingleValueEvent(valueEventListener);


    }


    ValueEventListener valueEventListener = new ValueEventListener() {
        @Override
        public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
            selectedstudentList.clear();
            if (dataSnapshot.exists()) {
                for (DataSnapshot snapshot : dataSnapshot.getChildren()) {
                    admin = snapshot.getValue(Admin.class);
                    selectedstudentList.add(admin);

                }
                adapter.notifyDataSetChanged();

            }
        }

        @Override
        public void onCancelled(@NonNull DatabaseError databaseError) {
            Toast.makeText(getApplicationContext(), "Data Not Found. ", Toast.LENGTH_LONG).show();
        }
    };


}