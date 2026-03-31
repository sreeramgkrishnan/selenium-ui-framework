package constants;

public enum Browser {

CHROME("chrome"),
FIREFOX("firefox"),
EDGE("edge");

private final String browserName;

Browser(String browserName) {
    this.browserName = browserName;
}
public String getBrowser() {
    return browserName;
}
}
