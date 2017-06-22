package com.example.lucky.eventreporter;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class MainActivity extends AppCompatActivity {

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);

    // Get ListView object from xml
    ListView eventListView = (ListView) findViewById(R.id.event_list);

    // Initialize an adapter
/*    // Returns a view for each object in a collection of data objects you provide
    ArrayAdapter<String> adapter = new ArrayAdapter<String>(
            this,                 // Context: The current context.
            R.layout.event_item,  // int: The resource ID for a layout file containing a layout to use when instantiating views.
            R.id.event_name,      // int: The id of the TextView within the layout resource to be populated
            getEventNames());     // T: The objects to represent in the ListView.*/

    EventAdapter adapter = new EventAdapter(this);

    // Assign adapter to ListView
    eventListView.setAdapter(adapter);
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


}
