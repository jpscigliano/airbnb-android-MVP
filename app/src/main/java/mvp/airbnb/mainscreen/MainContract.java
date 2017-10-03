package mvp.airbnb.mainscreen;

import java.util.ArrayList;

import mvp.airbnb.BasePresenter;
import mvp.airbnb.BaseView;
import mvp.airbnb.data.Accommodation;

/**
 * Created by jp on 9/9/17.
 */

public interface MainContract {

    interface View extends BaseView<Presenter> {


        void showAccomodations(ArrayList<Accommodation> mAccommodations);

        void showProgressBar();

        void hiddeProfressBar();
    }

    interface Presenter extends BasePresenter {

    }

}
