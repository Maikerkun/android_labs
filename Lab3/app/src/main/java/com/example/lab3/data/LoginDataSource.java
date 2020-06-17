package com.example.lab3.data;

import com.example.lab3.data.model.LoggedInUser;

import java.io.IOException;

/**
 * Class that handles authentication w/ login credentials and retrieves user information.
 */
public class LoginDataSource {

    String[] DUMMY = {"Maik", "123"};

    public Result<LoggedInUser> login(String username, String password) {

        try {

            if (DUMMY[0].equals(username) && DUMMY[1].equals(password)) {
                LoggedInUser fakeUser =
                        new LoggedInUser(
                                java.util.UUID.randomUUID().toString(),
                                DUMMY[0]);
                return new Result.Success<>(fakeUser);
            }
            return new Result.Error(new IOException("Invalid credentials"));
            // TODO: handle loggedInUser authentication
        } catch (Exception e) {
            return new Result.Error(new IOException("Error logging in", e));
        }
    }

    public void logout() {
        // TODO: revoke authentication
    }
}