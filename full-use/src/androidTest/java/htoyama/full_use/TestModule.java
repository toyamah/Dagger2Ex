package htoyama.full_use;

import android.content.Context;
import android.support.annotation.Nullable;
import android.support.test.InstrumentationRegistry;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import htoyama.full_use.domain.item.Item;
import htoyama.full_use.domain.item.ItemRepository;

@Module
public class TestModule {

    @Singleton
    @Provides
    public Context context() {
        return InstrumentationRegistry.getTargetContext().getApplicationContext();
    }

    @Provides
    public ItemRepository itemRepository() {
        return new ItemRepository() {
            @Nullable
            @Override
            public Item find() {
                return new Item(1, "fake", 100);
            }

            @Override
            public void save(Item item) {}
        };
    }

}
