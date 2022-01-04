package com.example.android1lesson5fragments.ui.adaters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.android1lesson5fragments.onClick.OnClick;
import com.example.android1lesson5fragments.models.TaskModel;
import com.example.android1lesson5fragments.databinding.HolderTextBinding;

import java.util.ArrayList;

public class AdapterText extends RecyclerView.Adapter<AdapterText.HolderText> {
    ArrayList<TaskModel> list = new ArrayList<>();
    private OnClick onClick;

    public AdapterText(OnClick onClick) {
        this.onClick = onClick;
    }

    public AdapterText() {

    }

    public void setOnClick(OnClick onClick) {
        this.onClick = onClick;

    }

    @NonNull
    @Override
    public AdapterText.HolderText onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new HolderText(HolderTextBinding.
                inflate(LayoutInflater.from(parent.getContext()), parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull AdapterText.HolderText holder, int position) {
        holder.onBind(list.get(position));
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public void addData(TaskModel taskModel) {
        this.list.add(taskModel);
        notifyDataSetChanged();
    }

    public class HolderText extends RecyclerView.ViewHolder {
        private HolderTextBinding binding;

        public HolderText(@NonNull HolderTextBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }

        public void onBind(TaskModel taskModel) {
            binding.tvDataHolder.setText(taskModel.getTitle());

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    onClick.onClickItem(taskModel);
                }
            });
        }
    }
}
