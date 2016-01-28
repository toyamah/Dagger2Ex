package htoyama.full_use.domain.item;

public final class Item {
    private final int mId;

    private String mName;
    private int mPrice;

    /**
     * 自分でインスタンス化したいエンティティなどは、{@code @Inject}は書かないで、
     * 通常通りコンストラクタを宣言する。
     */
    public Item(int id, String name, int price) {
        mId = id;
        setName(name);
        setPrice(price);
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

    public void setName(String name) {
        if (name == null) {
            throw new NullPointerException("name must be not null.");
        }
        mName = name;
    }

    public void setPrice(int price) {
        if (price < 0) {
            throw new IllegalArgumentException("price must be positive number.");
        }
        mPrice = price;
    }

    @Override
    public String toString() {
        return "Item{" +
                "mId=" + mId +
                ", mName='" + mName + '\'' +
                ", mPrice=" + mPrice +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        Item item = (Item) o;
        return mId == item.mId;

    }

    @Override
    public int hashCode() {
        return mId;
    }

}
