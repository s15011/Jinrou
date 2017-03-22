package jp.ac.it_college.std.s15011.jinrou;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import static android.R.layout.simple_list_item_1;

/**
 * Created by Nakachi Samuel Kota on 2017/03/20.
 */

public class ChatTab extends Fragment {

    ArrayAdapter<String> adapter;
//    @Override
//    public void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//    }
//
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.chat_tab, container, false);
////        Typeface typeface = Typeface.createFromAsset(getContext().getAssets(), "JKG-L_3.ttf");
////        ((TextView) view.findViewById(R.id.textView)).setTypeface(typeface);

        return view;
    }

    @Override
    public void onStart() {
        super.onStart();

        Button button = (Button)getActivity().findViewById(R.id.button2);
        ListView listview = (ListView)getActivity().findViewById(R.id.listView);
        adapter = new ArrayAdapter<String>(getActivity(), simple_list_item_1);

        button.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                addStringData();
            }
        });

        listview.setAdapter(adapter);
    }

    private void addStringData(){
        EditText edittext = (EditText)getActivity().findViewById(R.id.editText);
        adapter.add(edittext.getText().toString());
    }
}
