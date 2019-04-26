package com.sql.roomDatabaseTask;


import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;


/**
 * A simple {@link Fragment} subclass.
 */
public class ReadUserFragment extends Fragment {
    private View view;
    private TextView textViewUserData;


    public ReadUserFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater  inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_read_user, container, false);
        /*initialize the id*/
        inItId();
        /*get the data from the database*/
        List<User> users = MainActivity.myAppDatabase.myDao().getUser();
        String userInfo;
        for (User user : users) {
            int id = user.getId();
            String name = user.getName();
            String email = user.getEmail();
            userInfo = "\n\n" + "id:" + id + "\n" + "name:" + name + "\n" + "email:" + email;
            textViewUserData.append(userInfo);
        }

        return view;
    }

    private void inItId() {
        textViewUserData = view.findViewById(R.id.user_data_view);
    }

}
