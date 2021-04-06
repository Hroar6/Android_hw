package com.example.myapplication;

import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.widget.Button;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class ThemeActivity extends AppCompatActivity {
    private Button lightThemeBtn, darkThemeBtn;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_theme);
        findViews();
        lightThemeBtnClick();
        DarkThemeBtnClick();
    }

    private void findViews() {
        lightThemeBtn = findViewById(R.id.lightThemeBtn);
        darkThemeBtn = findViewById(R.id.darkThemeBtn);
    }

    private void lightThemeBtnClick() {
        lightThemeBtn.setOnClickListener(v -> {
            Intent intent = new Intent(ThemeActivity.this, MainActivity.class);
            startActivity(intent);
        });
    }

    private void DarkThemeBtnClick() {
        darkThemeBtn.setOnClickListener(v -> {
            Intent intent = new Intent(ThemeActivity.this, MainActivity.class);
            int theme = R.style.Theme_AppCompat_DayNight;
            intent.putExtra(Constants.firstActivityDataKey, theme);
            startActivity(intent);
        });
    }
}
