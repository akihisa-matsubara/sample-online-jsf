package it.jp.co.sample.jsf;

import static com.codeborne.selenide.Selenide.*;
import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;

public abstract class AbstractTestBase {

  /** screenshot name format. */
  private static final String SS_FORMAT = "%03d-%s-%s";
  /** report path format. */
  protected static final String REPORT_PATH_FORMAT = "test-results/reports/%s/%s_%s";

  /** validation successfull. */
  protected static final String VALID = "valid";
  /** validation failed. */
  protected static final String INVALID = "invalid";

  protected static final String BLANK = "";

  /** action. */
  protected static final String INIT = "initial";
  protected static final String VALIDATION = "validation";
  protected static final String BACK = "back_button";
  protected static final String NEXT = "next_button";

  /** screen shot counter. */
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

  // Screen Shot
  protected void doScreenshotInit() {
    doScreenshotFull(INIT);
  }

  protected void doScreenshotInvalidAfter() {
    doScreenshotFull(VALIDATION);
  }

  protected void doScreenshotActionBefore(String action) {
    doScreenshotFull("before_" + action + "_action");
  }

  private void doScreenshot(String action) {
    screenshot(String.format(SS_FORMAT, ssCounter, title().replaceAll(" ", "_"), action));
    ssCounter++;
  }

  private void doScreenshotFull(String action) {
    executeJavaScript("$(window).scrollTop(0)");
    doScreenshot(action);

    int windowHeight = ((Long) executeJavaScript("return $(window).height()")).intValue();
    int formHeight = ((Long) executeJavaScript("return $('#mainForm')[0].scrollHeight")).intValue();
    for (int i = 0; i < formHeight / windowHeight; i++) {
      executeJavaScript("$(window).scrollTop(" + (windowHeight * (i + 1)) + ")");
      doScreenshot(action);
    }
  }

  // fire event
  protected void blur() {
    executeJavaScript("document.activeElement.blur()");
  }

  // othre
  protected String classname() {
    return this.getClass().getSimpleName();
  }

  protected String methodname() {
    return Thread.currentThread().getStackTrace()[3].getMethodName();
  }

}
