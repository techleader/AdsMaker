CREATE TABLE headlines (
    hid INT NOT NULL AUTO_INCREMENT,
    headline VARCHAR(100) NOT NULL,
    PRIMARY KEY ( hid ))

 CREATE TABLE subheadlines (
    shid INT NOT NULL AUTO_INCREMENT,
    subheadline VARCHAR(100) NOT NULL,
    PRIMARY KEY ( shid ));

 CREATE TABLE buttons(
    btnid INT NOT NULL AUTO_INCREMENT,
    label VARCHAR(30) NOT NULL,
    PRIMARY KEY (btnid));


INSERT INTO headlines (headline) VALUES("Nothing but the best");
INSERT INTO headlines (headline) VALUES("Febulous for less");
INSERT INTO headlines (headline) VALUES("Marvlous for less");
INSERT INTO headlines (headline) VALUES("Always less price");