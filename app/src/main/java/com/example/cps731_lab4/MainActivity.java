package com.example.cps731_lab4;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;

public class MainActivity extends AppCompatActivity {

    private final ArrayList<String> mWordList = new ArrayList<>();
    private ArrayList<String> recipeTitle = new ArrayList<>();
    private ArrayList<String> mURLList = new ArrayList<>();
    private RecyclerView mRecyclerView;
    private WordListAdapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initRecipeTitle();
        initURLList();

        for (int i = 0; i < 10; i++) {
            mWordList.add(recipeTitle.get(i));
        }
        // Get a handle to the RecyclerView.
        mRecyclerView = findViewById(R.id.recyclerview);
        // Create an adapter and supply the data to be displayed.
        mAdapter = new WordListAdapter(this, recipeTitle, mURLList);
        // Connect the adapter with the RecyclerView.
        mRecyclerView.setAdapter(mAdapter);
        // Give the RecyclerView a default layout manager.
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        mRecyclerView.addItemDecoration(new DividerItemDecoration(this, DividerItemDecoration.VERTICAL));

    }

    void initRecipeTitle()
    {
        recipeTitle.add("Mac & Cheese");
        recipeTitle.add("Kale/Lemon Sandwiches");
        recipeTitle.add("Mango-Lime Bean Salad");
        recipeTitle.add("Sweet  Potato and Lentil Soup w/ Shiitake Mushrooms");
        recipeTitle.add("Lorem Ipsum");
        recipeTitle.add("Lorum more Ipsum");
        recipeTitle.add("Lorem some more Ipsum");
        recipeTitle.add("I dont know what im doing now");
        recipeTitle.add("some more filler");
        recipeTitle.add("There aint nothin else here my guy");

    }
    void initURLList()
    {
        mURLList.add("https://celebratingsweets.com/wp-content/uploads/2016/03/Guinness-Irish-Cheddar-Macaroni-and-Cheese-2-500x500.jpg");
        mURLList.add("https://freshforkmarket.com/wp-content/uploads/2015/05/kale_lemon_sandwiches_2.jpg");
        mURLList.add("https://healthyfitnessmeals.com/wp-content/uploads/2018/04/mango-black-bean-salad-2.jpg");
        mURLList.add("https://vegan-magazine.com/wp-content/uploads/2012/04/Lentil-sweet-potato-soup.jpg");
        mURLList.add("https://storcpdkenticomedia.blob.core.windows.net/media/recipemanagementsystem/media/recipe-media-files/recipes/retail/x17/18134-five-star-chocolate-chip-cookies-760x580.jpg?ext=.jpg");
        mURLList.add("https://storcpdkenticomedia.blob.core.windows.net/media/recipemanagementsystem/media/recipe-media-files/recipes/retail/x17/18134-five-star-chocolate-chip-cookies-760x580.jpg?ext=.jpg");
        mURLList.add("https://storcpdkenticomedia.blob.core.windows.net/media/recipemanagementsystem/media/recipe-media-files/recipes/retail/x17/18134-five-star-chocolate-chip-cookies-760x580.jpg?ext=.jpg");
        mURLList.add("https://storcpdkenticomedia.blob.core.windows.net/media/recipemanagementsystem/media/recipe-media-files/recipes/retail/x17/18134-five-star-chocolate-chip-cookies-760x580.jpg?ext=.jpg");
        mURLList.add("https://storcpdkenticomedia.blob.core.windows.net/media/recipemanagementsystem/media/recipe-media-files/recipes/retail/x17/18134-five-star-chocolate-chip-cookies-760x580.jpg?ext=.jpg");
        mURLList.add("https://storcpdkenticomedia.blob.core.windows.net/media/recipemanagementsystem/media/recipe-media-files/recipes/retail/x17/18134-five-star-chocolate-chip-cookies-760x580.jpg?ext=.jpg");
    }
}