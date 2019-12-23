package jp.co.sample.pres.errorpage;

import jp.co.sample.pres.BaseBackingBean;
import java.io.Serializable;
import javax.faces.view.ViewScoped;
import javax.inject.Named;

@ViewScoped
@Named
public class ErrorPageBean extends BaseBackingBean implements Serializable {

  private static final long serialVersionUID = 1L;

  public void init() {
    // empty.
  }

  public String pushGoToTopPage() {
    return goToTopPage();
  }

}
