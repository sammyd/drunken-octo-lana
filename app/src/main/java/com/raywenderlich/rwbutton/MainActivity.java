/*
 * Copyright (c) 2015 Razeware LLC
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 * THE SOFTWARE.
 */

package com.raywenderlich.rwbutton;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Gravity;
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
