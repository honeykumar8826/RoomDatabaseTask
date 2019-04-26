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
public class UpdateUserDetailFragment extends Fragment {

    private View view;
    private EditText editTextId, editTextName, editTextEmail;
    private String uId, uName, uEmail;
    private Button buttonUpdate;

    public UpdateUserDetailFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_update_user_detail, container, false);
        /*initialize the id*/
        inItId();
        /*listener for update button */
        buttonUpdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                /*get the value from the user*/
                getValueFromUser();
                User user = new User();
                user.setId(Integer.parseInt(uId));
                user.setName(uName);
                user.setEmail(uEmail);
                MainActivity.myAppDatabase.myDao().updateUserInfo(user);
                Toast.makeText(getContext(), "Record updated Successfully", Toast.LENGTH_SHORT).show();

            }
        });

        return view;
    }

    private void inItId() {
        editTextId = view.findViewById(R.id.update_user_id);
        editTextName = view.findViewById(R.id.update_user_name);
        editTextEmail = view.findViewById(R.id.update_user_email);
        buttonUpdate = view.findViewById(R.id.button_updateUser);
    }

    private void getValueFromUser() {
        uId = editTextId.getText().toString();
        uEmail = editTextEmail.getText().toString();
        uName = editTextName.getText().toString();
    }

}
