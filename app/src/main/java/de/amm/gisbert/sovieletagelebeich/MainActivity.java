package de.amm.gisbert.sovieletagelebeich;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Toast;

import java.util.Calendar;
import java.util.Date;

import static android.widget.Toast.makeText;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final DatePicker input = (DatePicker) findViewById(R.id.input);
        Button howmanydays = (Button) findViewById(R.id.howmanydays);

        howmanydays.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Calendar birthday = Calendar.getInstance();
                birthday.set(input.getYear(), input.getMonth(), input.getDayOfMonth());
                Calendar today = Calendar.getInstance();
                today.setTime(new Date());
                long diff = today.getTimeInMillis() - birthday.getTimeInMillis();

                float dayCount = (float) diff / (24 * 60 * 60 * 1000);

                Toast.makeText(MainActivity.this,
                        "Wow! Sie leben heute " + (int) dayCount + " Tage.", Toast.LENGTH_LONG).show();
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        // getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
