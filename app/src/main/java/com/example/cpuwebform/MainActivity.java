package com.example.cpuwebform;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    String url_api_view = "http://student02.csucleeds.com/student02/cpu/api.php?apicall=view";

    FloatingActionButton fab;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        fab = findViewById(R.id.floatingActionButton);
        fab.setOnClickListener(new View.OnClickListener() {


            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getBaseContext(), NewCustomerActivity.class);
                startActivity(intent);
            }
        });
    }


    public void onResume() {
        super.onResume();

        URLConnectionGetHandler uRLConnectionGetHandler = new URLConnectionGetHandler();
        uRLConnectionGetHandler.setDataDownloadListener(new URLConnectionGetHandler.DataDownloadListener() {

            @Override
            public void dataDownloadedSuccessfully(Object data) {
                ListView listView = (ListView) findViewById(R.id.listView);

                ArrayAdapter<String> adapter = new ArrayAdapter<String>(MainActivity.this,
                        android.R.layout.simple_list_item_1, jsonDecoder((String) data));

                if (listView != null) {
                    listView.setAdapter(adapter);
                }
            }

            @Override
            public void dataDownloadFailed() {
                Toast.makeText(MainActivity.this, "No records found.", Toast.LENGTH_SHORT).show();

            }
        });
        uRLConnectionGetHandler.execute(url_api_view);


    }

    private List<String> jsonDecoder(String json_string) {
        List<String> items = new ArrayList<>();
        try {
            json_string = json_string.substring(json_string.indexOf("{"));
            JSONObject root = new JSONObject(json_string);
            JSONArray array = root.getJSONArray("Customer");

            for (int i = 0; i < array.length(); i++) {
                JSONObject object = array.getJSONObject(i);
                Customer newCustomer = new Customer(
                        object.getString("id"),
                        object.getString("customer_id"),
                        object.getString("customer_type"),
                        object.getString("customer_sub_type"),
                        object.getString("status"),
                        object.getString("num_locations"),
                        object.getString("company_name"),
                        object.getString("contact_name"),
                        object.getString("title"),
                        object.getString("role"),
                        object.getString("phone_number"),
                        object.getString("mobile_number"),
                        object.getString("email_address"),
                        object.getString("street"),
                        object.getString("postcode"),
                        object.getString("county"),
                        object.getString("city"),
                        object.getString("annual_revenue")
                );
                items.add(newCustomer.toString());
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return items; // Always return the list, even if it's empty.
    }
}