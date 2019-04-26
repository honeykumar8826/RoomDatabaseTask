package com.sql.roomDatabaseTask;


import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


/**
 * A simple {@link Fragment} subclass.
 */
public class AddUserFragment extends Fragment {
    private View view;
    private EditText editTextId, editTextName, editTextEmail;
    private String uId, uName, uEmail;
    private Button buttonAdd;

    public AddUserFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_add_user, container, false);
        /*initialize the id*/
        inItId();
        buttonAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                /*get the value from the user*/
                getValueFromUser();
                User user = new User();
                user.setId(Integer.parseInt(uId));
                user.setName(uName);
                user.setEmail(uEmail);
                MainActivity.myAppDatabase.myDao().addUser(user);
                Toast.makeText(getContext(), "Record inserted", Toast.LENGTH_SHORT).show();
            }
        });


        return view;
    }

    private void getValueFromUser() {
        uId = editTextId.getText().toString();
        uEmail = editTextEmail.getText().toString();
        uName = editTextName.getText().toString();
    }

    private void inItId() {
        editTextId = view.findViewById(R.id.user_id);
        editTextName = view.findViewById(R.id.user_name);
        editTextEmail = view.findViewById(R.id.user_email);
        buttonAdd = view.findViewById(R.id.button_addUser);
    }

}
