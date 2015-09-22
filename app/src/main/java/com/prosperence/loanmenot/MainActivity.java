package com.prosperence.loanmenot;

import android.os.Bundle;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    public static final String EXTRA_MESSAGE = "com.prosperence.loanmenot.MESSAGE";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Main layout
        LinearLayout startPageLayout = new LinearLayout(this);
        startPageLayout.setOrientation(LinearLayout.VERTICAL);

        // Main page title
        TextView title = new TextView(this);
        title.setText("Click To Get Started!");
        startPageLayout.addView(title);

        // Add buttons to main page
        String[] buttons = { "Direct Loan", "Credit Card", "Lease to Own", "Periodic Payments" };
        for (String label : buttons) {
            addButton(startPageLayout, label);
        }

        // Render main page
        setContentView(startPageLayout);
    }

    private void addButton (LinearLayout layout, String label) {
        LinearLayout buttonWrapper = new LinearLayout(this);
        LayoutParams lp = new LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.WRAP_CONTENT);
        buttonWrapper.setLayoutParams(lp);
        buttonWrapper.setOrientation(LinearLayout.HORIZONTAL);

        Button button = (Button)getLayoutInflater().inflate(R.layout.main_button, null);
        button.setText(label);
        buttonWrapper.addView(button);
        layout.addView(buttonWrapper);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will automatically handle clicks on
        // the Home/Up button, so long as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

//    // Show direct loan inputs.
//    public void directLoan(View view) {
//        goToFormView("directLoan");
//        Intent intent = new Intent(this, BasicForm.class);
//        startActivity(intent);
//    }

//    // Show credit card inputs.
//    public void creditCard() {
//        goToFormView("creditCard");
//    }

//    // Show periodic payment inputs.
//    public void periodicPayments() {
//         goToFormView("periodicPayments");
//    }

//     // Show lease-to-own inputs.
//    public void leaseToOwn() {
//         goToFormView("leaseToOwn");
//    }

    // Go to the form view to collect loan/payment information.
    public void goToFormView(View view) {
        Intent intent = new Intent(this, BasicForm.class);
        startActivity(intent);
    }

}
