package com.bawei.week3demo_zqf;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Toast;

import com.bawei.week3demo_zqf.Adapter.MyRecycleViewAdapter;
import com.bawei.week3demo_zqf.JavaBeans.Bean;
import com.bawei.week3demo_zqf.Presenter.RecyclerPresenter;
import com.bawei.week3demo_zqf.Utils.EndlessRecyclerOnScrollListener;
import com.bawei.week3demo_zqf.View.IViewBean;

public class RecyclerActivity extends Activity implements IViewBean {

    private RecyclerView mRecycler;
    private SwipeRefreshLayout mSwipe;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycler);
        initView();
        RecyclerPresenter presenter = new RecyclerPresenter(this);
        presenter.getDataBean(Const.path);
    }


    @Override
    public void setBean(final Bean bean) {
        final MyRecycleViewAdapter adapter = new MyRecycleViewAdapter(bean, this);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        mRecycler.setLayoutManager(linearLayoutManager);
        mRecycler.setAdapter(adapter);
        mRecycler.addOnScrollListener(new EndlessRecyclerOnScrollListener(linearLayoutManager) {
            @Override
            public void onLoadMore(int currentPage) {
                for (int i = 0; i < 3; i++) {
                    bean.data.add(bean.data.get(i));
                }
                adapter.notifyDataSetChanged();
            }
        });
        mSwipe.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            public void onRefresh() {
                //我在List最前面加入一条数据
                bean.data.add(0,bean.data.get(2));
                //数据重新加载完成后，提示数据发生改变，并且设置现在不在刷新
                adapter.notifyDataSetChanged();
                mSwipe.setRefreshing(false);
                Toast.makeText(RecyclerActivity.this,"刷新",Toast.LENGTH_SHORT).show();
            }
        });
        adapter.setmMyItemclickListener(new MyRecycleViewAdapter.MyItemclickListener() {
            @Override
            public void itemclick(View view, int position) {
                Intent intent = new Intent(RecyclerActivity.this, ThingsActivity.class);
                intent.putExtra("name",bean.data.get(position).detailUrl);
                startActivity(intent);
            }
        });
    }

    private void initView() {
        mRecycler = (RecyclerView) findViewById(R.id.recycler);
        mSwipe = (SwipeRefreshLayout) findViewById(R.id.swipe);
    }
}
