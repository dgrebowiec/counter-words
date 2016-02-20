module.exports = function (grunt) {
    grunt.initConfig({
        typescript: {
            base: {
                src: ['app/*'],
                dest: 'build',
                options: {
                    target: 'ES5', module: 'commonjs', sourceMap: true,
                }
            }
        },
        watch: {

            src: {
                files: ['app/*','Gruntfile.js', 'index.html'],
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
        },
        connect: {
            server: {
                options: {
                    port: 8088
                }
            }
        }
    });
    grunt.loadNpmTasks('grunt-typescript');
    grunt.loadNpmTasks('grunt-contrib-connect');
    grunt.loadNpmTasks('grunt-contrib-copy');
    grunt.loadNpmTasks('grunt-contrib-watch');
    grunt.registerTask("default", ['connect:server','typescript']);
    grunt.registerTask("build", ['connect:server', 'typescript']);
};
