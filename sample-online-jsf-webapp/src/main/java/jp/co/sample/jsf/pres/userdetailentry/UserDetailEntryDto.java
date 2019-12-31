package jp.co.sample.jsf.pres.userdetailentry;

import jp.co.sample.common.code.GenderVo;
import jp.co.sample.common.util.CodeUtils;
import jp.co.sample.framework.jsf.util.ComponentUtils;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;
import javax.faces.model.SelectItem;
import javax.faces.view.ViewScoped;
import javax.inject.Named;
import lombok.Data;

@ViewScoped
@Named
@Data
public class UserDetailEntryDto implements Serializable {

  private static final long serialVersionUID = 1L;

  private String nameKanji;

  private String nameKana;

  private GenderVo gender;

  private LocalDate birthday;

  private String addressZip;

  private String address;

  public String getGender() {
    return gender == null ? "" : gender.getCode();
  }

  public void setGender(String genderCode) {
    this.gender = CodeUtils.decode(genderCode, GenderVo.class);
  }

  public List<SelectItem> getGenderItems() {
    return ComponentUtils.items(GenderVo.class);
  }

}
