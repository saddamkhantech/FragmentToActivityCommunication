package com.example.fragmenttoactivitycommunication;

import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;


/**
 * A simple {@link Fragment} subclass.
 */
public class PersonDetailFragment extends Fragment {
    private TextView name,lastname,email;
    private Button send;

    private MainActivity mainActivity;



    public PersonDetailFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view=inflater.inflate(R.layout.fragment_person_detail, container, false);
        name=view.findViewById(R.id.nameid);
        lastname=view.findViewById(R.id.lastnameid);
        email=view.findViewById(R.id.emailid);
        send=view.findViewById(R.id.button);
        send.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                show();
            }
        });
        return view;

    }


    public interface FragmentInterface
    {
        void sendData(Person person);

    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        if(context instanceof MainActivity)
        {
            mainActivity=(MainActivity)context;
        }
    }
    public void show()
    {   Person person=new Person();
    person.setName(name.getText().toString());
    person.setLastname(lastname.getText().toString());
    person.setEmail(email.getText().toString());

        mainActivity.sendData(person);
    }

}
