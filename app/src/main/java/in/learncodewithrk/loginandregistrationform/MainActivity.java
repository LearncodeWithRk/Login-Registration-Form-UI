package in.learncodewithrk.loginandregistrationform;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.basgeekball.awesomevalidation.AwesomeValidation;
import com.basgeekball.awesomevalidation.ValidationStyle;

public class MainActivity extends AppCompatActivity {
    Button requestButton;
    TextView alreadySignin;
    private AwesomeValidation awesomeValidation;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        awesomeValidation = new AwesomeValidation(ValidationStyle.BASIC);

        requestButton = (Button) findViewById(R.id.buttonSubmit);
        alreadySignin = (TextView) findViewById(R.id.already_signin);
        requestButton.setOnClickListener(mMyListener);
        alreadySignin.setOnClickListener(mMyListener);

        String regexPassword = "(?=.*[a-z])(?=.*[A-Z])(?=.*[\\d])(?=.*[~`!@#\\$%\\^&\\*\\(\\)\\-_\\+=\\{\\}\\[\\]\\|\\;:\"<>,./\\?]).{8,}";
        //adding validation to edit texts
        awesomeValidation.addValidation(this, R.id.editTextName, "^[A-Za-z\\s]{1,}[\\.]{0,1}[A-Za-z\\s]{0,}$", R.string.nameerror);
        awesomeValidation.addValidation(this, R.id.editTextEmail, Patterns.EMAIL_ADDRESS, R.string.emailerror);
        awesomeValidation.addValidation(this, R.id.editTextMobile, "^[2-9]{2}[0-9]{8}$", R.string.mobileerror);
        awesomeValidation.addValidation(this, R.id.editPassword, regexPassword, R.string.passworderror);
    }
    private View.OnClickListener mMyListener = new View.OnClickListener() {
        public void onClick(View v) {
            switch (v.getId()) {
                case R.id.buttonSubmit:
                    if (awesomeValidation.validate()) {
                        Toast.makeText(getApplicationContext(), "Working!", Toast.LENGTH_LONG).show();
                    }
                    break;
                case R.id.already_signin:
                    Intent i = new Intent(getApplicationContext(), LoginActivity.class);
                    startActivity(i);
                    break;
                default:
                    break;
            }
        }
    };

}