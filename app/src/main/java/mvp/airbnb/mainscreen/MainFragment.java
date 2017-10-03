package mvp.airbnb.mainscreen;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import mvp.airbnb.R;
import mvp.airbnb.data.Accommodation;

/**
 * Created by jp on 9/9/17.
 */

public class MainFragment extends Fragment implements MainContract.View{

    public static final String TAG = MainFragment.class.getName();


    MainContract.Presenter mPresenter;

    @BindView(R.id.recyclerView)
    RecyclerView mRecyclerView;


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_main, container, false);
        ButterKnife.bind(this, view);
        return view;
    }


    @Override
    public void onResume() {
        super.onResume();
        mPresenter.start();
    }

    public static Fragment newInstance(){
        MainFragment fragment=new MainFragment();
        return fragment;
    }



    @Override
    public void setPresenter(MainContract.Presenter presenter) {
        mPresenter=presenter;
    }

    @Override
    public void showAccomodations(ArrayList<Accommodation> mAccommodations) {

    }

    @Override
    public void showProgressBar() {

    }

    @Override
    public void hiddeProfressBar() {

    }
}
