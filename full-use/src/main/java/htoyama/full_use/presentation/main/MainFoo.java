package htoyama.full_use.presentation.main;

import android.content.Context;
import android.widget.Toast;

import javax.inject.Inject;

/**
 * mainパッケージでのみ使うなんらかのクラス
 *
 * @see htoyama.full_use.data.DataModule#Whats_ScopedBindings
 */
@MainScope
class MainFoo {
    private final Context mContext;

    @Inject
    MainFoo(Context context) {
        mContext = context;
    }

    void doSomething() {
        Toast.makeText(mContext, "MainFoo#doSomething", Toast.LENGTH_LONG).show();
    }

}
