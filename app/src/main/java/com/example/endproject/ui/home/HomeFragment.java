package com.example.endproject.ui.home;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.endproject.R;
import com.example.endproject.databinding.FragmentHomeBinding;
import com.example.endproject.api.Controllers.ProductController;
import com.example.endproject.api.Product.Product;

import java.util.ArrayList;
import java.util.List;

public class HomeFragment extends Fragment {

    private FragmentHomeBinding binding;
    private RecyclerView rv1;
    private RecyclerView rv2;
    private LinearLayoutManager linearLayoutManager1;
    private LinearLayoutManager linearLayoutManager2;
    private MyRvAdapter myRvAdapter1;
    private MyRvAdapter myRvAdapter2;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        binding = FragmentHomeBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        // RecyclerView 1
        rv1 = binding.horizontalRecyclerView;
        linearLayoutManager1 = new LinearLayoutManager(requireContext(), LinearLayoutManager.HORIZONTAL, false);
        int imageIds[] = {R.drawable.cream, R.drawable.lipstick, R.drawable.facewash, R.drawable.serum, R.drawable.toner};
        myRvAdapter1 = new MyRvAdapter(new ArrayList<>(), imageIds);
        rv1.setLayoutManager(linearLayoutManager1);
        rv1.setAdapter(myRvAdapter1);

        // RecyclerView 2
        rv2 = binding.horizontalRecyclerView2;
        linearLayoutManager2 = new LinearLayoutManager(requireContext(), LinearLayoutManager.HORIZONTAL, false);
        myRvAdapter2 = new MyRvAdapter(new ArrayList<>(), imageIds);
        rv2.setLayoutManager(linearLayoutManager2);
        rv2.setAdapter(myRvAdapter2);

        // Call API to fetch products
        fetchProducts();

        return root;
    }

    private void fetchProducts() {
        ProductController productController = new ProductController();
        productController.callApiGetProducts(new ProductController.ProductsCallBack() {
            @Override
            public void onGetProductSuccess(List<Product> listProducts) {
                // Update RecyclerView adapters with the retrieved product data
                ArrayList<String> productTitles = new ArrayList<>();
                for (Product product : listProducts) {
                    if (product.getName() != null) {
                        productTitles.add(product.getName());
                        // Log the title in Logcat
                        Log.d("Product Title", product.getName());
                    } else {
                        // Log a message indicating that the product name is null
                        Log.d("Product Title", "Product name is null for product with ID: " + product.getId());
                    }
                }
                myRvAdapter1.setData(productTitles);
                myRvAdapter2.setData(productTitles);
                myRvAdapter1.notifyDataSetChanged();
                myRvAdapter2.notifyDataSetChanged();
            }

            @Override
            public void onGetProductFailed() {
                // Handle failure to fetch products
                // For example, display a toast message
                Toast.makeText(requireContext(), "Failed to fetch products", Toast.LENGTH_SHORT).show();
            }
        });
    }

    class MyRvAdapter extends RecyclerView.Adapter<MyRvAdapter.MyHolder> {

        private ArrayList<String> data;
        private int[] imageIds;

        public MyRvAdapter(ArrayList<String> data, int[] imageIds) {
            this.data = data;
            this.imageIds = imageIds;
        }

        public void setData(ArrayList<String> data) {
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
            holder.lvImage.setImageResource(imageIds[position % imageIds.length]);
        }

        @Override
        public int getItemCount() {
            return data.size();
        }

        class MyHolder extends RecyclerView.ViewHolder {
            TextView tvTitle;
            ImageView lvImage;

            public MyHolder(@NonNull View itemView) {
                super(itemView);
                tvTitle = itemView.findViewById(R.id.tvTitle);
                lvImage = itemView.findViewById(R.id.lvImage);
            }
        }
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }

}
