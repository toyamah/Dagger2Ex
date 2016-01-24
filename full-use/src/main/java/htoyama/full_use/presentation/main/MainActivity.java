package htoyama.full_use.presentation.main;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

import javax.inject.Inject;

import htoyama.full_use.App;
import htoyama.full_use.R;
import htoyama.full_use.domain.item.Item;
import htoyama.full_use.domain.item.ItemRepository;

public class MainActivity extends AppCompatActivity {
    @Inject ItemRepository mItemRepository;
    @Inject MainFoo mMainFoo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        injectMembers();
        mMainFoo.doSomething();

        setupItemView();
    }

    private void setupItemView() {
        MainView mainView = (MainView) findViewById(R.id.item_view);
        mainView.bind(mItemRepository.find());

        mainView.setOnClickListener(new MainView.OnClickListener() {
            @Override
            public void onSubmitClick(Item item) {
                mItemRepository.save(item);

                Toast.makeText(getApplicationContext(),
                        "登録しました。 " + item.toString(), Toast.LENGTH_LONG).show();
            }
        });
    }

    private void injectMembers() {
        DaggerMainComponent.builder()
                .appComponent(App.component(this))
                .build()
                .inject(this);
    }

}
