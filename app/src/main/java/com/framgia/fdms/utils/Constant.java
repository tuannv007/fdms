package com.framgia.fdms.utils;

/**
 * Created by Age on 4/3/2017.
 */
public class Constant {
    // TODO: 4/3/2017 develop later
    public static final String END_POINT_URL = "http://stg-dms.framgia.vn";
    public static final int OUT_OF_INDEX = -1;
    public static final int PER_PAGE = 20;
    public static final int FIRST_PAGE = 1;
    public static final int PICK_IMAGE_REQUEST = 2;
    public static final int DEVICE_DASHBOARD = 3;
    public static final String FLAG_DASHBOARD = "flag_dashboard";

    private Constant() {
        // No-op
    }

    public class ApiParram {
        public static final String CATEGORY_ID = "category_id";
        public static final String STATUS_ID = "status_id";
        public static final String PAGE = "page";
        public static final String PER_PAGE = "per_page";
        public static final String PRODUCTION_NAME = "production_name";
        public static final String DEVICE_STATUS_ID = "device_status_id";
        public static final String DEVICE_CATEGORY_ID = "device_category_id";
        public static final String SERIAL_NUMBER = "serial_number";
        public static final String MODEL_NUMBER = "model_number";
        public static final String DEVICE_CODE = "device_code";
        public static final String PICTURE = "picture";
    }
}
