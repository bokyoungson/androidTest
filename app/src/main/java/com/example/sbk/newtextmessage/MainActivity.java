package com.example.sbk.newtextmessage;

import android.content.Context;
import android.media.Image;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    Context mContext = null;
    Button mSendButton = null;
    ImageButton mAttachFileButton = null;
    ImageButton mEmoticonButton = null;
    ImageButton mPhoneBookButton = null;
    ImageButton mBackButton = null;
    View.OnClickListener mButtonClickListener = null;
    View mWritePage = null;
    View mCheckPage = null;
    EditText mEditText = null;
    TextView mText = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mContext = this.getApplicationContext();
        mSendButton = (Button)findViewById(R.id.sendButton);
        mAttachFileButton = (ImageButton)findViewById(R.id.clipButton);
        mEmoticonButton = (ImageButton)findViewById(R.id.imoticonButton);
        mPhoneBookButton = (ImageButton)findViewById(R.id.numberButton);
        mWritePage = findViewById(R.id.write_message);
        mCheckPage = findViewById(R.id.check_message);
        mText = (TextView)findViewById(R.id.view_content);
        mEditText = (EditText)findViewById(R.id.content);
        mBackButton = (ImageButton)findViewById(R.id.backButton);

        mButtonClickListener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String str = "";

                switch (v.getId()) {
                    case R.id.sendButton:
                        str += "send button is called!";
                        String content = mEditText.getText().toString();
                        mText.setText(content);
                        mWritePage.setVisibility(View.INVISIBLE);
                        mCheckPage.setVisibility(View.VISIBLE);
                        break;
                    case R.id.clipButton:
                        str += "attach file button is called!";
                        break;

                    case R.id.imoticonButton:
                        str += "  emoticon button is called!";
                        break;

                    case R.id.numberButton:
                        str += "contacts button is called!";
                        break;
                    case R.id.backButton:
                        mWritePage.setVisibility(View.VISIBLE);
                        mCheckPage.setVisibility(View.INVISIBLE);
                        str += "back button is caleed!";
                        break;
                    default:
                        break;
                }
                showToast(str);
            }
        };
        // set buttons click listener
        mSendButton.setOnClickListener(mButtonClickListener);
        mAttachFileButton.setOnClickListener(mButtonClickListener);
        mEmoticonButton.setOnClickListener(mButtonClickListener);
        mPhoneBookButton.setOnClickListener(mButtonClickListener);
        mBackButton.setOnClickListener(mButtonClickListener);


    }

    private void showToast(String str) {
        Toast.makeText(mContext, str + "", Toast.LENGTH_SHORT).show();
    }
}
