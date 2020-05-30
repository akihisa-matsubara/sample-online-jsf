// Usage:
//   npx gulp
//   npx gulp --dev (--dev/--develop)
//   npx gulp watch
//   npx gulp watch --dev

const gulp = require('gulp');
// Load all Gulp plugins into one variable
const $ = require('gulp-load-plugins')({
  rename: {
    'gulp-sass-glob': 'sassGlob',
    'gulp-merge-media-queries': 'mmq',
    'gulp-clean-css': 'cleanCSS',
    'gulp-jsdoc3': 'jsdoc',
    'gulp-rollup-stream': 'rollup',
    'gulp-strip-debug': 'stripDebug',
  },
});
const yargs = require('yargs');
const autoprefixer = require('autoprefixer');
const cssdeclsort = require('css-declaration-sorter');
const includepaths = require('rollup-plugin-includepaths');
const babel = require('rollup-plugin-babel');

// Constants
const RESOURCES_PATH = './src/main/webapp/resources';
const CSS_PATH = `${RESOURCES_PATH}/css`;
const JS_PATH = `${RESOURCES_PATH}/js`;
const SASS_SOURCES = `${RESOURCES_PATH}/sass/**/*.sass`;
const JS_SOURCES = [
  `${JS_PATH}/**/*.js`,
  `!${JS_PATH}/**/*.min.js`,
  `!${JS_PATH}/jquery.js`,
  `!${JS_PATH}/materialize.js`,
];
// Check for --develop or --dev flag
const PRODUCTION = !(yargs.argv.develop || yargs.argv.dev);

// sass compile(sass->css), stylelint, minify
gulp.task('compile:sass', () => (
  gulp
    .src(SASS_SOURCES)
    .pipe($.plumber({ errorHandler: $.notify.onError('Error: <%= error.message %>') }))
    .pipe($.if(!PRODUCTION, $.sourcemaps.init()))
    .pipe($.sassGlob())
    .pipe($.sass({ outputStyle: 'expanded' }))
    .pipe($.postcss([autoprefixer()]))
    .pipe($.postcss([cssdeclsort({ order: 'alphabetical' })]))
    .pipe($.mmq())
    .pipe(
      $.stylelint({
        fix: true,
        reporters: [
          { formatter: 'string', console: true },
        ],
      }),
    )
    .pipe($.if(PRODUCTION, $.cleanCSS()))
    .pipe($.if(!PRODUCTION, $.sourcemaps.write()))
    .pipe($.rename({
      extname: '.min.css',
    }))
    .pipe(gulp.dest(CSS_PATH))
));

// js compile(es2015->es5), eslint, jsdoc, minify
gulp.task('compile:js', () => (
  gulp
    .src(JS_SOURCES)
    .pipe($.if(!PRODUCTION, $.sourcemaps.init()))
    .pipe($.eslint({ useEslintrc: true }))
    .pipe($.eslint.format())
    .pipe($.jsdoc())
    .pipe($.rollup({
      plugins: [includepaths({ paths: [JS_PATH] }),
        babel(),
      ],
    }))
    .pipe($.if(PRODUCTION, $.stripDebug()))
    .pipe($.if(PRODUCTION, $.uglify()))
    .pipe($.if(!PRODUCTION, $.sourcemaps.write()))
    .pipe($.rename({
      extname: '.min.js',
    }))
    .pipe(gulp.dest(JS_PATH))
));

// watch -> compile
gulp.task('watch', () => {
  gulp.watch(SASS_SOURCES, gulp.series('compile:sass'));
  gulp.watch(JS_SOURCES, gulp.series('compile:js'));
});

// default task
gulp.task('default', gulp.parallel('compile:sass', 'compile:js'));
