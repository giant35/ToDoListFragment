package run.move.todolistfragment;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Adapter;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements TodoNewFragment.OnNewItemAddListener{

    final List<Todo> todoList=new ArrayList<Todo>();
    TodoListAdapter adapter=null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TodoNewFragment addFragment= (TodoNewFragment) getFragmentManager().findFragmentById(R.id.newFragment);
        TodoListFragment listFragment= (TodoListFragment) getFragmentManager().findFragmentById(R.id.listFragment);

        adapter=new TodoListAdapter(this,R.layout.fragment_todo_row,todoList);
        listFragment.setListAdapter(adapter);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void OnNewItemAddListener(Todo text) {
        Log.i("","OnNewItemAddListener"+text.name);
        todoList.add(text);
        adapter.notifyDataSetChanged();
    }
}
