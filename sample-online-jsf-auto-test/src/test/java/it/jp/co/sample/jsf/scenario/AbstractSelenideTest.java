package it.jp.co.sample.jsf.scenario;

import static com.codeborne.selenide.Selenide.*;
import com.codeborne.selenide.Configuration;
import it.jp.co.sample.jsf.utils.ScreenshotSupport;

public abstract class AbstractSelenideTest {

  protected static final String BLANK = "";

  /** report path format. */
  protected static final String REPORT_PATH_FORMAT = "test-results/reports/%s/%s_%s";

  /** validation successfull. */
  protected static final String VALID = "valid";
  /** validation failed. */
  protected static final String INVALID = "invalid";

  /** action. */
  private static final String INIT = "initial";
  private static final String VALIDATION = "validation";
  protected static final String BACK = "back_button";
  protected static final String NEXT = "next_button";

  // report
  public void setReportsFolder(String testNo, String desc) {
    Configuration.reportsFolder = String.format(REPORT_PATH_FORMAT, this.getClass().getSimpleName(), testNo, desc);
  }

  // screenshot
  public static void takeScreenshotInit() {
    ScreenshotSupport.takeScreenshotFull(INIT);
  }

  public static void takeScreenshotInvalidAfter() {
    ScreenshotSupport.takeScreenshotFull(VALIDATION);
  }

  public static void takeScreenshotActionBefore(String action) {
    ScreenshotSupport.takeScreenshotFull("before_" + action + "_action");
  }

  // fire event
  protected void blur() {
    executeJavaScript("document.activeElement.blur()");
  }

}
