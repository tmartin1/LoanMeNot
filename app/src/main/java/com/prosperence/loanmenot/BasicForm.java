package com.prosperence.loanmenot;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Layout;
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
        int[] inputs;

        // Build form based on what button debt type was clicked (determines what information is needed)
        switch(debt_type) {
            case "Direct Loan":
                inputs = new int[] {
                        // xml input view components (same order as corresponding labels)
                        R.layout.form_field_loan_amount,
                        R.layout.form_field_interest_rate,
                        R.layout.form_field_payment_frequency,
                        R.layout.form_field_payment_amount
                };
                break;

            case "Credit Card":
                inputs = new int[] {
                        R.layout.form_field_purchase_price,
                        R.layout.form_field_interest_rate,
                        R.layout.form_field_payment_amount
                };
                break;

            // Currently handles 'Lease to Own' and 'Periodic Payments'
            default:
                inputs = new int[] {
                        R.layout.form_field_purchase_price,
                        R.layout.form_field_payment_amount,
                        R.layout.form_field_payment_frequency,
                        R.layout.form_field_number_of_payments
                };
                break;
        }

        addFormFields(formPageLayout, inputs);
    }

    // Build and inflate form fields and add to layout
    private void addFormFields (LinearLayout formPageLayout, int[] inputs) {
        for (int input : inputs) {
            // Inflate form field partial and add to view.
            LinearLayout new_field = (LinearLayout) getLayoutInflater().inflate(input, null);
            formPageLayout.addView(new_field);
        }
    }

}
