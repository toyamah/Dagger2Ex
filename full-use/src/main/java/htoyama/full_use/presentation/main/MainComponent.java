package htoyama.full_use.presentation.main;

import dagger.Component;
import htoyama.full_use.AppComponent;

@MainScope
@Component(
        /**
         * 引き継ぎたいComponentを指定する。
         */
        dependencies = AppComponent.class
)
public interface MainComponent {
    void inject(MainActivity activity);
}
