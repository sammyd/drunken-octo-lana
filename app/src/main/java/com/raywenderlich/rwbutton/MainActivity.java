package com.raywenderlich.rwbutton;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Gravity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;

import static android.view.ViewGroup.LayoutParams.WRAP_CONTENT;


public class MainActivity extends AppCompatActivity {

  private Button newButton;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);

    Button removeButton = (Button)findViewById(R.id.button_remove_button);
    removeButton.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View v) {
        // Remove button
        LinearLayout buttonContainer = (LinearLayout)findViewById(R.id.button_container);
        buttonContainer.removeView(newButton);
        newButton = null;
        // Update the +/- buttons
        enableButtonAdding(true);
      }
    });
  }

  @Override
  public boolean onCreateOptionsMenu(Menu menu) {
    // Inflate the menu; this adds items to the action bar if it is present.
    getMenuInflater().inflate(R.menu.menu_main, menu);
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

  public void addButton(View view) {
    // Create a new button
    newButton = new Button(this);
    // Set some attributes
    newButton.setText("Magic Button");
    // Set the layout params
    LayoutParams layoutParams = new LayoutParams(WRAP_CONTENT, WRAP_CONTENT);
    layoutParams.gravity = Gravity.CENTER_HORIZONTAL;
    newButton.setLayoutParams(layoutParams);

    // Add the button to the view
    LinearLayout buttonContainer = (LinearLayout)findViewById(R.id.button_container);
    buttonContainer.addView(newButton);

    // Disable the buttons
    enableButtonAdding(false);
  }

  private void enableButtonAdding(boolean enabled) {
    // Find the add button
    Button addButton = (Button)findViewById(R.id.button_add_button);
    // Set whether it's enabled
    addButton.setEnabled(enabled);

    // Find the remove button
    Button removeButton = (Button)findViewById(R.id.button_remove_button);
    // Set whether it's enabled
    removeButton.setEnabled(!enabled);
  }
}
