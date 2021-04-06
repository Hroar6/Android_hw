package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.Editable;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity {
    private EditText editText;
    private TextView textView;
    private Button[] numericButtons = null;
    private Button[] arithmeticButtons = null;
    private Button deleteButton, clearButton, equalsButton;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findViews();
        setNumericBtnBehavior();
        setArithmeticBtnBehavior();
        setClearButtonBehavior();
        setDeleteButtonBehavior();
        setEqualsButtonBehavior();
    }


    private void findViews() {
        editText = findViewById(R.id.editText);
        textView = findViewById(R.id.textView);
        numericButtons = new Button[]
                {
                        findViewById(R.id.button_1),
                        findViewById(R.id.button_2),
                        findViewById(R.id.button_3),
                        findViewById(R.id.button_4),
                        findViewById(R.id.button_5),
                        findViewById(R.id.button_6),
                        findViewById(R.id.button_7),
                        findViewById(R.id.button_8),
                        findViewById(R.id.button_9),
                        findViewById(R.id.button_0),
                };
        arithmeticButtons = new Button[]
                {
                        findViewById(R.id.button_multiplication),
                        findViewById(R.id.button_subtraction),
                        findViewById(R.id.button_share),
                        findViewById(R.id.button_modulo),
                        findViewById(R.id.button_addition),
                };
        deleteButton = findViewById(R.id.button_delete);
        clearButton = findViewById(R.id.button_AC);
        equalsButton = findViewById(R.id.button_equals);
    }

    private void setDeleteButtonBehavior() {
        deleteButton.setOnClickListener(v -> {
            String text = editText.getText().toString();
            if (!text.equals("")) {
                text = text.substring(0, text.length() - 1);
                editText.setText(text);
            } else {
                Toast.makeText(getApplicationContext(), "Ошибка", Toast.LENGTH_SHORT)
                        .show();
            }
        });
    }

    private void setEqualsButtonBehavior() {
        equalsButton.setOnClickListener(v -> {
//            String text = editText.getText().toString();
//            String[] sumArray = text.split("\\+");
//            for (String i : sumArray) {
//            }
            // TODO create equals from String
        });
    }

    private void setClearButtonBehavior() {
        clearButton.setOnClickListener(v -> editText.setText(""));
    }

    private void setArithmeticBtnBehavior() {
        for (Button i : arithmeticButtons) {
            i.setOnClickListener(v -> {
                String text = editText.getText().toString();
                boolean isTrue = true;
                if (text.equals("")) {
                    Toast.makeText(getApplicationContext(), "Ошибка", Toast.LENGTH_SHORT)
                            .show();
                    isTrue = false;
                } else {
                    String lastSymbol = text.substring(text.length() - 1);
                    for (Button j : arithmeticButtons) {
                        if (getTextFromButton(j).equals(lastSymbol)) {
                            Toast.makeText(getApplicationContext(), "Ошибка", Toast.LENGTH_SHORT)
                                    .show();
                            isTrue = false;
                            break;
                        }
                    }
                }
                if (isTrue) {
                    text += getTextFromButton(i);
                    editText.setText(text);
                }
            });
        }
    }

    private void setNumericBtnBehavior() {
        for (Button i : numericButtons) {
            i.setOnClickListener(v -> {
                String text = editText.getText().toString();
                text += getTextFromButton(i);
                editText.setText(text);
            });
        }
    }

    private String getTextFromButton(Button btn) {
        CharSequence btnNumber = btn.getText();
        return btnNumber.toString();
    }
}