package com.example.test2;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.os.Bundle;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        RecyclerView recyclerView = findViewById(R.id.list);

        List<ItemClass> itemClasses = new ArrayList<>();
        itemClasses.add(new ItemClass(ItemClass.LayoutTwo, R.drawable.icon, "Item Type 2", "Text"));
        itemClasses.add(new ItemClass(ItemClass.LayoutOne, "Item Type 1"));
        itemClasses.add(new ItemClass(ItemClass.LayoutOne, "Item Type 1"));
        itemClasses.add(new ItemClass(ItemClass.LayoutTwo, R.drawable.icon, "Item Type 2", "Text"));
        itemClasses.add(new ItemClass(ItemClass.LayoutOne, "Item Type 1"));
        itemClasses.add(new ItemClass(ItemClass.LayoutOne, "Item Type 1"));
        itemClasses.add(new ItemClass(ItemClass.LayoutOne, "Item Type 1"));
        itemClasses.add(new ItemClass(ItemClass.LayoutOne, "Item Type 1"));
        itemClasses.add(new ItemClass(ItemClass.LayoutOne, "Item Type 1"));
        itemClasses.add(new ItemClass(ItemClass.LayoutOne, "Item Type 1"));
        itemClasses.add(new ItemClass(ItemClass.LayoutOne, "Item Type 1"));
        itemClasses.add(new ItemClass(ItemClass.LayoutOne, "Item Type 1"));
        itemClasses.add(new ItemClass(ItemClass.LayoutOne, "Item Type 1"));
        itemClasses.add(new ItemClass(ItemClass.LayoutOne, "Item Type 1"));
        itemClasses.add(new ItemClass(ItemClass.LayoutOne, "Item Type 1"));
        itemClasses.add(new ItemClass(ItemClass.LayoutOne, "Item Type 1"));
        itemClasses.add(new ItemClass(ItemClass.LayoutOne, "Item Type 1"));
        itemClasses.add(new ItemClass(ItemClass.LayoutOne, "Item Type 1"));
        itemClasses.add(new ItemClass(ItemClass.LayoutTwo, R.drawable.icon, "Item Type 2", "Text"));
        itemClasses.add(new ItemClass(ItemClass.LayoutOne, "Item Type 1"));
        itemClasses.add(new ItemClass(ItemClass.LayoutOne, "Item Type 1"));

        MyAdapter adapter = new MyAdapter(itemClasses);

        GridLayoutManager glm = new GridLayoutManager(getApplicationContext(), 2);
        glm.setSpanSizeLookup(new GridLayoutManager.SpanSizeLookup() {
            @Override
            public int getSpanSize(int position) {
                switch(adapter.getItemViewType(position)) {
                    case 1:
                        return 2;
                    default:
                        return 1;
                }
            }
        });
        recyclerView.setLayoutManager(glm);
        recyclerView.setAdapter(adapter);
    }
}