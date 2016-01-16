module.exports = function (grunt) {
    grunt.initConfig({
        typescript: {
            base: {
                src: ['app/*.ts'],
                dest: 'build',
                options: {target: 'ES5', module: 'commonjs', sourceMap: true, watch: {after: ['copy'], atBegin: true}, connect: {
                    options: {
                        port: process.env.PORT || 3000,
                        base: 'dist/',
                    },

                    all: {},
                },}
            }
        },
        copy: {
            main: {
                files: [{
                    expand: true,
                    src: 'app/*',
                    dest: 'build/app/',
                    flatten: true,
                    filter: 'isFile'
                }, {expand: true, src: 'index.html', dest: 'build/', flatten: true, filter: 'isFile'}]
            }
        }
    });
    grunt.loadNpmTasks('grunt-typescript');
    grunt.loadNpmTasks('grunt-contrib-copy');
    grunt.registerTask("default", ["typescript"]);
    grunt.registerTask("build", ["typescript"]);
};
