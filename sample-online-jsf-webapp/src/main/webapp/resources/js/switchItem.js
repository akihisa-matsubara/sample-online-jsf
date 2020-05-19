// Note: selector is not escape.

/**
 * 初期処理
 */
$(() => {
  const INDIVIDUAL = '1';
  const JAPAN = '0386';
  const HIDE = 'hide';

  // 個人・法人
  $('input[name="individualCorporation"]').off();
  $('input[name="individualCorporation"]').on('change.individualCorporation', (e) => {
    if ($(e.currentTarget).val() === INDIVIDUAL) {
      $('#corpInfoEntryArea').addClass(HIDE);
      $('#indivInfoEntryArea').removeClass(HIDE);
    } else {
      $('#indivInfoEntryArea').addClass(HIDE);
      $('#corpInfoEntryArea').removeClass(HIDE);
    }
  });

  // 国籍
  $('#indiv-nationality').off('change.indiv-nationality');
  $('#indiv-nationality').on('change.indiv-nationality', (e) => {
    if ($(e.currentTarget).val() === JAPAN) {
      $('#indiv-permanentResidencyArea').addClass(HIDE);
    } else {
      $('#indiv-permanentResidencyArea').removeClass(HIDE);
    }
  });
});
