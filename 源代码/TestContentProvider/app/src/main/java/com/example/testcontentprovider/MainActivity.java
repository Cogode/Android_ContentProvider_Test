package com.example.testcontentprovider;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentResolver;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
    }

    private void init() {
        ContentResolver resolver = this.getContentResolver();
        Button queryWordButton = findViewById(R.id.query_word_btn);
        queryWordButton.setOnClickListener(view -> {
            Uri uri = Uri.parse("content://com.example.vocabulary.provider/Word");
            Cursor cursor = resolver.query(uri, null, null, null, null);
            String toShow = "单词表：\n";
            if(cursor != null) {
                while(cursor.moveToNext()) {
                    int nameIndex = cursor.getColumnIndex("name");
                    int meaningIndex = cursor.getColumnIndex("meaning");
                    int sentenceIndex = cursor.getColumnIndex("sentence");
                    String name = cursor.getString(nameIndex);
                    String meaning = cursor.getString(meaningIndex);
                    String sentence = cursor.getString(sentenceIndex);
                    toShow = toShow + "\n名称：" + name + "\n释义：" + meaning + "\n例句：" + sentence + "\n";
                }
                Toast.makeText(MainActivity.this, toShow, Toast.LENGTH_SHORT).show();
            }
            else
                Toast.makeText(MainActivity.this, "暂无数据", Toast.LENGTH_SHORT).show();
        });
        Button queryRawButton = findViewById(R.id.query_raw_btn);
        queryRawButton.setOnClickListener(view -> {
            Uri uri = Uri.parse("content://com.example.vocabulary.provider/RawWord");
            Cursor cursor = resolver.query(uri, null, null, null, null);
            String toShow = "生词表：\n";
            if(cursor != null) {
                while(cursor.moveToNext()) {
                    int nameIndex = cursor.getColumnIndex("name");
                    int meaningIndex = cursor.getColumnIndex("meaning");
                    int sentenceIndex = cursor.getColumnIndex("sentence");
                    String name = cursor.getString(nameIndex);
                    String meaning = cursor.getString(meaningIndex);
                    String sentence = cursor.getString(sentenceIndex);
                    toShow = toShow + "\n名称：" + name + "\n释义：" + meaning + "\n例句：" + sentence + "\n";
                }
                Toast.makeText(MainActivity.this, toShow, Toast.LENGTH_SHORT).show();
            }
            else
                Toast.makeText(MainActivity.this, "暂无数据", Toast.LENGTH_SHORT).show();
        });
    }
}