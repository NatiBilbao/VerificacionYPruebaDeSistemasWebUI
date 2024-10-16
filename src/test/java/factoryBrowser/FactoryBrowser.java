package factoryBrowser;

public class FactoryBrowser {
    public static IBrowser make(String type){
        IBrowser browser;
        switch (type.toLowerCase()){
            case "firefox":
                browser = new Firefox();
                break;
            case "edge":
                browser = new Edge();
                break;
            default:
                browser = new Chrome();
                break;
        }
        return browser;
    }
}
