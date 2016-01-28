package htoyama.full_use.domain.item;

import android.support.annotation.Nullable;

public interface ItemRepository {
    @Nullable
    Item find();

    void save(Item item);
}
