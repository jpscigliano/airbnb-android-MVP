package mvp.airbnb;

/**
 * Created by jp on 9/9/17.
 */

public interface BaseView<T> {
    void setPresenter(T presenter);
}
