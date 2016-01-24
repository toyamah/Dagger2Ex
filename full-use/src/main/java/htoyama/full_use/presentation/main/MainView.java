package htoyama.full_use.presentation.main;

import android.content.Context;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;

import htoyama.full_use.R;
import htoyama.full_use.domain.item.Item;

public class MainView extends LinearLayout {
    private final EditText mNameEditText;
    private final EditText mPriceEditText;
    private final Button mSubmitButton;

    private Item mItem;
    @Nullable private OnClickListener mListener;

    interface OnClickListener {
        void onSubmitClick(Item item);
    }

    public MainView(Context context, AttributeSet attrs) {
        super(context, attrs);

        setOrientation(VERTICAL);
        LayoutInflater.from(getContext()).inflate(R.layout.view_item, this, true);
        mNameEditText = (EditText) findViewById(R.id.item_name);
        mPriceEditText = (EditText) findViewById(R.id.item_price);
        mSubmitButton = (Button) findViewById(R.id.submit_button);

        setupButton();
    }

    public void setOnClickListener(@Nullable OnClickListener listener) {
        mListener = listener;
    }

    public void bind(@Nullable Item item) {
        if (item == null) {
            mItem = new Item(1, "", 0);
            return;
        }

        mNameEditText.setText(item.name());
        mPriceEditText.setText(String.valueOf(item.price()));
        mItem = item;
    }

    private void setupButton() {
        mSubmitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mListener != null) {
                    updateItem();
                    mListener.onSubmitClick(mItem);
                }
            }
        });
    }

    private void updateItem() {
        String name = mNameEditText.getText().toString();
        int price = Integer.valueOf(
                mPriceEditText.getText().toString());

        mItem.setName(name);
        mItem.setPrice(price);
    }

}
