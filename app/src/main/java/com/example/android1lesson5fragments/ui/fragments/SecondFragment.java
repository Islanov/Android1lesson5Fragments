package com.example.android1lesson5fragments.ui.fragments;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.android1lesson5fragments.R;
import com.example.android1lesson5fragments.models.TaskModel;
import com.example.android1lesson5fragments.databinding.FragmentSecondBinding;

public class SecondFragment extends Fragment {
    private FragmentSecondBinding binding;
    TaskModel taskModel;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        binding = FragmentSecondBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        listeners();
        getData();
    }


    private void listeners() {
        binding.btnData.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                save();
            }
        });
    }

    private void getData() {
        if (getArguments() != null) {
            TaskModel taskModel = (TaskModel) getArguments().getSerializable("key1");
            binding.etInput.setText(taskModel.getTitle());
        }
    }

    private void save() {
        String title = binding.etInput.getText().toString();
        if (title.isEmpty()) {
            binding.etInput.setError("Input text");
        } else {
            taskModel = new TaskModel(title);
            Bundle bundle = new Bundle();
            bundle.putSerializable("key", taskModel);
            FirstFragment firstFragment = new FirstFragment();
            firstFragment.setArguments(bundle);
            getParentFragmentManager().beginTransaction().replace(R.id.container_fragment, firstFragment).commit();

        }
    }
}
