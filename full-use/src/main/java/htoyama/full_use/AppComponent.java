package htoyama.full_use;

import android.content.Context;

import javax.inject.Singleton;

import dagger.Component;
import htoyama.full_use.domain.item.ItemRepository;

@Singleton
@Component(
        modules = AppModule.class
)
public interface AppComponent {

    /**
     * {@link AppModule} (と一応DataModule)で構築されたオブジェクトグラフの中に存在するクラスは、
     * このComponent内でメソッド宣言できる。
     *
     * <p>
     * ここでメソッドを宣言すると、このAppComponentに依存している別のComponent({@link Component#dependencies()})に、
     * そのクラスが使えるようになる。
     *
     * <p>
     * この場合、{@link ItemRepository}を{@link htoyama.full_use.presentation.main.MainComponent}
     * で使いたいため、ここで宣言する。
     */
    ItemRepository itemRepository();

    Context applicationContext();
}
