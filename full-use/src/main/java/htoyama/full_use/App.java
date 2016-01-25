package htoyama.full_use;

import android.app.Application;
import android.content.Context;
import android.support.annotation.VisibleForTesting;

public class App extends Application {
    /**
     * @see htoyama.full_use.data.DataModule#Whats_ScopedBindings
     */
    private AppComponent mComponent;

    public static App with(Context context) {
        return (App) context.getApplicationContext();
    }

    public static AppComponent component(Context context) {
        return App.with(context).mComponent;
    }

    @Override
    public void onCreate() {
        super.onCreate();

        buildComponent();
    }

    private void buildComponent() {
        mComponent = DaggerAppComponent.builder()
                .appModule(new AppModule(this))
                .build();
    }

    @VisibleForTesting
    public void setComponent(AppComponent component) {
        mComponent = component;
    }

}
