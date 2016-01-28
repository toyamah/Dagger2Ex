package htoyama.simple_dagger2;

import android.app.Application;
import android.content.Context;

public class App extends Application {
    private static final String TAG = App.class.getSimpleName();

    private AppComponent mAppComponent;

    public static App with(Context context) {
        return (App) context.getApplicationContext();
    }

    public static AppComponent component(Context context) {
        return App.with(context).mAppComponent;
    }

    @Override
    public void onCreate() {
        super.onCreate();

        //DaggerAppComponentは、ビルド時に自動生成される。(annotation processing)
        //したがって、初めてのビルドの時にはDaggerAppComponentというクラスは存在しない
        mAppComponent = DaggerAppComponent.builder()
                .appModule(new AppModule())
                .build();
    }
}
