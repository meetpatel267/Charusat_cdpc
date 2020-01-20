package charusat.com.charusatcdpc.student;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import charusat.com.charusatcdpc.R;

public class StudentAdapter extends RecyclerView.Adapter<StudentAdapter.StudentViewHolder> {

    private Context mCtx;
    private List<Student> studentList;

    public StudentAdapter(Context mCtx, List<Student> studentList) {
        this.mCtx = mCtx;
        this.studentList = studentList;
    }

    @NonNull
    @Override
    public StudentViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mCtx).inflate(R.layout.student_data_listview_row, parent, false);
        return new StudentViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull StudentViewHolder holder, int position) {
        Student student = studentList.get(position);

        if(student.id != null)
        {
            holder.textViewId.setVisibility(View.VISIBLE);
            holder.textViewId.setText("ID: "+ student.id);
        }

        if(student.name != null)
        {
            holder.textViewName.setVisibility(View.VISIBLE);
            holder.textViewName.setText("Name: " + student.name);
        }

        if(student.address != null)
        {
            holder.textViewAddress.setVisibility(View.VISIBLE);
            holder.textViewAddress.setText("Address: " + student.address);
        }

        if(student.birthdate != null)
        {
            holder.textViewBirthdate.setVisibility(View.VISIBLE);
            holder.textViewBirthdate.setText("DOB: " + student.birthdate);
        }

        if(student.email != null)
        {
            holder.textViewEmail.setVisibility(View.VISIBLE);
            holder.textViewEmail.setText("Email: " + student.email);
        }

        if(student.phone != null)
        {
            holder.textViewPhone.setVisibility(View.VISIBLE);
            holder.textViewPhone.setText("Mobile No. : " + student.phone);
        }

        if(student.branch != null)
        {
            holder.textViewBranch.setVisibility(View.VISIBLE);
            holder.textViewBranch.setText("Branch: " + student.branch);
        }

        if(student.sem != null)
        {
            holder.textViewSem.setVisibility(View.VISIBLE);
            holder.textViewSem.setText("Sem: " + student.sem);
        }

        if(student.cgpa != null)
        {
            holder.textViewCgpa.setVisibility(View.VISIBLE);
            holder.textViewCgpa.setText("CGPA: " + student.cgpa);
        }

        if(student.projects != null)
        {
            holder.textViewProjects.setVisibility(View.VISIBLE);
            holder.textViewProjects.setText("Projects: " + student.projects);
        }

        if(student.skills != null)
        {
            holder.textViewSkills.setVisibility(View.VISIBLE);
            holder.textViewSkills.setText("Skills: " + student.skills);
        }



    }

    @Override
    public int getItemCount() {
        return studentList.size();
    }

    class StudentViewHolder extends RecyclerView.ViewHolder {

        TextView textViewName, textViewId, textViewBirthdate, textViewEmail, textViewPhone;
        TextView textViewAddress, textViewBranch, textViewSem, textViewCgpa;
        TextView textViewProjects, textViewSkills;

        public StudentViewHolder(@NonNull View itemView) {
            super(itemView);

            textViewName = itemView.findViewById(R.id.textView_name);
            textViewId = itemView.findViewById(R.id.textView_id);
            textViewBirthdate = itemView.findViewById(R.id.textView_birthdate);
            textViewEmail= itemView.findViewById(R.id.textView_email);
            textViewAddress = itemView.findViewById(R.id.textView_address);
            textViewPhone = itemView.findViewById(R.id.textView_mobile_number);
            textViewCgpa = itemView.findViewById(R.id.textView_cgpa);
            textViewBranch = itemView.findViewById(R.id.textView_branch);
            textViewSem = itemView.findViewById(R.id.textView_sem);
            textViewProjects = itemView.findViewById(R.id.textView_project);
            textViewSkills = itemView.findViewById(R.id.textView_skills);


        }
    }
}