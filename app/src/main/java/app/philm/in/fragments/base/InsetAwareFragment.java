package app.philm.in.fragments.base;

import android.graphics.Rect;
import android.support.v4.app.Fragment;

import app.philm.in.PhilmActivity;

public class InsetAwareFragment extends Fragment
        implements PhilmActivity.OnActivityInsetsCallback {

    @Override
    public void onResume() {
        super.onResume();
        if (getActivity() instanceof PhilmActivity) {
            ((PhilmActivity) getActivity()).addInsetChangedCallback(this);
        }
    }

    @Override
    public void onPause() {
        if (getActivity() instanceof PhilmActivity) {
            PhilmActivity activity = ((PhilmActivity) getActivity());
            activity.resetAlpha();
            activity.removeInsetChangedCallback(this);
        }
        super.onPause();
    }

    @Override
    public void onInsetsChanged(Rect insets) {
    }

    public void setTopInsetAlpha(float alpha) {
        if (getActivity() instanceof PhilmActivity) {
            ((PhilmActivity) getActivity()).setInsetTopAlpha(alpha);
        }
    }

    public void setBottomInsetAlpha(float alpha) {
        if (getActivity() instanceof PhilmActivity) {
            ((PhilmActivity) getActivity()).setInsetBottomAlpha(alpha);
        }
    }
}