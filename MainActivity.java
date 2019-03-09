package example.com.prince.usamp7;

import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    Button closeButtton;
    AlertDialog.Builder builder;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        closeButtton = (Button) findViewById(R.id.button);
        builder = new AlertDialog.Builder(this);
        closeButtton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Uncomment the below code to Set the message and title from the strings.xml
                builder.setMessage(R.string.dialog_message).setTitle(R.string.dialog_title);

                //Setting message manually and performing action on button click
                builder.setMessage("Do you want to close the application?")
                        .setCancelable(false)
                        .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                finish();
                                Toast.makeText(getApplicationContext(),"you choose yes action for alert box",Toast.LENGTH_LONG).show();
                            }
                        })
                        .setNegativeButton("No", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                // Action for 'NO' Button
                                dialog.cancel();
                                Toast.makeText(getApplicationContext(),"you choose no for alert box",Toast.LENGTH_LONG).show();
                            }
                        });
                // Creating dialog box
                AlertDialog alert = builder.create();
                // Setting the title manually
                alert.setTitle("AlertDialogExample");
                alert.show();
            }
        });

    }
}
