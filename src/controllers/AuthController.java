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
            String correo = view.getUsername(); 
            String contraseña = view.getPassword(); 

            if (model.autenticarUsuario(correo, contraseña)) { 
                JOptionPane.showMessageDialog(view, "¡Inicio de sesión exitoso!");
            } else {
                view.displayErrorMessage("Correo o contraseña inválidos.");
            }
        }
    }
}
