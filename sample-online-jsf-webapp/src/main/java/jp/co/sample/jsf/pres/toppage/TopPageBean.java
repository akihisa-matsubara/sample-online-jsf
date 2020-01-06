package jp.co.sample.jsf.pres.toppage;

import jp.co.sample.framework.core.interceptor.InvokeConversation;
import jp.co.sample.framework.core.interceptor.InvokeConversation.Type;
import jp.co.sample.jsf.pres.BackingBeanBase;
import java.io.Serializable;
import javax.faces.view.ViewScoped;
import javax.inject.Named;

/**
 * トップページ BackingBean.
 */
@ViewScoped
@Named
public class TopPageBean extends BackingBeanBase implements Serializable {

  /** serialVersionUID. */
  private static final long serialVersionUID = 1L;

  /**
   * 初期化.
   */
  @InvokeConversation(type = Type.END)
  public void init() {
    // do nothing.
  }

}
