package shuvalov.nikita.simpleanimationslab;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    Button add;
    EditText userEntry;
    TextView currentWish;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final ViewGroup wishList = (ViewGroup)findViewById(R.id.wish_holder);

        add = (Button)findViewById(R.id.enter_wish);
        userEntry= (EditText)findViewById(R.id.user_entry);
        currentWish =(TextView)findViewById(R.id.wish_text);

        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String wish =userEntry.getText().toString();
                currentWish.setText(wish);
                Animation animation = AnimationUtils.loadAnimation(view.getContext(),R.anim.into_empty_list);
                currentWish.setAnimation(animation);

                //New TextView for wishlist group.
                TextView textView = new TextView(view.getContext());
                textView.setText(wish);
                wishList.addView(textView,0);

            }
        });

    }
}
