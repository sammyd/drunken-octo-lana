package com.raywenderlich.rwbutton;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.ViewGroup.LayoutParams;
import android.widget.Button;
import android.widget.LinearLayout;

import static android.view.ViewGroup.LayoutParams.WRAP_CONTENT;


public class MainActivity extends AppCompatActivity {

  private Button newButton;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);
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

  public void addButton(android.view.View view) {
    // Create a new button
    newButton = new Button(this);
    // Set some attributes
    newButton.setText("Magic Button");
    // Set the layout params
    LayoutParams layoutParams = new LayoutParams(WRAP_CONTENT, WRAP_CONTENT);
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
