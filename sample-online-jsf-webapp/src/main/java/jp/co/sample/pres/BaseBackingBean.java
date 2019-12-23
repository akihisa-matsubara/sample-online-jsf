package jp.co.sample.pres;

import jp.co.sample.pres.code.ScreenViewNameVo;

public abstract class BaseBackingBean {

  protected String redirect(ScreenViewNameVo vo) {
    return String.format("/pages/%s?faces-redirect=true", vo.getDecode());
  }

  public String goToTopPage() {
    return redirect(ScreenViewNameVo.TOP_PAGE);
  }

  public String pushLoginPage() {
    return redirect(ScreenViewNameVo.LOGIN);
  }

}
