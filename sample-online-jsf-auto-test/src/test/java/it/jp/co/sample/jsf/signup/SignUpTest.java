package it.jp.co.sample.jsf.signup;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.*;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.junit5.ScreenShooterExtension;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import it.jp.co.sample.jsf.AbstractTestBase;
import it.jp.co.sample.jsf.page.signup.UserDetailEntry;
import it.jp.co.sample.jsf.page.signup.UserEntryInfoConfirm;
import it.jp.co.sample.jsf.page.signup.UserInfoEntry;
import it.jp.co.sample.jsf.page.top.TopPage;

@ExtendWith({ScreenShooterExtension.class})
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class SignUpTest extends AbstractTestBase {

  @DisplayName("ユーザー登録シナリオテスト")
  @Nested
  class SignUpScenario {
    @DisplayName("正常系")
    @ParameterizedTest
    @CsvFileSource(resources = "/data/SignUpScenario.csv", numLinesToSkip = 1)
    void test(String testNo, String desc, String username, String password, String nameKanji, String nameKana, String gender, String birthday,
        String addressZip, String address) {
      // スクリーンショットの出力先変更
      Configuration.reportsFolder = String.format(REPORT_PATH_FORMAT, classname(), testNo, desc);

      // -- top page ---------------------------
      TopPage topPage = open("/", TopPage.class);
      doScreenshotInit();
      scrollToBottom();
      doScreenshotInit();
      topPage.SignUp.click();

      // -- user info entry --------------------
      UserInfoEntry userInfoEntry = page(UserInfoEntry.class);
      doScreenshotInit();
      userInfoEntry.Username.val(username);
      userInfoEntry.Password.val(password);
      blur();
      userInfoEntry.Username.should(cssClass(VALID));
      userInfoEntry.Password.should(cssClass(VALID));
      doScreenshotActionBefore(NEXT);
      userInfoEntry.Next.click();

      // -- user detail entry ------------------
      UserDetailEntry userDetailEntry = page(UserDetailEntry.class);
      doScreenshotInit();
      userDetailEntry.NameKanji.val(nameKanji);
      userDetailEntry.NameKana.val(nameKana);
      userDetailEntry.Gender.get(UserDetailEntry.genderOrderMap.get(gender)).parent().click();
      userDetailEntry.Birthday.val(birthday);
      userDetailEntry.AddressZip.val(addressZip);
      userDetailEntry.Address.val(address);
      blur();
      userDetailEntry.NameKanji.should(cssClass(VALID));
      userDetailEntry.NameKana.should(cssClass(VALID));
      userDetailEntry.Birthday.should(cssClass(VALID));
      userDetailEntry.AddressZip.should(cssClass(VALID));
      userDetailEntry.Address.should(cssClass(VALID));
      doScreenshotActionBefore(NEXT);
      scrollToBottom();
      doScreenshotActionBefore(NEXT);
      userDetailEntry.Next.click();

      // -- user entry info confirm ------------
      UserEntryInfoConfirm userEntryInfoConfirm = page(UserEntryInfoConfirm.class);
      doScreenshotInit();
      scrollToBottom();
      doScreenshotInit();
      userEntryInfoConfirm.Confirmed.click();

      // -- user entry complete ----------------
      doScreenshotInit();
      $("h5").shouldHave(text("Created your account!!"));
    }
  }

}
