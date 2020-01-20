package charusat.com.charusatcdpc.admin;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import charusat.com.charusatcdpc.R;

public class AdminAdapter extends RecyclerView.Adapter<charusat.com.charusatcdpc.admin.AdminAdapter.AdminViewHolder> {

    private Context mCtx;
    private List<Admin> selectedstudentList;

    public AdminAdapter(Context mCtx, List<Admin> selectedstudentList) {
        this.mCtx = mCtx;
        this.selectedstudentList = selectedstudentList;
    }

    @NonNull
    @Override
    public charusat.com.charusatcdpc.admin.AdminAdapter.AdminViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mCtx).inflate(R.layout.selected_student_listview_row, parent, false);
        return new charusat.com.charusatcdpc.admin.AdminAdapter.AdminViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull charusat.com.charusatcdpc.admin.AdminAdapter.AdminViewHolder holder, int position) {
       Admin admin = selectedstudentList.get(position);

        if(admin.selected_student_id != null)
        {
            holder.textViewSelectedStudentId.setVisibility(View.VISIBLE);
            holder.textViewSelectedStudentId.setText("ID: "+ admin.selected_student_id);
        }


    }

    @Override
    public int getItemCount() {
        return selectedstudentList.size();
    }

    class AdminViewHolder extends RecyclerView.ViewHolder {

        TextView textViewSelectedStudentId;

        public AdminViewHolder(@NonNull View itemView) {
            super(itemView);

            textViewSelectedStudentId = itemView.findViewById(R.id.textView_selected_student_id);


        }
    }
}