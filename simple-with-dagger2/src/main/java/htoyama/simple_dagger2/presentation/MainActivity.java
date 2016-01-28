package htoyama.simple_dagger2.presentation;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

import javax.inject.Inject;

import htoyama.simple_dagger2.App;
import htoyama.simple_dagger2.R;
import htoyama.simple_dagger2.data.item.Item;
import htoyama.simple_dagger2.data.item.ItemRequest;

public class MainActivity extends AppCompatActivity {
    @Inject
    ItemRequest mRequest;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //ここでinjectをすることで、
        //メンバ変数のmRequestにインスタンスが注入される。
        App.component(this)
                .inject(this);

        Item item = mRequest.execute();
        Toast.makeText(this, item.toString(), Toast.LENGTH_LONG).show();
    }

}
