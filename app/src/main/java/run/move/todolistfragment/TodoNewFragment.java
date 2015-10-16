package run.move.todolistfragment;

import android.app.Activity;
import android.os.Bundle;
import android.app.Fragment;
import android.util.Log;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link TodoNewFragment.OnNewItemAddListener} interface
 * to handle interaction events.
 * Use the {@link TodoNewFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class TodoNewFragment extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private OnNewItemAddListener mListener;

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment TodoNewFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static TodoNewFragment newInstance(String param1, String param2) {
        TodoNewFragment fragment = new TodoNewFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    public TodoNewFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        Log.d("todo","TodoNewFragment.onCreate");
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        Log.d("todo","TodoNewFragment.onCreateView");
        // Inflate the layout for this fragment
        View ret= inflater.inflate(R.layout.fragment_todo_new, container, false);
        final EditText editText= (EditText) ret.findViewById(R.id.inputText);
        editText.setOnKeyListener(new View.OnKeyListener() {
            @Override
            public boolean onKey(View v, int keyCode, KeyEvent event) {
                if(keyCode== KeyEvent.KEYCODE_ENTER && event.getAction()==KeyEvent.ACTION_DOWN){
                    String text=editText.getText().toString();
                    Todo todo=new Todo();
                    todo.name=text;
                    if(mListener!=null){
                        mListener.OnNewItemAddListener(todo);
                    }
                    editText.setText("");
                    return true;
                }
                return false;
            }
        });
        return ret;
    }


    @Override
    public void onAttach(Activity activity) {
        Log.d("todo","TodoNewFragment.onAttach");
        super.onAttach(activity);
        try {
            mListener = (OnNewItemAddListener) activity;
        } catch (ClassCastException e) {
            throw new ClassCastException(activity.toString()
                    + " must implement OnFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        Log.d("todo","TodoNewFragment.onDetach");
        super.onDetach();
        mListener = null;
    }

    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p/>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
    public interface OnNewItemAddListener {
        // TODO: Update argument type and name
        public void OnNewItemAddListener(Todo text);
    }

}
