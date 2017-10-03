package mvp.airbnb.mainscreen;

import mvp.airbnb.BasePresenter;

/**
 * Created by jp on 9/9/17.
 */

public class MainPresenter implements MainContract.Presenter {

    private MainContract.View mMainView;


    public MainPresenter(MainContract.View mMainView) {
        this.mMainView = mMainView;
        mMainView.setPresenter(this);
    }


    @Override
    public void start() {
        loadAccomodations();
    }

    private void loadAccomodations() {
        mMainView.showProgressBar();



    }


}
