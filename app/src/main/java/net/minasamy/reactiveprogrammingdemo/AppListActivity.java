package net.minasamy.reactiveprogrammingdemo;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import net.minasamy.reactiveprogrammingdemo.model.AppInfo;
import net.minasamy.reactiveprogrammingdemo.util.Utils;

import rx.Observable;
import rx.Observer;

public class AppListActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_app_list);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        //load apps list
        Observable.from(Utils.getAppsList(this))
                .subscribe(new Observer<AppInfo>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onNext(AppInfo appInfo) {
                        Log.i("App",appInfo.getLabel());
                    }
                });
    }

}