var gulp = require('gulp');
var concat = require('gulp-concat');
var concatVendor = require('gulp-concat-vendor');
var uglify = require('gulp-uglify');
var minify = require('gulp-minify-css')
var mainBowerFiles = require('main-bower-files');
var inject = require('gulp-inject');
var runSequence = require('run-sequence');
var gzip = require('gulp-gzip');
var clone = require('gulp-clone');
var order = require('gulp-order');
var series = require('stream-series');
var flatten = require('gulp-flatten');
var rimraf = require('gulp-rimraf');
var debug = require('gulp-debug');
var uncss = require('gulp-uncss');

var vendorJs;
var vendorCss1, vendorCss2, vendorCss3;


options = {
    html: ['src/main/webapp//**/*.html'],

    ignore: [
        '.show',
        '.hide',
        /\w\.in/,
        '.fade',
        '.collapse',
        '.collapsing',
        /(#|\.)has-error(\-[a-zA-Z]+)?/,
        /(#|\.)navbar(\-[a-zA-Z]+)?/,
        /(#|\.)dropdown(\-[a-zA-Z]+)?/,
        /(#|\.)is(\-[a-zA-Z]+)?/,
        /(#|\.)checkbox(\-[a-zA-Z]+)?/,
        /(#|\.)swagger(\-[a-zA-Z]+)?/,
        /(#|\.)pull(\-[a-zA-Z]+)?/,
        /(#|\.)list(\-[a-zA-Z]+)?/,
        /(#|\.)(open)/,
        /(#|\.)ripple(\-[a-zA-Z]+)?/,
        '.clearfix',
        '.three-dots-row-spinner',
        'rotateplane'],
    report : true
};


//// Watch Files For Changes
//gulp.task('watch', function() {
//    gulp.watch('css/*.css', 'styles');
//    gulp.watch('js/*.js', 'scripts');
//});

gulp.task('clean', function () {
    return gulp.src('src/main/webapp/vendor', {read: false})
        .pipe(rimraf());
});

gulp.task('lib-js-files', function () {
    vendorJs = gulp.src(mainBowerFiles('**/*.js'), {base: 'bower_components'})
        .pipe(debug({title: 'lib-js-files :'}))
        .pipe(concatVendor('lib.min.js'))
        .pipe(gulp.dest('src/main/webapp/vendor/js'));

    vendorJs.pipe(clone())
        .pipe(gzip())
        .pipe(gulp.dest('src/main/webapp/vendor/js'));
});


gulp.task('boot-css-files', function () {
    vendorCss1 = gulp.src('bower_components/bootstrap/dist/css/bootstrap.min.css')

        .pipe(debug({title: 'boot-css-files :'}))
        .pipe(gulp.dest('src/main/webapp/vendor/css'));
});

gulp.task('material-css-files', function () {
    vendorCss2 = gulp.src('bower_components/angular-material/angular-material.min.css')

        .pipe(debug({title: 'material-css-files :'}))
        .pipe(gulp.dest('src/main/webapp/vendor/css'));

});

gulp.task('spinkit-css-files', function () {

    vendorCss3 = gulp.src('bower_components/angular-spinkit/build/angular-spinkit.min.css')

        .pipe(debug({title: 'spinkit-css-files :'}))
        .pipe(gulp.dest('src/main/webapp/vendor/css'));
});


gulp.task('index', function () {
    var target = gulp.src("src/main/webapp/index.html");
    var jsSources = gulp.src(['src/main/webapp//**/*.js'], {read: false})
        .pipe(order(["**/security.js", "**/app.js"]));
    var cssSources = gulp.src(['src/main/webapp//**/*.css'], {read: false});


    return target.pipe(inject(series(vendorJs, vendorCss1, vendorCss2, vendorCss3, jsSources, cssSources), {relative: true}))
        .pipe(gulp.dest('src/main/webapp'));
});


gulp.task('copyFonts', function () {
    gulp.src('bower_components/**/fonts/*.{ttf,woff,woff2,eof,svg}')
        .pipe(flatten())
        .pipe(gulp.dest('src/main/webapp/vendor/fonts'));
});


// Default Task
gulp.task('default', function () {
    runSequence('clean', 'lib-js-files', 'boot-css-files', 'spinkit-css-files','material-css-files','copyFonts', "index");
});