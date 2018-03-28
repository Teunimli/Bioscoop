package com.example.rickyberg.bioscopify.PresentationLayer;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.example.rickyberg.bioscopify.R;

public class PayOrderActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.payorder_activity);

    }

    public void PaymentClick (View view){
        startActivity(new Intent(PayOrderActivity.this, ProcessingActivity.class));
    }

}
