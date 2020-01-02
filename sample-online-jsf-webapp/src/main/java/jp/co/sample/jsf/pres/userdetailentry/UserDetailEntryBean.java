package jp.co.sample.jsf.pres.userdetailentry;

import jp.co.sample.jsf.code.ViewNameVo;
import jp.co.sample.jsf.pres.BackingBeanBase;
import java.io.Serializable;
import javax.faces.view.ViewScoped;
import javax.inject.Named;

@ViewScoped
@Named
public class UserDetailEntryBean extends BackingBeanBase implements Serializable {

  private static final long serialVersionUID = 1L;

  public void init() {
    // do nothing.
  }

  public String pushBack() {
    return redirect(ViewNameVo.USER_INFO_ENTRY);
  }

  public String pushNext() {
    return redirect(ViewNameVo.TOP_PAGE);
  }

}
