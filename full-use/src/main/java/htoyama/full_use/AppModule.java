package htoyama.full_use;

import android.app.Application;
import android.content.Context;

import dagger.Module;
import dagger.Provides;
import htoyama.full_use.data.DataModule;

@Module(
        //AppModuleに、DataModuleをアタッチするようなイメージ
        includes = DataModule.class
)
public class AppModule {
    private final Application mApplication;

    public AppModule(Application application) {
        mApplication = application;
    }

    @Provides
    public Context provideContext() {
        return mApplication;
    }

}
