CREATE
DATABASE BaiTest
GO
USE BaiTest
GO
CREATE TABLE BRANCH
(
    IDBranch   bigint PRIMARY KEY,
    nameBranch nvarchar(100)
)
CREATE TABLE STATUSa
(
    IDStatus   bigint PRIMARY KEY,
    nameStatus nvarchar(100)
)
CREATE TABLE CATEGORY
(
    IDCategory bigint PRIMARY KEY,
    codeCate   varchar(100),
    nameCate   nvarchar(100),
)
CREATE TABLE SubCategory
(
    IDSubCategory bigint PRIMARY KEY,
    codeSubCate   varchar(100),
    nameSubCate   nvarchar(100),
    IDCategory    bigint NOT NULL,
    CONSTRAINT FK_SubCategory_CATEGORY foreign key (IDCategory) references CATEGORY (IDCategory),
)
CREATE TABLE PRODUCT
(
    IDProduct     bigint identity(1,1),
    IDSubCategory bigint NOT NULL,
    CONSTRAINT FK_PRODUCT_SubCATEGORY foreign key (IDSubCategory) references SubCATEGORY (IDSubCategory),
    nameProduct   nvarchar(100),
    color         nvarchar(100),
    quality       bigint,
    sellPrice     money,
    originPrice   money,
    descriptions  nvarchar(100),                                                      -- Sửa lỗi chính tả
    IDStatus      bigint NOT NULL,
    CONSTRAINT FK_PRODUCT_STATUS foreign key (IDStatus) references STATUSa (IDStatus) -- Sửa lỗi chính tả
)
CREATE TABLE PRODUCT_BRANCH
(
    IDProduct bigint,
    IDBranch  bigint,
    PRIMARY KEY (IDProduct, IDBranch)
) 
INSERT INTO BRANCH VALUES
(1,'Mitsubishi'),
(2,'Toyota'),
(3,'Ford')
INSERT INTO STATUSa VALUES
(1,N'Đang kinh doanh'),
(2,N'Ngừng kinh doanh')
INSERT INTO CATEGORY VALUES
(1,'CATE101','Sedan'),
(2,'CATE102','SUV'),
(3,'CATE103','MPV')
INSERT INTO SubCategory VALUES
(1,'SUBCATE101','SedanSub',3),
(2,'SUBCATE102','SUVSub',2),
(3,'SUBCATE103','MPVSub',1)
INSERT INTO PRODUCT VALUES
(3,'Ford Everest',N'Đen',28,50000,950000,N'Xe nhập khẩu',1),
(2,'Toyota Vios',N'Đỏ',29,60000,960000,N'Xe nhập khẩu',1),
(1,'Mitsubishi Xpander',N'Trắng',30,70000,970000,N'Xe lắp ráp',2)
INSERT INTO PRODUCT_BRANCH VALUES
(3,1),
(2,3),
(1,2)

SELECT*FROM PRODUCT
SELECT*FROM SubCategory
SELECT*FROM STATUSa