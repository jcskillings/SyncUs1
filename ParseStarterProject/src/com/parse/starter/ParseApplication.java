package com.parse.starter;

import android.app.Application;

import com.parse.Parse;
import com.parse.ParseACL;
import com.parse.ParseCrashReporting;
import com.parse.ParseException;
import com.parse.ParseUser;
import com.parse.SignUpCallback;

public class ParseApplication extends Application {

  @Override
  public void onCreate() {
    super.onCreate();

    // Initialize Crash Reporting.
    ParseCrashReporting.enable(this);

    // Enable Local Datastore.
    Parse.enableLocalDatastore(this);

    // Add your initialization code here
    Parse.initialize(this, "S853VeY0ISR12ujFxD6vAN2CL1x1yzRDCSXSOtq1", "g4XHz7D1WubgNX8EUD9EouHdVHqgbGTmi8DKaq75");


    ParseUser.enableAutomaticUser();
    ParseACL defaultACL = new ParseACL();
    // Optionally enable public read access.
    // defaultACL.setPublicReadAccess(true);
    ParseACL.setDefaultACL(defaultACL, true);

      ParseUser user = new ParseUser();
      user.setUsername("my name");
      user.setPassword("my pass");
      user.setEmail("email@example.com");

// other fields can be set just like with ParseObject
      user.put("email", "jcskillings@gmail.com");

      user.signUpInBackground(new SignUpCallback() {
          public void done(ParseException e) {
              if (e == null) {
                  // Hooray! Let them use the app now.
              } else {
                  // Sign up didn't succeed. Look at the ParseException
                  // to figure out what went wrong
              }
          }
      });


  }
}
