package jp.co.sample.jsf.pres.errorpage;

import jp.co.sample.jsf.pres.BackingBeanBase;
import java.io.Serializable;
import javax.faces.view.ViewScoped;
import javax.inject.Named;

@ViewScoped
@Named
public class ErrorPageBean extends BackingBeanBase implements Serializable {

  private static final long serialVersionUID = 1L;

  public void init() {
    // empty.
  }

  public String pushGoToTopPage() {
    return goToTopPage();
  }

}
