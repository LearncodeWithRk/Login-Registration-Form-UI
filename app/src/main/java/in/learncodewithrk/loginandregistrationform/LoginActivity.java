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

public class LoginActivity extends AppCompatActivity {
    Button requestButton;
    TextView alreadySignup,reset_password;
    private AwesomeValidation awesomeValidation;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        reset_password = (TextView)findViewById(R.id.reset_password);
        reset_password.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent streamIntent = new Intent(LoginActivity.this,ForgetPassword.class);
                startActivity(streamIntent);
            }
        });

        awesomeValidation = new AwesomeValidation(ValidationStyle.BASIC);

        requestButton = (Button) findViewById(R.id.buttonLogin);
        alreadySignup = (TextView) findViewById(R.id.already_signup);
        requestButton.setOnClickListener(mMyListener);
        alreadySignup.setOnClickListener(mMyListener);

        awesomeValidation.addValidation(this, R.id.editTextEmail, Patterns.EMAIL_ADDRESS, R.string.emailerror);
    }
    private View.OnClickListener mMyListener = new View.OnClickListener() {
        public void onClick(View v) {
            switch (v.getId() /*to get clicked view id**/) {
                case R.id.buttonSubmit:
                    if (awesomeValidation.validate()) {
                        Toast.makeText(getApplicationContext(), "Login In Working!", Toast.LENGTH_LONG).show();
                    }
                    break;
                case R.id.already_signup:
                    Intent i = new Intent(getApplicationContext(), MainActivity.class);
                    startActivity(i);
                    break;
                default:
                    break;
            }
        }
    };
}
