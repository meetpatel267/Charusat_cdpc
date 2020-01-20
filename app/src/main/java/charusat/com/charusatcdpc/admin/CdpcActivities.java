package charusat.com.charusatcdpc.admin;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.Resources;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import charusat.com.charusatcdpc.R;


public class CdpcActivities extends AppCompatActivity {

    ListView list;
    String[] titles;
    //String [] description;
    int[] imgs = {R.drawable.img_career,R.drawable.img_expert_lecture,R.drawable.img_industrial_visit,R.drawable.img_summer_internship,R.drawable.img_workshop};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cdpc_activities);

        Log.d("Activity created","Cdpc acrivity created");

        Resources res = getResources();
        titles = res.getStringArray(R.array.titles);
        //description = res.getStringArray(R.array.description);
        list = (ListView) findViewById(R.id.list_cdpc_activity);
        MyAdapter adapter = new MyAdapter(this,titles,imgs);
        list.setAdapter(adapter);
    }

    class MyAdapter extends ArrayAdapter<String> {
        Context context;
        int [] images;
        String [] mytitles;
        MyAdapter(Context c,String[] titles,int imgs[])
        {
            super(c,R.layout.cdpc_activities_listview_row,R.id.textView_title_activity,titles);
            this.context=c;
            this.images=imgs;
            this.mytitles=titles;
           // this.myDescriptions=desc;
        }

        @NonNull
        @Override
        public View getView(int position, View convertView, @NonNull ViewGroup parent) {
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            assert inflater != null;
            @SuppressLint("ViewHolder") View row = inflater.inflate(R.layout.cdpc_activities_listview_row,parent,false);
            ImageView myImage = (ImageView) row.findViewById(R.id.img_activity);
            TextView myTitle = (TextView) row.findViewById(R.id.textView_title_activity);
          // TextView myDesc = (TextView) cdpc_activities_listview_row.findViewById(R.id.text2);
            myImage.setImageResource(images[position]);
            myTitle.setText(mytitles[position]);
           // myDesc.setText(myDescriptions[position]);
            return row;
        }
    }
}
