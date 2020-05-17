// npx gulp
// npx gulp watch

const gulp = require('gulp');
const sass = require('gulp-sass');
const plumber = require('gulp-plumber');
const notify = require('gulp-notify');
const sassGlob = require('gulp-sass-glob');
const mmq = require('gulp-merge-media-queries');
const gulpStylelint = require('gulp-stylelint');
const postcss = require('gulp-postcss');
const autoprefixer = require('autoprefixer');
const cssdeclsort = require('css-declaration-sorter');
const cleanCSS = require('gulp-clean-css');
const rename = require('gulp-rename');

const resourcesPath = './src/main/webapp/resources';
const cssPath = `${resourcesPath}/css`;
const sassPath = `${resourcesPath}/sass`;
const sassSources = `${sassPath}/**/*.sass`;
const cssSources = [
  `${cssPath}/**/*.css`,
  `!${cssPath}/**/*.min.css`,
  `!${cssPath}/materialize.css`,
  `!${cssPath}/normalize.css`,
];

// sass compile, stylelint
gulp.task('compile', () => (
  gulp
    .src(sassSources)
    .pipe(plumber({ errorHandler: notify.onError('Error: <%= error.message %>') }))
    .pipe(sassGlob())
    .pipe(sass({ outputStyle: 'expanded' }))
    .pipe(postcss([autoprefixer()]))
    .pipe(postcss([cssdeclsort({ order: 'alphabetical' })]))
    .pipe(mmq())
    .pipe(
      gulpStylelint({
        fix: true,
      }),
    )
    .pipe(gulp.dest(cssPath))
));

// minify
gulp.task('minify', () => (
  gulp
    .src(cssSources)
    .pipe(cleanCSS())
    .pipe(rename({
      extname: '.min.css',
    }))
    .pipe(gulp.dest(cssPath))
));

// watch Sass -> compile + minify
gulp.task('watch', () => gulp.watch(sassSources, gulp.series('compile', 'minify')));

// default task
gulp.task('default', gulp.series('compile', 'minify'));
