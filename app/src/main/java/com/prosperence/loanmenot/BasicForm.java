package com.prosperence.loanmenot;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Spinner;

import java.util.ArrayList;
import java.util.List;

public class BasicForm extends AppCompatActivity {

    @Override
    protected void onCreate (Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // TODO: Change the title bar text for this page from "Basic Form" to "LoanMeNot: 'loan_type'.

        Intent intent = getIntent();
        String debt_type = intent.getStringExtra(MainActivity.EXTRA_DEBT_TYPE);

        // Form page layout
        LinearLayout formPageLayout = new LinearLayout(this);
        formPageLayout.setOrientation(LinearLayout.VERTICAL);

        // Add form fields to layout
        buildFormFields(formPageLayout, debt_type);

        // TODO: Add 'SUBMIT' button

        // Render form page
        setContentView(formPageLayout);
    }

    @Override
    public boolean onOptionsItemSelected (MenuItem item) {
        // Handle action bar item clicks here. The action bar will automatically handle clicks on
        // the Home/Up button, so long as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        // noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    // Define form fields
    private void buildFormFields (LinearLayout formPageLayout, String debt_type) {
        String[] labels;
        View[] fields;

        // Build form based on what button debt type was clicked (determines what information is needed)
        switch(debt_type) {
            case "Direct Loan":
                labels = new String[] {
                        // field labels (same order as their corresponding view component)
                        "Loan Amount",
                        "Interest Rate",
                        "Payment Frequency",
                        "Payment Amount"
                };
                fields = new View[] {
                        // xml view components, e.g. loan amount, interest rate, payment frequency, payment amount.
                };
                break;

            case "Credit Card":
                labels = new String[] {
                        "Purchase Price",
                        "Interest Rate",
                        "Payment Amount"
                };
                fields = new View[] {
                        // xml view components
                };
                break;

            // Currently handles 'Lease to Own' and 'Periodic Payments'
            default:
                labels = new String[] {
                        "Price of Product",
                        "Payment Amount",
                        "Payment Frequency",
                        "Number of Payments"
                };
                fields = new View[] {
                        // xml view components
                };
                break;
        }

        addFormFields(formPageLayout, labels, fields);
    }

    // Inflate form fields and add to layout
    private void addFormFields (LinearLayout formPageLayout, String[] field_labels, View[] field_views) {
        // iterate over field_views
        // create new LinearLayout to be the field_wrapper
        // create new TextView element for the label and addView it to the field_wrapper
        // set text for label from field_labels
        // inflate the component in field_views and addView it to the field_wrapper
        // addView field_wrapper to formPageLayout
    }

    // Add items for form spinner (dropdown list).
    public void addItemsOnSpinner () {
        Spinner payment_frequencies = (Spinner) findViewById(R.id.payment_frequencies);
        List<String> list = new ArrayList<String>();
        list.add("Weekly");
        list.add("Bi-Weekly");
        list.add("Monthly");
        ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_spinner_item, list);
        dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        payment_frequencies.setAdapter(dataAdapter);
    }
}
