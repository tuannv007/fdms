package com.framgia.fdms.utils;

import com.framgia.fdms.data.model.Respone;
import rx.Observable;

/**
 * Created by MyPC on 05/05/2017.
 */

public class Utils {
    public static <T> Observable<T> getResponse(Respone<T> listRespone) {
        if (listRespone == null) {
            return Observable.error(new NullPointerException());
        } else if (listRespone.isError()) {
            return Observable.error(new NullPointerException("ERROR" + listRespone.getStatus()));
        } else {
            return Observable.just(listRespone.getData());
        }
    }
}
