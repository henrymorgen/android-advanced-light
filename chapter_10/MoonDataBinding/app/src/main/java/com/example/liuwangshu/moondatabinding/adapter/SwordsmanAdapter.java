package com.example.liuwangshu.moondatabinding.adapter;
import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import com.example.liuwangshu.moondatabinding.R;
import com.example.liuwangshu.moondatabinding.databinding.ItemSwordsmanBinding;
import com.example.liuwangshu.moondatabinding.model.Swordsman;
import java.util.List;

public class SwordsmanAdapter extends RecyclerView.Adapter<SwordsmanAdapter.SwordsmanViewHolder> {
    private List<Swordsman> mList;
    public SwordsmanAdapter(List<Swordsman> mList) {
        this.mList = mList;
    }
    @Override
    public SwordsmanViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        ItemSwordsmanBinding binding = DataBindingUtil.inflate(LayoutInflater.from(parent.getContext()), R.layout.item_swordsman, parent, false);
        return new SwordsmanViewHolder(binding);
    }
    @Override
    public void onBindViewHolder(SwordsmanViewHolder holder, int position) {
        Swordsman swordsman = mList.get(position);
        holder.getBinding().setSwordsman(swordsman);
    }
    @Override
    public int getItemCount() {
        return mList.size();
    }
    public class SwordsmanViewHolder extends RecyclerView.ViewHolder {
        ItemSwordsmanBinding binding;

        public SwordsmanViewHolder(ViewDataBinding binding) {
            super(binding.getRoot());
            this.binding = (ItemSwordsmanBinding) binding;
        }
        public ItemSwordsmanBinding getBinding() {
            return binding;
        }
    }
}
