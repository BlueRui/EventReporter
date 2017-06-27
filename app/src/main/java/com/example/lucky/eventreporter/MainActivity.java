package com.example.lucky.eventreporter;

import android.support.v4.app.Fragment;
import android.content.res.Configuration;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class MainActivity extends AppCompatActivity implements EventFragment.OnItemSelectListener {


  EventFragment listFragment;
  CommentFragment gridFragment;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);
    //add list view
    if (isTablet()) {
      listFragment = new EventFragment();
      getSupportFragmentManager().beginTransaction().add(R.id.event_container, listFragment).commit();
    }

    //add Gridview
    gridFragment = new CommentFragment();
    getSupportFragmentManager().beginTransaction().add(R.id.comment_container, gridFragment).commit();
  }

  private boolean isTablet() {
    return (getApplicationContext().getResources().getConfiguration().screenLayout &
            Configuration.SCREENLAYOUT_SIZE_MASK) >=
            Configuration.SCREENLAYOUT_SIZE_LARGE;
  }

  @Override
  public void onItemSelected(int position){
    gridFragment.onItemSelected(position);
  }



  //  /**
//   * A dummy function to get fake event names
//   *
//   * @ return an array of ake event names
//   */
/*  private String[] getEventNames() {
    String[] names = {
            "Event1", "Event2", "Event3",
            "Event4", "Event5", "Event6",
            "Event7", "Event8", "Event9",
            "Event10", "Event11", "Event12"};
    return names;
  }*/

  // Get ListView object from xml
//    ListView eventListView = (ListView) findViewById(R.id.event_list);

  // Initialize an adapter
/*    // Returns a view for each object in a collection of data objects you provide
    ArrayAdapter<String> adapter = new ArrayAdapter<String>(
            this,                 // Context: The current context.
            R.layout.event_item,  // int: The resource ID for a layout file containing a layout to use when instantiating views.
            R.id.event_name,      // int: The id of the TextView within the layout resource to be populated
            getEventNames());     // T: The objects to represent in the ListView.*/

//    EventAdapter adapter = new EventAdapter(this);
  // Assign adapter to ListView
//    eventListView.setAdapter(adapter);
}
