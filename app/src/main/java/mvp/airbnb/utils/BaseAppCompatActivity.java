package mvp.airbnb.utils;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;

/**
 * Created by jp on 9/9/17.
 */

public class BaseAppCompatActivity extends AppCompatActivity {


    public void start(Fragment fragment, boolean addToBackStack, Integer frameId, String fragmentTag) {
        FragmentTransaction tx = getSupportFragmentManager().beginTransaction().replace(frameId, fragment, fragmentTag);
        if (addToBackStack) {
            tx.addToBackStack(fragment.getClass().getSimpleName());
        }
        tx.commit();
    }

    public void startWithAnimation(Fragment fragment, int in, int out, boolean addToBackStack, Integer frameId, String fragmentTag) {
        FragmentTransaction tx = getSupportFragmentManager().beginTransaction();
        tx.setCustomAnimations(in, out);
        tx.replace(frameId, fragment, fragmentTag);
        if (addToBackStack) {
            tx.addToBackStack(fragment.getClass().getSimpleName());
        }
        tx.commit();
    }
}
