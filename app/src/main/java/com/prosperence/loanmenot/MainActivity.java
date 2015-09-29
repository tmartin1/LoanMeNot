package com.prosperence.loanmenot;

import android.os.Bundle;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    // Option that the user selected (Loan, Credit, Lease to own, etc.).
    public static final String EXTRA_DEBT_TYPE = "com.prosperence.loanmenot.DEBT_TYPE";

    @Override
    protected void onCreate (Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Create main layout.
        LinearLayout startPageLayout = new LinearLayout(this);
        startPageLayout.setOrientation(LinearLayout.VERTICAL);

        // Main page title.
        // TODO: Format this title.
        TextView title = new TextView(this);
        title.setText("Click To Get Started!");
        startPageLayout.addView(title);

        // Add buttons to main page.
        addButtons(startPageLayout);

        // Render main page.
        setContentView(startPageLayout);
    }

    @Override
    public boolean onCreateOptionsMenu (Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected (MenuItem item) {
        // Handle action bar item clicks here. The action bar will automatically handle clicks on
        // the Home/Up button, so long as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    private void addButtons (LinearLayout layout) {
        // Define what buttons to add to main page.
        String[] buttons = {
                "Direct Loan",
                "Credit Card",
                "Lease to Own",
                "Periodic Payments"
        };

        for (String label : buttons) {
            addButton(layout, label);
        }
    }

    private void addButton (LinearLayout layout, final String label) {
        Button button = (Button)getLayoutInflater().inflate(R.layout.main_button, null);
        button.setText(label); // Set button text

        // Define what happens when the button is clicked.
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick (View view) {
                goToFormView(view, label);
            }
        });

        // Add button to layout.
        layout.addView(button);
    }

    // Go to the form view to collect loan/payment information.
    public void goToFormView (View view, String debt_type) {
        Intent intent = new Intent(view.getContext(), BasicForm.class);
        intent.putExtra(EXTRA_DEBT_TYPE, debt_type);
        startActivity(intent);
    }

}
