package com.example.rickyberg.bioscopify.PresentationLayer;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.rickyberg.bioscopify.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class TicketSelectActivity extends Fragment {

    private ImageView poster;
    private TextView title;
    private EditText juniorTickets;
    private EditText normalTickets;
    private EditText seniorTickets;
    private TextView totalPrice;
    private Button button;


    public TicketSelectActivity() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        return inflater.inflate(R.layout.fragment_ticket_select, container, false);


    }

}
