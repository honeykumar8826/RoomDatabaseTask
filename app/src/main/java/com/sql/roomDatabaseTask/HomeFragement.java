package com.sql.roomDatabaseTask;


import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;


/**
 * A simple {@link Fragment} subclass.
 */
public class HomeFragement extends Fragment implements View.OnClickListener {
    private View view;
    private Button addUser, viewUser, deleteUser, updateUser;

    public HomeFragement() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        view = inflater.inflate(R.layout.fragment_home_fragement, container, false);
        /*initialize the id*/
        inItId();
        addUser.setOnClickListener(this);
        viewUser.setOnClickListener(this);
        deleteUser.setOnClickListener(this);
        updateUser.setOnClickListener(this);
        return view;
    }

    private void inItId() {
        addUser = view.findViewById(R.id.button_add);
        viewUser = view.findViewById(R.id.button_view);
        deleteUser = view.findViewById(R.id.button_delete);
        updateUser = view.findViewById(R.id.button_update);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.button_add:
                MainActivity.fragmentManager.beginTransaction().replace(R.id.frame_layout, new AddUserFragment()).addToBackStack(null).commit();
                break;
            case R.id.button_view:
                MainActivity.fragmentManager.beginTransaction().replace(R.id.frame_layout, new ReadUserFragment()).addToBackStack(null).commit();
                break;
            case R.id.button_delete:
                MainActivity.fragmentManager.beginTransaction().replace(R.id.frame_layout, new DeleteUserFragment()).addToBackStack(null).commit();
                break;
            case R.id.button_update:
                MainActivity.fragmentManager.beginTransaction().replace(R.id.frame_layout, new UpdateUserDetailFragment()).addToBackStack(null).commit();
                break;
            default:
                break;

        }
    }
}
