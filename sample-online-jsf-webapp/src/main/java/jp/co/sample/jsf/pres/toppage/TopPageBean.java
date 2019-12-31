package jp.co.sample.jsf.pres.toppage;

import jp.co.sample.jsf.pres.BackingBeanBase;
import java.io.Serializable;
import javax.faces.view.ViewScoped;
import javax.inject.Named;

@ViewScoped
@Named
public class TopPageBean extends BackingBeanBase implements Serializable {

  private static final long serialVersionUID = 1L;

  public void init() {
    // do nothing.
  }

}
