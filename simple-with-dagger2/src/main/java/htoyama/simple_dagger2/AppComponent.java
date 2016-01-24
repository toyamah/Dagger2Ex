package htoyama.simple_dagger2;

import dagger.Component;
import htoyama.simple_dagger2.presentation.MainActivity;

@Component(
        modules = AppModule.class
)
public interface AppComponent {
    /**
     * 生成したオブジェクトグラフを使って、実際に使いたいクラスを記述する。
     */
    void inject(MainActivity activity);
}
