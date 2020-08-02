package dev.sample.jsf.pres.userinfoentry;

import dev.sample.framework.core.constant.Regexp;
import dev.sample.jsf.common.constant.ValidationMessageId;
import java.io.Serializable;
import javax.faces.view.ViewScoped;
import javax.inject.Named;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import lombok.Data;
import lombok.ToString;

/**
 * ユーザー情報登録 画面DTO.
 */
@ViewScoped
@Named
@Data
@ToString(exclude = {"password", "passwordConfirm"})
public class UserInfoEntryDto implements Serializable {

  /** serialVersionUID. */
  private static final long serialVersionUID = 1L;

  /** Username. */
  @Size(max = 40, message = ValidationMessageId.V0001E)
  @Pattern(regexp = Regexp.HALF_NUM_ALPHA, message = ValidationMessageId.V0012E)
  private String username;

  /** Email. */
  @Size(max = 40, message = ValidationMessageId.V0001E)
  @Pattern(regexp = Regexp.EMAIL, message = ValidationMessageId.V0022E)
  private String email;

  /** Password. */
  @Size(max = 15, message = ValidationMessageId.V0001E)
  @Pattern(regexp = Regexp.PW, message = ValidationMessageId.V0021E)
  private String password;

  /** Password(confirm). */
  @Size(max = 15, message = ValidationMessageId.V0001E)
  @Pattern(regexp = Regexp.PW, message = ValidationMessageId.V0021E)
  private String passwordConfirm;

}
