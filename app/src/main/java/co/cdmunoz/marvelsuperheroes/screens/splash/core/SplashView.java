package co.cdmunoz.marvelsuperheroes.screens.splash.core;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import butterknife.ButterKnife;
import co.cdmunoz.marvelsuperheroes.R;
import co.cdmunoz.marvelsuperheroes.screens.splash.SplashScreenActivity;

public class SplashView {

  private View view;

  public SplashView(SplashScreenActivity context) {
    FrameLayout parent = new FrameLayout(context);
    parent.setLayoutParams(new FrameLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT,
        ViewGroup.LayoutParams.MATCH_PARENT));
    view = LayoutInflater.from(context).inflate(R.layout.activity_splash, parent, true);
    ButterKnife.bind(view, context);
  }

  public View constructView() {
    return view;
  }
}
