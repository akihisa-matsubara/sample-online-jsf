package jp.co.sample.jsf.pres.userentrycomplete;

import jp.co.sample.framework.core.interceptor.InvokeConversation;
import jp.co.sample.framework.core.interceptor.InvokeConversation.Type;
import jp.co.sample.jsf.pres.BackingBeanBase;
import java.io.Serializable;
import javax.faces.view.ViewScoped;
import javax.inject.Named;

/**
 * ユーザー情報登録 BackingBean.
 */
@ViewScoped
@Named
public class UserEntryCompleteBean extends BackingBeanBase implements Serializable {

  /** serialVersionUID. */
  private static final long serialVersionUID = 1L;

  /**
   * 初期化.
   */
  @InvokeConversation(type = Type.END)
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
