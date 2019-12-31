package jp.co.sample.jsf.pres.login;

import jp.co.sample.framework.core.constant.Regexp;
import jp.co.sample.jsf.constant.ValidationMessageId;
import java.io.Serializable;
import javax.faces.view.ViewScoped;
import javax.inject.Named;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import lombok.Data;

@ViewScoped
@Named
@Data
public class LogInDto implements Serializable {

  private static final long serialVersionUID = 1L;

  @Size(max = 40, message = ValidationMessageId.V0001E)
  @Pattern(regexp = Regexp.NUM_ALPHA, message = ValidationMessageId.V0002E)
  private String username;

  @Size(max = 15, message = ValidationMessageId.V0001E)
  @Pattern(regexp = Regexp.PW, message = ValidationMessageId.V0003E)
  private String password;

}
