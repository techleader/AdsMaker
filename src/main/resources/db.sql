CREATE TABLE headlines (
    hid INT NOT NULL AUTO_INCREMENT,
    headline VARCHAR(100) NOT NULL,
    PRIMARY KEY ( hid ));

 CREATE TABLE subheadlines (
    shid INT NOT NULL AUTO_INCREMENT,
    subheadline VARCHAR(100) NOT NULL,
    PRIMARY KEY ( shid ));

 CREATE TABLE buttons(
    btnid INT NOT NULL AUTO_INCREMENT,
    label VARCHAR(30) NOT NULL,
    PRIMARY KEY (btnid));

 CREATE TABLE saved_ads(
    adsid INT NOT NULL,
    headline VARCHAR(100) NOT NULL,
    subheadline VARCHAR(100) NOT NULL,
    imagesurl VARCHAR(100) NOT NULL,
    button VARCHAR(30) NOT NULL,
    PRIMARY KEY (adsid));

INSERT INTO headlines (headline) VALUES("Nothing but the best");
INSERT INTO headlines (headline) VALUES("Febulous for less");
INSERT INTO headlines (headline) VALUES("Marvlous for less");
INSERT INTO headlines (headline) VALUES("Always less price");
INSERT INTO headlines (headline) VALUES("Great Deal");


INSERT INTO subheadlines (subheadline) VALUES("Rates are changing");
INSERT INTO subheadlines (subheadline) VALUES("Sweet Deals");
INSERT INTO subheadlines (subheadline) VALUES("Free next day delivery");
INSERT INTO subheadlines (subheadline) VALUES("All time 70% Off ");


INSERT INTO buttons (label) VALUES("Buy Now");
INSERT INTO buttons (label) VALUES("Book Now");
INSERT INTO buttons (label) VALUES("Shop Now");



