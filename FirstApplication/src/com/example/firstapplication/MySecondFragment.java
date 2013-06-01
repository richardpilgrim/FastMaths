package com.example.firstapplication;

import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.app.FragmentManager;
import android.widget.EditText;
import android.widget.TextView;

public class MySecondFragment extends Fragment {

    private OnFragmentClickListener mListener;
    private static boolean dashAccess;

	  public void onAttach(Activity activity) {
		    super.onAttach(activity);
            try {
                mListener = (OnFragmentClickListener) activity;
            } catch (ClassCastException e) {
                throw new ClassCastException(activity.toString() + " must implement listeners!");
            }
		    // Get a reference to the parent Activity.
		  }

		  // Called to do the initial creation of the Fragment.
		  @Override
		  public void onCreate(Bundle savedInstanceState) {
		    super.onCreate(savedInstanceState);
		    // Initialize the Fragment.

//              final Button ButtonOne;
//              ButtonOne = (Button)findViewById(R.id.buttonOne);
//              ButtonOne.setOnClickListener(new View.OnClickListener() {
//                  @Override
//                  public void onClick(View view) {
//                      EditText myText = (EditText)findViewById(R.id.myText);
//                      String str = (String)ButtonOne.getText();
//                      myText.setText(myText.getText()+ButtonOne.toString(), TextView.BufferType.EDITABLE);
//                  }
//              });

		  }

		  // Called once the Fragment has been created in order for it to
		  // create its user interface.
		  @Override
		  public View onCreateView(LayoutInflater inflater, 
		                           ViewGroup container,
		                           Bundle savedInstanceState) {
		    // Create, or inflate the Fragment's UI, and return it. 
		    // If this Fragment has no UI then return null.
		    View view = inflater.inflate(R.layout.my_fragment, container, false);
              final MyProblemFragment problemFragment = new MyProblemFragment();

              dashAccess = true;

              final Button ButtonOne = (Button)view.findViewById(R.id.buttonOne);
              ButtonOne.setOnClickListener(new View.OnClickListener() {
                  @Override
                  public void onClick(View view) {
                      mListener.OnFragmentClick(1, ButtonOne.getText());
                  }
              });

              final Button ButtonTwo = (Button)view.findViewById(R.id.buttonTwo);
              ButtonTwo.setOnClickListener(new View.OnClickListener() {
                  @Override
                  public void onClick(View view) {
                      mListener.OnFragmentClick(1, ButtonTwo.getText());
                  }
              });

              final Button ButtonThree = (Button)view.findViewById(R.id.buttonThree);
              ButtonThree.setOnClickListener(new View.OnClickListener() {
                  @Override
                  public void onClick(View view) {
                      mListener.OnFragmentClick(1, ButtonThree.getText());
                  }
              });

              final Button ButtonFour = (Button)view.findViewById(R.id.buttonFour);
              ButtonFour.setOnClickListener(new View.OnClickListener() {
                  @Override
                  public void onClick(View view) {
                      mListener.OnFragmentClick(1, ButtonFour.getText());
                  }
              });

              final Button ButtonFive = (Button)view.findViewById(R.id.buttonFive);
              ButtonFive.setOnClickListener(new View.OnClickListener() {
                  @Override
                  public void onClick(View view) {
                      mListener.OnFragmentClick(1, ButtonFive.getText());
                  }
              });

              final Button ButtonSix = (Button)view.findViewById(R.id.buttonSix);
              ButtonSix.setOnClickListener(new View.OnClickListener() {
                  @Override
                  public void onClick(View view) {
                      mListener.OnFragmentClick(1, ButtonSix.getText());
                  }
              });

              final Button ButtonSeven = (Button)view.findViewById(R.id.buttonSeven);
              ButtonSeven.setOnClickListener(new View.OnClickListener() {
                  @Override
                  public void onClick(View view) {
                      mListener.OnFragmentClick(1, ButtonSeven.getText());
                  }
              });

              final Button ButtonEight = (Button)view.findViewById(R.id.buttonEight);
              ButtonEight.setOnClickListener(new View.OnClickListener() {
                  @Override
                  public void onClick(View view) {
                      mListener.OnFragmentClick(1, ButtonEight.getText());
                  }
              });

              final Button ButtonNine = (Button)view.findViewById(R.id.buttonNine);
              ButtonNine.setOnClickListener(new View.OnClickListener() {
                  @Override
                  public void onClick(View view) {
                      mListener.OnFragmentClick(1, ButtonNine.getText());
                  }
              });

              final Button ButtonZero = (Button)view.findViewById(R.id.buttonZero);
              ButtonZero.setOnClickListener(new View.OnClickListener() {
                  @Override
                  public void onClick(View view) {
                      mListener.OnFragmentClick(1, ButtonZero.getText());
                  }
              });

              final Button ButtonDash = (Button)view.findViewById(R.id.buttonDash);

              if(dashAccess == false)
              {
                  ButtonDash.setActivated(false);
              }
              else
              {
                  ButtonDash.setActivated(true);
              }

              ButtonDash.setOnClickListener(new View.OnClickListener() {
                  @Override
                  public void onClick(View view) {
                      if(dashAccess == true)
                      {
                        mListener.OnFragmentClick(1, ButtonDash.getText());
                      }
                  }
              });

              final Button startButton = (Button)view.findViewById(R.id.startButton);
              startButton.setOnClickListener(new View.OnClickListener() {
                  @Override
                  public void onClick(View view) {
                      FragmentManager fragmentManager = getFragmentManager();
                      FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();

                      if(problemFragment.isAdded() == false)
                      {
                          fragmentTransaction.add(R.id.ui_container,problemFragment);
                          fragmentTransaction.commit();
                          startButton.setText(R.string.clearText);

                          ButtonOne.setVisibility(View.VISIBLE);
                          ButtonTwo.setVisibility(View.VISIBLE);
                          ButtonThree.setVisibility(View.VISIBLE);
                          ButtonFour.setVisibility(View.VISIBLE);
                          ButtonFive.setVisibility(View.VISIBLE);
                          ButtonSix.setVisibility(View.VISIBLE);
                          ButtonSeven.setVisibility(View.VISIBLE);
                          ButtonEight.setVisibility(View.VISIBLE);
                          ButtonNine.setVisibility(View.VISIBLE);
                          ButtonZero.setVisibility(View.VISIBLE);
                          ButtonDash.setVisibility(View.VISIBLE);
                      }
                      else
                      {
                          mListener.OnFragmentClick(2,"");
                      }
                  }
              });

              return view;
          }


