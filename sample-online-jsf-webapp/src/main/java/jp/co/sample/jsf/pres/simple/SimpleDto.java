package jp.co.sample.jsf.pres.simple;

import java.io.Serializable;
import javax.faces.view.ViewScoped;
import javax.inject.Named;
import lombok.Data;

@ViewScoped
@Named
@Data
public class SimpleDto implements Serializable {

  private static final long serialVersionUID = 1L;

  private String text;

  private String textarea;

}
