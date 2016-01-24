package htoyama.full_use.data.item;

import android.support.annotation.Nullable;

import javax.inject.Inject;
import javax.inject.Singleton;

import htoyama.full_use.domain.item.Item;
import htoyama.full_use.domain.item.ItemRepository;

/**
 * {@link ItemRepository}を実装したもの。
 * Dependency Inversion Principleの実現。
 *
 * <p>
 * {@link Singleton}というアノテーションを付与できる。
 * @see htoyama.full_use.data.DataModule#Whats_ScopedBindings
 */
@Singleton
public class ItemDataRepository implements ItemRepository {
    private final ItemPrefsGateway mGateway;

    @Inject
    public ItemDataRepository(ItemPrefsGateway gateway) {
        mGateway = gateway;
    }

    @Nullable
    @Override
    public Item find() {
        return mGateway.get();
    }

    @Override
    public void save(Item item) {
        if (item == null) {
            throw new NullPointerException("item must not be null.");
        }

        mGateway.put(item);
    }

}
