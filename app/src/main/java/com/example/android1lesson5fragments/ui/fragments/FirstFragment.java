package com.example.android1lesson5fragments.ui.fragments;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.android1lesson5fragments.onClick.OnClick;
import com.example.android1lesson5fragments.R;
import com.example.android1lesson5fragments.models.TaskModel;
import com.example.android1lesson5fragments.databinding.FragmentFirstBinding;
import com.example.android1lesson5fragments.ui.adaters.AdapterText;


public class FirstFragment extends Fragment {
    private FragmentFirstBinding binding;
    AdapterText adapterText;
    TaskModel taskModel;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        binding = FragmentFirstBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        adapterText = new AdapterText();
        binding.recyclerFirstFragment.setAdapter(adapterText);
        listeners();
        getData();

    }


    private void listeners() {
        binding.btnOpen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SecondFragment secondFragment = new SecondFragment();
                FragmentTransaction fragmentTransaction = getParentFragmentManager().beginTransaction();
                fragmentTransaction.replace(R.id.container_fragment, secondFragment).commit();
            }

        });
        adapterText.setOnClick(new OnClick() {
            @Override
            public void onClickItem(TaskModel taskModel) {
                Bundle bundle = new Bundle();
                bundle.putSerializable("key1", taskModel);
                SecondFragment secondFragment = new SecondFragment();
                secondFragment.setArguments(bundle);
                getParentFragmentManager().beginTransaction().replace(R.id.container_fragment, secondFragment).commit();
            }
        });
//        binding.tvText.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Bundle bundle = new Bundle();
//                bundle.putString("key",binding.tvText.getText().toString());
//                SecondFragment secondFragment = new SecondFragment();
//                secondFragment.setArguments(bundle);
//                getParentFragmentManager().beginTransaction().replace(R.id.container_fragment,secondFragment).commit();
//                FragmentTransaction fragmentTransaction = getParentFragmentManager().beginTransaction();
//                fragmentTransaction.replace(R.id.container_fragment,secondFragment).commit();
//            }
//        });

    }

    private void getData() {
        if (getArguments() != null) {
            taskModel = (TaskModel) getArguments().getSerializable("key");
            adapterText.addData(taskModel);
//            }
        }

    }
}
