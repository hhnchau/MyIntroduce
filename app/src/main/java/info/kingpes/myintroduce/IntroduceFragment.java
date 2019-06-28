package info.kingpes.myintroduce;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

public class IntroduceFragment extends Fragment {

    public static IntroduceFragment newInstance(Object o) {
        Bundle bundle = new Bundle();
        bundle.putString("DATA", o.toString());

        IntroduceFragment fragment = new IntroduceFragment();
        fragment.setArguments(bundle);
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        String s = "";
        if (getArguments() != null)
            s = getArguments().getString("DATA");

        View view = inflater.inflate(R.layout.my_introduce_fragment, container, false);

        TextView textView = view.findViewById(R.id.txt);
        textView.setText(s);

        ImageView img = view.findViewById(R.id.img);
        img.setImageResource(R.drawable.first);

        return view;
    }
}
