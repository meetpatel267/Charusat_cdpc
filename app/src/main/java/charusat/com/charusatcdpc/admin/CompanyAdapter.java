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

public class CompanyAdapter extends RecyclerView.Adapter<charusat.com.charusatcdpc.admin.CompanyAdapter.CompanyViewHolder> {

    private Context mCtx;
    private List<Company> companyList;

    public CompanyAdapter(Context mCtx, List<Company> companyList) {
        this.mCtx = mCtx;
        this.companyList = companyList;
    }

    @NonNull
    @Override
    public charusat.com.charusatcdpc.admin.CompanyAdapter.CompanyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mCtx).inflate(R.layout.company_details_listview_row, parent, false);
        return new charusat.com.charusatcdpc.admin.CompanyAdapter.CompanyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull charusat.com.charusatcdpc.admin.CompanyAdapter.CompanyViewHolder holder, int position) {
        Company company = companyList.get(position);

        if(company.company_name != null)
        {
            holder.textViewCompanyName.setVisibility(View.VISIBLE);
            holder.textViewCompanyName.setText("Name: "+ company.company_name);
        }

        if(company.company_email != null)
        {
            holder.textViewCompanyEmail.setVisibility(View.VISIBLE);
            holder.textViewCompanyEmail.setText("Email: "+ company.company_email);
        }

        if(company.company_location != null)
        {
            holder.textViewCompanyLocation.setVisibility(View.VISIBLE);
            holder.textViewCompanyLocation.setText("Location: "+ company.company_location);
        }

        if(company.company_type != null)
        {
            holder.textViewCompanyType.setVisibility(View.VISIBLE);
            holder.textViewCompanyType.setText("Type: "+ company.company_type);
        }

        if(company.website != null)
        {
            holder.textViewWebsite.setVisibility(View.VISIBLE);
            holder.textViewWebsite.setText("Website: "+ company.website);
        }
        if(company.required_students != null)
        {
            holder.textViewRequiredStudents.setVisibility(View.VISIBLE);
            holder.textViewRequiredStudents.setText("Name: "+ company.required_students);
        }



        if(company.required_skills != null)
        {
            holder.textViewRequiredSkills.setVisibility(View.VISIBLE);
            holder.textViewRequiredSkills.setText("Required Skills: " + company.required_skills);
        }



    }

    @Override
    public int getItemCount() {
        return companyList.size();
    }

    class CompanyViewHolder extends RecyclerView.ViewHolder {

        TextView textViewCompanyName, textViewCompanyLocation, textViewCompanyType, textViewCompanyEmail, textViewWebsite;
        TextView textViewRequiredStudents, textViewRequiredSkills;

        public CompanyViewHolder(@NonNull View itemView) {
            super(itemView);

            textViewCompanyName = itemView.findViewById(R.id.textView_company_name);
            textViewCompanyLocation =itemView.findViewById(R.id.textView_company_location);
            textViewCompanyType = itemView.findViewById(R.id.textView_company_type);
            textViewCompanyEmail = itemView.findViewById(R.id.textView_company_email);
            textViewWebsite = itemView.findViewById(R.id.textView_website);
            textViewRequiredStudents = itemView.findViewById(R.id.textView_required_students);
            textViewRequiredSkills = itemView.findViewById(R.id.textView_required_skills);

        }
    }
}