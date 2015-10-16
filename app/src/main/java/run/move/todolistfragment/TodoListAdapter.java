package run.move.todolistfragment;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.TextView;

import java.util.List;

/**
 * Created by sihai on 15/10/16.
 */
public class TodoListAdapter extends ArrayAdapter<Todo> {

    private int resourceId;
    public TodoListAdapter(Context context, int resource, List<Todo> objects) {
        super(context, resource, objects);
        this.resourceId=resource;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LinearLayout ret= (LinearLayout) convertView;
        if(ret==null){
            ret=new LinearLayout(getContext());
            LayoutInflater li= (LayoutInflater) getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            li.inflate(this.resourceId,ret,true);
        }
        TextView tv= (TextView) ret.findViewById(R.id.todoRowTextView);
        Todo todo=getItem(position);
        tv.setText(todo.name);
        return ret;
    }

    public View getView_(int position, View convertView, ViewGroup parent) {

        View ret= super.getView(position, convertView, parent);
        assert(ret!=null);
        Todo todo=getItem(position);
        TextView tv= (TextView) ret.findViewById(R.id.todoRowTextView);
        tv.setText(todo.name);
        return ret;
    }
}
