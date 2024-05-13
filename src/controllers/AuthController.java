package controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import models.AuthModel;
import views.AuthView;

public class AuthController {
    private AuthView view;
    private AuthModel model;

    public AuthController(AuthView view, AuthModel model) {
        this.view = view;
        this.model = model;

        this.view.addLoginListener(new LoginListener());
    }

    class LoginListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            String username = view.getUsername();
            String password = view.getPassword();

            if (model.authenticate(username, password)) {
                JOptionPane.showMessageDialog(view, "Login successful!");
            } else {
                view.displayErrorMessage("Invalid username or password.");
            }
        }
    }
}
