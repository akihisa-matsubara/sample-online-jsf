package dev.sample.jsf.pres.toppage;

import java.io.Serializable;
import javax.faces.view.ViewScoped;
import javax.inject.Named;
import dev.sample.framework.core.interceptor.InvokeConversation;
import dev.sample.framework.core.interceptor.InvokeConversation.Type;
import dev.sample.jsf.pres.BackingBeanBase;

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
