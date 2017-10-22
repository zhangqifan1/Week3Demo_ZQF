package com.bawei.week3demo_zqf.Presenter;

import com.bawei.week3demo_zqf.Model.BeanDataMoudle;
import com.bawei.week3demo_zqf.Model.IBeanModel;
import com.bawei.week3demo_zqf.View.IViewBean;

/**
 * Created by 张祺钒
 * on2017/10/21.
 */

public class RecyclerPresenter {
    private IBeanModel iBeanModel;
    private IViewBean iViewBean;

    public RecyclerPresenter(IViewBean iViewBean) {
        this.iViewBean=iViewBean;
        iBeanModel=new BeanDataMoudle();
    }

    public void getDataBean(String path){
        iBeanModel.getBeanData(path,iViewBean);
   }
}
