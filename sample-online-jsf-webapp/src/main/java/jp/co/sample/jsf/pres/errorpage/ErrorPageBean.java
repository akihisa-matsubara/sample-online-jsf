package jp.co.sample.jsf.pres.errorpage;

import jp.co.sample.jsf.pres.BackingBeanBase;
import java.io.Serializable;
import javax.faces.view.ViewScoped;
import javax.inject.Named;

/**
 * エラーページ BackingBean.
 */
@ViewScoped
@Named
public class ErrorPageBean extends BackingBeanBase implements Serializable {

  /** serialVersionUID. */
  private static final long serialVersionUID = 1L;

  /**
   * 初期化.
   */
  public void init() {
    // do nothing.
  }

  /**
   * Go TO TOP PAGEボタンのアクションメソッド.
   * トップページへ遷移します.
   *
   * @return トップページのURL
   */
  public String pushGoToTopPage() {
    return goToTopPage();
  }

}
