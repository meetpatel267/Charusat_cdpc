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

public class ViewStudentDetails extends AppCompatActivity {

    Student student;
    DatabaseReference databaseReference;
    private RecyclerView recyclerview_students;
    private StudentAdapter adapter;
    private List<Student> studentList;

    Intent i;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_student_data);
        i = getIntent();
        student = new Student();
        recyclerview_students = (RecyclerView) findViewById(R.id.recyclerView_student_data);
        recyclerview_students.setHasFixedSize(true);
        recyclerview_students.setLayoutManager(new LinearLayoutManager (this));
        studentList = new ArrayList<>();
        adapter = new StudentAdapter(this, studentList);
        recyclerview_students.setAdapter(adapter);

        String id = i.getStringExtra("id");

        databaseReference = FirebaseDatabase.getInstance().getReference("Student");

        Query query = FirebaseDatabase.getInstance().getReference("Student")
                .orderByChild("id")
                .equalTo(id);

        query.addListenerForSingleValueEvent(valueEventListener);

        //databaseReference.addListenerForSingleValueEvent(valueEventListener);
    }

    ValueEventListener valueEventListener = new ValueEventListener() {
        @Override
        public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
            studentList.clear();
            if (dataSnapshot.exists()) {
                for (DataSnapshot snapshot : dataSnapshot.getChildren()) {
                    Student student = snapshot.getValue(Student.class);
                    studentList.add(student);

                }
                adapter.notifyDataSetChanged();

            }
        }

        @Override
        public void onCancelled(@NonNull DatabaseError databaseError) {
            Toast.makeText(getApplicationContext(),"Data Not Found. ",Toast.LENGTH_LONG).show();
        }
    };


}