package com.example.test2;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import java.util.List;
import static com.example.test2.ItemClass.LayoutOne;
import static com.example.test2.ItemClass.LayoutTwo;

public class MyAdapter extends RecyclerView.Adapter <RecyclerView.ViewHolder> {

    public List<ItemClass> itemClassList;
    public MyAdapter(List<ItemClass> itemClassList)
    {
        this.itemClassList = itemClassList;
    }

    @Override
    public int getItemViewType(int position)
    {
        switch (itemClassList.get(position).getViewType()) {
            case 0:
                return LayoutOne;
            case 1:
                return LayoutTwo;
            default:
                return -1;
        }
    }

    static class LayoutOneViewHolder extends RecyclerView.ViewHolder {

        private final TextView textview;
        private final LinearLayout linearLayout;

        public LayoutOneViewHolder(@NonNull View itemView)
        {
            super(itemView);
            textview = itemView.findViewById(R.id.text);
            linearLayout = itemView.findViewById(R.id.linearlayout);
        }

        private void setView(String text)
        {
            textview.setText(text);
        }
    }

    static class LayoutTwoViewHolder extends RecyclerView.ViewHolder {

        private final ImageView icon;
        private final TextView text_one;
        private final TextView text_two;
        private final LinearLayout linearLayout;

        public LayoutTwoViewHolder(@NonNull View itemView)
        {
            super(itemView);
            icon = itemView.findViewById(R.id.image);
            text_one = itemView.findViewById(R.id.text_one);
            text_two = itemView.findViewById(R.id.text_two);
            linearLayout = itemView.findViewById(R.id.linearlayout);
        }

        private void setViews(int image, String textOne, String textTwo)
        {
            icon.setImageResource(image);
            text_one.setText(textOne);
            text_two.setText(textTwo);
        }
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder
    onCreateViewHolder(@NonNull ViewGroup parent, int viewType)
    {
        switch (viewType) {
            case LayoutOne:
                View layoutOne = LayoutInflater.from(parent.getContext())
                        .inflate(R.layout.layout_one, parent, false);
                return new LayoutOneViewHolder(layoutOne);
            case LayoutTwo:
                View layoutTwo = LayoutInflater.from(parent.getContext())
                        .inflate(R.layout.layout_two, parent, false);
                return new LayoutTwoViewHolder(layoutTwo);
            default:
                return null;
        }
    }

    @Override
    public void onBindViewHolder(
            @NonNull RecyclerView.ViewHolder holder, int position)
    {

        switch (itemClassList.get(position).getViewType()) {
            case LayoutOne:
                String text = itemClassList.get(position).getText();
                ((LayoutOneViewHolder)holder).setView(text);
                ((LayoutOneViewHolder)holder)
                        .linearLayout.setOnClickListener(
                        new View.OnClickListener() {
                            @Override
                            public void onClick(View view)
                            {
                                Toast.makeText(view.getContext(), "Layout One!", Toast.LENGTH_SHORT).show();
                            }
                        });
                break;

            case LayoutTwo:
                int image = itemClassList.get(position).geticon();
                String text_one = itemClassList.get(position).getText_one();
                String text_two = itemClassList.get(position).getText_two();
                ((LayoutTwoViewHolder)holder).setViews(image, text_one, text_two);
                ((LayoutTwoViewHolder)holder).linearLayout.setOnClickListener(
                        new View.OnClickListener() {
                            @Override
                            public void onClick(View view)
                            {
                                Toast.makeText(view.getContext(), "Layout Two!", Toast.LENGTH_SHORT).show();
                            }
                        });
                break;
            default:
        }
    }

    @Override
    public int getItemCount()
    {
        return itemClassList.size();
    }
}