          public static void disableDash()
          {
              dashAccess = false;
          }

          public static void enableDash()
          {
              dashAccess = true;
          }

		  // Called once the parent Activity and the Fragment's UI have 
		  // been created.
		  @Override
		  public void onActivityCreated(Bundle savedInstanceState) {
		    super.onActivityCreated(savedInstanceState);
		    // Complete the Fragment initialization particularly anything
		    // that requires the parent Activity to be initialized or the 
		    // Fragment's view to be fully inflated.
		  }

		  // Called at the start of the visible lifetime.
		  @Override
		  public void onStart(){
		    super.onStart();
		    // Apply any required UI change now that the Fragment is visible.
		  }

		  // Called at the start of the active lifetime.
		  @Override
		  public void onResume(){
		    super.onResume();
		    // Resume any paused UI updates, threads, or processes required
		    // by the Fragment but suspended when it became inactive.
		  }

		  // Called at the end of the active lifetime.
		  @Override
		  public void onPause(){
		    // Suspend UI updates, threads, or CPU intensive processes
		    // that don't need to be updated when the Activity isn't
		    // the active foreground activity.
		    // Persist all edits or state changes
		    // as after this call the process is likely to be killed.
		    super.onPause();
		  }

		  // Called to save UI state changes at the
		  // end of the active lifecycle.
		  @Override
		  public void onSaveInstanceState(Bundle savedInstanceState) {
		    // Save UI state changes to the savedInstanceState.
		    // This bundle will be passed to onCreate, onCreateView, and
		    // onCreateView if the parent Activity is killed and restarted.
		    super.onSaveInstanceState(savedInstanceState);
		  }

		  // Called at the end of the visible lifetime.
		  @Override
		  public void onStop(){
		    // Suspend remaining UI updates, threads, or processing
		    // that aren't required when the Fragment isn't visible.
		    super.onStop();
		  }

		  // Called when the Fragment's View has been detached.
		  @Override
		  public void onDestroyView() {
		    // Clean up resources related to the View.
		    super.onDestroyView();
		  }

		  // Called at the end of the full lifetime.
		  @Override
		  public void onDestroy(){
		    // Clean up any resources including ending threads,
		    // closing database connections etc.
		    super.onDestroy();
		  }

		  // Called when the Fragment has been detached from its parent Activity.
		  @Override
		  public void onDetach() {
		    super.onDetach();
		  }
}
