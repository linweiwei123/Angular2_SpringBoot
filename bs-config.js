// This is a configuration file for lite-server
var fallbackMiddleware = require('connect-history-api-fallback');

module.exports = {
  server: {
    baseDir:'./dist',
    middleware: {
      1: fallbackMiddleware({
            index: '/webui/index.html', verbose: true
         })
    }
  }
};
