package jp.co.sample.pres.simple.dto;

import java.io.Serializable;
import javax.faces.view.ViewScoped;
import javax.inject.Named;
import lombok.Data;

@ViewScoped
@Named
@Data
public class SimpleDto implements Serializable {

  private static final long serialVersionUID = 1L;

  private String text = "default value";

  private String textarea;

}
