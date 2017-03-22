package jp.ac.it_college.std.s15011.jinrou;

import android.content.Context;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import org.w3c.dom.Text;


/**
 * Created by Nakachi Samuel Kota on 2017/03/20.
 */

public class ChatTab extends Fragment {

    ArrayAdapter<String> adapter;
    private InputMethodManager inputMethodManager;
    private View window;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        final View view = inflater.inflate(R.layout.chat_tab, container, false);

        inputMethodManager = (InputMethodManager)getContext().getSystemService(Context.INPUT_METHOD_SERVICE);
        window = view.findViewById(R.id.listView);
        window.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                inputMethodManager.hideSoftInputFromWindow(window.getWindowToken(), InputMethodManager.HIDE_NOT_ALWAYS);
                window.requestFocus();
                return false;
            }
        });

        return view;
    }

    @Override
    public void onStart() {
        super.onStart();

        final Button button = (Button)getActivity().findViewById(R.id.button2);
        final EditText input_area = (EditText)getActivity().findViewById(R.id.editText);

        Typeface typeface = Typeface.createFromAsset(getContext().getAssets(),
                String.valueOf(R.string.GameFont));

        ListView listview = (ListView)getActivity().findViewById(R.id.listView);
        adapter = new ArrayAdapter<String>(getActivity(), R.layout.chat_tab_row);

        button.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                if (!input_area.getText().toString().equals("")) {
                    addStringData();
                }
            }
        });

        listview.setAdapter(adapter);
    }

    private void addStringData(){

        Typeface typeface = Typeface.createFromAsset(getContext().getAssets(),
                String.valueOf(R.string.GameFont));

        EditText edittext = (EditText)getActivity().findViewById(R.id.editText);
        edittext.setTypeface(typeface);
        adapter.add("なまえ >> " + edittext.getText().toString());
        edittext.getEditableText().clear();
    }
}
