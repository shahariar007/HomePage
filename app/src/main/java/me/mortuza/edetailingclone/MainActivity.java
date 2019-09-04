package me.mortuza.edetailingclone;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.util.Linkify;
import android.widget.LinearLayout;

import java.util.ArrayList;
import java.util.List;

import me.mortuza.edetailingclone.adapter.TestAdapter;
import me.mortuza.edetailingclone.customHut.StatusTextView;

public class MainActivity extends AppCompatActivity {

    List<ModelStatus> modelStatuses = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        RecyclerView view = findViewById(R.id.design);
        String[] x = getResources().getStringArray(R.array.demoDec);
        String[] image = getResources().getStringArray(R.array.image);

        for (int i = 0; i < 5; i++) {
            modelStatuses.add(new ModelStatus("s" + i, "2.20 hour", image[i], x[i]));
        }
        TestAdapter testAdapter = new TestAdapter(this);
        testAdapter.setModelStatuses(modelStatuses);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        view.setLayoutManager(linearLayoutManager);
        view.setAdapter(testAdapter);
        DividerItemDecoration dividerItemDecoration = new DividerItemDecoration(view.getContext(),
                linearLayoutManager.getOrientation());
        view.addItemDecoration(dividerItemDecoration);
        JsonTest jsonTest = new JsonTest();
        jsonTest.createJson();
    }
}
