-- Database
CREATE DATABASE pfwdb;

-- Main web app can read and write
GRANT ALL PRIVILEGES ON pfwdb.* TO 'pfwmain'@'%' IDENTIFIED BY 'pfwmain-password';

-- PDF creator module only has read permissions
GRANT SELECT ON pfwdb.* TO 'pdfcreator'@'%' IDENTIFIED BY 'pdfcreator-password';
