package co.cdmunoz.marvelsuperheroes.application;

import android.app.Application;
import co.cdmunoz.marvelsuperheroes.application.builder.AppComponent;
import co.cdmunoz.marvelsuperheroes.application.builder.AppContextModule;
import co.cdmunoz.marvelsuperheroes.application.builder.DaggerAppComponent;
import com.facebook.stetho.Stetho;
import timber.log.BuildConfig;
import timber.log.Timber;

public class AppController extends Application {

  private static AppComponent appComponent;

  @Override public void onCreate() {
    super.onCreate();
    Stetho.initializeWithDefaults(this);
    initialiseLogger();
    initAppComponent();
  }

  private void initAppComponent() {
    appComponent =
        DaggerAppComponent.builder().appContextModule(new AppContextModule(this)).build();
  }

  private void initialiseLogger() {
    if (BuildConfig.DEBUG) {
      Timber.plant(new Timber.DebugTree());
    } else {
      Timber.plant(new Timber.Tree() {
        @Override protected void log(int priority, String tag, String message, Throwable t) {
          //TODO  decide what to log in release version
        }
      });
    }
  }

  public static AppComponent getNetComponent() {
    return appComponent;
  }
}
