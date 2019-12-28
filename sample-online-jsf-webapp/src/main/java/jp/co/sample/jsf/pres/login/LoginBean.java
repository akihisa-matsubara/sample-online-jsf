package jp.co.sample.jsf.pres.login;

import jp.co.sample.jsf.pres.BackingBeanBase;
import jp.co.sample.jsf.pres.code.ViewNameVo;
import jp.co.sample.jsf.pres.login.dto.LoginDto;
import java.io.Serializable;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

@ViewScoped
@Named
public class LoginBean extends BackingBeanBase implements Serializable {

  private static final long serialVersionUID = 1L;

  @Inject
  private LoginDto dto;

  public void init() {
    // empty.
  }

  public String pushSignIn() {
    System.out.println(dto);
    return redirect(ViewNameVo.SIMPLE);
  }

}
