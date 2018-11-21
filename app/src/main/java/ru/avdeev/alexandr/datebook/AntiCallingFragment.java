package ru.avdeev.alexandr.datebook;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


/*

 класс AntiCallingFragment будет блокировать нежелательные звонки на телефон

 */

public class AntiCallingFragment extends Fragment {


    /**
     * создаем представление для фрагмента
     * @param inflater
     * @param container
     * @param savedInstanceState
     * @return
     */

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {


        View view = inflater.inflate(R.layout.anticalling_fragment, container, false);

        return view;
    }
}
