package com.example.endproject.ui.home;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.endproject.R;
import com.example.endproject.databinding.FragmentHomeBinding;

import java.util.ArrayList;

public class HomeFragment extends Fragment {

    private FragmentHomeBinding binding;
    private RecyclerView rv1;
    private RecyclerView rv2;
    private ArrayList<String> dataSource1;
    private ArrayList<String> dataSource2;
    private LinearLayoutManager linearLayoutManager1;
    private LinearLayoutManager linearLayoutManager2;
    private MyRvAdapter myRvAdapter1;
    private MyRvAdapter myRvAdapter2;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        HomeViewModel homeViewModel = new ViewModelProvider(this).get(HomeViewModel.class);

        binding = FragmentHomeBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        // RecyclerView 1
        rv1 = binding.horizontalRecyclerView;
        dataSource1 = new ArrayList<>();
        dataSource1.add("Hello");
        dataSource1.add("Welcome");
        dataSource1.add("To");
        dataSource1.add("The");

        linearLayoutManager1 = new LinearLayoutManager(requireContext(), LinearLayoutManager.HORIZONTAL, false);
        myRvAdapter1 = new MyRvAdapter(dataSource1);
        rv1.setLayoutManager(linearLayoutManager1);
        rv1.setAdapter(myRvAdapter1);

        // RecyclerView 2
        rv2 = binding.horizontalRecyclerView2;
        dataSource2 = new ArrayList<>();
        dataSource2.add("Item 1");
        dataSource2.add("Item 2");
        dataSource2.add("Item 3");
        dataSource2.add("Item 4");

        linearLayoutManager2 = new LinearLayoutManager(requireContext(), LinearLayoutManager.HORIZONTAL, false);
        myRvAdapter2 = new MyRvAdapter(dataSource2);
        rv2.setLayoutManager(linearLayoutManager2);
        rv2.setAdapter(myRvAdapter2);

        return root;
    }

    class MyRvAdapter extends RecyclerView.Adapter<MyRvAdapter.MyHolder> {

        private ArrayList<String> data;

        public MyRvAdapter(ArrayList<String> data) {
            this.data = data;
        }

        @NonNull
        @Override
        public MyHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.rv_item, parent, false);
            return new MyHolder(view);
        }

        @Override
        public void onBindViewHolder(@NonNull MyHolder holder, int position) {
            holder.tvTitle.setText(data.get(position));
        }

        @Override
        public int getItemCount() {
            return data.size();
        }

        class MyHolder extends RecyclerView.ViewHolder {
            TextView tvTitle;

            public MyHolder(@NonNull View itemView) {
                super(itemView);
                tvTitle = itemView.findViewById(R.id.tvTitle);
            }
        }
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}