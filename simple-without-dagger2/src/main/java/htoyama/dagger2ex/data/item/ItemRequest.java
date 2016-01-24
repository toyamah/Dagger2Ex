package htoyama.dagger2ex.data.item;

public class ItemRequest {
    private static final String TAG = ItemRequest.class.getSimpleName();

    public ItemRequest() {
        //do nothing.
    }

    public Item execute() {
        try {
            ItemParser parser = new ItemParser();
            return parser.parse("any strings");
        } catch (RuntimeException e) {
            throw e;
        }
    }

}
