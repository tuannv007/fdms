package com.framgia.fdms.screen.returndevice;

import android.content.Context;
import android.databinding.ObservableList;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import com.framgia.fdms.R;
import com.framgia.fdms.data.model.Status;
import com.framgia.fdms.databinding.ItemAssignerBinding;
import java.util.List;

/**
 * Created by Hoang Van Nha on 5/22/2017.
 * <></>
 */

public class AssignerAdapter extends ArrayAdapter<Status> {
    private final ReturnDeviceContract.ViewModel mViewModel;
    private Context mContext;
    private List<Status> mAssigners;
    private LayoutInflater mInflater;

    public AssignerAdapter(@NonNull Context context,
            @NonNull ReturnDeviceContract.ViewModel viewModel, @NonNull List<Status> objects) {
        super(context, R.layout.item_assigner, objects);
        mContext = context;
        mViewModel = viewModel;
        mAssigners = objects;
        mInflater = LayoutInflater.from(context);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View view, @NonNull ViewGroup parent) {
        ItemAssignerBinding binding = null;
        if (view == null) {
            binding = ItemAssignerBinding.inflate(mInflater, parent, false);
            binding.setViewModel(mViewModel);
            view = binding.getRoot();
        } else {
            binding = (ItemAssignerBinding) view.getTag();
        }
        if (mAssigners != null) {
            Status status = mAssigners.get(position);
            AssignerHolder holder = new AssignerHolder(binding);
            holder.bind(status, position);
        }
        view.setTag(binding);
        return view;
    }

    @Override
    public int getCount() {
        return mAssigners == null ? 0 : mAssigners.size();
    }

    public void update(ObservableList<Status> assigners) {
        mAssigners = assigners;
        notifyDataSetChanged();
    }

    public class AssignerHolder {

        private final ItemAssignerBinding mBinding;

        public AssignerHolder(ItemAssignerBinding binding) {
            mBinding = binding;
        }

        public void bind(Status device, int position) {
            mBinding.setAssigner(device);
            mBinding.setPosition(position);
            mBinding.executePendingBindings();
        }
    }
}
