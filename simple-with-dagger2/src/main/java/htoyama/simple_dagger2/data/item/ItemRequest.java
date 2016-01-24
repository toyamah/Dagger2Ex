package htoyama.simple_dagger2.data.item;

import javax.inject.Inject;

public class ItemRequest {
    private static final String TAG = ItemRequest.class.getSimpleName();

    private final ItemParser mParser;

    /**
     * {@link ItemParser}という依存性を外から注入できる。
     * これによって、{@link ItemParser}の内部の動きに左右されないテストが書けるようになる。
     */
    @Inject
    ItemRequest(ItemParser parser) {
        mParser = parser;
    }

    public Item execute() {
        try {
            //以下のstringは、本来はhttpレスポンスのjsonが入る。
            return mParser.parse("any strings");
        } catch (RuntimeException e) {
            throw e;
        }
    }

}
