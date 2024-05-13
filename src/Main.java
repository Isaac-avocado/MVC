import controllers.AuthController;
import models.AuthModel;
import views.AuthView;

public class Main {
    public static void main(String[] args) {
        AuthModel model = new AuthModel();
        AuthView view = new AuthView();
        AuthController controller = new AuthController(view, model);

        view.setVisible(true);
    }
}