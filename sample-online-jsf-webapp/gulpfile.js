// how to use:
//   npx gulp
//   npx gulp watch
//   npx gulp dev

const gulp = require('gulp');
const gulpif = require('gulp-if');
const sourcemaps = require('gulp-sourcemaps');
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
const eslint = require('gulp-eslint');
const jsdoc = require('gulp-jsdoc3');
const rollup = require('gulp-rollup-stream');
const includepaths = require('rollup-plugin-includepaths');
const babel = require('rollup-plugin-babel');
const stripDebug = require('gulp-strip-debug');
const uglify = require('gulp-uglify');

const resourcesPath = './src/main/webapp/resources';
const cssPath = `${resourcesPath}/css`;
const jsPath = `${resourcesPath}/js`;
const sassSources = `${resourcesPath}/sass/**/*.sass`;
const jsSources = [
  `${jsPath}/**/*.js`,
  `!${jsPath}/**/*.min.js`,
  `!${jsPath}/jquery.js`,
  `!${jsPath}/materialize.js`,
];

// minify setting
let minify = true;

// sass compile(sass->css), stylelint, minify
gulp.task('compile:sass', () => (
  gulp
    .src(sassSources)
    .pipe(plumber({ errorHandler: notify.onError('Error: <%= error.message %>') }))
    .pipe(gulpif(!minify, sourcemaps.init()))
    .pipe(sassGlob())
    .pipe(sass({ outputStyle: 'expanded' }))
    .pipe(postcss([autoprefixer()]))
    .pipe(postcss([cssdeclsort({ order: 'alphabetical' })]))
    .pipe(mmq())
    .pipe(
      gulpStylelint({
        fix: true,
        reporters: [
          { formatter: 'string', console: true },
        ],
      }),
    )
    .pipe(gulpif(minify, cleanCSS()))
    .pipe(gulpif(!minify, sourcemaps.write()))
    .pipe(rename({
      extname: '.min.css',
    }))
    .pipe(gulp.dest(cssPath))
));

// js compile(es2015->es5), eslint, jsdoc, minify
gulp.task('compile:js', () => (
  gulp
    .src(jsSources)
    .pipe(gulpif(!minify, sourcemaps.init()))
    .pipe(eslint({ useEslintrc: true }))
    .pipe(eslint.format())
    .pipe(jsdoc())
    .pipe(rollup({
      plugins: [includepaths({ paths: [jsPath] }),
        babel(),
      ],
    }))
    .pipe(gulpif(minify, stripDebug()))
    .pipe(gulpif(minify, uglify()))
    .pipe(gulpif(!minify, sourcemaps.write()))
    .pipe(rename({
      extname: '.min.js',
    }))
    .pipe(gulp.dest(jsPath))
));

// watch -> compile
gulp.task('watch', () => {
  gulp.watch(sassSources, gulp.series('compile:sass'));
  gulp.watch(jsSources, gulp.series('compile:js'));
});

// for development
gulp.task('no-minify', (done) => {
  minify = false;
  done();
});
gulp.task('dev', gulp.series('no-minify', 'compile:sass', 'compile:js'));

// default task
gulp.task('default', gulp.series('compile:sass', 'compile:js'));
