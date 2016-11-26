package cs.b07.flightapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    public final static String EXTRA_MESSAGE = "com.example.myfirstapp.MESSAGE";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    /** Called when the user clicks the Login button */
    public void login(View view) {
        Intent intent = new Intent(this, DisplayMessageActivity.class);

        EditText userNameObj = (EditText) findViewById(R.id.userName);
        String userNameStr = userNameObj.getText().toString();

        EditText passWordObj = (EditText) findViewById(R.id.passWord);
        String passWordStr = passWordObj.getText().toString();

        CheckLogin userExist = new CheckLogin(userNameStr, passWordStr);

        if (userExist.loginChecker(this)){

            //Need to edit still
            intent.putExtra(EXTRA_MESSAGE, userNameStr);
            startActivity(intent);
        }

    }
}
