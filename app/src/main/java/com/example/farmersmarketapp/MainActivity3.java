package com.example.farmersmarketapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity3 extends AppCompatActivity {

    ImageView groceryName;
    TextView searchBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);
    }

    public int[] myImages = {R.drawable.potato, R.drawable.tomato, R.drawable.eggplant,
            R.drawable.pumpkin,R.drawable.onion, R.drawable.garlic, R.drawable.ginger,
            R.drawable.apple,R.drawable.egg,R.drawable.rice, R.drawable.wheat, R.drawable.oil};

    public void itemSelected(int index, String productName){
        Intent intent = new Intent(this, MainActivity4.class);
        Bundle bundle = new Bundle();
        bundle.putInt("imageIndex",myImages[index]);
        bundle.putString("productName",productName);
        intent.putExtras(bundle);
        startActivity(intent);
    }

    public void onPotato(View view){itemSelected(0,"Potato");}
    public void onTomato(View view){itemSelected(1,"Tomato");}
    public void onEggplant(View view){itemSelected(2,"Eggplant");}
    public void onPumpkin(View view){itemSelected(3,"Pumpkin");}
    public void onOnion(View view){itemSelected(4,"Onion");}
    public void onGarlic(View view){itemSelected(5,"Garlic");}
    public void onGinger(View view){itemSelected(6,"Ginger");}
    public void onApple(View view){itemSelected(7,"Apple");}
    public void onEggs(View view){itemSelected(8,"Eggs");}
    public void onRice(View view){itemSelected(9,"Rice");}
    public void onWheat(View view){itemSelected(10,"Wheat Grains");}
    public void onOil(View view){itemSelected(11,"Olive Oil");}

    public void onRandomItem(View view){
        searchBar = findViewById(R.id.searchView2);
        searchBar.getText().toString();
    }
}