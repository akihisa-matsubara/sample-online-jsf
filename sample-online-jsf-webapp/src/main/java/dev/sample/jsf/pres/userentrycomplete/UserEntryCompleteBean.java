package dev.sample.jsf.pres.userentrycomplete;

import java.io.Serializable;
import javax.faces.view.ViewScoped;
import javax.inject.Named;
import dev.sample.framework.core.interceptor.InvokeConversation;
import dev.sample.framework.core.interceptor.InvokeConversation.Type;
import dev.sample.jsf.pres.BackingBeanBase;

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
