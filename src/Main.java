import controllers.AuthController;
import models.AuthModel;
import views.AuthView;
import java.sql.SQLException;

public class Main {
    public static void main(String[] args) {
        String url = "jdbc:mysql://sql.freedb.tech:3306/freedb_Bella Italia";
        String usuario = "freedb_isaac";
        String contraseña = "tQv#3G2fdCgAuM?";

        try {
            AuthModel model = new AuthModel(url, usuario, contraseña);
            AuthView view = new AuthView();
            AuthController controller = new AuthController(view, model);

            view.setVisible(true);
        } catch (SQLException e) {
            System.err.println("Error al conectar con la base de datos: " + e.getMessage());
        }
    }
}
