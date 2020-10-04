package com.example.cps731_lab4;

import android.content.Context;
import android.content.Intent;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.LinkedList;

public class WordListAdapter extends RecyclerView.Adapter<WordListAdapter.WordViewHolder> {
    private final ArrayList<String> urlList;
    private LayoutInflater mInflater;
    private  ArrayList<String> mWordList;
    private String recipeDesc = "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Ut sollicitudin porttitor fermentum. Suspendisse id magna finibus, molestie felis aliquet, pellentesque diam. Nullam elit justo, lobortis id lectus nec, dictum iaculis felis.";
    private Context mContext;
    private int posit;
    public WordListAdapter(Context context, ArrayList<String> wordList, ArrayList<String> urlList) {

        mInflater = LayoutInflater.from(context);
        this.mWordList = wordList;
        this.urlList = urlList;
        mContext = context;
    }

    @NonNull
    @Override
    public WordViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View mItemView = mInflater.inflate(R.layout.wordlist_item,
                parent, false);
        return new WordViewHolder(mItemView, this);
    }

    @Override
    public void onBindViewHolder(@NonNull WordListAdapter.WordViewHolder holder, int position) {
        String mCurrent = mWordList.get(position);
        holder.wordItemView.setText(Html.fromHtml("<h4>" +mCurrent +"</h4>"+"<small>" +recipeDesc +"</small>"));
        posit = position;
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
            int mPosition = getLayoutPosition();
            Toast.makeText(mContext, Integer.toString(mPosition), Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(mContext, RecipePage.class);
            intent.putExtra("image_url", urlList.get(mPosition));
            intent.putExtra("recipe_name",mWordList.get(mPosition));
            intent.putExtra("recipe_desc", recipeDesc);
            mContext.startActivity(intent);
        }
    }

}