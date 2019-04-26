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
public class DeleteUserFragment extends Fragment {
    private Button deleteUser;
    private EditText editTextUserId;
    private int userId;
    private View view;

    public DeleteUserFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_delete_user, container, false);
        /*initialize the id*/
        inItId();
        /*listener for button */
        deleteUser.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                /*get the user input*/
                getUserInput();
                User user = new User();
                user.setId(userId);
                MainActivity.myAppDatabase.myDao().deleteUser(user);
                Toast.makeText(getContext(), "User Account Successfully deleted", Toast.LENGTH_SHORT).show();
            }
        });
        return view;
    }

    private void getUserInput() {
        userId = Integer.parseInt(editTextUserId.getText().toString());
    }

    private void inItId() {
        deleteUser = view.findViewById(R.id.btn_delete_user);
        editTextUserId = view.findViewById(R.id.et_user_id);
    }

}
