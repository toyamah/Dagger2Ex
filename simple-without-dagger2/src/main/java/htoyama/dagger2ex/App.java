package htoyama.dagger2ex;

import android.app.Application;
import android.content.Context;

public class App extends Application {
    private static final String TAG = App.class.getSimpleName();

    public static App with(Context context) {
        return (App) context.getApplicationContext();
    }

    @Override
    public void onCreate() {
        super.onCreate();
    }

}
