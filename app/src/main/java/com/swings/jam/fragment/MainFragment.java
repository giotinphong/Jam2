package com.swings.jam.fragment;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.swings.jam.R;
import com.swings.jam.adapter.backingtrack.BackingTrackAdapter;
import com.swings.jam.adapter.typerecyclerview.TypeRecylerViewAdapter;
import com.swings.jam.adapter.yourjam.YourJamAdapter;
import com.swings.jam.data.BackingTrack;
import com.swings.jam.data.DataHelper;
import com.swings.jam.data.Type;
import com.swings.jam.data.YourJam;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link MainFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link MainFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class MainFragment extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private OnFragmentInteractionListener mListener;

    public MainFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment MainFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static MainFragment newInstance(String param1, String param2) {
        MainFragment fragment = new MainFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v =  inflater.inflate(R.layout.fragment_main, container, false);
        DataHelper dataHelper = new DataHelper(getContext());

        //list category
        final ArrayList<Type> typeArrayList = dataHelper.selectAllType();
        TypeRecylerViewAdapter adapter = new TypeRecylerViewAdapter(getContext(),typeArrayList);
        RecyclerView typeRecyclerView = (RecyclerView)v.findViewById(R.id.acti_main_recyleview_type);
        GridLayoutManager gridlayoutManager = new GridLayoutManager(getContext(),3);
        typeRecyclerView.setLayoutManager(gridlayoutManager);
        typeRecyclerView.setAdapter(adapter);


        LinearLayoutManager layoutManager = new LinearLayoutManager(getContext());
        layoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);
        RecyclerView topListenRecyclerView = (RecyclerView)v.findViewById(R.id.frag_main_recylerview_toplisten);
        ArrayList<BackingTrack> backingTrackArrayList = dataHelper.getTopListenBackingtrack(3);
        BackingTrackAdapter adapterBackingtrack = new BackingTrackAdapter(backingTrackArrayList,getContext());
        topListenRecyclerView.setAdapter(adapterBackingtrack);
        topListenRecyclerView.setLayoutManager(layoutManager);

        RecyclerView yourJamRecyclerView = (RecyclerView)v.findViewById(R.id.frag_main_recylerview_yourjam);
        ArrayList<YourJam> jamArrayList = dataHelper.getAllJam();
        YourJamAdapter jamAdapter = new YourJamAdapter(jamArrayList,getContext());
        LinearLayoutManager layoutManager1 = new LinearLayoutManager(getContext());
        layoutManager1.setOrientation(LinearLayoutManager.HORIZONTAL);
        yourJamRecyclerView.setLayoutManager(layoutManager1);
        yourJamRecyclerView.setAdapter(jamAdapter);
        return v;
    }

    // TODO: Rename method, update argument and hook method into UI event
    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onFragmentInteraction(uri);
        }
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnFragmentInteractionListener) {
            mListener = (OnFragmentInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void onFragmentInteraction(Uri uri);
    }
}
