package htoyama.full_use.data;

import android.content.Context;
import android.content.SharedPreferences;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import dagger.internal.ScopedProvider;
import htoyama.full_use.AppModule;
import htoyama.full_use.data.item.ItemDataRepository;
import htoyama.full_use.domain.item.ItemRepository;

/**
 * Dataレイヤーにおけるモジュール。 {@link AppModule}にincludeされる。
 *
 * <p>
 * このようにモジュールを分割することもできる。
 * 分割の使いドコロとしては、ある程度のパッケージ単位で宣言するのがいい<b>と思う</b>。
 */
@Module
public class DataModule {

    /**
     * 自分で管理しているクラス、より具体的に言うと{@code @Inject}をコンストラクタで書けるクラスは
     * 基本的には、ここModule内には<b>書かない</b>。
     *
     * <p>
     * ここに書くのは、{@link SharedPreferences}のようなAndroidのクラスであったり、
     * {@link Gson}のようなサードパーティーライブラリが多い。
     * 理由は、自分でInject付きのコンストラクタを自分で宣言できないから。
     */
    public Object How_to_use_module;

    /**
     * ScopedBindingsについて
     *
     * <p>
     * まず使用方法について<br>
     * ScopedBindingsを使用するには、{@link javax.inject.Scope}を定義したアノテーションを、
     * 各クラスや、各provideメソッドに付与すればよい。
     * 例えば、{@link Singleton}アノテーションは{@link javax.inject.Scope}を定義したアノテーションである。
     *
     * <p>
     * このScopedBindingsを使用すると、
     * ひとつの{@link dagger.Component}内で、たった1つのインスタンスを保持するようになる。
     * 故に、都度都度インスタンス生成をしなくてすむようになる。
     *
     * <p>
     * 注意すべきは、<b>ひとつの{@link dagger.Component}内で、たった1つのインスタンスを保持する</b> ということ。
     * つまり、いくら{@link Singleton}アノテーションをつけようが、<b>injectするごとに{@link dagger.Component}をbuildしていたなら</b>
     * 毎回インスタンス化されてしまう。
     *
     * <p>
     * 故に{@link dagger.Component}は出来る限りメンバ変数などで保存しておくよい。
     * 実際に{@link htoyama.full_use.App}では{@link htoyama.full_use.AppComponent}をメンバ変数に保存して、これを使いまわしている。
     * だからこそ、Singletonを実現できている。
     *
     * <p>
     * 実際にどうSingletonを実現させているかは、{@link ScopedProvider}を見ると良いだろう。
     *
     * @see javax.inject.Scope
     * @see Singleton
     * @see dagger.Component
     * @see ScopedProvider
     * @see #gson()
     * @see ItemDataRepository
     */
    public Object Whats_ScopedBindings;


    /**
     * {@code Context}が引数に定義できるのは、
     * {@link AppModule#provideContext()}を定義しているから。
     */
    @Provides
    public SharedPreferences sharedPreferences(Context context) {
        String name = "full_use_of_dagger2";
        return context.getSharedPreferences(name, Context.MODE_PRIVATE);
    }

    /**
     * サードパーティ製もprovideメソッドを用意するのが普通
     *
     * <p>
     * {@link Singleton}というアノテーションを付与することもできる。
     * これをつければ、文字通りSingletonとなる。
     *
     * @see #Whats_ScopedBindings こちらも必ず見ること
     */
    @Singleton
    @Provides
    public Gson gson() {
        return new GsonBuilder()
                .create();
    }

    /**
     * {@link ItemDataRepository}は自分で管理しているクラスで、{@code @Inject}付きのコンストラクタがあるから、
     * 特別このprovideメソッドが必要にないかもしれない。
     *
     * <p>
     * ただし、
     * Typeは{@link ItemRepository}というインタフェースにして、
     * クライアント側からは{@code ItemDataRepository}の存在は隠したい。
     * そういう時にもprovideメソッドは使う。
     *
     * <p>
     * ちなみに引数の{@code repository}も、コンストラクタで{@code @Inject}宣言しているので、ここで宣言可能。
     */
    @Provides
    public ItemRepository itemRepository(ItemDataRepository repository) {
        return repository;
    }


}
