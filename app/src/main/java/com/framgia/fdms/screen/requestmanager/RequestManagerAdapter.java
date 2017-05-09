package com.framgia.fdms.screen.requestmanager;

import android.content.Context;
import android.databinding.ObservableField;
import android.support.v7.widget.RecyclerView;
import android.view.ViewGroup;
import com.framgia.fdms.BaseRecyclerViewAdapter;
import com.framgia.fdms.data.model.Request;
import com.framgia.fdms.databinding.ItemRequestManagerAdapterBinding;
import java.util.List;

/**
 * Created by beepi on 09/05/2017.
 */

public class RequestManagerAdapter
        extends BaseRecyclerViewAdapter<RequestManagerAdapter.ViewHolder> {
    private List<Request> mRequests;

    public RequestManagerAdapter(Context context) {
        super(context);
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return null;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {

        holder.bind(new RequestModel(mRequests.get(position)));
    }

    @Override
    public int getItemCount() {
        return mRequests == null ? 0 : mRequests.size();
    }

    public void setRequests(List<Request> requests) {
        mRequests = requests;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private ItemRequestManagerAdapterBinding mBinding;

        public ViewHolder(ItemRequestManagerAdapterBinding binding) {
            super(binding.getRoot());
            mBinding = binding;
        }

        public void bind(RequestModel requestModel) {
            mBinding.setRequestModel(requestModel);
            mBinding.executePendingBindings();
        }
    }

    public class RequestModel {

        private Request mRequest;
        private ObservableField<Integer> mStatusRequest = new ObservableField<>();

        public RequestModel(Request request) {
            mRequest = request;
        }

        public Request getRequest() {
            return mRequest;
        }

        public void setRequest(Request request) {
            mRequest = request;
        }

        public ObservableField<Integer> getStatusRequest() {
            return mStatusRequest;
        }

        public void setStatusRequest(ObservableField<Integer> statusRequest) {
            mStatusRequest = statusRequest;
        }
    }
}
