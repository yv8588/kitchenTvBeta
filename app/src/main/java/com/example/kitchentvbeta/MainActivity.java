/**
 * @version 2.0
 * @author yoad wolfson.
 */
package com.example.kitchentvbeta;

import static com.example.kitchentvbeta.FBREF.AUTH;

import android.content.Intent;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.FragmentActivity;

import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;

import java.util.LinkedList;
import java.util.Queue;

public class MainActivity extends FragmentActivity {
    EditText password,mail;
    String p,m;
    boolean prove;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        password=(EditText)findViewById(R.id.password);
        mail=(EditText)findViewById(R.id.mail);

    }
    /**
     * when sign in button clicked creats user.
     * @param mail users email.
     * @param password users password.
     */
    public void sign(String mail,String password){
        AUTH.signInWithEmailAndPassword(mail, password).addOnCompleteListener((@NonNull Task<AuthResult> task) -> {

            if (task.isSuccessful()) {
                prove = true;
                Toast.makeText(MainActivity.this,"user signed in",Toast.LENGTH_SHORT).show();
                Intent si=new Intent(MainActivity.this,Bons.class);
                startActivity(si);
            }
            else {
                prove = false;
                Toast.makeText(MainActivity.this,"sign in failed",Toast.LENGTH_SHORT).show();
            }

        });
    }

    /**
     * when the button get clicked signs user in.
     * @param view the sign in button.
     */
    public void signIn(View view) {
        p=password.getText().toString();
        m=mail.getText().toString();
        if(m==null){
            Toast.makeText(MainActivity.this, "enter mail", Toast.LENGTH_SHORT).show();
        }
        else if(p==null){
            Toast.makeText(MainActivity.this, "enter password", Toast.LENGTH_SHORT).show();
        }
        else {
            mail.setText("");
            password.setText("");
            mail.setHint("mail");
            password.setHint("password");
            sign(m,p);
        }
    }
}