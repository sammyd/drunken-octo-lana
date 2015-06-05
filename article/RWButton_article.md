# Button

Buttons are the simplest UI widget that allows user interaction. Taps of the
button can be used to trigger actions in your app.

## Button Types

Within Android, there are four main button "types".

### Text

The standard button contains just text:

![Text Button](img/text_button.png)

It has the class `Button`, and creating it in layout XML is as follows:

```xml
  <Button
    android:layout_width="wrap_content"
    android:layout_height="wrap_content"
    android:text="Vanilla Button"
    ... />
```

The text for the button is set using the `android:text` attribute.

`Button` is a subclass of `TextView` and hence `View`, so the standard
attributes apply.

### Image

The `ImageButton` class allows you to make a button containing an image instead
of text:

![Image Button](img/image_button.png)

`ImageButton` is a subclass of `ImageView`, so providing the image is done via
the `android:src` attribute. This should be some form of a `@drawable`:

```xml
<ImageButton
  android:layout_width="wrap_content"
  android:layout_height="wrap_content"
  android:src="@mipmap/raywenderlich"
  ... />
```


### Image & Text

You've seen text buttons, and image buttons - but what you really want is both:

![Image and Text](image/text_image_button.png)

Luckily, this is made possible through the "drawable" functionality of the
`TextView` superclass of `Button`:

```xml
<Button
  android:layout_width="wrap_content"
  android:layout_height="wrap_content"
  android:text="Text and Image"
  android:drawableStart="@mipmap/raywenderlich"
  android:drawableLeft="@mipmap/raywenderlich"
  android:drawablePadding="10dp"
  ... />
```

The text for the button is once again provided by the `android:text`
attribute. The image is a `@drawable` set on the `android:drawableStart`
attribute.

> __NOTE:__ The `android:drawableLeft` is also used as a fallback for pre-API
> level 14. `android:drawableStart` will respect the writing direction, unlike
> `android:drawableLeft`.

The spacing between the image and the text is controlled by the
`android:drawablePadding` attribute.


### Floating Action Button (FAB)

Material Design introduces a new type of button, known as the Floating Action
Button (FAB):

![Floating Action Button](img/floating_action_button.png)

It is possible to create a FAB using the Design Support Library. This was
introduced in v22.2.0, so ensure that you've got that version installed using
the SDK manager.

Then make sure you add the design support library as a build dependency in
__build.gradle__:

```gradle
dependencies {
  compile "com.android.support:design:22.2.0"
  ...
}
```

You can then use the `FloatingActionButton` class:

```xml
<android.support.design.widget.FloatingActionButton
  <!-- Workaround -->
  xmlns:app="http://schemas.android.com/apk/res-auto"
  app:borderWidth="0dp"
  <!-- End workaround -->
  android:layout_width="wrap_content"
  android:layout_height="wrap_content"
  android:layout_marginBottom="16dp"
  android:layout_marginTop="16dp"
  android:layout_gravity="center_horizontal"
  android.support.design:fabSize="normal"
  android:src="@drawable/plus"
  />
```

`FloatingActionButton` is a subclass of `ImageView`, so you need to provide the
icon as a `@drawable` to the `android:src` attribute.

The `android.support.design:fabSize` attribute can be `normal` or `mini`.

## Creating Button from Code


## Button Styling


## Handling Button Taps


## Useful Properties

