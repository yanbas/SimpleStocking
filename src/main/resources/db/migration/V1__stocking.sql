CREATE TABLE stocking.materials (
                                    id varchar(36) NOT NULL,
                                    material_name varchar(100) NOT NULL,
                                    qty INT NOT NULL,
                                    status ENUM('Active','NonActive') NULL,
                                    material_aliase varchar(100) NULL,
                                    created_date DATETIME NULL,
                                    CONSTRAINT materials_PK PRIMARY KEY (id)
)
    ENGINE=InnoDB
    DEFAULT CHARSET=utf8
    COLLATE=utf8_general_ci
    COMMENT='table materials';
CREATE INDEX materials_status_IDX USING BTREE ON stocking.materials (status);


CREATE TABLE stocking.movement (
                                   id varchar(36) NOT NULL,
                                   material_id varchar(36) NOT NULL,
                                   transaction_date DATETIME NOT NULL,
                                   status ENUM('in','out') NOT NULL,
                                   qty INT NOT NULL,
                                   pic varchar(100) NULL,
                                   CONSTRAINT movement_PK PRIMARY KEY (id)
)
    ENGINE=InnoDB
    DEFAULT CHARSET=utf8
    COLLATE=utf8_general_ci;


CREATE TABLE stocking.adjustment (
                                     id varchar(36) NOT NULL,
                                     material_id varchar(36) NOT NULL,
                                     movement_id varchar(36) NOT NULL,
                                     adjustment_date DATETIME NOT NULL,
                                     reason TEXT NOT NULL,
                                     qty INT NULL,
                                     pic varchar(100) NULL,
                                     created_date DATETIME NULL,
                                     CONSTRAINT adjustment_PK PRIMARY KEY (id),
                                     CONSTRAINT adjustment_FK FOREIGN KEY (material_id) REFERENCES stocking.materials(id) ON DELETE RESTRICT ON UPDATE RESTRICT
)
    ENGINE=InnoDB
    DEFAULT CHARSET=utf8
    COLLATE=utf8_general_ci
    COMMENT='table adjustment ';
CREATE INDEX adjustment_pic_IDX USING BTREE ON stocking.adjustment (pic);
