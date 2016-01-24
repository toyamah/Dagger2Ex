package htoyama.simple_dagger2;

import com.fasterxml.jackson.core.JsonFactory;

import dagger.Module;
import dagger.Provides;

@Module
public class AppModule {

    @Provides
    public JsonFactory provideJsonFactory() {
        return new JsonFactory();
    }

}