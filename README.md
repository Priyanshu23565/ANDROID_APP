# ANDROID_APP
Multiplication Table Generator


This is a simple Android app that generates multiplication tables based on user input. The user can input a number and select the range for the table (10, 15, 20, 25, or 30). Upon clicking the "Generate" button, the app displays the multiplication table for the number up to the selected range.

Requirements:
Android Studio

Minimum SDK Version: Android 4.4 (KitKat)

How to Use:
Enter a number in the text field.

Select the desired multiplication range from the dropdown (10, 15, 20, 25, or 30).

Click the "Generate" button to display the multiplication table.

If the input is invalid or empty, the app will show an appropriate error message.

Code Overview:
MainActivity.java: The main activity class where the logic for generating the multiplication table is implemented.

Uses Spinner for range selection.

EditText for entering the number.

Button to trigger the multiplication table generation.

TextView to display the result.

Input validation with Toast messages for user feedback.
