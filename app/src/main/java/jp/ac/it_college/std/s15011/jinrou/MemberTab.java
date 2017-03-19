package jp.ac.it_college.std.s15011.jinrou;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.ListFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;

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

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(
                getActivity(),
                R.layout.member_list_row,
                name_list);

        setListAdapter(adapter);
    }
}
