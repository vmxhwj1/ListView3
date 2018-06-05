package pk.co.kr.a0515listview3;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ArrayList<Data> list = new ArrayList<>();
        Data data = new Data();
        data.setIcon(R.drawable.a1);
        data.setName("아이린1");
        list.add(data);

        data = new Data();
        data.setIcon(R.drawable.a2);
        data.setName("아이린2");
        list.add(data);

        data = new Data();
        data.setIcon(R.drawable.a3);
        data.setName("아이린3");
        list.add(data);

        data = new Data();
        data.setIcon(R.drawable.a4);
        data.setName("아이린4");
        list.add(data);

        data = new Data();
        data.setIcon(R.drawable.a5);
        data.setName("아이린5");
        list.add(data);

        MyAdapter adapter = new MyAdapter(this, R.layout.icontext, list);

        ListView listView = (ListView)findViewById(R.id.listView);
        listView.setAdapter(adapter);


    }
}
