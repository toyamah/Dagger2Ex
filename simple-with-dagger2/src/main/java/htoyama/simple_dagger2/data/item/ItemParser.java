package htoyama.simple_dagger2.data.item;

import com.fasterxml.jackson.core.JsonFactory;

import javax.inject.Inject;

import htoyama.simple_dagger2.AppModule;

class ItemParser {
    private static final String TAG = ItemParser.class.getSimpleName();

    private final JsonFactory mJsonFactory;

    /**
     * {@link AppModule}に{@link AppModule#provideJsonFactory()}というprovideメソッドを用意しているため、
     * このコンストラクタの引数に自動的に{@link JsonFactory}が入ってくれる
     */
    @Inject
    ItemParser(JsonFactory jsonFactory) {
        mJsonFactory = jsonFactory;
    }

    Item parse(String json) {
        if (json == null || json.isEmpty()) {
            throw new RuntimeException();
        }

        return new Item(1, "name", 100);
    }

}
