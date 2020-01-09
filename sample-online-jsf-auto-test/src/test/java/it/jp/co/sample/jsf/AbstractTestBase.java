package it.jp.co.sample.jsf;

import static com.codeborne.selenide.Selenide.*;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.SelenideElement;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;

public abstract class AbstractTestBase {

  /** screenshot name format. */
  private final String SS_FORMAT = "%03d-%s-%s";
  /** screenshot name format. */
  protected final String REPORT_PATH_FORMAT = "test-results/reports/%s/%s_%s";

  /** validation successfull. */
  protected final String VALID = "valid";
  /** validation failed. */
  protected final String INVALID = "invalid";

  private final String BOTTOM_CLASS = "footer-copyright";

  /** action. */
  protected final String INIT = "initial";
  protected final String BACK = "back_button";
  protected final String NEXT = "next_button";

  private int ssCounter = 1;

  @BeforeAll
  static void initAll() {
    // ベースURLを変更する (デフォルト:http://localhost:8080)
    Configuration.baseUrl = "http://localhost:9080/sample-online-jsf-webapp";
    // 利用ブラウザを変更する場合（デフォルト：Chrome）
    // Configuration.browser = Browsers.FIREFOX;
    // テストを実行した後、ブラウザーウィンドウは開いたままにする場合
    // Configuration.holdBrowserOpen = true;
    // 起動時にwindowサイズを最大化
    Configuration.startMaximized = true;
    // windowサイズを変更する場合（デフォルト：1366x768）
    // Configuration.browserSize = "1024x768";
    // Proxyサーバー利用する場合
    // Configuration.proxyEnabled = true;
    // Configuration.proxyHost = "127.0.0.1";
    // Configuration.proxyPort = 8888;
    // Selenium Gridを使用する場合
    // Configuration.remote = "http://localhost:5678/wd/hub";
  }

  @BeforeEach
  void init() {
    ssCounter = 1;
  }

  protected void doScreenshotInit() {
    doScreenshot(INIT);
  }

  protected void doScreenshotActionBefore(String action) {
    doScreenshot("before_" + action + "_action");
  }

  private void doScreenshot(String action) {
    screenshot(String.format(SS_FORMAT, ssCounter, title().replaceAll(" ", "_"), action));
    ssCounter++;
  }

  private SelenideElement bottomSelector() {
    return $("." + BOTTOM_CLASS);
  }

  protected void scrollToBottom() {
    bottomSelector().scrollTo();
  }

  protected void blur() {
    executeJavaScript("document.activeElement.blur()");
  }

  protected String classname() {
    return this.getClass().getSimpleName();
  }

  protected String methodname() {
    return Thread.currentThread().getStackTrace()[3].getMethodName();
  }
}
