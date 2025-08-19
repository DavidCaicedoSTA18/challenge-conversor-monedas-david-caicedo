import modelos.MenuConversor;

public class Principal {

    public static void main(String[] args) {
        try {
            MenuConversor menu = new MenuConversor();
            menu.iniciar();
        } catch (Exception e) {
            System.err.println("Error al iniciar la aplicación: " + e.getMessage());
            e.printStackTrace();
        }
    }
}
