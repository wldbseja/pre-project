// module.exports = {
//   env: { browser: true, es2020: true, commonjs: true },
//   extends: [
//     'eslint:recommended',
//     'plugin:react/recommended',
//     'plugin:react/jsx-runtime',
//     'plugin:react-hooks/recommended',
//   ],
//   parserOptions: { ecmaVersion: 'latest', sourceType: 'module' },
//   settings: { react: { version: '18.2' } },
//   plugins: ['react-refresh'],
//   rules: {
//     'react-refresh/only-export-components': 'warn',
//   },
// }

module.exports = {
  env: { browser: true, es2020: true, commonjs: true },
  extends: [
    'airbnb', 'airbnb/hooks',
  ],
  parserOptions: { ecmaVersion: 'latest', sourceType: 'module' },
  settings: { react: { version: '18.2' } },
  plugins: ['react-refresh'],
  rules: {
    'react-refresh/only-export-components': 'warn',
    'import/prefer-default-export': 'off',
    'import/no-unresolved': ['error', { ignore: ['^react-router-dom$', '^react-icons$'] }],
    'react/prop-types': 'off',
  },
};
