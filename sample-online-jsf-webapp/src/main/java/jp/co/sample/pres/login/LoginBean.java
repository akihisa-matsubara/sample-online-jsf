package jp.co.sample.pres.login;

import jp.co.sample.pres.BaseBackingBean;
import jp.co.sample.pres.code.ScreenViewNameVo;
import jp.co.sample.pres.login.dto.LoginDto;
import java.io.Serializable;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

@ViewScoped
@Named
public class LoginBean extends BaseBackingBean implements Serializable {

  private static final long serialVersionUID = 1L;

  @Inject
  private LoginDto dto;

  public void init() {
    // empty.
  }

  public String pushSignIn() {
    System.out.println(dto);
    return redirect(ScreenViewNameVo.SIMPLE);
  }

}
