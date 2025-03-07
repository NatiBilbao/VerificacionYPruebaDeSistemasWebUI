package tareas.tarea11.factoryBrowser;

public class FactoryBrowser {
    public static IBrowser make(String type) {
        IBrowser browser;

        switch (type.toLowerCase()) {
            case "edge":
                browser = new Edge();
                break;
            case "firefox":
                browser = new FireFox();
                break;
            default:
                browser = new Chrome();
                break;
        }

        return browser;

    }
}
