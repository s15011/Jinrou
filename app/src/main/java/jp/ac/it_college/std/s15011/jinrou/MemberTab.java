package jp.ac.it_college.std.s15011.jinrou;

import android.content.Context;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.ListFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by Nakachi Samuel Kota on 2017/03/20.
 */

public class MemberTab extends Fragment {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.member_tab, container, false);
        return view;
    }
}

class MemberListFragment extends ListFragment {
    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        ArrayList<String> name_list = new ArrayList<>();
        for (int i = 0; i <= 30; i++) name_list.add("member"+i);

        MyArrayAdapter adapter = new MyArrayAdapter(getContext(), 0, name_list);

        setListAdapter(adapter);
    }
}

class MyArrayAdapter extends ArrayAdapter<String> {

    private LayoutInflater layoutInflater;
    private String GameFont =  "JKG-L_3.ttf";

    public MyArrayAdapter(Context context, int id, ArrayList<String> items) {
        super(context, id, items);
        this.layoutInflater = (LayoutInflater) context.getSystemService(
                Context.LAYOUT_INFLATER_SERVICE
        );
    }

    @NonNull
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            convertView = layoutInflater.inflate(
                    R.layout.member_list_row,
                    parent,
                    false
            );
        }

        TextView textView = (TextView) convertView.findViewById(R.id.textView);
        textView.setTypeface(Typeface.createFromAsset(getContext().getAssets(), GameFont));

        return convertView;
    }
}
