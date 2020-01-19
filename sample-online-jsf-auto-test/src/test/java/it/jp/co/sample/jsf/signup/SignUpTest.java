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
    @DisplayName("画面レイアウト確認・単項目チェックOK")
    @ParameterizedTest
    @CsvFileSource(resources = "/data/SignUpScenario.csv", numLinesToSkip = 1)
    void test(String testNo, String desc, String username, String email, String password, String nameKanji, String nameKana, String gender, String birthday,
        String addressZip, String address) {
      // スクリーンショットの出力先変更
      Configuration.reportsFolder = String.format(REPORT_PATH_FORMAT, classname(), testNo, desc);

      // -- top page ---------------------------
      TopPage topPage = open("/", TopPage.class);
      doScreenshotInit();
      topPage.SignUp.click();

      // -- user info entry --------------------
      UserInfoEntry userInfoEntry = page(UserInfoEntry.class);
      doScreenshotInit();
      userInfoEntry.Username.val(username);
      userInfoEntry.Email.val(email);
      userInfoEntry.Password.val(password);
      userInfoEntry.PasswordConfirm.val(password);
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
      userDetailEntry.Next.click();

      // -- user entry info confirm ------------
      UserEntryInfoConfirm userEntryInfoConfirm = page(UserEntryInfoConfirm.class);
      doScreenshotInit();
      userEntryInfoConfirm.Confirmed.click();

      // -- user entry complete ----------------
      doScreenshotInit();
      $("h5").shouldHave(text("Created your account!!"));
    }
  }

  @DisplayName("ユーザー登録（単項目チェックNG）シナリオテスト")
  @Nested
  class SignUpValidationScenario {
    @DisplayName("単項目チェックNGメッセージ確認")
    @ParameterizedTest
    @CsvFileSource(resources = "/data/SignUpValidationScenario.csv", numLinesToSkip = 1)
    void test(String testNo, String desc, String username, String email, String password, String nameKanji, String nameKana, String addressZip,
        String address) {
      // スクリーンショットの出力先変更
      Configuration.reportsFolder = String.format(REPORT_PATH_FORMAT, classname(), testNo, desc);

      // -- top page ---------------------------
      TopPage topPage = open("/", TopPage.class);
      doScreenshotInit();
      topPage.SignUp.click();

      // -- user info entry --------------------
      UserInfoEntry userInfoEntry = page(UserInfoEntry.class);
      doScreenshotInit();
      userInfoEntry.Username.val(username);
      userInfoEntry.Email.val(email);
      userInfoEntry.Password.val(password);
      userInfoEntry.PasswordConfirm.val(password);
      blur();
      userInfoEntry.Username.should(cssClass(INVALID));
      userInfoEntry.Email.should(cssClass(INVALID));
      userInfoEntry.Password.should(cssClass(INVALID));
      userInfoEntry.PasswordConfirm.should(cssClass(INVALID));
      doScreenshotInvalidAfter();

      userInfoEntry.Username.val(BLANK);
      userInfoEntry.Email.val(BLANK);
      userInfoEntry.Password.val(BLANK);
      userInfoEntry.PasswordConfirm.val(BLANK);
      blur();
      doScreenshotActionBefore(NEXT);
      userInfoEntry.Next.click();

      // -- user detail entry ------------------
      UserDetailEntry userDetailEntry = page(UserDetailEntry.class);
      doScreenshotInit();
      userDetailEntry.NameKanji.val(nameKanji);
      userDetailEntry.NameKana.val(nameKana);
      userDetailEntry.AddressZip.val(addressZip);
      userDetailEntry.Address.val(address);
      blur();
      userDetailEntry.NameKanji.should(cssClass(INVALID));
      userDetailEntry.NameKana.should(cssClass(INVALID));
      userDetailEntry.AddressZip.should(cssClass(INVALID));
      userDetailEntry.Address.should(cssClass(INVALID));
      doScreenshotInvalidAfter();

      userDetailEntry.NameKanji.val(BLANK);
      userDetailEntry.NameKana.val(BLANK);
      userDetailEntry.AddressZip.val(BLANK);
      userDetailEntry.Address.val(BLANK);
      blur();
      doScreenshotActionBefore(NEXT);
      userDetailEntry.Next.click();

      // -- user entry info confirm ------------
      UserEntryInfoConfirm userEntryInfoConfirm = page(UserEntryInfoConfirm.class);
      doScreenshotInit();
      userEntryInfoConfirm.Confirmed.click();

      // -- user entry complete ----------------
      doScreenshotInit();
      $("h5").shouldHave(text("Created your account!!"));
    }
  }
}
