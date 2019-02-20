-- Database
CREATE DATABASE test;

-- Main web app can read and write
CREATE USER 'server' IDENTIFIED BY 'password';
GRANT ALL PRIVILEGES ON test.* TO 'server';

-- PDF creator module only has read permissions
GRANT SELECT ON test.* TO 'pdfcreator'@'%' IDENTIFIED BY 'pdfcreator-password';
