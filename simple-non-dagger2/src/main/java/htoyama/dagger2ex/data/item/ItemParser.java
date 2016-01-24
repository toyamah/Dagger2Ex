package htoyama.dagger2ex.data.item;

import com.fasterxml.jackson.core.JsonFactory;

class ItemParser {
    private static final String TAG = ItemParser.class.getSimpleName();

    private final JsonFactory mJsonFactory;

    ItemParser() {
        mJsonFactory = new JsonFactory();
    }

    Item parse(String json) {
        if (json == null || json.isEmpty()) {
            throw new RuntimeException();
        }

        return new Item(1, "name", 100);
    }

}
