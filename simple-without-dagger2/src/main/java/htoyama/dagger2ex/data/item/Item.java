package htoyama.dagger2ex.data.item;

/**
 * モデル
 */
public class Item {
    private static final String TAG = Item.class.getSimpleName();

    private final int mId;
    private String mName;
    private int mPrice;

    public Item(int id, String name, int price) {
        mId = id;
        mName = name;
        mPrice = price;
    }

    public int id() {
        return mId;
    }

    public String name() {
        return mName;
    }

    public int price() {
        return mPrice;
    }


    @Override
    public String toString() {
        return "Item{" +
                "mId=" + mId +
                ", mName='" + mName + '\'' +
                ", mPrice=" + mPrice +
                '}';
    }
}
