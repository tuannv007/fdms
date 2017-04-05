package com.framgia.fdms.data.source;

import com.framgia.fdms.data.DeviceDataSource;
import com.framgia.fdms.data.model.Device;
import com.framgia.fdms.data.source.api.service.FDMSApi;
import java.util.ArrayList;
import java.util.List;
import rx.Observable;

public class DeviceRemoteDataSource implements DeviceDataSource.RemoteDataSource {

    private FDMSApi mFDMSApi;

    public DeviceRemoteDataSource(FDMSApi FDMSApi) {
        mFDMSApi = FDMSApi;
    }

    @Override
    public Observable<List<Device>> getListDevice() {
        //TODO replace call API later
        List<Device> devices = new ArrayList<>();
        devices.add(new Device("Sam Sung Galaxy s1", "1/2/2017", "SamSung", "https://cdn.tgdd.vn/Products/Images/42/74113/samsung-galaxy-s7-2-400x460.png", "Description 1"));
        devices.add(new Device("Sam Sung Galaxy s2", "1/3/2017", "SamSung", "http://didongthongminh.vn/images/products/2016/06/14/original/samsung-galaxy-s7-gold_1465900740.jpg"));
        devices.add(new Device("Sam Sung Galaxy s3", "1/4/2017", "SamSung", "https://cdn3.tgdd.vn/Products/Images/42/74113/samsung-galaxy-s7-16-300x300.jpg", "Description 3"));
        devices.add(new Device("Sam Sung Galaxy s4", "1/5/2017", "SamSung", "http://www.samsung.com/hk_en/consumer/mobile/smartphones/galaxy-s/galaxy-s7/images/galaxy-s7-edge_gallery_front_silver_s3.png"));
        devices.add(new Device("Sam Sung Galaxy s5", "1/6/2017", "SamSung", "http://www.chipworks.com/sites/default/files/06-Samsung-Galaxy-S7-Teardown-External.jpg"));
        devices.add(new Device("Sam Sung Galaxy s6", "1/7/2017", "SamSung", "http://www.samsung.com/hk_en/consumer/mobile/smartphones/galaxy-s/galaxy-s7/images/galaxy-s7-edge_gallery_front_silver_s3.png", "Description 6"));
        devices.add(new Device("Sam Sung Galaxy s7", "2/2/2017", "SamSung", "https://cdn4.tgdd.vn/Products/Images/42/90709/samsung-galaxy-s7-edge-black-pearl-den-ngoc-trai-6.jpg", "Description 7"));
        devices.add(new Device("Sam Sung Galaxy s1", "3/2/2017", "SamSung", "http://zaibis.com/wp-content/uploads/2016/11/features_samsung-galaxy-s7-edge_performance_pink.jpg"));
        devices.add(new Device("Sam Sung Galaxy s2", "4/2/2017", "SamSung", "http://www.samsung.com/hk_en/consumer/mobile/smartphones/galaxy-s/galaxy-s7/images/galaxy-s7-edge_gallery_front_silver_s3.png", "Description 8"));
        devices.add(new Device("Sam Sung Galaxy s3", "5/2/2017", "SamSung", "https://cdn4.tgdd.vn/Products/Images/42/90709/samsung-galaxy-s7-edge-black-pearl-den-ngoc-trai-6.jpg", "Description 9"));
        devices.add(new Device("Sam Sung Galaxy s4", "6/2/2017", "SamSung", "http://static.nghenhinvietnam.vn/w670/uploaded/vanphong/2016_12_14/s7edge/dsc_6535_pbic.jpg", "Description 10"));
        devices.add(new Device("Sam Sung Galaxy s5", "7/2/2017", "SamSung", "http://cdn03.androidauthority.net/wp-content/uploads/2016/02/samsung-galaxy-s7-first-look-aa-840x560.jpg", "Description 11"));
        devices.add(new Device("Sam Sung Galaxy s6", "8/2/2017", "SamSung", "http://zaibis.com/wp-content/uploads/2016/11/features_samsung-galaxy-s7-edge_performance_pink.jpg", "Description 12"));
        devices.add(new Device("Sam Sung Galaxy s7", "9/2/2017", "SamSung", "http://www.chipworks.com/sites/default/files/06-Samsung-Galaxy-S7-Teardown-External.jpg", "Description 13"));
        devices.add(new Device("Sam Sung Galaxy s1", "10/2/2017", "SamSung", "https://cdn4.tgdd.vn/Products/Images/42/90709/samsung-galaxy-s7-edge-black-pearl-den-ngoc-trai-6.jpg", "Description 14"));
        devices.add(new Device("Sam Sung Galaxy s2", "11/2/2017", "SamSung", "http://www.samsung.com/hk_en/consumer/mobile/smartphones/galaxy-s/galaxy-s7/images/galaxy-s7-edge_gallery_front_silver_s3.png", "Description 15"));
        devices.add(new Device("Sam Sung Galaxy s3", "12/2/2017", "SamSung", "https://cdn4.tgdd.vn/Products/Images/42/90709/samsung-galaxy-s7-edge-black-pearl-den-ngoc-trai-6.jpg", "Description 16"));
        devices.add(new Device("Sam Sung Galaxy s4", "1/8/2017", "SamSung", "http://zaibis.com/wp-content/uploads/2016/11/features_samsung-galaxy-s7-edge_performance_pink.jpg", "Description 17"));
        devices.add(new Device("Sam Sung Galaxy s5", "1/9/2017", "SamSung", "http://www.samsung.com/hk_en/consumer/mobile/smartphones/galaxy-s/galaxy-s7/images/galaxy-s7-edge_gallery_front_silver_s3.png", "Description 18"));
        devices.add(new Device("Sam Sung Galaxy s6", "1/10/2017", "SamSung", "http://cdn03.androidauthority.net/wp-content/uploads/2016/02/samsung-galaxy-s7-first-look-aa-840x560.jpg"));
        devices.add(new Device("Sam Sung Galaxy s7", "1/11/2017", "SamSung", "http://www.chipworks.com/sites/default/files/06-Samsung-Galaxy-S7-Teardown-External.jpg", "Description 20"));
        devices.add(new Device("Sam Sung Galaxy s1", "1/12/2017", "SamSung", "http://cdn03.androidauthority.net/wp-content/uploads/2016/02/samsung-galaxy-s7-first-look-aa-840x560.jpg", "Description 21"));
        return Observable.just(devices);
    }
}
