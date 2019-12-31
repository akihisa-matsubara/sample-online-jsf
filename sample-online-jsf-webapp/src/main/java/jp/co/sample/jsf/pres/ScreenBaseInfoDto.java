package jp.co.sample.jsf.pres;

import java.io.Serializable;
import javax.faces.view.ViewScoped;
import javax.inject.Named;
import lombok.Data;

@ViewScoped
@Named
@Data
public class ScreenBaseInfoDto implements Serializable {

  private static final long serialVersionUID = 1L;

}
