package com.example.cps731_lab4;

import android.content.Context;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.LinkedList;

public class WordListAdapter extends RecyclerView.Adapter<WordListAdapter.WordViewHolder>  {
    private final LinkedList<String> mWordList;
    private LayoutInflater mInflater;
    private String recipeDesc = "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Ut sollicitudin porttitor fermentum. Suspendisse id magna finibus, molestie felis aliquet, pellentesque diam. Nullam elit justo, lobortis id lectus nec, dictum iaculis felis.";
    public WordListAdapter(Context context, LinkedList<String> wordList) {

        mInflater = LayoutInflater.from(context);
        this.mWordList = wordList;
    }

    @NonNull
    @Override
    public WordListAdapter.WordViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View mItemView = mInflater.inflate(R.layout.wordlist_item,
                parent, false);
        return new WordViewHolder(mItemView, this);
    }

    @Override
    public void onBindViewHolder(@NonNull WordListAdapter.WordViewHolder holder, int position) {
        String mCurrent = mWordList.get(position);
        holder.wordItemView.setText(Html.fromHtml("<h4>" +mCurrent +"</h4>"+"<small>" +recipeDesc +"</small>"));
    }

    @Override
    public int getItemCount() {
        return mWordList.size();
    }


    private void getLayoutPosition() {
    }

    public class WordViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        public final TextView wordItemView;
        final WordListAdapter mAdapter;
        public WordViewHolder(View itemView, WordListAdapter adapter) {
            super(itemView);
            wordItemView = itemView.findViewById(R.id.word);
            this.mAdapter = adapter;
            itemView.setOnClickListener(this);

        }

        @Override
        public void onClick(View view) {
        }
    }
}