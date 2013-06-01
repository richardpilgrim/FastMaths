package com.example.firstapplication;

import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentTransaction;
import android.content.Context;
import android.os.Bundle;
import android.text.Editable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.app.FragmentManager;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MyProblemFragment extends Fragment {

    private static OnFragmentClickListener mListener;
    private static View view;

    private static int Min = 0;
    private static int Max = 9;

    //Question variables
    int a;
    int b;
    String symbol;
    int solution;


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

    }

    // Called once the Fragment has been created in order for it to
    // create its user interface.
    @Override
    public View onCreateView(LayoutInflater inflater,
                             ViewGroup container,
                             Bundle savedInstanceState) {
        // Create, or inflate the Fragment's UI, and return it.
        // If this Fragment has no UI then return null.
        view = inflater.inflate(R.layout.problem_view, container, false);

        final TextView question = (TextView)view.findViewById(R.id.problemText);
        question.setText(updateQuestion());

        final TextView answer = (TextView)view.findViewById(R.id.problemAnswer);

        Button submitButton = (Button)view.findViewById(R.id.submit);
        submitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //TextView answer = (TextView)view.findViewById(R.id.problemAnswer);
                boolean check = false;
                if(answer != null)
                {
                    if(answer.getText().toString() != "")
                    {
                        int num = Integer.parseInt(answer.getText().toString());
                        check = checkAnswer(num);
                    }
                }

//                int num = Integer.parseInt(answer.getText().toString());
//                boolean check = checkAnswer(num);

                Context context = getActivity().getApplicationContext();
                CharSequence text;
                if(check == true)
                {

                    text = "Correct!!";
                }
                else
                {
                    text = "Not Correct :(";
                }

                int duration = Toast.LENGTH_SHORT;

                Toast toast = Toast.makeText(context, text, duration);
                toast.show();
                if(check == true)
                {
                    question.setText(updateQuestion());
                }

                clearTextBox();
            }
        });

        return view;
    }

    private String updateQuestion()
    {
        String problem;

        a = Min + (int)(Math.random() * ((Max - Min) + 1));
        b = Min + (int)(Math.random() * ((Max - Min) + 1));

        int symbolDecider = 0 + (int)(Math.random() * ((2 - 0) + 1));
        switch(symbolDecider)
        {
            case 0:
                symbol = " + ";
                solution = a + b;
                break;
            case 1:
                symbol = " - ";
                solution = a - b;
                break;
            case 2:
                symbol = " x ";
                solution = a * b;
                break;
        }

        problem = a+symbol+b+" = ";

        return problem;
    }

    private boolean checkAnswer(int answer)
    {
        boolean check;
        if(answer == solution)
        {
            check = true;
        }
        else
        {
            check = false;
        }
        return check;
    }

    public static void updateTextBox(String text)
    {
        final TextView myText = (TextView)view.findViewById(R.id.problemAnswer);
        String str = myText.getText().toString();
        myText.setText(str+text, TextView.BufferType.NORMAL);
        if(myText.getText().toString().length() >= 1)
        {
            mListener.OnFragmentClick(3, "");
        }

    }

    public static void clearTextBox()
    {
        final TextView myText = (TextView)view.findViewById(R.id.problemAnswer);
        myText.setText("", TextView.BufferType.NORMAL);
        mListener.OnFragmentClick(4, "");

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
