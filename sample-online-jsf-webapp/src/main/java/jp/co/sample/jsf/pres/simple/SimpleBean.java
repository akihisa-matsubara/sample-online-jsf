package jp.co.sample.jsf.pres.simple;

import jp.co.sample.jsf.pres.BackingBeanBase;
import jp.co.sample.jsf.pres.simple.dto.SimpleDto;
import java.io.Serializable;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;
import lombok.extern.slf4j.Slf4j;

@ViewScoped
@Named
@Slf4j
public class SimpleBean extends BackingBeanBase implements Serializable {

  private static final long serialVersionUID = 1L;

  @Inject
  private SimpleDto screenDto;

  public void init() {
    log.debug("called init: " + this);
  }

  public void action() {
    log.debug("called action: " + this);
    screenDto.setText("action");
  }

  public String redirect() {
    log.debug("called redirect: " + this);
    screenDto.setText("redirect");
    return "/pages/simple.xhtml";
  }

}
