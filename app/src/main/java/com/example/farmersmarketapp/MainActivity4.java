package com.example.farmersmarketapp;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.net.URLEncoder;

public class MainActivity4 extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    TextView productTextView,unitTextView,totalPriceTextView;
    EditText priceEditText,quantityEditText;
    ImageView listingImage;
    Spinner spinner;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main4);

        Intent intent = getIntent();
        Bundle bundle = intent.getExtras();
        Integer listingImageNumber = bundle.getInt("imageIndex");
        String listingProductName = bundle.getString("productName");

        listingImage = findViewById(R.id.imageView);
        listingImage.setImageResource(listingImageNumber);

        productTextView = findViewById(R.id.textView14);
        productTextView.setText("Product Name: "+listingProductName);

        spinner = (Spinner) findViewById(R.id.spinner);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.units_array, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);
        spinner.setOnItemSelectedListener(this);
    }

    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
        Toast.makeText(getApplicationContext(), "Selected Units: "
                        +adapterView.getItemAtPosition(i),
                Toast.LENGTH_SHORT).show();
        String unitName = spinner.getSelectedItem().toString();
        unitTextView = findViewById(R.id.textView18);
        unitTextView.setText("per "+unitName);
    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {}

    public void onPrice(View view){
        priceEditText = findViewById(R.id.editTextTextPersonName2);
        quantityEditText = findViewById(R.id.editTextTextPersonName);
        int unitPrice = Integer.parseInt(priceEditText.getText().toString());
        int quantity = Integer.parseInt(quantityEditText.getText().toString());
        totalPriceTextView = findViewById(R.id.textView19);
        totalPriceTextView.setText("Total Deal Price: "+String.valueOf(unitPrice*quantity));
    }

    public void Chat(View v) {
        try {
            Intent sendMsg = new Intent(Intent.ACTION_VIEW);
            String url = "https://api.whatsapp.com/send?phone=" + "+92 1111111111" + "&text=" + URLEncoder.encode("Your Message to Contact Number", "UTF-8");
            sendMsg.setPackage("com.whatsapp");
            sendMsg.setData(Uri.parse(url));
            if (sendMsg.resolveActivity(getPackageManager()) != null) {
                startActivity(sendMsg);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}