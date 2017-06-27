package com.example.lucky.eventreporter;

import android.support.v4.app.Fragment;
import android.content.res.Configuration;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class MainActivity extends AppCompatActivity {

  private EditText mUsernameEditText;
  private EditText mPasswordEditText;
  private Button mSubmitButton;
  private Button mRegisterButton;
  private DatabaseReference mDatabase;


  EventFragment listFragment;

  public MainActivity() {
  }

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);

    // Firebase uses singleton to initialize the sdk
    mDatabase = FirebaseDatabase.getInstance().getReference();

    mUsernameEditText = (EditText) findViewById(R.id.editTextLogin);
    mPasswordEditText = (EditText) findViewById(R.id.editTextPassword);
    mSubmitButton = (Button) findViewById(R.id.submit);
    mRegisterButton = (Button) findViewById(R.id.register);


    mRegisterButton.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View v) {
        final String username = mUsernameEditText.getText().toString();
        final String password = mPasswordEditText.getText().toString();
        final User user = new User(username, password, System.currentTimeMillis());
        mDatabase.child("users").addListenerForSingleValueEvent(new ValueEventListener() {
          @Override
          public void onDataChange(DataSnapshot dataSnapshot) {
            if (dataSnapshot.hasChild(username)) {
              Toast.makeText(getBaseContext(),"username is already registered, please change one", Toast.LENGTH_SHORT).show();
            } else if (!username.equals("") && !password.equals("")){
              // put username as key to set value
              mDatabase.child("users").child(user.getUsername()).setValue(user);
              Toast.makeText(getBaseContext(),"Successfully registered", Toast.LENGTH_SHORT).show();
            }
          }

          @Override
          public void onCancelled(DatabaseError databaseError) {

          }
        });
      }
    });

    mSubmitButton.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View v) {
        final String username = mUsernameEditText.getText().toString();
        final String password = mPasswordEditText.getText().toString();
        mDatabase.child("users").addListenerForSingleValueEvent(new ValueEventListener() {
          @Override
          public void onDataChange(DataSnapshot dataSnapshot) {
            if (dataSnapshot.hasChild(username) && (password.equals(dataSnapshot.child(username).child("password").getValue()))) {
              Log.i( " Your log", "You successfully login");
            } else {
              Toast.makeText(getBaseContext(),"Please login again", Toast.LENGTH_SHORT).show();
            }
          }

          @Override
          public void onCancelled(DatabaseError databaseError) {

          }
        });
      }
    });
  }

  private boolean isTablet() {
    return (getApplicationContext().getResources().getConfiguration().screenLayout &
            Configuration.SCREENLAYOUT_SIZE_MASK) >=
            Configuration.SCREENLAYOUT_SIZE_LARGE;
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
