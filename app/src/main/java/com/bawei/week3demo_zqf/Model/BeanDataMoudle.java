package com.bawei.week3demo_zqf.Model;

import com.bawei.week3demo_zqf.JavaBeans.Bean;
import com.bawei.week3demo_zqf.View.IViewBean;
import com.bawei.week3demo_zqf.network.OkhttpUtils;
import com.bawei.week3demo_zqf.network.ResultCallback;
import com.squareup.okhttp.Request;

/**
 * Created by 张祺钒
 * on2017/10/21.
 */

public class BeanDataMoudle implements IBeanModel {


    @Override
    public void getBeanData(String path, final IViewBean iViewBean) {
        OkhttpUtils.getAsyn(path, new ResultCallback<Bean>() {
            @Override
            public void onError(Request request, Exception e) {

            }

            @Override
            public void onResponse(Bean response) {
                iViewBean.setBean(response);
                System.out.println("-------------------------"+response.data.size());
            }
        });
    }
}
