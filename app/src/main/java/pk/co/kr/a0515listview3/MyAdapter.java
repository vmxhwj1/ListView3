package pk.co.kr.a0515listview3;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

public class MyAdapter extends BaseAdapter {
    //뷰 전개를 위한 LayoutInflater를 생성하기 위한 Context 변수
    Context context;
    LayoutInflater inflater;
    //항목뷰의 id를 저장할 변수
    int layout;
    //출력할 데이터 배열을 저장할 변수
    List<Data> list;

    //Activity 클래스로 부터 데이터를 넘겨받기 위한 생성자
    public  MyAdapter(Context context, int layout, List<Data>list){
        super();
        this.context = context;
        this.layout = layout;
        this.list = list;

        inflater = (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    //ListView에 출력될 항목의 개수를 설정하는 메소드
    @Override
    public int getCount() {
        return list.size();
    }

    //출력할 내용을 설정하는 메소드
    @Override
    public Object getItem(int position) {
        return list.get(position).getName();
    }

    //각 항목 뷰의 아이디를 설정하는 메소드
    @Override
    public long getItemId(int position) {
        return position;
    }

    //실제 출력할 항목 뷰를 설정하는 메소드
    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        if(convertView == null){
            //첫번째 매개변수는 출력할 뷰의 아이디
            //두번째 매개변수는 부모 뷰
            //세번째 매개변수는 GroupView 여부
            //layout에 저장된 아이디를 가지고 xml 파일을 찾아서 메모리에 로드드
           convertView = inflater.inflate(layout, parent, false);
        }
        //짝수행과 홀수행의 배경색설정
        if(position % 2 == 0){
            convertView.setBackgroundColor(Color.RED);
        }else{
            convertView.setBackgroundColor(Color.BLUE);
        }
        //이미지 뷰에 이미지를 출력
        ImageView imgView = (ImageView)convertView.findViewById(R.id.img);
        imgView.setImageResource(list.get(position).getIcon());
        //텍스트 뷰에 텍스트를 출력
        TextView textView = (TextView)convertView.findViewById(R.id.text);
        textView.setText(list.get(position).getName());

        //anonymous 클래스에서는 일반 지역변수는 사용할 수 없기 때문에
        //final 변수에 저장해서 사용해야 합니다.
        final int pos = position;

        //버튼을 눌렀을 때 처리
        Button button = (Button)convertView.findViewById(R.id.btn);
        button.setOnClickListener(new Button.OnClickListener(){
            @Override
            public void onClick(View v) {
                String msg = list.get(position).getName();
                Toast.makeText(context, "select item:" + msg, Toast.LENGTH_SHORT).show();

            }
        });

        return convertView;
    }
}













