;
'use strict';

// Note: selector is not escqpe.

/**
 * 初期処理
 */
$(function() {
  const INDIVIDUAL = '1', JAPAN = '0386', HIDE = 'hide';

  // 個人・法人
  $('input[name="individualCorporation"]').off();
  $('input[name="individualCorporation"]').on('change.individualCorporation', function() {
    if ($(this).val() === INDIVIDUAL) {
      $('#corpInfoEntryArea').addClass(HIDE);
      $('#indivInfoEntryArea').removeClass(HIDE);
    } else {
      $('#indivInfoEntryArea').addClass(HIDE);
      $('#corpInfoEntryArea').removeClass(HIDE);
    }
  });

  // 国籍
  $('#indiv-nationality').off('change.indiv-nationality');
  $('#indiv-nationality').on('change.indiv-nationality', function() {
    if ($(this).val() === JAPAN) {
      $('#indiv-permanentResidencyArea').addClass(HIDE);
    } else {
      $('#indiv-permanentResidencyArea').removeClass(HIDE);
    }
  });

});
