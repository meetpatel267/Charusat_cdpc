package charusat.com.charusatcdpc.admin;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.github.barteksc.pdfviewer.PDFView;

import charusat.com.charusatcdpc.R;

public class PlacementData extends AppCompatActivity {
    PDFView pdfViewer;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_placement_data);
        pdfViewer=(PDFView) findViewById(R.id.pdfviewer);
        pdfViewer.fromAsset("PlacementData2018.pdf").load();
    }
}
