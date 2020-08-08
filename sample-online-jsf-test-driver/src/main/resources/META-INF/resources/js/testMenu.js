/* global sampleRoot */

/**
 * 初期処理
 */
$(() => {
  // ビュー名
  $('#viewName').off('change.viewName');
  $('#viewName').on('change.viewName', (e) => {
    sampleRoot.fileUpload.clear('jsonFile');
  });
});
