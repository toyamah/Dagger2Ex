package htoyama.full_use.data.item;

import android.content.SharedPreferences;
import android.support.annotation.Nullable;

import com.google.gson.Gson;

import javax.inject.Inject;

import htoyama.full_use.domain.item.Item;

public class ItemPrefsGateway {
    private static final String KEY_ITEM = "item";
    private final SharedPreferences mPrefs;
    private final Gson mGson;

    /**
     * 2つの引数が使えるのは、{@link htoyama.full_use.data.DataModule}でprovideメソッドを宣言しているから。
     */
    @Inject
    public ItemPrefsGateway(SharedPreferences prefs, Gson gson) {
        mPrefs = prefs;
        mGson = gson;
    }

    public void put(Item item) {
        mPrefs.edit()
                .putString(KEY_ITEM, mGson.toJson(item))
                .apply();
    }

    @Nullable
    public Item get() {
        String itemJson = mPrefs.getString(KEY_ITEM, null);
        if (itemJson == null) {
            return null;
        }

        return mGson.fromJson(itemJson, Item.class);
    }

}
