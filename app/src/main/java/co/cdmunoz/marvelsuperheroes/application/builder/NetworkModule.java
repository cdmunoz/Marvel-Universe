package co.cdmunoz.marvelsuperheroes.application.builder;

import android.content.Context;
import co.cdmunoz.marvelsuperheroes.utils.rx.AppRxSchedulers;
import com.facebook.stetho.okhttp3.StethoInterceptor;
import dagger.Module;
import dagger.Provides;
import java.io.File;
import okhttp3.Cache;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

@Module public class NetworkModule {

  @AppScope @Provides OkHttpClient provideHttpClient(HttpLoggingInterceptor logger, Cache cache) {

    OkHttpClient.Builder builder = new OkHttpClient().newBuilder();
    builder.addInterceptor(logger);
    builder.addNetworkInterceptor(new StethoInterceptor());
    builder.cache(cache);
    return builder.build();
  }

  @AppScope @Provides HttpLoggingInterceptor provideInterceptor() {
    HttpLoggingInterceptor httpLoggingInterceptor = new HttpLoggingInterceptor();
    httpLoggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
    return httpLoggingInterceptor;
  }

  @AppScope @Provides Cache provideCache(File file) {
    return new Cache(file, 10 * 10 * 1000);
  }

  @AppScope @Provides File provideCacheFile(Context context) {
    return context.getFilesDir();
  }

  @AppScope @Provides RxJavaCallAdapterFactory provideRxAdapter() {
    return RxJavaCallAdapterFactory.createWithScheduler(AppRxSchedulers.INTERNET_SCHEDULERS);
  }

  @Provides GsonConverterFactory provideGsonClient() {
    return GsonConverterFactory.create();
  }
}

