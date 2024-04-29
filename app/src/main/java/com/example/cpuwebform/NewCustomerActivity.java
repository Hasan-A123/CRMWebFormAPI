package com.example.cpuwebform;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;
import android.content.Intent;
import android.app.Activity;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.List;
public class NewCustomerActivity  extends AppCompatActivity {

    String url_insert_customer = "http://student02.csucleeds.com/student02/cpu/api.php?apicall=insert";
    Spinner  spinner_type, spinner_customer_sub_type, spinner_status;
    TextView  textView_type, textView_customer_sub_type, textView_status;
    EditText editText_customer_accounting_id,editText_no_of_locations, editText_company_name, editText_contact_name, editText_title,
            editText_role, editText_phone_number, editText_mobile_number, editText_email_address,
            editText_street_address, editText_postcode, editText_county, editText_City, editText_annual_revenue;

    Button button_submit;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_customer);


        spinner_type = findViewById(R.id.spinner_type);
        spinner_customer_sub_type = findViewById(R.id.spinner_customer_sub_type);
        spinner_status = findViewById(R.id.spinner_status);
        textView_type = findViewById(R.id.textView_type);
        textView_customer_sub_type = findViewById(R.id.textView_customer_sub_type);
        textView_status = findViewById(R.id.textView_status);
        editText_customer_accounting_id= findViewById(R.id.editText_customer_accounting_id);
        editText_no_of_locations= findViewById(R.id.editText_no_of_locations);
        editText_company_name= findViewById(R.id.editText_company_name);
        editText_contact_name= findViewById(R.id.editText_contact_name);
        editText_title= findViewById(R.id.editText_title);
        editText_role= findViewById(R.id.editText_role);
        editText_phone_number= findViewById(R.id.editText_phone_number);
        editText_mobile_number= findViewById(R.id.editText_mobile_number);
        editText_email_address= findViewById(R.id.editText_email_address);
        editText_street_address= findViewById(R.id.editText_street_address);
        editText_postcode= findViewById(R.id.editText_postcode);
        editText_county= findViewById(R.id.editText_county);
        editText_City= findViewById(R.id.editText_City);
        editText_annual_revenue= findViewById(R.id.editText_annual_revenue);


        populateSpinners();

        //button
        button_submit = findViewById(R.id.button_submit);
        button_submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                URLConnectionPostHandler uRLConnectionPostHandler = new URLConnectionPostHandler();
                uRLConnectionPostHandler.setDataDownloadListener(new URLConnectionPostHandler.DataDownloadListener() {
                    @Override
                    public void dataDownloadedSuccessfully(Object data) {
                        // handler result

                        Toast.makeText(NewCustomerActivity.this, data.toString(), Toast.LENGTH_SHORT).show();
                    }

                    @Override
                    public void dataDownloadFailed() {
                        Toast.makeText(NewCustomerActivity.this, "Record not added.", Toast.LENGTH_SHORT).show();
                    }
                });
                uRLConnectionPostHandler.execute(url_insert_customer, generateParameters());

                Intent resultIntent = new Intent();
                setResult(Activity.RESULT_OK, resultIntent);
                finish();
            }
        });
    }
    private void populateSpinners() {
        List<String> type = new ArrayList<String>();
        type.add("prospect");
        type.add("customer");
        type.add("vendor");
        type.add("competitor");

        List<String> customer_sub_type = new ArrayList<String>();
        customer_sub_type.add("commercial");
        customer_sub_type.add("educational");
        customer_sub_type.add("domestic");


        List<String> status = new ArrayList<String>();
        status.add("active");
        status.add("inactive");



        ArrayAdapter<String> dataAdapterSources = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, type);
        dataAdapterSources.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner_type.setAdapter(dataAdapterSources);

        ArrayAdapter<String> dataAdapterStatus = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, customer_sub_type);
        dataAdapterStatus.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner_customer_sub_type.setAdapter(dataAdapterStatus);

        ArrayAdapter<String> dataAdapterTypes = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, status);
        dataAdapterTypes.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner_status.setAdapter(dataAdapterTypes);
    }

    private String generateParameters() {
        StringBuilder paramString = new StringBuilder();
        paramString.append("&customer_id=");
        paramString.append( editText_customer_accounting_id.getText().toString());

        /** Spinner
         *
         */
        paramString.append("customer_type=");
        paramString.append(spinner_type.getItemAtPosition(spinner_type.getSelectedItemPosition()).toString());

        paramString.append("&customer_sub_type=");
        paramString.append(spinner_customer_sub_type.getItemAtPosition(spinner_customer_sub_type.getSelectedItemPosition()).toString());

        paramString.append("&status=");
        paramString.append(spinner_status.getItemAtPosition(spinner_status.getSelectedItemPosition()).toString());


        paramString.append("&num_locations=");
        paramString.append( editText_no_of_locations.getText().toString());

        paramString.append("&company_name=");
        paramString.append( editText_company_name.getText().toString());

        paramString.append("&contact_name=");
        paramString.append( editText_contact_name.getText().toString());

        paramString.append("&title=");
        paramString.append( editText_title.getText().toString());

        paramString.append("&role=");
        paramString.append( editText_role.getText().toString());

        paramString.append("&phone_number=");
        paramString.append( editText_phone_number.getText().toString());

        paramString.append("&mobile_number=");
        paramString.append( editText_mobile_number.getText().toString());

        paramString.append("&email_address=");
        paramString.append( editText_email_address.getText().toString());

        paramString.append("&address_street=");
        paramString.append( editText_street_address.toString());

        paramString.append("&address_postcode=");
        paramString.append( editText_postcode.getText().toString());

        paramString.append("&address_county=");
        paramString.append( editText_county.getText().toString());

        paramString.append("&address_city=");
        paramString.append( editText_City.getText().toString());

        paramString.append("&annual_revenue=");
        paramString.append( editText_annual_revenue.getText().toString());

        return paramString.toString();
    }


}


