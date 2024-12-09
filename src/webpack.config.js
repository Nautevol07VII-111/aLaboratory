const path = require('path');
const HtmlWebpackPlugin = require('html-webpack-plugin');

module.exports = {
  entry: './src/index.js', // Path to your main JS entry point
  output: {
    filename: 'bundle.js', // Name of the bundled output file
    path: path.resolve(__dirname, 'dist'), // Output directory (can be changed)
  },
  devtool: 'source-map', // Useful for debugging in development mode
  devServer: {
    contentBase: path.join(__dirname, 'dist'), // Directory for static files (e.g., HTML, CSS)
    compress: true, // Enable Gzip compression for faster loading
    port: 8080, // Port to run the server on
    hot: true, // Enable Hot Module Replacement (HMR)
    open: true, // Automatically open the browser when the server starts
    watchContentBase: true, // Watch for changes to static files (HTML, CSS)
    historyApiFallback: true, // If you're using React Router or similar, fall back to `index.html`
  },
  plugins: [
    new HtmlWebpackPlugin({
        template: './index.html',
    }),
],
  module: {
    rules: [
      {
        test: /\.js$/, // Apply to .js files
        exclude: /node_modules/, // Exclude files in node_modules
        use: 'babel-loader', // Use Babel to transpile JS (if using React, etc.)
      },
      {
        test: /\.css$/, // Apply to .css files
        use: ['style-loader', 'css-loader'], // Use style-loader and css-loader for CSS imports
      },
      // Add more loaders if you're using images, fonts, etc.
    ],
  },
};