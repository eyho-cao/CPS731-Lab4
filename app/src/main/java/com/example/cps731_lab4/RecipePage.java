package com.example.cps731_lab4;

import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.bumptech.glide.Glide;


public class RecipePage extends AppCompatActivity {
    private static final String TAG = "Recipe Page";

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.recipe_page);
        Log.d(TAG, "onCreate: started.");

        getIncomingIntent();
    }

    private void getIncomingIntent(){
        Log.d(TAG, "getIncomingIntent: checking for incoming intents.");

        if(getIntent().hasExtra("image_url") && getIntent().hasExtra("recipe_name") && getIntent().hasExtra("recipe_desc")){
            Log.d(TAG, "getIncomingIntent: found intent extras.");

            String imageUrl = getIntent().getStringExtra("image_url");
            String recipe = getIntent().getStringExtra("recipe_name");
            String recipeDesc = getIntent().getStringExtra("recipe_desc");

            setImage(imageUrl, recipe, recipeDesc);
        }
    }


    private void setImage(String imageUrl, String recipeName, String recipeDesc){
        Log.d(TAG, "setImage: setting te image and name to widgets.");

        TextView name = findViewById(R.id.recipeTxtView);
        name.setText(recipeName);

        ImageView image = findViewById(R.id.recipeImage);
        Glide.with(this)
                .asBitmap()
                .load(imageUrl)
                .into(image);

        TextView desc = findViewById(R.id.recipeTxtView);
        desc.setText(recipeDesc);
    }

}
