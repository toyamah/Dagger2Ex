package htoyama.dagger2ex.presentation;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

import htoyama.dagger2ex.R;
import htoyama.dagger2ex.data.item.Item;
import htoyama.dagger2ex.data.item.ItemRequest;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ItemRequest request = new ItemRequest();
        Item item = request.execute();

        Toast.makeText(this, item.toString(), Toast.LENGTH_LONG).show();
    }

}
