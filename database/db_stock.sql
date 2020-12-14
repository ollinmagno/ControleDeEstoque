

CREATE TABLE tbl_user (
    pk_user_id    INTEGER       PRIMARY KEY AUTOINCREMENT,
    user_name     VARCHAR (100) NOT NULL,
    user_login    VARCHAR (50)  NOT NULL,
    user_password VARCHAR (30)  NOT NULL
);
CREATE TABLE tbl_product (
    pk_product_id  INTEGER       PRIMARY KEY AUTOINCREMENT,
    pro_descricao  VARCHAR (255) NOT NULL,
    pro_quantidade INTEGER,
    pro_valor      DOUBLE        NOT NULL
);
CREATE TABLE tbl_stock (
    pk_stock_id    INTEGER PRIMARY KEY AUTOINCREMENT,
    stock_amount   INTEGER NOT NULL,
    stock_price    DOUBLE  NOT NULL,
    stock_type_mov INTEGER NOT NULL,
    stock_date     DATE    NOT NULL,
    fk_user_id     INTEGER REFERENCES tbl_user (pk_user_id) NOT NULL,
    fk_product_id  INTEGER REFERENCES tbl_product (pk_product_id) NOT NULL
);