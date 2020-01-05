package jp.co.sample.jsf.pres.login;

import jp.co.sample.framework.core.interceptor.DebugLog;
import jp.co.sample.framework.core.interceptor.OutputTiming;
import jp.co.sample.jsf.code.ViewNameVo;
import jp.co.sample.jsf.constant.ProcessName;
import jp.co.sample.jsf.pres.BackingBeanBase;
import java.io.Serializable;
import javax.faces.view.ViewScoped;
import javax.inject.Named;

/**
 * ログインページBackingBean.
 */
@ViewScoped
@Named
public class LogInBean extends BackingBeanBase implements Serializable {

  /** serialVersionUID. */
  private static final long serialVersionUID = 1L;

  /**
   * 初期化.
   */
  public void init() {
    // do nothing.
  }

  /**
   * SIGN INボタンのアクションメソッド.
   * ●●ページへ遷移します.
   *
   * @return ●●ページのURL
   */
  @DebugLog(outputTiming = OutputTiming.BEGIN, processName = ProcessName.ACTION_SIGN_IN, viewName = ViewNameVo.LOG_IN_VIEW,
      dtoClass = LogInDto.class)
  public String pushSignIn() {
    // TODO 一旦トップページへ
    return redirect(ViewNameVo.TOP_PAGE);
  }

}
