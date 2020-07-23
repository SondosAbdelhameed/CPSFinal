package com.cps.views.profile;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.cps.R;
import com.cps.adapters.ChildrenAdapter;
import com.cps.adapters.EventNewsAdapter;
import com.cps.databinding.FragmentProfileBinding;
import com.cps.models.UserData;

public class ProfileFragment extends Fragment {

    private ProfileViewModel profileViewModel;
    FragmentProfileBinding binding;
    ChildrenAdapter adapter;
    RecyclerView recyclerView;
    UserData user;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        binding = DataBindingUtil.inflate(inflater,R.layout.fragment_profile, container, false);
        profileViewModel = ViewModelProviders.of(this).get(ProfileViewModel.class);
        binding.setViewModel(profileViewModel);
        binding.setLogged(new UserData(getContext()).isLoged());
        recyclerView = binding.rcvChildren;
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        recyclerView.setHasFixedSize(true);
        user = new UserData(getContext());
        binding.setUser(user);
        if (user.isLoged()){
            adapter = new ChildrenAdapter(user.getChildren(),profileViewModel);
            recyclerView.setAdapter(adapter);
        }
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        initActions();
    }

    private void initActions() {
        binding.changePasswordAction.setOnClickListener(v -> {
            EditPasswordDialog dialog = new EditPasswordDialog();
            dialog.show(getChildFragmentManager() , EditPasswordDialog.class.getSimpleName());
        });
    }

    @Override
    public void onResume() {
        super.onResume();
        user = new UserData(getContext());
        if (user.isLoged()){
            binding.setUser(user);
            binding.rvlBefore.setVisibility(View.GONE);
            binding.conlAfter.setVisibility(View.VISIBLE);
            adapter = new ChildrenAdapter(user.getChildren(),profileViewModel);
            recyclerView.setAdapter(adapter);
        }
    }
}